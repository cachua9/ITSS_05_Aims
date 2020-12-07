package aims.engine.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class User {
	private String username;
	private String password;
	private int type;
	
	public User() {
		
	}
	public User(String user, String pass, int type) {
		this.username = user;
		this.password = pass;
		this.type = type;
	}
	
	public boolean checkLoginInfo(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
	
	public static ArrayList<User> getData(){
		ArrayList<User> result = new ArrayList<User>();
		Connection conn = DBConnection.getConn();
		String sql = "select * from User";
		try {
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				User u = new User(rs.getString("user"), rs.getString("pass"), rs.getInt("type"));
				result.add(u);
			}
		}
		catch (SQLException e) {
			
		}	
		return result;
	}
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAdmin() {
		this.type = 1;
	}
	public boolean isAdmin() {
		return this.type == 1;
	}
}
