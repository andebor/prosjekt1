package database;
/*package db;

import java.sql.ResultSet;

public class DbKoie {
	
	public static void main(String[] args) {
        System.out.println("main");
        new dbKoie().getKoie();

    }

    public DbKoie() {
    }

    private Koie getKoie(String koiename, int numberOfBeds, String description, Image image) {
        String sql = "select * from koie where koie_name = ?";
        Koie koie = null;
        try (PreparedStatement ps = DbConnection.getInstance().prepareStatement(sql)) {
        	ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                koie = new Koie(rs.getString("koie_name"), rs.getInt(numberOfBeds), rs.getString("description"), );
                if (withPassword) employee.setPassword(rs.getString("passord"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return koie;
    }
    
}
*/