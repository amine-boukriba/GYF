/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import org.controlsfx.control.Notifications;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AjouterHotelController implements Initializable {
ServiceHotel Hotel = new ServiceHotel();
    private TableView<Hotel> tblhotelDetails;
    private TableColumn<Hotel, String> nom_h;
    private TableColumn<Hotel, String> lo;
    private TableColumn<Hotel, String> caté;
    @FXML
    private TextField nom;
    @FXML
    private TextField localisation;
    @FXML
    private TextField catégorie;
    @FXML
    private JFXButton btnNext;
    
        private List<String> listfiles;
    @FXML
    private JFXButton btnNext1;
    @FXML
    private JFXTextField img;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         listfiles = new ArrayList<>();
        listfiles.add("*.png");
        listfiles.add("*.jpg");
    }    
     @FXML
    private void ajout(ActionEvent event) throws IOException {
                  if (validateFields()) {

        Hotel h = new Hotel();
        h.setNom_hotel(nom.getText());
        h.setLocalisation(localisation.getText());
        h.setCategorie(catégorie.getText());
        h.setImage_hotel(img.getText()); 

        Hotel.ajout(h);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès!");
            alert.setHeaderText(null);
            alert.setContentText("L'Hotel "+h.getNom_hotel()+" est ajouté avec succès");
            alert.showAndWait();
         Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterChambre.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
                  } else if(validateFields()==false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
        }

    }
   
    // Test de validation de saisie
    private boolean validateFields(){
        if(nom.getText().isEmpty() || localisation.getText().isEmpty() || catégorie.getText().isEmpty() || img.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    @FXML
    private void get_image(ActionEvent event) {
         JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String filename=f.getAbsolutePath();
        img.setText(filename);
        Image imagee;
          try {
              imagee = new Image(new FileInputStream(filename));
      //         imagev.setImage(imagee);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(AjouterHotelController.class.getName()).log(Level.SEVERE, null, ex);
          }
          
    };
 
	

  
    @FXML
  public void gotoHotelAd   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficheHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  @FXML
    public void gotoRestaurantAd(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheRestaurant.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
        }
    
 
