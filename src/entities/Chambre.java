/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author omarb
 */
public class Chambre {
    
    
    
    private int id_chambre;
    private String type_chambre;
    private int prix_chambre;
    private int id_hotel;
    

    public Chambre(int id_chambre, String type_chambre, int prix_chambre, int id_hotel) {
        this.id_chambre = id_chambre;
        this.type_chambre = type_chambre;
        this.prix_chambre = prix_chambre;
        this.id_hotel = id_hotel;
    }

    public Chambre(String type_chambre, int prix_chambre, int id_hotel) {
        this.type_chambre = type_chambre;
        this.prix_chambre = prix_chambre;
        this.id_hotel = id_hotel;
    }
    
    public Chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public Chambre() {
    }
  

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public int getPrix_chambre() {
        return prix_chambre;
    }

    public void setPrix_chambre(int prix_chambre) {
        this.prix_chambre = prix_chambre;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }
  @Override
    public String toString() {
        return "Chambre{" + "id_chambre=" + id_chambre + ", type_chambre=" + type_chambre + ", prix_chambre=" + prix_chambre + ", id_hotel=" + id_hotel + '}';
    }
  
}
