package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import database.DbEquipmentList;
import database.DbKoie;
import database.DbReports;
import model.ModelEquipment;
import model.ModelKoie;
import model.ModelReports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * Class for controlling the content of the KoieEksempel-GUI
 *
 */

public class KoieEksempelController implements Initializable {
	private static Stage primaryStage;
	private static ModelKoie koie;
	private ModelEquipment equipment1 = null;
	
	/**
	 * Method for setting the primaryStage field
	 * @param primaryStage The stage window
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		KoieEksempelController.primaryStage = primaryStage;
	}
	
	/**
	 * Method for setting the ModelKoie field
	 * @param koie the ModelKoie object we want to set
	 */
	public static void setKoier(ModelKoie koie) {
		KoieEksempelController.koie = koie;
	}
	//Declaring fields from the FXML-file
	@FXML
	private Text koieName;
	@FXML
	private Button saveWood,saveForgotten;
	@FXML
	private TextField beds, dugnad, smoke;
	@FXML
	private TextArea description;
	@FXML
	private ComboBox<String> koieList,wood,forgotten;
	@FXML
	private Text errorMessage;
	@FXML
	private TableView<ModelReports> reportsTable;
	@FXML
	private TableColumn<ModelReports, Date> date;
	@FXML
	private TableColumn<ModelReports, Integer> status, reportID;
	@FXML
	private TableView<ModelEquipment> equipmentList;
	@FXML
	private TableColumn<ModelEquipment, String> equipments;
	@FXML
	private TableColumn<ModelEquipment, Integer> equipmentstatus;
	@FXML
	private ImageView koiePic;

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
	 * Method for opening the KoieEksempel-GUI. Makes a ModelKoie object from the selected koie name in the checkbox
	 * by using DbKoie.getKoie(koieName). Shows an error message in the GUI if no koie is selected.
	 * @param event The event of the button(Button click)
	 * @throws IOException If an input or output exception occurred
	 */
	@FXML
	public void toKoie(ActionEvent event) throws IOException {
		if (koieList.getValue() != null) {
			ModelKoie mkoie = DbKoie.getKoie(koieList.getValue());
			KoieEksempel koie = new KoieEksempel();
			try {
				KoieEksempelController.setKoier(mkoie);
				koie.start(primaryStage);

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			errorMessage.setVisible(true);
		}
	}

	/**
	 *  Initializing list of data to display in choicebox. Using DbKoie.getAllKoieNames() to retrieve the koie names
	 */
	final ObservableList<String> dataKoie = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	/**
	 *  Initializing list of data to display in reportsTable. Using DbReports.getReports(koieName)
	 *   to retrieve all reports on that koie name
	 */
	final ObservableList<ModelReports> dataReport = FXCollections
			.observableArrayList(DbReports.getReports(koie.getKoieName()));
	


	/**
	 * Filling the textboxes, tables and choiceboxes with sufficient data. Calls methods that updates and fills in tables.
	 */ 
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		koieList.setPromptText("Trykk her for å velge annen koie");
		koieList.setItems(dataKoie);
		if (koie != null){
			koieName.setText(koie.getKoieName());
			beds.setText(String.valueOf(koie.getNumberOfBeds()));
			description.setText(koie.getDescription());

			
			if(koie.getSmoke() == 0){
				smoke.setText("Fungerer ikke");
			}
			else{
				smoke.setText("Fungerer");
			}
			
			Image img = new Image(koie.getImage());
			koiePic.setImage(img);
			//Update functions
			updateWoodStatus();
			updateForgotten();
			updateEquipmentTable();
			editEquipmentStatus();
			openReport();
			updateReportsTable();

		}
		
		

	}
	/**
	 * Method for displaying the wood status and changing the display values in the wood checkbox and dugnad textbox
	 * Showing the save button when wood checkbox is clicked. 
	 */
	private void updateWoodStatus(){
	
		
			
			wood.getItems().addAll("0-15","15-30","Mer enn 30");	
			if (koie.getWood() == 1) {
				wood.setValue("0-15");
				dugnad.setText("Så fort som mulig");
			} else if (koie.getWood() == 2) {
				wood.setValue("15-30");
				dugnad.setText("Ca 3 mnd");
			} else {
				wood.setValue("Mer enn 30");
				dugnad.setText("Ca 6 mnd");
			}
			wood.setOnAction((event) ->{
				saveWood.setOpacity(100);
				saveWood.setDisable(false);
			});
			
					
	}
	/**
	 * Method for updating the status of forgotten in the koie displayed in the GUI. Changing value of the forgotten
	 * checkbox will show a save button. 
	 */
	
