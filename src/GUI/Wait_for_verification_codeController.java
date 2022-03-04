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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.Globals;

/**
 * FXML Controller class
 *
 * @author boukr
 */
public class Wait_for_verification_codeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Globals global =new Globals();
    public String code; 
    @FXML
    private Button confirm;
    @FXML
    private TextField code_user;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       code=global.serviceuser.send_verification_code(global.user.getEmail_user(),"verification"); 
    }    
     public void confirm_code(ActionEvent event) {
         if (global.user.getVerification()==0){
         if (code.equals(code_user.getText()))
         {   
                global.servicehistoriques.add_session(global.historique);
                global.user.setVerification(1);
                global.serviceuser.modifier(global.user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("verification");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("congrats your account is verified");

		alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/acceuil.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                confirm.getScene().setRoot(root);
         }
         else {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("verification");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid code please re enter your code ");

		alert.showAndWait();
             
         
         }
         }
         else{
             if (code.equals(code_user.getText()))
         {   
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/change_password.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                confirm.getScene().setRoot(root);
         }
         else {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("resetting password");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid code please re enter your code ");

		alert.showAndWait();
             
         
         }
         
         
         }
        }
    
}
