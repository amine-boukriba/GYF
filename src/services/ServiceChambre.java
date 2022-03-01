 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Chambre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author omarb
 */
public class ServiceChambre implements IService<Chambre> {
    
        MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();
          
    
    @Override
   public ArrayList<Chambre> affiche() {
     

      ArrayList<Chambre>  list = new ArrayList();
       try {
                  String req ="Select * FROM chambre";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                       Chambre c = new Chambre();
                         c.setId_chambre(rs.getInt("id_chambre"));
                         c.setType_chambre(rs.getString("type_chambre"));
                         c.setPrix_chambre(rs.getInt("prix_chambre"));
                         c.setId_hotel(rs.getInt("id_hotel"));
                 
                         list.add(c);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Chambre");

        }   
     return list;    
    }
   
    //////////////////////////////////////////////////////////////////////////////////////////

 // @Override
   public ArrayList<Chambre> afficheavecnom_hotel() {
     

      ArrayList<Chambre>  list = new ArrayList();
       try {
                  String req ="select id_chambre,prix_chambre , type_chambre,nom_hotel from chambre join hotels using (id_hotel) where etat = 'disponible'  ";

               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                       Chambre c = new Chambre();
                        c.setId_chambre(rs.getInt("id_chambre"));
                         c.setType_chambre(rs.getString("type_chambre"));
                         c.setPrix_chambre(rs.getInt("prix_chambre"));
                          c.setNom_hotel(rs.getString("nom_hotel"));
                         list.add(c);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Chambre");

        }   
     return list;    
    }

   
    //////////////////////////////////////////////////////////////////////////////////////////

  // @Override
   public ArrayList<Chambre> affichePrix_chambreHotel(String nom_hotel) {
     

      ArrayList<Chambre>  list = new ArrayList();
       try {
                  String req ="select * from chambre join hotels using (id_hotel) where nom_hotel ='"+nom_hotel+"'  and etat = 'disponible' ORDER by prix_chambre desc ";
               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                       Chambre c = new Chambre();
                         c.setId_chambre(rs.getInt("id_chambre"));
                         c.setType_chambre(rs.getString("type_chambre"));
                         c.setPrix_chambre(rs.getInt("prix_chambre"));
                         c.setId_hotel(rs.getInt("id_hotel"));
                         c.setEtat(rs.getString("etat"));
                 
                         list.add(c);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Chambre");

        }   
     return list;    
    }

    //////////////////////////////////////////////////////////////////////////////////////////

          @Override

    public void ajout(Chambre c) {
        try {
            String req = "INSERT INTO `chambre`(`type_chambre`,`prix_chambre`,`id_hotel`) VALUES ('" + c.getType_chambre()+ "','" + c.getPrix_chambre()+ 
                    "','" + c.getId_hotel() +"')";
                //        System.out.println(h);

 
                Statement sm = connection.createStatement();
                sm.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in inserting Chambre");

            }
            
        }
   
     //////////////////////////////////////////////////////////////////////////////////////////

           @Override

    
    public void supprime(int id ) {
        try {
            String req = "DELETE FROM chambre WHERE id_chambre = ?" ;
          PreparedStatement ps = connection.prepareStatement(req);
         // System.out.println(req);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in deleting Chambre");        }
    }
    
     //////////////////////////////////////////////////////////////////////////////////////////

    
        @Override

    public void modifier(Chambre c) {
        try {
            Statement stm = connection.createStatement();
            String req = "UPDATE `chambre` SET `type_chambre`='"
                    + c.getType_chambre()+ "',`prix_chambre`='"
                    + c.getPrix_chambre()+ "',`id_hotel`='"
                    + c.getId_hotel()+ "' WHERE `id_chambre`='"
                    + c.getId_chambre()+ "'";
            //  System.out.println(req);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            
            System.out.println("Error in updating chambre ");
        }
    }
}
