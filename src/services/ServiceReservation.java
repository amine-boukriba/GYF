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
import static java.util.Collections.list;
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
 
   
    //////////////////////////////////////////////////////////////////////////////////////////

// @Override
   public ArrayList<reservation> AfficherReservationRestaurant() {
     

      ArrayList<reservation>  list = new ArrayList();
       try {
                  String req ="select * from reservations_resto_hotel join users using (id_user) join restaurants using (id_restaurant);";

               //   System.out.println(req);
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
               
                     reservation r = new reservation();
                         r.setId_reservation(rs.getInt("id_reservation"));
                         r.setNom_restaurant(rs.getString("nom_restaurant"));
                         r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_creation(rs.getString("date_creation"));
                          r.setNom_user(rs.getString("nom_user"));
                        r.setPrenom_user(rs.getString("prenom_user"));
                       r.setEmail_user(rs.getString("email_user"));
                       r.setNbr_personne(rs.getInt("nbr_personne"));
      
                         list.add(r);

             }             
   
        } catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation restaurant");

        }   
     return list;    
    }

    //////////////////////////////////////////////////////////////////////////////////////////

   public List<reservation> AfficherfullinformationHotel() {
          
       
       
       ArrayList<reservation>  list = new ArrayList();


       try {
//                   String req ="select id_reservation,mode_payment,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre, date_creation from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel)";
String req="select * from users join (select DATEDIFF( date_fin, date_debut) AS date_difference ,id_user, r.id_chambre , id_reservation , mode_payment, date_debut,date_fin,date_creation FROM reservations_resto_hotel r join chambre c on c.id_chambre = r.id_chambre ) as r using (id_user) join chambre on chambre.id_chambre=r.id_chambre join hotels using (id_hotel);";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
                 reservation r = new reservation();
                    r.setId_reservation(rs.getInt("id_reservation"));
                    r.setMode_payment(rs.getString("mode_payment"));
                    r.setPrix(rs.getInt("prix_chambre")*rs.getInt("date_difference"));
                      r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_fin(rs.getDate("date_fin"));
                         r.setNom_user(rs.getString("nom_user"));
                    r.setPrenom_user(rs.getString("prenom_user"));
                    r.setEmail_user(rs.getString("email_user"));
                    r.setType_chambre(rs.getString("type_chambre"));
                    r.setNom_hotel(rs.getString("nom_hotel"));
                    r.setPrix_chambre(rs.getInt("prix_chambre"));
                   r.setDate_creation(rs.getString("date_creation"));


                         list.add(r);


            }

             }             
     
        catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }
   
     public List<List> statstypechambre() {
          
       PreparedStatement  pst; 
       
      List<List>  reservation = new ArrayList();


       try {
//                   String req ="select id_reservation,mode_payment,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre, date_creation from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel)";
                        String req=" select count(*) as nbr , sum(prix_chambre) as prix_chambre from reservations_resto_hotel join chambre using (id_chambre) group by type_chambre; ";

                pst = connection.prepareStatement(req);
                ResultSet rs = pst.executeQuery(req);
                while (rs.next()) {
                    List<Object> list=new ArrayList();
                    list.clear();
                     list.add(rs.getInt(1));
                    list.add(rs.getInt(2));
                   
                    reservation.add(list);
                      }                               
        }catch (SQLException e) {
                System.err.println(e.getMessage());
        }
        return reservation;
    }
   //////////////////////////////////////////////////////////////////////
     
     
     
    public List<reservation> AfficherfullinformationHotelcodeQR(int id_reservation) {
          
       
       
       ArrayList<reservation>  list = new ArrayList();


       try {
//                   String req ="select id_reservation,mode_payment,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre, date_creation from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel)";
String req="select * from users join (select DATEDIFF( date_fin, date_debut) AS date_difference ,id_user, r.id_chambre , id_reservation , mode_payment, date_debut,date_fin,date_creation FROM reservations_resto_hotel r join chambre c on c.id_chambre = r.id_chambre ) as r using (id_user) join chambre on chambre.id_chambre=r.id_chambre join hotels using (id_hotel) where id_reservation='"+id_reservation+"'";
            Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(req);
             while (rs.next()){
                 reservation r = new reservation();
                  
                    r.setMode_payment(rs.getString("mode_payment"));
                    r.setPrix(rs.getInt("prix_chambre")*rs.getInt("date_difference"));
                      r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_fin(rs.getDate("date_fin"));
                         r.setNom_user(rs.getString("nom_user"));
                    r.setPrenom_user(rs.getString("prenom_user"));
                 
                    r.setNom_hotel(rs.getString("nom_hotel"));
            
                   r.setDate_creation(rs.getString("date_creation"));


                         list.add(r);


            }

             }             
     
        catch (SQLException ex) {
                Logger.getLogger(ServiceChambre.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in selecting reservation");

        }   
     return list;    
    }
   
   ////////////////////////////////////////////////////::
  public void AjoutReservationHotel(reservation r  ) {
              List<String> list = new ArrayList<>();

  

        try {
         

            String req = "INSERT INTO reservations_resto_hotel(id_chambre,date_debut,date_fin,mode_payment,id_user,nbr_personne, date_creation) VALUES (?,?,?,?,?,?,?)";
                //        System.out.println(h);
                
                   PreparedStatement ps = connection.prepareStatement(req);
                   System.out.println(req);
            ps.setInt(1, r.getId_chambre());
            ps.setDate(2, (Date) r.getDate_debut());
            ps.setDate(3, (Date) r.getDate_fin());
            ps.setString(4, r.getMode_payment());
            ps.setInt(5, r.getId_user());
            ps.setInt(6, r.getNbr_personne());
            ps.setString(7, r.getDate_creation());


                                          ps.executeUpdate();

                     

  String reqP ="select id_reservation,mode_payment,prix,date_debut,date_fin,nom_user,prenom_user,email_user,type_chambre,nom_hotel,prix_chambre ,date_creation from users join reservations_resto_hotel using (id_user) join chambre using (id_chambre) join hotels using (id_hotel) where id_reservation=?";

                   PreparedStatement ps1 = connection.prepareStatement(reqP);
                   ps1.setInt(1,r.getId_reservation());

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
                 list.add(11,rs.getString(12));

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

        }
  /////////////////////////////////////////////////////////////////////////
   @Override

 public void AjoutReservationRestaurant(reservation r) {
        try {
           String req = "INSERT INTO `reservations_resto_hotel`(`id_restaurant`,`date_debut`,`id_user`,`nbr_personne`,date_creation) VALUES ('" + r.getId_restaurant()+ "','" + r.getDate_debut()+ 
                    "','" + r.getId_user()+ "','" + r.getNbr_personne()+ "','" + r.getDate_creation()+"')";
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
                    + r.getNbr_personne() + "',`date_creation`='"
                    +r.getDate_creation() +"' WHERE `id_reservation`='"
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
                    + r.getNbr_personne() +  "',`date_creation`='"
                    +r.getDate_creation() + "' WHERE `id_reservation`='"
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


     ///////////////////////////////////////////////////////////////
 
   public List<reservation> AfficheInformationHotelReservationClient() {
          
       
       
       ArrayList<reservation>  list = new ArrayList();


       try {
String req = "select * from users join (select DATEDIFF( date_fin, date_debut) AS date_difference ,id_user, r.id_chambre , id_reservation , mode_payment, date_debut,date_fin,nbr_personne FROM reservations_resto_hotel r join chambre c on c.id_chambre = r.id_chambre ) as r using (id_user) join chambre on chambre.id_chambre=r.id_chambre join hotels using (id_hotel) where id_user = ?;";          
          PreparedStatement ps = connection.prepareStatement(req);

                      // ps.setInt(1,r.getId_user());
                       ps.setInt(1,1);

          ResultSet rs = ps.executeQuery();
             while (rs.next()){
                                            reservation r = new reservation();

                             r.setPrix(rs.getInt("prix_chambre")*rs.getInt("date_difference"));
                       r.setNom_hotel(rs.getString("nom_hotel"));
                                
                    r.setType_chambre(rs.getString("type_chambre"));
             
                    r.setPrix_chambre(rs.getInt("prix_chambre"));
                      r.setDate_debut(rs.getDate("date_debut"));
                         r.setDate_fin(rs.getDate("date_fin"));
                         r.setNbr_personne(rs.getInt("nbr_personne"));
                         

      


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
    public Integer MaxID() {
          
int id =0;
       try {
String req = "select max(id_reservation) as max from reservations_resto_hotel where id_chambre is not null;";          
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


  public List<reservation> AfficheInformationRestoReservationClient() {
          
       
       
       ArrayList<reservation>  list = new ArrayList();


       try {
String req = "SELECT * FROM `reservations_resto_hotel` r join restaurants rr WHERE r.id_restaurant = rr.id_restaurant and id_user=?;";          
          PreparedStatement ps = connection.prepareStatement(req);

                      // ps.setInt(1,r.getId_user());
                       ps.setInt(1,1);

          ResultSet rs = ps.executeQuery();
             while (rs.next()){
                                            reservation r = new reservation();

                        
                       r.setNom_restaurant(rs.getString("nom_restaurant"));
                                
                    r.setLocalisation(rs.getString("localisation"));
             
                    r.setDate_debut(rs.getDate("date_debut"));
           
                         r.setDate_creation(rs.getString("date_creation"));
                         r.setNbr_personne(rs.getInt("nbr_personne"));
                         

      


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
   
}


/////////////////////////////////////////////

