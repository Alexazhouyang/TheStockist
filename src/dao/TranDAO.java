package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import model.Reorder;
import model.Transaction;
import util.DBHelper;

public class TranDAO {
	
public void insertTran(Transaction user) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql = "INSERT INTO transaction ( `productID`, `mechID`, `customerName`, `usage`, `dateofUsage`) VALUES ('"
			+ user.getProductID() +"','"
			+ user.getMechID()+"', '"
			+ user.getCustomerName()+"', '"
			+ user.getUsage()+"','"
			+ user.getDateofUsage()+"')";
			
			
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
	public ArrayList<Transaction> selectTran() {
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;	
		Transaction tran = new Transaction();
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		try {
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql="SELECT * FROM transaction ";
					rs = statement.executeQuery(sql);
					while (rs.next()) {	
						tran = new Transaction();
						tran.setCustomerName(rs.getString("customerName"));
						tran.setDateofUsage(rs.getString("dateofUsage"));
						tran.setMechID(rs.getInt("mechID"));
						tran.setProductID(rs.getInt("productID"));
						tran.setTransactionID(rs.getInt("transactionID"));
						tran.setUsage(rs.getInt("usage"));
						
						list.add(tran);					
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
