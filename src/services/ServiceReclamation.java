/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reclamation;
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
 * @author ASUS
 */
public class ServiceReclamation implements IService<reclamation>{
    
 Connection cnx;

    public ServiceReclamation() {
        cnx = MyDB.getInstance().getConnection();
    }   
   
 @Override
    public void ajout(reclamation t) {
    try {
        String req = "insert into reclamation (id_reclamation,description,nom,prenom,email,date_creation,date_traitement,status,image_reclamation,cible_reclamation,type_reclamation,id_user) "
                + "values"+"('"+t.getId_reclamation()+"','"+ t.getDescription()+"','"+ t.getNom()+"','"+ t.getPrenom()+"','"+ t.getEmail()+"','"+t.getDate_creation()+"','"+ t.getDate_traitement()+"','"+t.getStatus()+"'"
                + ",'"+t.getImage_reclamation()+"','"+ t.getCible_reclamation()+"','"+t.getType_reclamation()+"','"+t.getId_user()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
 
    }
 @Override
     public void supprime(int id) {
      try {
        String req ="delete from Reclamation where id_reclamation=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
 @Override
    public void modifier(reclamation t) {
    try {
        String req ="update reclamation set description= ?,date_creation= ?,date_traitement= ?,status= ?,image_reclamation= ?,cible_reclamation= ?,type_reclamation= ?,id_user= ? where id_reclamation= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,t.getDescription());
        ps.setString(2,t.getDate_creation());
        ps.setString(3, t.getDate_traitement());
        ps.setString(4,t.getStatus());
        ps.setString(5,t.getImage_reclamation());
        ps.setInt(6,t.getCible_reclamation());
        ps.setString(7,t.getType_reclamation());
        ps.setInt(8,t.getId_user());
        ps.setInt(9,t.getId_reclamation());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @Override
     public List<reclamation> affiche() {
        List<reclamation> list =new ArrayList<>();
        try{
            String req ="select * from reclamation";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        reclamation r =new reclamation();
        r.setId_reclamation(rs.getInt(1));
        r.setDescription(rs.getString("description"));
        r.setNom(rs.getString("nom"));
        r.setPrenom(rs.getString("prenom"));
        r.setEmail(rs.getString("email")); 
        r.setDate_creation(rs.getString("date_creation"));
        r.setDate_traitement(rs.getString("date_traitement"));
        r.setStatus(rs.getString("status"));
        r.setImage_reclamation(rs.getString("image_reclamation"));
        r.setCible_reclamation(rs.getInt("cible_reclamation"));
        r.setType_reclamation(rs.getString("type_reclamation"));
        r.setId_user(rs.getInt("id_user"));
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }


    
 
    public List<reclamation> rechercher_parchoix(String type, String valeur) {
        List<reclamation> List = new ArrayList<>();
        String requete = null;
        try { 
            
             if (type.equals("Description")) {
                requete = "SELECT * from reclamation where description like '%" + valeur + "%'";
            } else if (type.equals("Status")) {
                requete = "SELECT * from reclamation where status ='" + valeur + "'"; 
            } else if (type.equals("Tout")) {
                requete = "SELECT * from Reclamation where status like '%" + valeur + "%'or description like '%" + valeur + "%'"; 
            }
             else if (type.equals("Nom")) {
                requete = "SELECT * from reclamation where nom ='" + valeur + "'";
                
             }else if (type.equals("Prenom")) {
                requete = "SELECT * from reclamation where Prenom ='" + valeur + "'";}
             else if (type.equals("email")) {
                requete = "SELECT * from reclamation where email ='" + valeur + "'";}
  Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                 reclamation r =new reclamation();
       r.setId_reclamation(rs.getInt(1));
        r.setDescription(rs.getString("description"));
        r.setNom(rs.getString("nom"));
        r.setPrenom(rs.getString("prenom"));
        r.setEmail(rs.getString("email"));
        r.setDate_creation(rs.getString("date_creation"));
        r.setDate_traitement(rs.getString("date_traitement"));
        r.setStatus(rs.getString("status"));
        r.setImage_reclamation(rs.getString("image_reclamation"));
         List.add(r);
         
            }
            } 
        catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
            }
        return List;
}
    public List<reclamation> afficheById(int id) {
        List<reclamation> list =new ArrayList<>();
        try{
            String req ="select * from reclamation where id_user="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        reclamation r =new reclamation();
        r.setId_reclamation(rs.getInt(1));
        r.setDescription(rs.getString("description"));
        r.setNom(rs.getString("nom"));
        r.setPrenom(rs.getString("prenom"));
        r.setEmail(rs.getString("email")); 
        r.setDate_creation(rs.getString("date_creation"));
        r.setDate_traitement(rs.getString("date_traitement"));
        r.setStatus(rs.getString("status"));
        r.setImage_reclamation(rs.getString("image_reclamation"));
        r.setCible_reclamation(rs.getInt("cible_reclamation"));
        r.setType_reclamation(rs.getString("type_reclamation"));
        r.setId_user(rs.getInt("id_user"));
        
          list.add(r); 
          System.out.println("h");
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
    public void repondre(reclamation t) {
    try {
        String req ="update reclamation set date_traitement= ?, status= ? where id_reclamation= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getDate_traitement());
        ps.setString(2,t.getStatus());
        ps.setInt(3, t.getId_reclamation());
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
