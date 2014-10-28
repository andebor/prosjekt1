package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import database.DbKoie;
import database.DbReports;
import model.ModelKoie;
import model.ModelReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ChoiceBox<String> koieList;
	
	
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	final ObservableList<String> data = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		koieList.setItems(data);
		
	}
}
