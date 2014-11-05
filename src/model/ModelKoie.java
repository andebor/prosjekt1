package model;

import java.util.Date;

public class ModelKoie {

	private String koieName;
	private int numberOfBeds;
	private String description;
	private String image;
	 

	public ModelKoie(String koie_name, int number_of_beds, String description, String image){
		this.koieName = koie_name;
		this.numberOfBeds = number_of_beds;
		this.description = description;
		this.image = image;
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
	
}
