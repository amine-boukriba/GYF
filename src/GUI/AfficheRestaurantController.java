/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
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
import services.ServiceRestaurant;
import entities.restaurants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AfficheRestaurantController implements Initializable {
    int index = -1;
  

    ServiceRestaurant res = new ServiceRestaurant();
    /**
     * Initializes the controller class.
     */
  @FXML
    private JFXTextField nom_res1;
    @FXML
    private JFXTextField localisation1;
    @FXML
    private JFXTextField horaire1;
  
    @FXML
    private JFXTextField téléphone1;
  
    @FXML
    private JFXTextField nbr_fourchet1;
  
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
    
     @FXML
    private ImageView Exit;
        @FXML
    private ImageView imagev;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;
       @FXML
    private JFXComboBox<String> spécialité1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
                  id_affiche.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println(newSelection);
                
                            try {
                                Image image = new Image(new FileInputStream(newSelection.getImage_restaurant()));
                                imagev.setImage(image); 
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(AfficheHotelClientController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                
            }
        });
               
   
         spécialité1.getItems().add("Cuisine albanaise");
 spécialité1.getItems().add("Cuisine allemande");
 spécialité1.getItems().add("Cuisine britannique");
 spécialité1.getItems().add("Cuisine anglaise");
 spécialité1.getItems().add("Cuisine écossaise");
 spécialité1.getItems().add("Cuisine galloise");
 spécialité1.getItems().add("Cuisine bulgare");
 spécialité1.getItems().add("Cuisine chypriote");
 spécialité1.getItems().add("Cuisine danoise");
 spécialité1.getItems().add("Cuisine espagnole");
 spécialité1.getItems().add("Cuisine française");
 spécialité1.getItems().add("Cuisine grecque");
 spécialité1.getItems().add("Cuisine italienne");
 spécialité1.getItems().add("Cuisine suisse");
 spécialité1.getItems().add("Cuisine égyptienne");
 spécialité1.getItems().add("cuisine algérienne");
 spécialité1.getItems().add("Cuisine libyenne");
 spécialité1.getItems().add("Cuisine marocaine");
 spécialité1.getItems().add("Cuisine tunisienne");

 spécialité1.getItems().add("Cuisine des États-Unis");

 spécialité1.getItems().add("Cuisine canadienne");
 spécialité1.getItems().add("Cuisine mexicaine");
 spécialité1.getItems().add("Cuisine chinoise");
 spécialité1.getItems().add("Cuisine coréenne");
 spécialité1.getItems().add("Cuisine japonaise");
 spécialité1.getItems().add("Cuisine mongole");
 spécialité1.getItems().add("Cuisine taïwanaise");
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
   @FXML     
void getSelected (MouseEvent event){
       
        
    index = id_affiche.getSelectionModel().getSelectedIndex();
    
    if (index <= -1){
    
        return;
    
    }
    nom_res1.setText(nom_res.getCellData(index).toString());
    localisation1.setText(lo.getCellData(index).toString());
    spécialité1.setValue(spécialité.getCellData(index).toString());
    horaire1.setText(horaire.getCellData(index).toString());
    téléphone1.setText(téléphone.getCellData(index).toString());
    nbr_fourchet1.setText(nbr_fourchet.getCellData(index).toString());

    
}
    @FXML
    public void Delete(){
        restaurants r = id_affiche.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Demande de confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Etes-vous sûr de vouloir supprimer le restaurant " + r.getNom_restaurant());
        Optional<ButtonType> btn = alert.showAndWait();
        if (btn.get() == ButtonType.OK) {
            res.supprime(r.getId_restaurant());
            showRestaurant();
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("Le restaurant " + r.getNom_restaurant()+ " a été supprimé");
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
             int  id_selected = id_affiche.getSelectionModel().getSelectedItem().getId_restaurant();
        System.out.println(index);
        String nom_restauarnt = nom_res1.getText();
        String localisation = localisation1.getText();
        int nombre_fourchet = Integer.parseInt(nbr_fourchet1.getText());
        System.out.println(nombre_fourchet);
        String numero_restaurant = téléphone1.getText();
        String cuisinies = spécialité1.getValue();
        String horaire = this.horaire1.getText();

        restaurants r = new restaurants(id_selected, nom_restauarnt,localisation,horaire,numero_restaurant,cuisinies,nombre_fourchet);
       res.modifier(r);
       
          showRestaurant();
    }
      
          @FXML
  public void gotoRestaurantAd(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheRestaurant.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
	
  public void gotoAjoutRestaurant(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterRestaurant.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  
  
  public void gotoHotelAd   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficheHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  public void gotolistres   (ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheReservationRestaurantAdmin.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
 

  
  
}
    

  

  

    

