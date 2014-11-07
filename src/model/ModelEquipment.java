package model;

import java.util.HashMap;
import java.util.Map;

public class ModelEquipment {
	
	private String equipment;
	private int Fl�koia, Fosenkoia, Heinfjordstua, Hognabu, Holms�koia, Holvassgamma, Iglbu, Kamtj�nnkoia;
	private int Kr�klik�ten, Kvernmovollen, K�sen, Lynh�gen, Mortensk�ten, Nicokoia, Rindalsl�a, Selbuk�ten;
	private int Sonvasskoia, Stabburet, Stakkslettbua, Telin, Taagaabu, Vekvess�tra, �vensenget;
	public Map<String,Integer> statusMap;

	public ModelEquipment(String equipment, int fl�koia, int fosenkoia,
			int heinfjordstua, int hognabu, int holms�koia, int holvassgamma,
			int iglbu, int kamtj�nnkoia, int kr�klik�ten, int kvernmovollen,
			int k�sen, int lynh�gen, int mortensk�ten, int nicokoia,
			int rindalsl�a, int selbuk�ten, int sonvasskoia, int stabburet,
			int stakkslettbua, int telin, int taagaabu, int vekvess�tra,
			int �vensenget){
		
		this.equipment = equipment;
		Fl�koia = fl�koia;
		Fosenkoia = fosenkoia;
		Heinfjordstua = heinfjordstua;
		Hognabu = hognabu;
		Holms�koia = holms�koia;
		Holvassgamma = holvassgamma;
		Iglbu = iglbu;
		Kamtj�nnkoia = kamtj�nnkoia;
		Kr�klik�ten = kr�klik�ten;
		Kvernmovollen = kvernmovollen;
		K�sen = k�sen;
		Lynh�gen = lynh�gen;
		Mortensk�ten = mortensk�ten;
		Nicokoia = nicokoia;
		Rindalsl�a = rindalsl�a;
		Selbuk�ten = selbuk�ten;
		Sonvasskoia = sonvasskoia;
		Stabburet = stabburet;
		Stakkslettbua = stakkslettbua;
		Telin = telin;
		Taagaabu = taagaabu;
		Vekvess�tra = vekvess�tra;
		�vensenget = �vensenget;
		
	}

	public String getEquipment() {
		return equipment;
	}

	public int getEquipmentStatus(String koieName){
		return statusMap.get(koieName);
	}
	

	public void makeStatusMap(){
		statusMap = new HashMap<String,Integer>();
		statusMap.put("Fl�koia", Fl�koia);
		statusMap.put("Fosenkoia", Fosenkoia);
		statusMap.put("Heinfjordstua", Heinfjordstua);
		statusMap.put("Hognabu", Hognabu);
		statusMap.put("Holms�koia", Holms�koia);
		statusMap.put("Holvassgamma", Holvassgamma);
		statusMap.put("Iglbu", Iglbu);
		statusMap.put("Kamtj�nnkoia", Kamtj�nnkoia);
		statusMap.put("Kr�klik�ten", Kr�klik�ten);
		statusMap.put("Kvernmovollen", Kvernmovollen);
		statusMap.put("K�sen", K�sen);
		statusMap.put("Lynh�gen", Lynh�gen);
		statusMap.put("Mortensk�ten", Mortensk�ten);
		statusMap.put("Nicokoia", Nicokoia);
		statusMap.put("Rindalsl�a", Rindalsl�a);
		statusMap.put("Selbuk�ten", Selbuk�ten);
		statusMap.put("Sonvasskoia", Sonvasskoia);
		statusMap.put("Stabburet", Stabburet);
		statusMap.put("Stakkslettbua", Stakkslettbua);
		statusMap.put("Telin", Telin);
		statusMap.put("Taagaabu", Taagaabu);
		statusMap.put("Vekvess�tra",Vekvess�tra);
		statusMap.put("�vensenget", �vensenget);
	}
	
}
