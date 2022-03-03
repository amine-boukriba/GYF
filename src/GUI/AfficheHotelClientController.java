/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import entities.Hotel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheHotelClientController implements Initializable {
    Hotel h = new Hotel(); 

    ServiceHotel Hotel = new ServiceHotel();
@FXML
    private TableView<Hotel> tblhotelDetails;
@FXML
    private TableColumn<Hotel, String> nom_h;
@FXML
    private TableColumn<Hotel, String> lo;
@FXML
    private TableColumn<Hotel, String> caté;
     @FXML 
    private GridPane grid_img;
     
      @FXML
    private JFXTextField txtHotelSearch;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    showHotel();
    }    
    
      public void showHotel(){
          List<Hotel> hotels = Hotel.affiche();

        ObservableList list = FXCollections.observableArrayList(hotels);
        nom_h.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        lo.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        caté.setCellValueFactory(new PropertyValueFactory<>("categorie"));


          tblhotelDetails.setItems(list);
          System.out.println(list);
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
		txtHotelSearch.textProperty().addListener((observable, oldValue, newValue) -> {
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
		sortedData.comparatorProperty().bind(tblhotelDetails.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tblhotelDetails.setItems(sortedData);
                // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		txtHotelSearch.textProperty().addListener((observable, oldValue, newValue) -> {
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
		sortedData.comparatorProperty().bind(tblhotelDetails.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tblhotelDetails.setItems(sortedData);
    }
  private void showImage(MouseEvent event) {
   Image image;
                            try {
                                image = new Image(new FileInputStream(h.getImage_hotel()));
                            
                          //      imagev.setImage(image); 
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AfficheHotelClientController.class.getName()).log(Level.SEVERE, null, ex);
                            }
       
    
   
    }
  @FXML
  public void gotoRestaurant(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheRestaurantClient.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
	
   @FXML
  public void gotoReservation(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutReservationClientHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  
    @FXML
  public void gotoHotel(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheHotelClient.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
}
