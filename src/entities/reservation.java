/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.util.Date;
/**
 *
 * @author omarb
 */
public class reservation {


        
   private int id_reservation;
   private int id_chambre;
  private  Date date_debut ;
   private Date date_fin;
   private String mode_payment;
  private  int prix;
  private  int id_restaurant;
   private int id_user;
   private String nom_restaurant;
private String nom_hotel;
private int nbr_personne;

 

    public reservation(int id_reservation, int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_restaurant, int id_user,int nbr_personne) {
        this.id_reservation = id_reservation;
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_restaurant = id_restaurant;
     this.nbr_personne = nbr_personne;
        this.id_user = id_user;
    }



    public reservation(int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_restaurant, int id_user,int nbr_personne) {
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_restaurant = id_restaurant;
        this.id_user = id_user;
             this.nbr_personne = nbr_personne;

    }
        
    public reservation(int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_user, int nbr_personne) {
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_user = id_user;
        this.nbr_personne = nbr_personne;
    }

        public reservation(Date date_debut, Date date_fin, int id_restaurant, int id_user,  int nbr_personne) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_restaurant = id_restaurant;
        this.id_user = id_user;
        this.nbr_personne = nbr_personne;
    }
    

    public reservation(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }
    
    
    
    
    public reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public reservation() {
    }
///////////////////////////////////////////////////////////////////
        public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getMode_payment() {
        return mode_payment;
    }

    public void setMode_payment(String mode_payment) {
        this.mode_payment = mode_payment;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
       public int getNbr_personne() {
        return nbr_personne;
    }

    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = nbr_personne;
    }

    @Override
    public String toString() {
        return "reservation{" + "id_reservation=" + id_reservation + ", id_chambre=" + id_chambre + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", mode_payment=" + mode_payment + ", prix=" + prix + ", id_restaurant=" + id_restaurant + ", id_user=" + id_user + '}';
    }

}
