/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entities.Bateaux;
import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceBateaux;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class ItemBateauxController implements Initializable {

    ServiceBateaux sb = new ServiceBateaux();
    Bateaux listBateaux = new Bateaux();
   
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

     public void setData(Bateaux bateaux) {
         System.out.println(bateaux);
        depart.setText("Depart \n"+bateaux.getDepart());
        date_deb.setText("Date depart \n"+bateaux.getDate_depart()+"");
        arrive.setText("Date arrive \n"+bateaux.getDestination());
        date_arr.setText("Date arrive \n"+bateaux.getDate_arrive()+"");
        prix.setText(bateaux.getPrix()+"");
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+bateaux.getImage_bateau()));
         
        img_comp.setImage(image);
        listBateaux = bateaux;
        
    }
    
    @FXML
    private void voirDetail(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailItemsBateaux.fxml"));
            Parent root = loader.load();
            DetailItemsBateauxController controller = loader.getController();
            btn_detail.getScene().setRoot(root);
            controller.setId(listBateaux);
            
        } catch (IOException ex) {
            Logger.getLogger(ItemVolsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
