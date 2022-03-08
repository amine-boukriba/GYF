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

 */
public class TemplateController implements Initializable {

    @FXML
    private ImageView Exit;
    @FXML
    private JFXButton listemonument;
    @FXML
    private JFXButton statistique;

    private JFXButton repondre;
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

    private JFXButton reclamation;
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
    private void gotostatistique() {
        view.getChildren().clear();
         statistique.setOnMouseClicked(event -> {
             
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EspaceAdmin.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
                
             
        });
        
    }

    @FXML
    private void gotoMonument() {
        view.getChildren().clear();
         monument.setOnMouseClicked(event -> {
             
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("MonumentAdmin.fxml"));

      @FXML
    private void gotoreclamation() {
        view.getChildren().clear();
         reclamation.setOnMouseClicked(event -> {
             
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("gestionreclamationadmin.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
                
             
        });
    }

    @FXML
    private void gotoEspace() {
        view.getChildren().clear();
         espace.setOnMouseClicked(event -> {
             
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EspaceCulturels.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
                
             
        });
    }
    
    

        });

    }
    
}
