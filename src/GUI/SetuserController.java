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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.FormatStyle;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseButton;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import services.ServicesUsers;

import utils.Globals;
import static utils.Password_hash.getSHA;
import static utils.Password_hash.toHexString;

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
    @FXML
    private Button delete;
    @FXML
    private Button block;
    @FXML
    private Button admin;
    @FXML
    private TextField text_name;
    @FXML
    private Button update;
    @FXML
    private TextField text_last_name;
    @FXML
    private TextField text_telephone;
    @FXML
    private TextField text_email;
    @FXML
    private TextField text_pays;
    @FXML
    private TextField text_ville;
    @FXML
    private TextField text_zip;
    @FXML
    private DatePicker text_date;
    ObservableList<String> langs = FXCollections.observableArrayList("male","female");
    @FXML
    private ChoiceBox<String> text_sexe;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text_sexe.setItems(langs);
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
@FXML
    public void make_admin(ActionEvent event) {
    Users user = TVuser.getSelectionModel().getSelectedItem();
    global.serviceuser.make_admin(user);
    rehcherche_user();
        }
    @FXML
    public void blockUnblock(ActionEvent event) {
    Users user = TVuser.getSelectionModel().getSelectedItem();
        global.serviceuser.blockUnblock(user);
        rehcherche_user();
    
    }
    @FXML
    public void delete(ActionEvent event) {
    Users user = TVuser.getSelectionModel().getSelectedItem();
        global.serviceuser.delete_user(user);
        rehcherche_user();

    }
    @FXML
    public void update(ActionEvent event) {
    Users user = new Users();
    Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        if((text_name.getText().isEmpty())||!(text_name.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("please insert your first name correctly!");
            alert.show();
        }
        else if ((text_last_name.getText().isEmpty())||!(text_last_name.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("please insert your last name correctly!");
            alert.show();
        }
        else if((text_telephone.getText().isEmpty())||(!Pattern.matches("^\\d*$",text_telephone.getText()))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your phone number correctly");
            alert.show();
        }
        else if((text_pays.getText().isEmpty())||(!text_pays.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your country correctly");
            alert.show();
        }
        else if((text_ville.getText().isEmpty())||(!text_ville.getText().matches("[a-zA-Z]+"))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert your city correctly");
            alert.show();
        }
        else if((text_zip.getText().isEmpty())||(!Pattern.matches("^\\d*$",text_zip.getText()))){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("\"please insert you phone number correctly");
            alert.show();
        }
            else if(text_date.getValue()==null){
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("\"please enter your birth date");
                alert.show();
            }
            else if(text_sexe.getValue()==null){
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("\"please enter your gender");
                alert.show();
            }
            else{
                user.setPrenom_user(text_name.getText());
                user.setNom_user(text_last_name.getText());
                int numero = Integer.parseInt(text_telephone.getText());
                user.setNumero_tel(numero);
                user.setEmail_user(text_email.getText());
                user.setPays_user(text_pays.getText());
                user.setVille_user(text_ville.getText());
                user.setSexe(text_sexe.getValue());
                int numero_zip = Integer.parseInt(text_zip.getText());
                user.setCode_postal(numero_zip);
                Date dateee = Date.valueOf(text_date.getValue()); // Magic happens here!
                user.setDate_naissance(dateee);
                global.serviceuser.modifier_by_email(user);
                rehcherche_user();

    }
    }
     @FXML
    private void fnSelected(MouseEvent event) {
        Users user= TVuser.getSelectionModel().getSelectedItem();
        text_name.setText(user.getPrenom_user());
        text_last_name.setText(user.getNom_user());
        text_email.setText(user.getEmail_user());
        text_sexe.setValue(user.getSexe());
        text_pays.setText(user.getPays_user());
        text_ville.setText(user.getVille_user());
        text_telephone.setText(Integer.toString(user.getNumero_tel()));
        text_zip.setText(Integer.toString(user.getCode_postal()));
        text_date.setValue(user.getDate_naissance().toLocalDate());
    }

   




    
    
}
