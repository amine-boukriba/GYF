/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.status;
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
 * @author ASUS
 */
public class ServiceStatus implements IService<status> {
Connection cnx;

    public ServiceStatus() {
        cnx = MyDB.getInstance().getConnection();
    }   

    @Override
    public void ajout(status t) {
        try {
        String req = "insert into status (nom_status,id_reclamation,message) "
                + "values"+"('"+ t.getNom_status()+"',"+t.getId_reclamation()+",'"+t.getMessage()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("ajout avec succées");
    } catch (SQLException ex) {
        Logger.getLogger(ServiceStatus.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void modifier(status t) {
        try {
        String req ="update status set nom_status= ? where id_Status= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getNom_status());
        ps.setInt(2,t.getId_status());
        ps.executeUpdate();
        System.out.println("modification avec succées");
    } catch (SQLException ex) {
        Logger.getLogger(ServiceStatus.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public void supprime(int id) {
        try {
        String req ="delete from status where id_status=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("supprission avec succées");
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public List<status> affiche() {
        List<status> list =new ArrayList<>();
        try{
            String req ="select * from status where id_status=";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            System.out.println("voici la liste des status");
    while(rs.next()){
        status s =new status();
        s.setId_status(rs.getInt(1));
        s.setNom_status(rs.getString("nom_status"));
        s.setId_reclamation(rs.getInt("id_reclamation"));
        s.setMessage(rs.getString("message"));
         list.add(s); 
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
   }
    
    public List<status> affichestatus(int id) {
        List<status> list =new ArrayList<>();
        try{
            String req ="select * from status where id_reclamation="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            System.out.println("voici la liste des status");
    while(rs.next()){
        status s =new status();
        s.setId_status(rs.getInt(1));
        s.setNom_status(rs.getString("nom_status"));
        s.setId_reclamation(rs.getInt("id_reclamation"));
        s.setMessage(rs.getString("message"));
         list.add(s); 
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
   }
  
}
