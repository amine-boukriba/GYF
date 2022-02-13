
package test;

import utils.MyDB;
import services.ServiceHotel;
import services.ServiceRestaurant;
import entities.restaurants;
import entities.Hotel;
public class Main {
     
         public static void main(String[] args){
                MyDB.getInstance();
                ServiceHotel ha = new ServiceHotel();
                ServiceRestaurant ra = new ServiceRestaurant();
  Hotel h = new Hotel(1,"omaroam","talel",121,"jdaazd",1,12,"");
  restaurants r = new restaurants(1,"alfa" , "sousse" , "12:00 - 22:00", "26353009", "spécialité mer " , 1 , 2 ,"");

 // ha.create(h);
 //ha.modify(h);
 // ha.delete(h.getId_hotel());
 //System.out.println(ha.afficher());

//ra.create(r);
 //ra.modify(r);
 //ra.delete(r.getId_restaurant());
//System.out.println(ra.afficher());

      

    }
    
    }
   
