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
public class OfferOption {
    
    private int id_offer_option;
    private int id_offer;
    private int id_bateau;
    private int id_espace;
    private int id_vol;
    private int id_hotel;
    private int id_monument;
    private int id_restaurant;
    private int id_evenement;
    private int id_plan;

    public OfferOption() {
    }

    public OfferOption(int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement,int id_plan) {
        this.id_offer = id_offer;
        this.id_bateau = id_bateau;
        this.id_espace = id_espace;
        this.id_vol = id_vol;
        this.id_hotel = id_hotel;
        this.id_monument = id_monument;
        this.id_restaurant = id_restaurant;
        this.id_evenement = id_evenement;
        this.id_plan = id_plan;
    }

    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement,int id_plan) {
        this.id_offer_option = id_offer_option;
        this.id_offer = id_offer;
        this.id_bateau = id_bateau;
        this.id_espace = id_espace;
        this.id_vol = id_vol;
        this.id_hotel = id_hotel;
        this.id_monument = id_monument;
        this.id_restaurant = id_restaurant;
        this.id_evenement = id_evenement;
        this.id_plan = id_plan;
    }
    
    

    public int getId_offer_option() {
        return id_offer_option;
    }

    public void setId_offer_option(int id_offer_option) {
        this.id_offer_option = id_offer_option;
    }

    public int getId_offer() {
        return id_offer;
    }

    public void setId_offer(int id_offer) {
        this.id_offer = id_offer;
    }

    public int getId_bateau() {
        return id_bateau;
    }

    public void setId_bateau(int id_bateau) {
        this.id_bateau = id_bateau;
    }

    public int getId_espace() {
        return id_espace;
    }

    public void setId_espace(int id_espace) {
        this.id_espace = id_espace;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
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

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    @Override
    public String toString() {
        return "OfferOption{" + "id_offer_option=" + id_offer_option + ", id_offer=" + id_offer + ", id_bateau=" + id_bateau + ", id_espace=" + id_espace + ", id_vol=" + id_vol + ", id_hotel=" + id_hotel + ", id_monument=" + id_monument + ", id_restaurant=" + id_restaurant + ", id_evenement=" + id_evenement + ", id_plan=" + id_plan + '}';
    }

    
    
    
    
}
