package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Class for starting the ReportForm-GUI
 */
public class ReportForm extends Application {
	/**
	 * Method for starting the GUI and retrieve the FXML file. Passing the Stage element to the controller file.
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(this.getClass().getResource("ReportForm.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		ReportFormController.setPrimaryStage(primaryStage);     
	}
		
}
