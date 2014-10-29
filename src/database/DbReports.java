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
	            	ModelReports report = new ModelReports(rs.getInt("report_id"), rs.getString("koie_name"), rs.getInt("status"), 
	            			rs.getDate("startdate"), rs.getDate("enddate"), rs.getBoolean("smoke_detector"), 
	            			rs.getInt("wood"), rs.getString("remarks_of_defects"), rs.getBoolean("forgotten"), 
	            			rs.getString("comments"),rs.getTimestamp("timestamp"));
	                reports.add(report);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return reports;
	    }
	   
	   public static ModelReports getReport(String koiename) {
	        String sql = "select * from reports where koie_name = ?";
	        ModelReports report = null;
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	        	ps.setString(1, koiename);
	        	ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	report = new ModelReports(rs.getInt("report_id"), rs.getString("koie_name"), rs.getInt("status"), 
	            			rs.getDate("startdate"), rs.getDate("enddate"), rs.getBoolean("smoke_detector"), 
	            			rs.getInt("wood"), rs.getString("remarks_of_defects"), rs.getBoolean("forgotten"), 
	            			rs.getString("comments"),rs.getTimestamp("timestamp"));    }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return report;
	    }
	   
	   public static boolean checkReport(String koieName, String startDate, String endDate) {
	        String sql = "select * from reports where koie_name = ? and startdate = ? and enddate = ?";
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	        	ps.setString(1, koieName);
	        	ps.setString(2, startDate);
	        	ps.setString(3, endDate);
	        	ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	return true;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	   
	   public static void main(String[] args) {
		 
		   System.out.println(checkReport("mortenskåten", "2014-10-28", "2014-10-29"));
	}

}
