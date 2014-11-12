package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEquipment;
/**
 * 
 *Queries for the current_invetory2 database table
 *
 */

public class DbEquipmentList {
	/**
	 * Generates a list of ModelEquipment objects that contains the equipment name and status of the equipment on every koie.
	 * 
	 * @return List of ModelEquipment objects.
	 */
	public static List<ModelEquipment> getEquipment() {
        String sql = "select * from current_inventory2 where utstyr <> 'wood' and utstyr <> 'status'  and utstyr <> 'smoke' and utstyr <> 'forgotten' order by utstyr";
        List<ModelEquipment> inventory = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	ModelEquipment equipment = new ModelEquipment(rs.getString("utstyr"), rs.getInt("Flåkoia"), 
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
	
	/**
	 * Checks the equipment status on every equipment on a given koie. Used to check whether all list values are 0. (Means that all equipment on the given koie is okay).
	 * @param koieName Name of the koie you want equipment status on
	 * @return List of integers 
	 */
	
	public static List<Integer> getEquipmentStatus(String koieName) {
        String sql = "select " + koieName + " from current_inventory2 where utstyr <> 'wood' and utstyr <> 'status'  and utstyr <> 'smoke' and utstyr <> 'forgotten' order by utstyr";
        List<Integer> inventory = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	inventory.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }
	
	/**
	 * Updates the equipment status on the given koie. 
	 * 
	 * @param equipment The equipment you want to change status on
	 * @param newStatus The new status you want for that equipment
	 * @param koieName The koie you want to change the equipment status on
	 */
	
	public static void updateEquipment(String equipment, int newStatus, String koieName) {
		String sql;
		if (newStatus == 0){
			sql = "update current_inventory2 set "+koieName+"= 0 where utstyr ='"+equipment+"'";
		}
		else if(newStatus == 1){
			sql = "update current_inventory2 set "+koieName+"= 1 where utstyr ='"+equipment+"'";
		}
		else if (newStatus == 2){
			sql = "update current_inventory2 set "+koieName+"= 2 where utstyr ='"+equipment+"'";
		}
		else{
			sql = "update current_inventory2 set "+koieName+"= 3 where utstyr ='"+equipment+"'";
		}
    	
    	try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
