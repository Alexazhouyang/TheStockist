package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MechDAO;
import dao.TranDAO;
import dao.UserDAO;
import dao.productDAO;
import javafx.scene.control.Tab;
import model.Products;
import model.Transaction;
import model.Users;

/**
 * Servlet implementation class usageIssueServlet
 */
@WebServlet("/usageIssueServlet")
public class usageIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usageIssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("productID"));
		String userName = request.getParameter("userName");
		String customerName = request.getParameter("customerName");
		int usage = Integer.parseInt(request.getParameter("usage"));
		Transaction tran = new Transaction();
		Products products = new Products();
		Users users = new Users();
		UserDAO uDao = new UserDAO();
		TranDAO tDao = new TranDAO();
		productDAO pDao = new productDAO();
		MechDAO mDao = new MechDAO();
		String usageDate;
		Date currDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		usageDate = sdf.format(currDate.getTime());
		
		int qty = pDao.selectProductsByID(productID).getQty();
	
		try {
			tran.setUsage(usage);
			tran.setCustomerName(customerName);
			tran.setDateofUsage(usageDate);
			tran.setProductID(productID);
			int userID = uDao.FindID(userName);
			int mechID = mDao.selectMech(users, userID).getMechID();
			tran.setMechID(mechID);
			
			if(qty >= usage)
			{
			qty = qty - usage;
			products.setQty(qty);
			pDao.updateQty(productID, qty);
			tDao.insertTran(tran);
			}
			
			request.setAttribute("mechID", mechID);
			request.getRequestDispatcher("viewProductServlet").forward(request,response);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
