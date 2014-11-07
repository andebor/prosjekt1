package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DbKoie;
import model.ModelKoie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KoierController implements Initializable {

	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		KoierController.primaryStage = primaryStage;
	}
	
	@FXML
	private ComboBox<String> koieList;
	@FXML
	private Text errorMessage;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	//Opening selected koie in the choicebox when "Velg koie" is clicked
	@FXML
	public void toKoie(ActionEvent event)throws IOException{
		if(koieList.getValue() != null){
		ModelKoie mkoie = DbKoie.getKoie(koieList.getValue());//Getting the selected koie object by using its name
		KoieEksempel koie = new KoieEksempel();
		try {
			KoieEksempelController.setKoier(mkoie);
			koie.start(primaryStage);

		} catch (IOException e) {

			e.printStackTrace();
		}
		}
		else{
			errorMessage.setVisible(true);//Error message if nothing is selected
		}
	}
	
	//Code for filling the choicebox with koie names on initialization of the GUI
	final ObservableList<String> data = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		koieList.setPromptText("Trykk her for å finne koie");
		koieList.setItems(data);
		
	}
}
