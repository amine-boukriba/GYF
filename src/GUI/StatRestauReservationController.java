/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceReservation;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class StatRestauReservationController implements Initializable {
ServiceReservation res = new ServiceReservation();
  
 @FXML
    private PieChart chart;
  @FXML
    private BarChart bar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // TODO
        
        List<reservation> lclist = new ArrayList<>();
        reservation lc = new reservation();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int total=0;
        
        try {
            String req = "select count(*) as nbr, nom_restaurant from reservations_resto_hotel join restaurants USING (id_restaurant)  GROUP by nom_restaurant ;";
            Statement st = MyDB.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(req);
            while(rs.next()){
                
                lc.setNom_restaurant(rs.getString("nom_restaurant"));
                lc.setId_reservation(rs.getInt("nbr"));
               total += lc.getId_reservation();
                pieChartData.add(new PieChart.Data(lc.getNom_restaurant(), lc.getId_reservation()));
                lclist.add(lc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        chart.setData(pieChartData);
        
        System.out.println(chart.getData());
        chart.getData().sort(new Comparator<PieChart.Data> () {
            @Override
            public int compare(PieChart.Data o1, PieChart.Data o2) {
                if (o1.getPieValue()<o2.getPieValue()) {
                 return 1;
                }
                return -1;
            }
        });
        System.out.println(chart.getData());
    }    

 
}



  

 
 

