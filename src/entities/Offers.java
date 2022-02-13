/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author anwer
 */
public class Offers {
    
    private int id_offer;
    private String titre;
    private String depart;
    private String destination;
    private Date date_depart;
    private Date date_arrive;
    private int nombre_nuits;
    private String description;
    private float prix;
    private String image_offer;
    private int avis_offer ;
    private int id_vol;
    private int id_hotel;
    private int id_restaurant;
    private int id_monument;
    private int id_evenement;
    private int id_espace;

    public Offers() {
    }

    public Offers(String titre, String depart, String destination, Date date_depart, Date date_arrive, int nombre_nuits, String description, float prix, String image_offre, int avis_offre, int id_vol, int id_hotel, int id_restaurant, int id_monument, int id_evenement, int id_espace) {
        this.titre = titre;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nombre_nuits = nombre_nuits;
        this.description = description;
        this.prix = prix;
        this.image_offer = image_offre;
        this.avis_offer = avis_offre;
        this.id_vol = id_vol;
        this.id_hotel = id_hotel;
        this.id_restaurant = id_restaurant;
        this.id_monument = id_monument;
        this.id_evenement = id_evenement;
        this.id_espace = id_espace;
    }

    
    
    public Offers(int id_offer, String titre, String depart, String destination, Date date_depart, Date date_arrive, int nombre_nuits, String description, float prix, String image_offre, int avis_offre, int id_vol, int id_hotel, int id_restaurant, int id_monument, int id_evenement, int id_espace) {
        this.id_offer = id_offer;
        this.titre = titre;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.nombre_nuits = nombre_nuits;
        this.description = description;
        this.prix = prix;
        this.image_offer = image_offre;
        this.avis_offer = avis_offre;
        this.id_vol = id_vol;
        this.id_hotel = id_hotel;
        this.id_restaurant = id_restaurant;
        this.id_monument = id_monument;
        this.id_evenement = id_evenement;
        this.id_espace = id_espace;
    }

    public int getId_offer() {
        return id_offer;
    }

    public void setId_offer(int id_offre) {
        this.id_offer = id_offre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }

    public int getNombre_nuits() {
        return nombre_nuits;
    }

    public void setNombre_nuits(int nombre_nuits) {
        this.nombre_nuits = nombre_nuits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage_offer() {
        return image_offer;
    }

    public void setImage_offer(String image_offer) {
        this.image_offer = image_offer;
    }

    public int getAvis_offer() {
        return avis_offer;
    }

    public void setAvis_vol(int avis_offer) {
        this.avis_offer= avis_offer;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getId_monument() {
        return id_monument;
    }

    public void setId_monument(int id_monument) {
        this.id_monument = id_monument;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_espace() {
        return id_espace;
    }

    public void setId_espace(int id_espace) {
        this.id_espace = id_espace;
    }

    @Override
    public String toString() {
        return "Offres{" + "id_offer=" + id_offer + ", titre=" + titre + ", depart=" + depart + ", destination=" + destination + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", nombre_nuits=" + nombre_nuits + ", description=" + description + ", prix=" + prix + ", image_offer=" + image_offer + ", avis_offer=" + avis_offer + ", id_vol=" + id_vol + ", id_hotel=" + id_hotel + ", id_restaurant=" + id_restaurant + ", id_monument=" + id_monument + ", id_evenement=" + id_evenement + ", id_espace=" + id_espace + '}';
    }
    
    
}
