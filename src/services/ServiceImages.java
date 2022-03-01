/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Images;
import java.sql.Connection;
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
public class ServiceImages {
    
    Connection connection;
    
    public ServiceImages() {
        connection = MyDB.getInstance().getConnection();
    }

    
    public void ajout(Images t) {
        try {
            
                String req = "insert into images (path,id_espace_culturels,id_evenement,id_hotel,id_monument,id_offer,id_restaurant) values (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, t.getPath());
            if(t.getId_espace_culturels()==0){
                ps.setNull(2, 0);
            }else{
                ps.setInt(2, t.getId_espace_culturels());
            }
            if(t.getId_evenement()==0){
                ps.setNull(3, 0);
            }else{
                ps.setInt(3, t.getId_evenement());
            }
            if(t.getId_hotel()==0){
                ps.setNull(4, 0);
            }else{
                ps.setInt(4, t.getId_hotel());
            }
            if(t.getId_monument()==0){
                ps.setNull(5, 0);
            }else{
                ps.setInt(5, t.getId_monument());
            }
            if(t.getId_offer()==0){
                ps.setNull(6, 0);
            }else{
                ps.setInt(6, t.getId_offer());
            }
            if(t.getId_restaurant()==0){
                ps.setNull(7, 0);
            }else{
                ps.setInt(7, t.getId_restaurant());
            }

            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public void modifier(Images t) {
            
        String req ="update images set path=? ,id_espace_culturels =?,id_evenement =?,id_hotel=?,id_hotel=?,id_offer =?,id_restaurant =? where id_offer =?";
        try{
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, t.getPath());
            if(t.getId_espace_culturels()==0){
                ps.setNull(2, 0);
            }else{
                ps.setInt(2, t.getId_espace_culturels());
            }
            if(t.getId_evenement()==0){
                ps.setNull(3, 0);
            }else{
                ps.setInt(3, t.getId_evenement());
            }
            if(t.getId_hotel()==0){
                ps.setNull(4, 0);
            }else{
                ps.setInt(4, t.getId_hotel());
            }
            if(t.getId_monument()==0){
                ps.setNull(5, 0);
            }else{
                ps.setInt(5, t.getId_monument());
            }
            if(t.getId_offer()==0){
                ps.setNull(6, 0);
            }else{
                ps.setInt(6, t.getId_offer());
            }
            if(t.getId_restaurant()==0){
                ps.setNull(7, 0);
            }else{
                ps.setInt(7, t.getId_restaurant());
            }
            ps.setInt(8, t.getId_offer());
            ps.executeUpdate();
  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void supprime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Images> affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Images> getPath(int id){
        List<Images> list = new ArrayList<>();
        try {
            String req = "select path from images where id_offer = "+id+"";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Images i =new Images();
                i.setPath(rs.getString("path"));
                list.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
