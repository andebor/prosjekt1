package model;

public class ModelEquipmentList {

	private int equipment_id;
	private String equipmentName;
	private String koieName;
	private boolean status;
	 

	public ModelEquipmentList(int equipment_id, String equipment_name, String koie_name, boolean status){
		this.equipment_id = equipment_id;
		this.equipmentName = equipment_name;
		this.koieName = koie_name;
		this.status = status;
	}

	public String getKoieName() {
		return koieName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	
}
