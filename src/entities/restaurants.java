/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author omarb
 */
public class restaurants {

  
 

    public restaurants(String nom_restaurant, String localisation, String horaire, String numero_restaurant, String cuisinies, int nombre_fourchet) {
        this.nom_restaurant = nom_restaurant;
        this.localisation = localisation;
        this.horaire = horaire;
        this.numero_restaurant = numero_restaurant;
        this.cuisinies = cuisinies;
        this.nombre_fourchet = nombre_fourchet;
    }

    public restaurants(int id_restaurant, String nom_restaurant, String localisation, String horaire, String numero_restaurant, String cuisinies, int nombre_fourchet) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.localisation = localisation;
        this.horaire = horaire;
        this.numero_restaurant = numero_restaurant;
        this.cuisinies = cuisinies;
        this.nombre_fourchet = nombre_fourchet;
    }


    private String nom_restaurant ;
    private String localisation;
    private String horaire;
    private String numero_restaurant;
    private String cuisinies;
    private int nombre_fourchet;
    private int avis_restaurant ;
    private String image_restaurant;
    
   private Date  date_debut;
  private String date_creation;
       private int  nbr_personne;
        private String    nom_user;
             private String   prenom_user ;
             private int id_reservation;
    private int id_restaurant ;
    
        public restaurants(String nom_restaurant, String localisation, String horaire, String numero_restaurant, String cuisinies, int nombre_fourchet, int avis_restaurant , String image_restaurant) {
 
        this.nom_restaurant = nom_restaurant;
        this.localisation = localisation;
        this.horaire = horaire;
        this.numero_restaurant = numero_restaurant;
        this.cuisinies = cuisinies;
        this.nombre_fourchet = nombre_fourchet;
        this.avis_restaurant = avis_restaurant;
        this.image_restaurant = image_restaurant;

    }

    public restaurants(int id_restaurant, String nom_restaurant, String localisation, String horaire, String numero_restaurant, String cuisinies, int nombre_fourchet, int avis_restaurant, String image_restaurant) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.localisation = localisation;
        this.horaire = horaire;
        this.numero_restaurant = numero_restaurant;
        this.cuisinies = cuisinies;
        this.nombre_fourchet = nombre_fourchet;
        this.avis_restaurant = avis_restaurant;
        this.image_restaurant = image_restaurant;

    }
    public restaurants() {
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getNumero_restaurant() {
        return numero_restaurant;
    }

    public void setNumero_restaurant(String numero_restaurant) {
        this.numero_restaurant = numero_restaurant;
    }

    public String getCuisinies() {
        return cuisinies;
    }

    public void setCuisinies(String cuisinies) {
        this.cuisinies = cuisinies;
    }

    public int getNombre_fourchet() {
        return nombre_fourchet;
    }

    public void setNombre_fourchet(int nombre_fourchet) {
        this.nombre_fourchet = nombre_fourchet;
    }

    public int getAvis_restaurant() {
        return avis_restaurant;
    }

    public void setAvis_restaurant(int avis_restaurant) {
        this.avis_restaurant = avis_restaurant;
    }
  public String getImage_restaurant() {
        return image_restaurant;
    }

    public void setImage_restaurant(String image_restaurant) {
        this.image_restaurant = image_restaurant;
    }
   
  

  public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public int getNbr_personne() {
        return nbr_personne;
    }

    public void setNbr_personne(int nbr_personne) {
        this.nbr_personne = nbr_personne;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }
public String toString(){
    return   " Nom d'utilisatuer=" + nom_user + ", Prénom d'utilisateur=" + prenom_user  + ", Nom restaurant=" + nom_restaurant+ " ,jour de réservation=" + date_debut + "";
}
}
