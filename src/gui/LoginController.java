package gui;

import java.io.IOException;

import database.DbAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * Class for controlling the content of the Login-GUI. 
 *
 */

public class LoginController {

	private static Stage primaryStage;

	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		LoginController.primaryStage = primaryStage;
	}

	//Declaring fields from the FXML-file
	@FXML
	private TextField e_post;
	@FXML
	private Text errorMessage;
	@FXML
	private PasswordField pw;

	/**
	 * Method for opening the MainMenu-GUI. It will only open 
	 * the main menu if username and password is correct which
	 * is checked with the DbAdmin.checkAdmin(username,pw) method. 
	 * Otherwise, an error message will appear.
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */

	@FXML
	public void openMainMenu(ActionEvent event) throws IOException {
		if (DbAdmin.checkAdmin(e_post.getText(), pw.getText())) {
			MainMenu mm = new MainMenu();
			mm.start(primaryStage);
		} else {
			errorMessage.setVisible(true);
		}
	}
}
