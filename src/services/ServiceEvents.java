/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author anwer
 */
import entities.Evenement;
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
public class ServiceEvents implements IService<Evenement> {
    Connection cnx;

    public ServiceEvents() {
        cnx = MyDB.getInstance().getConnection();
    }
    
    @Override
    public void ajout(Evenement t) {
        
      Statement st; 
        try {
                   String req = "insert into evenement(nom_evenement,description,type_evenement,localisation,image_evenement,date_debut,date_fin,pays,nombre_participants,prix) values"+" ('"+ t.getNom() +"','"+ t.getDescription() +"','"+ t.getType() +"','"+ t.getLocalisation() +"','"+ t.getImage() +"','"+ t.getDate_debut() +"','"+ t.getDate_fin() +"','"+t.getPays()+"','"+ t.getNbre_participants() +"','"+ t.getPrix() +"')";

            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void modifier(Evenement t) {
         try { 
        String req = "update evenement set nom_evenement = ?, description = ?, type_evenement = ? ,localisation = ?, image_evenement = ?, date_debut = ? , date_fin= ?,pays = ? ,nombre_participants = ?, prix = ? where id_evenement = ? ";
        PreparedStatement ps= cnx.prepareStatement(req);
        ps.setString(1,t.getNom());
        ps.setString(2,t.getDescription());
        ps.setString(3,t.getType());
        ps.setString(4,t.getLocalisation());
        ps.setString(5,t.getImage());
        ps.setDate(6, t.getDate_debut());
        ps.setDate(7, t.getDate_fin());
        ps.setString(8,t.getPays());
        ps.setInt(9, t.getNbre_participants());
        ps.setInt(10, t.getPrix());
        ps.setInt(11,t.getId_event());
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
   public void supprime(int id) {
      try {
        String req ="delete from evenement where id_evenement = ?";
        
        PreparedStatement ps = cnx.prepareStatement(req);
        
                System.out.println(ps);

        ps.setInt(1, id);
                        System.out.println(ps);

        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evenement> affiche() {
         List<Evenement> list= new ArrayList<>();
        try {
            String req ="select * from evenement";
            Statement st;
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Evenement E =new Evenement();
                E.setId_event(rs.getInt("id_evenement"));
                E.setNom(rs.getString("nom_evenement"));
                E.setDescription(rs.getString("description"));
                E.setType(rs.getString("type_evenement"));
                E.setLocalisation(rs.getString("localisation"));
                E.setImage(rs.getString("image_evenement"));
                E.setDate_debut(rs.getDate("date_debut"));
                E.setDate_fin(rs.getDate("date_fin"));
                E.setPays(rs.getString("pays"));
                E.setNbre_participants(rs.getInt("nombre_participants"));
                E.setPrix(rs.getInt("prix"));
                list.add(E);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
       
    }
    public List<Evenement> getById(int id ){
        List<Evenement> list = new ArrayList<>();
        try {
            String req = "select * from evenement where id_evenement="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                 Evenement E =new Evenement();
                E.setId_event(rs.getInt("id_evenement"));
                E.setNom(rs.getString("nom_evenement"));
                E.setDescription(rs.getString("description"));
                E.setType(rs.getString("type_evenement"));
                E.setLocalisation(rs.getString("localisation"));
                E.setImage(rs.getString("image_evenement"));
                E.setDate_debut(rs.getDate("date_debut"));
                E.setDate_fin(rs.getDate("date_fin"));
                E.setPays(rs.getString("pays"));
                E.setNbre_participants(rs.getInt("nombre_participants"));
                E.setPrix(rs.getInt("prix"));
                list.add(E);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
   
}
