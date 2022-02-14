/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author boukr
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
import entities.Hotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author PC
 */
public class ServiceHotel implements IService<Hotel> {

    MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();
          
    
    @Override
   public ArrayList<Hotel> affiche() {
     

      ArrayList<Hotel>  list = new ArrayList();
       try {
                  String req ="Select * FROM hotels";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                       Hotel h = new Hotel();
                         h.setId_hotel(rs.getInt("id_hotel"));
                         h.setNom_hotel(rs.getString("nom_hotel"));
                         h.setLocalisation(rs.getString("localisation"));
                         h.setCategorie(rs.getString("categorie"));
                         h.setAvis_hotel(rs.getInt("avis_hotel"));
                         h.setImage_hotel(rs.getString("image_hotel"));

                         list.add(h);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Hotel");

        }   
     return list;    
    }

          @Override

    public void ajout(Hotel h) {
        try {
            String req = "INSERT INTO `hotels`(`nom_hotel`,`localisation`,`categorie`,`avis_hotel`,`image_hotel`) VALUES ('" + h.getNom_hotel() + "','" + h.getLocalisation() + 
                    "','" + h.getCategorie() + "','" + h.getAvis_hotel() + "','" + h.getImage_hotel() +"')";
                //        System.out.println(h);

 
                Statement sm = connection.createStatement();
                sm.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in inserting Hotel");

            }
            
        }
    
   
           @Override

    
    public void supprime(int id ) {
        try {
            String req = "DELETE FROM hotels WHERE id_hotel = ?" ;
          PreparedStatement ps = connection.prepareStatement(req);
       //   System.out.println(req);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in deleting Hotel");        }
    }
        @Override

    public void modifier(Hotel h) {
        try {
            Statement stm = connection.createStatement();
            String req = "UPDATE `hotels` SET `nom_hotel`='"
                    + h.getNom_hotel() + "',`localisation`='"
                    + h.getLocalisation()  + "',`categorie`='"
                    + h.getCategorie() + "',`avis_hotel`='"
                    + h.getAvis_hotel()+ "',`image_hotel`='"
                    + h.getImage_hotel()+ "' WHERE `id_hotel`='"
                    + h.getId_hotel()  + "'";
          //      System.out.println(req);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            
            System.out.println("Error in updating hotel ");
        }
    }

}

    

