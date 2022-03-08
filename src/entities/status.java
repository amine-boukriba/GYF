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
public class status {
    private int id_status;
    private String nom_status;
    private String message;
    private int id_reclamation;

    public status() {
    }

    public status(int id_status, String nom_status) {
        this.id_status = id_status;
        this.nom_status = nom_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    
    public status(String nom_status) {
        this.nom_status = nom_status;
    }

    public int getId_status() {
        return id_status;
    }

    public void setId_status(int id_status) {
        this.id_status = id_status;
    }

    public String getNom_status() {
        return nom_status;
    }

    public void setNom_status(String nom_status) {
        this.nom_status = nom_status;
    }

    @Override
    public String toString() {
        return "status{" + "id_status=" + id_status + ", nom_status=" + nom_status + '}';
    }
    
}
