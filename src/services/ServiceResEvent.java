/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Evenement;
import entities.ResEvents;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author moham
 */
public class ServiceResEvent implements IService<ResEvents> {
    Connection cnx;
     public ServiceResEvent() {
        cnx = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajout(ResEvents t) {
         Statement st; 
  

        try {
           String req = "insert into reservation_evenement(payment_event,id_user,id_evenement,date_expiration) values"+" ('"+ t.getPayment_event() +"','"+ t.getId_user() +"','"+ t.getId_evenement() +"','"+ t.getDate_expiration() +"')";
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        }
    

    @Override
    public void modifier(ResEvents t) {
        try {
          String req = "update reservation_evenement set payment_event = ?, id_user = ?, id_evenement = ? ,date_expiration = ? where id_res_event = ? ";
          PreparedStatement ps= cnx.prepareStatement(req);
          ps.setInt(1,t.getPayment_event());
        ps.setInt(2,t.getId_user());
        ps.setInt(3,t.getId_evenement());
        ps.setDate(4,t.getDate_expiration());
        ps.setInt(5,t.getId_re_event());
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    public void supprime(int id_res_event) {
        try {
            String req ="delete from reservation_evenement where id_res_event=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,id_res_event);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<ResEvents> affiche() {
         List<ResEvents> list= new ArrayList<>();
        try {
           
            String req ="select * from reservation_evenement";
            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ResEvents E =new ResEvents();
                E.setId_re_event(rs.getInt("id_res_event"));
                E.setPayment_event(rs.getInt("payment_event"));
                E.setId_user(rs.getInt("id_user"));
                E.setId_evenement(rs.getInt("id_evenement"));
                E.setDate_expiration(rs.getDate("date_expiration"));
                list.add(E);
               }  
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
 }

   
}
