package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class LoginController {
	
	private static Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage){
		LoginController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button login;
	
	@FXML
	public void openMainMenu(ActionEvent event){
		MainMenu mm = new MainMenu();
		try {
			mm.start(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
