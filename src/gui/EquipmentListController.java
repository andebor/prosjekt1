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

public class EquipmentListController implements Initializable{
	
	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		EquipmentListController.primaryStage = primaryStage;
	}
	final ObservableList<ModelKoie> data = FXCollections.observableArrayList(DbKoie.getAllKoieStatus());

	@FXML
	TableView<ModelKoie> equipmentTable;
	@FXML
	TableColumn<ModelKoie, String> koie;
	@FXML
	TableColumn<ModelKoie, Integer> wood, status;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateEquipmentTable();
		enableDoubleClickOnTable();
		

	}
	
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
}
