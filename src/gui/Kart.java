
package gui;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;



public class Kart extends Application {
	public static Stage primaryStage;
	
	public static void setPrimaryStage(Stage primaryStage){
		Kart.primaryStage = primaryStage;
	}

    public static void main(String[] args) {
        launch(Kart.class, args);
    }
    
    @Override
    public void start(Stage stage) {

// Use a border pane as the root for scene
        BorderPane border = new BorderPane();
        
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setCenter(addAnchorPane(addGridPane()));

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle("Koie Kart");
        stage.show();
    }

   

   
	
	    private HBox addHBox() {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 15, 12));
        hbox.setSpacing(50);   // Gap between nodes
        

        Button backButton = new Button("Hovedmeny");
        backButton.setPrefSize(100, 20);
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event){
            	MainMenu backToMenu = new MainMenu();
            	try {
            		
					backToMenu.start(primaryStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        });
        hbox.getChildren().addAll(backButton);
        
        return hbox;
    }

    private GridPane addGridPane() {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        // Category in column 2, row 1
       
        return grid;
    }

    private AnchorPane addAnchorPane(GridPane grid) {
  	    WebView kartet = new WebView();
        WebEngine webEngine = kartet.getEngine();
        URL urlGoogleMaps = getClass().getResource("map.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
           
        AnchorPane anchorpane = new AnchorPane();
        
     
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
      

        anchorpane.getChildren().addAll(kartet);
        // Anchor buttons to bottom right, anchor grid to top
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);

        return anchorpane;
    }
}
