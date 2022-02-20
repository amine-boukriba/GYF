/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Images;
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
public class ServiceImages implements IService<Images>{
    
    Connection connection;
    
    public ServiceImages() {
        connection = MyDB.getInstance().getConnection();
    }

    @Override
    public void ajout(Images t) {
        try {
            String req = "insert into images (path,id_espace_culturels,id_evenement,id_hotel,id_monument,id_offer,id_restaurant) values (?,?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, t.getPath());
            ps.setInt(2, t.getId_espace_culturels());
            ps.setInt(3, t.getId_evenement());
            ps.setInt(4, t.getId_hotel());
            ps.setInt(5, t.getId_monument());
            ps.setInt(6, t.getId_offer());
            ps.setInt(7, t.getId_restaurant());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Images t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Images> affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
