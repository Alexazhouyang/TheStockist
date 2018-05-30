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

import dao.productDAO;
import model.Products;
import model.Reorder;

/**
 * Servlet implementation class reorderCaculateServlet
 */
@WebServlet("/reorderCaculateServlet")
public class reorderCaculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reorderCaculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("productID"));
		int reorderQty = Integer.parseInt(request.getParameter("reorderQty"));
		int orderQty = 0;
		float price =0;
		productDAO productDAO = new productDAO();
		Products products = new Products();
		products = productDAO.selectProductsByID(userId);
		Reorder reorder = new Reorder();
		int test = reorderQty - products.getQty();
		
		String orderDate;
		Date currDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		orderDate = sdf.format(currDate.getTime());
		
		
		if(test > 0)			
		{		
			orderQty = reorderQty-products.getQty();
		
			if(orderQty >= products.getMinOrderQty()) {
				
				price = products.getUnitPrice() * orderQty;
				reorder.setOrderQty(orderQty);
				
			}else {
				orderQty = products.getMinOrderQty();
				reorder.setOrderQty(orderQty);
				price = products.getUnitPrice() * products.getMinOrderQty();
			}
			
		}
		else {
			
			orderQty = 0;
			price = 0;
			reorder.setOrderQty(orderQty);
		}
		
		
		reorder.setMinOrderQty(products.getMinOrderQty());
		
		reorder.setPartNO(products.getPartNO());
		reorder.setQty(products.getQty());
		reorder.setPrice(price);
		reorder.setProductID(userId);
		reorder.setReorderQty(reorderQty);
		reorder.setUnitPrice(products.getUnitPrice());
		reorder.setOrderDate(orderDate);
		
		request.getSession().setAttribute("reorderDetail", reorder);
		request.getRequestDispatcher("reorderDetail.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
