/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import services.ServiceRestaurant;
import entities.restaurants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AjouterRestaurantController implements Initializable {
ServiceRestaurant res = new ServiceRestaurant();
    @FXML
    private JFXTextField nom_res;
    @FXML
    private JFXTextField localisation;
    @FXML
    private JFXTextField horaire;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXTextField téléphone;
    @FXML
    private JFXTextField spécialité;
    @FXML
    private JFXTextField nbr_fourchet;
    @FXML
    private JFXButton btnNext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void ajout(ActionEvent event) {
          if (validateNumber() && validateFields()) {
        
        restaurants r = new restaurants();
        r.setNom_restaurant(nom_res.getText());
        r.setLocalisation(localisation.getText());
        r.setCuisinies(spécialité.getText());
        r.setHoraire(horaire.getText());
        r.setNumero_restaurant(téléphone.getText());
        String text1 = nbr_fourchet.getText();
        r.setNombre_fourchet(Integer.parseInt(text1));
        res.ajout(r);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès!");
            alert.setHeaderText(null);
            alert.setContentText("Le restaurant "+r.getNom_restaurant()+" est ajouté avec succès");
            alert.showAndWait();
        } else if(validateNumber()==false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un nombre de fourchette valide");
            alert.showAndWait();
        } else if(validateFields()==false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
            
        }

    }
    private boolean validateNumber() {
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(nbr_fourchet.getText());
        if(m.find() && m.group().equals(nbr_fourchet.getText())) {
            return true;
        } else {
            return false;
        }
    }
    // Test de validation de saisie
    private boolean validateFields(){
        if(nom_res.getText().isEmpty() || localisation.getText().isEmpty() || spécialité.getText().isEmpty() || horaire.getText().isEmpty()|| téléphone.getText().isEmpty() || nbr_fourchet.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
 
    
    

    }
    
