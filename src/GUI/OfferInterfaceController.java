/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Bateaux;
import entities.Images;
import entities.Offers;
import entities.Vols;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import services.ServiceImages;
import services.ServiceOffers;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class OfferInterfaceController implements Initializable {

    String path="";
    ServiceOffers sf = new ServiceOffers();
    ServiceImages si = new ServiceImages();
    @FXML
    private Label label_id;
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private TextField prix;
    @FXML
    private TextField input_id;
    
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_sup;
    
    @FXML
    private TextField titre;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField nb_nuit;
    @FXML
    private TextField description;
    @FXML
    private TextField image_offer;
    @FXML
    private TextField avis_offer;
    @FXML
    private TableView<Offers> tab_offer;

    @FXML
    private TableColumn<Offers, String> tab_depart;
    @FXML
    private TableColumn<Offers, String> tab_dest;
    @FXML
    private TableColumn<Offers, Float> tab_prix;
    @FXML
    private TableColumn<Offers, Integer> tab_avis;
    @FXML
    private TableColumn<Offers, String> tab_titre;
    @FXML
    private TableColumn<Offers, Date> tabd_dat_debut;
    @FXML
    private TableColumn<Offers, Date> tab_date_fin;
    @FXML
    private TableColumn<Offers, Integer> tab_nb_nuit;
    @FXML
    private TableColumn<Offers, String> tab_description;
    @FXML
    private TableColumn<Offers, String> tab_img_offer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
    }    
    
    private void afficher(){
        ObservableList <Offers> data = FXCollections.observableArrayList(sf.affiche());
        
        tab_offer.getItems().clear();
        
        tab_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        tab_depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        tab_dest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tabd_dat_debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        tab_date_fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        tab_nb_nuit.setCellValueFactory(new PropertyValueFactory<>("nombre_nuits"));
        tab_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tab_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        tab_avis.setCellValueFactory(new PropertyValueFactory<>("avis_offer"));
        tab_img_offer.setCellValueFactory(new PropertyValueFactory<>("path"));
        for (Offers o : data){
            //System.out.println(b);
        tab_offer.getItems().add(o);
        
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
            
            image_offer.setText(img);
            Image getAbsolutePath = null;
            ImageIcon icon = new ImageIcon(img);
            Image image = icon.getImage().getScaledInstance(50, 50, 50);
            
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
            //System.out.println(name);
            
            dest = new File(newPath+name+'.'+ext);
            Files.copy(source.toPath(), dest.toPath());

            

//            System.out.println(source);
//            System.out.println(dest);
            this.path=name+'.'+ext;
        } catch (IOException ex) {
            Logger.getLogger(VolInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void getValues() {
        List<Offers> list = new ArrayList<>();
        tab_offer.setOnMouseClicked((MouseEvent event) -> {
            Offers listOffers = tab_offer.getItems().get(tab_offer.getSelectionModel().getSelectedIndex());
            titre.setText(listOffers.getTitre());
            depart.setText(listOffers.getDepart());
            destination.setText(listOffers.getDestination());
            date_debut.setValue(listOffers.getDate_debut().toLocalDate());
            date_fin.setValue(listOffers.getDate_fin().toLocalDate());
            prix.setText(Math.round(listOffers.getPrix())+"");
            nb_nuit.setText(Integer.toString(listOffers.getNombre_nuits()));
            description.setText(listOffers.getDescription());
            image_offer.setText(listOffers.getPath());
            avis_offer.setText(Integer.toString(listOffers.getAvis_offer()));
            input_id.setText(Integer.toString(listOffers.getId_offer()));
            list.add(listOffers);
        });
    }

    private boolean checkData(){
        boolean v = false;
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(prix.getText());
        Matcher m1 = p.matcher(nb_nuit.getText());
        Matcher m2 = p.matcher(avis_offer.getText());
        if(titre.getText().isEmpty() || depart.getText().isEmpty() || destination.getText().isEmpty() || date_debut.getValue()==null || date_fin.getValue()==null || prix.getText().isEmpty() || nb_nuit.getText().isEmpty() ||description.getText().isEmpty() ||image_offer.getText().isEmpty() ||avis_offer.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("text non valide");
				alert.setContentText("saisire tous les champ");
                                Optional<ButtonType> result = alert.showAndWait();
                                v = true;
                                
        }else if (!(m.find() && m.group().equals(prix.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                 v = true;
        }
        else if (!(m1.find() && m1.group().equals(nb_nuit.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                 v = true;
        }
        else if (!(m2.find() && m2.group().equals(avis_offer.getText()) )){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("number non valide");
				alert.setContentText("must be number");
                                Optional<ButtonType> result = alert.showAndWait();
                                 v = true;
        }else if(Date.valueOf(date_debut.getValue()).compareTo(Date.valueOf(date_fin.getValue()))>0 ){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText("Date not valid");
				alert.setContentText("la date d'arriver doit etre superieur a date de depart");
                                Optional<ButtonType> result = alert.showAndWait();
                                 v = true;
                                
        }
        return v;
    }
    @FXML
    private void ajouter(ActionEvent event) {
         
        if(checkData()==false){
        Offers o = new Offers();
        o.setTitre(titre.getText());
        o.setDepart(depart.getText());
        o.setDestination(destination.getText());
        o.setDate_debut(Date.valueOf(date_debut.getValue()));
        o.setDate_fin(Date.valueOf(date_fin.getValue()));
        o.setNombre_nuits(Integer.parseInt(nb_nuit.getText()));
        o.setDescription(description.getText());
        o.setPrix(Integer.parseInt(prix.getText()));

        o.setAvis_offer((Integer.parseInt(avis_offer.getText())));
        sf.ajout(o);
        Images i = new Images();
        i.setId_offer(sf.lastId());
        
        i.setPath(path);
        
        //System.out.println(i);
        si.ajout(i);
        afficher();
        

       
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OfferOptionInterface.fxml"));
            Parent root = loader.load();
            
            OfferOptionInterfaceController controller = loader.getController();
            controller.setIdValues(sf.lastId(),Date.valueOf(date_debut.getValue()),depart.getText()+"",destination.getText()+"");
            btn_ajout.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(OfferInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
        if(checkData()==false){
        Offers o = new Offers();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	alert.setTitle("Unsaved data warning");
	alert.setContentText("There is unsaved data. Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
            o.setTitre(titre.getText());
        o.setDepart(depart.getText());
        o.setDestination(destination.getText());
        o.setDate_debut(Date.valueOf(date_debut.getValue()));
        o.setDate_fin(Date.valueOf(date_fin.getValue()));
        o.setNombre_nuits(Integer.parseInt(nb_nuit.getText()));
        o.setDescription(description.getText());
        o.setPrix(Integer.parseInt(prix.getText()));

        o.setAvis_offer((Integer.parseInt(avis_offer.getText())));
        o.setId_offer(Integer.parseInt(input_id.getText()));
        
        
        sf.modifier(o);
        Images i = new Images();
        i.setId_offer(Integer.parseInt(input_id.getText()));
        
        i.setPath(path);
        
        System.out.println(i);
        si.modifier(i);
        afficher();
        }
        else{
            System.out.println("");
        }
        }
    }

    @FXML
    private void supprime(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	alert.setTitle("Unsaved data warning");
	alert.setContentText("There is unsaved data. Do you want to continue and lose data ?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
          sf.supprime(Integer.parseInt(input_id.getText()));
          sf.affiche();  
        }
        else{
            System.out.println("");
        }
        
    }
    
}
