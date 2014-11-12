
package gui;

import java.io.IOException;
import java.net.URL;
import database.DbKoie;
import model.ModelKoie;
import netscape.javascript.JSObject;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	/**Setting the primarystage to Kart*/
	public static void setPrimaryStage(Stage primaryStage){
		Kart.primaryStage = primaryStage;
	}
    /**Starting Launching the kart*/
    public static void main(String[] args) {
        launch(Kart.class, args);
      
    }
    /** Function that starts the map*/
    @Override
    public void start(Stage stage) {

        /**Creating a new BorderPane*/
        BorderPane border = new BorderPane();
        /**Creating a new group*/
        Group group = addHBox();
       
        
       /**Adding the group to the top of the borderPane */
        border.setTop(group);
        /**Adding the gridPane that has the webview to the center of the borderpane, */
        border.setCenter(addAnchorPane(addGridPane()));
        /**Creating a scene witch innherits from the borderpane */
        Scene scene = new Scene(border);
        /**Evrything is added from right to left*/
        scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
       /**Adding the scene to the stage*/
        stage.setScene(scene);
       /**Showing the stage*/
        stage.show();
    }
    
    
    

   
 
	/**Function that creates the group with button and picture*/
	    private Group addHBox() {
	    /**Creating the group*/	
	    Group group = new Group();
        /**Creating a new HBX*/
        HBox hbox = new HBox();
        /**Hbox layout*/
        hbox.setPadding(new Insets(10, 12, 15, 12));
        hbox.setSpacing(50);   // Gap between nodes

       /**Fetching the image from myWebPage and adding it to a image*/
        Image kartTekst = new Image("http://folk.ntnu.no/ssbolsta/sites/images/PNG.png");
        /**Creating a imageview*/
        ImageView iv2 = new ImageView();
        /**Putting the image in the imageview*/
        iv2.setImage(kartTekst);
        /**Setting the size of the imageview*/
        iv2.setFitHeight(66);
        iv2.setFitWidth(610);
       
    

       
        /**Creating a button and giving it the right size*/
        Button backButton = new Button("Hovedmeny");
        backButton.setPrefSize(100, 20);
        backButton.setLayoutX(50);
        backButton.setLayoutY(233);
        /**Adding a listner that reacts when button is pressed*/
        backButton.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event){
                /**Creating a new main menu stage*/
            	MainMenu backToMenu = new MainMenu();
            	try {
            		/**Starting the new main menu*/
					backToMenu.start(primaryStage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        });
        /**Adding the backbutton and picture to the hbox*/
        hbox.getChildren().addAll(backButton);
        hbox.getChildren().addAll(iv2);

 
        /**Adding the Hboxes to the group*/
        group.getChildren().addAll(hbox);
        /**returning the group*/
        return group;
    }

    private GridPane addGridPane() {
        /**Creating the GridPane and setting max sizes*/
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setMaxWidth(333);
        grid.setMaxHeight(222);
        grid.setPadding(new Insets(0, 10, 0, 10));

        
       /**returning the gridPane*/
        return grid;
    }
    /**Creating the  anchorPane */
    private AnchorPane addAnchorPane(GridPane grid) {
        /**Creating a new webView */
  	    WebView kartet = new WebView();
        /**Setting size of the webView*/
  	    kartet.setMaxHeight(577);

  	    kartet.setMaxWidth(795);
        /**Loading the webEngine, that again loads the webpage from the html file */
        WebEngine webEngine = kartet.getEngine();
        URL urlGoogleMaps = getClass().getResource("map.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        JSObject jsobj = (JSObject) webEngine.executeScript("window");
        jsobj.setMember("java", new Kart());
        /**Creating a new AnchorPane*/
        AnchorPane anchorpane = new AnchorPane();
        
     
        HBox hb = new HBox();
        hb.setPadding(new Insets(0, 10, 10, 10));
        hb.setSpacing(10);
      

        anchorpane.getChildren().addAll(kartet);
        /**Adding the webview to the Anchorpane*/
        AnchorPane.setBottomAnchor(hb, 8.0);
        AnchorPane.setRightAnchor(hb, 5.0);
        AnchorPane.setTopAnchor(grid, 10.0);
        
        /**returning Anchorpane*/
        return anchorpane;
        
    }
    /**Function that sends you to the Koie when the button is pushed*/
    public void toKoie(String koieName) throws IOException{
    	/**Opens the koie with the KoieName that is provided from the html */
    	ModelKoie mkoie = DbKoie.getKoie(koieName);//Getting the selected koie object by using its name
		/**Creates a new koieEksempel*/
        KoieEksempel koie = new KoieEksempel();
		try {
			KoieEksempelController.setKoier(mkoie);
            /**Starting the new KoieEksempel*/
			koie.start(primaryStage);

		} catch (IOException e) {

			e.printStackTrace();
		}
    }
}
