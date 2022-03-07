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
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.commons.lang3.RandomStringUtils;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private ChoiceBox<String> typerec;
    @FXML
    private TextField sujetrec;
    @FXML
    private Label lbNomImage;
    @FXML
    private Button btnenvoyer;
    @FXML
    private Button btnImage;
    @FXML
    private ImageView ImageView;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<String>  list =FXCollections.observableArrayList("compte","monument","restourant","hotel","evenement","voyage");
       typerec.setItems(list);// TODO
       sujetrec.setText(GestionreclamationclientController.recco.getDescription());
       typerec.setValue(GestionreclamationclientController.recco.getType_reclamation());
       lbNomImage.setVisible(false);
       lbNomImage.setText(GestionreclamationclientController.recco.getImage_reclamation());
       String img="file:///"+GestionreclamationclientController.recco.getImage_reclamation();
       Image image=new Image(img);
       ImageView.setImage(image);
    }    

    @FXML
    private void insert(ActionEvent event) throws IOException {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        reclamation rec=new reclamation();
        rec=GestionreclamationclientController.recco;
        rec.setImage_reclamation(lbNomImage.getText());
        rec.setType_reclamation(typerec.getValue());
        rec.setDescription(sujetrec.getText());
        ServiceReclamation rr=new ServiceReclamation();
        rr.modifier(rec);
        Parent etab = FXMLLoader.load(getClass().getResource("gestionreclamationclient.fxml"));      
        Scene scene = new Scene(etab);
        Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
        windows.setScene(scene);
        windows.show(); }else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
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
        

               Path save=Paths.get("D:\\pi3a\\gyf\\GYF\\src\\public\\Image\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        lbNomImage.setVisible(false);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbNomImage.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("D:\\pi3a\\gyf\\GYF\\src\\public\\Image\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
                String pathbd=save.toString().replace("\\" , "\\\\");
        lbNomImage.setVisible(false);
        lbNomImage.setText(pathbd);
            System.out.println(save); 
            }
        
        Image img=new Image("file:///"+filename);
        ImageView.setImage(img);
        }
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
