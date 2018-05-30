package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.supplierDAO;
import model.Supplier;

/**
 * Servlet implementation class supplierAddServlet
 */
@WebServlet("/supplierAddServlet")
public class supplierAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		Supplier supplier = new Supplier();
		String supplierName,contactNumber,email;
		supplierDAO supplierDAO = new supplierDAO();
		try {
			
			supplierName=request.getParameter("supplierName");
			contactNumber=request.getParameter("contactNumber");
			email=request.getParameter("email");
			if((supplierName!= null)&&(contactNumber != null))
			{
			supplier.setSupplierName(supplierName);
			supplier.setContactNumber(contactNumber);
			supplier.setEmail(email);
			
			supplierDAO.insertSupplier(supplier);
			}
			else {
				
			}
			ArrayList<Supplier> list = supplierDAO.selectSupplier();
	        request.setAttribute("list", list);			
	        request.getRequestDispatcher("supplier.jsp").forward(request,
	                response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
