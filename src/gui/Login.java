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
	private Stage primaryStage;
	
	@FXML
	private ImageView koieLogo;
	
	

	@Override
	public void start(Stage primaryStage) throws IOException {
	    FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(this);
        Parent root = (Parent) fxmlLoader.load(this.getClass().getResourceAsStream("Login.fxml"));
        File file = new File("koiene_logo.gif");
		Image image = new Image(file.toURI().toString());
        koieLogo.setImage(image);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        this.primaryStage = primaryStage;
        
	}
	
	
	
	
	 
	@FXML
	private Button login;
	
	@FXML
	public void openMainMenu(ActionEvent event){
		MainMenu mm = new MainMenu();
		try {
			mm.start(primaryStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
