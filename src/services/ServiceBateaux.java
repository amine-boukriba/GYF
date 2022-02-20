/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Bateaux;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author anwer
 */
public class ServiceBateaux implements IService<Bateaux>{

    Connection connection;
    
    public ServiceBateaux() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajout(Bateaux t) {
        try {
            String req ="insert into bateaux (compagnie_maritime,depart,destination,date_depart,date_arrive,prix,duree,nom_bateau,image_bateau,avis_bateau) values(?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getCompagnie_maritime());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setFloat(6, t.getPrix());
            ps.setInt(7, t.getDuree());
            ps.setString(8, t.getNom_bateau());
            ps.setString(9, t.getImage_bateau());
            ps.setInt(10, t.getAvis_bateau());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Bateaux t) {
        try {
            String req = "update bateaux set compagnie_maritime = ?,depart = ?,destination = ?,date_depart = ?,date_arrive = ?,prix = ?,duree = ?"
                    + ",nom_bateau = ?,image_bateau = ?,avis_bateau = ? where id_bateau = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getCompagnie_maritime());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setFloat(6, t.getPrix());
            ps.setInt(7, t.getDuree());
            ps.setString(8, t.getNom_bateau());
            ps.setString(9, t.getImage_bateau());
            ps.setInt(10, t.getAvis_bateau());
            ps.setInt(11, t.getId_bateau());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprime(int id) {
        try {
            String req = "delete from bateaux where id_bateau = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Bateaux> affiche() {
        List<Bateaux> list = new ArrayList();
        try {
            
            String req = "select * from bateaux";
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                list.add( new Bateaux(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getFloat(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Bateaux> getOne(int id){
        List<Bateaux> list = new ArrayList();
        try {
            
            String req = "select * from bateaux where id_bateau = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add( new Bateaux(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getFloat(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Bateaux> rechercheBateaux(String depart,String destination ,Date date_dep){
         List<Bateaux> list =new ArrayList();
         
        try {
           
            String req = "select * from bateaux where depart=? and destination=? and date_depart = ? "; 
            
             PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, depart);
            ps.setString(2,destination);
            ps.setDate(3, date_dep);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Bateaux(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getFloat(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    public List<Bateaux> filtrePrix (float prix_min , float prix_max){
        List<Bateaux> list = new ArrayList();
        try {
            
            String req = "select * from bateaux where prix between ? and ?";
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setFloat(1, prix_min);
            ps.setFloat(2, prix_max);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                list.add(new Bateaux(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getFloat(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
