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
    private Date date_debut;
    private Date date_fin;
    private int nombre_nuits;
    private String description;
    private float prix;
    private int avis_offer ;
    

    public Offers() {
    }

    public Offers(String titre, String depart, String destination, Date date_debut, Date date_fin, int nombre_nuits, String description, float prix, int avis_offre) {
        this.titre = titre;
        this.depart = depart;
        this.destination = destination;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nombre_nuits = nombre_nuits;
        this.description = description;
        this.prix = prix;
        this.avis_offer = avis_offre;
    }

    
    
    public Offers(int id_offer, String titre, String depart, String destination, Date date_debut, Date date_fin, int nombre_nuits, String description, float prix, int avis_offre) {
        this.id_offer = id_offer;
        this.titre = titre;
        this.depart = depart;
        this.destination = destination;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nombre_nuits = nombre_nuits;
        this.description = description;
        this.prix = prix;
        this.avis_offer = avis_offre;
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


    public int getAvis_offer() {
        return avis_offer;
    }

    public void setAvis_vol(int avis_offer) {
        this.avis_offer= avis_offer;
    }


    @Override
    public String toString() {
        return "Offres{" + "id_offer=" + id_offer + ", titre=" + titre + ", depart=" + depart + ", destination=" + destination + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", nombre_nuits=" + nombre_nuits + ", description=" + description + ", prix=" + prix +  ", avis_offer=" + avis_offer +  '}';
    }
    
    
}
