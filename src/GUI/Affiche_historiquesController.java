/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Historiques;
import entities.Roles;
import entities.Users;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
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
public class Affiche_historiquesController implements Initializable {

    @FXML
    private TableView<Historiques> tvhistorique;
    @FXML
    private TextField recherche;
    @FXML
    private TableView<Users> tvuser;
    @FXML
    private TableColumn<Users,String> last_name;
    @FXML
    private TableColumn<Historiques, String> entry_date;
    @FXML
    private TableColumn<Historiques, String> leave_date;
    @FXML
    private TableColumn<Historiques,Long> duration;
    @FXML
    private TableColumn<Users, String> email;
    @FXML
    private TableColumn<Users, String> name;
    Globals global=new Globals();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recherche_hisoto_by_user();
        recherche.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            recherche_hisoto_by_user();
                    });
    }

        
    public void recherche_hisoto_by_user()
    {
        HashMap<Historiques,Users> map= new HashMap();
        map=global.servicehistoriques.filter_historiques(recherche.getText());
        Collection<Users> values = map.values();
        ArrayList<Users> list_user= new ArrayList<>(values);
        Set<Historiques> set_historiques=map.keySet();
        ArrayList <Historiques>list_historiques=new ArrayList<Historiques>(set_historiques);
        ObservableList observable_list_user =FXCollections.observableArrayList(list_user);
        ObservableList observable_list_historiques =FXCollections.observableArrayList(list_historiques);

        
     name.setCellValueFactory(new PropertyValueFactory<>("nom_user")); ;
     last_name.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));                
        email.setCellValueFactory(new PropertyValueFactory<>("email_user"));
          duration.setCellValueFactory(new PropertyValueFactory<>("duree"));
          leave_date.setCellValueFactory(new PropertyValueFactory<>("sortie_date"));
        entry_date.setCellValueFactory(new PropertyValueFactory<>("entre_date"));
        tvuser.setItems(observable_list_user);
        tvhistorique.setItems(observable_list_historiques);
    }
}
