/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TypeReclamationController implements Initializable {

    @FXML
    private ComboBox<String> ComboList;
    @FXML
    private Button btnSuivant;
    public static ObservableList<String> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        ObservableList<String>  list =FXCollections.observableArrayList("compte","monument","Espace_Culturels","restaurant","hotel","evenement","voyage"); // TODO
    ComboList.setItems(list);
    }    

    @FXML
    private void fnSuivant(ActionEvent event) throws IOException {
        if(ComboList.getValue().equals("monument")){
            ServiceMonument ser=new ServiceMonument();
            list=FXCollections.observableArrayList(ser.affiche().getNom_monument());
            Parent etab = FXMLLoader.load(getClass().getResource("ajoutreclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
        }else if(ComboList.getValue().equals("Espace_Culturels")){
            ServiceEspaceCulturel ser=new ServiceEspaceCulturel();
            list=FXCollections.observableArrayList(ser.affiche().getNom_espace());
            Parent etab = FXMLLoader.load(getClass().getResource("ajoutreclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
            
        }
        
    }
    
}
