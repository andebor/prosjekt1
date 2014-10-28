package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class KoierController implements Initializable {

	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		KoierController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	private ChoiceBox koieList;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
