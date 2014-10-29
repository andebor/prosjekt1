package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.ModelKoie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	TextField koieName;
	
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (koie != null){
			koieName.setText(koie.getKoieName());

			
			
		}
		
		
	}

}
