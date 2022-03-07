/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author anwer
 */
public class JavaFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
            Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../GUI/VolInterface.fxml"));
            root = FXMLLoader.load(getClass().getResource("../GUI/BateauxInterface.fxml"));
            root = FXMLLoader.load(getClass().getResource("../GUI/OfferInterface.fxml"));
            //root = FXMLLoader.load(getClass().getResource("../GUI/OfferOptionInterface.fxml"));
            //root = FXMLLoader.load(getClass().getResource("../GUI/VolClientInterface.fxml"));
            root = FXMLLoader.load(getClass().getResource("../GUI/PlaningInterface.fxml"));
            //root = FXMLLoader.load(getClass().getResource("../GUI/BateauxClientInterface.fxml"));
            //root = FXMLLoader.load(getClass().getResource("../GUI/OfferClientInterface.fxml"));
            root = FXMLLoader.load(getClass().getResource("../GUI/AdminInterface.fxml"));
            root = FXMLLoader.load(getClass().getResource("../GUI/UserInterface.fxml"));

            
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass().getResource("..\\css\\style.css").toExternalForm());
            primaryStage.setScene(scene);
            
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(JavaFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
