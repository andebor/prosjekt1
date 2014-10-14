package gui;

import java.io.IOException;

import db.DbAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		LoginController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button login;
	@FXML
	private TextField username, pw;
	@FXML
	private Text errorMessage;
	
	
	@FXML
	public void openMainMenu(ActionEvent event)throws IOException{
		DbAdmin dbAdmin = new DbAdmin();
		if (dbAdmin.checkAdmin(username.getText(),pw.getText())){
			MainMenu mm = new MainMenu();
			mm.start(primaryStage);
			
		}
		else{
			errorMessage.setVisible(true);
			
			
		}
		
		
	}
}
