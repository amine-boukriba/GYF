/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Monuments;
import static java.awt.SystemColor.info;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.lang3.RandomStringUtils;
import services.ServiceMonuments;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class MonumentAdminController implements Initializable {

    @FXML
    private Label nom_monument;
    @FXML
    private Label image;
    @FXML
    private Label payant;
    @FXML
    private Label prix;
    @FXML
    private Label description;
    @FXML
    private Label date_creation;
    @FXML
    private Label pays;
    @FXML
    private Label localisation;
    
    @FXML
    private TextField tfnom_monument;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfpays;
    @FXML
    private TextField tflocalisation;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
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
    private TableView<Monuments> TvMonum;
    @FXML
    private Button btnImage;
    @FXML
    private ComboBox<String> ComboPayant;
    @FXML
    private DatePicker TfDate;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String>  list =FXCollections.observableArrayList("Non payant","Payant");
        ComboPayant.setItems(list);
       fnShow(); // TODO
    }    

    @FXML
   private void fnInsert(ActionEvent event) {
        Monuments mon=new Monuments();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        mon.setDate_creation(TfDate.getValue().toString());
        mon.setDescription(tfdescription.getText());
        mon.setImage_monument(lbFileName.getText());
        mon.setLocalisation(tflocalisation.getText());
        mon.setPays(tfpays.getText());
        mon.setNom_monument(tfnom_monument.getText());
        
        if(tfnom_monument.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le nom du Monument!");
           tfnom_monument.setStyle("-fx-border-color: red; -fx-border-width:2px;");
            new animatefx.animation.Shake(tfnom_monument).play();
           
             alert.show();
            
        }
        else if(tfdescription.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer la description du Monument!");
             tfdescription.setStyle("-fx-border-color: red; -fx-border-width:2px;");
            new animatefx.animation.Shake(tfdescription).play();
            alert.show();
        }
        else if(tflocalisation.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer la localisation du Monument!");
            tflocalisation.setStyle("-fx-border-color: red; -fx-border-width:2px;");
            new animatefx.animation.Shake(tflocalisation).play();
            alert.show();
        }
        else if(tfpays.getText().isEmpty()){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("veuillez insérer le pays du Monument!");
            tfpays.setStyle("-fx-border-color: red; -fx-border-width:2px;");
            new animatefx.animation.Shake(tfpays).play();
            alert.show();
        }
        else if(ComboPayant.getValue()=="Non payant"){
            mon.setPayant(Boolean.FALSE);
        }else if(ComboPayant.getValue()=="Payant"){
            mon.setPayant(Boolean.TRUE);
        }
        mon.setAvis_monument(5);
        mon.setPrix(Integer.parseInt(tfprix.getText()));
        ServiceMonuments ser=new ServiceMonuments();
        ser.ajout(mon);
        
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Monuments ajouté avec succés!");
        alert.show();
        
       
        fnShow();
        lbId.setText("");
        lbFileName.setText("");
        lbImage.setVisible(false);
        tfdescription.setText("");
        tflocalisation.setText("");
        tfnom_monument.setText("");
        
        tfpays.setText("");
        tfprix.setText("");
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(null);
        ComboPayant.setValue("");
        TfDate.setValue(null);
    }

    @FXML
    private void fnUpdate(ActionEvent event) {
        Monuments mon=new Monuments();
        mon.setId_monument(Integer.parseInt(lbId.getText()));
        mon.setDate_creation(TfDate.getValue().toString());
        mon.setDescription(tfdescription.getText());
        mon.setImage_monument(lbFileName.getText());
        mon.setLocalisation(tflocalisation.getText());
        mon.setNom_monument(tfnom_monument.getText());
        if(ComboPayant.getValue()=="Non payant"){
            mon.setPayant(Boolean.FALSE);
        }else if(ComboPayant.getValue()=="Payant"){
            mon.setPayant(Boolean.TRUE);
        }
        mon.setPays(tfpays.getText());
        mon.setAvis_monument(5);
        mon.setPrix(Integer.parseInt(tfprix.getText()));
        ServiceMonuments ser=new ServiceMonuments();
        ser.modifier(mon);
        fnShow();
        lbId.setText("");
        lbFileName.setText("");
        lbImage.setVisible(false);
        tfdescription.setText("");
        tflocalisation.setText("");
        tfnom_monument.setText("");
        tfpays.setText("");
        tfprix.setText("");
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(null);
        ComboPayant.setValue("");
        TfDate.setValue(null);
    }

    @FXML
    private void fnDelete(ActionEvent event) {
        ServiceMonuments sr= new ServiceMonuments() {};
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        
        alert.setTitle("Confirmation suppression!");
        alert.setHeaderText(null);
        alert.setContentText("Etes vous sur de supprimer ce monument!");
        Optional <ButtonType> action = alert.showAndWait();
        
        if (action.get() == ButtonType.OK){
        sr.supprime(Integer.parseInt(lbId.getText()));
        }
        
        fnShow();
        lbId.setText("");
        lbFileName.setText("");
        lbImage.setVisible(false);
        tfdescription.setText("");
        tflocalisation.setText("");
        tfnom_monument.setText("");
        tfpays.setText("");
        tfprix.setText("");
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(null);
        ComboPayant.setValue("");
        TfDate.setValue(null);
    }

    @FXML
    private void fnSelected(MouseEvent event) {
        Monuments mon= TvMonum.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(mon.getId_monument()));
        lbFileName.setText(mon.getImage_monument());
        lbImage.setVisible(true);
        tfdescription.setText(mon.getDescription());
        tflocalisation.setText(mon.getLocalisation());
        tfnom_monument.setText(mon.getNom_monument());
        tfpays.setText(mon.getPays());
        tfprix.setText(String.valueOf(mon.getPrix()));
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(image);
        if(mon.getPayant()==true){
            ComboPayant.setValue("Payant");
        }else if(mon.getPayant()==false){
            ComboPayant.setValue("Non payant");
        }
        TfDate.setValue(LocalDate.parse(mon.getDate_creation()));
        
        
    }
    
    public void fnShow(){
        ServiceMonuments sr= new ServiceMonuments() {};
        List reclamation = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(reclamation);
        
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

    @FXML
    private void fnAddImage(ActionEvent event) throws IOException {
        FileChooser chooser=new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG FILE","*.jpg"));
        chooser.setTitle("Choose Image");
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        File file=chooser.showOpenDialog(stage);
        if(file !=null){
        String filename=file.getAbsolutePath();
        filename=filename.replace("\\" , "\\\\");
         String rndchars = RandomStringUtils.randomAlphanumeric(16);
            try {
        

               Path save=Paths.get("C:\\Users\\akram\\GYF\\src\\public\\Image\\Monuments\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        lbFileName.setVisible(false);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbFileName.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("C:\\Users\\akram\\GYF\\src\\public\\Image\\Monuments\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
                String pathbd=save.toString().replace("\\" , "\\\\");
        lbFileName.setVisible(false);
        lbFileName.setText(pathbd);
            System.out.println(save); 
            }
        
        Image img=new Image("file:///"+filename);
        ImgView.setImage(img);
        }
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("EspaceAdmin.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
   
        
      
   
        
        
        
    } 
