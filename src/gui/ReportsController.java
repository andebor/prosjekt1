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
/**
 * 
 * Class for controlling the content of the Reports-GUI
 *
 */
public class ReportsController implements Initializable {

	private static Stage primaryStage;
	
	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		ReportsController.primaryStage = primaryStage;
	}
	

	//Declaring fields from the FXML-file
	@FXML
	private TableView<ModelReports> reportsTable;
	@FXML
	private TableColumn<ModelReports, String> koie;
	@FXML
	private TableColumn<ModelReports, Date> date, from, to, dateDelivered;
	@FXML
	private TableColumn<ModelReports, Integer> status;

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
	 * Making an ObservableList of ModelReports objects collected from DdReports.getReports().
	 */
	final ObservableList<ModelReports> data = FXCollections
			.observableArrayList(DbReports.getReports());
	

	/**
	 * The initialize method that is called automatically. 
	 * Calling methods for filling the reports table and enable double click on the table
	 * in this method.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateReportsTable();
		enableDoubleClickOnTable();

	}
	
	/**
	 * Method that defines the data types to be displayed in the reports table. 
	 * The status column has a CellValueFactory-method so that we are able to display 
	 * different text and colours according to the status we get from the database.
	 */
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
		//Make the sort type on dateDelivered to descending
		dateDelivered.setSortType(TableColumn.SortType.DESCENDING);
		
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
							setStyle("-fx-background-color: khaki");
							setText("Gjenglemt");
						} else {
							setStyle("-fx-background-color: lightsalmon");
							setText("Mangler i utstyr");
						}
					} else {
						setText(null);
					}
				}
			};
		});
		reportsTable.setItems(data);
		//Setting the table to sort on the values in the "Dato levert" column
		reportsTable.getSortOrder().add(dateDelivered);
		
	}
	
	

	/**
	 * Makes a event when a row is double clicked in the reports table.
	 * When double clicked. The value of the row(ModelReports object) will take
	 * you to ReportForm-GUI showing the values of the clicked ModelReports.
	 */
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
