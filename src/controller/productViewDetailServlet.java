package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productDAO;
import dao.supplierDAO;
import model.Products;
import model.Supplier;

/**
 * Servlet implementation class productViewDetailServlet
 */
@WebServlet("/productViewDetailServlet")
public class productViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productViewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("productID"));
		productDAO productDAO = new productDAO();
		Products products = new Products();
		supplierDAO supplierDAO = new supplierDAO();
		ArrayList<Supplier> sList = supplierDAO.selectSupplier();
		request.setAttribute("sList", sList);
		products = productDAO.selectProductsByID(userId);
		products.setProductID(userId);
		request.getSession().setAttribute("products", products);
		request.getRequestDispatcher("productDetail.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
