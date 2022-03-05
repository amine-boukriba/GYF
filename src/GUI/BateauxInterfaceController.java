/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Bateaux;
import entities.Offers;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import services.ServiceBateaux;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class BateauxInterfaceController implements Initializable {

    String path="";
    ServiceBateaux sb = new ServiceBateaux();
    @FXML
    private Label label_id;
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
    private TextField input_id;
    @FXML
    private TableView<Bateaux> tab_bateau;
    @FXML
    private TableColumn<Bateaux, Integer> tab_id;
    @FXML
    private TableColumn<Bateaux, String> tab_comp;
    @FXML
    private TableColumn<Bateaux, String> tab_depart;
    @FXML
    private TableColumn<Bateaux, String> tab_dest;
    @FXML
    private TableColumn<Bateaux, Date> tabd_dat_dep;
    @FXML
    private TableColumn<Bateaux, Date> tab_date_arr;
    @FXML
    private TableColumn<Bateaux, Float> tab_prix;
    @FXML
    private TableColumn<Bateaux, Integer> tab_duree;
    @FXML
    private TableColumn<Bateaux, String> tab_nom_bateau;
    @FXML
    private TableColumn<?, String> tab_img_bateau;
    @FXML
    private TableColumn<?, Integer> tab_avis;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_sup;
    @FXML
    private TextField compMar;
    @FXML
    private TextField nom_bateau;
    @FXML
    private TextField image_bateau;
    @FXML
    private TextField avis_bateau;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }    

    private void afficher(){
        ObservableList <Bateaux> data = FXCollections.observableArrayList(sb.affiche());
        tab_bateau.getItems().clear();
        //System.out.println(sb.affiche());
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id_bateau"));
        tab_comp.setCellValueFactory(new PropertyValueFactory<>("compagnie_maritime"));
        tab_depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        tab_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tabd_dat_dep.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        tab_date_arr.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        tab_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tab_duree.setCellValueFactory(new PropertyValueFactory<>("duree"));
        tab_nom_bateau.setCellValueFactory(new PropertyValueFactory<>("nom_bateau"));
        tab_img_bateau.setCellValueFactory(new PropertyValueFactory<>("image_bateau"));
        tab_avis.setCellValueFactory(new PropertyValueFactory<>("avis_bateau"));
        for (Bateaux b : data){
            //System.out.println(b);
        tab_bateau.getItems().add(b);
            //System.out.println();
        }
    }
    @FXML
    private void saveImage(ActionEvent event) {
        
        File source = null;
            File dest = null;
        try {
            JFileChooser chos= new JFileChooser();
            chos.showOpenDialog(null);
            File f = chos.getSelectedFile();
            
            
            String img = f.getAbsolutePath();
            
            image_bateau.setText(img);
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
            String alphabet = "123xyz";
            for (int i = 0; i < 30; i++) {
                  name +=  alphabet.charAt(r.nextInt(alphabet.length()));
            }
            
            dest = new File(newPath+name+'.'+ext);
            Files.copy(source.toPath(), dest.toPath());

                        System.out.println(dest.toString());


          
            this.path=name+'.'+ext;
        } catch (IOException ex) {
            Logger.getLogger(VolInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getValues() {
        List<Bateaux> list = new ArrayList<>();
        tab_bateau.setOnMouseClicked((MouseEvent event) -> {
            Bateaux listBateaux = tab_bateau.getItems().get(tab_bateau.getSelectionModel().getSelectedIndex());
             compMar.setText(listBateaux.getCompagnie_maritime());
            depart.setText(listBateaux.getDepart());
            destination.setText(listBateaux.getDestination());
            //date_dep.setDayCellFactory(value);
            //date_arr.setValue(listVols.getDate_arrive());
            prix.setText(Float.toString(listBateaux.getPrix()));
            duree.setText(Integer.toString(listBateaux.getDuree()));
            nom_bateau.setText(listBateaux.getNom_bateau());
            image_bateau.setText(listBateaux.getImage_bateau());
            avis_bateau.setText(Integer.toString(listBateaux.getAvis_bateau()));
            input_id.setText(Integer.toString(listBateaux.getId_bateau()));
            list.add(listBateaux);
        });
    }

    @FXML
    private void ajouter(ActionEvent event) {
        Bateaux b = new Bateaux();
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(prix.getText());
        Matcher m1 = p.matcher(duree.getText());
        Matcher m2 = p.matcher(avis_bateau.getText());
        if(compMar.getText().isEmpty() && depart.getText().isEmpty() && destination.getText().isEmpty() && date_dep.getValue()==null && date_arr.getValue()==null && prix.getText().isEmpty()&&nom_bateau.getText().isEmpty()&&duree.getText().isEmpty()&&image_bateau.getText().isEmpty()&&avis_bateau.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("text non valide");
				alert.setContentText("saisire tous les champ");
                                Optional<ButtonType> result = alert.showAndWait();

                                
        }else if (!(m.find() && m.group().equals(prix.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
        }
        else if (!(m1.find() && m1.group().equals(duree.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
        }
        else if (!(m2.find() && m2.group().equals(avis_bateau.getText()) )){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
        }else if(Date.valueOf(date_dep.getValue()).compareTo(Date.valueOf(date_arr.getValue()))>0 ){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Date not valid");
				alert.setContentText("la date d'arriver doit etre superieur a date de depart");
                                Optional<ButtonType> result = alert.showAndWait();
                                
        }
        else{
           b.setCompagnie_maritime(compMar.getText());
        b.setDepart(depart.getText());
        b.setDestination(destination.getText());
        b.setDate_depart(Date.valueOf(date_dep.getValue()));
        b.setDate_arrive(Date.valueOf(date_arr.getValue()));
        b.setPrix(Integer.parseInt(prix.getText()));
        b.setDuree(Integer.parseInt(duree.getText()));
        b.setNom_bateau(nom_bateau.getText());
        b.setImage_bateau(path);
        b.setAvis_bateau(Integer.parseInt(avis_bateau.getText()));
        
        
        sb.ajout(b);
        afficher();  
        }
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        Bateaux b = new Bateaux();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	alert.setTitle("warning");
	alert.setContentText("Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            b.setCompagnie_maritime(compMar.getText());
        b.setDepart(depart.getText());
        b.setDestination(destination.getText());
        b.setDate_depart(Date.valueOf(date_dep.getValue()));
        b.setDate_arrive(Date.valueOf(date_arr.getValue()));
        b.setPrix(Integer.parseInt(prix.getText()));
        b.setDuree(Integer.parseInt(duree.getText()));
        b.setNom_bateau(nom_bateau.getText());
        b.setImage_bateau(path);
        b.setAvis_bateau(Integer.parseInt(avis_bateau.getText()));
        b.setId_bateau(Integer.parseInt(input_id.getText()));
        
        sb.modifier(b);
        afficher(); 
        }
        else{
            System.out.println("");
        }
    }

    @FXML
    private void supprime(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	alert.setTitle("warning");
	alert.setContentText(" Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           sb.supprime(Integer.parseInt(input_id.getText()));
        afficher(); 
        }
        else{
            System.out.println("");
        }
        
    }
    
}
