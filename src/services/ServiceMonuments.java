
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


public class ServiceMonuments implements IService<Monuments> {

     Connection cnx;
    
    public ServiceMonuments(){
        cnx= MyDB.getInstance().getConnection();
    }

    @Override
    public void ajout(Monuments t) {
        try {
            String req="insert into monuments(nom_monument,image_monument,payant,prix,description,date_creation,pays,localisation,avis_monument) values (?,?,?,?,?,?,?,?,?)";
                  
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getNom_monument());
            ps.setString(2, t.getImage_monument());
            ps.setBoolean(3, t.getPayant());
            ps.setInt(4, t.getPrix());
            ps.setString(5, t.getDescription());
            ps.setString(6, t.getDate_creation());
            ps.setString(7, t.getPays());
            ps.setString(8, t.getLocalisation());
            ps.setInt(9,t.getAvis_monument());
           
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void modifier(Monuments t) {
        try {
            String req="update monuments set nom_monument= ? ,image_monument= ? ,payant= ? ,prix= ? ,description= ? ,date_creation= ? ,pays= ? ,localisation= ? ,avis_monument= ? where id_monument= ? ";
            PreparedStatement ps= cnx.prepareStatement(req);
            ps.setString(1, t.getNom_monument());
            ps.setString(2, t.getImage_monument());
            ps.setBoolean(3, t.getPayant());
            ps.setInt(4, t.getPrix());
            ps.setString(5, t.getDescription());
            ps.setString(6, t.getDate_creation());
            ps.setString(7, t.getPays());
            ps.setString(8, t.getLocalisation());
            ps.setInt(9,t.getAvis_monument());
            ps.setInt(10, t.getId_monument());
           
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void supprime(int id) {
        try {
            String req="delete from monuments where id_monument=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Monuments> affiche() {
        List <Monuments> list = new ArrayList<>();
        try {
            String req="select * from monuments";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                Monuments m = new Monuments();
                m.setId_monument(rs.getInt("id_monument"));
                m.setNom_monument(rs.getString("nom_monument"));
                m.setImage_monument(rs.getString("image_monument"));
                m.setPayant(rs.getBoolean("payant"));
                m.setPrix(rs.getInt("prix"));
                m.setDescription(rs.getString("description"));
                m.setDate_creation(rs.getString("date_creation"));
                m.setPays(rs.getString("pays"));
                m.setLocalisation(rs.getString("localisation"));
                m.setAvis_monument(rs.getInt("avis_monument"));
                
                list.add(m);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
     public List<Monuments>  rechercherParNom(String nom_monument){
        List<Monuments> list1 =new ArrayList<>();
        try{
            String req ="select * from monuments where nom_monument = '"+nom_monument+"'";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            while(rs.next()){
              Monuments m =new Monuments();
                m.setId_monument(rs.getInt("id_monument"));
                m.setNom_monument(rs.getString("nom_monument"));
                m.setImage_monument(rs.getString("image_monument"));
                m.setPayant(rs.getBoolean("payant"));
                m.setPrix(rs.getInt("prix"));
                m.setDescription(rs.getString("description"));
                m.setDate_creation(rs.getString("date_creation"));
                m.setPays(rs.getString("pays"));
                m.setLocalisation(rs.getString("localisation"));
                m.setAvis_monument(rs.getInt("avis_monument"));
                
                
       list1.add(m);
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
    }
   return list1;
    }
     public Monuments getMonumentsById(int id){
         Monuments m =new Monuments();
        try{
            String req ="select * from monuments where id_monument="+id+"";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
            while(rs.next()){
              
                m.setId_monument(rs.getInt("id_monument"));
                m.setNom_monument(rs.getString("nom_monument"));
                m.setImage_monument(rs.getString("image_monument"));
                m.setPayant(rs.getBoolean("payant"));
                m.setPrix(rs.getInt("prix"));
                m.setDescription(rs.getString("description"));
                m.setDate_creation(rs.getString("date_creation"));
                m.setPays(rs.getString("pays"));
                m.setLocalisation(rs.getString("localisation"));
                m.setAvis_monument(rs.getInt("avis_monument"));
                
                
       
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceMonuments.class.getName()).log(Level.SEVERE, null, ex);
    }
   return m;
     }
    }

    

   

   

   
    

