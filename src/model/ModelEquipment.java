package model;

import java.util.HashMap;
import java.util.Map;

public class ModelEquipment {
	
	private int id;
	private String equipment;
	private int Flåkoia;
	private int Fosenkoia; 
	private int Heinfjordstua;
	private int Hognabu;
	private int Holmsåkoia;
	private int Holvassgamma;
	private int Iglbu;
	private int Kamtjønnkoia;
	private int Kråklikåten;
	private int Kvernmovollen;
	private int Kåsen;
	private int Lynhøgen;
	private int Mortenskåten;
	private int Nicokoia;
	private int Rindalsløa;
	private int Selbukåten;
	private int Sonvasskoia;
	private int Stabburet;
	private int Stakkslettbua;
	private int Telin;
	private int Taagaabu;
	private int Vekvessætra;
	private int Øvensenget;
	public Map<String,Integer> statusMap;

	public ModelEquipment(int id, String equipment, int flåkoia, int fosenkoia,
			int heinfjordstua, int hognabu, int holmsåkoia, int holvassgamma,
			int iglbu, int kamtjønnkoia, int kråklikåten, int kvernmovollen,
			int kåsen, int lynhøgen, int mortenskåten, int nicokoia,
			int rindalsløa, int selbukåten, int sonvasskoia, int stabburet,
			int stakkslettbua, int telin, int taagaabu, int vekvessætra,
			int øvensenget){
		
		this.id = id;
		this.equipment = equipment;
		this.id = id;
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

	public int getId() {
		return id;
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

	public String getEquipment() {
		return equipment;
	}

	public int getEquipmentStatus(String koieName){
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
