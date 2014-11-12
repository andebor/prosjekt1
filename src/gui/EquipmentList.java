package gui;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * Class for starting the EquipmentList-Gui
 *
 */
public class EquipmentList extends Application{
	/**
	 * Method for starting the GUI and retrieve the FXML file. Passing the Stage element to the controller file.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(EquipmentList.class.getResource("EquipmentList.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		EquipmentListController.setPrimaryStage(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

