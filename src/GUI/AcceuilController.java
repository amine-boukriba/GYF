/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import utils.Globals;

/**
 * FXML Controller class
 *
 * @author boukr
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button show_users;
    Globals global=new Globals();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void goto_modification(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/modfier_user.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                show_users.getScene().setRoot(root);
        
    }
        public void goto_show_historiques(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/affiche_historiques.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                show_users.getScene().setRoot(root);
        
    }
            public void goto_change_password(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/change_password.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                show_users.getScene().setRoot(root);
        
    }
            
    public void SIGN_OUT (ActionEvent event) {
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
                show_users.getScene().setRoot(root);
        
    }
     public void goto_show_users(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/setuser.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                show_users.getScene().setRoot(root);
        
    }

    
}
