/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author omarb
 */
public class NewFXMain extends Application {
    double x,y=0;
    @Override
    public void start(Stage primaryStage) {
  try {
      
        
            primaryStage.setResizable(false);
   //Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheReservationRestoClient.fxml"));

           //Parent root = FXMLLoader.load(getClass().getResource("../GUI/StatRestauReservation.fxml"));
             Parent root = FXMLLoader.load(getClass().getResource("../GUI/Template.fxml"));
 //Parent root = FXMLLoader.load(getClass().getResource("../GUI/userInterface.fxml"));
           Label lb1_size = new Label();
            Scene scene = new Scene(root);
            
            primaryStage.setScene(scene);
            primaryStage.show();
                    scene.getStylesheets().add("..GUI/styles.css");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
 /*public void start(Stage primaryStage) throws Exception{
     //  Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheHotelClient.fxml"));

            Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutReservationClientHotel.fxml"));
         //  Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficheHotel.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);
        });

        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
        
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
