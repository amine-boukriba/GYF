/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Monuments;
import entities.Reservation;
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
 * @author akram
 */
public class ServiceReservation implements IService<Reservation>{
Connection cnx;
    
    public ServiceReservation(){
        cnx= MyDB.getInstance().getConnection();
    }
    @Override
    public void ajout(Reservation t) {
       try {
            String req="insert into reservation(user,type,id_esp,num_card,Date_reservation,card_password) values (?,?,?,?,?,?)";
                  
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getUser());
            ps.setBoolean(2, t.getType());
            ps.setInt(3, t.getId_esp());
            ps.setInt(4, t.getNum_card());
            ps.setString(5, t.getDate_reservation());
            ps.setString(6, t.getCard_password());
            
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Reservation t) {
    try {
            String req="update reservation set num_card= ? ,Date_reservation= ? ,card_password= ? ,id_esp= ? where id= ? ";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setInt(1, t.getNum_card());
            ps.setString(2, t.getDate_reservation());
            ps.setString(3, t.getCard_password());
            ps.setInt(4, t.getId_esp());
            ps.setInt(5, t.getId());
           
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void supprime(int id) {
       try {
            String req="delete from reservation where id=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reservation> affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Reservation> afficheEspCult(int id){
        List <Reservation> list = new ArrayList<>();
        try {
            String req="select * from reservation where type=true and user="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Reservation m = new Reservation();
                m.setId(rs.getInt("id"));
                m.setCard_password(rs.getString("card_password"));
                m.setDate_reservation(rs.getString("date_reservation"));
                m.setId_esp(rs.getInt("id_esp"));
                m.setNum_card(rs.getInt("num_card"));
                m.setType(rs.getBoolean("type"));
                m.setUser(rs.getInt("user"));
                
                list.add(m);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public List<Reservation> afficheMonum(int id){
        List <Reservation> list = new ArrayList<>();
        try {
            String req="select * from reservation where type=false and user="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Reservation m = new Reservation();
                m.setId(rs.getInt("id"));
                m.setCard_password(rs.getString("card_password"));
                m.setDate_reservation(rs.getString("date_reservation"));
                m.setId_esp(rs.getInt("id_esp"));
                m.setNum_card(rs.getInt("num_card"));
                m.setType(rs.getBoolean("type"));
                m.setUser(rs.getInt("user"));
                
                list.add(m);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Reservation getReservById(int id){
        Reservation m = new Reservation();
        try {
            String req="select * from reservation where id="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                m.setId(rs.getInt("id"));
                m.setCard_password(rs.getString("card_password"));
                m.setDate_reservation(rs.getString("date_reservation"));
                m.setId_esp(rs.getInt("id_esp"));
                m.setNum_card(rs.getInt("num_card"));
                m.setType(rs.getBoolean("type"));
                m.setUser(rs.getInt("user"));
                
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
}
