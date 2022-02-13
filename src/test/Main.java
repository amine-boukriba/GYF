/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.avis;
import services.ServiceAvis;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
      MyDB.getInstance();
        //ServiceReclamation sr = new ServiceReclamation();
         //reclamation r= new reclamation("description",new Date(1), new Date(2), "status"," image_reclamation", 2, 4, 2);
        //sr.ajouter(new reclamation("description",new Date(1), new Date(2), "status", "image_reclamation", 0, 0,2));
       //sr.modifier(new reclamation(6,"reclamation hotel", new Date(1), new Date(2), "status", "image_reclamation", 0, 0, 2));
        //sr.supprimer(7);
         ServiceAvis sa = new ServiceAvis();
        // sa.ajouter(new avis(14, "description2", 2, 0, 0));
         //sa.modifier(new avis(8, 2, "contientdeuxetoiles", 2, 0, 0));
       
        //sa.supprimer(4);
       // System.out.println(sr.afficher());
        System.out.println(sa.afficher());
    }
}
