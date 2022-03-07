
package services;

import entities.reservation;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import entities.restaurants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
         
            String req = "INSERT INTO `restaurants`(`nom_restaurant`,`localisation`, `horaire`, `numero_restaurant`,`cuisinies`,`nombre_fourchet`,`avis_restaurant`, `image_restaurant`)  VALUES (?,?,?,?,?,?,?,?);";
                     //   System.out.println(r);
 PreparedStatement ps = connection.prepareStatement(req);

             ps.setString(1, r.getNom_restaurant());
            ps.setString(2, r.getLocalisation());
            ps.setString(3, r.getHoraire());
            ps.setString(4, r.getNumero_restaurant());
             ps.setString(5, r.getCuisinies());
            ps.setInt(6, r.getNombre_fourchet());
            ps.setInt(7,r.getAvis_restaurant());
            ps.setString(8, r.getImage_restaurant());
            ps.executeUpdate();
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
            System.out.println(r);
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
    
    public List<restaurants> AfficheInformationRestoReservationClientqr(int id_reservation) {
          
       
       
       ArrayList<restaurants>  list = new ArrayList();


       try {
String req = "SELECT * FROM `reservations_resto_hotel` join restaurants using(id_restaurant) join users using (id_user) WHERE id_reservation ='"+id_reservation+"'";        
           Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){

    
                                            restaurants r = new restaurants();

                        
                       r.setNom_restaurant(rs.getString("nom_restaurant"));
                               
                    r.setLocalisation(rs.getString("localisation"));
             
                    r.setDate_debut(rs.getDate("date_debut"));
           
                         r.setDate_creation(rs.getString("date_creation"));
                         r.setNbr_personne(rs.getInt("nbr_personne"));
                         
                             r.setNom_user(rs.getString("nom_user"));
                                    r.setPrenom_user(rs.getString("prenom_user"));
                 
      


                         list.add(r);
       System.out.println(r);
                


            }

             }  
        catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
         return list;  
  }
     public Integer MaxID1() {
          
int id =0;
       try {
    String req = "select max(id_reservation) as max from reservations_resto_hotel where id_restaurant is not null;";          
          PreparedStatement ps = connection.prepareStatement(req);


          ResultSet rs = ps.executeQuery();
                  
             while (rs.next()){
              id =  rs.getInt("max");
             }
           
             }             
     
        catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return id;    
   }


}

    

