package gui;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{
	

	

		@Override
		public void start(Stage primaryStage) throws IOException {
			Parent root = FXMLLoader.load(Login.class.getResource("Login.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}
}

