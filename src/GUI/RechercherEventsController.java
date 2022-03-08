/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Evenement;
import java.awt.Desktop;
import java.io.File;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.ServiceEvents;

/**
 * FXML Controller class
 *
 * @author moham
 */ 
public class RechercherEventsController implements Initializable {

    private Button seachhotels;
    private Button seachresto;
    private Button searchEvents;
    private Button seachhistoires;
    @FXML
    private TextField nom_evenement;
    private DatePicker date_debut;
    private DatePicker date_fin;
    @FXML
    private Button rechercher;
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
    private TableColumn<Evenement,String> pays_event;
    @FXML
    private TableColumn <Evenement,String> localisation_event;
    @FXML
    private AnchorPane recherchepannel;
    private Button vol;
    private Button batteau;
    private Button offre;
    @FXML
    private TableColumn<?,?> gotobtn;
     public void gotohotels(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficherHotel.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	public void handleMouseEvent(MouseEvent event) {

	}
      public    void gotoRestaurant(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjouterRestaurant.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();

    }

   public void gotoActivites(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficher.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
    
   public void gotoHistoirEtCulture(ActionEvent event) throws IOException {
        
       Parent root = FXMLLoader.load(getClass().getResource("../GUI/ajoutermonument.fxml"));
       Scene scene = new Scene(root);
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.setScene(scene);
       stage.show();
 
    }
 public void gotovols(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/ajoutervol.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
     public void gotoBateau(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/ajouterBateau.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
         
        public void gotooffre(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/ajouterutilisateur.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
        
     public void gotointernaute(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/template.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
     
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
         
           table_events.setItems(list);
         FilteredList<Evenement> filteredData = new FilteredList<>(list, b -> true);
		
		nom_evenement.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(event -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
                                        
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (event.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (event.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (event.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}else if (event.getPays().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                        
                                }//else if (event.getDate_debut().toLowerCase.indexOf(lowerCaseFilter) != -1 ) {
					//return true; 
                                        
                                //}//else if (event.getDate_fin().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					//return true; 
                                        
                                //}//else if (event.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					//return true; 
				//}
				     else  
				    	 return false;
			});
		});
               // dayed_search.getValue(). -> {
		//	filteredData.setPredicate(event -> {
				// If filter text is empty, display all persons.
								
			//	if (newValue == null || newValue.isEmpty()) {
			//		return true;
                                        
			//	}
                	  //  	 return false;
			//});
		//});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Evenement> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table_events.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table_events.setItems(sortedData);
        table_events.setRowFactory(tv -> new TableRow<Evenement>() {
    @Override
    protected void updateItem(Evenement item, boolean empty) {
        
 
        
    }
});
         TableColumn<Evenement, Void> gotobtn = new TableColumn("Action");
          Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>> cellFactory
           = new Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>>() {
          
            @Override
            public TableCell<Evenement, Void> call(final TableColumn<Evenement, Void> param) {
                final TableCell<Evenement, Void> cell = new TableCell<Evenement, Void>() {

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
                                Image img=Image.getInstance(urlimage);
                                img.setAbsolutePosition(0, 0);
                                img.scaleToFit(826, 1100);
                                doc.add(img);
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
                            } catch (IOException | DocumentException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
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

        table_events.getColumns().add(gotobtn);
         
     }
       public void gotoallEvents(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("../GUI/afficher.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
    ServiceEvents se=new ServiceEvents();
    ObservableList<Evenement> Events = FXCollections.observableArrayList();
   ObservableList<Evenement> allEvents;
   ObservableList<Evenement> selectedevents;
    @FXML
    
	public void SearchEvent(ActionEvent event) {
           Evenement u = new Evenement();
        
            ServiceEvents sp = new ServiceEvents();
            List Event = sp.affiche();
      
            u.setNom(nom_evenement.getText().toLowerCase());
            
		List<Evenement> listemps = sp.rechercherparnom(u.getNom());
                for(int i=0;i<listemps.size();i++){
                    u=listemps.get(i);
                }
                 ObservableList list = FXCollections.observableArrayList(u);
                
         table_events .setItems(list);
         nom_event.setCellValueFactory(new PropertyValueFactory<>("nom"));
         type_event.setCellValueFactory(new PropertyValueFactory<>("type"));
         prix_event.setCellValueFactory(new PropertyValueFactory<>("prix"));
         pays_event.setCellValueFactory(new PropertyValueFactory<>("pays"));
         localisation_event.setCellValueFactory(new PropertyValueFactory<>("localisation"));
         date_debut_event.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         date_fin_event.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
         
                       
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
		assert date_debut != null : "fx:id=\"date_debut\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert date_fin != null : "fx:id=\"date_fin\" was not injected: check your FXML file 'gererevents.fxml'.";
	        assert seachhotels != null : "fx:id=\"seachhotels\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert seachresto != null : "fx:id=\"seachresto\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert searchEvents != null : "fx:id=\"searchEvents\" was not injected: check your FXML file 'gererevents.fxml'.";
		assert seachhistoires != null : "fx:id=\"seachhistoires\" was not injected: check your FXML file 'gererevents.fxml'.";
		
     //   ServiceEvents sp = new ServiceEvents();
       // List Eventss = sp.affiche();
        //ObservableList list = FXCollections.observableArrayList(Eventss);
        //table_events.setItems(list);
        // nom_event.setCellValueFactory(new PropertyValueFactory<>("nom"));
         //type_event.setCellValueFactory(new PropertyValueFactory<>("type"));
        // prix_event.setCellValueFactory(new PropertyValueFactory<>("prix"));
         //pays_event.setCellValueFactory(new PropertyValueFactory<>("pays"));
         //localisation_event.setCellValueFactory(new PropertyValueFactory<>("localisation"));
         //date_debut_event.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         //date_fin_event.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
         
         
          //TableColumn<Evenement, Void> gotobtn = new TableColumn("Action");
          //Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>> cellFactory
           //= new Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>>() {
          
            //@Override
           /* public TableCell<Evenement, Void> call(final TableColumn<Evenement, Void> param) {
                final TableCell<Evenement, Void> cell = new TableCell<Evenement, Void>() {

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
                                //doc.add(img);
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
                            } catch (IOException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DocumentException ex) {
                                Logger.getLogger(RechercherEventsController.class.getName()).log(Level.SEVERE, null, ex);
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

        table_events.getColumns().add(gotobtn);
        

    }
    */

         
        // TODO
       
  fnshow();
        }

}

