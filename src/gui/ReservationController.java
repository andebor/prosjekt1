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

public class ReservationController implements Initializable {

	private static Stage primaryStage;
	private static ModelReservations reservation;

	public static void setPrimaryStage(Stage primaryStage) {
		ReservationController.primaryStage = primaryStage;
	}

	public static void setReservations(ModelReservations reservation) {
		ReservationController.reservation = reservation;
	}

	@FXML
	TextField koie, id, startDate, endDate, delivered, email, number, name;

	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException {
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	@FXML
	public void backToReservations(ActionEvent event) throws IOException {
		Reservations r = new Reservations();
		r.start(primaryStage);
	}

	@FXML
	public void sendStandardEmail(ActionEvent event) {
		sendEmail(true);
	}

	@FXML
	public void sendCustomEmail(ActionEvent event) {
		sendEmail(false);
	}

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
		} catch (IOException e) {

			e.printStackTrace();
		} catch (URISyntaxException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateReservation();
	}
	
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
