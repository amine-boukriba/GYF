/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.restaurants;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceRestaurant;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheRestaurantClientController implements Initializable {
    ServiceRestaurant res = new ServiceRestaurant();
    /**
     * Initializes the controller class.
     */

  

@FXML
    private TableView<restaurants> id_affiche;
@FXML
    private TableColumn<restaurants, String> nom_res;
@FXML
    private TableColumn<restaurants, String> lo;
@FXML
    private TableColumn<restaurants, String> spécialité;
@FXML
    private TableColumn<restaurants, String> horaire;
@FXML
    private TableColumn<restaurants, Integer> nbr_fourchet;
@FXML
    private TableColumn<restaurants, String> téléphone;
    @FXML
    private JFXTextField searchres;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                showRestaurant();
               
    }
   public void showRestaurant(){
    List<restaurants> r = res.affiche();

        ObservableList list = FXCollections.observableArrayList(r);
        nom_res.setCellValueFactory(new PropertyValueFactory<>("nom_restaurant"));
        lo.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        spécialité.setCellValueFactory(new PropertyValueFactory<>("cuisinies"));
         nbr_fourchet.setCellValueFactory(new PropertyValueFactory<>("nombre_fourchet"));
        téléphone.setCellValueFactory(new PropertyValueFactory<>("numero_restaurant"));
        horaire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
          id_affiche.setItems(list);
//        try {

//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
//            Parent root = loader.load();
//            pane.getChildren().add(root);
//            // TODO
//        } catch (IOException ex) {
//            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
//        }

 // Wrap the ObservableList in a FilteredList (initially display all data).
     
 FilteredList<restaurants> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchres.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(restaurants -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare 
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (restaurants.getNom_restaurant().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (restaurants.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches localisation
				}
				else if (restaurants.getCuisinies().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<restaurants> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche.setItems(sortedData);
                // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchres.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(restaurants -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (restaurants.getNom_restaurant().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (restaurants.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (restaurants.getCuisinies().toLowerCase().indexOf(lowerCaseFilter)!=-1)
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
}