package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelKoie;
import model.ModelReports;

public class DbKoie {

    private ModelKoie getKoie(String koieName) {
        String sql = "select * from koie where koie_name = ?";
        ModelKoie koie = null;
        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
        	ps.setString(1, koieName);
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                koie = new ModelKoie(rs.getString("koie_name"), rs.getInt("number_of_beds"), rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koie;
    }
    
}
