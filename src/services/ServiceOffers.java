/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Offers;
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
public class ServiceOffers implements IService<Offers>{

    Connection connection ;

    public ServiceOffers() {
        connection = MyDB.getInstance().getConnection();
    }
    
            
            
    @Override
    public void ajout(Offers t) {
        try {
            String req = "insert into offers (titre,depart,destination,date_debut,date_fin,nombre_nuits,description,prix, "
                    + "avis_offer)"
                    + "values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_debut());
            ps.setDate(5, t.getDate_fin());
            ps.setInt(6, t.getNombre_nuits());
            ps.setString(7,t.getDescription());
            ps.setFloat(8, t.getPrix());
            ps.setInt(9, t.getAvis_offer());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Offers t) {
        try {
            String req = "update offers set titre = ?,depart = ?,destination = ?,date_debut = ?,date_fin = ?,nombre_nuits = ?,description = ?,prix = ?, "
                    + "avis_offer = ? where id_offer = ?";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_debut());
            ps.setDate(5, t.getDate_fin());
            ps.setInt(6, t.getNombre_nuits());
            ps.setString(7,t.getDescription());
            ps.setFloat(8, t.getPrix());
            ps.setInt(9, t.getAvis_offer());
            ps.setInt(10, t.getId_offer());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprime(int id) {
        try {
            String req = "delete from offers where id_offer=?";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Offers> affiche() {
        
        List<Offers> list = new ArrayList();
        try {
            String req ="select *,(select path from images where offers.id_offer=images.id_offer ) as path from offers";
            
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                list.add(new Offers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getFloat(9),rs.getInt(10),rs.getString(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);
        return list;
    }
    public List<Offers> rechercheOffers(String depart,String destination ,Date date_dep){
         List<Offers> list =new ArrayList();
         
        try {
           
            String req = "select * from offers where depart=? and destination=? and date_debut = ? "; 
            
             PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, depart);
            ps.setString(2,destination);
            ps.setDate(3, date_dep);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Offers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getFloat(9),rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }
    
    public List<Offers> filtrePrix (float prix_min , float prix_max){
        List<Offers> list = new ArrayList();
        try {
            
            String req = "select * from offers where prix between ? and ?";
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setFloat(1, prix_min);
            ps.setFloat(2, prix_max);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                list.add(new Offers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getString(8),rs.getFloat(9),rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int lastId(){
        int id=0;
        String req = "SELECT max(id_offer) id_offer FROM offers";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                id= rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(id);
        return id;
    }
}
