/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Users;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author boukr
 */
public class ServicesUsers implements IService<Users> {
    Connection cnx;
    
    public ServicesUsers(){
    cnx=MyDB.getInstance().getConnection();
}

    @Override
    public void create(Users t) {
        try {
            String req;
            req = "insert into users(nom_user,prenom_user,"
                    + "sexe,numero_tel,email_user,pays_user,ville_user,"
                    + "code_postal,date_naissance, id_role;)"
                    + "values('"+t.getNom_user()+"','"+t.getPrenom_user()+"','"+t.getSexe()+"','"
                    +t.getNumero_tel()+"','"+t.getEmail_user()+"','"+t.getPays_user()+"'"+t.getVille_user()+"','"
                    +t.getCode_postal()+"','"+t.getDate_naissance()+"','"+t.getId_role()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(req);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    
    

    @Override
    public void delete(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> read(Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
  

    
   
