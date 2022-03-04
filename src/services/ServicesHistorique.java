/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Historiques;
import entities.Roles;
import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author boukr
 */
public class ServicesHistorique {
      Connection cnx;
    public ServicesHistorique(){
    cnx=MyDB.getInstance().getConnection();  }
    public void add_session(Historiques h){
        LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    h.setEntre_date(formattedDate);
    
    }
    public void calcul_duration(Historiques h){
    
    
          try {
              SimpleDateFormat sdf
                      = new SimpleDateFormat(
                              "dd-MM-yyyy HH:mm:ss");
              
              // parse method is used to parse
              // the text from a string to
              // produce the date
              Date d1 = sdf.parse(h.getEntre_date());
              Date d2 = sdf.parse(h.getSortie_date());
              
              // Calucalte time difference
              // in milliseconds
              long difference_In_Time
                      = d2.getTime() - d1.getTime();
              
              // Calucalte time difference in
              // seconds, minutes, hours, years,
              // and days
              long difference_In_Seconds
                      = (difference_In_Time
                      / 1000)
                      % 60; 
              h.setDuree(difference_In_Seconds);
          } catch (ParseException ex) {
              Logger.getLogger(ServicesHistorique.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  
    public void exit_session(Historiques h,Users user){
            LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    h.setSortie_date(formattedDate);
    calcul_duration(h);
    try {
            String req;
            req = "insert into historique(entre_date,sortie_date,duree,id_user)values(?,?,?,?)";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,h.getEntre_date());
            ps.setString(2,h.getSortie_date());
            ps.setLong(3,h.getDuree());
            ps.setInt(4,user.getId_user());
            ps.executeUpdate(); 
            System.out.println("requete executé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public HashMap<Historiques,Users> filter_historiques(String value){
        HashMap<Historiques,Users> map= new HashMap<>();
        try {
            String req;
            req = "select * from historique INNER JOIN users ON users.id_user  = historique.id_user  where concat(nom_user,prenom_user,email_user) like '%"+value+"%'";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);   
            while (rs.next())
            {
                Historiques h=new Historiques();
                Users user= new Users();
                user.setNom_user(rs.getString("nom_user"));
                user.setPrenom_user(rs.getString("prenom_user"));
                user.setEmail_user(rs.getString("email_user"));
                h.setDuree(rs.getInt("duree"));
                h.setEntre_date(rs.getString("entre_date"));
                h.setSortie_date(rs.getString("sortie_date"));
                map.put(h,user);
            }
                   //* throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
};
    
}
