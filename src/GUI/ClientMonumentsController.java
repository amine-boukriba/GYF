/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ClientEspaceCulturelsController.id;
import entities.Espace_culturels;
import entities.Monuments;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.AlertBox;
import services.ServiceEspaceCulturel;
import services.ServiceMonuments;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class ClientMonumentsController implements Initializable {

    @FXML
    private TableView<Monuments> TvMonum;
    @FXML
    private TableColumn<Monuments, String> colNomMonument;
    @FXML
    private TableColumn<Monuments, Boolean> colPayant;
    @FXML
    private TableColumn<Monuments, Integer> colPrix;
    @FXML
    private TableColumn<Monuments, String> colDescription;
    @FXML
    private TableColumn<Monuments, String> colDateCreation;
    @FXML
    private TableColumn<Monuments, String> colPays;
    @FXML
    private TableColumn<Monuments, String> colLocalisation;
    @FXML
    private Label lbId;
    @FXML
    private TextField tfSearch;
    @FXML
    private ImageView ImgView;
    @FXML
    private Label lbImage;
    @FXML
    private Label lbFileName;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnReserv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fnShow(); // TODO
    }    

    @FXML
    private void fnSelected(MouseEvent event) {
        Monuments esp= TvMonum.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(esp.getId_monument()));
        lbFileName.setText(esp.getImage_monument());
        lbImage.setVisible(true);
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(image);
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ClientEspMon.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void FnReserver(ActionEvent event) throws IOException {
        if(lbId.getText().equals("")){
            AlertBox.display("Erreur", "Choissir une Monuments !!");
        }else{
        id=Integer.parseInt(lbId.getText());
        Parent etab = FXMLLoader.load(getClass().getResource("AddReservationMon.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }
    }
    
    public void fnShow(){
        ServiceMonuments sr= new ServiceMonuments() {};
        List espaceList = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colDateCreation.setCellValueFactory(new PropertyValueFactory<>("date_creation")); 
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));       
     colLocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));          
        colNomMonument.setCellValueFactory(new PropertyValueFactory<>("nom_monument"));
        colPayant.setCellValueFactory(new PropertyValueFactory<>("payant"));
          colPays.setCellValueFactory(new PropertyValueFactory<>("pays"));
          colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
       
          

                  
        
        
        TvMonum.setItems(list);
         FilteredList<Monuments> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Clients -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Clients.getNom_monument().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (Clients.getPays().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (Clients.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (Clients.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Monuments> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(TvMonum.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		TvMonum.setItems(sortedData);
        TvMonum.setRowFactory(tv -> new TableRow<Monuments>() {
    @Override
    protected void updateItem(Monuments item, boolean empty) {
        
 
        
    }
});

    }
    
    
    
    
}
