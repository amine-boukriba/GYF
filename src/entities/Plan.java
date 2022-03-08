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
public class Plan {
    private int id_plan;
    private String depart;
    private String destination;
    private Date date_debut;
    private Date date_fin;
    private float prix;
    private int id_user;

    public Plan() {
    }

    public Plan(String depart, String destination, Date date_debut, Date date_fin, float prix, int id_user) {
        this.depart = depart;
        this.destination = destination;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.id_user = id_user;
    }

    public Plan(int id_plan, String depart, String destination, Date date_debut, Date date_fin, float prix, int id_user) {
        this.id_plan = id_plan;
        this.depart = depart;
        this.destination = destination;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.id_user = id_user;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Plan{" + "id_plan=" + id_plan + ", depart=" + depart + ", destination=" + destination + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", prix=" + prix + ", id_user=" + id_user + '}';
    }
    
    
}
