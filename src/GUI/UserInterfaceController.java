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
 * @author omarb
 */
public class UserInterfaceController implements Initializable {

    @FXML
    private AnchorPane view;
    @FXML
    private ImageView Exit;
    @FXML
    private JFXButton Eventss;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private JFXButton Events;
    @FXML
    private JFXButton btn_calendar;
    @FXML
    private JFXButton btn_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            view.getChildren().clear();
            
            
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("afficher.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            view.getChildren().add(anchorPane);
        } catch (IOException ex) {
            Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

   


    @FXML
    private void gotoEventss() {
          view.getChildren().clear();
         Eventss.setOnMouseClicked(event -> {
            
          
              try {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("afficher.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();
                  view.getChildren().add(anchorPane);
              } catch (IOException ex) {
                  Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
              }
            
             
             
        });
    }

    @FXML
    private void gotoevents() {
         view.getChildren().clear();
         Events.setOnMouseClicked(event -> {
            
          
              try {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("afficher.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();
                  view.getChildren().add(anchorPane);
              } catch (IOException ex) {
                  Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
              }
            
             
             
        });
    }

    @FXML
    private void gotocalendar() {
            view.getChildren().clear();
         btn_calendar.setOnMouseClicked(event -> {
            
          
              try {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("afficher.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();
                  view.getChildren().add(anchorPane);
              } catch (IOException ex) {
                  Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
              }
            
             
             
        });
    }

    @FXML
    private void searchevents() {
            view.getChildren().clear();
         btn_search.setOnMouseClicked(event -> {
            
          
              try {
                  FXMLLoader fxmlLoader = new FXMLLoader();
                  fxmlLoader.setLocation(getClass().getResource("rechercherEvents.fxml"));
                  AnchorPane anchorPane = fxmlLoader.load();
                  view.getChildren().add(anchorPane);
              } catch (IOException ex) {
                  Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
              }
            
             
             
        });
    }
    
}
