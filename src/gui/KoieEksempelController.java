package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DbKoie;
import model.ModelKoie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KoieEksempelController implements Initializable {
	private static Stage primaryStage;
	private static ModelKoie koie;
	
	public static void setPrimaryStage(Stage primaryStage){
		KoieEksempelController.primaryStage = primaryStage;
	}
	
	public static void setKoier(ModelKoie koie){
		KoieEksempelController.koie = koie;
	}
	
	@FXML 
	Button back,backToMain;
	
	@FXML
	Text koieName;
	
	@FXML
	private ChoiceBox<String> koieList;
	@FXML
	private Text errorMessage;
	
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		Koier koie = new Koier();
		koie.start(primaryStage);
	}
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (koie != null){
			koieName.setText(koie.getKoieName());

			
			
		}
		
		
	}

}
