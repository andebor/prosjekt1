package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
/**
 * 
 * Class for controlling the content of the MainMenu-GUI
 *
 */

public class MainMenuController {
	
	private static Stage primaryStage;

	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */

	public static void setPrimaryStage(Stage primaryStage){
		MainMenuController.primaryStage = primaryStage;
	}
	

	/**
	 * Method for opening the Koier-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void openKoie(ActionEvent event)throws IOException{
		Koier koier = new Koier();
		koier.start(primaryStage);
	}
	
	/**
	 * Method for opening the Kart-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void openKart(ActionEvent event)throws IOException{
		Kart kart = new Kart();
		Kart.setPrimaryStage(primaryStage);
		kart.start(primaryStage);
	}
	
	/**
	 * Method for opening the Reports-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void openReports(ActionEvent event)throws IOException{
		Reports reports = new Reports();
		reports.start(primaryStage);
	}
	
	/**
	 * Method for opening the Reservations-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	
	@FXML
	public void openReservations(ActionEvent event)throws IOException{
		Reservations reserv = new Reservations();
		reserv.start(primaryStage);
	}
	
	/**
	 * Method for opening the EquipmentList-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void openEquipmentList(ActionEvent event)throws IOException{
		EquipmentList el = new EquipmentList();
		el.start(primaryStage);	
	}
	
	/**
	 * Method for opening the Login-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void backToLogin(ActionEvent event)throws IOException{
		Login li = new Login();
		li.start(primaryStage);
	}
	
}