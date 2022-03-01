/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Bateaux;
import entities.Espace_culturels;
import entities.Evenement;
import entities.Hotel;
import entities.Monuments;
import entities.OfferOption;
import entities.Vols;
import entities.restaurants;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import services.ServiceBateaux;
import services.ServiceEspaceCulturel;
import services.ServiceEvents;
import services.ServiceHotel;
import services.ServiceMonuments;
import services.ServiceOfferOption;
import services.ServiceRestaurant;
import services.ServiceVols;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class OfferOptionInterfaceController implements Initializable {

    ObservableList<Bateaux> listBateu = FXCollections.observableArrayList();
    ObservableList<Vols> listVol= FXCollections.observableArrayList();
    ObservableList<Hotel> listHotel= FXCollections.observableArrayList();
    ObservableList<restaurants> listRes= FXCollections.observableArrayList();
    ObservableList<Monuments> listMonument= FXCollections.observableArrayList();
    ObservableList<Evenement> listEvent= FXCollections.observableArrayList();
    ObservableList<Espace_culturels> listEsp= FXCollections.observableArrayList();

    ServiceBateaux sb = new ServiceBateaux();
    ServiceVols sv = new ServiceVols();
    ServiceHotel sh = new ServiceHotel();
    ServiceRestaurant sr = new ServiceRestaurant();
    ServiceMonuments sm =new ServiceMonuments();
    ServiceEvents se = new ServiceEvents();
    ServiceEspaceCulturel sec = new ServiceEspaceCulturel();
    ServiceOfferOption sop = new ServiceOfferOption();
    @FXML
    private Label label_id;
    @FXML
    private TextField input_id;
    @FXML
    private TableColumn<?, ?> tab_bateau;
    @FXML
    private TableColumn<?, ?> tab_id;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_sup;
    @FXML
    private TextField id_offer;
    @FXML
    private ChoiceBox<Bateaux> bateau_opt;
    @FXML
    private ChoiceBox<Espace_culturels> espace_opt;
    @FXML
    private ChoiceBox<Vols> vol_opt;
    @FXML
    private ChoiceBox<Hotel> hotel_opt;
    @FXML
    private ChoiceBox<Monuments> monument_opt;
    @FXML
    private ChoiceBox<restaurants> restaurant_opt;
    @FXML
    private ChoiceBox<Evenement> evenement_opt;
    @FXML
    private TableColumn<OfferOption, Integer> tab_offer;
    @FXML
    private TableColumn<Bateaux, Integer> tab_espace;
    @FXML
    private TableColumn<OfferOption, Integer> tab_vol;
    @FXML
    private TableColumn<OfferOption, Integer> tab_hotel;
    @FXML
    private TableColumn<OfferOption, Integer> tab_monument;
    @FXML
    private TableColumn<OfferOption, Integer> tab_restaurant;
    @FXML
    private TableColumn<OfferOption, Integer> tab_evenement;
    @FXML
    private TableView<OfferOption> tab_option;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listBateu.addAll(sb.getBateaux(Date.valueOf("1970-01-01"),"14", "al" ));
        bateau_opt.setItems(listBateu);
        StringConverter<Bateaux> converterBateu = new StringConverter<Bateaux>() {
            @Override
            public String toString(Bateaux object) {
                return object.getCompagnie_maritime();
            }

            @Override
            public Bateaux fromString(String string) {
                return null;
            }
        };
        bateau_opt.setConverter(converterBateu);
        
        //*****************Vol
        listVol.addAll(sv.getVol(Date.valueOf("2022-02-18"), "zefz", "zefze"));
        
        vol_opt.setItems(listVol);
        StringConverter<Vols> converterVol = new StringConverter<Vols>() {
            @Override
            public String toString(Vols object) {
                return object.getCompagnie_aerien();
            }

            @Override
            public Vols fromString(String string) {
                return null;
            }
        };
        vol_opt.setConverter(converterVol);
        
        //*********************hotel
        listHotel.addAll(sh.affiche());
        System.out.println(listHotel);
        hotel_opt.setItems(listHotel);
        StringConverter<Hotel> converterHotel = new StringConverter<Hotel>() {
            @Override
            public String toString(Hotel object) {
                return object.getNom_hotel();
            }

            @Override
            public Hotel fromString(String string) {
                return null;
            }
        };
        hotel_opt.setConverter(converterHotel);
        
        //*********************restaurant
        listRes.addAll(sr.affiche());
        
        restaurant_opt.setItems(listRes);
        StringConverter<restaurants> converterRes = new StringConverter<restaurants>() {
            @Override
            public String toString(restaurants object) {
                return object.getNom_restaurant();
            }

            @Override
            public restaurants fromString(String string) {
                return null;
            }
        };
        restaurant_opt.setConverter(converterRes);
        
        //*********************evenement
        listEvent.addAll(se.affiche());
        
        evenement_opt.setItems(listEvent);
        StringConverter<Evenement> converterEvent = new StringConverter<Evenement>() {
            @Override
            public String toString(Evenement object) {
                return object.getNom();
            }

            @Override
            public Evenement fromString(String string) {
                return null;
            }
        };
        evenement_opt.setConverter(converterEvent);
        
        //*********************monument
        listMonument.addAll(sm.affiche());
        
        monument_opt.setItems(listMonument);
        StringConverter<Monuments> converterMon = new StringConverter<Monuments>() {
            @Override
            public String toString(Monuments object) {
                return object.getNom_monument();
            }

            @Override
            public Monuments fromString(String string) {
                return null;
            }
        };
        monument_opt.setConverter(converterMon);
        
        
        //*********************Espace
        listEsp.addAll(sec.affiche());
        
        espace_opt.setItems(listEsp);
        StringConverter<Espace_culturels> converterEcp = new StringConverter<Espace_culturels>() {
            @Override
            public String toString(Espace_culturels object) {
                return object.getNom_espace();
            }

            @Override
            public Espace_culturels fromString(String string) {
                return null;
            }
        };
        espace_opt.setConverter(converterEcp); 
        afficher();
    }    


    @FXML
