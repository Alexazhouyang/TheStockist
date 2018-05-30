package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReorderDAO;
import dao.productDAO;
import dao.supplierDAO;
import model.Products;
import model.Reorder;
import model.Supplier;

/**
 * Servlet implementation class reportViewServlet
 */
@WebServlet("/reportViewServlet")
public class reportViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportViewServlet() {
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReorderDAO reorderDAO = new ReorderDAO();
		
		ArrayList<Reorder> list = reorderDAO.selectReorder();
		supplierDAO supplierDAO = new supplierDAO();
		ArrayList<Supplier> sList = supplierDAO.selectSupplier();
		request.setAttribute("sList", sList);
        request.setAttribute("list", list);
        
        request.getRequestDispatcher("report.jsp").forward(request,
                response);
		
	}

}
