package gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReportsController {
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReportsController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	private TableView reportsTable;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	
}
