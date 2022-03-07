/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import entities.Bateaux;
import entities.PaymentBateaux;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServiceBateaux;
import services.ServicePaymentBateaux;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class DetailItemsBateauxController implements Initializable {

    ServicePaymentBateaux spb = new ServicePaymentBateaux();
    ServiceBateaux sb = new ServiceBateaux();
    PaymentBateaux payBat = new PaymentBateaux();
    Bateaux list;
    
    @FXML
    private ImageView image;
    @FXML
    private Label comp;
    @FXML
    private Label depart_text;
    @FXML
    private Label destination_text;
    @FXML
    private Label date_dep_text;
    @FXML
    private Label date_arr_text;
    @FXML
    private Label ptix_text;
    @FXML
    private Label duree_text;
    @FXML
    private Label avis_text;
    @FXML
    private Label nom_bateau;
    
    @FXML
    private JFXButton btn_payer;
    @FXML
    private JFXRadioButton rad_reserver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("BateauxClientInterface.fxml"));
//            Parent root = loader.load();
//            BateauxClientInterfaceController controller = loader.getController();
//            btn_retour.getScene().setRoot(root);
//        } catch (IOException ex) {
//            Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
     public void setId(Bateaux b){
        this.list=b;
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+list.getImage_bateau()));
        this.image.setImage(image);
        comp.setText(b.getCompagnie_maritime());
        depart_text.setText(b.getDepart());
        destination_text.setText(b.getDestination());
        date_dep_text.setText(b.getDate_depart()+"");
        date_arr_text.setText(b.getDate_arrive()+"");
        ptix_text.setText(b.getPrix()+"");
        duree_text.setText(b.getDuree()+"");
        avis_text.setText(b.getAvis_bateau()+"");
        nom_bateau.setText(b.getNom_bateau());
        
    }

    @FXML
    private void Payer(ActionEvent event) {
        List <String> listitem=new ArrayList<>();
        if(rad_reserver.isSelected()==true){
            payBat.setId_bateau(list.getId_bateau());
            payBat.setId_user(2);
            payBat.setType_payment("agence");
         System.out.println(payBat);
           //listitem.add()
            spb.ajoutPay(payBat,listitem);    
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Succes");
				alert.setHeaderText("Reservation succeeded");
				alert.setContentText("An email wel be send to your addres for more information");
                                Optional<ButtonType> result = alert.showAndWait();
       }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentInterface.fxml"));
                Parent root = loader.load();
                PaymentInterfaceController controller = loader.getController();
                payBat.setId_bateau(list.getId_bateau());
                payBat.setId_user(2);
                payBat.setType_payment("en ligne");
                listitem.add(list.getPrix()+"");

                controller.setPayment(payBat,list);
                UserInterfaceController.userinterface.view.getChildren().clear();
                UserInterfaceController.userinterface.view.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    
}
