package database_tests;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import model.ModelKoie;
import database.DbKoie;
/**
 * Testing the static values retrieved from the database table "koie" in the class database.DbKoie.
 * @author �yvind Bratvedt
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
		koier.put("Fl�koia", 11);
		koier.put("Fosenkoia", 10);
		koier.put("Heinfjordstua", 25);
		koier.put("Hognabu", 6);
		koier.put("Holms�koia", 20);
		koier.put("Holvassgamma", 8);
		koier.put("Iglbu", 8);
		koier.put("Kamtj�nnkoia", 6);
		koier.put("Kr�klik�ten", 4);
		koier.put("Kvernmovollen", 8);
		koier.put("K�sen", 8);
		koier.put("Lynh�gen", 4);
		koier.put("Mortensk�ten", 2);
		koier.put("Nicokoia", 8);
		koier.put("Rindalsl�a", 4);
		koier.put("Selbuk�ten", 2);
		koier.put("Sonvasskoia", 8);
		koier.put("Stabburet", 2);
		koier.put("Stakkslettbua", 11);
		koier.put("Telin", 9);
		koier.put("Taagaabu", 6);
		koier.put("Vekvess�tra",20);
		koier.put("�vensenget", 8);
	
	
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
