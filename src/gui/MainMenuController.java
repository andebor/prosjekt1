package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
	
	private static Stage primaryStage;
	
	
	public void setPrimaryStage(Stage primaryStage){
		MainMenuController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button koier, reports, reservations, equipmentList;
	
	
	
	
	@FXML
	public void openKoie(ActionEvent event){
		Koier koier = new Koier();
		try {
			koier.start(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void openReports(ActionEvent event){
		Reports reports = new Reports();
		try{
			reports.start(primaryStage);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void openReservations(ActionEvent event){
		Reservations reserv = new Reservations();
		try{
			reserv.start(primaryStage);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void openEquipmentList(ActionEvent event){
		EquipmentList el = new EquipmentList();
		try {
			el.start(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
