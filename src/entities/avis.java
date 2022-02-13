/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class avis {
    private int id_avis;
    private int nombre_etoile;
    private String description;
    private int id_user;
    private int cible_avis;
    private int type_avis;

    public avis() {
    }

    public avis(int id_avis, int nombre_etoile, String description, int id_user, int cible_avis, int type_avis) {
        this.id_avis = id_avis;
        this.nombre_etoile = nombre_etoile;
        this.description = description;
        this.id_user = id_user;
        this.cible_avis = cible_avis;
        this.type_avis = type_avis;
    }

    public avis(int nombre_etoile, String description, int id_user, int cible_avis, int type_avis) {
        this.nombre_etoile = nombre_etoile;
        this.description = description;
        this.id_user = id_user;
        this.cible_avis = cible_avis;
        this.type_avis = type_avis;
    }

    public int getId_avis() {
        return id_avis;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    public int getNombre_etoile() {
        return nombre_etoile;
    }

    public void setNombre_etoile(int nombre_etoile) {
        this.nombre_etoile = nombre_etoile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getCible_avis() {
        return cible_avis;
    }

    public void setCible_avis(int cible_avis) {
        this.cible_avis = cible_avis;
    }

    public int getType_avis() {
        return type_avis;
    }

    public void setType_avis(int type_avis) {
        this.type_avis = type_avis;
    }

    @Override
    public String toString() {
        return "avis{" + "id_avis=" + id_avis + ", nombre_etoile=" + nombre_etoile + ", description=" + description + ", id_user=" + id_user + ", cible_avis=" + cible_avis + ", type_avis=" + type_avis + '}';
    }
    
    
}
