package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import model.ModelReports;
import model.ModelReservations;
import database.DbReservations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReservationsController implements Initializable {

	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		ReservationsController.primaryStage = primaryStage;
	}

	@FXML
	private Button back;
	@FXML
	TableView<ModelReservations> reservationsTable;
	@FXML
	TableColumn<ModelReservations, String> koie, name, email;
	@FXML
	TableColumn<ModelReservations, Date> date, from, to;
	@FXML
	TableColumn<ModelReservations, Integer> number;

	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException {
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	final ObservableList<ModelReservations> data = FXCollections
			.observableArrayList(DbReservations.getReservations());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
