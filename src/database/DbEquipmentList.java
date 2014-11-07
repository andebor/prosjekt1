package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEquipment;
import model.ModelEquipmentLists;
import model.ModelReports;

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
	
	public static List<ModelEquipmentLists> getEquipment2() {
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

			
			
	
	public static List<ModelEquipment> getEquipment() {
        String sql = "select * from current_inventory2 where utstyr <> 'wood' and utstyr <> 'status'  and utstyr <> 'smoke' order by utstyr";
        List<ModelEquipment> inventory = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ModelEquipment equipment = new ModelEquipment(rs.getInt("id"), rs.getString("utstyr"), rs.getInt("Flåkoia"), 
            			rs.getInt("Fosenkoia"), rs.getInt("Heinfjordstua"), rs.getInt("Hognabu"), rs.getInt("Holmsåkoia"), 
            			rs.getInt("Holvassgamma"), rs.getInt("Iglbu"), rs.getInt("Kamtjønnkoia"), rs.getInt("Kråklikåten"), 
            			rs.getInt("Kvernmovollen"), rs.getInt("Kåsen"), rs.getInt("Lynhøgen"), rs.getInt("Mortenskåten"), 
            			rs.getInt("Nicokoia"), rs.getInt("Rindalsløa"), rs.getInt("Selbukåten"), rs.getInt("Sonvasskoia"), 
            			rs.getInt("Stabburet"), rs.getInt("Stakkslettbua"), rs.getInt("Telin"), rs.getInt("Taagaabu"), 
            			rs.getInt("Vekvessætra"), rs.getInt("Øvensenget"));
            	inventory.add(equipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }
	
	public static void updateEquipment(String equipment, int newStatus, String koieName) {
		String sql;
		if (newStatus == 0){
			sql = "update current_inventory2 set "+koieName+"= 0 where utstyr ='"+equipment+"'";
		}
		else{
			sql = "update current_inventory2 set "+koieName+"= 1 where utstyr ='"+equipment+"'";
		}
    	
    	try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		getEquipment();
	}

}
