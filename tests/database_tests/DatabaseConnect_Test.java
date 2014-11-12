package database_tests;

import static org.junit.Assert.*;

import org.junit.Test;



import java.sql.Connection;

import database.DatabaseConnect;

public class DatabaseConnect_Test {
	
	@Test
	public void testGetDbInstance(){
		Connection c = DatabaseConnect.getInstance();
		assertTrue(c != null);	
	}
	
}
