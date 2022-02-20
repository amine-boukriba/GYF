
package test;

import utils.MyDB;
import services.ServiceHotel;
import services.ServiceRestaurant;
import services.ServiceChambre;
import entities.restaurants;
import entities.Hotel;
import entities.Chambre;
public class Main {
     
         public static void main(String[] args){
                MyDB.getInstance();
                ServiceHotel ha = new ServiceHotel();
                ServiceRestaurant ra = new ServiceRestaurant();
                ServiceChambre ca = new ServiceChambre();
 Hotel h = new Hotel(5,"omar","talel","jdaazd",1,"");
  restaurants r = new restaurants(1,"alfa" , "sousse" , "12:00 - 22:00", "26353009", "spécialité mer " , 1 , 2 ,"");
    Chambre c = new Chambre("double",2000,6);
  //  Chambre c = new Chambre(3);
  

//Hotel h1 = new Hotel(5);
//ha.supprime(h1.getId_hotel());

// ha.ajout(h);
 //ha.modifier(h);
 //ha.supprime(h.getId_hotel());
//System.out.println(ha.afficheBylocalisation("hammamet"));
//System.out.println(ha.afficheByName("marhaba"));


//ra.ajout(r);
 //ra.modifier(r);
 //ra.supprime(r.getId_restaurant());
//System.out.println(ra.affiche());

//ca.ajout(c);
//ca.modifier(c);
//ca.supprime(c.getId_chambre());
//System.out.println(ca.afficheBynom_hotel("marhaba"));
System.out.println(ca.affichePrix_chambreHotel("marhaba"));

      

    }
    
    }
   
