package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Queries for the admin database table
 *
 */
public class DbAdmin {
	/**
	 * Checks if the parameters is a row in the database admin table. 
	 * @param username The username we want to check with the email column in the database admin table
	 * @param pw The password we want to check with the password column in the database admin table
	 * @return true if the username and pw is in the same row in the database admin table. False if not
	 * 
	 */
	public static boolean checkAdmin(String username, String pw){
		String sql = "select password from admin where admin_email = ?";
		try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String dbPw = rs.getString("password");
				if (dbPw.equals(pw)){
					return true;
				}
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	
		return false;
	}
	
	
}
