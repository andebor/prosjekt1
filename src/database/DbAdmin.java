package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbAdmin {

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
