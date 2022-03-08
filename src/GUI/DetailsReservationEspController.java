/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Espace_culturels;
import entities.Monuments;
import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.ServiceEspaceCulturel;
import services.ServiceMonuments;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class DetailsReservationEspController implements Initializable {

    @FXML
    private TextField tfNumCard;
    @FXML
    private TextField tfPasswordCard;
    @FXML
    private DatePicker tfDate;
    @FXML
    private Label lbNom;
    @FXML
    private Label lbPays;
    @FXML
    private Label lbLocalisation;
    @FXML
    private Label lbDesc;
    @FXML
    private ImageView imgView;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSupp;
    @FXML
    private Label filename;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceReservation ser=new ServiceReservation();
        Reservation m=ser.getReservById(MesReservationController.id);
        tfDate.setValue(LocalDate.parse(m.getDate_reservation()));
        tfNumCard.setText(String.valueOf(m.getNum_card()));
        tfPasswordCard.setText(m.getCard_password());
        ServiceEspaceCulturel serM=new ServiceEspaceCulturel();
        Espace_culturels mon=serM.getEspace_culturelsById(m.getId_esp());
        lbNom.setText(mon.getNom_espace());
        lbDesc.setText(mon.getDescription());
        lbLocalisation.setText(mon.getLocalisation());
        lbPays.setText(mon.getPays());
        filename.setText(mon.getImage_espace());
        String img="file:///"+filename.getText();
       Image image=new Image(img);
       imgView.setImage(image); // TODO
    }    

    @FXML
    private void fnModif(ActionEvent event) throws IOException {
        ServiceReservation ser=new ServiceReservation();
        Reservation m=ser.getReservById(MesReservationController.id);
        m.setCard_password(tfPasswordCard.getText());
        m.setDate_reservation(tfDate.getValue().toString());
        m.setNum_card(Integer.parseInt(tfNumCard.getText()));
        ser.modifier(m);
        Parent etab = FXMLLoader.load(getClass().getResource("MesReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void fnSupp(ActionEvent event) throws IOException {
        ServiceReservation ser=new ServiceReservation();
        ser.supprime(MesReservationController.id);
        Parent etab = FXMLLoader.load(getClass().getResource("MesReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void FnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("MesReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
