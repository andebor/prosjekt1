package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import model.ModelReports;


public class DbReports {

	   public static List<ModelReports> getReports() {
	        String sql = "select * from reports";
	        List<ModelReports> reports = new ArrayList<>();
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	ModelReports report = new ModelReports(rs.getInt("report_id"), rs.getString("koie_name"), rs.getBoolean("status"), 
	            			rs.getDate("startdate"), rs.getDate("enddate"), rs.getBoolean("smoke_detector"), 
	            			rs.getBoolean("wood"), rs.getString("remarks_of_defects"), rs.getBoolean("forgotten"), 
	            			rs.getString("comments"),rs.getTimestamp("timestamp"));
	                reports.add(report);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reports;
	    }
	   
	   public ModelReports getReport(int report_id) {
		  
	        String sql = "select * from reports where report_id = ?";
	        ModelReports report = null;
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	        	ps.setInt(1, report_id);
	        	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	report = new ModelReports(rs.getInt("report_id"), rs.getString("koie_name"), rs.getBoolean("status"), 
	            			rs.getDate("startdate"), rs.getDate("enddate"), rs.getBoolean("smoke_detector"), 
	            			rs.getBoolean("wood"), rs.getString("remarks_of_defects"), rs.getBoolean("forgotten"), 
	            			rs.getString("comments"),rs.getTimestamp("timestamp"));    }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return report;
	    }
}
