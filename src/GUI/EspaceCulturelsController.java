/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Espace_culturels;
import entities.Monuments;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServiceEspaceCulturel;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import org.apache.commons.lang3.RandomStringUtils;
import services.ServiceMonuments;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class EspaceCulturelsController implements Initializable {

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
    private Button btnImage;
    @FXML
    private ComboBox<String> ComboPayant;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdescription;
    @FXML
    private DatePicker TfDate;
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
    private TableView<Espace_culturels> TvMonum;
    @FXML
    private TableColumn<Espace_culturels, String> colNomMonument;
    @FXML
    private TableColumn<Espace_culturels, String> colPayant;
    @FXML
    private TableColumn<Espace_culturels, Integer> colPrix;
    @FXML
    private TableColumn<Espace_culturels, String> colDescription;
    @FXML
    private TableColumn<Espace_culturels, String> colDateCreation;
    @FXML
    private TableColumn<Espace_culturels, String> colPays;
    @FXML
    private TableColumn<Espace_culturels, String> colLocalisation;
    @FXML
    private TableColumn<Espace_culturels, String> colHoraire;
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
    private TextField tfHoraire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String>  list =FXCollections.observableArrayList("Non payant","Payant");
        ComboPayant.setItems(list);
       fnShow();
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
        

               Path save=Paths.get("C:\\Users\\akram\\GYF\\src\\public\\Image\\Espace_Cult\\"+rndchars+"_"+rndchars+".jpg");
                Files.copy(Paths.get(filename), save);
        lbFileName.setVisible(false);
        String pathbd=save.toString().replace("\\" , "\\\\");
        lbFileName.setText(pathbd);
            System.out.println(save); 
            } catch (java.nio.file.FileAlreadyExistsException e) {
               Path save=Paths.get("C:\\Users\\akram\\GYF\\src\\public\\Image\\Espace_Cult\\"+rndchars+"_"+rndchars+".jpg");
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
    private void fnInsert(ActionEvent event) {
        Espace_culturels mon=new Espace_culturels();
        mon.setDate_creation(TfDate.getValue().toString());
        mon.setDescription(tfdescription.getText());
        mon.setImage_espace(lbFileName.getText());
        mon.setLocalisation(tflocalisation.getText());
        mon.setNom_espace(tfnom_monument.getText());
        mon.setHoraire(tfHoraire.getText());
        if(ComboPayant.getValue()=="Non payant"){
            mon.setPaye(Boolean.FALSE);
        }else if(ComboPayant.getValue()=="Payant"){
            mon.setPaye(Boolean.TRUE);
        }
        mon.setPays(tfpays.getText());
        mon.setAvis_espace(5);
        mon.setPrix(Integer.parseInt(tfprix.getText()));
        ServiceEspaceCulturel ser=new ServiceEspaceCulturel();
        ser.ajout(mon);
        fnShow();
        lbId.setText("");
        lbFileName.setText("");
        lbImage.setVisible(false);
        tfdescription.setText("");
        tflocalisation.setText("");
        tfnom_monument.setText("");
        tfHoraire.setText("");
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
        Espace_culturels mon=new Espace_culturels();
        mon.setId_espace(Integer.parseInt(lbId.getText()));
        mon.setDate_creation(TfDate.getValue().toString());
        mon.setDescription(tfdescription.getText());
        mon.setImage_espace(lbFileName.getText());
        mon.setLocalisation(tflocalisation.getText());
        mon.setHoraire(tfHoraire.getText());
        mon.setNom_espace(tfnom_monument.getText());
        if(ComboPayant.getValue()=="Non payant"){
            mon.setPaye(Boolean.FALSE);
        }else if(ComboPayant.getValue()=="Payant"){
            mon.setPaye(Boolean.TRUE);
        }
        mon.setPays(tfpays.getText());
        mon.setAvis_espace(5);
        mon.setPrix(Integer.parseInt(tfprix.getText()));
        ServiceEspaceCulturel ser=new ServiceEspaceCulturel();
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
        tfHoraire.setText("");
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(null);
        ComboPayant.setValue("");
        TfDate.setValue(null);
    }

    @FXML
    private void fnDelete(ActionEvent event) {
        ServiceEspaceCulturel sr= new ServiceEspaceCulturel() {};
        sr.supprime(Integer.parseInt(lbId.getText()));
        fnShow();
        lbId.setText("");
        lbFileName.setText("");
        lbImage.setVisible(false);
        tfdescription.setText("");
        tflocalisation.setText("");
        tfnom_monument.setText("");
        tfpays.setText("");
        tfprix.setText("");
        tfHoraire.setText("");
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(null);
        ComboPayant.setValue("");
        TfDate.setValue(null);
    }

    @FXML
    private void fnSelected(MouseEvent event) {
        Espace_culturels esp= TvMonum.getSelectionModel().getSelectedItem();
        lbId.setText(String.valueOf(esp.getId_espace()));
        lbFileName.setText(esp.getImage_espace());
        lbImage.setVisible(true);
        tfdescription.setText(esp.getDescription());
        tflocalisation.setText(esp.getLocalisation());
        tfnom_monument.setText(esp.getNom_espace());
        tfpays.setText(esp.getPays());
        tfprix.setText(String.valueOf(esp.getPrix()));
        tfHoraire.setText(esp.getHoraire());
        String img="file:///"+lbFileName.getText();
       Image image=new Image(img);
       ImgView.setImage(image);
        if(esp.getPaye()==true){
            ComboPayant.setValue("Payant");
        }else if(esp.getPaye()==false){
            ComboPayant.setValue("Non payant");
        }
        TfDate.setValue(LocalDate.parse(esp.getDate_creation()));
        
    }

    @FXML
    private void fnRetour(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("EspaceAdmin.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    public void fnShow(){
        ServiceEspaceCulturel sr= new ServiceEspaceCulturel() {};
        List espaceList = sr.affiche();
        ObservableList list =FXCollections.observableArrayList(espaceList);
        
         colDateCreation.setCellValueFactory(new PropertyValueFactory<>("date_creation")); 
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));       
     colLocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));          
        colNomMonument.setCellValueFactory(new PropertyValueFactory<>("nom_espace"));
        colPayant.setCellValueFactory(new PropertyValueFactory<>("paye"));
          colPays.setCellValueFactory(new PropertyValueFactory<>("pays"));
          colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          colHoraire.setCellValueFactory(new PropertyValueFactory<>("horaire"));
       
          

                  
        
        
        TvMonum.setItems(list);
         FilteredList<Espace_culturels> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Clients -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Clients.getNom_espace().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (Clients.getPays().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (Clients.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (Clients.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}else if (Clients.getHoraire().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Espace_culturels> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(TvMonum.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		TvMonum.setItems(sortedData);
        TvMonum.setRowFactory(tv -> new TableRow<Espace_culturels>() {
    @Override
    protected void updateItem(Espace_culturels item, boolean empty) {
        
 
        
    }
});

    }
}