	private void updateForgotten(){
		forgotten.getItems().addAll("Ikke gjenglemt","Gjenglemt");
		if(koie.getForgotten() == 0){
			forgotten.setValue("Ikke gjenglemt");
		}
		else{
			forgotten.setValue("Gjenglemt");
		}
		
		forgotten.setOnAction((event)->{
			saveForgotten.setOpacity(100);
			saveForgotten.setDisable(false);
		});
	}
	
	/**
	 * Method declaring a EventHandler that executes when a row in the equipment table is double clicked.
	 * The event opens a prompt that gives opportunity to change the status of the double clicked equipment in
	 * the equipment table.
	 */
	private void editEquipmentStatus() {
		equipmentList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					
					equipment1 = (ModelEquipment) equipmentList.getSelectionModel().getSelectedItem();
					
					
					Stage newStage = new Stage();
					AnchorPane comp = new AnchorPane();
					Text nameField = new Text("Vil du endre status på "
							+ equipment1.getEquipment().toLowerCase() + " på "
							+ koie.getKoieName() + "?");
					ComboBox<String> status = new ComboBox<String>();
					int initialStatus;
					equipment1.makeStatusMap();
					if (equipment1.getEquipmentStatus(koie.getKoieName()) == 0) {
						status.setValue("Utstyr i orden");
						initialStatus = 0;
						status.getItems().addAll("Utstyr i orden",
								"Mangler i utstyr");
					} else {
						initialStatus = 1;
						status.setValue("Mangler i utstyr");
						status.getItems().addAll("Mangler i utstyr",
								"Utstyr i orden");
					}

					Button save = new Button();
					Button exit = new Button();
					save.setText("Lagre");
					exit.setText("Ikke lagre");
					Text error = new Text("Du har ikke endret på noe!");
					
					save.setOnAction(new EventHandler<ActionEvent>() {
						/**
						 * Method that closes the prompt and returns to the KoieEksempel-GUI if the value in the checkbox
						 * is different from the original value. A error message will show up otherwise.
						 * Updates the equipment table in the GUI and in the database since the initialize-method will be
						 * executed when the start method is called.
						 */
						@Override
						public void handle(ActionEvent event) {
							if (status.getValue() == "Utstyr i orden" && initialStatus != 0) {
								DbEquipmentList.updateEquipment(equipment1.getEquipment(), 0,koie.getKoieName());
								newStage.close();
								KoieEksempel koien = new KoieEksempel();
								try {
									KoieEksempelController.setKoier(koie);
									koien.start(primaryStage);

								} catch (IOException e) {

									e.printStackTrace();
								}
							} else if (status.getValue().equals("Mangler i utstyr") && initialStatus != 1) {
								DbEquipmentList.updateEquipment(equipment1.getEquipment(), 1,koie.getKoieName());
								newStage.close();
								
								KoieEksempel koien = new KoieEksempel();
								try {
									KoieEksempelController.setKoier(koie);
									koien.start(primaryStage);

								} catch (IOException e) {

									e.printStackTrace();
								}
							} else {
								error.setVisible(true);
						
							}

						}
					});

					exit.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							newStage.close();
						}
					});
					
					
					
					
					nameField.setX(40);
					nameField.setY(50);
					status.setLayoutX(135);
					status.setLayoutY(80);
					save.setLayoutX(120);
					save.setLayoutY(140);
					exit.setLayoutX(230);
					exit.setLayoutY(140);
					error.setFill(Color.RED);
					error.setLayoutX(50);
					error.setLayoutY(190);
					error.setVisible(false);
					

					comp.getChildren().add(nameField);
					comp.getChildren().add(status);
					comp.getChildren().add(save);
					comp.getChildren().add(exit);
					comp.getChildren().add(error);

					Scene stageScene = new Scene(comp, 400, 200);
					newStage.setScene(stageScene);
					newStage.show();
					
				}
			}
		});
	}
	
	/**
	 * Implements a double click event on reportstable. When a row is double clicked,
	 *  the content of the row (a ModelReports object) will open in the ReportForm gui.
	 * 
	 */
	private void openReport(){
		reportsTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					ModelReports report = (ModelReports) reportsTable
							.getSelectionModel().getSelectedItem();
					ReportForm rf = new ReportForm();
					try {
						ReportFormController.setReports(report);
						rf.start(primaryStage);
						
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}
			}
		});

	}
	/**
	 * Method that defines the data types to be displayed in the equipment table. 
	 * The status column has a CellValueFactory-method so that we are able to display different text and colours 
	 * according to the status we get from the database. Adds data to the table view
	 * 
	 * 
	 *  Updates the database on three conditions; 0: All equipment is good and nothing is forgotten, 1: All equipment 
	 * is good, but something is forgotten, 2: Defects in equipment and something might be forgotten 
	 * (You can see if something is forgotten when going to the actual koie in the GUI).
	 */
	private void updateEquipmentTable() {
		final ObservableList<ModelEquipment> dataEquipment = FXCollections
				.observableArrayList(DbEquipmentList.getEquipment());
		if (DbEquipmentList.getEquipment() != null) {
			
			equipments
					.setCellValueFactory(new PropertyValueFactory<ModelEquipment, String>(
							"equipment"));
			equipmentstatus
					.setCellValueFactory(new PropertyValueFactory<ModelEquipment, Integer>(
							koie.getKoieName()));
			
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
							}
							else{
									setStyle("-fx-background-color: lightsalmon");
									setText("Mangler i utstyr");
								}
								
							
						} else {
							setText(null);
						}
					}
				};

			});
		}
	
		boolean allGood = true;
		for(int i : DbEquipmentList.getEquipmentStatus(koie.getKoieName())){
			if (i == 1){
				allGood = false;
			}
		}
		if(allGood && koie.getForgotten() == 0){
			DbEquipmentList.updateEquipment("status",0,koie.getKoieName());
			
		}
		else if (allGood && koie.getForgotten() == 1){
			DbEquipmentList.updateEquipment("status", 1,koie.getKoieName());
			
		}
		else{
			DbEquipmentList.updateEquipment("status", 2,koie.getKoieName());
			
		}
			
		
	
			
		
		
		equipmentList.setItems(dataEquipment);
	}
	
