package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ModelReports;
import javafx.collections.ObservableList;

public class DbReports {

	public static void main(String[] args) {
        System.out.println("main");
        new DbReports().getReports();
	}
	
	   public Map<String, ModelReports> getReports() {
	        String sql = "select * from reports";
	        Map<String, ModelReports> reports = new HashMap();
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	ModelReports report = new ModelReports(rs.getInt("report_id"), rs.getString("koie_name"), rs.getBoolean("status"), 
	            			rs.getDate("startdate"), rs.getDate("enddate"), rs.getBoolean("smoke_detector"), 
	            			rs.getBoolean("wood"), rs.getString("remarks_of_defects"), rs.getBoolean("forgotten"), 
	            			rs.getString("comments"));
	                reports.put(rs.getString("koie_name"), report);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reports;
	    }
}
