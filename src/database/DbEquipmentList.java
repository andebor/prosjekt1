package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEquipmentList;
import model.ModelEquipmentLists;
import model.ModelReservations;

public class DbEquipmentList {
	
	public static List<ModelEquipmentLists> getEquipmentLists() {
        String sql = "select * from current_inventory";
        List<ModelEquipmentLists> equipments = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ModelEquipmentLists equipment = new ModelEquipmentLists(rs.getString("koie"), rs.getInt("wood"), rs.getInt("status"));
            	equipments.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipments;
    }
	
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
