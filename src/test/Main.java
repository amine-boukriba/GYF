
package test;

import entities.Espace_culturels;
import entities.Monuments;
import static java.util.Collections.list;
import services.ServiceEspaceCulturel;
import services.ServiceMonuments;
import utils.MyDB;


public class Main {
    public static void main(String[] args) {
        
    ServiceMonuments sp = new ServiceMonuments();
  // ServiceEspaceCulturel sp = new ServiceEspaceCulturel();
    
    //---------CRUD Monuments------------
   //sp.ajout(new Monuments("nom_monument", "image_monument", 1, 30, "description", "date_creation", "pays", "localisation", 5));
    //sp.modifier(new Monuments(3,"nom", "image_monument", 1, 30, "description", "date_creation", "pays", "localisation", 5));
    //sp.supprime(5);
    //System.out.println(sp.afficher());
    
    //---------CRUD Espace culturel------------
    //sp.ajout(new Espace_culturels("nom_espace", "image_espace", "horaire", 0, 0, "date_creation", "pays", "localisation", "description", 0)); 
    //sp.modifier(new Espace_culturels(7,"albatros", "image_espace", "horaire", 0, 0, "date_creation", "pays", "localisation", "description", 0));
    //sp.supprime(8);
    //System.out.println(sp.affiche());
    
    
    }
}
