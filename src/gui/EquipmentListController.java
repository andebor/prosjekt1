package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EquipmentListController {
	
	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		EquipmentListController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

}
