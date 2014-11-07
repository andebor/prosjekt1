package model;

import java.util.HashMap;
import java.util.Map;

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
