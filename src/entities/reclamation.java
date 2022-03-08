/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class reclamation {

    
     private int id_reclamation;
     private String description;
      private String nom;
       private String prenom;
        private String email;
     private String date_creation;
     private String date_traitement;
     private String status; 
     private String image_reclamation; 
     private int cible_reclamation; 
     private String type_reclamation; 
     private int id_user; 
     public reclamation() {
    }

    public reclamation(int id_reclamation, String description, String nom, String prenom, String email, String date_creation, String date_traitement, String status, String image_reclamation, int cible_reclamation, String type_reclamation, int id_user) {
        this.id_reclamation = id_reclamation;
        this.description = description;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_creation = date_creation;
        this.date_traitement = date_traitement;
        this.status = status;
        this.image_reclamation = image_reclamation;
        this.cible_reclamation = cible_reclamation;
        this.type_reclamation = type_reclamation;
        this.id_user = id_user;
    }

    public reclamation(String description, String nom, String prenom, String email, String date_creation, String date_traitement, String status, String image_reclamation, int cible_reclamation, String type_reclamation, int id_user) {
        this.description = description;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_creation = date_creation;
        this.date_traitement = date_traitement;
        this.status = status;
        this.image_reclamation = image_reclamation;
        this.cible_reclamation = cible_reclamation;
        this.type_reclamation = type_reclamation;
        this.id_user = id_user;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDate_traitement() {
        return date_traitement;
    }

    public void setDate_traitement(String date_traitement) {
        this.date_traitement = date_traitement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage_reclamation() {
        return image_reclamation;
    }

    public void setImage_reclamation(String image_reclamation) {
        this.image_reclamation = image_reclamation;
    }

    public int getCible_reclamation() {
        return cible_reclamation;
    }

    public void setCible_reclamation(int cible_reclamation) {
        this.cible_reclamation = cible_reclamation;
    }

    public String getType_reclamation() {
        return type_reclamation;
    }

    public void setType_reclamation(String type_reclamation) {
        this.type_reclamation = type_reclamation;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id_reclamation=" + id_reclamation + ", description=" + description + ", nom=" + nom + ", prenom=" +
                prenom + ", email=" + email + ", date_creation=" + date_creation + ", date_traitement=" + date_traitement + ", status=" +
                status + ", image_reclamation=" + image_reclamation + ", cible_reclamation=" + cible_reclamation + ", type_reclamation=" +
                type_reclamation + ", id_user=" + id_user + '}';
    }

    public void setType_reclamation(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     
}