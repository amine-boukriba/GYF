/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Historiques;
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
import utils.RandomString;
import utils.SendEmail;

public class ServicesUsers implements IService<Users> {
    Connection cnx;
    
    public ServicesUsers(){
    cnx=MyDB.getInstance().getConnection();
}

    @Override
    public void ajout(Users t) {
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
    public void supprime(int id) {
        
        try {
            String req;
            req = "delete from users where id_user=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,id);
            ps.executeUpdate();
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Users t) {
        
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
    public List<Users> affiche() {
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
    public List<Users> filter_users(){
        
        
        
        return null;
};
    public String send_verification_code(String utility){
     RandomString rs= new RandomString();
     String code;
        code = rs.getAlphaNumericString(5);
        SendEmail mailer=new SendEmail();
        mailer.email_sending("hello this is your" + utility + "code: " + code,utility);
     return code;
      }
    public boolean verification_user(Users user,String verification_code_user){
        if (compare_code(verification_code_user,"verification")){
        user.setVerification(true);
         modifier(user);
         return true;
        }
        else{return false;}
    }
    public int sign_in(Users user) throws SQLException{
            String login=user.getEmail_user();
            String  password=user.getPassword();
            String req;
            req = "SELECT password FROM users WHERE email_user  ='"+login+"'";
            Statement st=cnx.createStatement();
            ResultSet resultat = st.executeQuery(req);
            
            if(resultat.next()){
                
                
                    String motDePasse = resultat.getString(1);
                    
                    if(motDePasse.equals(password)){
                        
                        return 1; //"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                    }else {
                        
                        return 0;//"Mot de passe incorrect ! ","Error",1);
                    }
        
                }
            else {
                
                return -1;//"Login incorrect ! ","Error",1);
            }
        
    }
      
    
    public void sign_out(Users user,Historiques h){
       ServicesHistorique histo=new ServicesHistorique();
       histo.exit_session(h);
        
    };
    public boolean compare_code(String verification_code_user,String utility){
        String verification_code;
        verification_code=send_verification_code(utility);
        return verification_code.equals(verification_code_user);
    }
     public void  reset_password(String password){
        try {
            String req;
            req = "update users set password=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,password);
            ps.executeUpdate();
            System.out.println("requete executé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
  

    
   
