/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Forget_passwordController implements Initializable {

    @FXML
    private TextField email_text;
    Globals global =new Globals();
    @FXML
    private Button send;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void receive_email(ActionEvent event) {
        try {
            if (global.serviceuser.check_user(email_text.getText())){
                global.user.setEmail_user(email_text.getText());
                global.serviceuser.update_user_information(global.user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/wait_for_ressenting_password_code.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                    send.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("reset password");

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText("invalid email");

		alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forget_passwordController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
        
}
