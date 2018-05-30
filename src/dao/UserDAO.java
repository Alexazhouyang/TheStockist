package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Users;
import util.DBHelper;

public class UserDAO {
	
	
	public void insertUser(Users user) {
		
	DBHelper dbHelper = new DBHelper();
	String sql = "";
	Connection connection = null;
	Statement statement = null;
	
	try {
		
		connection = dbHelper.initDB();
		statement =connection.createStatement();
		sql = "INSERT INTO user ( userName, password, role) VALUES ('"
				+ user.getUsername()
				+ "','"
				+ user.getPassword()
				+ "','"
				+ user.getRole()
				+ "')";
		
		statement.executeUpdate(sql);
        
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	public String  judgeUserPassword(String username) {
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		String password = "";
		
		
		try {
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql="SELECT * FROM user WHERE userName = '"
					+ username + "'";
					rs = statement.executeQuery(sql);
					while (rs.next()) {
						
						password = rs.getString("password");	
						
					
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}
	
public int FindID(String userName) {
		
		DBHelper dbHelper = new DBHelper();
		String sql = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		int userid = 0;

		try {
			
			connection = dbHelper.initDB();
			statement =connection.createStatement();
			sql="SELECT * FROM user WHERE userName = '"
			+ userName + "'";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				userid = rs.getInt("userID");			
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return userid;
	}

public String FindRole(int userid) {
	
	DBHelper dbHelper = new DBHelper();
	String sql = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	String role = "";
	

	try {
		
		connection = dbHelper.initDB();
		statement =connection.createStatement();
		sql="SELECT * FROM user WHERE userID = '"
		+ userid + "'";
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			role = rs.getString("role");			
		}
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	return role;
}
public Users FindLog(Users users ,int userid) {
	
	DBHelper dbHelper = new DBHelper();
	String sql = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	

	try {
		
		connection = dbHelper.initDB();
		statement =connection.createStatement();
		sql="SELECT * FROM user WHERE userID = "
		+ userid ;
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			users.setUsername(rs.getString("userName"));
			users.setPassword(rs.getString("password"));
			users.setRole(rs.getString("role"));
		}
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	return users;
}


}
