/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import entities.PaymentVols;
import entities.Vols;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import services.ServicePaymentVols;
import services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class DetailItemsController implements Initializable {

    ServicePaymentVols spv = new ServicePaymentVols();
    ServiceVols sv = new ServiceVols();
    PaymentVols payVol = new PaymentVols();
    Vols list;
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
    private JFXButton btn_payer;
    @FXML
    private JFXRadioButton rad_reserver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        System.out.println(id);
//        System.out.println(id);
//        List<Vols> list = new ArrayList<>(sv.getOne(id));
//        System.out.println(list);
            
    }    
    
    public void setId(Vols v){
        this.list=v;
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+list.getImage_vol()));
        this.image.setImage(image);
        comp.setText(v.getCompagnie_aerien());
        depart_text.setText(v.getDepart());
        destination_text.setText(v.getDestination());
        date_dep_text.setText(v.getDate_depart()+"");
        date_arr_text.setText(v.getDate_arrive()+"");
        ptix_text.setText(v.getPrix()+"");
        duree_text.setText(v.getDuree()+"");
        avis_text.setText(v.getAvis_vol()+"");
        
    }

    

    @FXML
    private void Payer(ActionEvent event) {
        List <String> listitem=new ArrayList<>();
        if(rad_reserver.isSelected()==true){
            payVol.setId_vol(list.getId_vol());
            payVol.setId_user(2);
            payVol.setType_payment("agence");
         System.out.println(payVol);
           //listitem.add()
            spv.ajoutPay(payVol,listitem);     
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
                payVol.setId_vol(list.getId_vol());
                payVol.setId_user(2);
                payVol.setType_payment("en ligne");
                listitem.add(list.getPrix()+"");

                controller.setPayment(payVol,list);
               // btn_payer.getScene().setRoot(root);
                UserInterfaceController.userinterface.view.getChildren().clear();
                UserInterfaceController.userinterface.view.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