/**
 * Method that defines the data types to be displayed in the reports table.
 *  The status column has a CellValueFactory-method so that we are able to display
 *   different text and colours according to the status we get from the database. 
 */
	public void updateReportsTable(){
		if (DbReports.getReport(koie.getKoieName()) != null) {
			// Setting cell value factories for the columns
			reportID.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>(
					"reportId"));
			date.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>(
					"timeStamp"));
			status.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>(
					"status"));

			
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
								setText("Mangler i utstyr");
							} else {
								setStyle("-fx-background-color: khaki");
								setText("Gjenglemt");
							}
						} else {
							setText(null);
						}
					}
				};
			});
			// Pushing values into the tables
			reportsTable.setItems(dataReport);
		}
	}
	/**
	 * Method for the save wood status button. Will update the equipment in the database and
	 * the current ModelKoie object when button is clicked and something is changed from the original
	 * ModelKoie-status.  
	 * 
	 */
	@FXML
	public void saveWoodStatus(){
		if(wood.getValue() == "0-15" && koie.getWood() != 1) {
			saveWood.setOpacity(0);
			saveWood.setDisable(true);
			DbEquipmentList.updateEquipment("wood", 1, koie.getKoieName());
			dugnad.setText("Så fort som mulig");
			koie.setWood(1);
		}
		else if(wood.getValue() == "15-30" && koie.getWood() != 2){
			saveWood.setOpacity(0);
			saveWood.setDisable(true);
			DbEquipmentList.updateEquipment("wood", 2, koie.getKoieName());
			dugnad.setText("Ca 3 mnd");
			koie.setWood(2);
		}
		else if(wood.getValue() == "Mer enn 30" && koie.getWood() != 3){
			saveWood.setOpacity(0);
			saveWood.setDisable(true);
			DbEquipmentList.updateEquipment("wood", 3, koie.getKoieName());
			dugnad.setText("Ca 6 mnd");
			koie.setWood(3);
		}
		else{
			saveWood.setOpacity(0);
			saveWood.setDisable(true);
		}
		
	}
	
	/**
	 * Method for the save forgotten status button. Will update the equipment in the database and
	 * the current ModelKoie object when button is clicked and something is changed from the original
	 * ModelKoie-status. 
	 * 
	 */
	
	@FXML
	public void saveForgottenStatus(){
		if(forgotten.getValue() == "Ikke gjenglemt" && koie.getForgotten() != 0){
			saveForgotten.setOpacity(0);
			saveForgotten.setDisable(true);
			DbEquipmentList.updateEquipment("forgotten", 0, koie.getKoieName());
			koie.setForgotten(0);
			updateEquipmentTable();
		}
		else if(forgotten.getValue() == "Gjenglemt" && koie.getForgotten() != 1){
			saveForgotten.setOpacity(0);
			saveForgotten.setDisable(true);
			DbEquipmentList.updateEquipment("forgotten", 1, koie.getKoieName());
			koie.setForgotten(1);
			updateEquipmentTable();
		}
		else{
			saveForgotten.setOpacity(0);
			saveForgotten.setDisable(true);
		}
	}
}
