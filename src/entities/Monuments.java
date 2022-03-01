
package entities;


public class Monuments {
     private int id_monument;
     private String nom_monument;
     private String image_monument;
     private Boolean payant;
     private int prix;
     private String description;
     private String date_creation;
     private String pays;
     private String localisation;
     private int avis_monument;

    public Monuments() {
    }

    public Monuments(int id_monument, String nom_monument, String image_monument, Boolean payant, int prix, String description, String date_creation, String pays, String localisation, int avis_monument) {
        this.id_monument = id_monument;
        this.nom_monument = nom_monument;
        this.image_monument = image_monument;
        this.payant = payant;
        this.prix = prix;
        this.description = description;
        this.date_creation = date_creation;
        this.pays = pays;
        this.localisation = localisation;
        this.avis_monument = avis_monument;
    }
    public Monuments( String nom_monument, String image_monument, Boolean payant, int prix, String description, String date_creation, String pays, String localisation, int avis_monument) {
        
        this.nom_monument = nom_monument;
        this.image_monument = image_monument;
        this.payant = payant;
        this.prix = prix;
        this.description = description;
        this.date_creation = date_creation;
        this.pays = pays;
        this.localisation = localisation;
        this.avis_monument = avis_monument;
    }

    public int getId_monument() {
        return id_monument;
    }

    public String getNom_monument() {
        return nom_monument;
    }

    public String getImage_monument() {
        return image_monument;
    }

    public Boolean getPayant() {
        return payant;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
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

    public int getAvis_monument() {
        return avis_monument;
    }

    public void setId_monument(int id_monument) {
        this.id_monument = id_monument;
    }

    public void setNom_monument(String nom_monument) {
        this.nom_monument = nom_monument;
    }

    public void setImage_monument(String image_monument) {
        this.image_monument = image_monument;
    }

    public void setPayant(Boolean payant) {
        this.payant = payant;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setAvis_monument(int avis_monument) {
        this.avis_monument = avis_monument;
    }

    @Override
    public String toString() {
        return "Monument{" + "id_monument=" + id_monument + ", nom_monument=" + nom_monument + ", image_monument=" + image_monument + ", payant=" + payant + ", prix=" + prix + ", description=" + description + ", date_creation=" + date_creation + ", pays=" + pays + ", localisation=" + localisation + ", avis_monument=" + avis_monument + '}';
    }
    
     
}
