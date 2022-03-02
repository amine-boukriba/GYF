/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class AddReservationMonController implements Initializable {

    @FXML
    private TextField tfNumCard;
    @FXML
    private TextField tfPasswordCard;
    @FXML
    private DatePicker tfDate;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnConfirm(ActionEvent event) throws IOException {
        ServiceReservation ser=new ServiceReservation();
        Reservation rec=new Reservation();
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        rec.setCard_password(tfPasswordCard.getText());
        rec.setDate_reservation(tfDate.getValue().toString());
        rec.setId_esp(ClientEspaceCulturelsController.id);
        rec.setUser(1);
        rec.setType(Boolean.FALSE);
        rec.setNum_card(Integer.parseInt(tfNumCard.getText()));
        if(tfPasswordCard.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le mot de passe!");
            alert.show();
        }else{
            ser.ajout(rec);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("paiement ajoutée avec succés!");
            alert.show();
        }
       
        Parent etab = FXMLLoader.load(getClass().getResource("MesReservation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void fnCancel(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ClientMonuments.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
