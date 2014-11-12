package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import model.ModelKoie;
import database.DbKoie;
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
 * Class for controlling the content of the EquipmentList-GUI
 *
 */
public class EquipmentListController implements Initializable{
	
	private static Stage primaryStage;

	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		EquipmentListController.primaryStage = primaryStage;
	}
	
	/**
	 * Declaring an Observable list of Modelkoie objects by getting the values from DbKoie.getAllKoieStatus().
	 */
	final ObservableList<ModelKoie> data = FXCollections.observableArrayList(DbKoie.getAllKoieStatus());
	
	//Declaring fields from the FXML-file
	@FXML
	TableView<ModelKoie> equipmentTable;
	@FXML
	TableColumn<ModelKoie, String> koie;
	@FXML
	TableColumn<ModelKoie, Integer> wood, status;
	
	
	/**
	 * Method for opening the MainMenu-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	/**
	 * The initialize method that is called automatically. 
	 * Calling methods for filling the equipment table and enable double click on the table
	 * in this method.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateEquipmentTable();
		enableDoubleClickOnTable();
		

	}
	
	
	/**
	 * Method that defines the data types to be displayed in the equipment table. 
	 * The status and wood columns have a CellValueFactory-method so that we are able to display 
	 * different text and colours according to the status we get from the database.
	 * Adds data to the table view.
	 */
	private void updateEquipmentTable(){
		koie.setCellValueFactory(
				new PropertyValueFactory<ModelKoie, String>("koieName"));
		wood.setCellValueFactory(
				new PropertyValueFactory<ModelKoie, Integer>("wood"));
		
		wood.setCellFactory(column ->{
			return new TableCell<ModelKoie,Integer>(){
				@Override
				protected void updateItem(Integer item, boolean empty){
					super.updateItem(item, empty);
					
					if(!empty){
						if (item == 1) {
							setText("0-15");
						}
						else if(item == 2){
							setText("15-30");
						}
						else{
							setText("Mer enn 30");
						}
					}
					else{
						setText(null);
					}
				}
			};
		});
		status.setCellValueFactory(
				new PropertyValueFactory<ModelKoie, Integer>("status"));
		
		status.setCellFactory(column -> {
			return new TableCell<ModelKoie, Integer>() {
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
	
	/**
	 * Makes a event when a row is double clicked in the equipment table.
	 * When double clicked. The value of the row(ModelKoie object) will take
	 * you to Koie-GUI showing the values of the clicked ModelKoie.
	 */
	private void enableDoubleClickOnTable(){
		equipmentTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					ModelKoie tempObject = (ModelKoie) equipmentTable
							.getSelectionModel().getSelectedItem();
					ModelKoie mkoie = DbKoie.getKoie(tempObject.getKoieName());
					KoieEksempel koie = new KoieEksempel();
					try {
						KoieEksempelController.setKoier(mkoie);
						koie.start(primaryStage);

					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		});
	}
	
	
}
