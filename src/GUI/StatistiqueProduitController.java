/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import entities.Chambre;
import entities.Hotel;
import entities.reservation;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.ServiceReservation;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author omarb
 */
public class StatistiqueProduitController implements Initializable {
ServiceReservation res = new ServiceReservation();

    @FXML
    private PieChart chart;
    
    @FXML
    private PieChart chart1;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         chart1();
        
        chart();
        
       
  //      pane.getChildren().add(buildBarChart());
    }
    private void chart1(){
        
           chart.setTitle("Statistiques de nombre de reservation ");
        
        
        List<reservation> lclist = new ArrayList<>();
        reservation lc = new reservation();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        int total=0;
        try {
            String req = "select count(*) as nbr,nom_hotel from reservations_resto_hotel join chambre USING (id_chambre) join hotels using (id_hotel) GROUP by nom_hotel ;";
            Statement st = MyDB.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(req);
            while(rs.next()){
                
                lc.setNom_hotel(rs.getString("nom_hotel"));
                lc.setId_reservation(rs.getInt("nbr"));
               total += lc.getId_reservation();
                pieChartData.add(new PieChart.Data(lc.getNom_hotel(), lc.getId_reservation()));
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
   /* private BarChart buildBarChart() { 
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        res.statstypechambre().forEach((p)->{
            dataSeries1.getData().add(new XYChart.Data(p.get(0), p.get(1)));
        });
        barChart.getData().add(dataSeries1);
        barChart.setId("bar_chart");
        barChart.setPrefHeight(300);
        barChart.setPrefWidth(324); 
        return barChart;
    }

   */
    
    private void chart(){
        
        
           chart1.setTitle("Statistique de nombre de chambre ");
        
         List<reservation> lclist1 = new ArrayList<>();
        reservation lc1 = new reservation();
                        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        int total1=0;
        
        try {
            String req = "select count(*) as nbr,type_chambre from reservations_resto_hotel join chambre USING (id_chambre) GROUP by type_chambre; ";
            Statement st = MyDB.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(req);
            while(rs.next()){
                
                lc1.setNom_hotel(rs.getString("type_chambre"));
                lc1.setId_reservation(rs.getInt("nbr"));
               total1 += lc1.getId_reservation();
                pieChartData.add(new PieChart.Data(lc1.getNom_hotel(), lc1.getId_reservation()));
                lclist1.add(lc1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        chart1.setData(pieChartData);
        
        System.out.println(chart1.getData());
        chart1.getData().sort(new Comparator<PieChart.Data> () {
            @Override
            public int compare(PieChart.Data o1, PieChart.Data o2) {
                if (o1.getPieValue()<o2.getPieValue()) {
                 return 1;
                }
                return -1;
            }
        });
        System.out.println(chart1.getData());
       
    }
}


