/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Monuments;
import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServiceMonuments;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class MesReservationController implements Initializable {

    @FXML
    private TableView<Reservation> tvEsp;
    @FXML
    private TableColumn<Reservation, Integer> EspID;
    @FXML
    private TableColumn<Reservation, Integer> EspIdEsp;
    @FXML
    private TableColumn<Reservation, String> EspDate;
    @FXML
    private TableView<Reservation> tvMon;
    @FXML
    private TableColumn<Reservation, Integer> MonId;
    @FXML
    private TableColumn<Reservation, Integer> MonIdEsp;
    @FXML
    private TableColumn<Reservation, String> MonDate;
    @FXML
    private Label id_esp;
    @FXML
    private Label id_mon;
    @FXML
    private Button btnDetailsCult;
    @FXML
    private Button btnDetailsMon;
    public static int id;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      showMon();
      showEsp();// TODO
    }    

    @FXML
    private void fnSelectedEsp(MouseEvent event) {
        Reservation mon= tvEsp.getSelectionModel().getSelectedItem();
        id_esp.setText(String.valueOf(mon.getId()));
    }

    @FXML
    private void fnSelectedMon(MouseEvent event) {
        Reservation mon= tvMon.getSelectionModel().getSelectedItem();
        id_mon.setText(String.valueOf(mon.getId()));
        System.out.println(String.valueOf(mon.getId()));
    }

    @FXML
    private void fnDetails(ActionEvent event) throws IOException {
        id=Integer.parseInt(id_esp.getText());
        Parent etab = FXMLLoader.load(getClass().getResource("DetailsReservationEsp.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void fnDetailsMon(ActionEvent event) throws IOException {
        id=Integer.parseInt(id_mon.getText());
        Parent etab = FXMLLoader.load(getClass().getResource("DetailsReservationMon.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    public void showEsp(){
        ServiceReservation sr= new ServiceReservation() {};
        List reser = sr.afficheEspCult(1);
        ObservableList list =FXCollections.observableArrayList(reser);
        
         EspID.setCellValueFactory(new PropertyValueFactory<>("id")); 
     EspDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));       
     EspIdEsp.setCellValueFactory(new PropertyValueFactory<>("id_esp"));  
       
          

                  
        
        
        tvEsp.setItems(list);
        
    }
    public void showMon(){
        ServiceReservation sr= new ServiceReservation() {};
        List reser = sr.afficheMonum(1);
        ObservableList list =FXCollections.observableArrayList(reser);
        
         MonId.setCellValueFactory(new PropertyValueFactory<>("id")); 
     MonDate.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));       
     MonIdEsp.setCellValueFactory(new PropertyValueFactory<>("id_esp"));  
       
          

                  
        
        
        tvMon.setItems(list);
        
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ClientEspMon.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
