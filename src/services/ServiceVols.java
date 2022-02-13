/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Vols;
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
public class ServiceVols implements IService<Vols>{
    
    Connection connection;

    public ServiceVols() {
        connection = MyDB.getInstance().getConnection();
    }
    
    

    @Override
    public void ajout(Vols t) {
        try {
            String req ="insert into vols (compagnie_aerien,depart,destination,date_depart,date_arrive,prix,duree,type_avion,image_vol,avis_vol)"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1,t.getCompagnie_aerien());
            ps.setString(2, t.getDepart());
            ps.setString(3,t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setFloat(6, t.getPrix());
            ps.setInt(7, t.getDuree());
            ps.setString(8, t.getType_avion());
            ps.setString(9, t.getImage_vol());
            ps.setInt(10, t.getAvis_vol());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Vols t) {
        try {
            String req ="update vols set compagnie_aerien =?,depart = ?,destination = ?,date_depart = ?,date_arrive = ?"
                    + ",prix = ?,duree = ?,type_avion = ?,image_vol =?,avis_vol = ? where id_vol = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, t.getCompagnie_aerien());
            ps.setString(2, t.getDepart());
            ps.setString(3, t.getDestination());
            ps.setDate(4, t.getDate_depart());
            ps.setDate(5, t.getDate_arrive());
            ps.setFloat(6, t.getPrix());
            ps.setInt(7, t.getDuree());
            ps.setString(8, t.getType_avion());
            ps.setString(9, t.getImage_vol());
            ps.setInt(10, t.getAvis_vol());
            ps.setInt(11, t.getId_vol());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprime(int id) {
        try {
            String req ="delete from vols where id_vol = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vols> affiche() {
        
        List<Vols> list =new ArrayList<>();
        try {
            String req = "select * from vols";
            Statement ps = connection.createStatement();
            
            ResultSet rs =  ps.executeQuery(req);
            
            while(rs.next()){
                Vols vol= new Vols();
                vol.setId_vol(rs.getInt(1));
                vol.setCompagnie_aerien(rs.getString("compagnie_aerien"));
                vol.setDepart(rs.getString("depart"));
                vol.setDestination(rs.getString("destination"));
                vol.setDate_depart(rs.getDate("date_depart"));
                vol.setDate_arrive(rs.getDate("date_arrive"));
                vol.setPrix(rs.getFloat("prix"));
                vol.setDuree(rs.getInt("duree"));
                vol.setType_avion(rs.getString("type_avion"));
                vol.setImage_vol(rs.getString("image_vol"));
                vol.setAvis_vol(rs.getInt("avis_vol"));
                list.add(vol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
