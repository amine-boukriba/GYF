/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.avis;
import entities.reclamation;
import java.sql.Date;
import services.ServiceAvis;
import services.ServiceReclamation;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
      MyDB.getInstance();
        ServiceReclamation sr = new ServiceReclamation();
         //reclamation r= new reclamation("description",new Date(1), new Date(2), "status"," image_reclamation", 2, 4, 2);
       // sr.ajouter(new reclamation("description123",new Date(1), new Date(2), "status", "image_reclamation", 0, 0,2));
       //sr.modifier(new reclamation(8,"reclamation resto", new Date(1), new Date(2), "status", "image_reclamation", 0, 0, 2));
        //sr.supprimer(7);
        ServiceAvis sa = new ServiceAvis();
         //sa.ajout(new avis(2, "description2", 2, 0, 0));
         sa.modifier(new avis(9,3,"contienttroisetoiles", 2, 0, 0));
       
       // sa.supprime(6);
       // System.out.println(sr.afficher());
        //System.out.println(sa.affiche());
    }
}
