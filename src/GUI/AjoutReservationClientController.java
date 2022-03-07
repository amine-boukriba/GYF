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
import entities.reservation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ServiceChambre;

/**
 * FXML Controller class
 *
 * @author omarb
 */
import entities.Chambre;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.controlsfx.control.Notifications;
import services.ServiceReservation;
import utils.MyDB;
public class AjoutReservationClientController implements Initializable {

    int index = -1;
    ServiceChambre chamb = new ServiceChambre();
    ServiceReservation res = new ServiceReservation();
    public static reservation e ; 
    /**
     * Initializes the controller class.
     */
  
     @FXML
    private JFXTextField nbr_personne;
    @FXML
    private JFXTextField search_chambre;
    
      @FXML
    private JFXTextField nom_hotel;
    @FXML
    private JFXTextField type_chambre;
      @FXML
    private JFXTextField prix_chambre;
 
    @FXML
    private JFXComboBox<String> mode_payment;
   
     @FXML
    private TableView<Chambre> id_affiche_chambre;
    
     @FXML
    private TableColumn<Chambre,String> reservation_nomHotel;
    
     @FXML
      private TableColumn<Chambre,Integer> reservation_prixHotel;
 
     @FXML
      private TableColumn<Chambre,String> reservation_typeHotel;
      
     @FXML 
     private JFXDatePicker date_arrivé;
    
     @FXML 
     private JFXDatePicker date_sortie;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private ImageView image_qr;
        
          int id= 0;
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            mode_payment.getItems().add("en ligne");
            mode_payment.getItems().add("agence");
            
            // TODO
            showChambreHotel();
      
    }    
    
    
    void showChambreHotel(){
          List<Chambre> chambres = chamb.afficheavecnom_hotel();

        ObservableList list = FXCollections.observableArrayList(chambres);
        reservation_nomHotel.setCellValueFactory(new PropertyValueFactory<>("nom_hotel"));
        reservation_prixHotel.setCellValueFactory(new PropertyValueFactory<>("prix_chambre"));
        reservation_typeHotel.setCellValueFactory(new PropertyValueFactory<>("type_chambre"));
         
          id_affiche_chambre.setItems(list);
          
          FilteredList<Chambre> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_chambre.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Chambre -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare 
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Chambre.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Chambre.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches type chambre
                                }
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Chambre> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(id_affiche_chambre.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		id_affiche_chambre.setItems(sortedData);
                // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		search_chambre.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Chambre -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Chambre.getNom_hotel().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Chambre.getType_chambre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}

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
    void getSelected (MouseEvent event){
       
        
    index = id_affiche_chambre.getSelectionModel().getSelectedIndex();
    
    if (index <= -1){
    
        return;
    
    }
    nom_hotel.setText(reservation_nomHotel.getCellData(index).toString());
    type_chambre.setText(reservation_typeHotel.getCellData(index).toString());
    prix_chambre.setText(reservation_prixHotel.getCellData(index).toString());
 

     
    
}  
     @FXML
    private void ajout(ActionEvent event) {
                  if (validateNumber() && validateFields()) {

       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   LocalDateTime now = LocalDateTime.now();

     int  id_selected = id_affiche_chambre.getSelectionModel().getSelectedItem().getId_chambre();
        reservation r = new reservation();
  

        r.setDate_debut(Date.valueOf(date_arrivé.getValue()));
        r.setDate_fin(Date.valueOf(date_sortie.getValue()));
        r.setId_user(1);
        r.setId_chambre(id_selected);
        r.setMode_payment(mode_payment.getValue());
        r.setDate_creation(dtf.format(now));
        String text1 = nbr_personne.getText();
        r.setNbr_personne(Integer.parseInt(text1));

        res.AjoutReservationHotel(r);
                             try {
                              //   System.out.println(res.AfficherfullinformationHotelcodeQR(res.MaxID()) +"ncezijezjeiznezjej");   
                               //  System.out.println("ezjidi");
            QRcodeGen(res.AfficherfullinformationHotelcodeQR(res.MaxID()).toString(),res.MaxID());
            String absolutePath = new File("").getAbsolutePath();
            System.out.println(".\\QRcode\\1.jpg");
            File file = new File(absolutePath+"\\src\\GUI\\QRcode\\" +res.MaxID()+".jpg");
            Image image;
                          image = new Image(new FileInputStream(absolutePath+"/src/GUI/QRcode/"+res.MaxID()+".jpg"));
                     
//File file = new File("./QRcode/1.jpg");
//        Image image = new Image(file.toURI().toString());
                    image_qr.setImage(image);
 } catch (FileNotFoundException ex) {
                          Logger.getLogger(AjoutReservationClientController.class.getName()).log(Level.SEVERE, null, ex);
                      }
       
        
    
        try {
                         MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();

            String req = "update chambre set etat=\"non disponible\" where id_chambre =?"  ;
                      PreparedStatement ps = connection.prepareStatement(req);
                ps.setInt(1,id_selected);

          //      System.out.println(req);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            System.out.println("Error in updating hotel ");
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
        if(date_arrivé.getValue() == null  || date_sortie.getValue() == null || mode_payment.getSelectionModel().getSelectedItem().isEmpty() || nom_hotel.getText().isEmpty()|| type_chambre.getText().isEmpty() || prix_chambre.getText().isEmpty() || nbr_personne.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
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
  
    @FXML
  public void gotolistReservation(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficheReservationClientHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
 
}
    

 