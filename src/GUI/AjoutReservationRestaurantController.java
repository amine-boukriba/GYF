/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entities.Chambre;
import entities.reservation;
import entities.restaurants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import services.ServiceReservation;
import services.ServiceRestaurant;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class AjoutReservationRestaurantController implements Initializable {
    ServiceRestaurant res = new ServiceRestaurant();
     ServiceReservation res1 = new ServiceReservation();

int index = -1;
        
      @FXML
    private JFXTextField nbr_personne;
    @FXML
    private JFXTextField nom_restaurant;
    
      @FXML
    private JFXTextField localisation;
 
     @FXML 
     private JFXDatePicker date_arrivé;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXTextField search_resto;
    @FXML
    private TableView<restaurants> id_affiche;
    @FXML
    private TableColumn<restaurants, String> reservation_nomResto;
    @FXML
    private TableColumn<restaurants, String> reservation_local_resto;
    @FXML
    private TableColumn<restaurants, String> spécialité;
    @FXML
    private ImageView image_qr;
    
    
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO*
        showRestaurant();
    }    
    
   
    public void showRestaurant(){
    List<restaurants> r = res.affiche();

        ObservableList list = FXCollections.observableArrayList(r);
        reservation_nomResto.setCellValueFactory(new PropertyValueFactory<>("nom_restaurant"));
        reservation_local_resto.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        spécialité.setCellValueFactory(new PropertyValueFactory<>("cuisinies"));
     
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
		search_resto.textProperty().addListener((observable, oldValue, newValue) -> {
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
		search_resto.textProperty().addListener((observable, oldValue, newValue) -> {
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
    nom_restaurant.setText(reservation_nomResto.getCellData(index).toString());
    localisation.setText(reservation_local_resto.getCellData(index).toString());
 

     
    

    }
            
    
     @FXML
    private void ajout(ActionEvent event) throws IOException {
                  if (validateNumber() && validateFields()) {

       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   LocalDateTime now = LocalDateTime.now();

     int  id_selected = id_affiche.getSelectionModel().getSelectedItem().getId_restaurant();

        reservation r = new reservation();
        r.setDate_debut(Date.valueOf(date_arrivé.getValue()));
        r.setId_user(1);
        r.setId_restaurant(id_selected);

        r.setDate_creation(dtf.format(now));
        String text1 = nbr_personne.getText();
          
        r.setNbr_personne(Integer.parseInt(text1));

        res1.AjoutReservationRestaurant(r);
    
             try {
                                 System.out.println(res.AfficheInformationRestoReservationClientqr(res.MaxID1()) +"ncezijezjeiznezjej");   
                                 System.out.println("ezjidi");
              QRcodeGen(res.AfficheInformationRestoReservationClientqr(res.MaxID1()).toString(),res.MaxID1());
            String absolutePath = new File("").getAbsolutePath();
            System.out.println(".\\QRcode\\1.jpg");
            File file = new File(absolutePath+"\\src\\GUI\\QRcode\\" +res.MaxID1()+".jpg");
            Image image;
                          image = new Image(new FileInputStream(absolutePath+"/src/GUI/QRcode/"+res.MaxID1()+".jpg"));
                     
//File file = new File("./QRcode/1.jpg");
//        Image image = new Image(file.toURI().toString());
                    image_qr.setImage(image);
 } catch (FileNotFoundException ex) {
                          Logger.getLogger(AjoutReservationClientController.class.getName()).log(Level.SEVERE, null, ex);
                      }
             
             
             
       
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès!");
            alert.setHeaderText(null);
            alert.setContentText("Ton  reservation  est ajouté avec succès");
            alert.showAndWait();
        } else if(validateNumber()==false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur Validation!");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir un nombre de personne valide");
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
        Matcher m = p.matcher(nbr_personne.getText());
        if(m.find() && m.group().equals(nbr_personne.getText())) {
            return true;
        } else {
            return false;
        }
    }
    // Test de validation de saisie
    private boolean validateFields(){
        if(date_arrivé.getValue() == null  ||  nom_restaurant.getText().isEmpty()|| localisation.getText().isEmpty() || nbr_personne.getText().isEmpty()) {
            return false;
        } else {
            return true;
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
  public void gotoHotel(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheHotelClient.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
  
 

  public void QRcodeGen(String input, int id_reservation) {
        try {
            ByteArrayOutputStream output = QRCode.from(input).to(ImageType.JPG).withSize(500, 500).stream();
            String absolutePath = new File("").getAbsolutePath();
            System.out.println(absolutePath+"\\src\\GUI\\QRCode\\");
            File f = new File(absolutePath+"\\src\\GUI\\QRCode\\" + id_reservation + ".jpg");
            FileOutputStream fos;
            fos = new FileOutputStream(f);
            
            fos.write(output.toByteArray());
            fos.flush();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
