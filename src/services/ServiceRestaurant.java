
package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.restaurants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**



 */
public class ServiceRestaurant implements IService<restaurants> {

    MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();
          
    
 
    @Override
   public ArrayList<restaurants> affiche() {
     

      ArrayList<restaurants>  list = new ArrayList();
       try {
                  String req ="Select * FROM restaurants";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                       restaurants r = new restaurants();
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setNom_restaurant(rs.getString("nom_restaurant"));
                         r.setLocalisation(rs.getString("localisation"));
                         r.setHoraire(rs.getString("horaire"));
                         r.setNumero_restaurant(rs.getString("numero_restaurant"));
                         r.setCuisinies(rs.getString("cuisinies"));
                         r.setNombre_fourchet(rs.getInt("nombre_fourchet"));
                         r.setAvis_restaurant(rs.getInt("avis_restaurant"));
                         r.setImage_restaurant(rs.getString("image_restaurant"));

                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting restaurant");

        }   
     return list;    
    }
    //////////////////////////////////////////////////////////////////////////////////////////
  // @Override
   public ArrayList<restaurants> afficheByName(String nom_restaurant) {
     

      ArrayList<restaurants>  list = new ArrayList();
       try {
                  String req ="Select * FROM restaurants WHERE nom_restaurant='"+nom_restaurant+"'"; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                         restaurants r = new restaurants();
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setNom_restaurant(rs.getString("nom_restaurant"));
                         r.setLocalisation(rs.getString("localisation"));
                         r.setHoraire(rs.getString("horaire"));
                         r.setNumero_restaurant(rs.getString("numero_restaurant"));
                         r.setCuisinies(rs.getString("cuisinies"));
                         r.setNombre_fourchet(rs.getInt("nombre_fourchet"));
                         r.setAvis_restaurant(rs.getInt("avis_restaurant"));
                         r.setImage_restaurant(rs.getString("image_restaurant"));

                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Hotel");

        }   
     return list;    
    }
 //////////////////////////////////////////////////////////////////////////////////////////
     //      @Override

 public ArrayList<restaurants> afficheBylocalisation(String localisation) {
     

      ArrayList<restaurants>  list = new ArrayList();
       try {
                  String req ="Select * FROM restaurants WHERE localisation='"+localisation+"'"; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                         restaurants r = new restaurants();
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setNom_restaurant(rs.getString("nom_restaurant"));
                         r.setLocalisation(rs.getString("localisation"));
                         r.setHoraire(rs.getString("horaire"));
                         r.setNumero_restaurant(rs.getString("numero_restaurant"));
                         r.setCuisinies(rs.getString("cuisinies"));
                         r.setNombre_fourchet(rs.getInt("nombre_fourchet"));
                         r.setAvis_restaurant(rs.getInt("avis_restaurant"));
                         r.setImage_restaurant(rs.getString("image_restaurant"));

                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Hotel");

        }   
     return list;    
    }
 
  //////////////////////////////////////////////////////////////////////////////////////////

public ArrayList<restaurants> afficheBycuisinies(String cuisinies) {
     

      ArrayList<restaurants>  list = new ArrayList();
       try {
                  String req ="Select * FROM restaurants WHERE cuisinies='"+cuisinies+"'"; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                         restaurants r = new restaurants();
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setNom_restaurant(rs.getString("nom_restaurant"));
                         r.setLocalisation(rs.getString("localisation"));
                         r.setHoraire(rs.getString("horaire"));
                         r.setNumero_restaurant(rs.getString("numero_restaurant"));
                         r.setCuisinies(rs.getString("cuisinies"));
                         r.setNombre_fourchet(rs.getInt("nombre_fourchet"));
                         r.setAvis_restaurant(rs.getInt("avis_restaurant"));
                         r.setImage_restaurant(rs.getString("image_restaurant"));

                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting Hotel");

        }   
     return list;    
    }
 //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void ajout(restaurants r) {
        try {
         Statement stm = connection.createStatement();
            String req = "INSERT INTO `restaurants`(`nom_restaurant`,`localisation`, `horaire`, `numero_restaurant`,`cuisinies`,`nombre_fourchet`,`avis_restaurant`, `image_restaurant`) VALUES ('"   + r.getNom_restaurant() + "','" + r.getLocalisation() + "','"
                 + r.getHoraire() + "','"   + r.getNumero_restaurant() + "','" + r.getCuisinies() + "','" + r.getNombre_fourchet() +  "','" + r.getAvis_restaurant() + "','" + r.getImage_restaurant() +"')";
                     //   System.out.println(r);

            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Error in inserting restaurant");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////

           @Override

    public void supprime( int id   ) {
        try {
            
            String req = "delete from restaurants where id_restaurant = ?" ;

          PreparedStatement ps = connection.prepareStatement(req);
             ps.setInt(1,id);

            ps.executeUpdate();
                  //       System.out.println(req);

        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in deleting restaurant");
        }
    }
     //////////////////////////////////////////////////////////////////////////////////////////

        @Override

    public void modifier(restaurants r) {
        try {
         Statement stm = connection.createStatement();
            String req = "UPDATE `restaurants` SET `nom_restaurant`='"
                    + r.getNom_restaurant() + "',`localisation`='"
                    + r.getLocalisation() + "',`numero_restaurant`='"
                    + r.getNumero_restaurant() + "',`cuisinies`='"
                    + r.getCuisinies() + "',`nombre_fourchet`='"
                    + r.getNombre_fourchet()+ "',`avis_restaurant`='"
                    + r.getAvis_restaurant()+"',`Image_restaurant`='"
                    + r.getImage_restaurant()+ "' WHERE `id_restaurant`='"
                    + r.getId_restaurant()  + "'";
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            
            System.out.println("Error in updating restaurant ");
        }
    }

}

    

