package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;

import model.ModelReports;
/**
 * 
 * Queries for the reports table in the database
 *
 */

public class DbReports {
		
		/**
		 * Query that retrieves all reports and generates a 
		 * list of ModelReports objects that each contain information about one report
		 * @return List of ModelReports objects
		 */
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
	   /**
	    * Query for getting one report on a given koie. Used to check if a koie atleast has one report
	    * @param koiename name of the koie you want to get report from
	    * @return ModelReports object with info about the report
	    */
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
	   
	   /**
	    * Query to check if there is a report in the database with the given parameters
	    * @param koieName name of the koie
	    * @param startDate start date of the koie stay
	    * @param endDate end date of the koie stay
	    * @return true if there is a report from that time period on that koie name. False if not. 
	    */
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
	   /**
	    * Query for getting all reports on a given koie
	    * @param koieName Name of the koie you want to get all reports from
	    * @return A list of ModelReports objects
	    */
	   public static List<ModelReports> getReports(String koieName) {
	        String sql = "select * from reports where koie_name = ?";
	        List<ModelReports> reports = new ArrayList<>();
	        try (PreparedStatement ps = DatabaseConnect.getInstance().prepareStatement(sql)) {
	        	ps.setString(1, koieName);
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
}
