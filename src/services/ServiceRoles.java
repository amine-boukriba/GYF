/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Roles;
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
 * @author boukr
 */
public class ServiceRoles implements IService<Roles>{
    Connection cnx;
    public ServiceRoles(){
    cnx=MyDB.getInstance().getConnection();
    }
    @Override
    public void ajout(Roles t) {
         try {
            String req;
            req = "insert into roles(role)values(?)";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,t.getLabel());
            ps.executeUpdate(); 
            System.out.println("requete executé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public void supprime(int id) {
         try {
            String req;
            req = "delete from roles where id_role=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,id);
            ps.executeUpdate();
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Roles t) {
        try {
            String req;
            req = "update roles set role=? where id_role=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,t.getLabel());
            ps.setInt(2,t.getIdr());
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Roles> affiche() {
     List <Roles> list= new ArrayList<>();
        try {
            String req;
            req = "select * from roles";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);
            while (rs.next())
            {
                Roles role= new Roles();
                role.setIdr(rs.getInt("id_role"));
                role.setLabel(rs.getString("role"));
                list.add(role);
                
            
            }
                   //* throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    }
    

