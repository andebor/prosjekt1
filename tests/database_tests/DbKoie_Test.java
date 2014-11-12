package database_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import model.ModelKoie;
import database.DbKoie;
/**
 * Testing the static values retrieved from the database table "koie" in the class database.DbKoie.
 * @author Øyvind Bratvedt
 *
 */

public class DbKoie_Test {
	/**
	 * Checks that the the getKoie(koieName) function gets the correct values from the database. 
	 * The test makes a HashMap with the correct koie names and corresponding number of beds. 
	 * Then it iterates through the map and checks if DbKoie.getKoie(koieName) returns the right object 
	 * by checking name and number of beds.
	 * 
	 * 
	 */
	@Test
	public void testGetKoieNameWhenKoieNameIsRight(){
		HashMap<String,Integer> koier = new HashMap<String,Integer>();
		koier.put("Flåkoia", 11);
		koier.put("Fosenkoia", 10);
		koier.put("Heinfjordstua", 25);
		koier.put("Hognabu", 6);
		koier.put("Holmsåkoia", 20);
		koier.put("Holvassgamma", 8);
		koier.put("Iglbu", 8);
		koier.put("Kamtjønnkoia", 6);
		koier.put("Kråklikåten", 4);
		koier.put("Kvernmovollen", 8);
		koier.put("Kåsen", 8);
		koier.put("Lynhøgen", 4);
		koier.put("Mortenskåten", 2);
		koier.put("Nicokoia", 8);
		koier.put("Rindalsløa", 4);
		koier.put("Selbukåten", 2);
		koier.put("Sonvasskoia", 8);
		koier.put("Stabburet", 2);
		koier.put("Stakkslettbua", 11);
		koier.put("Telin", 9);
		koier.put("Taagaabu", 6);
		koier.put("Vekvessætra",20);
		koier.put("Øvensenget", 8);
	
	
		for(String koie : koier.keySet()){
			ModelKoie koien = DbKoie.getKoie(koie);
			String expectedName = koie;
			String actualName = koien.getKoieName();
			assertEquals("Expected koie name does not match the actual database koiename.",expectedName,actualName);
			int expectedNoOfBeds = koier.get(koie);
			int actualNoOfBeds = koien.getNumberOfBeds();
			assertTrue("Expected no. of beds does not match the actual no. of beds. Koie name: "+koie ,expectedNoOfBeds == actualNoOfBeds);
			
		}
		
	}
	
	
}
