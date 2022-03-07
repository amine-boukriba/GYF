/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import entities.reclamation;

import java.io.File;
import java.io.IOException;


import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.FileChooser;

import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;

import org.apache.commons.lang3.RandomStringUtils;
import org.controlsfx.control.Notifications;
import services.JavaMailUtil;
import services.ServiceReclamation;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjoutreclamationController implements Initializable {

    @FXML
    private TextField nomtxtfield;
    @FXML
    private TextField mailtxtfield;
    @FXML
    private TextField prenomtxtfield;
    @FXML
    private ChoiceBox<String> typerec;
     
    @FXML
    private TextField sujetrec;
    private ImageView nomCheckMark;
    private ImageView prenomCheckMark ;
    private ImageView emailCheckMark ;
    Notifications n;
    String erreur;
    @FXML
    private Button btnenvoyer;
    private ImageView recaptchaCheckMark;
    
    ServiceReclamation sr =new ServiceReclamation();
    @FXML
    private Label lbNomImage;
    @FXML
    private Button btnImage;
    @FXML
    private ImageView ImageView;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
//        typerec.setItems(TypeReclamationController.list);
ObservableList<String>  list =FXCollections.observableArrayList("Compte","Monument","Espace_Culturels","Restaurant","Hotel","Evenement","Voyage");
typerec.setItems(list);
    
}
    @FXML
    private void insert(ActionEvent event) throws IOException, MessagingException {
         LocalDateTime now = LocalDateTime.now();  
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        reclamation r=new reclamation();
        r.setDescription(sujetrec.getText());
        r.setNom(nomtxtfield.getText());
        r.setPrenom( prenomtxtfield.getText());
        r.setEmail(mailtxtfield.getText());
        r.setDate_creation(dtf.format(now));
        r.setDate_traitement("0000/00/00 00:00:00");
        r.setStatus("En cours");
        r.setCible_reclamation(0);
        r.setType_reclamation(typerec.getValue());
        r.setId_user(GestionreclamationclientController.id_user);
        r.setImage_reclamation(lbNomImage.getText());
       sr.ajout(r);
       JavaMailUtil.sendMail(r.getEmail(),"Reclamation","Reclamation en cours de traitement");
        Parent etab = FXMLLoader.load(getClass().getResource("gestionreclamationclient.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
   System.out.println("ajout avec succées");
    String title= "reclamation ajoutée avec succés";
       TrayNotification tray = new TrayNotification();
          AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
   
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
        

               Path save=Paths.get("C:\\Users\\ASUS\\GYF_2\\GYF\\src\\Images\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        lbNomImage.setVisible(false);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbNomImage.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("C:\\Users\\ASUS\\GYF_2\\GYF\\src\\Images\\"+rndchars+"_"+rndchars+".jpg");
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
    private void fnretour(ActionEvent event) throws IOException {
         Parent etab = FXMLLoader.load(getClass().getResource("templateclient.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

}