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

	public int getFl�koia() {
		return Fl�koia;
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

	public int getHolms�koia() {
		return Holms�koia;
	}

	public int getHolvassgamma() {
		return Holvassgamma;
	}

	public int getIglbu() {
		return Iglbu;
	}

	public int getKamtj�nnkoia() {
		return Kamtj�nnkoia;
	}

	public int getKr�klik�ten() {
		return Kr�klik�ten;
	}

	public int getKvernmovollen() {
		return Kvernmovollen;
	}

	public int getK�sen() {
		return K�sen;
	}

	public int getLynh�gen() {
		return Lynh�gen;
	}

	public int getMortensk�ten() {
		return Mortensk�ten;
	}

	public int getNicokoia() {
		return Nicokoia;
	}

	public int getRindalsl�a() {
		return Rindalsl�a;
	}

	public int getSelbuk�ten() {
		return Selbuk�ten;
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

	public int getVekvess�tra() {
		return Vekvess�tra;
	}

	public int get�vensenget() {
		return �vensenget;
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
