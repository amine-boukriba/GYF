/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class UserInterfaceController implements Initializable {

    @FXML
    private ImageView Exit;
    @FXML
    private JFXButton mesreservations;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    
    @FXML
    private JFXButton monument;
    @FXML
    private JFXButton espace;
    @FXML
    private AnchorPane view;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gotomesreserv() {
        view.getChildren().clear();
         mesreservations.setOnMouseClicked(event -> {
             
            
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MesReservation.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
             
                
             
        });
    }

   

    @FXML
    private void gotomonument() {
        view.getChildren().clear();
         monument.setOnMouseClicked(event -> {
             
            
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ClientMonuments.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
             
                
             
        });
    }

    @FXML
    private void gotoespace() {
        view.getChildren().clear();
         espace.setOnMouseClicked(event -> {
             
            
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ClientEspaceCulturels.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
             
                
             
        });
    }
    
}
