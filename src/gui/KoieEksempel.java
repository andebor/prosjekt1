package gui;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * Class for starting the KoieEksempel-GUI
 *
 */
public class KoieEksempel extends Application{
	/**
	 * Method for starting the GUI and retrieve the FXML file. Passing the Stage element to the controller file.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(KoieEksempel.class.getResource("KoieEksempel.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		KoieEksempelController.setPrimaryStage(primaryStage); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

