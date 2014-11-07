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
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;

public class KoieEksempelController implements Initializable {
	private static Stage primaryStage;
	private static ModelKoie koie;
	private static ModelEquipmentLists equipment;
	private ModelEquipment equipment1 = null;

	public static void setPrimaryStage(Stage primaryStage) {
		KoieEksempelController.primaryStage = primaryStage;
	}

	public static void setKoier(ModelKoie koie) {
		KoieEksempelController.koie = koie;
	}

	@FXML
	private Button back, backToMain, koiee;
	@FXML
	private Text koieName;
	@FXML
	private TextField beds, wood, dugnad, smoke;
	@FXML
	private TextArea description;
	@FXML
	private ComboBox<String> koieList;
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

	// Method for returning to main menu
	@FXML
	public void backToMainMenu(ActionEvent event) throws IOException {
		MainMenu mm = new MainMenu();
		mm.start(primaryStage);
	}

	// Method for opening a new koie. Further explanation in
	// KoierController.java
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

	// Initializing lists of data to display in tables and choicebox.
	final ObservableList<String> dataKoie = FXCollections
			.observableArrayList(DbKoie.getAllKoieNames());
	final ObservableList<ModelReports> dataReport = FXCollections
			.observableArrayList(DbReports.getReport(koie.getKoieName()));


	// Filling the textboxes, tables and choicebox with sufficient data.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		koieList.setPromptText("Trykk her for å velge annen koie");
		koieList.setItems(dataKoie);
		koieName.setText(koie.getKoieName());
		beds.setText(String.valueOf(koie.getNumberOfBeds()));
		description.setText(koie.getDescription());

		// Displaying different wood status according to the value in the
		// database
		if (koie != null) {
			
			if (koie.getWood() == 1) {
				wood.setText("0-15");
				dugnad.setText("Så fort som mulig");
			} else if (koie.getWood() == 2) {
				wood.setText("15-30");
				dugnad.setText("Ca 3 mnd");
			} else {
				wood.setText("Mer enn 30");
				dugnad.setText("Ca 6 mnd");
			}
			
			if(koie.getSmoke() == 0){
				smoke.setText("Fungerer");
			}
			else{
				smoke.setText("Fungerer ikke");
			}
		}
		
		if (DbReports.getReport(koie.getKoieName()) != null) {
			// Setting cell value factories for the columns
			reportID.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>(
					"reportId"));
			date.setCellValueFactory(new PropertyValueFactory<ModelReports, Date>(
					"timeStamp"));
			status.setCellValueFactory(new PropertyValueFactory<ModelReports, Integer>(
					"status"));

			// Implementing custom cell factory for the status column.
			// Different colour and text for different values in the database
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
						} else {
							setText(null);
						}
					}
				};
			});
			// Pushing values into the tables
			reportsTable.setItems(dataReport);
		}

		

			Image img = new Image(koie.getImage());
			koiePic.setImage(img);
			updateEquipmentTable();
			editEquipmentStatus();

		

	}

	private void editEquipmentStatus() {
		equipmentList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() > 1) {
					
					equipment1 = (ModelEquipment) equipmentList.getSelectionModel().getSelectedItem();
					int initialStatus;
					
					Stage newStage = new Stage();
					VBox comp = new VBox();
					Text nameField = new Text("Vil du endre status på "
							+ equipment1.getEquipment().toLowerCase() + " på "
							+ koie.getKoieName() + "?");
					ComboBox<String> status = new ComboBox<String>();

					equipment1.makeStatusMap();
					if (equipment1.getEquipmentStatus(koie.getKoieName()) == 0) {
						status.setValue("Alt i orden");
						initialStatus = 0;
						status.getItems().addAll("Utstyr i orden",
								"Mangler i utstyr");
					} else {
						initialStatus = 1;
						status.setValue("Mangler i utstyr");
						status.getItems().addAll("Mangler i utstyr",
								"Alt i orden");
					}

					Button save = new Button();
					Button exit = new Button();
					save.setText("Lagre");
					exit.setText("Ikke lagre");
					
					save.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							if (status.getValue() == "Alt i orden" && initialStatus != 0) {
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
								System.out.println("Du har ikke endret utstyr");
							}

						}
					});

					exit.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							newStage.close();
						}
					});

					comp.getChildren().add(nameField);
					comp.getChildren().add(status);
					comp.getChildren().add(save);
					comp.getChildren().add(exit);

					Scene stageScene = new Scene(comp, 400, 300);
					newStage.setScene(stageScene);
					newStage.show();

				}
			}
		});
	}

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
							} else {
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
		
		equipmentList.setItems(dataEquipment);
	}
}
