/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Vols;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ServiceVols;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class VolInterfaceController implements Initializable {
    
    String path="";
    ServiceVols sv = new ServiceVols();

    @FXML
    private TextField compAeri;
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private DatePicker date_dep;
    @FXML
    private DatePicker date_arr;
    @FXML
    private TextField prix;
    @FXML
    private TextField duree;
    @FXML
    private TextField type_avion;
    @FXML
    private TextField image_vol;
    @FXML
    private TextField avis_vol;
    @FXML
    private TableView<Vols> tab_vols;
    @FXML
    private TableColumn<Vols, Integer> tab_id;
    @FXML
    private TableColumn<Vols, String> tab_comp;
    @FXML
    private TableColumn<Vols, String> tab_depart;
    @FXML
    private TableColumn<Vols, String> tab_dest;
    @FXML
    private TableColumn<Vols, Date> tabd_dat_dep;
    @FXML
    private TableColumn<Vols, Date> tab_date_arr;
    @FXML
    private TableColumn<Vols, Integer> tab_prix;
    @FXML
    private TableColumn<Vols, Integer> tab_duree;
    @FXML
    private TableColumn<Vols, String> tab_tyope_avion;
    @FXML
    private TableColumn<Vols, String> tab_img_vol;
    @FXML
    private TableColumn<Vols, Integer> tab_avis;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_sup;
    @FXML
    private Label label_id;
    @FXML
    private TextField input_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affiche();
       
    }    

    private void affiche(){
        ObservableList <Vols> data = FXCollections.observableArrayList(sv.affiche());
        tab_vols.getItems().clear();
        //System.out.println(sv.affiche());
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id_vol"));
        tab_comp.setCellValueFactory(new PropertyValueFactory<>("compagnie_aerien"));
        tab_depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        tab_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tabd_dat_dep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tab_date_arr.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        tab_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tab_duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        tab_tyope_avion.setCellValueFactory(new PropertyValueFactory<>("type_avion"));
        tab_img_vol.setCellValueFactory(new PropertyValueFactory<>("image_vol"));
        tab_avis.setCellValueFactory(new PropertyValueFactory<>("avis_vol"));
        for (Vols v : data){
            //System.out.println(v);
        tab_vols.getItems().add(v);
        
            //System.out.println();
        }
    }
    
    public boolean checkData(){
        boolean v=false;
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(prix.getText());
        Matcher m1 = p.matcher(duree.getText());
        Matcher m2 = p.matcher(avis_vol.getText());
        
        
        if(compAeri.getText().isEmpty() || depart.getText().isEmpty() || destination.getText().isEmpty() || date_dep.getValue()==null || date_arr.getValue()==null || prix.getText().isEmpty() ||duree.getText().isEmpty() ||type_avion.getText().isEmpty() ||image_vol.getText().isEmpty() ||avis_vol.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("text non valide");
				alert.setContentText("saisire tous les champ");
                                Optional<ButtonType> result = alert.showAndWait();
                                v=true;
                                
        }else if (!(m.find() && m.group().equals(prix.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                v=true;
        }
        else if (!(m1.find() && m1.group().equals(duree.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                v=true;
        }
        else if (!(m2.find() && m2.group().equals(avis_vol.getText()) )){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                v=true;
        }else if(Date.valueOf(date_dep.getValue()).compareTo(Date.valueOf(date_arr.getValue()))>0 ){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Date not valid");
				alert.setContentText("la date d'arriver doit etre superieur a date de depart");
                                Optional<ButtonType> result = alert.showAndWait();
                                v=true;
        }
            return v;
    }
    @FXML
    private void ajouter(ActionEvent event) {
 
        
        if(checkData()== false){
         Vols v = new Vols();
        v.setCompagnie_aerien(compAeri.getText());
        v.setDepart(depart.getText());
        v.setDestination(destination.getText());
        v.setDate_depart(Date.valueOf(date_dep.getValue()));
        v.setDate_arrive(Date.valueOf(date_arr.getValue()));
        v.setPrix(Integer.parseInt(prix.getText()));
        v.setDuree(Integer.parseInt(duree.getText()));
        v.setType_avion(type_avion.getText());
        v.setImage_vol(path);
        v.setAvis_vol(Integer.parseInt(avis_vol.getText()));
        
        sv.ajout(v);
        affiche();   
        }
        
    }
    

    @FXML
    private void modifier(ActionEvent event) {
         Vols v = new Vols();
         Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Unsaved data warning");
	alert.setContentText("There is unsaved data. Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
		         
        v.setCompagnie_aerien(compAeri.getText());
        v.setDepart(depart.getText());
        v.setDestination(destination.getText());
        v.setDate_depart(Date.valueOf(date_dep.getValue()));
        v.setDate_arrive(Date.valueOf(date_arr.getValue()));
        v.setPrix(Integer.parseInt(prix.getText()));
        v.setDuree(Integer.parseInt(duree.getText()));
        v.setType_avion(type_avion.getText());
        v.setImage_vol(path);
        v.setAvis_vol(Integer.parseInt(avis_vol.getText()));
        v.setId_vol(Integer.parseInt(input_id.getText()));
        sv.modifier(v);
        affiche();
        }
        else{
            System.out.println();
        }
         
        
    }

    @FXML
    private void supprime(ActionEvent event) {
         Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Unsaved data warning");
	alert.setContentText("There is unsaved data. Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
            sv.supprime(Integer.parseInt(input_id.getText()));
        affiche();
        }
        else{
            System.out.println();
        }
        
    }

    @FXML
    private void getValues() {
        List<Vols> list = new ArrayList<>();
            tab_vols.setOnMouseClicked((MouseEvent event) -> {
            Vols listVols = tab_vols.getItems().get(tab_vols.getSelectionModel().getSelectedIndex());
            compAeri.setText(listVols.getCompagnie_aerien());
            depart.setText(listVols.getDepart());
            destination.setText(listVols.getDestination());
            //date_dep.setDayCellFactory(value);
            //date_arr.setValue(listVols.getDate_arrive());
            prix.setText(Float.toString(listVols.getPrix()));
            duree.setText(Integer.toString(listVols.getDuree()));
            type_avion.setText(listVols.getType_avion());
            image_vol.setText(listVols.getImage_vol());
            avis_vol.setText(Integer.toString(listVols.getAvis_vol()));
            list.add(listVols);
        });
        
    }
 
    @FXML
    private void saveImage() {
        File source = null;
            File dest = null;
        try {
            JFileChooser chos= new JFileChooser();
            chos.showOpenDialog(null);
            File f = chos.getSelectedFile();
            
            
            String img = f.getAbsolutePath();
            
            image_vol.setText(img);
            Image getAbsolutePath = null;
            ImageIcon icon = new ImageIcon(img);
            //Image image = icon.getImage().getScaledInstance(50, 50, 50);
            
            String filePath = new File("").getAbsolutePath();
            String newPath =filePath.concat("\\src\\Images\\");
            
            File directory = new File(newPath);
            if(!(directory.exists())){
                directory.mkdirs();
            }
            
            
            String ext = img.substring(img.lastIndexOf('.')+1);
            source = new File(img);
            
            Random r = new Random();
            String name="";
            String alphabet = "123adftnxyz";
            for (int i = 0; i < 30; i++) {
                  name +=  alphabet.charAt(r.nextInt(alphabet.length()));
            }
            System.out.println(name);
            
            dest = new File(newPath+name+'.'+ext);
            Files.copy(source.toPath(), dest.toPath());

            

//            System.out.println(source);
//            System.out.println(dest);
            this.path=name+'.'+ext;
        } catch (IOException ex) {
            Logger.getLogger(VolInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
