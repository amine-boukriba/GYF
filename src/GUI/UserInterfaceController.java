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
 * @author omarb
 */
public class UserInterfaceController implements Initializable {

    @FXML
    private AnchorPane view;
    @FXML
    private ImageView exit;
    @FXML
    private JFXButton hotel3;
    @FXML
    private JFXButton Ajout;
    @FXML
    private JFXButton stat;
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
