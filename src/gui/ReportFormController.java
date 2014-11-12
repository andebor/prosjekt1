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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReportFormController implements Initializable {
	private static Stage primaryStage;
	private static ModelReports report;

	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */

	public static void setPrimaryStage(Stage primaryStage) {
		ReportFormController.primaryStage = primaryStage;
	}
	/**
	 * 
	 * Method for setting the current report to be showed in the GUI view
	 *
	 * @param report A ModelReports object
	 */
	public static void setReports(ModelReports report) {
		ReportFormController.report = report;
	}
	
	//Declaring fields from the FXML-file
	@FXML
	TextField forgotten, smokeDetector, timeStamp, reportId, woodStatus, koieName;
	@FXML
	TextArea reportComment;
	@FXML
	ListView<String> defectsList;

	ObservableList<String> data;
	
	/**
	 * Method for going back to the Reports-GUI
	 * @param event 
	 * @throws IOException If an input or output exception occurred
	 */

	@FXML
	public void backToReports(ActionEvent event) throws IOException {
		Reports reports = new Reports();
		reports.start(primaryStage);
	}
	
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
	 * The initialize method that is called automatically. 
	 * Calling method for filling in textfields and listviews in this method
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		updateReport();
	}
	
	/**
	 * 
	 * Method for filling in sufficient data to the text fields. All values are taken from the
	 * ModelReports object. Since defects are represented with a string  and separates the defects
	 * with a comma in the database table, we need to convert it to a ArrayList to get it in to 
	 * the ListView. This is done by generating a substring that is added to the ArrayList when
	 *  the next character is a comma. Some of the textfields have multiple showings, determined by the
	 *  value of the fields in ModelReports.
	 */
	private void updateReport() {
		if (report != null) {
			ArrayList<String> defectList = new ArrayList<String>();
			String tempString = "";
			for (int i = 0; i < report.getDefects().length(); i++) {
				char c = report.getDefects().charAt(i);
				if (c == ',' || i == report.getDefects().length() -1) {
					if(c != ','){
						tempString += c;
					}
					defectList.add(tempString);
					tempString = "";
				} else if (tempString == "") {
					if (c == ' ') {
						continue;
					}
					tempString += c;
					tempString = tempString.toUpperCase();
				} else {
					tempString += c;
				}
			}
			data = FXCollections.observableArrayList(defectList);
			defectsList.setItems(data);
			koieName.setText(report.getKoieName());
			if (report.getWood() == 1) {
				woodStatus.setText("0-15");
			} else if (report.getWood() == 2) {
				woodStatus.setText("15-30");
			} else {
				woodStatus.setText("Mer enn 30");
			}
			reportId.setText(String.valueOf(report.getReportId()));
			timeStamp.setText(report.getTimeStamp().toString());
			smokeDetector.setText(report.getSmokeDetector() ? "Ja" : "Nei");
			forgotten.setText(report.getForgotten() ? "Ja" : "Nei");
			reportComment.setText(report.getComments());
		}
	}
}
