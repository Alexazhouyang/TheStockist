package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Users;
import util.DBHelper;

public class FindIdDAO {
public int FindID(Users user) {
		
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
			+ user.getUsername() + "'";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				user = new Users();
				userid = rs.getInt("userID");			
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return userid;
	}

}
