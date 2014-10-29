package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import model.ModelReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReportFormController implements Initializable {
	private static Stage primaryStage;
	private static ModelReports report;
	
	public static void setPrimaryStage(Stage primaryStage){
		ReportFormController.primaryStage = primaryStage;
	}
	
	public static void setReports(ModelReports report){
		ReportFormController.report = report;
	}
	
	@FXML 
	Button back,backToMain;
	
	@FXML
	TextField forgotten,smokeDetector,timeStamp,reportId,woodStatus,koieName;
	
	@FXML
	TextArea reportComment;
	
	@FXML
	ListView<String> defectsList;
	
	
	
	ObservableList<String> data;
	
	@FXML
	public void backToReports(ActionEvent event) throws IOException{
		Reports reports = new Reports();
		reports.start(primaryStage);
	}
	
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException{
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (report != null){
			ArrayList<String> defectList = new ArrayList<String>();
			String tempString = "";
			for (int i = 0; i < report.getDefects().length(); i++){
				char c = report.getDefects().charAt(i);
				if (c == ','){
					defectList.add(tempString);
					tempString = "";
				}
				else if(tempString == ""){
					if (c == ' '){
						continue;
					}
					tempString += c;
					tempString = tempString.toUpperCase();
				}
				else{
					tempString += c;
				}
			}
			data = FXCollections.observableArrayList (defectList);
			defectsList.setItems(data);
			koieName.setText(report.getKoieName());
			woodStatus.setText(String.valueOf(report.getWood()));
			reportId.setText(String.valueOf(report.getReportId()));
			timeStamp.setText(report.getTimeStamp().toString());
			smokeDetector.setText(report.getSmokeDetector() ? "Ja" : "Nei");
			forgotten.setText(report.getForgotten() ? "Nei" : "Ja");
			reportComment.setText(report.getComments());
		}	
	}
}
