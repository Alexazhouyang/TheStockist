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
 * Servlet implementation class productAddServlet
 */
@WebServlet("/productAddServlet")
public class productAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productAddServlet() {
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
		Products products =new Products();
		String  partNO,productName,description,color,dimension,manufacturer,reorderLevel,shelfLocation;
		int qty,damageQty,minOrderQty,supplierID;
		float unitPric;
		productDAO productDAO = new productDAO();
		try {
			partNO =request.getParameter("partNO");
			productName = request.getParameter("productName");
			description = request.getParameter("description");
			color = request.getParameter("color");
			dimension = request.getParameter("dimension");
			manufacturer = request.getParameter("manufacturer");
			reorderLevel = request.getParameter("reorderLevel");
			shelfLocation = request.getParameter("shelfLocation");
			unitPric = Float.parseFloat(request.getParameter("unitPrice"));
			qty = Integer.parseInt(request.getParameter("qty"));
			damageQty = Integer.parseInt(request.getParameter("damageQty"));
			minOrderQty = Integer.parseInt(request.getParameter("minOrderQty"));
			supplierID = Integer.parseInt(request.getParameter("supplierID"));
			products.setPartNO(partNO);
			products.setProductName(productName);
			products.setDescription(description);
			products.setColor(color);
			products.setDimension(dimension);
			products.setManufacturer(manufacturer);
			products.setReorderLevel(reorderLevel);
			products.setShelfLocation(shelfLocation);
			products.setUnitPrice(unitPric);
			products.setDamageQty(damageQty);
			products.setMinOrderQty(minOrderQty);
			products.setQty(qty);
			products.setSupplierID(supplierID);			
			productDAO.insertProduct(products);
			supplierDAO supplierDAO = new supplierDAO();
			ArrayList<Supplier> sList = supplierDAO.selectSupplier();
			request.setAttribute("sList", sList);
			ArrayList<Products> list = productDAO.selectProduct();
	        request.setAttribute("list", list);			
	        request.getRequestDispatcher("product.jsp").forward(request,
	                response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
