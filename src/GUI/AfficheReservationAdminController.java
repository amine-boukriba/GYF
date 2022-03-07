/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheReservationAdminController implements Initializable {

    ServiceReservation res = new ServiceReservation();
    
    @FXML
    private TableView<reservation> id_affiche;
    @FXML
    private TableColumn<reservation, String> nom_user;
    @FXML
    private TableColumn<reservation, String > prénom_user;
    @FXML
    private TableColumn<reservation, String> email;
    @FXML
    private TableColumn<reservation, String> nom_hotel;
    @FXML
    private TableColumn<reservation, String>type;
    @FXML
    private TableColumn <reservation, Integer> prix;
    @FXML
    private TableColumn <reservation, Date> date_entree;
    @FXML
    private TableColumn <reservation, Date> date_sortie;
    @FXML
    private TableColumn <reservation, String> mode_payment;
    @FXML
    private TableColumn <reservation, String> date_creation;
    @FXML
    private JFXTextField search_restaurant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   showReservation();
    }    

    private void showReservation(){
        
                    
                 
           

                   List<reservation> r = res.AfficherfullinformationHotel();
                  
                           ObservableList list = FXCollections.observableArrayList(r);
                  
        nom_hotel.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
         mode_payment.setCellValueFactory(new PropertyValueFactory<>("mode_payment"));
        email.setCellValueFactory(new PropertyValueFactory<>("email_user"));
         nom_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));

        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        date_entree.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_creation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        date_sortie.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
         prénom_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
            id_affiche.setItems(list);

           // System.out.println(list);
            
            FilteredList<reservation> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_restaurant.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				
			if (reservation.getNom_user().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (reservation.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches localisation
				}
				else if (reservation.getPrenom_user().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 else if (reservation.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches localisation
				}
				else if (reservation.getMode_payment().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<reservation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche.setItems(sortedData);
                // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		// 2. Set the filter Predicate whenever the filter changes.
		search_restaurant.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				
			if (reservation.getNom_user().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (reservation.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches localisation
				}
				else if (reservation.getPrenom_user().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 else if (reservation.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches localisation
				}
				else if (reservation.getMode_payment().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche.setItems(sortedData);
        }
    @FXML
    private void Delete(ActionEvent event) {
        reservation r = id_affiche.getSelectionModel().getSelectedItem();
      
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Demande de confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Etes-vous sûr de vouloir d'annuler   Votre reservation de   l'hôtel" +r.getNom_hotel() );
        Optional<ButtonType> btn = alert.showAndWait();
        if (btn.get() == ButtonType.OK) {
                             //       System.out.println(r.getId_reservation());
                                    
            res.supprimerReservation(r.getId_reservation());
            showReservation();
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("votre reservation de l'hôtel "   + r.getNom_hotel()+" a été supprimé");
            resAlert.showAndWait();
        } else {
            alert.close();
        }
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
    
}
