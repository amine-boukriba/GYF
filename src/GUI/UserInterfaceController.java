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

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import utils.Globals;


/**
 * FXML Controller class
 *
 * @author anwer
 */
public class UserInterfaceController implements Initializable {

    static UserInterfaceController userinterface;
    @FXML
    public AnchorPane view;
    @FXML
    private ImageView Exit;

    @FXML
    private JFXButton hotel3;
    @FXML
    private JFXButton Ajout;
    @FXML
    private JFXButton stat;
    @FXML

    private JFXButton btn_vol;
    @FXML

    private JFXButton hotel;
    @FXML
    private JFXButton hotel1;
    @FXML
    private JFXButton hotel2;
    @FXML
    private JFXButton profil;
    @FXML
    private JFXButton changePassword;
    @FXML

    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML

    private JFXButton btn_bateau;
    @FXML
    private JFXButton btn_offer;
    @FXML
    private JFXButton btn_plan;
    @FXML
    private JFXButton btn_vols;

    private JFXButton restoM;
    @FXML
    private JFXButton sign_out;
    Globals global=new Globals();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userinterface=this;
    }    

    @FXML
    private void gotoHotelad(ActionEvent event) {
    }

    @FXML
    private void gotoHotelAjout(ActionEvent event) {
    }

    @FXML
    private void gotostat(ActionEvent event) {
    }

    @FXML
    private void getVols() {
        view.getChildren().clear();
         btn_vols.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("VolClientInterface.fxml"));
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
         btn_bateau.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("BateauxClientInterface.fxml"));
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
         btn_offer.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferClientInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }

    @FXML
    private void getPlan() {
        view.getChildren().clear();
         btn_plan.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("PlaningInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }

    @FXML
    private void getVolsinterface() {
        
         view.getChildren().clear();
         btn_vol.setOnMouseClicked(event -> {
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("VolClientInterface.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 view.getChildren().add(anchorPane);
             } catch (IOException ex) {
                 Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
=======
    private void change_data() {
        view.getChildren().clear();
         profil.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("modfier_user.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
    }

    @FXML
    private void GoToChangePassword() {
        view.getChildren().clear();
         changePassword.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("change_password.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
    }

    @FXML
    private void gotorestaurant(ActionEvent event) {
    }

    @FXML
    private void gotosignout() {
        global.serviceuser.sign_out(global.user,global.historique);
        global.user=null;
        global.historique=null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/auth.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                restoM.getScene().setRoot(root);

    }
    
}
