package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Class for starting the Login-GUI. This is also the systems starting class.
 */
public class Login extends Application {
	
	/**
	 * Method for starting the GUI and retrieve the FXML file. Passing the Stage element to the controller file.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
	    primaryStage.setScene(new Scene(root));
	    primaryStage.show();
	    primaryStage.setResizable(false);
	    LoginController.setPrimaryStage(primaryStage);
	   
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
