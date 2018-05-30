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
 * Servlet implementation class supplierServlet
 */
@WebServlet("/productViewServlet")
public class productViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productViewServlet() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		productDAO productDAO = new productDAO() ;
		ArrayList<Products> list = productDAO.selectProduct();
        request.setAttribute("list", list);
        supplierDAO supplierDAO = new supplierDAO();
		ArrayList<Supplier> sList = supplierDAO.selectSupplier();
		request.setAttribute("sList", sList);
        request.getRequestDispatcher("product.jsp").forward(request,
                response);
		
		

	}

}
