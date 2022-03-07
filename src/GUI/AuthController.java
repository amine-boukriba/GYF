/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utils.Globals;
import static utils.Password_hash.getSHA;
import static utils.Password_hash.toHexString;

/**
 * FXML Controller class
 *
 * @author boukr
 */
public class AuthController implements Initializable {

    @FXML
    private Button auth;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Hyperlink forget_password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
    @FXML
    public void authentification(ActionEvent event) {
        String path="../GUI/InterfaceUserAdmin.fxml";
        try {
            Globals global=new Globals();
            int state;
            //get login and password 
            Globals.user.setEmail_user(login.getText());
            try {
                global.user.setPassword(toHexString(getSHA(password.getText())));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Globals.user);
            state=global.serviceuser.sign_in(global.user);
            //check login and password 
            if (state==1){
                //   both login and password are correct and user not blocked
                if ((global.serviceuser.blocked(global.user)==0)&&(global.serviceuser.verfied(global.user)==1)){
                global.serviceuser.update_user_information(global.user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connection");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("Connected successfully!");

		alert.showAndWait();
                global.servicehistoriques.add_session(global.historique);
                global.serviceuser.update_user_information(global.user);
                if (global.user.getId_role()==10){
                    path="../GUI/UserInterface.fxml";
                }
                FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                auth.getScene().setRoot(root);

                }
                else {
                     //   both login and password are correct and user is blocked
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connection");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("your blocked please call adminstrateur");

		alert.showAndWait();
                    
                }
            }
            if (state==0){
                 //   both login  valid and password invalid  
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connection");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid password");

		alert.showAndWait();}
            if (state==-1){
                 //   both login  and password are inccorrect 
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connection");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid login");

		alert.showAndWait();}
        } catch (SQLException ex) {
            Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
        public void registration(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/register.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                auth.getScene().setRoot(root);
            
        }
    @FXML
        public void forget_password(ActionEvent event) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/forget_password.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                auth.getScene().setRoot(root);
            
        }
   
    
}
