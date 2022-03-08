
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.stripe.exception.StripeException;
import entities.Bateaux;
import entities.Images;
import entities.OfferOption;
import entities.Offers;
import entities.PaymentBateaux;
import entities.PaymentOffers;
import entities.PaymentPlan;
import entities.PaymentVols;
import entities.Plan;
import entities.Vols;
import java.sql.Date;
import services.ServiceBateaux;
import services.ServiceImages;
import services.ServiceMail;
import services.ServiceOfferOption;
import services.ServiceOffers;
import services.ServicePaymentBateaux;
import services.ServicePaymentOffers;
import services.ServicePaymentPlan;
import services.ServicePaymentStripe;
import services.ServicePaymentVols;
import services.ServicePlan;
import services.ServiceVols;
import utils.MyDB;

/**
 *
 * @author anwer
 */
public class Main {

    public static void main(String[] args) throws StripeException{
        //********************** MAIL ****************************
        //ServiceMail.sendMail("anwerboubaker3@gmail.com");
        //********************** VOLS ****************************
        
        ServiceVols sv = new ServiceVols();
        //System.out.println(sv.affiche());
        //sv.ajout(new Vols("tun","12","fr",Date.valueOf("2020-02-12"),new Date(1),12.6f,3,"arbus","azdsd",5));
        //sv.rechercheVols("22", "ita");
        //sv.modifier(new Vols(1,"tun","22","ita",new Date(999999999),new Date(999999999),12.69f,3,"arbus","azdsd",5));
        //sv.supprime(2);
        //System.out.println(sv.filtrePrix(1, 133));
        
        //********************** BATEAUX ****************************
        
        ServiceBateaux sb = new ServiceBateaux();
        //sb.ajout(new Bateaux("tun","12","fr",new Date(500),new Date(600),14.6f,3,"arbus","azdsd",5));
        //sb.modifier(new Bateaux(1,"fr","14","al",new Date(500),new Date(600),14.6f,3,"edward","azdsd",5));
        //sb.supprime(3);
        //System.out.println(sb.getOne(1));
        
        //********************** OFFERS ****************************
        
        ServiceOffers sf = new ServiceOffers();
        //sf.ajout(new Offers("titre","fr","alg",new Date(1),new Date(1),6,"description",72.1f,4));
        //sf.modifier(new Offers(1,"titre","fr","alg",new Date(1),new Date(1),6,"description",72.1f,4));
        //sf.supprime(1);
        //System.out.println(sf.affiche());
        //System.out.println(sf.rechercheOffers("fr", "ing", Date.valueOf("1970-01-01")));
        
        //********************** IMAGES ****************************
        ServiceImages si = new ServiceImages();
        //si.ajout(new Images("adaz",1,1,1,1,3,1));
        //********************** OFFER/PLAN OPTION ****************************
        
        ServiceOfferOption so = new ServiceOfferOption();
        System.out.println(so.getOffers(35));
        //so.ajout(new OfferOption(0,1,1,1,1,1,1,1,4));
        
        //********************** PLAN ****************************
        ServicePlan sp = new ServicePlan();
        
        //sp.ajout(new Plan("azdda","dazdaz",Date.valueOf("2020-12-12"),Date.valueOf("2020-12-03"),12.2f,2));
        //sp.modifier(new Plan(3,"aaaaa","aaaa",Date.valueOf("2020-12-12"),Date.valueOf("2020-12-03"),12.2f,2));
        //sp.supprime(3);
        
        //********************** PAYMENT BATAUX ****************************
        
        ServicePaymentBateaux spb = new ServicePaymentBateaux();
        //spb.ajout(new PaymentBateaux(1,2,"agence"));
        //System.out.println(spb.affiche());
        
        //********************** PAYMENT VOLS ****************************
        
        ServicePaymentVols spv = new ServicePaymentVols();
        //spv.ajout(new PaymentVols(1,2,"agence"));
        //System.out.println(spv.affiche());
        
        //********************** PAYMENT OFFERS ****************************
        
        ServicePaymentOffers spo = new ServicePaymentOffers();
        //spo.ajout(new PaymentOffers(4,2,"en ligne"));
        //System.out.println(spv.affiche());
        
        //********************** PAYMENT PLAN ****************************
        
        ServicePaymentPlan spp = new ServicePaymentPlan();
        //spp.ajout(new PaymentPlan(4,2,"agence"));
        
        //********************** PAYMENT STRIPE ****************************
//        ServicePaymentStripe spt = new ServicePaymentStripe("annnn@gmail.com","ann",2000,"4111111111111111");
//        spt.payer();
    }
    
}
