package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReorderDAO;
import dao.supplierDAO;
import model.Products;
import model.Reorder;


/**
 * Servlet implementation class reportSearchServlet
 */
@WebServlet("/reportSearchServlet")
public class reportSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportSearchServlet() {
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
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		Reorder reorder = new Reorder();
		int supplierID = 0;
		ReorderDAO reorderDAO =new ReorderDAO();
		supplierDAO supplierDAO = new supplierDAO();
		ArrayList<model.Supplier> sList = supplierDAO.selectSupplier();
		request.setAttribute("sList", sList);
		
try {
			
	supplierID = Integer.parseInt(request.getParameter("supplierID"));
			
			if(request.getParameter("supplierID") != null)
			{
			ArrayList<Reorder> list = reorderDAO.selectProductsByID(supplierID);	
			request.setAttribute("list", list);
			request.setAttribute("supplierID", supplierID);
	        request.getRequestDispatcher("report.jsp").forward(request,response);
			}
			else {
				
		        request.getRequestDispatcher("reportViewServlet").forward(request,
		                response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
