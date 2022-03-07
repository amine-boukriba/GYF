/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import utils.Globals;
import static utils.Password_hash.getSHA;
import static utils.Password_hash.toHexString;

/**
 * FXML Controller class
 *
 * @author boukr
 */
public class Modfier_userController implements Initializable {

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
    @FXML
    private ChoiceBox<String> sexe;
    @FXML
    private DatePicker date_de_naissance;
    @FXML
    private PasswordField password;
    Globals global =new Globals();
    ObservableList<String> langs = FXCollections.observableArrayList("male","female");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(global.user);
        sexe.setItems(langs);
        
        first_name.setEditable(false);
        first_name.setText(global.user.getPrenom_user());
        first_name.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                first_name.setEditable(true);
    }
});
    last_name.setEditable(false);
        last_name.setText(global.user.getNom_user());
        last_name.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                last_name.setEditable(true);
    }
});
        telephone.setEditable(false);
        telephone.setText(String.valueOf(global.user.getNumero_tel()));
        telephone.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                telephone.setEditable(true);
    }
});
        email.setEditable(false);
        email.setText(global.user.getEmail_user());
        pays.setEditable(false);
        pays.setText(global.user.getPays_user());
        pays.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                pays.setEditable(true);
    }
});
        ville.setEditable(false);
        ville.setText(global.user.getVille_user());
        ville.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                ville.setEditable(true);
    }
});
        zip.setEditable(false);
        zip.setText(String.valueOf(global.user.getCode_postal()));
        zip.setOnMouseClicked(event -> {
    if(event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
                zip.setEditable(true);
    }
});      
                sexe.setValue(global.user.getSexe());
                LocalDate localD = global.user.getDate_naissance().toLocalDate();
                date_de_naissance.setValue(localD);
                        
    }   
        @FXML
    public void change_modification(ActionEvent event) {
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
        else try {
            if(!toHexString(getSHA(password.getText())).equals(global.user.getPassword())){
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
                global.user.setPrenom_user(first_name.getText());
                global.user.setNom_user(last_name.getText());
                int numero = Integer.parseInt(telephone.getText());
                global.user.setNumero_tel(numero);
                global.user.setPays_user(pays.getText());
                global.user.setVille_user(ville.getText());
                global.user.setSexe(sexe.getValue());
                int numero_zip = Integer.parseInt(zip.getText());
                global.user.setCode_postal(numero_zip);
                Date date = Date.valueOf(date_de_naissance.getValue()); // Magic happens here!
                global.user.setDate_naissance(date);
                System.out.println(global.user);
                global.serviceuser.modifier(global.user); 
            }} catch (NoSuchAlgorithmException ex) {
             Logger.getLogger(Modfier_userController.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    
    
    
}
