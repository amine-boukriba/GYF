/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.AlertBox;
import services.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionreclamationclientController implements Initializable {

    @FXML
    private TableView<reclamation> tablerec;
    @FXML
    private TableColumn<reclamation, Integer> lbId;
    @FXML
    private TableColumn<reclamation, String> lbDateCrea;
    @FXML
    private TableColumn<reclamation, String> lbDateTrai;
    @FXML
    private TableColumn<reclamation, String> lbType;
    @FXML
    private TableColumn<reclamation, String> lbStatus;
    @FXML
    private Button btnajt;
    @FXML
    private Button btnmdf;
    @FXML
    private Button btnsuppr;
    @FXML
    private Label lbTitreDesc;
    @FXML
    private Label lbDesc;
    @FXML
    private TextField tfSearch;
    @FXML
    private ImageView ImgView;
    @FXML
    private Label IdId;
    public static reclamation recco;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fnShow(); // TODO
    }    

    @FXML
    private void fnSelected(MouseEvent event) {
        reclamation rec= tablerec.getSelectionModel().getSelectedItem();
        lbTitreDesc.setVisible(true);
        lbDesc.setText(rec.getDescription());
        String img=rec.getImage_reclamation().replace("\\", "\\\\");
        Image image = new Image("file:///"+img);
        ImgView.setImage(image);
        IdId.setText(String.valueOf(rec.getId_reclamation()));
     
    }

    @FXML
    private void ajoutreclamation(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("ajoutreclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
    }

    @FXML
    private void modifierreclamation(ActionEvent event) throws IOException {
        if(IdId.getText().equals("")){
            AlertBox.display("Erreur", "Choissir une reclamation !!");
        }else{
        reclamation rec= tablerec.getSelectionModel().getSelectedItem();
        recco=rec;
        Parent etab = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
        }
    }

    @FXML
    private void supprReclamation(ActionEvent event) {
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
            Alert.AlertType type=Alert.AlertType.CONFIRMATION;
            Alert alert=new Alert(type,"");
            
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(window);
            alert.getDialogPane().setContentText("Voulez-vous continuer ?");

            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get()==ButtonType.OK) {
        if(IdId.getText().equals("")){
            AlertBox.display("Erreur", "Choissir une reclamation !!");
        }else{
        ServiceReclamation ser=new ServiceReclamation();
        ser.supprime(Integer.parseInt(IdId.getText()));
        lbDesc.setText("");
        lbTitreDesc.setVisible(false);
        ImgView.setImage(null);
        IdId.setText("");
        fnShow();
        }}else if (result.get()==ButtonType.CANCEL) {
                
            window.close();
            
        }
    }
    
    public void fnShow(){
        ServiceReclamation ser=new ServiceReclamation();
        // user id
        ObservableList<reclamation> list=FXCollections.observableArrayList(ser.afficheById(2));
       
        lbId.setCellValueFactory(new PropertyValueFactory<>("id_reclamation")); 
     lbDateCrea.setCellValueFactory(new PropertyValueFactory<>("date_creation"));       
     lbDateTrai.setCellValueFactory(new PropertyValueFactory<>("date_traitement"));          
        lbStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        lbType.setCellValueFactory(new PropertyValueFactory<>("type_reclamation"));
        
        
        
        tablerec.setItems(list);
         FilteredList<reclamation> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(reclam -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (reclam.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (reclam.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (reclam.getType_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                }else if (reclam.getDate_creation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
                                }else if (reclam.getDate_traitement().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
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
    
}
