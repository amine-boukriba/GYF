/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entities.Bateaux;
import entities.OfferOption;
import entities.Offers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceOfferOption;
import services.ServiceOffers;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class ItemOfferController implements Initializable {

    
    ServiceOffers so = new ServiceOffers();
    ServiceOfferOption soo = new ServiceOfferOption();
    Offers listOffer = new Offers();
    @FXML
    private ImageView img_comp;
    @FXML
    private Label date_deb;
    @FXML
    private Label depart;
    @FXML
    private Label date_arr;
    @FXML
    private Label arrive;
    @FXML
    private Label prix;
    @FXML
    private JFXButton btn_detail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setData(Offers offer) {
         System.out.println();
        depart.setText("Depart \n"+offer.getDepart());
        date_deb.setText("Date Depart \n"+offer.getDate_debut()+"");
        arrive.setText("Arrive \n"+offer.getDestination());
        date_arr.setText("Date arrive \n"+offer.getDate_fin()+"");
        prix.setText("Prix \n"+offer.getPrix()+"");
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+offer.getPath()));
         
        img_comp.setImage(image);
        listOffer = offer;
        
    }
    
    @FXML
    private void voirDetail(ActionEvent event) {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailItemOffer.fxml"));
            Parent root = loader.load();
            DetailItemOfferController controller = loader.getController();
            UserInterfaceController.userinterface.view.getChildren().clear();
            UserInterfaceController.userinterface.view.getChildren().add(root);
            controller.setId(listOffer);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ItemVolsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
