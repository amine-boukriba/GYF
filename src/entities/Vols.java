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
public class Vols {
    private int id_vol;
    private String compagnie_aerien;
    private String depart;
    private String destination;
    private Date date_depart;
    private Date date_arrive;
    private float prix;
    private int duree;
    private String type_avion;
    private String image_vol;
    private int avis_vol ;

    public Vols() {
    }

    public Vols(int id_vol, String compagnie_aerien, String depart, String destination, Date date_depart, Date date_arrive, float prix, int duree, String type_avion, String image_vol, int avis_vol) {
        this.id_vol = id_vol;
        this.compagnie_aerien = compagnie_aerien;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.prix = prix;
        this.duree = duree;
        this.type_avion = type_avion;
        this.image_vol = image_vol;
        this.avis_vol = avis_vol;
    }

        
    public Vols(String compagnie_aerien, String depart, String destination, Date date_depart, Date date_arrive, float prix, int duree, String type_avion, String image_vol, int avis_vol) {
        this.compagnie_aerien = compagnie_aerien;
        this.depart = depart;
        this.destination = destination;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
        this.prix = prix;
        this.duree = duree;
        this.type_avion = type_avion;
        this.image_vol = image_vol;
        this.avis_vol = avis_vol;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public String getCompagnie_aerien() {
        return compagnie_aerien;
    }

    public void setCompagnie_aerien(String compagnie_aerien) {
        this.compagnie_aerien = compagnie_aerien;
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

    public String getType_avion() {
        return type_avion;
    }

    public void setType_avion(String type_avion) {
        this.type_avion = type_avion;
    }

    public String getImage_vol() {
        return image_vol;
    }

    public void setImage_vol(String image_vol) {
        this.image_vol = image_vol;
    }

    public int getAvis_vol() {
        return avis_vol;
    }

    public void setAvis_vol(int avis_vol) {
        this.avis_vol = avis_vol;
    }

    @Override
    public String toString() {
        return "Vols{" + "id_vol=" + id_vol + ", compagnie_aerien=" + compagnie_aerien + ", depart=" + depart + ", destination=" + destination + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + ", prix=" + prix + ", duree=" + duree + ", type_avion=" + type_avion + ", image_vol=" + image_vol + ", avis_vol=" + avis_vol + '}';
    }
    
    
    
}
