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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class TemplateController implements Initializable {

  
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private AnchorPane view;
       @FXML
    private JFXButton reserv;
            @FXML
    private JFXButton resto;
    @FXML
    private JFXButton restoM;
    @FXML
    private JFXButton Ajout;
    @FXML
    private JFXButton stat;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("AfficheRestaurant.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
      
        slider.setTranslateX(-176);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-176);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }    

    @FXML
    private void gotoReservationAd( ) {
         view.getChildren().clear();
         reserv.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("AfficheReservationRestaurantAdmin.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
                
             
        });

    }
       @FXML
    private void gotoRestaurantAda( ) {
         view.getChildren().clear();
         resto.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("AfficheRestaurant.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
                
             
        });

    }

    @FXML
    private void gotoRestaurantAdaa( ) {
          view.getChildren().clear();
         restoM.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("AfficheRestaurant.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
                
             
        });
    }
     @FXML
    private void gotoRestaurantAjout( ) {
         view.getChildren().clear();
         Ajout.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("AjouterRestaurant.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
                
             
        });
    }
            @FXML
    private void gotostat( ) {
         view.getChildren().clear();
         stat.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("StatRestauReservation.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
             }
                
             
        });
    
    }
       @FXML
    private void gotohotel(ActionEvent event ) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/TemplateHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
    }

