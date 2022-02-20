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
public interface IIIService<T> {
        public void ajout(T t);
    public void modifier(T t);
    public void supprime(int id);
    public List<T> affiche();
    public List<T> afficheBynom_hotel(String nom_hotel);
    public List<T> affichePrix_chambreHotel(String nom_hotel);

}
