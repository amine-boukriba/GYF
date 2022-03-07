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
public class Wait_for_ressenting_password_codeController implements Initializable {

    @FXML
    private TextField code_user;
    @FXML
    private Button confirm;
    Globals global=new Globals();
    String code;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               code=global.serviceuser.send_verification_code(global.user.getEmail_user(),"rest password"); 

    }    

    @FXML
    private void confirm_code(ActionEvent event) {
         if (code.equals(code_user.getText()))
         {   
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("reset");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("you can now change your password");

		alert.showAndWait();
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
		alert.setTitle("reset");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid code please re enter your code ");

		alert.showAndWait();
     
         }
         }
    
}
