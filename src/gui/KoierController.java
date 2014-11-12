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
/**
 * 
 * Class for controlling the content of the Koier-GUI
 *
 */
public class KoierController implements Initializable {

	private static Stage primaryStage;
	
	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage){
		KoierController.primaryStage = primaryStage;
	}
	//Declaring the fields coming from FXML
	@FXML
	private ComboBox<String> koieList;
	@FXML
	private Text errorMessage;
	
	/**
	 * Method for opening the MainMenu-GUI
	 * @param event
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	/**
	 * Method for opening the KoieEksempel-GUI. Makes a ModelKoie object from the selected koie name in the checkbox
	 * by using DbKoie.getKoie(koieName). Shows an error message in the GUI if no koie is selected.
	 * @param event 
	 * @throws IOException
	 */
	
	@FXML
	public void toKoie(ActionEvent event)throws IOException{
		if(koieList.getValue() != null){
		ModelKoie mkoie = DbKoie.getKoie(koieList.getValue());
		KoieEksempel koie = new KoieEksempel();
		try {
			KoieEksempelController.setKoier(mkoie);
			koie.start(primaryStage);

		} catch (IOException e) {

			e.printStackTrace();
		}
		}
		else{
			errorMessage.setVisible(true);
		}
	}
	
	/**
	 * Code for adding koie names to an ObservableList using DbKoie.getAllKoieNames();
	 */
	final ObservableList<String> data = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	/**
	 *  Initializing method for filling the ChoiceBox with the 
	 *  ObservableList of koie names and setting the prompt text of the choicebox 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		koieList.setPromptText("Trykk her for å finne koie");
		koieList.setItems(data);
		
	}
}
