package database_tests;

import static org.junit.Assert.*;

import org.junit.Test;



import java.sql.Connection;

import database.DatabaseConnect;
/**
 * Testing the connection to the database
 * 
 * @author Øyvind Bratvedt
 *
 */
public class DatabaseConnect_Test {
	/**
	 * Testing the class that returns an instance of a database Connection object. Checks if the Connection
	 * instance is null. That means that the connection is not successful and something is wrong. 
	 */
	@Test
	public void testGetDbInstance(){
		Connection c = DatabaseConnect.getInstance();
		assertTrue(c != null);	
	}
	
}
