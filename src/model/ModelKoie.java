package model;

public class ModelKoie {

	private String koieName;
	private int numberOfBeds;
	private String description;
	private String image;
	private int status,wood, smoke,forgotten;
	
	 
	public ModelKoie(String koie_name, int number_of_beds, String description, String image){
		this.koieName = koie_name;
		this.numberOfBeds = number_of_beds;
		this.description = description;
		this.image = image;
	}
	
	public ModelKoie(String koie_name){
		this.koieName = koie_name;
		
	}
	public void setSmoke(int smoke){
		this.smoke = smoke;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}
	
	public void setForgotten(int forgotten){
		this.forgotten = forgotten;
	}

	public String getKoieName() {
		return koieName;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getImage() {
		return image;
	}
	
	public int getStatus(){
		return status;
	}
	
	public int getWood(){
		return wood;
	}
	
	public int getSmoke(){
		return smoke;
	}
	public int getForgotten(){
		return forgotten;
	}
}
