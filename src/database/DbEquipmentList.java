package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEquipmentLists;

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
	

	public static ModelEquipmentLists getEquipmentList(String koieName) {
        String sql = "select * from current_inventory where koie = ?";
        ModelEquipmentLists equipment = null;
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
        	ps.setString(1, koieName);
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	equipment = new ModelEquipmentLists(rs.getString("koie"), rs.getInt("wood"), rs.getInt("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipment;
    }
	
	public static List<ModelEquipmentLists> getEquipment() {
        String sql = "show columns from current_inventory";
        List<ModelEquipmentLists> equipments = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	rs.getString("Field");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipments;
    }
	public static void main(String[] args) {
		getEquipment();
	}

}
