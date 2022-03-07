/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Chambre;
import entities.Hotel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import services.ServiceChambre;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AjouterChambreController implements Initializable {
      


ServiceChambre chamb = new ServiceChambre();
ServiceHotel Hotel = new ServiceHotel();
int index = -1;
    @FXML
    private JFXTextField search_hotel;
    @FXML
    private TableView<Hotel> id_affiche_chambre;
    @FXML
    private TableColumn<Hotel, String> chambre_nomHotel;
    @FXML
    private TableColumn<Hotel, String> localisation_Hotel;
@FXML
    private TableColumn<Hotel, String> catégorie;
    @FXML
    private JFXTextField prix_chambre;
    @FXML
    private JFXComboBox<String> type_chambre;
    @FXML
    private JFXTextField nbr_chambre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        showHotel();
           type_chambre.getItems().add("single");
        type_chambre.getItems().add("double");
         type_chambre.getItems().add("suite");
    }    
public void gotohotels(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutReservationClientHotel.fxml\n" +
"                Parent root = FXMLLoader.load(getClass().getResource(\""));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
    
     public void showHotel(){
          List<Hotel> hotels = Hotel.affiche();

        ObservableList list = FXCollections.observableArrayList(hotels);
        chambre_nomHotel.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        localisation_Hotel.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        catégorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
          id_affiche_chambre.setItems(list);
        //  System.out.println(list);
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
//            Parent root = loader.load();
//            pane.getChildren().add(root);
//            // TODO
//        } catch (IOException ex) {
//            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//        }

 // Wrap the ObservableList in a FilteredList (initially display all data).
     
 FilteredList<Hotel> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_hotel.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Hotel -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Hotel.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Hotel.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (Hotel.getCategorie().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Hotel> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche_chambre.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche_chambre.setItems(sortedData);
                // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_hotel.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Hotel -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Hotel.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Hotel.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (Hotel.getCategorie().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche_chambre.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche_chambre.setItems(sortedData);
    }

     
     @FXML
    private void ajout(ActionEvent event) {
        
                  if (validateNumber() && validateFields()) {

             int  id_selected = id_affiche_chambre.getSelectionModel().getSelectedItem().getId_hotel();

        Chambre chambre = new Chambre();
        chambre.setType_chambre(type_chambre.getValue());
          String text1 = prix_chambre.getText();
          
        chambre.setPrix_chambre(Integer.parseInt(text1));
        
        chambre.setId_hotel(id_selected);
        
        
       
         String text2 = nbr_chambre.getText();
       int alt= Integer.parseInt(text2);
        
        for (int i = 0; i < alt ; i++) {
        chamb.ajout(chambre);
        }
        
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès!");
            alert.setHeaderText(null);
            alert.setContentText("Les chambres sont ajouter avec succès");
            alert.showAndWait();
        } else if(validateNumber()==false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un nombre ou prix  de chambre valide");
            alert.showAndWait();
        } else if(validateFields()==false){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
        }
    }
  private boolean validateNumber() {
        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(nbr_chambre.getText() );
        Matcher m1 = p.matcher(prix_chambre.getText());
        
        if((m.find() && m.group().equals(nbr_chambre.getText())) && (m1.find() && m1.group().equals(prix_chambre.getText())) ) {
            return true;
        } else {
            return false;
        }
    }
    // Test de validation de saisie
    private boolean validateFields(){
        if(prix_chambre.getText().isEmpty() ||  type_chambre.getSelectionModel().getSelectedItem().isEmpty()|| nbr_chambre.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
 

    @FXML
    private void handle(MouseEvent event) {
    }
    
       @FXML
  public void gotoHotelAd   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficheHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
    public void gotoRestaurantAd(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheRestaurant.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
     public void gotoaddhotel(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
}

    

  