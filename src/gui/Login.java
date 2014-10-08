package gui;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Login extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent root = FXMLLoader.load(this.getClass().getResource("Login.fxml"));
	    primaryStage.setScene(new Scene(root));
	    primaryStage.show();
	    LoginController lc = new LoginController();
	    lc.primaryStage = primaryStage;
	}
	 
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
