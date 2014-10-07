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

public class Login extends Application{
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(this);
        Parent root = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        this.primaryStage = primaryStage;
	}

	@FXML
	private Button loginn;
	
	@FXML
	public void openHovedmeny(ActionEvent event){
		Hovedmeny hm = new Hovedmeny();
		try {
			hm.start(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
