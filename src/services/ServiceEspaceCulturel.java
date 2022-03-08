/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Espace_culturels;
import entities.Monuments;

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
public class ServiceEspaceCulturel implements IService <Espace_culturels> {

     Connection cnx;
    
    public ServiceEspaceCulturel(){
        cnx= MyDB.getInstance().getConnection();
    }

    @Override
    public void ajout(Espace_culturels t) {
        try {
            String req="insert into espace_culturels(id_espace,nom_espace,image_espace,horaire,prix,paye,date_creation,pays,localisation,description,avis_espace) values (?,?,?,?,?,?,?,?,?,?,?)";
                   
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, t.getId_espace());
            ps.setString(2, t.getNom_espace());
            ps.setString(3, t.getImage_espace());
            ps.setString(4, t.getHoraire());
            ps.setInt(5, t.getPrix());
            ps.setBoolean(6, t.getPaye());
            ps.setString(7, t.getDate_creation());
            ps.setString(8, t.getPays());
            ps.setString(9, t.getLocalisation());
            ps.setString(10, t.getDescription());
            ps.setInt(11,t.getAvis_espace());
           
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Espace_culturels t) {
        try {
            String req="update espace_culturels set nom_espace= ? ,image_espace= ? ,horaire= ? ,prix= ? ,paye= ? ,date_creation= ? ,pays= ? ,localisation= ? ,description = ? ,avis_espace= ? where id_espace= ? ";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, t.getNom_espace());
            ps.setString(2, t.getImage_espace());
            ps.setString(3, t.getHoraire());
            ps.setInt(4, t.getPrix());
            ps.setBoolean(5, t.getPaye());
            ps.setString(6, t.getDate_creation());
            ps.setString(7, t.getPays());
            ps.setString(8, t.getLocalisation());
            ps.setString(9, t.getDescription());
            ps.setInt(10,t.getAvis_espace());
            ps.setInt(11, t.getId_espace());
           
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void supprime(int id) {
        try {
            String req="delete from espace_culturels where id_espace=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Espace_culturels> affiche() {
        List <Espace_culturels> list = new ArrayList<>();
        try {
            String req="select * from espace_culturels";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Espace_culturels e = new Espace_culturels();
                e.setId_espace(rs.getInt("id_espace"));
                e.setNom_espace(rs.getString("nom_espace"));
                e.setImage_espace(rs.getString("image_espace"));
                e.setHoraire(rs.getString("horaire"));
                e.setPrix(rs.getInt("prix"));
                e.setPaye(rs.getBoolean("paye"));
                e.setDate_creation(rs.getString("date_creation"));
                e.setPays(rs.getString("pays"));
                e.setLocalisation(rs.getString("localisation"));
                e.setDescription(rs.getString("description"));
                e.setAvis_espace(rs.getInt("avis_espace"));
                
                list.add(e);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Espace_culturels>  rechercherParNom(String nom_espace){
        List<Espace_culturels> list2 =new ArrayList<>();
        try{
            String req ="select * from espace_culturels where nom_espace = '"+nom_espace+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            while(rs.next()){
              Espace_culturels e =new Espace_culturels();
                e.setId_espace(rs.getInt("id_espace"));
                e.setNom_espace(rs.getString("nom_espace"));
                e.setImage_espace(rs.getString("image_espace"));
                e.setHoraire(rs.getString("horaire"));
                e.setPrix(rs.getInt("prix"));
                e.setPaye(rs.getBoolean("paye"));
                e.setDate_creation(rs.getString("date_creation"));
                e.setPays(rs.getString("pays"));
                e.setLocalisation(rs.getString("localisation"));
                e.setDescription(rs.getString("description"));
                e.setAvis_espace(rs.getInt("avis_espace"));
                
                
       list2.add(e);
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list2;
    }
    


    public List<Espace_culturels> getEspace_culturelsById(int id) {
        Espace_culturels est = new Espace_culturels();
        List<Espace_culturels> list = new ArrayList<>();
        try {
            String req="select * from espace_culturels where id_espace="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                
                est.setId_espace(rs.getInt("id_espace"));
                est.setNom_espace(rs.getString("nom_espace"));
                est.setImage_espace(rs.getString("image_espace"));
                est.setHoraire(rs.getString("horaire"));
                est.setPrix(rs.getInt("prix"));
                est.setPaye(rs.getBoolean("paye"));
                est.setDate_creation(rs.getString("date_creation"));
                est.setPays(rs.getString("pays"));
                est.setLocalisation(rs.getString("localisation"));
                est.setDescription(rs.getString("description"));
                est.setAvis_espace(rs.getInt("avis_espace"));
                list.add(est);

                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEspaceCulturel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    }
