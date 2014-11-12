package gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import model.ModelReservations;
import database.DbReports;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * 
 * Class for controlling the content of the Reservation-GUI
 *
 */

public class ReservationController implements Initializable {

	private static Stage primaryStage;
	private static ModelReservations reservation;
	
	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */

	public static void setPrimaryStage(Stage primaryStage) {
		ReservationController.primaryStage = primaryStage;
	}
	
	/**
	 * Method for setting the current reservation to be showed in the GUI view
	 * @param reservation ModelReservations object.
	 */
	public static void setReservations(ModelReservations reservation) {
		ReservationController.reservation = reservation;
	}

	//Declaring fields from the FXML-file
	@FXML
	TextField koie, id, startDate, endDate, delivered, email, number, name;
	
	/**
	 * Method for opening the MainMenu-GUI
	 * @param event
	 * @throws IOException If an input or output exception occurred
	 */

	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException {
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	/**
	 * Method for going back to the Reservations-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */

	@FXML
	public void backToReservations(ActionEvent event) throws IOException {
		Reservations r = new Reservations();
		r.start(primaryStage);
	}
	
	/**
	 * Code to be executed if the "Standard email" button is pressed.
	 * @param event 
	 */
	@FXML
	public void sendStandardEmail(ActionEvent event) {
		sendEmail(true);
	}
	
	/**
	 * Code to be executed if the "Annen email" button is pressed.
	 * @param event
	 */
	@FXML
	public void sendCustomEmail(ActionEvent event) {
		sendEmail(false);
	}

	/**
	 * Method that opens your standard email program (if you have one) and makes an automatic
	 * generated email if param = true or an empty email if param = false. The reciever email
	 * is the ModelReservations.tenantMail field. Catching exceptions if URI is wrong, the system
	 * does not support Desktop or IOException
	 * @param standard
	 */
	private void sendEmail(boolean standard) {
		Desktop desktop = Desktop.getDesktop();
		try {
			if (standard) {
				String body = "Hei!%0DDu%20har%20reservert"
						+ "%20"
						+ reservation.getKoieName()
						+ "%20i%20perioden%20"
						+ reservation.getStartDate().toString()
						+ "%20til%20"
						+ reservation.getEndDate().toString()
						+ ".%0D"
						+ "Husk%20å%20sende%20inn%20rapport%20etter%20oppholdet%20på%20http://org.ntnu.no/gruppetre/.%0D"
						+ "Hilsen%20Koiestyret.";
				desktop.mail(new URI("mailto:" + email.getText()
						+ "?subject=Koierapport&body=" + body));
			} else {
				desktop.mail(new URI("mailto:" + email.getText()));
			}
		} catch (UnsupportedOperationException e){
			e.printStackTrace();
			
		} catch (IOException e) {

			e.printStackTrace();
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
	}
	/**
	 * The initialize method that is called automatically. 
	 * Calling methods for filling the reservation fields with data in the GUI
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateReservation();
	}
	
	/**
	 * Filling textfields in the GUI with data from the ModelReservations object
	 */
	private void updateReservation(){
		if (reservation != null) {
			koie.setText(reservation.getKoieName());
			id.setText(String.valueOf(reservation.getReservationId()));
			startDate.setText(reservation.getStartDate().toString());
			endDate.setText(reservation.getEndDate().toString());

			delivered.setText(DbReports.checkReport(reservation.getKoieName(),
					reservation.getStartDate().toString(), reservation
							.getEndDate().toString()) ? "Ja" : "Nei");
			if (delivered.getText().equals("Ja")) {
				delivered.setStyle("-fx-background-color: lightgreen");
			} else {
				delivered.setStyle("-fx-background-color: lightsalmon");
			}
			email.setText(reservation.getTenantEmail());
			number.setText(reservation.getTenantNumber());
			name.setText(reservation.getTenantName());
		}
	}
}
