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
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
        
        restaurants r = new restaurants();
        r.setNom_restaurant(nom_res.getText());
        r.setLocalisation(localisation.getText());
        r.setCuisinies(spécialité.getText());
        r.setHoraire(horaire.getText());
        r.setNumero_restaurant(téléphone.getText());
           String text1 = nbr_fourchet.getText();
        r.setNombre_fourchet(Integer.parseInt(text1));
        res.ajout(r);
        Notifications notificationBuilder = Notifications.create()
                .title("ajouter avec succées")
                 .text("ajouter aux list des hotels")
                 .graphic(null)
                 .hideAfter(Duration.seconds(5))
                 .position(Pos.TOP_RIGHT)
                 .onAction(new EventHandler<ActionEvent>(){
                   @Override 
                   public void handle(ActionEvent event){
                     System.out.println("Clicked on notification");
                 }
                 });
       notificationBuilder.showConfirm();

    }
    
}
