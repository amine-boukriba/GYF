/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.avis;
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
public class ServiceAvis implements IServices<avis>{
    Connection cnx;

    public ServiceAvis() {
        cnx = MyDB.getInstance().getConnection();
    }
   public void ajouter(avis t) {
    try {
        String req = "insert into avis (id_avis,nombre_etoile,description,id_user,cible_avis,type_avis) "
                + "values"+"('"+t.getId_avis()+"','"+ t.getNombre_etoile()+"','"+t.getDescription()+"','"+ t.getId_user()+"','"+t.getCible_avis()+"'"
                + ",'"+t.getType_avis()+"')";
        Statement st=cnx.createStatement();
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
 
    }
     public void supprimer(int id) {
      try {
        String req ="delete from avis where id_avis=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void modifier(avis t) {
    try {
        String req ="update avis set nombre_etoile = ?,description = ?,id_user = ?,cible_avis = ?,type_avis = ? where id_avis = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1,t.getNombre_etoile());
        ps.setString(2,t.getDescription());
        ps.setInt(3,t.getId_user());
        ps.setInt(4,t.getCible_avis());
        ps.setInt(5,t.getType_avis());
         ps.setInt(6,t.getId_avis());
       
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     public List<avis> afficher() {
        List<avis> list =new ArrayList<>();
        try{
            String req ="select *from avis";
            Statement st = cnx.createStatement();
            ResultSet rs =st.executeQuery(req);
    while(rs.next()){
        avis a =new avis();
        a.setId_avis(rs.getInt(1));
        a.setNombre_etoile(rs.getInt("nombre_etoile"));
        a.setDescription(rs.getString("description"));
        a.setId_user(rs.getInt("id_user"));
        a.setCible_avis(rs.getInt("cible_avis"));
        a.setType_avis(rs.getInt("type_avis"));
        
          list.add(a); 
    }
        } catch (SQLException ex) {
        Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
    }
}


