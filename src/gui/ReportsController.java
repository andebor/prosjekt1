package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import model.ModelReports;
import database.DbReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ReportsController implements Initializable {

	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		ReportsController.primaryStage = primaryStage;
	}

	@FXML
	private TableView<ModelReports> reportsTable;
	@FXML
	private TableColumn<ModelReports, String> koie;
	@FXML
	private TableColumn<ModelReports, Date> date, from, to, dateDelivered;
	@FXML
	private TableColumn<ModelReports, Integer> status;

	// Method for returning to main menu
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException {
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	final ObservableList<ModelReports> data = FXCollections
			.observableArrayList(DbReports.getReports());

	@FXML
	public void openReport(ActionEvent event) throws IOException {
		ModelReports report = (ModelReports) reportsTable.getSelectionModel()
				.getSelectedItem();
		System.out.println(report.getKoieName());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateReportsTable();
		enableDoubleClickOnTable();

	}

	private void updateReportsTable() {
		koie.setCellValueFactory(new PropertyValueFactory<ModelReports, String>(
				"koieName"));
		from.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>(
				"startDate"));
		to.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>(
				"endDate"));
		dateDelivered
				.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>(
						"timeStamp"));
		status.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>(
				"status"));

		status.setCellFactory(column -> {
			return new TableCell<ModelReports, Integer>() {
				@Override
				protected void updateItem(Integer item, boolean empty) {
					super.updateItem(item, empty);

					if (!empty) {
						setTextFill(Paint.valueOf("black"));
						if (item == 0) {
							setStyle("-fx-background-color: lightgreen");
							setText("Alt i orden");
						} else if (item == 1) {
							setStyle("-fx-background-color: lightsalmon");
							setText("Mangler i utstyr");
						} else {
							setStyle("-fx-background-color: khaki");
							setText("Gjenglemt");
						}
					} else {
						setText(null);
					}
				}
			};
		});
		reportsTable.setItems(data);
	}

	private void enableDoubleClickOnTable() {
		reportsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					ModelReports report = (ModelReports) reportsTable
							.getSelectionModel().getSelectedItem();
					ReportForm rf = new ReportForm();
					try {
						ReportFormController.setReports(report);
						rf.start(primaryStage);

					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});
	}

}
