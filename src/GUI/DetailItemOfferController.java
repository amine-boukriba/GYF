/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import entities.Bateaux;
import entities.Espace_culturels;
import entities.Evenement;
import entities.Hotel;
import entities.Monuments;
import entities.OfferOption;
import entities.Offers;
import entities.PaymentOffers;
import entities.Vols;
import entities.restaurants;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import services.ServiceBateaux;
import services.ServiceEspaceCulturel;
import services.ServiceEvents;
import services.ServiceHotel;
import services.ServiceMonuments;
import services.ServiceOfferOption;
import services.ServicePaymentOffers;
import services.ServiceRestaurant;
import services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class DetailItemOfferController implements Initializable {

    ObservableList<OfferOption> listOffer = FXCollections.observableArrayList();
    ServiceOfferOption soo = new ServiceOfferOption();
    PaymentOffers payOff = new PaymentOffers();
    ServicePaymentOffers spo = new ServicePaymentOffers();
    
    Offers list ;
    
    @FXML
    private ImageView image;
    @FXML
    private Label depart_text;
    @FXML
    private Label destination_text;
    @FXML
    private Label date_dep_text;
    @FXML
    private Label date_arr_text;
    @FXML
    private JFXButton btn_retour;
    @FXML
    private JFXButton btn_payer;
    @FXML
    private JFXRadioButton rad_reserver;
    @FXML
    private Label titre;
    @FXML
    private Label nb_nuit_text;
    @FXML
    private Label description_text;
    @FXML
    private Label prix_text;
    @FXML
    private Label avis_offer;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //setList();
        //setId(Offers o);
    }    
    
    private void setList(){
        System.out.println(list.getId_offer());
        //listOffer.addAll(soo.getOffers(list.getId_offer()));
        //System.out.println(listOffer);
        
    }
    
    private void setGrid(){
        int row=0;
           for (int i =0;i<1;i++){
            
            if(listOffer.get(0).getId_bateau() !=0){
               ServiceBateaux sb = new ServiceBateaux();
               List<Bateaux> listBat = new ArrayList<> (sb.getOne(listOffer.get(0).getId_bateau()));
            List<String> list = new ArrayList<>();
            list.add(listBat.get(0).getImage_bateau());
            list.add("Companie "+listBat.get(0).getCompagnie_maritime());
            list.add("Nom bateau "+listBat.get(0).getNom_bateau());
            list.add("Avis "+listBat.get(0).getAvis_bateau()+"");
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            
            }else
                row=row;
            
             if(listOffer.get(0).getId_espace()!= 0){
                ServiceEspaceCulturel se = new ServiceEspaceCulturel();
                List<Espace_culturels> listEs= new ArrayList<Espace_culturels>(se.getEspace_culturelsById(listOffer.get(0).getId_evenement()));
                 System.out.println(listEs);
            List<String> list = new ArrayList<>();
            list.add(listEs.get(0).getImage_espace());
            list.add("Nom "+listEs.get(0).getNom_espace());
            list.add("Description "+listEs.get(0).getDescription());
            list.add("Location "+listEs.get(0).getLocalisation()+"");
                 System.out.println(list);
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
                 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }
             else
                row=row;
            
            if(listOffer.get(0).getId_evenement()!= 0){
                 ServiceEvents se = new ServiceEvents();
                  List<Evenement> listEv = new ArrayList<>(se.getById(listOffer.get(0).getId_evenement()));
            List<String> list = new ArrayList<>();
            list.add(listEv.get(0).getImage());
            list.add("Nom "+listEv.get(0).getNom());
            list.add("Description "+listEv.get(0).getDescription());
            list.add("Localisation "+listEv.get(0).getLocalisation()+"");
                
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
                 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }else
                row=row;
            
            if(listOffer.get(0).getId_hotel()!= 0){
                 ServiceHotel sh = new ServiceHotel();
                 ArrayList<Hotel>  listH = new ArrayList(sh.getById(listOffer.get(0).getId_hotel()));
            List<String> list = new ArrayList<>();
            list.add(listH.get(0).getImage_hotel());
            list.add("Nom "+listH.get(0).getNom_hotel());
            list.add("Location "+listH.get(0).getLocalisation());
            list.add("Avis "+listH.get(0).getAvis_hotel()+"");
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 System.out.println("detailItem offer "+ list);
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }else
                row=row;
      
            if(listOffer.get(0).getId_monument()!= 0){
                 ServiceMonuments sm = new ServiceMonuments();
                 List<Monuments> listM = new ArrayList<Monuments>(sm.getMonumentsById(listOffer.get(0).getId_monument()));
            List<String> list = new ArrayList<>();
            list.add(listM.get(0).getImage_monument());
            list.add("Nom "+listM.get(0).getNom_monument());
            list.add("Description "+listM.get(0).getDescription());
            list.add("Localisation "+listM.get(0).getLocalisation()+"");
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1,row+1); 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }else
                row=row;
            
            if(listOffer.get(0).getId_restaurant()!= 0){
                 ServiceRestaurant sr = new ServiceRestaurant();
                 ArrayList<restaurants>  listR = new ArrayList(sr.getById(listOffer.get(0).getId_restaurant()));
            List<String> list = new ArrayList<>();
            list.add(listR.get(0).getImage_restaurant());
            list.add("Nom "+listR.get(0).getNom_restaurant());
            list.add("Nombre Fourchet "+listR.get(0).getNombre_fourchet()+"");
            list.add("Localisation "+listR.get(0).getLocalisation()+"");
                System.out.println(listR);
                System.out.println(list);
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }else
                row=row;
            
            if(listOffer.get(0).getId_vol()!= 0){
                 ServiceVols sv = new ServiceVols();
                 List<Vols> listV = new ArrayList<>(sv.getOne(listOffer.get(0).getId_vol()));
            List<String> list = new ArrayList<>();
            list.add(listV.get(0).getImage_vol());
            list.add("Companie "+listV.get(0).getCompagnie_aerien());
            list.add("Duree "+listV.get(0).getDuree()+"");
            list.add("Avis "+listV.get(0).getAvis_vol()+"");
             try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("OfferOptionItem.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();
                 
                 OfferOptionItemController itemController = fxmlLoader.getController();
                 itemController.setItemm(list);
                 grid.add(anchorPane, i+1, row+1); 
                 System.out.println(i+1);
             } catch (IOException ex) {
                 Logger.getLogger(DetailItemOfferController.class.getName()).log(Level.SEVERE, null, ex);
             }
             row++;
            }else
                row=row;
            
               
        }
    }

     public void setId(Offers o){
         int size=0;
        this.list=o;
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+list.getPath()));
        this.image.setImage(image);
        titre.setText(o.getTitre());
        depart_text.setText(o.getDepart());
        destination_text.setText(o.getDestination());
        date_dep_text.setText(o.getDate_debut()+"");
        date_arr_text.setText(o.getDate_fin()+"");
        nb_nuit_text.setText(o.getNombre_nuits()+"");
        description_text.setText(o.getDescription()+"");
        prix_text.setText(o.getPrix()+"");
        avis_offer.setText(o.getAvis_offer()+"");
        listOffer.addAll(soo.getOffers(list.getId_offer()));
         System.out.println(listOffer);
        
        grid.setPadding(new Insets(10));
        setGrid();

        
    }
    
    @FXML
    private void retourVol(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OfferClientInterface.fxml"));
            Parent root = loader.load();
            OfferClientInterfaceController controller = loader.getController();
            btn_retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Payer(ActionEvent event) {
        List <String> listitem=new ArrayList<>();
        if(rad_reserver.isSelected()==true){
            payOff.setId_offer(list.getId_offer());
            payOff.setId_user(2);
            payOff.setType_payment("agence");
         System.out.println(payOff);
           //listitem.add()
            spo.ajoutPay(payOff,listitem);           
       }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentInterface.fxml"));
                Parent root = loader.load();
                PaymentInterfaceController controller = loader.getController();
                payOff.setId_offer(list.getId_offer());
                payOff.setId_user(2);
                payOff.setType_payment("en ligne");
                listitem.add(list.getPrix()+"");

                controller.setPayment(payOff,list);
                btn_payer.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
