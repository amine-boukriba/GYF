/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.OfferOption;
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
public class ServiceOfferOption implements IService<OfferOption>{

    Connection connection;
    
    public ServiceOfferOption() {
        connection = MyDB.getInstance().getConnection();
    }
    
    @Override
    public void ajout(OfferOption t) {
        try {
            String req = "insert into offer_option (id_offer,id_bateau,id_espace,id_vol,id_hotel,id_monument,id_restaurant,id_evenement,id_plan) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            if(t.getId_offer() == 0){
                ps.setNull(1, 0);
            }else{
                ps.setInt(1, t.getId_offer());
            }
            if(t.getId_bateau() ==0){
                ps.setNull(2, 0);
            }else{
                ps.setInt(2, t.getId_bateau());
            }
            if(t.getId_espace()==0){
                ps.setNull(3, 0);
            }else{
                ps.setInt(3, t.getId_espace());
            }
            if(t.getId_vol()==0){
                ps.setNull(4, 0);
            }else{
                ps.setInt(4, t.getId_vol());
            }
            if(t.getId_hotel()==0){
                ps.setNull(5, 0);
            }else{
                ps.setInt(5, t.getId_hotel());
            }
            if(t.getId_monument()==0){
                 ps.setNull(6, 0);
            }else{
                ps.setInt(6, t.getId_monument());
            }
            if(t.getId_restaurant()==0){
                 ps.setNull(7, 0);
            }else{
                ps.setInt(7, t.getId_restaurant());
            }
            if(t.getId_evenement()==0){
                 ps.setNull(8, 0);
            }else{
                ps.setInt(8, t.getId_evenement());
            }
            if(t.getId_plan() == 0){
                ps.setNull(9, 0);
            }else{
                ps.setInt(9, t.getId_plan());
            }
            
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(OfferOption t) {
        try {
            String req ="update offer_option set id_bateau =?,id_espace =? ,id_vol =?,id_hotel=?,id_monument =?,id_monument =?,id_evenement =? where id_offer_option =?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, t.getId_bateau());
            ps.setInt(2, t.getId_espace());
            ps.setInt(3, t.getId_vol());
            ps.setInt(4, t.getId_hotel());
            ps.setInt(5, t.getId_monument());
            ps.setInt(6, t.getId_restaurant());
            ps.setInt(7, t.getId_evenement());
            ps.setInt(8, t.getId_offer_option());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprime(int id) {
        
        try {
            String req = "delete from offer_option where id_offer_option ="+id+"";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OfferOption> affiche() {
        List<OfferOption> list = new ArrayList<>();
        try {
            String req = "select * from offer_option";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                list.add(new OfferOption(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);
        return list;
    }
    
}
