package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.ModelReports;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	TextArea defects, reportComment;
	
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
			koieName.setText(report.getKoieName());
			woodStatus.setText(String.valueOf(report.getWood()));
			reportId.setText(String.valueOf(report.getReportId()));
			defects.setText(report.getDefects());
			System.out.println(report.getDefects());
			timeStamp.setText(report.getTimeStamp().toString());
			smokeDetector.setText(report.getSmokeDetector() ? "Ja" : "Nei");
			forgotten.setText(report.getForgotten() ? "Nei" : "Ja");
			reportComment.setText(report.getComments());

			
			
		}
		
		
	}

	
	
	

}
