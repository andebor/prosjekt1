package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelKoie;
import model.ModelReports;

public class DbKoie {

	public static ModelKoie getKoie(String koieName) {
		String sql = "select * from koie where koie_name = ?";
		ModelKoie koie = null;
		try (PreparedStatement ps = DatabaseConnect.getInstance()
				.prepareStatement(sql)) {
			ps.setString(1, koieName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				koie = new ModelKoie(rs.getString("koie_name"),
						rs.getInt("number_of_beds"),
						rs.getString("description"), rs.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql2 = "select "+koieName+" from current_inventory2 where utstyr in ('wood','status','smoke')";
		try (PreparedStatement ps = DatabaseConnect.getInstance()
				.prepareStatement(sql2)) {
			ResultSet rs = ps.executeQuery();
			int counter = 0;
			while (rs.next()) {
					if(counter == 0){
						koie.setSmoke(rs.getInt(1));
						
					}
					else if(counter == 1){
						koie.setStatus(rs.getInt(1));
					}	
					else{
						koie.setWood(rs.getInt(1));
					}
					counter++;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return koie;
	}

	public static List<String> getAllKoieNames() {
		String sql = "select koie_name from koie";
		List<String> koier = new ArrayList<>();
		try (PreparedStatement ps = DatabaseConnect.getInstance()
				.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				koier.add(rs.getString("koie_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return koier;
	}

	public static List<ModelKoie> getAllKoieStatus() {
		List<ModelKoie> koieStatusList = new ArrayList<ModelKoie>();
		ModelKoie koieStatus = null;
		List<String> koier = getAllKoieNames();
		int counter = 0;
		for (String koieName : koier) {
			String sql = "select "+koieName+" from current_inventory2 where utstyr in ('wood','status','smoke')";
			try (PreparedStatement ps = DatabaseConnect.getInstance()
					.prepareStatement(sql)) {
				ResultSet rs = ps.executeQuery();
				koieStatus = new ModelKoie(koieName);
				while (rs.next()) {
						if(counter == 0){
							koieStatus.setSmoke(rs.getInt(1));
							
						}
						else if (counter == 1){
							koieStatus.setStatus(rs.getInt(1));
						}
						else{
							koieStatus.setWood(rs.getInt(1));
						}
						counter++;
						
						
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			koieStatusList.add(koieStatus);
			counter = 0;
		}
		return koieStatusList;
	}
	
}
