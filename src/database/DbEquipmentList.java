package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelEquipmentList;

public class DbEquipmentList {
	
	private ModelEquipmentList getEquipmentList(String koieName) {
        String sql = "select * from equipment_list where koie_name = ?";
        ModelEquipmentList koie = null;
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
        	ps.setString(1, koieName);
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                koie = new ModelEquipmentList(rs.getInt("equipment_id"), rs.getString("equipment_name"), rs.getString("koie_name"), rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koie;
    }

}
