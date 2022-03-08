/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Plan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author anwer
 */
public class ServicePlan implements IService<Plan>{
    
    Connection connection;

    public ServicePlan() {
        connection = MyDB.getInstance().getConnection();
    }
    
    

    @Override
    public void ajout(Plan t) {
        try {
            String req = "insert into plan (depart,destination,date_debut,date_fin,prix,id_user) values (?,?,?,?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setString(1, t.getDepart());
            ps.setString(2, t.getDestination());
            ps.setDate(3, t.getDate_debut());
            ps.setDate(4, t.getDate_fin());
            ps.setFloat(5, t.getPrix());
            ps.setInt(6, t.getId_user());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Plan t) {
        try {
            String req = "update plan set depart=?, destination = ? ,date_debut=? , date_fin=? ,prix= ? ,id_user=? where id_plan =?";
            
            PreparedStatement ps =connection.prepareStatement(req);
            
            ps.setString(1, t.getDepart());
            ps.setString(2, t.getDestination());
            ps.setDate(3, t.getDate_debut());
            ps.setDate(4, t.getDate_fin());
            ps.setFloat(5, t.getPrix());
            ps.setInt(6, t.getId_user());
            ps.setInt(7, t.getId_plan());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprime(int id) {
        try {
            String req = "delete from plan where id_plan =?";
            
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Plan> affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public int getLast(){
        int id=0;
        try {
            String req ="select max(id_plan) from plan";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            rs.next();
            
            id=rs.getInt(1);
            System.out.println(id);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePaymentPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
