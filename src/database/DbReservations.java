package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ModelReservations;

public class DbReservations {
	public static void main(String[] args) {
		System.out.println("main");
		new DbReservations().getReservations();
	}

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

	private ModelReservations getReservation(String reservation_id) {
		String sql = "select * from reservations where reservation_id = ?";
		ModelReservations reservation = null;
		try (PreparedStatement ps = DatabaseConnect.getInstance()
				.prepareStatement(sql)) {
			ps.setString(1, reservation_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reservation = new ModelReservations(
						rs.getInt("reservation_id"), rs.getString("koie_name"),
						rs.getDate("startdate"), rs.getDate("enddate"),
						rs.getString("tenant_name"),
						rs.getString("tenant_number"),
						rs.getString("tenant_epost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservation;
	}

}