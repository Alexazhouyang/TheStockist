package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReorderDAO;
import model.Reorder;

/**
 * Servlet implementation class reorderSubmitServlet
 */
@WebServlet("/reorderSubmitServlet")
public class reorderSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reorderSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		Reorder reorder = new Reorder();
		int productID,minOrderQty,qty,reorderQty,orderQty,supplierID;
		String partNO;
		float unitPrice,price;
		String orderDate;
		Date currDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		orderDate = sdf.format(currDate.getTime());
		
		try {
		reorder.setProductID(Integer.parseInt(request.getParameter("productID")));
		reorder.setMinOrderQty(Integer.parseInt(request.getParameter("minOrderQty")));
		reorder.setQty(Integer.parseInt(request.getParameter("qty")));
		reorder.setReorderQty(Integer.parseInt(request.getParameter("reorderQty")));
		reorder.setOrderQty(Integer.parseInt(request.getParameter("orderQty")));
		reorder.setSupplierID(Integer.parseInt(request.getParameter("supplierID")));
		
		reorder.setPartNO(request.getParameter("partNO"));
		
		reorder.setOrderDate(orderDate);
		reorder.setUnitPrice(Float.parseFloat(request.getParameter("unitPrice")));
		reorder.setPrice(Float.parseFloat(request.getParameter("price")));
		
		ReorderDAO reorderDAO = new ReorderDAO();
		reorderDAO.insertReorder(reorder);
		request.getRequestDispatcher("reorderViewServlet").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
