package database;

import static org.junit.Assert.assertEquals;
import model.ModelKoie;

import org.junit.Test;

import database.DbKoie;


public class DbKoie_Test {
	
	

	@Test
	public void testGetKoieNameWhenKoieNameIsRight(){
		DbKoie dbKoie = new DbKoie();
		ModelKoie koie = dbKoie.getKoie("Flåkoia");
		String expected = "Flåkoia";
		String actual = koie.getKoieName();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetNumberOfBedsWhenKoieNameIsRight(){
		DbKoie dbKoie = new DbKoie();
		ModelKoie koie = dbKoie.getKoie("Flåkoia");
		int expected = 11;
		int actual = koie.getNumberOfBeds();
		assertEquals(expected,actual);
	}
	
	//Not necessary
	@Test
	public void testGetDescriptionWhenKoieNameIsRight(){
		DbKoie dbKoie = new DbKoie();
		ModelKoie koie = dbKoie.getKoie("Flåkoia");
		String expected = "Flåkoia er bygd i 1968.";//LOLOL
		String actual = koie.getDescription();
		assertEquals(expected,actual);
		
	}
	
	
	
}
