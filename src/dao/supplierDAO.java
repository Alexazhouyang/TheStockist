package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Supplier;
import util.DBHelper;

public class supplierDAO {
	
	/**
	 * update supplier information
	 */
	
	public void updateSupplier(Supplier user,int supplierID) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "UPDATE supplier SET supplierName= '"
			+ user.getSupplierName()
			+"',contactNumber='"
			+ user.getContactNumber()
			+"',email='"
			+ user.getEmail()+"' WHERE supplierID="+ supplierID;
			
			statement.executeUpdate(sql);				
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		}
	
	/**
	 * insert supplier information
	 */
	
	public void insertSupplier(Supplier user) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "INSERT INTO supplier ( supplierName, contactNumber, email) VALUES ('"
					+ user.getSupplierName()
					+ "','"
					+ user.getContactNumber()
					+ "','"
					+ user.getEmail()
					+ "')";
			
			statement.executeUpdate(sql);				
			} catch (SQLException e) {
			e.printStackTrace();
			}	
		}
	
	
	/**
	 * select supplier information
	 * @param userid
	 
	 * @return
	 */
		public ArrayList<Supplier> selectSupplier() {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Supplier supplier =new Supplier();
			ArrayList<Supplier> list = new ArrayList<Supplier>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM supplier ";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							supplier = new Supplier();
							supplier.setSupplierID(rs.getInt("supplierID"));
							supplier.setSupplierName(rs.getString("supplierName"));
							supplier.setContactNumber(rs.getString("contactNumber"));
							supplier.setEmail(rs.getString("email"));
							list.add(supplier);					
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
			public Supplier selectSupplierByID(int supplierID) {
				DBHelper dbHelper = new DBHelper();
				String sql = "";
				Connection connection = null;
				Statement statement = null;
				ResultSet rs = null;	
				Supplier supplier =new Supplier();
				
				try {
					connection = dbHelper.initDB();
					statement =connection.createStatement();
					sql="SELECT * FROM supplier WHERE supplierID ="+ supplierID;
							rs = statement.executeQuery(sql);
							while (rs.next()) {	
								supplier = new Supplier();
								supplier.setSupplierID(supplierID);
								supplier.setSupplierName(rs.getString("supplierName"));
								supplier.setContactNumber(rs.getString("contactNumber"));
								supplier.setEmail(rs.getString("email"));
											
							}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return supplier;
			}
			
			
		public ArrayList<Supplier> selectSupplierByName(String supplierName) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;	
			Supplier supplier =new Supplier();
			ArrayList<Supplier> list = new ArrayList<Supplier>();
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="SELECT * FROM supplier WHERE supplierName LIKE '%"+ supplierName + "%'";
						rs = statement.executeQuery(sql);
						while (rs.next()) {	
							supplier = new Supplier();
							supplier.setSupplierID(rs.getInt("supplierID"));
							supplier.setSupplierName(rs.getString("supplierName"));
							supplier.setContactNumber(rs.getString("contactNumber"));
							supplier.setEmail(rs.getString("email"));
							list.add(supplier);					
						}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		public void deleteoneSupplier(int supplierID) {
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				sql="DELETE FROM supplier WHERE supplierID = "+ supplierID;
				statement.executeUpdate(sql);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		public void deleteSupplierList(String[] supplierID) {
			//delete All checked
			DBHelper dbHelper = new DBHelper();
			String sql = "";
			Connection connection = null;
			Statement statement = null;
			try {
				connection = dbHelper.initDB();
				statement =connection.createStatement();
				int id = 0;
				for (int i = 0; i < supplierID.length; i++) {
				
				id = Integer.parseInt(supplierID[i]);
				sql="DELETE FROM supplier WHERE supplierID = "+ supplierID;
				statement.executeUpdate(sql);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	
	
	

}
