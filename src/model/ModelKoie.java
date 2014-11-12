package model;
/**
 * 
 * Class for storing data retrieved from the queries in database.DbKoie and database.DbEquipmentList
 *
 */
public class ModelKoie {

	private String koieName;
	private int numberOfBeds;
	private String description;
	private String image;
	private int status,wood, smoke,forgotten;
	
	 /**
	  * Constructor for constructing static info on a koie
	  * @param koie_name The koie name
	  * @param number_of_beds Number of beds on the koie
	  * @param description Short description of the koie
	  * @param image Image URL of the koie
	  */
	public ModelKoie(String koie_name, int number_of_beds, String description, String image){
		this.koieName = koie_name;
		this.numberOfBeds = number_of_beds;
		this.description = description;
		this.image = image;
	}
	
	/**
	 * Constructor for only setting a koie name to the object
	 * @param koie_name The koie name
	 */
	public ModelKoie(String koie_name){
		this.koieName = koie_name;
		
	}
	/**
	 * Set the current status on the smoke detector
	 * @param smoke 0 or 1. 0 = works, 1= broken
	 */
	public void setSmoke(int smoke){
		this.smoke = smoke;
	}
	
	/**
	 * Set the general status on the koie
	 * @param status 0 = everything good, 1 = forgotten, 2 = defects (+maybe forgotten)
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * Set the wood status on the koie
	 * @param wood 1 = "0-15", 2 = "15-30", 3 = "Mer enn 30".
	 */
	public void setWood(int wood) {
		this.wood = wood;
	}
	
	/**
	 * Set the forgotten status on the koie
	 * @param forgotten 0 = all good, 1 = something forgotten.
	 */
	public void setForgotten(int forgotten){
		this.forgotten = forgotten;
	}
	
	/**
	 * 
	 * @return The koie name
	 */
	public String getKoieName() {
		return koieName;
	}
	/**
	 * 
	 * @return The number of beds
	 */
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	
	/**
	 * 
	 * @return The description of the koie
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * 
	 * @return The image URL of the koie as a String.
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * 
	 * @return The current general status of the koie
	 */
	public int getStatus(){
		return status;
	}
	/**
	 * 
	 * @return The current wood status
	 */
	public int getWood(){
		return wood;
	}
	
	/**
	 *
	 * @return The current smoke detector status
	 */
	public int getSmoke(){
		return smoke;
	}
	/**
	 * 
	 * @return If something is currently forgotten on the koie
	 */
	public int getForgotten(){
		return forgotten;
	}
}
