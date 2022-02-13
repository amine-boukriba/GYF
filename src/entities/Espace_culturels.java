/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author akram
 */
public class Espace_culturels{
     private int id_espace;
     private String nom_espace;
     private String image_espace;
     private String horaire;
     private int prix;
     private int paye;
     private String date_creation;
     private String pays;
     private String localisation;
     private String description;
     private int avis_espace;

    public Espace_culturels() {
    }

    public Espace_culturels(int id_espace, String nom_espace, String image_espace, String horaire, int prix, int paye, String date_creation, String pays, String localisation, String description, int avis_espace) {
        this.id_espace = id_espace;
        this.nom_espace = nom_espace;
        this.image_espace = image_espace;
        this.horaire = horaire;
        this.prix = prix;
        this.paye = paye;
        this.date_creation = date_creation;
        this.pays = pays;
        this.localisation = localisation;
        this.description = description;
        this.avis_espace = avis_espace;
    }

    public Espace_culturels(String nom_espace, String image_espace, String horaire, int prix, int paye, String date_creation, String pays, String localisation, String description, int avis_espace) {
        this.nom_espace = nom_espace;
        this.image_espace = image_espace;
        this.horaire = horaire;
        this.prix = prix;
        this.paye = paye;
        this.date_creation = date_creation;
        this.pays = pays;
        this.localisation = localisation;
        this.description = description;
        this.avis_espace = avis_espace;
    }

    public int getId_espace() {
        return id_espace;
    }

    public String getNom_espace() {
        return nom_espace;
    }

    public String getImage_espace() {
        return image_espace;
    }

    public String getHoraire() {
        return horaire;
    }

    public int getPrix() {
        return prix;
    }

    public int getPaye() {
        return paye;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public String getPays() {
        return pays;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getDescription() {
        return description;
    }

    public int getAvis_espace() {
        return avis_espace;
    }

    public void setId_espace(int id_espace) {
        this.id_espace = id_espace;
    }

    public void setNom_espace(String nom_espace) {
        this.nom_espace = nom_espace;
    }

    public void setImage_espace(String image_espace) {
        this.image_espace = image_espace;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPaye(int paye) {
        this.paye = paye;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvis_espace(int avis_espace) {
        this.avis_espace = avis_espace;
    }

    @Override
    public String toString() {
        return "Espace_culturels{" + "id_espace=" + id_espace + ", nom_espace=" + nom_espace + ", image_espace=" + image_espace + ", horaire=" + horaire + ", prix=" + prix + ", paye=" + paye + ", date_creation=" + date_creation + ", pays=" + pays + ", localisation=" + localisation + ", description=" + description + ", avis_espace=" + avis_espace + '}';
    }
    

     
     
}
