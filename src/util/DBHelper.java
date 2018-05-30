package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
//	private static final String driver = "com.mysql.jdbc.Driver";
//	private static final String url= "jdbc:mysql://localhost:3306/Team11_Stockist?useUnicode=true&characterEncoding=UTF";
//	private static final String username ="root";
//	private static final String password ="410428";
//	
//	private static Connection connection = null;
	
	public Connection initDB() throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/Team11_Stockist?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "410428");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	
	}
	
	public void closeDB(Statement sta, Connection conn) {
		try {
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDB(ResultSet rs, Statement sta, Connection conn) {
	
		try {
			rs.close();
		sta.close();
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	
}
