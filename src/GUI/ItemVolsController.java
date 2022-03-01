/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entities.Bateaux;
import entities.Vols;
import java.io.IOException;
import javafx.scene.image.Image;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.ServiceBateaux;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class ItemVolsController implements Initializable {

    ServiceBateaux sb = new ServiceBateaux();
            
    Vols listvol ;
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
        
    }    
    
    public void setData(Vols vols) {
//        this.fruit = fruit;
//        this.myListener = myListener;
        depart.setText(vols.getDepart());
        date_deb.setText(vols.getDate_depart()+"");
        arrive.setText(vols.getDestination());
        date_arr.setText(vols.getDate_arrive()+"");
        prix.setText(vols.getPrix()+"");
        Image image = new Image(getClass().getResourceAsStream("../"+vols.getImage_vol()));
        img_comp.setImage(image);
        listvol = vols;
        
    }

    @FXML
    private void voirDetail(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailItems.fxml"));
            Parent root = loader.load();
            DetailItemsController controller = loader.getController();
            btn_detail.getScene().setRoot(root);
            controller.setId(listvol);
        } catch (IOException ex) {
            Logger.getLogger(ItemVolsController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }
    
}
