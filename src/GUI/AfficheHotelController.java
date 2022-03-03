
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.Optional;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import services.ServiceHotel;
import entities.Hotel;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AfficheHotelController implements Initializable {
        int index = -1;

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
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField localisation;
    @FXML
    private JFXTextField catégorie;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
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

@FXML
    void getSelected (MouseEvent event){
       
        
    index = tblhotelDetails.getSelectionModel().getSelectedIndex();
    
    if (index <= -1){
    
        return;
    
    }
    nom.setText(nom_h.getCellData(index).toString());
    localisation.setText(lo.getCellData(index).toString());
    catégorie.setText(caté.getCellData(index).toString());
   

    
}
     @FXML
    public void Delete(){



        ObservableList<Hotel> lp = tblhotelDetails.getSelectionModel().getSelectedItems();
        Hotel r = tblhotelDetails.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Demande de confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Etes-vous sûr de vouloir supprimer le restaurant " + r.getNom_hotel());
        Optional<ButtonType> btn = alert.showAndWait();
        if (btn.get() == ButtonType.OK) {
         Hotel.supprime(r.getId_hotel());
            showHotel();
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("Le restaurant " + r.getNom_hotel()+ " a été supprimé");
            resAlert.showAndWait();
        } else {
            alert.close();
        }
    }
   
     
    
    @FXML
      public void UpdateTable(){
      /*  nom_res.setCellValueFactory(new PropertyValueFactory<restaurants,String>("nom_restaurant"));
        lo.setCellValueFactory(new PropertyValueFactory<restaurants,String>("localisation"));
        spécialité.setCellValueFactory(new PropertyValueFactory<restaurants,String>("cuisinies"));
        horaire.setCellValueFactory(new PropertyValueFactory<restaurants,String>("horaire"));
        téléphone.setCellValueFactory(new PropertyValueFactory<restaurants,String>("numero_restaurant"));
        nbr_fourchet.setCellValueFactory(new PropertyValueFactory<restaurants,Integer>("nombre_fourchet"));

*/
             int  id_selected = tblhotelDetails.getSelectionModel().getSelectedItem().getId_hotel();
        System.out.println(id_selected);
        String nom_hotel = nom.getText();
        String localisation = this.localisation.getText();
        String categorie = catégorie.getText();

     

        Hotel h = new Hotel(id_selected, nom_hotel,localisation,categorie);
       Hotel.modifier(h);
       
          showHotel();
    }
      
    private void showImage(MouseEvent event) {
      Hotel h = tblhotelDetails.getSelectionModel().getSelectedItem();
      String path = h.getImage_hotel();
      grid_img.getChildren().clear();
      grid_img.add(new ImageView(new Image("file:/"+path, 193, 200, false, false)), 0, 0);
    }
     @FXML
  public void gotoRestaurantAd(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheRestaurant.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
	
   @FXML
  public void gotoAjoutHotel(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  
    @FXML
  public void gotoHotelAd   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficheHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
 

  
    @FXML
  public void gotoListeResrv   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheReservationAdmin.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
}
