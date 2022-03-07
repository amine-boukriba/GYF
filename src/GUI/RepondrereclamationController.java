/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reclamation;
import entities.status;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
<<<<<<< HEAD
import javafx.util.Duration;
=======
>>>>>>> c7fcde50ff82a7025c9917e62c749d6eec95001a
import javax.mail.MessagingException;
import services.JavaMailUtil;
import services.ServiceReclamation;
import services.ServiceStatus;
<<<<<<< HEAD
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
=======
>>>>>>> c7fcde50ff82a7025c9917e62c749d6eec95001a

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RepondrereclamationController implements Initializable {

    @FXML
    private TextArea messageTextField;
    @FXML
    private Button envoyerMessageButton;
    @FXML
    private ComboBox<String> ComboList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String>  list =FXCollections.observableArrayList("Traitée","En Cours","Rejetée");
        ComboList.setItems(list);// TODO
    }    

    @FXML
    private void fnEnvoyer(ActionEvent event) throws IOException, MessagingException {
        LocalDateTime now = LocalDateTime.now();  
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
        ServiceStatus ser=new ServiceStatus();
        ServiceReclamation rec=new ServiceReclamation();
<<<<<<< HEAD
        status reponse=new status();
        reclamation reclam=new reclamation();
        reponse.setId_reclamation(GestionreclamationadminController.id);
        reponse.setMessage(messageTextField.getText());
        reponse.setNom_status(ComboList.getValue());
        reclam.setId_reclamation(GestionreclamationadminController.id);
        reclam.setStatus(ComboList.getValue());
        reclam.setDate_traitement(dtf.format(now));
        rec.repondre(reclam);
        ser.ajout(reponse);
=======
        status t=new status();
        reclamation r=new reclamation();
        t.setId_reclamation(GestionreclamationadminController.id);
        t.setMessage(messageTextField.getText());
        t.setNom_status(ComboList.getValue());
        r.setId_reclamation(GestionreclamationadminController.id);
        r.setStatus(ComboList.getValue());
        r.setDate_traitement(dtf.format(now));
        rec.repondre(r);
        ser.ajout(t);
>>>>>>> c7fcde50ff82a7025c9917e62c749d6eec95001a
        JavaMailUtil.sendMail(GestionreclamationadminController.email,"Reclamation "+ComboList.getValue()+"",messageTextField.getText());
        Parent etab = FXMLLoader.load(getClass().getResource("gestionreclamationadmin.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
<<<<<<< HEAD
         String title= "mail envoyé avec succées";
       TrayNotification tray = new TrayNotification();
        AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
=======
>>>>>>> c7fcde50ff82a7025c9917e62c749d6eec95001a
    }
    
}
