/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

;
import java.lang.Object;
import entities.Evenement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceEvents;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AjouterController implements Initializable {
     
    private Label welcome;
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
    private Button ajouter_event;
    @FXML
    private TextField nbre_participants;
    @FXML
    private TextField localisation_event;
    @FXML
    private Button image_event;
    @FXML
    private TextArea description_event;
    @FXML
    private Label lbNomImage;
    @FXML
    private ImageView ImageView;
   

	public void handleMouseEvent(MouseEvent event) {

	}
     

 
    ServiceEvents se=new ServiceEvents();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
   
    @FXML
    public void Insert(ActionEvent event) {
        Evenement p = new Evenement();
        p.setNom(nom_evenement.getText());
        p.setType(type_evenement.getText());
        p.setPrix(Integer.valueOf(prix_evenement.getText().toLowerCase()));
        p.setPays(pays_evenement.getText());
        p.setNbre_participants(Integer.valueOf(nbre_participants.getText().toLowerCase()));
        p.setLocalisation(localisation_event.getText());
        p.setImage(lbNomImage.getText());
        p.setDescription(description_event.getText());
        p.setDate_debut(Date.valueOf(date_debut.getValue()));
        p.setDate_fin(Date.valueOf(date_fin.getValue()));
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
   
        
        if(nom_evenement.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le nom de l'évenement à ajouter!");
            alert.show();
        }
        else if(type_evenement.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le type de l'évenement à ajouter !");
            alert.show();
        }
        else if(prix_evenement.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le prix de l'évenement à ajouter!");
            alert.show();
        }
        else if(pays_evenement.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le pays de l'évenement à ajouter!");
            alert.show();
        }
        else if(nbre_participants.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le nombre des participants de l'évenement à ajouter!");
            alert.show();
           
        }else if(lbNomImage.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer l'image de l'évenement à ajouter!");
            alert.show();
        }
        else if(description_event.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer la description de l'évenement à ajouter!");
            alert.show();
        }
          
                

       
        
        //alert.setTitle("Information Dialog");
        //alert.setHeaderText(null);
        //alert.setContentText("Monuments ajouté avec succés!");
        //alert.show();
      
       boolean d= (Date.valueOf(date_debut.getValue()).compareTo(Date.valueOf(date_fin.getValue()))>0 );
       if(d=false)
       {
          alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Date début ne peut pas etre supperieure à date fin de l'évenement!");
            alert.show(); 
       }
      se.ajout(p);
    String title= "Evenement ajouté avec succés";
       TrayNotification tray = new TrayNotification();
          AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
                    
                       
    }

}
    
    

