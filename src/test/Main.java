
package test;

import utils.MyDB;
import services.ServiceHotel;
import services.ServiceRestaurant;
import services.ServiceChambre;
import entities.restaurants;
import entities.Hotel;
import entities.Chambre;
import entities.reservation;
import java.sql.Date;
import services.ServiceMail;
import services.ServiceReservation;
public class Main {
     
         public static void main(String[] args){
                MyDB.getInstance();
                ServiceHotel ha = new ServiceHotel();
                ServiceRestaurant ra = new ServiceRestaurant();
                ServiceChambre ca = new ServiceChambre();
                services.ServiceReservation rs = new ServiceReservation();
 Hotel h = new Hotel(5,"omar","talel","jdaazd",1,"");
  restaurants r = new restaurants(1,"alfa" , "sousse" , "12:00 - 22:00", "26353009", "spécialité mer " , 1 , 2 ,"");
    Chambre c = new Chambre("double",2000,6);
   reservation  rsh = new reservation( 5,Date.valueOf("2020-12-12"),Date.valueOf("2020-12-03"),"agence",1234,1,4);
  //  Chambre c = new Chambre(3);
  

//Hotel h1 = new Hotel(5);
//ha.supprime(h1.getId_hotel());

// ha.ajout(h);
 //ha.modifier(h);
 //ha.supprime(h.getId_hotel());
//System.out.println(ha.afficheBylocalisation("hammamet"));
//System.out.println(ha.afficheByName("marhaba"));

System.out.println(rs.AfficherReservationHotel());

//ra.ajout(r);
 //ra.modifier(r);
 //ra.supprime(r.getId_restaurant());
//System.out.println(ra.affiche());

//ca.ajout(c);
//ca.modifier(c);
//ca.supprime(c.getId_chambre());
//System.out.println(ca.afficheBynom_hotel("marhaba"));
//System.out.println(ca.affichePrix_chambreHotel("marhaba"));


//ServiceMail.sendMail("omar.bouchniba@esprit.tn");
//rs.AjoutReservationHotel(rsh);

    }
    
    }
   
