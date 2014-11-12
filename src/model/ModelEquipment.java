package model;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * Class for storing data retrieved from the queries in database.DbEquipmentList
 *
 */
public class ModelEquipment {
	
	private String equipment;
	private int Flåkoia, Fosenkoia, Heinfjordstua, Hognabu, Holmsåkoia, Holvassgamma, Iglbu, Kamtjønnkoia;
	private int Kråklikåten, Kvernmovollen, Kåsen, Lynhøgen, Mortenskåten, Nicokoia, Rindalsløa, Selbukåten;
	private int Sonvasskoia, Stabburet, Stakkslettbua, Telin, Taagaabu, Vekvessætra, Øvensenget;
	public Map<String,Integer> statusMap;

	public ModelEquipment(String equipment, int flåkoia, int fosenkoia,
			int heinfjordstua, int hognabu, int holmsåkoia, int holvassgamma,
			int iglbu, int kamtjønnkoia, int kråklikåten, int kvernmovollen,
			int kåsen, int lynhøgen, int mortenskåten, int nicokoia,
			int rindalsløa, int selbukåten, int sonvasskoia, int stabburet,
			int stakkslettbua, int telin, int taagaabu, int vekvessætra,
			int øvensenget){
		
		this.equipment = equipment;
		Flåkoia = flåkoia;
		Fosenkoia = fosenkoia;
		Heinfjordstua = heinfjordstua;
		Hognabu = hognabu;
		Holmsåkoia = holmsåkoia;
		Holvassgamma = holvassgamma;
		Iglbu = iglbu;
		Kamtjønnkoia = kamtjønnkoia;
		Kråklikåten = kråklikåten;
		Kvernmovollen = kvernmovollen;
		Kåsen = kåsen;
		Lynhøgen = lynhøgen;
		Mortenskåten = mortenskåten;
		Nicokoia = nicokoia;
		Rindalsløa = rindalsløa;
		Selbukåten = selbukåten;
		Sonvasskoia = sonvasskoia;
		Stabburet = stabburet;
		Stakkslettbua = stakkslettbua;
		Telin = telin;
		Taagaabu = taagaabu;
		Vekvessætra = vekvessætra;
		Øvensenget = øvensenget;
		
	}

	public int getFlåkoia() {
		return Flåkoia;
	}

	public int getFosenkoia() {
		return Fosenkoia;
	}

	public int getHeinfjordstua() {
		return Heinfjordstua;
	}

	public int getHognabu() {
		return Hognabu;
	}

	public int getHolmsåkoia() {
		return Holmsåkoia;
	}

	public int getHolvassgamma() {
		return Holvassgamma;
	}

	public int getIglbu() {
		return Iglbu;
	}

	public int getKamtjønnkoia() {
		return Kamtjønnkoia;
	}

	public int getKråklikåten() {
		return Kråklikåten;
	}

	public int getKvernmovollen() {
		return Kvernmovollen;
	}

	public int getKåsen() {
		return Kåsen;
	}

	public int getLynhøgen() {
		return Lynhøgen;
	}

	public int getMortenskåten() {
		return Mortenskåten;
	}

	public int getNicokoia() {
		return Nicokoia;
	}

	public int getRindalsløa() {
		return Rindalsløa;
	}

	public int getSelbukåten() {
		return Selbukåten;
	}

	public int getSonvasskoia() {
		return Sonvasskoia;
	}

	public int getStabburet() {
		return Stabburet;
	}

	public int getStakkslettbua() {
		return Stakkslettbua;
	}

	public int getTelin() {
		return Telin;
	}

	public int getTaagaabu() {
		return Taagaabu;
	}

	public int getVekvessætra() {
		return Vekvessætra;
	}

	public int getØvensenget() {
		return Øvensenget;
	}

	public Map<String, Integer> getStatusMap() {
		return statusMap;
	}

	public String getEquipment() {
		return equipment;
	}

	public Integer getEquipmentStatus(String koieName){
		return statusMap.get(koieName);
	}
	

	public void makeStatusMap(){
		statusMap = new HashMap<String,Integer>();
		statusMap.put("Flåkoia", Flåkoia);
		statusMap.put("Fosenkoia", Fosenkoia);
		statusMap.put("Heinfjordstua", Heinfjordstua);
		statusMap.put("Hognabu", Hognabu);
		statusMap.put("Holmsåkoia", Holmsåkoia);
		statusMap.put("Holvassgamma", Holvassgamma);
		statusMap.put("Iglbu", Iglbu);
		statusMap.put("Kamtjønnkoia", Kamtjønnkoia);
		statusMap.put("Kråklikåten", Kråklikåten);
		statusMap.put("Kvernmovollen", Kvernmovollen);
		statusMap.put("Kåsen", Kåsen);
		statusMap.put("Lynhøgen", Lynhøgen);
		statusMap.put("Mortenskåten", Mortenskåten);
		statusMap.put("Nicokoia", Nicokoia);
		statusMap.put("Rindalsløa", Rindalsløa);
		statusMap.put("Selbukåten", Selbukåten);
		statusMap.put("Sonvasskoia", Sonvasskoia);
		statusMap.put("Stabburet", Stabburet);
		statusMap.put("Stakkslettbua", Stakkslettbua);
		statusMap.put("Telin", Telin);
		statusMap.put("Taagaabu", Taagaabu);
		statusMap.put("Vekvessætra",Vekvessætra);
		statusMap.put("Øvensenget", Øvensenget);
	}
	
}
