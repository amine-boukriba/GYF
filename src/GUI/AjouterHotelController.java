/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Hotel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AjouterHotelController implements Initializable {
ServiceHotel Hotel = new ServiceHotel();
    @FXML
    private AnchorPane root;
    private TableView<Hotel> tblhotelDetails;
    private TableColumn<Hotel, String> nom_h;
    private TableColumn<Hotel, String> lo;
    private TableColumn<Hotel, String> caté;
    @FXML
    private TextField nom;
    @FXML
    private TextField localisation;
    @FXML
    private TextField catégorie;
    @FXML
    private JFXButton btnHome;
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
        
        Hotel h = new Hotel();
        h.setNom_hotel(nom.getText());
        h.setLocalisation(localisation.getText());
        h.setCategorie(catégorie.getText());
        Hotel.ajout(h);

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

