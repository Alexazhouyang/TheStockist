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
 * Servlet implementation class supplierSearchServlet
 */
@WebServlet("/supplierSearchServlet")
public class supplierSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supplierSearchServlet() {
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
		Supplier supplier = new Supplier();
		String supplierName = null;
		supplierDAO supplierDAO = new supplierDAO();
		
		
		try {
			
			supplierName = request.getParameter("supplierName");
			
			if(request.getParameter("supplierName") != null)
			{
			ArrayList<Supplier> list = supplierDAO.selectSupplierByName(supplierName);		
			request.setAttribute("list", list);
	        request.getRequestDispatcher("supplier.jsp").forward(request,
	                response);
			}
			else {
				
		        request.getRequestDispatcher("supplier.jsp").forward(request,
		                response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
