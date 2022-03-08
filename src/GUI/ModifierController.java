/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import services.ServiceEvents;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class ModifierController implements Initializable {

    @FXML
    private AnchorPane modifier;
    private Button seachhotels;
    private Button seachresto;
    private Button searchEvents;
    private Button seachhistoires;
    @FXML
    private TextField nom_evenement;
    @FXML
    private TextField type_evenement;
    @FXML
    private DatePicker date_debut;
    @FXML
    private DatePicker date_fin;
    @FXML
    private TextField prix_evenement;
    @FXML
    private TextField pays_evenement;
    @FXML
    private Button Modifier_event;
    private Button logout;
    private Button gerer_event;
    @FXML
    private TextField nbre_participants;
    @FXML
    private TextField localisation_event;
    @FXML
    private Button image_event;
    @FXML
    private TextArea description_event;
    private Button reclamation;
    private Button offre;
    private Button users;
    private Button bateau;
    private Button vol;
    ServiceEvents se = new ServiceEvents();
     Evenement u=new Evenement();
    @FXML
    private TableView<Evenement> table_events;
    @FXML
    private TableColumn<Evenement,String> nom_event;
    @FXML
    private TableColumn<Evenement,String> type_event;
    @FXML
    private TableColumn<Evenement,Integer> nbre_parti_event;
    @FXML
    private TableColumn<Evenement,Integer> prix_event;
    @FXML
    private TableColumn<Evenement,String> localisation_event_table;
    @FXML
    private TableColumn<Evenement,String> image_event_table;
    @FXML
    private TableColumn<Evenement,Date> date_debut_table;
    @FXML
    private TableColumn<Evenement,Date> date_fin_table;
      int index =-1;
   ObservableList<Evenement> Events = FXCollections.observableArrayList();
   ObservableList<Evenement> allEvents;
   ObservableList<Evenement> selectedevents;
    @FXML
    private ImageView ImageView;
    @FXML
    private Label lbNomImage;
    @FXML
   public void handleButtonSubmitAction(ActionEvent event) {
            
           ServiceEvents sp = new ServiceEvents();
        String nom = nom_evenement.getText().toString().toLowerCase();
        String type = type_evenement.getText().toString().toLowerCase();
        String description = description_event.getText().toString().toLowerCase();
        String localisation = localisation_event.getText().toString().toLowerCase();
        String image = lbNomImage.getText().toString().toLowerCase();
        String pays = pays_evenement.getText().toString().toLowerCase();
        int nbre_part = Integer.valueOf(nbre_participants.getText().toLowerCase());
        int prix = Integer.valueOf(prix_evenement.getText().toLowerCase());
        Date dated = null;
        if (date_debut.getValue() != null) {
           dated = Date.valueOf(date_debut.getValue());
        }
        Date datef = null;
        if (date_fin.getValue() != null) {
           datef = Date.valueOf(date_fin.getValue());
          
        selectedevents = table_events.getSelectionModel().getSelectedItems();
              
    
        if (selectedevents.size() > 0) {
			for (Evenement u : selectedevents){
                     Evenement E=new Evenement(u.getId_event(), nom, description, type, image, dated, datef, pays, prix, nbre_part, localisation);
                              sp.modifier(E);
                               Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String title= "Modifieé avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
                        }
          List<Evenement> listemps = sp.affiche();
	   for (int i = 0; i < listemps.size(); i++) {
		Events.add(listemps.get(i));
            }
           table_events.refresh(); 
        
        }
        }
   }
   @FXML
    void getSelected (MouseEvent event){
       
        
    index = table_events.getSelectionModel().getSelectedIndex();
    
    if (index <= -1){
    
        return;
    
    }
    nom_evenement.setText(nom_event.getCellData(index).toString());
    type_evenement.setText(type_event.getCellData(index).toString());
    prix_evenement.setText(prix_event.getCellData(index).toString());
    nbre_participants.setText(nbre_parti_event.getCellData(index).toString());
   
    localisation_event.setText(localisation_event_table.getCellData(index).toString());

     
    
}
     @FXML
    private void InsertImage(ActionEvent event) throws IOException {
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG FILE","*.jpg"));
        chooser.setTitle("Choose Image");
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        File file=chooser.showOpenDialog(stage);
        if(file !=null){
        String filename=file.getAbsolutePath();
        filename=filename.replace("\\" , "\\\\");
         String rndchars = RandomStringUtils.randomAlphanumeric(16);
            try {
        

               Path save=Paths.get("C:\\Users\\moham\\OneDrive\\Desktop\\gestion_evenement\\GYF\\src\\pictures"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        lbNomImage.setVisible(false);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbNomImage.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("C:\\Users\\moham\\OneDrive\\Desktop\\gestion_evenement\\GYF\\src\\pictures"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
                String pathbd=save.toString().replace("\\" , "\\\\");
        lbNomImage.setVisible(false);
        lbNomImage.setText(pathbd);
            System.out.println(save); 
            }
        
       Image img=new Image("file:///"+filename);
        ImageView.setImage(img);
        }
        System.out.println("ajout avec succées");  
    String title= "Image ajoutée avec succés";
       TrayNotification tray = new TrayNotification();
          AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
    }
    
    public void initdata (Evenement u){
        nom_evenement.setText(u.getNom());
        type_evenement.setText(u.getType());
        description_event.setText(u.getDescription());
        image_event.setText(u.getImage());
        date_debut.setValue(u.getDate_debut().toLocalDate());
        date_debut.setValue(u.getDate_fin().toLocalDate());
        pays_evenement.setText(u.getPays());
        localisation_event.setText(u.getLocalisation());
        String p =String.valueOf(u.getPrix());
        prix_evenement.setText(p);
        String n =String.valueOf(u.getNbre_participants());
        nbre_participants.setText(n);
        
        
        
        
    }
  

	public void handleMouseEvent(MouseEvent event) {

	}
         

   
    
  
  
        
 
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               
		assert nom_evenement != null : "fx:id=\"nom_evenement\" was not injected: check your FXML file 'modifier.fxml'.";
		assert type_evenement != null : "fx:id=\"type_evenement\" was not injected: check your FXML file 'modifier.fxml'.";
		assert nbre_participants != null : "fx:id=\"nbre_participants\" was not injected: check your FXML file 'modifier.fxml'.";
		assert prix_evenement != null : "fx:id=\"prix_evenement\" was not injected: check your FXML file 'modifier.fxml'.";
		assert pays_evenement != null : "fx:id=\"pays_evenement\" was not injected: check your FXML file 'modifier.fxml'.";
		assert localisation_event != null : "fx:id=\"localisation_event\" was not injected: check your FXML file 'modifier.fxml'.";
		assert image_event != null : "fx:id=\"RechercherEmp\" was not injected: check your FXML file 'modifier.fxml'.";
		assert date_debut != null : "fx:id=\"date_debut\" was not injected: check your FXML file 'modifier.fxml'.";
		assert date_fin != null : "fx:id=\"date_fin\" was not injected: check your FXML file 'modifier.fxml'.";
		assert description_event != null : "fx:id=\"description_event\" was not injected: check your FXML file 'modifier.fxml'.";
		assert Modifier_event != null : "fx:id=\"rechercherEvent\" was not injected: check your FXML file 'modifier.fxml'.";
		assert gerer_event != null : "fx:id=\"gerer_event\" was not injected: check your FXML file 'modifier.fxml'.";
		assert seachhotels != null : "fx:id=\"seachhotels\" was not injected: check your FXML file 'modifier.fxml'.";
		assert seachresto != null : "fx:id=\"seachresto\" was not injected: check your FXML file 'modifier.fxml'.";
		assert searchEvents != null : "fx:id=\"searchEvents\" was not injected: check your FXML file 'modifier.fxml'.";
		assert seachhistoires != null : "fx:id=\"seachhistoires\" was not injected: check your FXML file 'modifier.fxml'.";
		assert bateau != null : "fx:id=\"bateau\" was not injected: check your FXML file 'modifier.fxml'.";
                assert users != null : "fx:id=\"useres\" was not injected: check your FXML file 'modifier.fxml'.";
                assert offre != null : "fx:id=\"offre\" was not injected: check your FXML file 'modifier.fxml'.";
                assert reclamation != null : "fx:id=\"reclamation\" was not injected: check your FXML file 'modifier.fxml'.";
                assert logout != null : "fx:id=\"logout\" was not injected: check your FXML file 'modifier.fxml'.";
                assert vol != null : "fx:id=\"vol\" was not injected: check your FXML file 'modifier.fxml'.";
                
            ServiceEvents sp = new ServiceEvents();
        List Eventss = sp.affiche();
        ObservableList list = FXCollections.observableArrayList(Eventss);
        table_events.setItems(list);
         nom_event.setCellValueFactory(new PropertyValueFactory<>("nom"));
         type_event.setCellValueFactory(new PropertyValueFactory<>("type"));
         nbre_parti_event.setCellValueFactory(new PropertyValueFactory<>("nbre_participants"));
         prix_event.setCellValueFactory(new PropertyValueFactory<>("prix"));
         localisation_event_table.setCellValueFactory(new PropertyValueFactory<>("localisation"));
         image_event_table.setCellValueFactory(new PropertyValueFactory<>("image"));
         date_debut_table.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         date_fin_table.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
        
         
    }    
    
}
