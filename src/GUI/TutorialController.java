/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class TutorialController implements Initializable {

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
    private TextField tfimage;
    @FXML
    private TextField tfpayant;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfdescription;
    @FXML
    private TextField tfdatecreation;
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
    private TableView<?> tablemonument;
    @FXML
    private TableColumn<?, ?> colNomMonument;
    @FXML
    private TableColumn<?, ?> colimage;
    @FXML
    private TableColumn<?, ?> colPayant;
    @FXML
    private TableColumn<?, ?> colPrix;
    @FXML
    private TableColumn<?, ?> colDescription;
    @FXML
    private TableColumn<?, ?> colDateCreation;
    @FXML
    private TableColumn<?, ?> colPays;
    @FXML
    private TableColumn<?, ?> colLocalisation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
}
