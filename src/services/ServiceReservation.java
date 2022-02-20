/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author omarb
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
import entities.reservation;
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
public class ServiceReservation implements IVService<reservation> {

    MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();
    ////////////////////////////////////////////////////////////////////
   @Override
   public ArrayList<reservation> afficheReservation() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="Select * FROM reservation";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){

                       reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_hotel(rs.getInt("id_hotel"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setId_user(rs.getInt("id_user"));



                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
   @Override
   public ArrayList<reservation> AfficherReservationRestaurantByName (String nom_restaurant) {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservation_resto_hotel join restaurants using (id_restaurant) where nom_restaurant ='"+nom_restaurant+"' "; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                          r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_user(rs.getInt("id_user"));


                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }
 //////////////////////////////////////////////////////////////////////////////////////////
 @Override
   public ArrayList<reservation> AfficherReservationHotelByName (String nom_hotel) {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservation_resto_hotel join hotels using (id_hotel) where nom_hotel ='"+nom_hotel+"' "; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_hotel(rs.getInt("id_hotel"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_user(rs.getInt("id_user"));


                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceHotel.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }
 //////////////////////////////////////////////////////////////////////////////////////////
 @Override
   public ArrayList<reservation> AfficherReservationHotel() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservation_resto_hotel where id_hotel is not null   ";

               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_hotel(rs.getInt("id_hotel"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_user(rs.getInt("id_user"));


                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }

   
    //////////////////////////////////////////////////////////////////////////////////////////

 @Override
   public ArrayList<reservation> AfficherReservationRestaurant() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservation_resto_hotel where id_restaurant is not null   ";

               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_restaurant(rs.getInt("id_restaurant"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_user(rs.getInt("id_user"));


                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }

    //////////////////////////////////////////////////////////////////////////////////////////

 @Override

  public void AjoutReservationHotel(reservation r) {
        try {
            String req = "INSERT INTO `reservation_resto_hotel`(`id_hotel`,`date_debut`,`date_fin`,`mode_payement`,`prix`,`id_user`,`nbr_personne`) VALUES ('" + r.getId_hotel()+ "','" + r.getDate_debut()+ 
                    "','" + r.getDate_fin()+"','" + r.getMode_payment()+ "','" + r.getPrix()+ "','" + r.getId_user()+ "','" + r.getNbr_personne()+ "')";
                //        System.out.println(h);

 
                Statement sm = connection.createStatement();
                sm.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in inserting reservation");

            }
            
        }
  /////////////////////////////////////////////////////////////////////////
   @Override

 public void AjoutReservationRestaurant(reservation r) {
        try {
           String req = "INSERT INTO `reservation_resto_hotel`(`id_restaurant`,`date_debut`,`date_fin`,`id_user`,`nbr_personne`) VALUES ('" + r.getId_restaurant()+ "','" + r.getDate_debut()+ 
                    "','" + r.getDate_fin()+ "','" + r.getId_user()+ "','" + r.getNbr_personne()+ "')";
                //        System.out.println(h);

 
                Statement sm = connection.createStatement();
                sm.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in inserting reservation");

            }
            
        }
 ///////////////////////////////////////////////////////////////////////////////////////
  @Override

   public void modifierReservationHotel(reservation r) {
        try {
            Statement stm = connection.createStatement();
            String req = "UPDATE `reservation_resto_hotel` SET `id_hotel`='"
                    + r.getId_hotel()+ "',`date_debut`='"
                    + r.getDate_debut()+ "',`date_fin`='"
                    + r.getDate_fin()+ "',`mode_payement`='"
                    +r.getMode_payment()+ "',`prix`='"
                    +r.getPrix()+ "',`id_user`='"
                    + r.getId_user()+ "',`nbr_personne`='"
                    + r.getNbr_personne() + "' WHERE `id_reservation`='"
                    + r.getId_reservation()+ "'";
            //  System.out.println(req); 
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            
            System.out.println("Error in updating reservation");
        }
    }
   //////////////////////////////////////////////////////////////////
    @Override

     public void modifierReservationRestaurant(reservation r) {
        try {
            Statement stm = connection.createStatement();
            String req = "UPDATE `reservation_resto_hotel` SET `id_restaurant`='"
                    + r.getId_hotel()+ "',`date_debut`='"
                    + r.getDate_debut()+ "',`date_fin`='"
                    + r.getDate_fin()+ "',`id_user`='"
                    + r.getId_user()+ "',`nbr_personne`='"
                    + r.getNbr_personne() + "' WHERE `id_reservation`='"
                    + r.getId_reservation()+ "'";
            //  System.out.println(req);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            
            System.out.println("Error in updating reservation ");
        }
    }
     @Override
     public void supprimerReservation(int id ){
             
        try {
            String req = "DELETE FROM reservation_resto_hotel WHERE id_reservation = ?" ;
          PreparedStatement ps = connection.prepareStatement(req);
         // System.out.println(req);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in deleting reservation");        }
    }
    
}