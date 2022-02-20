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
public interface IIService<T> { 
      
    public void ajout(T t);
    public void modifier(T t);
    public void supprime(int id);
    public List<T> affiche();
    public List<T> afficheByName(String nom_restaurant);
    public List<T> afficheBylocalisation(String localisation);
    public List<T> afficheBycuisinies(String cuisinies);

    
}


