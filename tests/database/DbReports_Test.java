package database;

import static org.junit.Assert.assertEquals;
import model.ModelReports;

import org.junit.Test;

public class DbReports_Test {
	DbReports dbReport = new DbReports();
	
	//Note: Might not be useful before we have sufficient data in the db
	
	@Test
	public void testGetReservationWhenIdExists(){
		ModelReports report = dbReport.getReport(18);
		int expected = 18;
		int actual = report.getReportId();
		assertEquals(expected,actual);
	}
	
	
}
