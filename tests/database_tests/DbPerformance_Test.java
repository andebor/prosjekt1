package database_tests;

import database.DbKoie;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Performance testing of the database. 
 * These database tests differs a lot. 
 * This test should be run only when you're experiencing low performance on the queries
 * and want to check if it is super slow.
 * 
 * @author Øyvind Bratvedt
 *
 */
public class DbPerformance_Test {
	
	/** Testing the time it takes to get all koie names from the database 1000 times.
	 * 
	*/
	
	@Test
	public void getAllKoieNames(){
		double average = 0;
		int howManyFetches = 1000;
		
			double start = System.nanoTime();
			for (int j = 0; j < howManyFetches; j++){
				DbKoie.getAllKoieNames();
			}
			average += System.nanoTime() - start;
		
		
		System.out.println("Average time for getting all koienames 1000 times: "+ average/1000000000 + "seconds");
		assertTrue("100 times 1000 db queries took more than 1000 seconds",average/1000000000 < 1000);
	}
	
}
