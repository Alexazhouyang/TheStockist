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
@WebServlet("/supplierUpdateServlet")
public class supplierUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierUpdateServlet() {
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
		int supplierID = Integer.parseInt(request.getParameter("supplierID"));
		supplierDAO supplierDAO = new supplierDAO();
		Supplier supplier = new Supplier();
		supplier.setSupplierName(request.getParameter("supplierName"));
		supplier.setEmail(request.getParameter("email"));
		supplier.setContactNumber(request.getParameter("contactNumber"));
		
		supplierDAO.updateSupplier(supplier, supplierID);
		supplier.setSupplierID(supplierID);
		
		supplier = supplierDAO.selectSupplierByID(supplierID);		
		request.getSession().setAttribute("supplier", supplier);
		request.getRequestDispatcher("supplierDetail.jsp").forward(request,response);
	}

}
