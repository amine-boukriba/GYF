/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Bateaux;
import entities.Offers;
import entities.Vols;
import java.sql.Date;
import services.ServiceBateaux;
import services.ServiceOffers;
import services.ServiceVols;
import utils.MyDB;

/**
 *
 * @author anwer
 */
public class Main {

    public static void main(String[] args){
        
        //********************** VOLS ****************************
        
        ServiceVols sv = new ServiceVols();
        //sv.ajout(new Vols("tun","12","fr",new Date(1),new Date(1),12.6f,3,"arbus","azdsd",5));
        //sv.modifier(new Vols(1,"tun","22","ita",new Date(999999999),new Date(999999999),12.69f,3,"arbus","azdsd",5));
        //sv.supprime(2);
        //System.out.println(sv.affiche());
        
        //********************** BATEAUX ****************************
        
        ServiceBateaux sb = new ServiceBateaux();
        //sb.ajout(new Bateaux("tun","12","fr",new Date(500),new Date(600),14.6f,3,"arbus","azdsd",5));
        //sb.modifier(new Bateaux(1,"fr","14","al",new Date(500),new Date(600),14.6f,3,"edward","azdsd",5));
        //sb.supprime(3);
        //System.out.println(sb.affiche());
        
        //********************** OFFERS ****************************
        
        ServiceOffers sf = new ServiceOffers();
        //sf.ajout(new Offers("titre","fr","alg",new Date(1),new Date(1),6,"description",72.1f,"azdzadaz",4,1,1,1,1,1,1));
        //sf.modifier(new Offers(1,"titre","fr","ing",new Date(1),new Date(1),10,"description",72.1f,"a",4,1,1,1,1,1,1));
        //sf.supprime(2);
        System.out.println(sf.affiche());
    }
    
}
