/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import services.ServiceEvents;

/**
 * FXML Controller class
 *
 * @author mouham
 */
public class AfficherCalenderierController implements Initializable {

    @FXML
    private Button btnRetour;
    @FXML
    private Agenda Agenda;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvents sp = new ServiceEvents();
        List<Evenement> Eventss = sp.affiche();
        for(int i=0;i<Eventss.size();i++){
            Agenda.appointments().add(new Agenda.AppointmentImplLocal()
             .withStartLocalDateTime(Eventss.get(i).getDate_debut().toLocalDate().atTime(7, 00))
             .withEndLocalDateTime(Eventss.get(i).getDate_fin().toLocalDate().atTime(10, 00))
              .withDescription(Eventss.get(i).getNom())
              
                
           );
        }
       
        
        // TODO
    }    

    @FXML
    private void Onclick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("view.fxml"));
                Parent Ajouter = (Parent)loader.load();                      
                Scene scene = new Scene(Ajouter);
                
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
    }
    
}
