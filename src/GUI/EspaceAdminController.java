/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import services.ServiceMonuments;
import services.ServiceEspaceCulturel;

/**
 * FXML Controller class
 *
 * @author akram
 */
public class EspaceAdminController implements Initializable {

    @FXML
    private Button btnEspCult;
    @FXML
    private Button btnMonm;
    @FXML
    private PieChart piechart;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceMonuments sm = new ServiceMonuments();
        ServiceEspaceCulturel src = new ServiceEspaceCulturel();
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
        new PieChart.Data("Monuments",sm.count()),
        new PieChart.Data("Espace culturels",src.count()));
        piechart.setData(pieChartData);
        piechart.setTitle("Monument et espace culturels");
        // TODO
    }    

    @FXML
    private void fnEspac(ActionEvent event) throws IOException{
        Parent etab = FXMLLoader.load(getClass().getResource("EspaceCulturels.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void fnMonume(ActionEvent event) throws IOException {
        Parent etab = FXMLLoader.load(getClass().getResource("MonumentAdmin.fxml"));      
        Scene scene = new Scene(etab);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
}
