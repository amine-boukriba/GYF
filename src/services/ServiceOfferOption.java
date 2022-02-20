/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.OfferOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            
            ps.setInt(2, t.getId_bateau());
            ps.setInt(3, t.getId_espace());
            ps.setInt(4, t.getId_vol());
            ps.setInt(5, t.getId_hotel());
            ps.setInt(6, t.getId_monument());
            ps.setInt(7, t.getId_restaurant());
            ps.setInt(8, t.getId_evenement());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
