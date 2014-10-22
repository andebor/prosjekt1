package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import model.ModelReservations;
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
	private Button back, back1;

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (reservation != null){
			koie.setText(reservation.getKoieName());
			id.setText(String.valueOf(reservation.getReservationId()));
			startDate.setText(reservation.getStartDate().toString());
			endDate.setText(reservation.getEndDate().toString());
//			delivered.setText(reservation);
			email.setText(reservation.getTenantEmail());
			number.setText(reservation.getTenantNumber());
			name.setText(reservation.getTenantName());
			}	
	}
}
