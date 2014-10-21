package gui;

import java.io.IOException;
import java.util.Map;

import model.ModelReports;
import database.DbReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ReportsController {
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReportsController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	private static TableView<ModelReports> reportsTable;
	@FXML
	private static TableColumn<ModelReports, String> koie,date,from,to,dateDelivered,status;
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	private final static ObservableList<ModelReports> data = FXCollections.observableArrayList(DbReports.getReports());
	
	public static void fillReportsTable(){
		reportsTable.setEditable(true);
		koie.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,String>("koie_name"));
		from.setCellValueFactory(
				new PropertyValueFactory<ModelReports,String>("startdate"));
		to.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,String>("enddate"));
		dateDelivered.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,String>("enddate"));
		status.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,String>("status"));
		
		reportsTable.setItems(data);
	}
	
	
	
	
	
	
	
}
