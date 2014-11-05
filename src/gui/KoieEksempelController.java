package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import database.DbEquipmentList;
import database.DbKoie;
import database.DbReports;
import model.ModelEquipment;
import model.ModelEquipmentLists;
import model.ModelKoie;
import model.ModelReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KoieEksempelController implements Initializable {
	private static Stage primaryStage;
	private static ModelKoie koie;
	private static ModelEquipmentLists equipment;
	
	public static void setPrimaryStage(Stage primaryStage){
		KoieEksempelController.primaryStage = primaryStage;
	}
	
	public static void setKoier(ModelKoie koie){
		KoieEksempelController.koie = koie;
	}
	
	@FXML 
	Button back, backToMain, koiee;
	@FXML
	Text koieName;
	@FXML
	TextField beds, wood, dugnad;
	@FXML
	TextArea description;
	@FXML
	private ChoiceBox<String> koieList;
	@FXML
	private Text errorMessage;
	@FXML
	TableView<ModelReports> reportsTable;
	@FXML
	TableColumn<ModelReports, Date> date;
	@FXML
	TableColumn<ModelReports, Integer> status, reportID;
	@FXML
	TableView<ModelEquipment> equipmentList;
	@FXML
	TableColumn<ModelEquipment, String> equipments;
	@FXML
	TableColumn<ModelEquipment, Integer> equipmentstatus;
	
	@FXML
	public void back(ActionEvent event) throws IOException{
		Koier koie = new Koier();
		koie.start(primaryStage);
	}
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	@FXML
	public void toKoie(ActionEvent event)throws IOException{
		if(koieList.getValue() != null){
		ModelKoie mkoie = DbKoie.getKoie(koieList.getValue());
		KoieEksempel koie = new KoieEksempel();
		try {
			KoieEksempelController.setKoier(mkoie);
			koie.start(primaryStage);

		} catch (IOException e) {

			e.printStackTrace();
		}
		}
		else{
			errorMessage.setVisible(true);
		}
	}

	final ObservableList<String> dataKoie = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	final ObservableList<ModelReports> dataReport = FXCollections
			.observableArrayList(DbReports.getReport(koie.getKoieName()));
	final ObservableList<ModelEquipment> dataEquipment = FXCollections
			.observableArrayList(DbEquipmentList.getEquipment());
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		koieList.setItems(dataKoie);
		koieName.setText(koie.getKoieName());
		beds.setText(String.valueOf(koie.getNumberOfBeds()));
		description.setText(koie.getDescription());
		if(DbEquipmentList.getEquipmentList(koie.getKoieName()) != null){
			equipment = DbEquipmentList.getEquipmentList(koie.getKoieName());
			if(equipment.getWood() == 1){
				wood.setText("0-15");
			}
			else if(equipment.getWood() == 2){
				wood.setText("15-30");
			}
			else{
				wood.setText("Mer enn 30");
			}
		}
		if(DbEquipmentList.getEquipmentList(koie.getKoieName()) != null){
			equipment = DbEquipmentList.getEquipmentList(koie.getKoieName());
			if(equipment.getWood() == 1){
				dugnad.setText("S� fort som mulig");
			}
			else if(equipment.getWood() == 2){
				dugnad.setText("Ca 3 mnd");
			}
			else{
				dugnad.setText("Ca 6 mnd");
			}
		}
		
		if(DbReports.getReport(koie.getKoieName()) != null){
		reportID.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>("reportId"));
		date.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>("timeStamp"));
		status.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>("status"));	

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
							setText("Mangler");
						} else {
							setStyle("-fx-background-color: khaki");
							setText("Gjenglemt");
						}
					}
					else {
						setText(null);
					}
				}
			};

		});
		}
		reportsTable.setItems(dataReport);
		
		if(!DbEquipmentList.getEquipment().contains("status")){
		equipments.setCellValueFactory(new PropertyValueFactory<ModelEquipment, String>("equipment"));	
		equipmentstatus.setCellValueFactory(new PropertyValueFactory<ModelEquipment, Integer>(koie.getKoieName()));
		
		equipmentstatus.setCellFactory(column -> {
			return new TableCell<ModelEquipment, Integer>() {
				@Override
				protected void updateItem(Integer item, boolean empty) {
					super.updateItem(item, empty);

					if (!empty) {
						setTextFill(Paint.valueOf("black"));
						if (item == 0) {
							setStyle("-fx-background-color: lightgreen");
							setText("Utstyr i orden");
						} else {
							setStyle("-fx-background-color: lightsalmon");
							setText("Mangler utstyr");
						} 
					}
					else {
						setText(null);
					}
				}
			};

		});
		
		
		equipmentList.setItems(dataEquipment);
		}
		
	}

}
