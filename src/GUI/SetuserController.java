/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Roles;
import entities.Users;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.Globals;

/**
 * FXML Controller class
 *
 * @author boukr
 */
public class SetuserController implements Initializable {

    @FXML
    private TableColumn<Users,String> name;
    @FXML
    private TableColumn<Users,String> last_name;
    @FXML
    private TableColumn<Users,String> sexe;
    @FXML
    private TableColumn<Users,Integer> telephone;
    @FXML
    private TableColumn<Users,String> email;
    @FXML
    private TableColumn<Users,String> pays;
    @FXML
    private TableColumn<Users,String> ville;
    @FXML
    private TableColumn<Users,Integer> zip;
    @FXML
    private TableColumn<Users,Date> date;
    @FXML
    private TableColumn<Users,String> blocked;
    @FXML
    private TableColumn<Users,String> verified;
    @FXML
    private TableView<Users> TVuser;
    @FXML
    private TableColumn<Roles,String> role;
    Globals global=new Globals();
    @FXML
    private TextField recherche;
    @FXML
    private TableView<Roles> TV_role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rehcherche_user();
        recherche.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            rehcherche_user();
        });

    }   
    
    
    
    public void rehcherche_user(){
        HashMap<Roles,Users> map= new HashMap();
        map=global.serviceuser.filter_users(recherche.getText());
        Collection<Users> values = map.values();
        ArrayList<Users> list_user= new ArrayList<>(values);
        Set<Roles> set_roles=map.keySet();
        ArrayList <Roles>list_role=new ArrayList<Roles>(set_roles);
        ObservableList observable_list_user =FXCollections.observableArrayList(list_user);
        ObservableList observable_list_role =FXCollections.observableArrayList(list_role);

        
     name.setCellValueFactory(new PropertyValueFactory<>("nom_user")); ;
     last_name.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));       
     sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));          
        telephone.setCellValueFactory(new PropertyValueFactory<>("numero_tel"));
        email.setCellValueFactory(new PropertyValueFactory<>("email_user"));
          pays.setCellValueFactory(new PropertyValueFactory<>("pays_user"));
          ville.setCellValueFactory(new PropertyValueFactory<>("ville_user"));
          zip.setCellValueFactory(new PropertyValueFactory<>("code_postal"));
          date.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
          blocked.setCellValueFactory(new PropertyValueFactory<>("blocked"));
         verified.setCellValueFactory(new PropertyValueFactory<>("verification"));
        role.setCellValueFactory(new PropertyValueFactory<>("label"));
        TVuser.setItems(observable_list_user);
        TV_role.setItems(observable_list_role);
        

    }
    
}
