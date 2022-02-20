/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author omarb
 */
public interface IVService<T> {
    public void AjoutReservationHotel(T t);
    public void modifierReservationHotel(T t);
     public List<T> AfficherReservationHotel();
    public List<T> AfficherReservationHotelByName(String nom_restaurant);
    /////////////////////////////////////////////////
    public void AjoutReservationRestaurant(T t);
    public void modifierReservationRestaurant(T t);
       public List<T> AfficherReservationRestaurant();
    public List<T> AfficherReservationRestaurantByName(String nom_hotel);
    ////////////////////////////////////////////////////////
    public List<T> afficheReservation();
   public void supprimerReservation(int id);
}
