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
import entities.PaymentPlan;
import entities.Plan;
import entities.Vols;
import entities.restaurants;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ServiceBateaux;
import services.ServiceEspaceCulturel;
import services.ServiceEvents;
import services.ServiceHotel;
import services.ServiceMonuments;
import services.ServiceOfferOption;
import services.ServicePaymentPlan;
import services.ServicePaymentVols;
import services.ServicePlan;
import services.ServiceRestaurant;
import services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class PlaningInterfaceController implements Initializable {

    
    
    

    ServiceBateaux sb = new ServiceBateaux();
    ServiceVols sv = new ServiceVols();
    ServiceHotel sh = new ServiceHotel();
    ServiceRestaurant sr = new ServiceRestaurant();
    ServiceMonuments sm =new ServiceMonuments();
    ServiceEvents se = new ServiceEvents();
    ServiceEspaceCulturel sec = new ServiceEspaceCulturel();
    ServiceOfferOption sop = new ServiceOfferOption();
    OfferOption op = new OfferOption();
    ServicePlan sp = new ServicePlan();
    int prix=0;
    PaymentPlan pp = new PaymentPlan();
    
    Plan pl = new Plan();
    
    ServicePaymentPlan spp = new ServicePaymentPlan();
    
    
    @FXML
    private JFXButton btn_show_vol;
    
    //************* bateau
    @FXML
    private TableView<Bateaux> tab_bateau;
    @FXML
    private TableColumn<Bateaux, String> tab_comp1;
    @FXML
    private TableColumn<Bateaux, String> tab_depart1;
    @FXML
    private TableColumn<Bateaux, String> tab_dest1;
    @FXML
    private TableColumn<Bateaux, Date> tabd_dat_dep1;
    @FXML
    private TableColumn<Bateaux, Date> tab_date_arr1;
    @FXML
    private TableColumn<Bateaux, Integer> tab_prix1;
    @FXML
    private JFXButton btn_show_bat;
    
    //******************vol
    @FXML
    private TableColumn<Vols, String> tab_compv;
    @FXML
    private TableColumn<Vols, String> tab_departv;
    @FXML
    private TableColumn<Vols, String> tab_destv;
    @FXML
    private TableColumn<Vols, Date> tabd_dat_depv;
    @FXML
    private TableColumn<Vols, Date> tab_date_arrv;
    @FXML
    private TableColumn<Vols, Integer> tab_prixv;
    @FXML
    private TableColumn<Vols, Integer> tab_avisv;
    @FXML
    private TableView<Vols> tab_vols;
    @FXML
    private JFXButton btn_payer;
    
    //*****************monument
    @FXML
    private TableView<Monuments> tab_monument;
    @FXML
    private TableColumn<Monuments, String> tab_nomm;
    @FXML
    private TableColumn<Monuments, String> tab_descm;
    @FXML
    private TableColumn<Monuments, Date> tab_createm;
    @FXML
    private TableColumn<Monuments, String> tab_paym;
    @FXML
    private TableColumn<Monuments, String> tab_localm;
    @FXML
    private TableColumn<Monuments, Integer> tab_prixm;
    @FXML
    private JFXButton btn_monu;
    
    //****************hotel
    @FXML
    private TableView<Hotel> tab_hotel;
    @FXML
    private TableColumn<Hotel, String> tab_nomh;
    @FXML
    private TableColumn<Hotel, String> tab_localh;
    @FXML
    private TableColumn<Hotel, String> tab_categh;
    @FXML
    private TableColumn<Hotel, Integer> tab_avish;
    @FXML
    private JFXButton btn_hotel;
    
    //************************evenement
    @FXML
    private TableView<Evenement> tab_evenement;
    @FXML
    private TableColumn<Evenement, String> tab_nomev;
    @FXML
    private TableColumn<Evenement, String> tab_descev;
    @FXML
    private TableColumn<Evenement, String> tab_typeev;
    @FXML
    private TableColumn<Evenement, String> tab_localev;
    @FXML
    private TableColumn<Evenement, String> tab_payev;
    @FXML
    private TableColumn<Evenement, Integer> tab_prixev;
    @FXML
    private JFXButton btn_event;
    
    //************** rateuarant
    @FXML
    private TableView<restaurants> tab_restaurant;
    @FXML
    private TableColumn<restaurants, String> tab_nomres;
    @FXML
    private TableColumn<restaurants, String> tab_locares;
    @FXML
    private TableColumn<restaurants, String> tab_horaireres;
    @FXML
    private TableColumn<restaurants, String> tab_cuisineres;
    @FXML
    private TableColumn<restaurants, Integer> tab_nbfourchetres;
    @FXML
    private TableColumn<restaurants, Integer> tab_avisres;
    @FXML
    private JFXButton btn_restaurant;
    
    //************* espace
    @FXML
    private TableView<Espace_culturels> tab_espace;
    @FXML
    private TableColumn<Espace_culturels,String> tab_nomesp;
    @FXML
    private TableColumn<Espace_culturels, String> tab_horairesp;
    @FXML
    private TableColumn<Espace_culturels, Integer> tab_prixesp;
    @FXML
    private TableColumn<Espace_culturels, Date> tab_createsp;
    @FXML
    private TableColumn<Espace_culturels, String> tab_paysesp;
    @FXML
    private TableColumn<Espace_culturels, String> tab_locatesp;
    @FXML
    private JFXButton btn_espace;
    @FXML
    private Label lab_prix;
    @FXML
    private JFXRadioButton rad_reserver;
    @FXML
    private TextField depart_input;
    @FXML
    private DatePicker debut_input;
    @FXML
    private DatePicker fin_input;
    @FXML
    private JFXButton btn_submit;
    @FXML
    private TextField destination_input;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tab_bateau.setVisible(false);
        tab_monument.setVisible(false);
        tab_restaurant.setVisible(false);
        tab_hotel.setVisible(false);
        tab_evenement.setVisible(false);
        tab_espace.setVisible(false);
        tab_vols.setVisible(false);
        
        
        tab_vols.setOnMouseClicked((MouseEvent event) -> {
            Vols listVols = tab_vols.getItems().get(tab_vols.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_vol(listVols.getId_vol());
               prix+=listVols.getPrix();
               lab_prix.setText(prix+"");
               tab_vols.setVisible(false);
            }
                System.out.println(op);
        });
        
        
        tab_bateau.setOnMouseClicked((MouseEvent event) -> {
            Bateaux listBat = tab_bateau.getItems().get(tab_vols.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_bateau(listBat.getId_bateau());
               prix+=listBat.getPrix();
               lab_prix.setText(prix+"");
               tab_bateau.setVisible(false);
            }
                System.out.println(op);
        });
        
        tab_monument.setOnMouseClicked((MouseEvent event) -> {
            Monuments listBat = tab_monument.getItems().get(tab_monument.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_monument(listBat.getId_monument());
               prix+=listBat.getPrix();
               lab_prix.setText(prix+"");
               tab_monument.setVisible(false);
            }
                System.out.println(op);
        });
        
        tab_restaurant.setOnMouseClicked((MouseEvent event) -> {
            restaurants listBat = tab_restaurant.getItems().get(tab_restaurant.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_restaurant(listBat.getId_restaurant());
               tab_restaurant.setVisible(false);
            }
                System.out.println(op);
        });
        
        tab_hotel.setOnMouseClicked((MouseEvent event) -> {
            Hotel listBat = tab_hotel.getItems().get(tab_hotel.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_hotel(listBat.getId_hotel());
               tab_hotel.setVisible(false);
            }
                System.out.println(op);
        });
        
        tab_evenement.setOnMouseClicked((MouseEvent event) -> {
            Evenement listBat = tab_evenement.getItems().get(tab_evenement.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_evenement(listBat.getId_event());
               prix+=listBat.getPrix();
               lab_prix.setText(prix+"");
               tab_evenement.setVisible(false);
            }
                System.out.println(op);
        });
        
        tab_espace.setOnMouseClicked((MouseEvent event) -> {
            Espace_culturels listBat = tab_espace.getItems().get(tab_espace.getSelectionModel().getSelectedIndex());
                
                if(event.getClickCount() == 2){
               op.setId_espace(listBat.getId_espace());
               prix+=listBat.getPrix();
               lab_prix.setText(prix+"");
               tab_espace.setVisible(false);
            }
                System.out.println(op);
        });
        
    }   

    @FXML
    private void getValues(MouseEvent event) {
        System.out.println(prix);
    }

    @FXML
    private void showVol(ActionEvent event) {
        if(op.getId_vol()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_vols.setVisible(true);
        ObservableList <Vols> data = FXCollections.observableArrayList(sv.affiche());
        tab_vols.getItems().clear();
        //System.out.println(sv.affiche());

        tab_compv.setCellValueFactory(new PropertyValueFactory<>("compagnie_aerien"));
        tab_departv.setCellValueFactory(new PropertyValueFactory<>("depart"));
        tab_destv.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tabd_dat_depv.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tab_date_arrv.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        tab_prixv.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tab_avisv.setCellValueFactory(new PropertyValueFactory<>("avis_vol"));
        for (Vols v : data){
            //System.out.println(v);
        tab_vols.getItems().add(v);
        
            //System.out.println();
        }
        }
    }

    @FXML
    private void showBateau(ActionEvent event) {
        if(op.getId_bateau()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_bateau.setVisible(true);
        ObservableList <Bateaux> data = FXCollections.observableArrayList(sb.affiche());
        tab_bateau.getItems().clear();
        //System.out.println(sb.affiche());
        tab_comp1.setCellValueFactory(new PropertyValueFactory<>("compagnie_maritime"));
        tab_depart1.setCellValueFactory(new PropertyValueFactory<>("depart"));
        tab_dest1.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tabd_dat_dep1.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tab_date_arr1.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        tab_prix1.setCellValueFactory(new PropertyValueFactory<>("prix"));
      
        for (Bateaux b : data){
            //System.out.println(b);
        tab_bateau.getItems().add(b);
            //System.out.println();
        }
        }
    }


    @FXML
    private void payer(ActionEvent event) {
        if(depart_input.getText().isEmpty()||destination_input.getText().isEmpty()||debut_input.getValue()==null||fin_input.getValue()==null){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("text non valide");
				alert.setContentText("saisire tous les champ");
                                Optional<ButtonType> result = alert.showAndWait();
        }else if(Date.valueOf(debut_input.getValue()).compareTo(Date.valueOf(fin_input.getValue()))>0 ){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Date not valid");
				alert.setContentText("la date d'arriver doit etre superieur a date de depart");
                                Optional<ButtonType> result = alert.showAndWait();
                                
        }else{
            
        
        //************ ajout plan
        pl.setDepart(depart_input.getText());
        pl.setDestination(destination_input.getText());
        //System.out.println(Date.valueOf(debut_input.getValue())+" "+Date.valueOf(fin_input.getValue()));
        pl.setDate_debut(Date.valueOf(debut_input.getValue()));
        pl.setDate_fin(Date.valueOf(fin_input.getValue()));
        pl.setId_user(2);
        pl.setPrix(prix);
        sp.ajout(pl);
        
        //*********** ajout plan option
        op.setId_plan(sp.getLast());
        sop.ajout(op);

        // el PP ou payment plan
        List <String> listitem=new ArrayList<>();
        if(rad_reserver.isSelected()==true){
            pp.setId_plan(sp.getLast());
            pp.setId_user(2);
            pp.setType_payment("agence");
         
           //listitem.add()
           //Service plan payment n3adiwoulou el objet eli chyinserih ou leflous wel carta
            
            spp.ajoutPay(pp,listitem);    
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Succes");
				alert.setHeaderText("reservation  valide");
				alert.setContentText("you will reseve a email with more informations");
                                Optional<ButtonType> result = alert.showAndWait();
       }else{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentInterface.fxml"));
                Parent root = loader.load();
                PaymentInterfaceController controller = loader.getController();
                pp.setId_plan(sp.getLast());
                pp.setId_user(2);
                pp.setType_payment("en ligne");
                listitem.add(prix+"");

                controller.setPayment(pp,pl);
                btn_payer.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(DetailItemsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
    
     private void getValues() {
         
     }

    @FXML
    private void showMonument(ActionEvent event) {
        if(op.getId_monument()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_monument.setVisible(true);
        ObservableList<Monuments> listMonument= FXCollections.observableArrayList(sm.affiche());
        //System.out.println(listMonument);
        tab_monument.getItems().clear();
        //System.out.println(sv.affiche());

        tab_nomm.setCellValueFactory(new PropertyValueFactory<>("nom_monument"));
        tab_descm.setCellValueFactory(new PropertyValueFactory<>("description"));
        tab_createm.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        tab_paym.setCellValueFactory(new PropertyValueFactory<>("pays"));
        tab_localm.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        tab_prixm.setCellValueFactory(new PropertyValueFactory<>("prix"));
        for (Monuments v : listMonument){
            //System.out.println(v);
        tab_monument.getItems().add(v);
        
            
        }
        }
    }

    @FXML
    private void showHotel(ActionEvent event) {
        if(op.getId_hotel()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_hotel.setVisible(true);
        ObservableList<Hotel> listHotel= FXCollections.observableArrayList(sh.affiche());
        
        //System.out.println(listHotel);
        tab_hotel.getItems().clear();
        //System.out.println(sv.affiche());

        tab_nomh.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        tab_localh.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        tab_categh.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        tab_avish.setCellValueFactory(new PropertyValueFactory<>("avis_hotel"));
        for (Hotel v : listHotel){
            //System.out.println(v);
        tab_hotel.getItems().add(v);
        tab_hotel.setVisible(true);
            
        }
        }
    
    }

    @FXML
    private void showRestaurant(ActionEvent event) {
        if(op.getId_restaurant()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_restaurant.setVisible(true);
        ObservableList<restaurants> listRes= FXCollections.observableArrayList(sr.affiche());
        
        //System.out.println(listRes);
        tab_restaurant.getItems().clear();
        //System.out.println(sv.affiche());

        tab_nomres.setCellValueFactory(new PropertyValueFactory<>("nom_restaurant"));
        tab_locares.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        tab_horaireres.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        tab_cuisineres.setCellValueFactory(new PropertyValueFactory<>("cuisinies"));
        tab_nbfourchetres.setCellValueFactory(new PropertyValueFactory<>("nombre_fourchet"));
        tab_avisres.setCellValueFactory(new PropertyValueFactory<>("avis_restaurant"));
        for (restaurants v : listRes){
            //System.out.println(v);
        tab_restaurant.getItems().add(v);
        tab_restaurant.setVisible(true);
            
        }
        }
    }

    @FXML
    private void showEvent(ActionEvent event) {
        if(op.getId_evenement()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_evenement.setVisible(true);
        ObservableList<Evenement> listEvent= FXCollections.observableArrayList(se.affiche());
        //System.out.println(listEvent);
        tab_evenement.getItems().clear();
        //System.out.println(sv.affiche());

        tab_nomev.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tab_descev.setCellValueFactory(new PropertyValueFactory<>("description"));
        tab_typeev.setCellValueFactory(new PropertyValueFactory<>("type"));
        tab_localev.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        tab_payev.setCellValueFactory(new PropertyValueFactory<>("pays"));
        tab_prixev.setCellValueFactory(new PropertyValueFactory<>("prix"));
        for (Evenement v : listEvent){
            //System.out.println(v);
        tab_evenement.getItems().add(v);
        tab_evenement.setVisible(true);
            
        }
        }
    }

    @FXML
    private void showEspace(ActionEvent event) {
        if(op.getId_espace()!=0){
            tab_vols.setVisible(false);
        }else{
        tab_espace.setVisible(true);
        ObservableList<Espace_culturels> listEsp= FXCollections.observableArrayList(sec.affiche());
        //System.out.println(listEsp);
        tab_espace.getItems().clear();
        //System.out.println(sv.affiche());

        tab_nomesp.setCellValueFactory(new PropertyValueFactory<>("nom_espace"));
        tab_horairesp.setCellValueFactory(new PropertyValueFactory<>("horaire"));
        tab_prixesp.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tab_createsp.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        tab_paysesp.setCellValueFactory(new PropertyValueFactory<>("pays"));
        tab_locatesp.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        for (Espace_culturels v : listEsp){
            //System.out.println(v);
        tab_espace.getItems().add(v);
        tab_espace.setVisible(true);
            
        }
    }
    }

    @FXML
    private void submitPlan(ActionEvent event) {
//        pl.setDepart(depart_input.getText());
//        pl.setDestination(destination_input.getText());
//        pl.setDate_debut(Date.valueOf(debut_input.getValue()));
//        pl.setDate_fin(Date.valueOf(fin_input.getValue()));
//        pl.setId_user(2);
        System.out.println(op);
//        sp.ajout();
    }
    
}
