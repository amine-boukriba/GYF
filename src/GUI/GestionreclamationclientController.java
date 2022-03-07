/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.reclamation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
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
import javafx.util.Callback;
import javafx.util.Duration;
import services.AlertBox;
import services.ServiceReclamation;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    public static int id_user;
    @FXML
    private Label lbiduser;
        
    

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
        id_user=Integer.parseInt(lbiduser.getText());
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
         String title= "Modifieé avec Succés";
       TrayNotification tray = new TrayNotification();
        AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
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
            String title= "Reclamation supprimée avec succés";
             TrayNotification tray = new TrayNotification();
          AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
            
    }
    
    public void fnShow(){
        ServiceReclamation ser=new ServiceReclamation();
        // user id
        ObservableList<reclamation> list=FXCollections.observableArrayList(ser.afficheById(1));
       lbiduser.setText(String.valueOf(1));
        lbId.setCellValueFactory(new PropertyValueFactory<>("id_reclamation")); 
     lbDateCrea.setCellValueFactory(new PropertyValueFactory<>("date_creation"));       
     lbDateTrai.setCellValueFactory(new PropertyValueFactory<>("date_traitement"));          
        lbStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        lbType.setCellValueFactory(new PropertyValueFactory<>("type_reclamation"));
        
        
        
        tablerec.setItems(list);
         FilteredList<reclamation> filteredData = new FilteredList<>(list, b -> true);
		
		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(rec -> {
				// If filter text is empty, display all reclamation
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (rec.getDate_creation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter by date creation.
                                }
                                        else if(rec.getDate_traitement().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter by date traitement
				}else if (rec.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter by status.
				}else if (rec.getType_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter by type.
				}
				     else  
				    	 return false; // Does not reclamation
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

     TableColumn<reclamation, Void> gotobtn = new TableColumn("Action");
          Callback<TableColumn<reclamation, Void>, TableCell<reclamation, Void>> cellFactory
           = new Callback<TableColumn<reclamation, Void>, TableCell<reclamation, Void>>() {
          
            @Override
            public TableCell<reclamation, Void> call(final TableColumn<reclamation, Void> param) {
                final TableCell<reclamation, Void> cell = new TableCell<reclamation, Void>() {

                    private final Button btn = new Button("Pdf");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                            
                                reclamation data = getTableView().getItems().get(getIndex());
                                int a=data.getId_reclamation();
                                System.out.println(a);
                                reclamation u=new reclamation();
                                String nom=data.getNom();
                                String prenom=data.getPrenom();
                                String email=data.getEmail();
                                String description=data.getDescription();
                                String type=data.getType_reclamation();
                                String datet=data.getDate_traitement();
                                String dater=data.getDate_creation();
                                String status=data.getStatus();
                                
                                
                                
                                Document doc =new Document();
                                
                               try {
                                String file_name="C:\\Users\\ASUS\\Desktop\\mon projet\\bilel\\GYF\\src\\GUI//reclamation.pdf";
                                PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                                doc.open();
                                doc.add(new Paragraph("reclamation: "));
                                doc.add(new Paragraph("nom user: '"+nom+"'"));
                                doc.add(new Paragraph("prenom user: '"+prenom+"'"));
                                doc.add(new Paragraph("email user: '"+email+"'"));
                                doc.add(new Paragraph("Description: '"+description+"'"));
                                doc.add(new Paragraph("type reclamation: '"+type+"'"));
                                doc.add(new Paragraph("date reclamation: '"+dater+"'"));
                                doc.add(new Paragraph("date traitement: '"+datet+"'"));
                                doc.add(new Paragraph("status : '"+status+"'"));
                               
                                doc.close();
                                Desktop.getDesktop().open(new File(file_name));
                            } catch (DocumentException ex) {
                                Logger.getLogger(GestionreclamationadminController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(GestionreclamationadminController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(GestionreclamationadminController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           
                               
                            
         
                            
                        });
                       
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

       gotobtn.setCellFactory(cellFactory);

        tablerec.getColumns().add(gotobtn);
         String title= "voici la liste des réclamations";
       TrayNotification tray = new TrayNotification();
        AnimationType typee = AnimationType.POPUP;
        tray.setAnimationType (typee);
        tray.setTitle(title);
        tray.setMessage(title);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
    }
    
                        
    }
    

