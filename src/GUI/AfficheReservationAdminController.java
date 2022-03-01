/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.reservation;
import entities.restaurants;
import static java.lang.Math.E;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.length;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceChambre;
import services.ServiceReservation;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheReservationAdminController implements Initializable {
ServiceReservation res = new ServiceReservation();

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<reservation> id_affiche;
@FXML
    private TableColumn<reservation, String> nom_user;
@FXML
    private TableColumn<reservation, String> prénom_user;
@FXML
    private TableColumn<reservation, String> nom_hotel;
@FXML
    private TableColumn<reservation, String> type;

@FXML
    private TableColumn<reservation, Date> date_sortie;
@FXML
    private TableColumn<reservation, Date> date_entree;
@FXML
    private TableColumn<reservation, Integer> prix;
@FXML
    private TableColumn<reservation, String> mode_payment;
@FXML
    private TableColumn<reservation, String> date_creation;
@FXML
    private TableColumn<reservation, String> email;

@FXML
    private JFXTextField search_hotel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
        showReservation();
     
    }
  
    
 
       public void showReservation(){
          reservation ra = new reservation();
                    
                 
           

                   List<reservation> r = res.AfficherfullinformationHotel();
                  
                           ObservableList list = FXCollections.observableArrayList(r);
                  
               nom_user.setCellValueFactory(new PropertyValueFactory<>("nom_user"));
        prénom_user.setCellValueFactory(new PropertyValueFactory<>("prenom_user"));
        email.setCellValueFactory(new PropertyValueFactory<>("email_user"));
        nom_hotel.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        type.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        date_creation.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        date_entree.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        mode_payment.setCellValueFactory(new PropertyValueFactory<>("mode_payment"));
        date_sortie.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
            id_affiche.setItems(list);

            
            FilteredList<reservation> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_hotel.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reservation.getNom_user().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (reservation.getPrenom_user().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (reservation.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter)!=-1){
				     return true;
                                }
                                else if (reservation.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
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
		search_hotel.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reservation.getNom_user().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (reservation.getPrenom_user().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (reservation.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter)!=-1){
				     return true;
                                }
                                else if (reservation.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
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
       
    public void Delete(){
        reservation r = id_affiche.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Demande de confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Etes-vous sûr de vouloir supprimer la reservation de " + r.getNom_user()+" " + r.getPrenom_user());
        Optional<ButtonType> btn = alert.showAndWait();
        if (btn.get() == ButtonType.OK) {
            res.supprimerReservation(r.getId_reservation());
            showReservation();
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("La reservation de monsieur  " + r.getNom_user()+" " + r.getPrenom_user()+" a été supprimé");
            resAlert.showAndWait();
        } else {
            alert.close();
        }
    }
   
}

