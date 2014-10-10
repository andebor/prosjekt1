package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application{
	
	
		@Override
		public void start(Stage primaryStage) throws IOException {
			Parent root = FXMLLoader.load(this.getClass().getResource("MainMenu.fxml"));
		    primaryStage.setScene(new Scene(root));
		    primaryStage.show();
		    MainMenuController.setPrimaryStage(primaryStage);
		     
		}
	
		
		
		public static void main(String[] args) {
			launch(args);
		}
}

