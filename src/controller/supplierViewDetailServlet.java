package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.supplierDAO;
import model.Supplier;

/**
 * Servlet implementation class supplierViewDetailServlet
 */
@WebServlet("/supplierViewDetailServlet")
public class supplierViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierViewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int supplierID = Integer.parseInt(request.getParameter("supplierID"));
		supplierDAO supplierDAO = new supplierDAO();
		Supplier supplier = new Supplier();
		
		supplier = supplierDAO.selectSupplierByID(supplierID);		
		request.getSession().setAttribute("supplier", supplier);
		request.getRequestDispatcher("supplierDetail.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
