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
 * @author boukr
 */
public class InterfaceUserAdminController implements Initializable {

    @FXML
    private ImageView Exit;
    @FXML
    private Label Menu;
    @FXML
    private Label MenuClose;
    @FXML
    private AnchorPane slider;
    @FXML
    private AnchorPane view;
    @FXML
    private JFXButton affiche_users;
    @FXML
    private JFXButton Profil;
    @FXML
    private JFXButton historiques;
    @FXML
    private JFXButton modifider;
    @FXML
    private JFXButton btn_sign_out;
    Globals global=new Globals();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void getHistoriques() {
        view.getChildren().clear();
         historiques.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("affiche_historiques.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
    }

    @FXML
    private void get_change_user() {
        view.getChildren().clear();
         modifider.setOnMouseClicked(event -> {
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
    private void get_users() {
         view.getChildren().clear();
         affiche_users.setOnMouseClicked(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("setuser.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                view.getChildren().add(anchorPane);
            } catch (IOException ex) {
                Logger.getLogger(InterfaceUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
         });
    }

    @FXML
    private void sign_out(ActionEvent event) {
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
                affiche_users.getScene().setRoot(root);
    }

    
    
}
