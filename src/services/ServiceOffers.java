/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Offers;
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
public class ServiceOffers implements IService<Offers>{

    Connection connection ;

    public ServiceOffers() {
        connection = MyDB.getInstance().getConnection();
    }
    
            
            
    @Override
    public void ajout(Offers t) {
        try {
            String req = "insert into offers (titre,depart,destination,date_depart,date_arrive,nombre_nuits,description,prix,image_offer, "
                    + "avis_offer,id_vol,id_hotel,id_restaurant,id_monument,id_evenement,id_espace)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setInt(6, t.getNombre_nuits());
            ps.setString(7,t.getDescription());
            ps.setFloat(8, t.getPrix());
            ps.setString(9, t.getImage_offer());
            ps.setInt(10, t.getAvis_offer());
            ps.setInt(11, t.getId_vol());
            ps.setInt(12, t.getId_hotel());
            ps.setInt(13, t.getId_restaurant());
            ps.setInt(14, t.getId_monument());
            ps.setInt(15, t.getId_evenement());
            ps.setInt(16, t.getId_espace());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Offers t) {
        try {
            String req = "update offers set titre = ?,depart = ?,destination = ?,date_depart = ?,date_arrive = ?,nombre_nuits = ?,description = ?,prix = ?,image_offer = ?, "
                    + "avis_offer = ?,id_vol = ?,id_hotel = ?,id_restaurant = ?,id_monument = ?,id_evenement = ?,id_espace = ? where id_offer = ?";
            
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setInt(6, t.getNombre_nuits());
            ps.setString(7,t.getDescription());
            ps.setFloat(8, t.getPrix());
            ps.setString(9, t.getImage_offer());
            ps.setInt(10, t.getAvis_offer());
            ps.setInt(11, t.getId_vol());
            ps.setInt(12, t.getId_hotel());
            ps.setInt(13, t.getId_restaurant());
            ps.setInt(14, t.getId_monument());
            ps.setInt(15, t.getId_evenement());
            ps.setInt(16, t.getId_espace());
            ps.setInt(17, t.getId_offer());
            
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
            String req ="select * from offers";
            
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                list.add(new Offers(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getInt(7),rs.getString(8),
                rs.getFloat(9),rs.getString(10),rs.getInt(11),rs.getInt(12),rs.getInt(13),rs.getInt(14),rs.getInt(15),rs.getInt(16),rs.getInt(17)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
}
