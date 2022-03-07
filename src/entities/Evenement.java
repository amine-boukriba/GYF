/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.sql.Date;
/**
 *
 * @author moham
 */
public class Evenement { 
     public int id_evenement;
     private String nom;
     private String description;
     private String type;
     private String image;
     private Date date_debut;
     private Date date_fin;
     private String pays;
     private int  prix;
     private int nbre_participants;
     private String localisation;
     public Evenement() {
    }
     public Evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public Evenement(String nom, String description, String type, String image, Date date_debut, Date date_fin, String pays, int prix, int nbre_participants, String localisation) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.image = image;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.pays = pays;
        this.prix = prix;
        this.nbre_participants = nbre_participants;
        this.localisation=localisation;
    }

    public Evenement(int id_evenement, String nom, String description, String type, String image, Date date_debut, Date date_fin, String pays, int prix, int nbre_participants, String localisation) {
        this.id_evenement = id_evenement;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.image = image;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.pays = pays;
        this.prix = prix;
        this.nbre_participants = nbre_participants;
        this.localisation = localisation;
    }
    
     
   

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getPrix() {
        return prix;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public int getId_event() {
        return id_evenement;
    }

    public String getImage() {
        return image;
    }

    public int getNbre_participants() {
        return nbre_participants;
    }

    public String getPays() {
        return pays;
    }

    public void setId_event(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbre_participants(int nbre_participants) {
        this.nbre_participants = nbre_participants;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    
     
    @Override
    public String toString() {
        return "evenement:\n id :"+this.id_evenement+"\n nom :"+this.nom+"\ndescription :"+this.description+"\ntype :"+this.type+"\npays :"+this.pays+"\nlocalisation :"+this.localisation+"\nprix :"+this.prix+"\ndate début :"+this.date_debut+"\ndate fin :"+this.date_fin+"\nnobre de participants :"+this.nbre_participants+"\nImage :"+this.image; //To change body of generated methods, choose Tools | Templates.
    }

 
     
     
}
