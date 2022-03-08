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
public class Bateaux {
    
     private int id_bateau;
    private String compagnie_maritime;
    private String depart;
    private String destination;
    private Date date_depart;
    private Date date_arrive;
    private float prix;
    private int duree;
    private String nom_bateau;
    private String image_bateau;
    private int avis_bateau ;

    public Bateaux() {
    }

    public Bateaux(String compagnie_maritime, String depart, String destination, Date date_depart, Date date_arrive, float prix, int duree, String nom_bateau, String image_bateau, int avis_bateau) {
        this.compagnie_maritime = compagnie_maritime;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.prix = prix;
        this.duree = duree;
        this.nom_bateau = nom_bateau;
        this.image_bateau = image_bateau;
        this.avis_bateau = avis_bateau;
    }

    
    public Bateaux(int id_bateau, String compagnie_maritime, String depart, String destination, Date date_depart, Date date_arrive, float prix, int duree, String nom_bateau, String image_bateau, int avis_bateau) {
        this.id_bateau = id_bateau;
        this.compagnie_maritime = compagnie_maritime;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.prix = prix;
        this.duree = duree;
        this.nom_bateau = nom_bateau;
        this.image_bateau = image_bateau;
        this.avis_bateau = avis_bateau;
    }

    public int getId_bateau() {
        return id_bateau;
    }

    public void setId_bateau(int id_bateau) {
        this.id_bateau = id_bateau;
    }

    public String getCompagnie_maritime() {
        return compagnie_maritime;
    }

    public void setCompagnie_maritime(String compagnie_maritime) {
        this.compagnie_maritime = compagnie_maritime;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getNom_bateau() {
        return nom_bateau;
    }

    public void setNom_bateau(String nom_bateau) {
        this.nom_bateau = nom_bateau;
    }

    public String getImage_bateau() {
        return image_bateau;
    }

    public void setImage_bateau(String image_bateau) {
        this.image_bateau = image_bateau;
    }

    public int getAvis_bateau() {
        return avis_bateau;
    }

    public void setAvis_bateau(int avis_bateau) {
        this.avis_bateau = avis_bateau;
    }

    @Override
    public String toString() {
        return "Bateaux{" + "id_bateau=" + id_bateau + ", compagnie_maritime=" + compagnie_maritime + ", depart=" + depart + ", destination=" + destination + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", prix=" + prix + ", duree=" + duree + ", nom_bateau=" + nom_bateau + ", image_bateau=" + image_bateau + ", avis_bateau=" + avis_bateau + '}';
    }
    
    
}
