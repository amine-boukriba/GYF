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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class AdminInterfaceController implements Initializable {

    @FXML
    private ImageView Exit;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private JFXButton btn_vols;
    @FXML
    private JFXButton btn_bateaux;
    @FXML
    private JFXButton btn_offers;
    @FXML
    private JFXButton btn_voyage;
    @FXML
    private AnchorPane view;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
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
    private void getVol() {
        view.getChildren().clear();
         btn_vols.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("VolInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });

    }

    @FXML
    private void getBateau() {
        view.getChildren().clear();
        btn_bateaux.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("BateauxInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }

    @FXML
    private void getOffer() {
        view.getChildren().clear();
        btn_offers.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }

    @FXML
    private void getInterface() {
        view.getChildren().clear();
         btn_voyage.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("VolInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }
    
}
