package database_tests;

import database.DbKoie;
import static org.junit.Assert.*;
import org.junit.Test;

public class DbPerformance_Test {
	/*These database tests differs a lot. This test should be run only when you're experiencing low performance on the queries
	and want to check if it is super slow*/
	
	@Test
	public void getAllKoieNames(){
		double start = System.nanoTime();
		for (int i = 0; i < 1000; i++){
			
			DbKoie.getAllKoieNames();
			
		}
		double estimated = System.nanoTime() - start;
		System.out.println("Estimated time on getting all koienames 1000 times: "+ estimated/1000000000 + "seconds");
		assertTrue("1000 db queries took more than 100 seconds",estimated/1000000000 < 100);
	}
	
}
