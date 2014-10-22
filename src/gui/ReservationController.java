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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReservationController{
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReservationController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back, back1;

//	@FXML
//	TableView<ModelReservations> reservationsTable;
//	@FXML
//	TableColumn<ModelReservations, String> koie, name, email;
//	@FXML
//	TableColumn<ModelReservations, Date> date, from, to;
//	@FXML
//	TableColumn<ModelReservations, Integer> number;
	
	
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
//	final ObservableList<ModelReservations> data = FXCollections.observableArrayList(DbReservations.getReservations());
	
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		koie.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, String>("koieName"));
//		from.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, Date>("startDate"));
//		to.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, Date>("endDate"));
//		name.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, String>("tenantName"));
//		email.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, String>("tenantEmail"));
//		number.setCellValueFactory(
//				new PropertyValueFactory<ModelReservations, Integer>("tenantNumber"));
//		
//		
//	}
//	
}
