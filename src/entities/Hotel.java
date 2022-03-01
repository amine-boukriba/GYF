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

    public Hotel(int id_hotel, String nom_hotel, String localisation, String categorie) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.localisation = localisation;
        this.categorie = categorie;
    }

    private int id_hotel;

   
    private String nom_hotel;
    private String localisation;
    private String categorie;
    private int avis_hotel;
    private String image_hotel;



    public Hotel(int id_hotel, String nom_hotel, String localisation, String categorie, int avis_hotel,String image_hotel) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.localisation = localisation;
        this.categorie = categorie;
        this.avis_hotel = avis_hotel;
        this.image_hotel = image_hotel;

    }

    public Hotel(String nom_hotel, String localisation,  String categorie,  int avis_hotel) {
        this.nom_hotel = nom_hotel;
        this.localisation = localisation;
        this.categorie = categorie;
        this.avis_hotel = avis_hotel;
        this.image_hotel = image_hotel;

    }
 public Hotel(int id_hotel) {
        this.id_hotel = id_hotel;
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

 
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        return "Hotel{" + "id_hotel=" + id_hotel + ", nom_hotel=" + nom_hotel + ", localisation=" + localisation + ", categorie=" + categorie +  ", avis_hotel=" + avis_hotel + ", image_hotel=" + image_hotel +'}';
    }

    
}