private void getValues() {
//        List<OfferOption> list = new ArrayList<>();
//        tab_option.setOnMouseClicked((MouseEvent event) -> {
//            OfferOption listOption = tab_option.getItems().get(tab_option.getSelectionModel().getSelectedIndex());
//            bateau_opt.setText(listOption.get());
//            depart.setText(listOption.getDepart());
//            destination.setText(listOption.getDestination());
//            //date_dep.setDayCellFactory(value);
//            //date_arr.setValue(listVols.getDate_arrive());
//            prix.setText(Float.toString(listOption.getPrix()));
//            duree.setText(Integer.toString(listOption.getDuree()));
//            type_avion.setText(listOption.getType_avion());
//            image_vol.setText(listOption.getImage_vol());
//            avis_vol.setText(Integer.toString(listOption.getAvis_vol()));
//            list.add(listOption);
//        });
   }

    public void setIdOffer(Integer id){
        id_offer.setText(id+"");
    }
    private void afficher(){
        ObservableList <OfferOption> data = FXCollections.observableArrayList(sop.affiche());
        tab_option.getItems().clear();
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id_offer_option"));
        tab_offer.setCellValueFactory(new PropertyValueFactory<>("id_offer"));
        tab_bateau.setCellValueFactory(new PropertyValueFactory<>("id_bateau"));
        tab_espace.setCellValueFactory(new PropertyValueFactory<>("id_espace"));
        tab_vol.setCellValueFactory(new PropertyValueFactory<>("id_vol"));
        tab_hotel.setCellValueFactory(new PropertyValueFactory<>("id_hotel"));
        tab_monument.setCellValueFactory(new PropertyValueFactory<>("id_monument"));
        tab_restaurant.setCellValueFactory(new PropertyValueFactory<>("id_restaurant"));
        tab_evenement.setCellValueFactory(new PropertyValueFactory<>("id_evenement"));
        for (OfferOption v : data){
            //System.out.println(v);
        tab_option.getItems().add(v);
        
            //System.out.println();
        }
    }
    @FXML
    private void ajouter(ActionEvent event) {
        OfferOption op = new OfferOption();
        op.setId_offer(Integer.parseInt(id_offer.getText()));
        op.setId_bateau(bateau_opt.getSelectionModel().getSelectedItem().getId_bateau());
        op.setId_espace(espace_opt.getSelectionModel().getSelectedItem().getId_espace());
        op.setId_vol(vol_opt.getSelectionModel().getSelectedItem().getId_vol());
        op.setId_hotel(hotel_opt.getSelectionModel().getSelectedItem().getId_hotel());
        op.setId_monument(monument_opt.getSelectionModel().getSelectedItem().getId_monument());
        op.setId_restaurant(restaurant_opt.getSelectionModel().getSelectedItem().getId_restaurant());
        op.setId_evenement(evenement_opt.getSelectionModel().getSelectedItem().getId_event());
        
        sop.ajout(op);
        afficher();
    }

    @FXML
    private void modifier(ActionEvent event) {
        OfferOption op = new OfferOption();
        op.setId_offer_option(Integer.parseInt(input_id.getText()));

        op.setId_bateau(bateau_opt.getSelectionModel().getSelectedItem().getId_bateau());
        op.setId_espace(espace_opt.getSelectionModel().getSelectedItem().getId_espace());
        op.setId_vol(vol_opt.getSelectionModel().getSelectedItem().getId_vol());
        op.setId_hotel(hotel_opt.getSelectionModel().getSelectedItem().getId_hotel());
        op.setId_monument(monument_opt.getSelectionModel().getSelectedItem().getId_monument());
        op.setId_restaurant(restaurant_opt.getSelectionModel().getSelectedItem().getId_restaurant());
        op.setId_evenement(evenement_opt.getSelectionModel().getSelectedItem().getId_event());
        sop.modifier(op);
        afficher();
    }

    @FXML
    private void supprime(ActionEvent event) {
        sop.supprime(Integer.parseInt(input_id.getText()));
        afficher();
    }
    
}
