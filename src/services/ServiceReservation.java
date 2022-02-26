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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author PC
 */
public class ServiceReservation implements IIService<reservation> {

    MyDB instance = MyDB.getInstance();
    Connection connection = instance.getConnection();
    ////////////////////////////////////////////////////////////////////
   @Override
   public ArrayList<reservation> afficheReservation() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="Select * FROM reservations_resto_hotel";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){

                       reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_chambre(rs.getInt("id_chambre"));
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
  // @Override
   public ArrayList<reservation> AfficherReservationRestaurantByName (String nom_restaurant) {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservations_resto_hotel join restaurants using (id_restaurant) where nom_restaurant ='"+nom_restaurant+"' "; 
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
// @Override
   public ArrayList<reservation> AfficherReservationHotelByName (String nom_hotel) {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservations_resto_hotel where id_chambre in (select id_chambre from  chambre where id_hotel=(SELECT id_hotel from hotels where nom_hotel='"+nom_hotel+"')); "; 
            Statement st = connection.createStatement();
            System.out.println(req);
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_chambre(rs.getInt("id_chambre"));
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
 //@Override
   public ArrayList<reservation> AfficherReservationHotel() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservations_resto_hotel where id_chambre is not null   ";

               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setId_chambre(rs.getInt("id_chambre"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_debut(rs.getDate("date_fin"));
                         r.setMode_payment(rs.getString("mode_payment"));
                         r.setPrix(rs.getInt("prix"));
                         r.setId_user(rs.getInt("id_user"));


                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceReservation.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }

   
    //////////////////////////////////////////////////////////////////////////////////////////

// @Override
   public ArrayList<reservation> AfficherReservationRestaurant() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservations_resto_hotel where id_restaurant is not null   ";

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

   public List<reservation> Afficherfullinformation(int id_reservation) {
          
       
       ArrayList<reservation>  list = new ArrayList();


       try {
                   String req ="select id_reservation,mode_payment,prix,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel) where id_reservation='"+id_reservation+"' ";

            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
                 reservation r = new reservation();
                    r.setId_reservation(rs.getInt("id_reservation"));
                    r.setMode_payment(rs.getString("mode_payment"));
                    r.setPrix(rs.getInt("prix"));
                      r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_fin(rs.getDate("date_fin"));
                         r.setNom_user(rs.getString("nom_user"));
                    r.setPrenom_user(rs.getString("prenom_user"));
                    r.setEmail_user(rs.getNString("email_user"));
                    r.setType_chambre(rs.getString("type_chambre"));
                    r.setNom_hotel(rs.getString("nom_hotel"));
                    r.setPrix_chambre(rs.getInt("prix_chambre"));

                         list.add(r);


            }

             }             
     
        catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }
  public void AjoutReservationHotel(reservation r  ) {
              List<String> list = new ArrayList<>();

  

        try {
         

            String req = "INSERT INTO reservations_resto_hotel(id_chambre,date_debut,date_fin,mode_payment,prix,id_user,nbr_personne) VALUES (?,?,?,?,?,?,?)";
                //        System.out.println(h);
                
                   PreparedStatement ps = connection.prepareStatement(req);
                   System.out.println(req);
            ps.setInt(1, r.getId_chambre());
            ps.setDate(2, (Date) r.getDate_debut());
            ps.setDate(3, (Date) r.getDate_fin());
            ps.setString(4, r.getMode_payment());
            ps.setInt(5, r.getPrix());
            ps.setInt(6, r.getId_user());
            ps.setInt(7, r.getNbr_personne());


                  ps.executeUpdate();
                     

  String reqP ="select id_reservation,mode_payment,prix,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel) where id_reservation=?";

                   PreparedStatement ps1 = connection.prepareStatement(reqP);
                   ps1.setInt(1,50);

                      ResultSet rs = ps1.executeQuery();
                                                System.out.println(ps1);

            while (rs.next()){
                list.add(0,rs.getString(1));
                list.add(1,rs.getString(2));
                list.add(2,rs.getString(3));
                list.add(3,rs.getString(4));
                list.add(4,rs.getString(5));
                list.add(5,rs.getString(6));
                list.add(6,rs.getString(7));
                list.add(7,rs.getString(8));
                list.add(8,rs.getString(9));
                list.add(9,rs.getString(10));
                list.add(10,rs.getString(11));
                          System.out.println(r +"daaz");

           ServiceMail sm = new ServiceMail(list);
            sm.sendMail(list);
            }
        }
        /*{
          
            } */catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in inserting reservation");

            }
                                System.out.println();

        }
  /////////////////////////////////////////////////////////////////////////
   @Override

 public void AjoutReservationRestaurant(reservation r) {
        try {
           String req = "INSERT INTO `reservations_resto_hotel`(`id_restaurant`,`date_debut`,`date_fin`,`id_user`,`nbr_personne`) VALUES ('" + r.getId_restaurant()+ "','" + r.getDate_debut()+ 
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
            String req = "UPDATE `reservations_resto_hotel` SET `id_chambre`='"
                    + r.getId_chambre()+ "',`date_debut`='"
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
            String req = "UPDATE `reservations_resto_hotel` SET `id_restaurant`='"
                    + r.getId_restaurant()+ "',`date_debut`='"
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
            String req = "DELETE FROM reservations_resto_hotel WHERE id_reservation = ?" ;
          PreparedStatement ps = connection.prepareStatement(req);
         // System.out.println(req);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in deleting reservation");        }
    }
    
}