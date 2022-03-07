/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import services.ServiceEvents;
import entities.Evenement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AfficherController implements Initializable {

    private Button seachhotels;
    private Button seachresto;
    private Button searchEvents;
    private Button seachhistoires;
    private Button logout;
    @FXML
    private TableView<Evenement> table_events;
    @FXML
    private TableColumn<Evenement,String> nom_event;
    @FXML
    private TableColumn<Evenement,String> type_event;
    @FXML
    private TableColumn<Evenement,Date> date_debut_event;
    @FXML
    private TableColumn<Evenement,Date> date_fin_event;
    @FXML
    private TableColumn<Evenement,Integer> prix_event;
    @FXML
    private TableColumn<Evenement,Integer> pays_event;
    @FXML
    private TableColumn<Evenement,String> localisation_event;
    private Button vols;
    private Button bateau;
    private Button offre;
    @FXML
    private ImageView imagev;
   
       public void fnshow(){
            ServiceEvents sp = new ServiceEvents();
        List Eventss = sp.affiche();
        ObservableList list = FXCollections.observableArrayList(Eventss);
        table_events.setItems(list);
         nom_event.setCellValueFactory(new PropertyValueFactory<>("nom"));
         type_event.setCellValueFactory(new PropertyValueFactory<>("type"));
         prix_event.setCellValueFactory(new PropertyValueFactory<>("prix"));
         pays_event.setCellValueFactory(new PropertyValueFactory<>("pays"));
         localisation_event.setCellValueFactory(new PropertyValueFactory<>("localisation"));
         date_debut_event.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         date_fin_event.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
      
         
          TableColumn<Evenement, Void> gotobtn = new TableColumn("Action");
          Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>> cellFactory
           = new Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>>() {
          
            @Override
            public TableCell<Evenement, Void> call(final TableColumn<Evenement, Void> param) {
                final TableCell<Evenement, Void> cell;
                cell = new TableCell<Evenement, Void>() {
                    
                    private final Button btn = new Button("Pdf");
 
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Evenement data = getTableView().getItems().get(getIndex());
                            int a=data.getId_event();
                            System.out.println(a);
                            Evenement u=new Evenement();
                            String nom=data.getNom();
                            String description=data.getDescription();
                            String type=data.getType();
                            String urlimage=data.getImage();
                            String localisation=data.getLocalisation();
                            String pays=data.getPays();
                            String nre_par=String.valueOf(data.getNbre_participants());
                            String prix=String.valueOf(data.getPrix());
                            String dated=String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", data.getDate_debut());
                            String datef=String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", data.getDate_fin());
                            
                                    
                            Document doc =new Document();
                             
                            try {
                                String file_name="C:\\Users\\moham\\OneDrive\\Desktop\\gestion_evenement\\GYF\\src\\GUI//Evenement.pdf";
                                PdfWriter.getInstance(doc, new FileOutputStream(file_name));
                                doc.open();
                                doc.addTitle("Evenemet: "+nom);
                                doc.add(new Paragraph("Description: '"+nom+"'"));
                                doc.add(new Paragraph("Catégorie: '"+type+"'"));
                                //Image img=Image.getInstance(urlimage);
                               // doc.add(img);
                                doc.add(new Paragraph("pays: '"+pays+"'"));
                                doc.add(new Paragraph("localisation: '"+localisation+"'"));
                                doc.add(new Paragraph("Nombre de Participant: '"+nre_par+"'"));
                                doc.add(new Paragraph("Prix: '"+prix+"'"));
                                doc.add(new Paragraph("Date début: '"+dated+"'"));
                                doc.add(new Paragraph("Date fin: '"+datef+"'"));
                                doc.close();
                                Desktop.getDesktop().open(new File(file_name));
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DocumentException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            String title= "PDF téléchargé avec succés";
                        TrayNotification tray = new TrayNotification();
                        AnimationType typee = AnimationType.POPUP;
                        tray.setAnimationType (typee);
                        tray.setTitle(title);
                        tray.setMessage(title);
                        tray.setNotificationType(NotificationType.SUCCESS);
                        tray.showAndDismiss(Duration.millis(3000));
                            
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

        table_events.getColumns().add(gotobtn);
        
           
       }
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   assert table_events != null : "fx:id=\"table_events\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert nom_event != null : "fx:id=\"nom_event\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert type_event != null : "fx:id=\"type_event\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert prix_event != null : "fx:id=\"prix_event\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert pays_event != null : "fx:id=\"pays_event\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert localisation_event != null : "fx:id=\"localisation_event\" was not injected: check your FXML file 'gererevents.fxml'.";
		
      fnshow(); 

    }
    

         
        // TODO
       
  
        }
    

