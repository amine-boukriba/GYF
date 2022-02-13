/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Users;
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
                    + "code_postal,date_naissance, id_role)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,t.getNom_user());
            ps.setString(2,t.getPrenom_user());
            ps.setString(3,t.getSexe());
            ps.setInt(4,t.getNumero_tel());
            ps.setString(5,t.getEmail_user());
            ps.setString(6,t.getPays_user());
            ps.setString(7,t.getVille_user());
            ps.setInt(8,t.getCode_postal());
            ps.setDate(9,t.getDate_naissance());
            ps.setInt(10,t.getId_role());
            ps.executeUpdate(); 
            System.out.println("requete executé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    @Override
    public void delete(Users t) {
        
        try {
            String req;
            req = "delete from users where id_user=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,t.getId_user());
            ps.executeUpdate();
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Users t) {
        
        try {
            String req;
            req = "update users set nom_user=?,prenom_user=?,"
                    + "sexe=?,numero_tel=?,email_user=?,pays_user=?,ville_user=?,"
                    + "code_postal=?,date_naissance=?, id_role=? where id_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,t.getNom_user());
            ps.setString(2,t.getPrenom_user());
            ps.setString(3,t.getSexe());
            ps.setInt(4,t.getNumero_tel());
            ps.setString(5,t.getEmail_user());
            ps.setString(6,t.getPays_user());
            ps.setString(7,t.getVille_user());
            ps.setInt(8,t.getCode_postal());
            ps.setDate(9, (Date) t.getDate_naissance());
            ps.setInt(10,t.getId_role());
            ps.setInt(11,t.getId_user());
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Users> read() {
        List <Users> list= new ArrayList<>();
        try {
            String req;
            req = "select * from users";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while (rs.next())
            {
                Users user= new Users();
                user.setId_user(rs.getInt("id_user"));
                user.setNom_user(rs.getString("nom_user"));
                user.setPrenom_user(rs.getString("prenom_user"));
                user.setSexe(rs.getString("sexe"));
                user.setNumero_tel(rs.getInt("numero_tel"));
                user.setEmail_user(rs.getString("email_user"));
                user.setPays_user(rs.getString("pays_user"));
                user.setVille_user(rs.getString("ville_user"));
                user.setDate_naissance(rs.getDate("date_naissance"));
                user.setCode_postal(rs.getInt("code_postal"));
                user.setId_role(rs.getInt("id_role"));
                list.add(user);
                
            
            }
                   //* throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
  

    
   
