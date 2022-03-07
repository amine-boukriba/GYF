/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author anwer
 */
public class Images {
    private int id_image;
    private String path;
    private int id_espace_culturels;
    private int id_evenement;
    private int id_hotel;
    private int id_monument;
    private int id_offer;
    private int id_restaurant;

    public Images() {
    }

    public Images(String path, int id_espace_culturels, int id_evenement, int id_hotel, int id_monument, int id_offer, int id_restaurant) {
        this.path = path;
        this.id_espace_culturels = id_espace_culturels;
        this.id_evenement = id_evenement;
        this.id_hotel = id_hotel;
        this.id_monument = id_monument;
        this.id_offer = id_offer;
        this.id_restaurant = id_restaurant;
    }

    public Images(int id_image, String path, int id_espace_culturels, int id_evenement, int id_hotel, int id_monument, int id_offer, int id_restaurant) {
        this.id_image = id_image;
        this.path = path;
        this.id_espace_culturels = id_espace_culturels;
        this.id_evenement = id_evenement;
        this.id_hotel = id_hotel;
        this.id_monument = id_monument;
        this.id_offer = id_offer;
        this.id_restaurant = id_restaurant;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId_espace_culturels() {
        return id_espace_culturels;
    }

    public void setId_espace_culturels(int id_espace_culturels) {
        this.id_espace_culturels = id_espace_culturels;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public int getId_monument() {
        return id_monument;
    }

    public void setId_monument(int id_monument) {
        this.id_monument = id_monument;
    }

    public int getId_offer() {
        return id_offer;
    }

    public void setId_offer(int id_offer) {
        this.id_offer = id_offer;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    @Override
    public String toString() {
        return "Images{" + "id_image=" + id_image + ", path=" + path + ", id_espace_culturels=" + id_espace_culturels + ", id_evenement=" + id_evenement + ", id_hotel=" + id_hotel + ", id_monument=" + id_monument + ", id_offer=" + id_offer + ", id_restaurant=" + id_restaurant + '}';
    }
    
    
    
}
