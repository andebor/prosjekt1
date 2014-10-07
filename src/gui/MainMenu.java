package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenu extends Application{
		private Stage primaryStage;
		
		@Override
		public void start(Stage primaryStage) throws IOException {
		    FXMLLoader fxmlLoader = new FXMLLoader();
	        fxmlLoader.setController(this);
	        Parent root = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("MainMenu.fxml"));
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	        this.primaryStage = primaryStage;
		}

		@FXML
		private Button koier, reports, reservations, equipmentList;
		
		@FXML
		public void openKoie(ActionEvent event){
			Koier koier = new Koier();
			try {
				koier.start(primaryStage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		@FXML
		public void openEquipmentList(ActionEvent event){
			EquipmentList el = new EquipmentList();
			try {
				el.start(primaryStage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		public static void main(String[] args) {
			launch(args);
		}
}

