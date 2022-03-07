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

   

        private String localisation;

  
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
private String nom_user;
private String prenom_user;
private String email_user;
private String type_chambre;
private int prix_chambre;
private String date_creation;


 public reservation(int id_reservation,String mode_payment, int prix, Date date_debut, Date date_fin,  String nom_user, String prenom_user, String email_user, String type_chambre, String nom_hotel,int prix_chambre) {
        this.id_reservation = id_reservation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.nom_hotel = nom_hotel;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email_user = email_user;
        this.type_chambre = type_chambre;
                this.prix_chambre = prix_chambre;
                this.date_creation = date_creation;
    }


 

    public reservation(int id_reservation, int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_restaurant, int id_user,int nbr_personne , String date_creation) {
        this.id_reservation = id_reservation;
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_restaurant = id_restaurant;
     this.nbr_personne = nbr_personne;
        this.id_user = id_user;
        
        this.date_creation = date_creation;
    }



    public reservation(int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_restaurant, int id_user,int nbr_personne,String date_creation) {
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_restaurant = id_restaurant;
        this.id_user = id_user;
             this.nbr_personne = nbr_personne;
               
        this.date_creation = date_creation;
    }
        
    public reservation(int id_chambre, Date date_debut, Date date_fin, String mode_payment, int prix, int id_user, int nbr_personne ,String date_creation) {
        this.id_chambre = id_chambre;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.mode_payment = mode_payment;
        this.prix = prix;
        this.id_user = id_user;
        this.nbr_personne = nbr_personne;
        this.date_creation = date_creation;

    }

        public reservation(Date date_debut, Date date_fin, int id_restaurant, int id_user,  int nbr_personne, String date_creation ) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id_restaurant = id_restaurant;
        this.id_user = id_user;
        this.nbr_personne = nbr_personne;
                this.date_creation = date_creation;
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

   public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
  

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
    public int getPrix_chambre() {
        return prix_chambre;
    }

    public void setPrix_chambre(int prix_chambre) {
        this.prix_chambre = prix_chambre;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }


    public String getNom_user() {
        return nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public String toString() {
        return   "  Nom d'utilisatuer=" + nom_user + ", Prénom d'utilisateur=" + prenom_user  + ", Nom d'Hôtel=" + nom_hotel+ " date d'entrée=" + date_debut + ", date de sortie=" + date_fin + ", mode de payment=" + mode_payment + ", prix Total=" + prix + "TND"+ "";
    }


}
