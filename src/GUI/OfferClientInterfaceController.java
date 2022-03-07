/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import entities.Bateaux;
import entities.Offers;
import entities.Vols;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.ServiceOffers;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class OfferClientInterfaceController implements Initializable {

    ServiceOffers so = new ServiceOffers();
    @FXML
    private Label text_error;
    @FXML
    private TextField depart;
    @FXML
    private TextField arrive;
    @FXML
    private DatePicker date_deb;
    @FXML
    private JFXButton btn_rechercher;
    @FXML
    private ScrollPane scrole;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Offers> list = new ArrayList<>(so.affiche());
        System.out.println(list);
        
      
        if(list.size()==0){
           text_error.setText("No data found");
        }else{
            
                for (int i=0;i<list.size();i++){
                    
                    try {
                        //System.out.println("azdzdzad");
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("ItemOffer.fxml"));
                        AnchorPane anchorPane = fxmlLoader.load();
                        ItemOfferController itemController = fxmlLoader.getController();
                        itemController.setData(list.get(i));
                        //System.out.println(list.get(i));
                        grid.add(anchorPane, 1, i+1);
                        grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                        grid.setMaxWidth(Region.USE_PREF_SIZE);
                        
                        //set grid height
                        grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                        grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                        grid.setMaxHeight(Region.USE_PREF_SIZE);
                        
                        GridPane.setMargin(anchorPane, new Insets(10));
                    } catch (IOException ex) {
                        Logger.getLogger(OfferClientInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           
        }
    }    

    @FXML
    private void rechercher(ActionEvent event) {
        if(depart.getText().isEmpty() && date_deb.getValue()==null && arrive.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("text non valide");
				alert.setContentText("saisire tous les champ");
                                Optional<ButtonType> result = alert.showAndWait();            
        }
            else{
         grid.getChildren().clear();
        List<Offers> list = new ArrayList<>(so.rechercheOffers(depart.getText(), arrive.getText(), Date.valueOf(date_deb.getValue())));
            System.out.println(list);
        if(list.size()==0){
           text_error.setText("No data found");
        }
            try {
                for (int i=0;i<list.size();i++){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("ItemOffer.fxml"));
                        AnchorPane anchorPane = fxmlLoader.load();
                        ItemOfferController itemController = fxmlLoader.getController();
                        itemController.setData(list.get(i));
                    grid.add(anchorPane, 1, i+1);
                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMaxWidth(Region.USE_PREF_SIZE);

                    //set grid height
                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMaxHeight(Region.USE_PREF_SIZE);
                    
                  GridPane.setMargin(anchorPane, new Insets(10));
                }
            } catch (IOException ex) {
                Logger.getLogger(VolClientInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
}
