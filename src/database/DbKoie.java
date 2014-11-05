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
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
        	ps.setString(1, koieName);
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                koie = new ModelKoie(rs.getString("koie_name"), rs.getInt("number_of_beds"), rs.getString("description"),rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koie;
    }
    
    public static List<String> getAllKoieNames() {
        String sql = "select koie_name from koie";
        List<String> koier = new ArrayList<>();
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
                koier.add(rs.getString("koie_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koier;
    }
    
}
