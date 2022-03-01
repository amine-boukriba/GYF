/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import entities.reclamation;
import entities.status;
import java.sql.Date;
//import services.ServiceAvis;
import services.ServiceReclamation;
import services.ServiceStatus;
import utils.MyDB;
/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
      MyDB.getInstance();
        ServiceStatus ss=new ServiceStatus();
        //ss.ajout(new status("traité"));
       // ss.supprime(5);
        //ss.modifier(new status(4,"en cours"));
        //System.out.println(ss.affiche());
        ServiceReclamation sr = new ServiceReclamation();
        //reclamation r= new reclamation("jj","nom", "pren", "adresse_mail", new Date(1), new Date(2), "status", "image_reclamation", 0, 0, 2);
     //sr.ajout(new reclamation("hotel", "nom", "prenom"," email", new Date(1), new Date(2), "status", "image_reclamation", 0, 0, 2));
       //sr.modifier(new reclamation(8,"description123", "nom", "prenom"," email", new Date(1), new Date(2), "status", "image_reclamation", 0, 0, 2));
        //sr.supprime(6);
         System.out.println(sr.affiche());
         // System.out.println(sr.rechercher_parchoix("Tout", "reclamation resto"));
        //ServiceAvis sa = new ServiceAvis();
         //sa.ajout(new avis(4, "excellent", 2, 0, 0));
         //sa.modifier(new avis(7,3,"contienttroisetoiles", 2, 0, 0));
         //sa.supprime(8);
 //System.out.println(sa.affiche());
         
    }
}
