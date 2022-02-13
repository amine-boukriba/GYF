/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author boukr
 */
public class Hotel {

    private int id_hotel;
    private String nom_hotel;
    private String localisation;
    private int prix_hotel ; 
    private String categorie;
    private int id_chambre ;
    private int avis_hotel;
    private String image_hotel;



    public Hotel(int id_hotel, String nom_hotel, String localisation, int prix_hotel, String categorie, int id_chambre, int avis_hotel,String image_hotel) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.localisation = localisation;
        this.prix_hotel = prix_hotel;
        this.categorie = categorie;
        this.id_chambre = id_chambre;
        this.avis_hotel = avis_hotel;
        this.image_hotel = image_hotel;

    }

    public Hotel(String nom_hotel, String localisation, int prix_hotel, String categorie, int id_chambre, int avis_hotel) {
        this.nom_hotel = nom_hotel;
        this.localisation = localisation;
        this.prix_hotel = prix_hotel;
        this.categorie = categorie;
        this.id_chambre = id_chambre;
        this.avis_hotel = avis_hotel;
        this.image_hotel = image_hotel;

    }

    public Hotel() {
    }


     
         public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getPrix_hotel() {
        return prix_hotel;
    }

    public void setPrix_hotel(int prix_hotel) {
        this.prix_hotel = prix_hotel;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public int getAvis_hotel() {
        return avis_hotel;
    }

    public void setAvis_hotel(int avis_hotel) {
        this.avis_hotel = avis_hotel;
    }
    public String getImage_hotel() {
        return image_hotel;
    }

    public void setImage_hotel(String image_hotel) {
        this.image_hotel = image_hotel;
    }
      @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom_hotel=" + nom_hotel + ", localisation=" + localisation + ", prix_hotel=" + prix_hotel + ", categorie=" + categorie + ", id_chambre=" + id_chambre + ", avis_hotel=" + avis_hotel + ", image_hotel=" + image_hotel +'}';
    }

    
}
