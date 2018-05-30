package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.Reorder;
import util.DBHelper;

public class ReorderDAO {
	
	/**
	 * select supplier information by partNO
	 * @param userid
	 
	 * @return
	 */
		public ArrayList<Reorder> selectProductsByID(int supplierID) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Reorder reorder = new Reorder();
			ArrayList<Reorder> list = new ArrayList<Reorder>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM reorder WHERE supplierID LIKE "+ supplierID + "";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							reorder = new Reorder();
							reorder.setPartNO(rs.getString("partNO"));
							reorder.setProductID(rs.getInt("productID"));
							reorder.setOrderDate(rs.getString("orderDate"));
							reorder.setUnitPrice(rs.getFloat("unitPrice"));
							reorder.setSupplierID(rs.getInt("supplierID"));
							reorder.setOrderQty(rs.getInt("orderQty"));
							reorder.setPrice(rs.getFloat("price"));
							reorder.setReorderQty(rs.getInt("reorderQty"));
							reorder.setMinOrderQty(rs.getInt("minOrderQty"));							
							reorder.setQty(rs.getInt("qty"));
							list.add(reorder);					
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	/**
	 * select supplier information
	 * @param userid
	 
	 * @return
	 */
		public ArrayList<Reorder> selectReorder() {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Reorder reorder = new Reorder();
			ArrayList<Reorder> list = new ArrayList<Reorder>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM reorder ";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							reorder = new Reorder();
							reorder.setPartNO(rs.getString("partNO"));
							reorder.setProductID(rs.getInt("productID"));
							reorder.setOrderDate(rs.getString("orderDate"));
							reorder.setUnitPrice(rs.getFloat("unitPrice"));
							reorder.setSupplierID(rs.getInt("supplierID"));
							reorder.setOrderQty(rs.getInt("orderQty"));
							reorder.setPrice(rs.getFloat("price"));
							reorder.setReorderQty(rs.getInt("reorderQty"));
							reorder.setMinOrderQty(rs.getInt("minOrderQty"));							
							reorder.setQty(rs.getInt("qty"));
	
							list.add(reorder);					
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
public void insertReorder(Reorder user) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "INSERT INTO reorder (productID, supplierID, unitPrice, "
					+ "minOrderQty, reorderQty, orderQty, price, orderDate, partNO,qty) VALUES ("
					+ user.getProductID()
					+","
					+ user.getSupplierID()
					+","
					+ user.getUnitPrice()
					+","
					+ user.getMinOrderQty()
					+","
					+ user.getReorderQty()
					+","
					+ user.getOrderQty()
					+","
					+ user.getPrice()
					+",'"
					+ user.getOrderDate()
					+"','"															
					+ user.getPartNO()
					+"',"
					+ user.getQty()
					+ ")";
			
			statement.executeUpdate(sql);				
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		}





}
