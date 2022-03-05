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
//    private Vols vol;
//    private Bateaux bateau;
//    private Espace_culturels espace_cult;
//    private Evenement evenement;
//    private Hotel hotel;
//    private Monuments monument;
//    private restaurants restaurant;
    

    public OfferOption() {
    }

//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau, Espace_culturels espace_cult, Evenement evenement, Hotel hotel, Monuments monument, restaurants restaurant) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//        this.espace_cult = espace_cult;
//        this.evenement = evenement;
//        this.hotel = hotel;
//        this.monument = monument;
//        this.restaurant = restaurant;
//    }

    
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

//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//    }
//
//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//    }
//
//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau, Espace_culturels espace_cult) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//        this.espace_cult = espace_cult;
//    }
//
//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau, Espace_culturels espace_cult, Evenement evenement) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//        this.espace_cult = espace_cult;
//        this.evenement = evenement;
//    }
//
//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau, Espace_culturels espace_cult, Evenement evenement, Hotel hotel) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//        this.espace_cult = espace_cult;
//        this.evenement = evenement;
//        this.hotel = hotel;
//    }
//
//    public OfferOption(int id_offer_option, int id_offer, int id_bateau, int id_espace, int id_vol, int id_hotel, int id_monument, int id_restaurant, int id_evenement, int id_plan, Vols vol, Bateaux bateau, Espace_culturels espace_cult, Evenement evenement, Hotel hotel, Monuments monument) {
//        this.id_offer_option = id_offer_option;
//        this.id_offer = id_offer;
//        this.id_bateau = id_bateau;
//        this.id_espace = id_espace;
//        this.id_vol = id_vol;
//        this.id_hotel = id_hotel;
//        this.id_monument = id_monument;
//        this.id_restaurant = id_restaurant;
//        this.id_evenement = id_evenement;
//        this.id_plan = id_plan;
//        this.vol = vol;
//        this.bateau = bateau;
//        this.espace_cult = espace_cult;
//        this.evenement = evenement;
//        this.hotel = hotel;
//        this.monument = monument;
//    }
//    
    
    
    

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

//    public Vols getVol() {
//        return vol;
//    }
//
//    public void setVol(Vols vol) {
//        this.vol = vol;
//    }
//
//    public Bateaux getBateau() {
//        return bateau;
//    }
//
//    public void setBateau(Bateaux bateau) {
//        this.bateau = bateau;
//    }
//
//    public Espace_culturels getEspace_cult() {
//        return espace_cult;
//    }
//
//    public void setEspace_cult(Espace_culturels espace_cult) {
//        this.espace_cult = espace_cult;
//    }
//
//    public Evenement getEvenement() {
//        return evenement;
//    }
//
//    public void setEvenement(Evenement evenement) {
//        this.evenement = evenement;
//    }
//
//    public Hotel getHotel() {
//        return hotel;
//    }
//
//    public void setHotel(Hotel hotel) {
//        this.hotel = hotel;
//    }
//
//    public Monuments getMonument() {
//        return monument;
//    }
//
//    public void setMonument(Monuments monument) {
//        this.monument = monument;
//    }
//
//    public restaurants getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(restaurants restaurant) {
//        this.restaurant = restaurant;
//    }

    @Override
    public String toString() {
        return "OfferOption{" + "id_offer_option=" + id_offer_option + ", id_offer=" + id_offer + ", id_bateau=" + id_bateau + ", id_espace=" + id_espace + ", id_vol=" + id_vol + ", id_hotel=" + id_hotel + ", id_monument=" + id_monument + ", id_restaurant=" + id_restaurant + ", id_evenement=" + id_evenement + ", id_plan=" + id_plan + '}';
    }

   
    

   

    
    
    
    
}
