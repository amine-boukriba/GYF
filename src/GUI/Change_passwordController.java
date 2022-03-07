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
public class Change_passwordController implements Initializable {

    @FXML
    private TextField password;
    @FXML
    private Button submit;
    @FXML
    private TextField confirm_password;
    Globals global=new Globals();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void reset_password(ActionEvent event) {
         if (password.getText().equals(confirm_password.getText())){
             global.serviceuser.reset_password(global.user.getEmail_user(), password.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/acceuil.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                password.getScene().setRoot(root);
         }
         else
         {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("resetting password");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("passwords dont match");

		alert.showAndWait();
         }
        }
     

}
