package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelReservations;
/**
 * 
 *Queries for the database reservations table
 *
 */
public class DbReservations {
	/**
	 * Query for getting all reservations and add the information of each reservation into a ModelReservations object,
	 * and then into a List. 
	 * 
	 * @return A List of ModelReservations objects 
	 */
	public static List<ModelReservations> getReservations() {
		String sql = "select * from reservations";
		List<ModelReservations> reservations = new ArrayList<>();
		try (PreparedStatement ps = DatabaseConnect.getInstance()
				.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ModelReservations reservation = new ModelReservations(
						rs.getInt("reservation_id"), rs.getString("koie_name"),
						rs.getDate("startdate"), rs.getDate("enddate"),
						rs.getString("tenant_name"),
						rs.getString("tenant_phone_number"),
						rs.getString("tenant_email"));
				reservations.add(reservation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservations;
	}


}