
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
    public void ajouter(Monuments t) {
        try {
            String req="insert into monuments(id_monument,nom_monument,image_monument,payant,prix,description,date_creation,pays,localisation,avis_monument) values "
                    +"('"+t.getId_monument()+"','"+t.getNom_monument()+"','"+t.getImage_monument()+"','"+t.getPayant()+"','"+t.getPrix()+"','"+t.getDescription()+"','"+t.getDate_creation()+"','"+t.getPays()+"','"+t.getLocalisation()+"','"+t.getAvis_monument()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
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
            ps.setInt(3, t.getPayant());
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

    
    public void supprimer(int id) {
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
    public List<Monuments> afficher() {
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
                m.setPayant(rs.getInt("payant"));
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

    @Override
    public void supprimer(Monuments t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

   
    
}
