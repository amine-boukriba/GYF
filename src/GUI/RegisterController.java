/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
public class RegisterController implements Initializable {

    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private TextField pays;
    @FXML
    private TextField ville;
    @FXML
    private TextField zip;
    ObservableList<String> langs = FXCollections.observableArrayList("male","female");
    @FXML
    private ChoiceBox<String> sexe ;
    @FXML
    private Button registre;
    @FXML
    private DatePicker date_de_naissance;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirm_password;
    Globals global=new Globals();
    /**
    boolean isInteger = Pattern.matches("^\\d*$",first_name.getText());
        boolean isemail = Pattern.matches("^(.+)@(.+)$",first_name.getText());
       boolean isAlphabet = first_name.getText().matches("[a-zA-Z]+");
*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe.setItems(langs);
    }    
    @FXML
    public void ajouter_user(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        if((first_name.getText().isEmpty())||!(first_name.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("please insert your first name correctly!");
            alert.show();
        }
        else if ((last_name.getText().isEmpty())||!(last_name.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("please insert your last name correctly!");
            alert.show();
        }
        else if((telephone.getText().isEmpty())||(!Pattern.matches("^\\d*$",telephone.getText()))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your phone number correctly");
            alert.show();
        }
        else if((email.getText().isEmpty())||(!Pattern.matches("^(.+)@(.+)$",email.getText()))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your email correctly");
            alert.show();
        }
        else if((pays.getText().isEmpty())||(!pays.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your country correctly");
            alert.show();
        }
        else if((ville.getText().isEmpty())||(!ville.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your city correctly");
            alert.show();
        }
        else if((zip.getText().isEmpty())||(!Pattern.matches("^\\d*$",zip.getText()))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert you phone number correctly");
            alert.show();
        }
        else if(!password.getText().equals(confirm_password.getText())){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please enter your password correctly");
            alert.show();
        }
        else if(date_de_naissance.getValue()==null){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please enter your birth date");
            alert.show();
        }
        else if(sexe.getValue()==null){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please enter your gender");
            alert.show();
        }
        else{
            global.user.setBlocked(0);
            global.user.setVerification(0);
            int codepostal=Integer.parseInt(zip.getText());  
            global.user.setCode_postal(codepostal);
            Date date = Date.valueOf(date_de_naissance.getValue());
            global.user.setDate_naissance(date);
            global.user.setEmail_user(email.getText());
            global.user.setId_role(10);
        try {
            global.user.setPassword(toHexString(getSHA(password.getText())));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
            global.user.setNom_user(last_name.getText());
            global.user.setPrenom_user(first_name.getText());
            int numero=Integer.parseInt(telephone.getText());  
            global.user.setNumero_tel(numero);
            global.user.setSexe(sexe.getValue());
            global.user.setVille_user(ville.getText());
            global.user.setPays_user(pays.getText());
            global.serviceuser.ajout(global.user); 
            global.serviceuser.update_user_information(global.user);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/wait_for_verification_code.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AuthController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sexe.getScene().setRoot(root);
       


        }
    }
            
            
            
        }

