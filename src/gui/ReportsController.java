package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Map;
import java.util.ResourceBundle;

import model.ModelReports;
import database.DbReports;
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

public class ReportsController implements Initializable {
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReportsController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	TableView<ModelReports> reportsTable;
	@FXML
	TableColumn<ModelReports, String> koie;
	@FXML
	TableColumn<ModelReports,Date> date,from,to,dateDelivered;
	@FXML
	TableColumn<ModelReports,Boolean> status;
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	final ObservableList<ModelReports> data = FXCollections.observableArrayList(DbReports.getReports());
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		koie.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,String>("koieName"));
		from.setCellValueFactory(
				new PropertyValueFactory<ModelReports,Date>("startDate"));
		to.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,Date>("endDate"));
		dateDelivered.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,Date>("timeStamp"));
		status.setCellValueFactory(
			    new PropertyValueFactory<ModelReports,Boolean>("status"));
		
		reportsTable.setItems(data);
		
	}
	
	
	
	
	
	
	
}
