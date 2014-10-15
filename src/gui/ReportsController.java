package gui;

import java.io.IOException;
import java.util.ArrayList;

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
	
	private String koieNavn,dateFrom,dateTo,dateDel;
	
	public ReportsController(String kn, String df, String dt, String dd){
		this.koieNavn = kn;
		this.dateFrom = df;
		this.dateTo = dt;
		this.dateDel = dd;
	}
	
	private static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReportsController.primaryStage = primaryStage;
	}
	
	@FXML
	private Button back;
	@FXML
	private static TableColumn<ReportsController, String> koie;
	@FXML
	private TableColumn<ReportsController, String> dato;
	@FXML
	private static TableColumn<ReportsController, String> datoFra;
	@FXML
	private static TableColumn<ReportsController, String> datoTil;
	@FXML
	private static TableColumn<ReportsController, String> datoLevert;
	@FXML
	private TableColumn<ReportsController, String> status;
	@FXML
	private static TableView<ReportsController> reportsTable;
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}
	
	@FXML
	public static void fillTable(){
		final ObservableList<ReportsController> test = FXCollections.observableArrayList
		(new ReportsController("koie1","f1","t1","d1"),
		new ReportsController("koie2","f2","t2","d2"),
		new ReportsController("koie3","f3","t3","d3"),
		new ReportsController("koie4","f4","t4","d4"),
		new ReportsController("koie5","f5","t5","d5"),
		new ReportsController("koie6","f6","t6","d6"));
		
		koie.setCellValueFactory(new PropertyValueFactory<ReportsController,String>("koieNavn"));
		datoFra.setCellValueFactory(new PropertyValueFactory<ReportsController,String>("dateFrom"));
		datoTil.setCellValueFactory(new PropertyValueFactory<ReportsController,String>("dateTo"));
		datoLevert.setCellValueFactory(new PropertyValueFactory<ReportsController,String>("dateDel"));
		
		reportsTable.setItems(test);
		
	}
	
	
}
