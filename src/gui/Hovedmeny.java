package gui;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Hovedmeny extends Application{
	
		@Override
		public void start(Stage primaryStage) throws IOException {
			Parent root = FXMLLoader.load(Hovedmeny.class.getResource("Hovedmeny.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}
}

