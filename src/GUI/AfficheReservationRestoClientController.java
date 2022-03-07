/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.reservation;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheReservationRestoClientController implements Initializable {
 ServiceReservation res = new ServiceReservation();
    @FXML
    private TableView<reservation> id_affiche;
    @FXML
    private TableColumn<reservation, String> nom_resto;
    @FXML
    private TableColumn<reservation, String> localisation;
    @FXML
    private TableColumn<reservation, Date> date_entré;
  
   
    @FXML
    private TableColumn<reservation, Integer> nbr_personne;
    @FXML
    private TableColumn<reservation, String> date_création;
    @FXML
    private JFXTextField search_reservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showReservation();
    }    
     public void showReservation(){
         
                   List<reservation> r = res.AfficheInformationRestoReservationClient();
            
                           ObservableList list = FXCollections.observableArrayList(r);
                 id_affiche.setItems(list); 
                
               //  System.out.println("daijdzaiad");
                // System.out.println(list);
        nom_resto.setCellValueFactory(new PropertyValueFactory<>("nom_restaurant"));
        localisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        
      
        date_entré.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        date_création.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
         nbr_personne.setCellValueFactory(new PropertyValueFactory<>("nbr_personne"));
           

      //      System.out.println(list + "ékceoezzeezezdedzezdezd");
            FilteredList<reservation> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_reservation.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				
				if (reservation.getNom_restaurant().toLowerCase().indexOf(lowerCaseFilter)!=-1){
				     return true;
                                }
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
		search_reservation.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reservation -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				
				if (reservation.getNom_restaurant().toLowerCase().indexOf(lowerCaseFilter)!=-1){
				     return true;
                        }
                      
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
        alert.setContentText("Etes-vous sûr de vouloir annuler Votre reservation de restaurant  " + r.getNom_restaurant());
        Optional<ButtonType> btn = alert.showAndWait();
        if (btn.get() == ButtonType.OK) {
            res.supprimerReservation(r.getId_reservation());
            showReservation();
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("La reservation de restaurant "  + r.getNom_restaurant()+" a été supprimé");
            resAlert.showAndWait();
        } else {
            alert.close();
        }
    }
}
