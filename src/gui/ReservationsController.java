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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * 
 * Class for controlling the content of the Reservations-GUI
 *
 */

public class ReservationsController implements Initializable {

	private static Stage primaryStage;
	
	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		ReservationsController.primaryStage = primaryStage;
	}
	
	//Declaring fields from the FXML-file
	@FXML
	TableView<ModelReservations> reservationsTable;
	@FXML
	TableColumn<ModelReservations, String> koie, name, email;
	@FXML
	TableColumn<ModelReservations, Date> date, from, to;
	@FXML
	TableColumn<ModelReservations, Integer> number;


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
	 * Making an ObservableList of ModelReservations objects collected from DdReservations.getReservations().
	 */
	final ObservableList<ModelReservations> data = FXCollections
			.observableArrayList(DbReservations.getReservations());
	
	/**
	 * The initialize method that is called automatically. 
	 * Calling methods for filling the reservations table and enable double click on the table
	 * in this method.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateReservationsTable();
		enableDoubleClickOnTable();

	}
	
	/**
	 * Method that defines the data types to be displayed in the reservations table. 
	 * Adds data to the table view.
	 */

	private void updateReservationsTable() {
		koie.setCellValueFactory(new PropertyValueFactory<ModelReservations, String>(
				"koieName"));
		from.setCellValueFactory(new PropertyValueFactory<ModelReservations, Date>(
				"startDate"));
		to.setCellValueFactory(new PropertyValueFactory<ModelReservations, Date>(
				"endDate"));
		name.setCellValueFactory(new PropertyValueFactory<ModelReservations, String>(
				"tenantName"));
		email.setCellValueFactory(new PropertyValueFactory<ModelReservations, String>(
				"tenantEmail"));
		number.setCellValueFactory(new PropertyValueFactory<ModelReservations, Integer>(
				"tenantNumber"));

		reservationsTable.setItems(data);
	}

	/**
	 * Makes a event when a row is double clicked in the reservations table.
	 * When double clicked. The value of the row(ModelReservations object) will take
	 * you to Reservation-GUI showing the values of the clicked ModelReservations.
	 */	
	private void enableDoubleClickOnTable() {
		reservationsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					ModelReservations reservation = (ModelReservations) reservationsTable
							.getSelectionModel().getSelectedItem();
					Reservation r = new Reservation();
					try {
						ReservationController.setReservations(reservation);
						r.start(primaryStage);

					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});
	}
}
