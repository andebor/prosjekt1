package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
	
	private static Stage primaryStage;
	
	
	public static void setPrimaryStage(Stage primaryStage){
		MainMenuController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button koier, reports, reservations, equipmentList, logOut;
	
	
	
	
	@FXML
	public void openKoie(ActionEvent event)throws IOException{
		Koier koier = new Koier();
		koier.start(primaryStage);
		
	}
	
	@FXML
	public void openReports(ActionEvent event)throws IOException{
		Reports reports = new Reports();
		reports.start(primaryStage);
		
	}
	
	@FXML
	public void openReservations(ActionEvent event)throws IOException{
		Reservations reserv = new Reservations();
		reserv.start(primaryStage);
	
	}
	
	@FXML
	public void openEquipmentList(ActionEvent event)throws IOException{
		EquipmentList el = new EquipmentList();
		el.start(primaryStage);	
	}
	
	public void backToLogin(ActionEvent event)throws IOException{
		Login li = new Login();
		li.start(primaryStage);
	}
	
	
}
