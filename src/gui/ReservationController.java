package gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import model.ModelReservations;
import database.DbReports;
import database.DbReservations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReservationController implements Initializable{
	
	private static Stage primaryStage;
	private static ModelReservations reservation;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReservationController.primaryStage = primaryStage;
	}
	
	public static void setReservations(ModelReservations reservation){
		ReservationController.reservation = reservation;
	}
	
	@FXML
	private Button back, back1, standardMail, customMail;

	@FXML
	TextField koie, id, startDate, endDate, delivered, email, number, name;

	@FXML
	public void backToMainMenu(ActionEvent event)throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	@FXML
	public void backToReservations(ActionEvent event) throws IOException{
		Reservations r = new Reservations();
		r.start(primaryStage);
	}
	@FXML
	public void sendStandardEmail(ActionEvent event){
		 Desktop desktop = Desktop.getDesktop(); 
		 try {
			 String body = "Hei%0DDu%20har%20reservert"
			 		+ "%20"+reservation.getKoieName()+"%20i%20perioden%20"+reservation.getStartDate().toString()
			 		+"%20til%20"+reservation.getEndDate().toString()+"%0D"
			 		+ "Husk%20å%20sende%20inn%20rapport%20etter%20oppholdet%20på%20http://org.ntnu.no/gruppetre/%0D"
			 		+"Hilsen%20Koiestyret";
			desktop.mail(new URI("mailto:"+email.getText()+"?subject=Koierapport&body="+body));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void sendCustomEmail(ActionEvent event){
		Desktop desktop = Desktop.getDesktop();
		try{
			desktop.mail(new URI("mailto:"+email.getText()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (reservation != null){
			koie.setText(reservation.getKoieName());
			id.setText(String.valueOf(reservation.getReservationId()));
			startDate.setText(reservation.getStartDate().toString());
			endDate.setText(reservation.getEndDate().toString());
			
			delivered.setText(DbReports.checkReport
					(reservation.getKoieName(), reservation.getStartDate().toString(), reservation.getEndDate().toString()) ?
					"Ja" : "Nei");
			if (delivered.getText().equals("Ja")){
				delivered.setStyle("-fx-background-color: lightgreen");
			}
			else{
				delivered.setStyle("-fx-background-color: lightsalmon");
			}
			email.setText(reservation.getTenantEmail());
			number.setText(reservation.getTenantNumber());
			name.setText(reservation.getTenantName());
			}	
	}
}
