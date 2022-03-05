/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.stripe.exception.StripeException;
import entities.Bateaux;
import entities.Offers;
import entities.PaymentBateaux;
import entities.PaymentOffers;
import entities.PaymentPlan;
import entities.PaymentVols;
import entities.Plan;
import entities.Vols;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import services.ServicePaymentBateaux;
import services.ServicePaymentOffers;
import services.ServicePaymentPlan;
import services.ServicePaymentStripe;
import services.ServicePaymentVols;
import services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class PaymentInterfaceController implements Initializable {

    
    ServicePaymentVols spv = new ServicePaymentVols();
    ServicePaymentPlan spp = new ServicePaymentPlan();
    ServicePaymentBateaux spb = new ServicePaymentBateaux();
    ServicePaymentOffers spo = new ServicePaymentOffers();
    ServiceVols sv = new ServiceVols();
    
    PaymentVols payVol = new PaymentVols();
    Vols list;
    
    PaymentPlan payPlan = new PaymentPlan();
    Plan listPlan;
    
    PaymentBateaux payBat = new PaymentBateaux();
    Bateaux listBateux;
    
    PaymentOffers payOff = new PaymentOffers();
    Offers listOffer ;
    
    @FXML
    private TextField card_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void payer(ActionEvent event) {
            if(list != null){
                List<String> listItems = new ArrayList<>() ;
                listItems.add(0,list.getPrix()+"");
                listItems.add(1,card_text.getText());
                System.out.println(listItems);
                spv.ajoutPay(payVol, listItems);
            }else if (listPlan != null){
                List<String> listItems = new ArrayList<>() ;
                listItems.add(0,listPlan.getPrix()+"");
                listItems.add(1,card_text.getText());
                System.out.println(listItems);
                spp.ajoutPay(payPlan, listItems);
            }
            else if (listBateux != null){
                List<String> listItems = new ArrayList<>() ;
                listItems.add(0,listBateux.getPrix()+"");
                listItems.add(1,card_text.getText());
                System.out.println(listItems);
                spb.ajoutPay(payBat, listItems);
            }
            
            else if (listOffer != null){
                List<String> listItems = new ArrayList<>() ;
                listItems.add(0,listOffer.getPrix()+"");
                listItems.add(1,card_text.getText());
                System.out.println(listItems);
                spo.ajoutPay(payOff, listItems);
            }
            
            
//            ServicePaymentStripe spt = new ServicePaymentStripe("annnn@gmail.com","ann",(int)list.getPrix()*100,card_text.getText());//4111111111111111
//            spt.payer();
                 Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Succes");
				alert.setHeaderText("Payment succeded");
				alert.setContentText("An email wel be send to your addres for more information");
                                Optional<ButtonType> result = alert.showAndWait();
        
    }
//    public void setPayment(PaymentVols pay ,Vols list){
//        
//        
//    }
    public  <T> void setPayment(T pay ,T list){
        if(pay instanceof PaymentPlan && list instanceof Plan){
        this.payPlan=(PaymentPlan) pay;
        this.listPlan=(Plan) list;
        System.out.println(payPlan);
        System.out.println(listPlan);
        }else if (pay instanceof PaymentVols && list instanceof Vols){
            this.payVol=(PaymentVols) pay;
            this.list=(Vols) list;
        System.out.println(payVol);
        System.out.println(list);
        }else if (pay instanceof PaymentBateaux && list instanceof Bateaux){
            this.payBat=(PaymentBateaux) pay;
            this.listBateux = (Bateaux) list;
        }
        else if (pay instanceof PaymentOffers && list instanceof Offers){
            this.payOff=(PaymentOffers) pay;
            this.listOffer = (Offers) list;
        }
    }
    
}
