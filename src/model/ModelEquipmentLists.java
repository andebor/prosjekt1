package model;

public class ModelEquipmentLists {

	private String koieName;
	private int wood;
	private int status;
	 

	public ModelEquipmentLists(String koie_name, int wood, int status){
		this.koieName = koie_name;
		this.wood = wood;
		this.status = status;
	}

	public String getKoieName() {
		return koieName;
	}
	
	public int getWood(){
		return wood;
	}
	
	public int getStatus(){
		return status;
	}
	
	
}
