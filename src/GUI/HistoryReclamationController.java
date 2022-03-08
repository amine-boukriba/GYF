/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.status;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceStatus;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class HistoryReclamationController implements Initializable {

    @FXML
    private TableView<status> tvhist;
    @FXML
    private TableColumn<status, Integer> Cl_Id;
    @FXML
    private TableColumn<status, Integer> Cl_Rec;
    @FXML
    private TableColumn<status, String> Cl_Type;
    @FXML
    private TableColumn<status, String> Cl_Message;
    @FXML
    private Button BtnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fnShow(); // TODO
    }    

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
       
       
        Parent etab = FXMLLoader.load(getClass().getResource("gestionreclamationadmin.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    public void fnShow(){
        ServiceStatus rp=new ServiceStatus();
          ObservableList<status> list = FXCollections.observableArrayList(rp.affichestatus(GestionreclamationadminController.id));
    Cl_Id.setCellValueFactory(new PropertyValueFactory<>("id_status")); 
     Cl_Rec.setCellValueFactory(new PropertyValueFactory<>("id_reclamation")); 
     Cl_Type.setCellValueFactory(new PropertyValueFactory<>("nom_status"));
     Cl_Message.setCellValueFactory(new PropertyValueFactory<>("message")); 
        tvhist.setItems( list);
    }
    
}
