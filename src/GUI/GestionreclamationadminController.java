/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
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
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionreclamationadminController implements Initializable {

    @FXML
    private TableView<reclamation> tablerec;
    @FXML
    private Button btnajt;
    private ComboBox<String> typerecherche;
    
    @FXML
    private TextField valrecherche;
    @FXML
    private TableColumn<reclamation, String>nom;
    @FXML
    private TableColumn<reclamation, String> prenom;
    @FXML
    private TableColumn<reclamation, String> mail;
    @FXML
    private TableColumn<reclamation, String> dc;
    @FXML
    private TableColumn<reclamation, String> dt;
    @FXML
    private TableColumn<reclamation, String> type;
    @FXML
    private TableColumn<reclamation, Integer> ColId;
    @FXML
    private ImageView ImageView;
    @FXML
    private Label lbTitreDesc;
    @FXML
    private Label lbDesc;
    @FXML
    private Label IdId;
    public static int id;
    @FXML
    private TableColumn<reclamation, String> status;
    public static String email;
    @FXML
    private Label lbemail;
    @FXML
    private Button btnHist;

    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fnshow();
        
       
    }    

    

    @FXML
    private void ajouterreclamation(ActionEvent event) throws IOException {
        if(IdId.getText().equals("")){
            AlertBox.display("Erreur", "Choissir une reclamation !!");
        }else{
        id=Integer.parseInt(IdId.getText());
        email=lbemail.getText();
        Parent etab = FXMLLoader.load(getClass().getResource("repondrereclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }
    }
    public void fnshow(){
        ServiceReclamation sr= new ServiceReclamation() {};
        List reclamation = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(reclamation);
        
         ColId.setCellValueFactory(new PropertyValueFactory<>("id_reclamation")); 
     nom.setCellValueFactory(new PropertyValueFactory<>("nom"));       
     prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));          
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        dc.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
          dt.setCellValueFactory(new PropertyValueFactory<>("date_traitement"));
          type.setCellValueFactory(new PropertyValueFactory<>("type_reclamation"));
          status.setCellValueFactory(new PropertyValueFactory<>("status"));
          

                  
        
        
        tablerec.setItems(list);
         FilteredList<reclamation> filteredData = new FilteredList<>(list, b -> true);
		
		valrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reclam -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reclam.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (reclam.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (reclam.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (reclam.getType_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                        
                                }else if (reclam.getDate_traitement().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                        
                                }else if (reclam.getDate_creation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                        
                                }else if (reclam.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
				     else  
				    	 return false;
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tablerec.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tablerec.setItems(sortedData);
        tablerec.setRowFactory(tv -> new TableRow<reclamation>() {
    @Override
    protected void updateItem(reclamation item, boolean empty) {
        
 
        
    }
});

    }

    @FXML
    private void fnSelected(MouseEvent event) {
        reclamation rec= tablerec.getSelectionModel().getSelectedItem();
        lbTitreDesc.setVisible(true);
        lbDesc.setText(rec.getDescription());
        String img=rec.getImage_reclamation().replace("\\", "\\\\");
        Image image = new Image("file:///"+img);
        ImageView.setImage(image);
        IdId.setText(String.valueOf(rec.getId_reclamation()));
        lbemail.setText(rec.getEmail());
    }

    @FXML
    private void bntHistory(ActionEvent event) throws IOException {
        if(IdId.getText().equals("")){
            AlertBox.display("Erreur", "Choissir une reclamation !!");
        }else{
        id=Integer.parseInt(IdId.getText());
        Parent etab = FXMLLoader.load(getClass().getResource("HistoryReclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        }
    }

    
}
