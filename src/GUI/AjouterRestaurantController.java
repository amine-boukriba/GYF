/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import services.ServiceRestaurant;
import entities.restaurants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFileChooser;
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
    private JFXTextField téléphone;
    @FXML
    private JFXComboBox<String> spécialité;
    @FXML
    private JFXTextField nbr_fourchet;
    @FXML
    private JFXButton btnNext;
   

    private AnchorPane slider;
    @FXML
    private JFXTextField img;
    @FXML
    private JFXButton btnNext1;
      @FXML
    private ImageView imagev;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
      

 spécialité.getItems().add("Cuisine albanaise");
 spécialité.getItems().add("Cuisine allemande");
 spécialité.getItems().add("Cuisine britannique");
 spécialité.getItems().add("Cuisine anglaise");
 spécialité.getItems().add("Cuisine écossaise");
 spécialité.getItems().add("Cuisine galloise");
 spécialité.getItems().add("Cuisine bulgare");
 spécialité.getItems().add("Cuisine chypriote");
 spécialité.getItems().add("Cuisine danoise");
 spécialité.getItems().add("Cuisine espagnole");
 spécialité.getItems().add("Cuisine française");
 spécialité.getItems().add("Cuisine grecque");
 spécialité.getItems().add("Cuisine italienne");
 spécialité.getItems().add("Cuisine suisse");
 spécialité.getItems().add("Cuisine égyptienne");
 spécialité.getItems().add("cuisine algérienne");
 spécialité.getItems().add("Cuisine libyenne");
 spécialité.getItems().add("Cuisine marocaine");
 spécialité.getItems().add("Cuisine tunisienne");

 spécialité.getItems().add("Cuisine des États-Unis");

 spécialité.getItems().add("Cuisine canadienne");
 spécialité.getItems().add("Cuisine mexicaine");
 spécialité.getItems().add("Cuisine chinoise");
 spécialité.getItems().add("Cuisine coréenne");
 spécialité.getItems().add("Cuisine japonaise");
 spécialité.getItems().add("Cuisine mongole");
 spécialité.getItems().add("Cuisine taïwanaise");
     
    }

    @FXML
    private void ajout(ActionEvent event) {
          if (validateNumber() && validateFields()) {
        
        restaurants r = new restaurants();
        r.setNom_restaurant(nom_res.getText());
        r.setLocalisation(localisation.getText());

        r.setCuisinies( spécialité.getValue());
        r.setHoraire(horaire.getText());
        r.setNumero_restaurant(téléphone.getText());
        String text1 = nbr_fourchet.getText();
        r.setNombre_fourchet(Integer.parseInt(text1));
        r.setImage_restaurant(img.getText());
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
      @FXML
    private void get_image(ActionEvent event) {
         JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        img.setText(filename);
        Image imagee;
          try {
              imagee = new Image(new FileInputStream(filename));
           imagev.setImage(imagee);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(AjouterHotelController.class.getName()).log(Level.SEVERE, null, ex);
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
        if(nom_res.getText().isEmpty() || localisation.getText().isEmpty() ||  spécialité.getSelectionModel().getSelectedItem().isEmpty() || horaire.getText().isEmpty()|| téléphone.getText().isEmpty() || nbr_fourchet.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
 

    }
    
