package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import model.ModelEquipmentLists;
import model.ModelReports;
import model.ModelReservations;
import database.DbEquipmentList;
import database.DbReservations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EquipmentListController implements Initializable{
	
	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		EquipmentListController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	TableView<ModelEquipmentLists> equipmentTable;
	@FXML
	TableColumn<ModelEquipmentLists, String> koie;
	@FXML
	TableColumn<ModelEquipmentLists, Integer> wood, status;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	final ObservableList<ModelEquipmentLists> data = FXCollections.observableArrayList(DbEquipmentList.getEquipmentLists());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		koie.setCellValueFactory(
				new PropertyValueFactory<ModelEquipmentLists, String>("koieName"));
		wood.setCellValueFactory(
				new PropertyValueFactory<ModelEquipmentLists, Integer>("wood"));
		status.setCellValueFactory(
				new PropertyValueFactory<ModelEquipmentLists, Integer>("status"));
		
		status.setCellFactory(column -> {
			return new TableCell<ModelEquipmentLists, Integer>() {
				@Override
				protected void updateItem(Integer item, boolean empty) {
					super.updateItem(item, empty);

					if (!empty) {

						if (item == 0) {
							setStyle("-fx-background-color: lightgreen");
							setText("Alt i orden");

						} else if (item == 1) {
							setStyle("-fx-background-color: khaki");
							setText("Gjenglemt");

						} else {

							setStyle("-fx-background-color: lightsalmon");
							setText("Mangler");
						}

					}

					else {
						setText(null);
					}
				}
			};

		});
		
		
		equipmentTable.setItems(data);
	}

}
