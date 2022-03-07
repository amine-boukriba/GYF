/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Historiques;
import entities.Roles;
import entities.Users;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import static utils.Password_hash.getSHA;
import static utils.Password_hash.toHexString;
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
                    + "code_postal,date_naissance, id_role,password,verification,blocked)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(11,t.getPassword());
            ps.setInt(12,t.getVerification());
            ps.setInt(13,t.getBlocked());
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
                    + "code_postal=?,date_naissance=?, id_role=?,password=?,verification =?,blocked=? where id_user=? ";
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
            ps.setString(11,t.getPassword());
            ps.setInt(12,t.getVerification());
            ps.setInt(13,t.getBlocked());
            ps.setInt(14,t.getId_user());
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
            req = "select * from users ";
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
    public HashMap<Roles,Users> filter_users(String value){
        HashMap<Roles,Users> map= new HashMap<>();
        try {
            String req;
            req = "select * from users INNER JOIN roles ON users.id_role = roles.id_role where concat(nom_user,prenom_user,email_user) like '%"+value+"%'";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(req);   
            while (rs.next())
            {
                Roles role=new Roles();
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
                user.setVerification(rs.getInt("verification"));
                user.setBlocked(rs.getInt("blocked"));
                role.setIdr(rs.getInt("id_role"));
                role.setLabel(rs.getString("role"));
                map.put(role,user);
                
            
            }
                   //* throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
};
    public String send_verification_code(String email,String utility){
     RandomString rs= new RandomString();
     String code;
        code = rs.getAlphaNumericString(5);
        SendEmail mailer=new SendEmail();
        mailer.email_sending(email,"Hello, this is your " + utility + " code:     " + code,utility);
     return code;
      }
    public int sign_in(Users user) throws SQLException{
                    System.out.println(user);

            String login=user.getEmail_user();
            String  password=user.getPassword();
            String req;
            req = "SELECT password FROM users WHERE email_user  ='"+login+"'";
            Statement st=cnx.createStatement();
            ResultSet resultat = st.executeQuery(req);
            if(resultat.next()){
                    String motDePasse;
                    motDePasse = resultat.getString(1);   
                    if(motDePasse.equals(password)){
                        
                        return 1; //"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        
                        return 0;//"Mot de passe incorrect ! ","Error",1);
                    }
                
                }
            else {
                
                return -1;//"Login incorrect ! ","Error",1);
            }
        
    }
    public int blocked(Users user){
        int res=1;
        try {
            String login=user.getEmail_user();
            String req;
            req = "SELECT blocked FROM users WHERE email_user  ='"+login+"'";
            Statement st=cnx.createStatement();
            ResultSet resultat = st.executeQuery(req);
            if(resultat.next()){
              res= resultat.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
                  return res;
  
          }
    public int verfied(Users user){
        int res=1;
        try {
            String login=user.getEmail_user();
            String req;
            req = "SELECT verification FROM users WHERE email_user  ='"+login+"'";
            Statement st=cnx.createStatement();
            ResultSet resultat = st.executeQuery(req);
            if(resultat.next()){
              res= resultat.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
                  return res;
  
          }

      
    
    public void sign_out(Users user,Historiques h){
       ServicesHistorique histo=new ServicesHistorique();
       histo.exit_session(h, user);
        
    };
     public void  reset_password(String email,String password){
        try {
            String req;
            req = "update users set password=? where email_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,toHexString(getSHA(password)));
            ps.setString(2,email);

            ps.executeUpdate();
            System.out.println("requete executé");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     public void update_user_information(Users user){
        try {
            String req;
            req = "select * from users where email_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,user.getEmail_user());
            ResultSet rs =ps.executeQuery();
            while (rs.next())
            {
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
                user.setBlocked(rs.getInt("blocked"));
                user.setVerification(rs.getInt("verification"));
                user.setPassword(rs.getString("password"));
              

                
            
            }
                   //* throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public boolean check_user(String email) throws SQLException{
     String req;
            req = "SELECT email_user FROM users WHERE email_user  ='"+email+"'";
            Statement st=cnx.createStatement();
            ResultSet resultat = st.executeQuery(req);
            
        return resultat.next();
     }
      public void modifier_by_email(Users t) {
        
        try {
            String req;
            req = "update users set nom_user=?,prenom_user=?,"
                    + "sexe=?,numero_tel=?,email_user=?,pays_user=?,ville_user=?,"
                    + "code_postal=?,date_naissance=? where email_user=? ";
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
            ps.setString(10,t.getEmail_user());
            System.out.println(req);
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void make_admin(Users user){
          user.setId_role(21);
          try {
            String req;
            req = "update users set id_role=? where email_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,user.getId_role());  
            ps.setString(2,user.getEmail_user());  
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void delete_user(Users user){
           try {
            String req;
            req = "delete from users where email_user=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1,user.getEmail_user());
            ps.executeUpdate();
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public void blockUnblock(Users user)
      {
         if (user.getBlocked()==1)
         {try {
            String req;
            req = "update users set blocked=? where email_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,0);  
            ps.setString(2,user.getEmail_user());  
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
         else
         {
             try {
            String req;
            req = "update users set blocked=? where email_user=? ";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,1);  
            ps.setString(2,user.getEmail_user());  
            ps.executeUpdate();
            System.out.println("requete executé");
            //*throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(ServicesUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
             
         }
          
      }


  

    
   
