/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Bateaux;
import entities.Espace_culturels;
import entities.Evenement;
import entities.Hotel;
import entities.Monuments;
import entities.OfferOption;
import entities.Offers;
import entities.Vols;
import entities.restaurants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author anwer
 */
public class ServiceOfferOption implements IService<OfferOption>{

    Connection connection;
    
    public ServiceOfferOption() {
        connection = MyDB.getInstance().getConnection();
    }
    
    public List<OfferOption> getOffers(int id){
        List <OfferOption> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM offer_option where id_offer = "+id+"";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                list.add(new OfferOption(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
//            if(list.get(0).getId_vol()!=0){
//                list.clear();
//                String req1 ="SELECT *  FROM Vols    where id_vol="+list.get(0).getId_vol()+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_depart"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("type_avion"),rs1.getInt("avis_vol"))));
//            }
//            }
//            if(list.get(0).getId_bateau()!=0){
//                list.clear();
//                String req1 ="SELECT *  FROM bateaux where id_bateau="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau"))));
//            }
//            }
//             if(list.get(0).getId_vol()!=0&&list.get(0).getId_bateau()!=0&&list.get(0).getId_espace()!=0){
//                 list.clear();
//                String req1 ="SELECT * FROM `offer_option` inner join vols USING(id_vol) INNER join bateaux using(id_bateau) inner join espace_culturels using(id_espace) where offer_option.id_offer="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau")),
//                        new Espace_culturels(rs1.getInt("id_espace"),rs1.getString("nom_espace"),rs1.getString("image_espace"),rs1.getString("horaire"),rs1.getInt("prix"),rs1.getInt("paye"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getString("description"),rs1.getInt("avis_espace"))));
//            }
//            }
//             if(list.get(0).getId_vol()!=0&&list.get(0).getId_bateau()!=0&&list.get(0).getId_espace()!=0&&list.get(0).getId_evenement()!=0){
//                 list.clear();
//                String req1 ="SELECT * FROM `offer_option` inner join vols USING(id_vol) INNER join bateaux using(id_bateau) inner join espace_culturels using(id_espace)  inner join evenement using(id_evenement) where offer_option.id_offer="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau")),
//                        new Espace_culturels(rs1.getInt("id_espace"),rs1.getString("nom_espace"),rs1.getString("image_espace"),rs1.getString("horaire"),rs1.getInt("prix"),rs1.getInt("paye"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getString("description"),rs1.getInt("avis_espace")),
//                        new Evenement(rs1.getInt("id_evenement"),rs1.getString("nom_evenement"),rs1.getString("description"),rs1.getString("type_evenement"),rs1.getString("localisation"),rs1.getString("image_evenement"),rs1.getDate("date_debut"),rs1.getDate("date_fin"),rs1.getString("pays"),rs1.getInt("nombre_participants"),rs1.getInt("prix"))));
//            }
//            }
//             if(list.get(0).getId_vol()!=0&&list.get(0).getId_bateau()!=0&&list.get(0).getId_espace()!=0&&list.get(0).getId_evenement()!=0&&list.get(0).getId_hotel()!=0){
//                 list.clear();
//                String req1 ="SELECT * FROM `offer_option` inner join vols USING(id_vol) INNER join bateaux using(id_bateau) inner join espace_culturels using(id_espace)  inner join evenement using(id_evenement) inner join hotels using (id_hotel) where offer_option.id_offer="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau")),
//                        new Espace_culturels(rs1.getInt("id_espace"),rs1.getString("nom_espace"),rs1.getString("image_espace"),rs1.getString("horaire"),rs1.getInt("prix"),rs1.getInt("paye"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getString("description"),rs1.getInt("avis_espace")),
//                        new Evenement(rs1.getInt("id_evenement"),rs1.getString("nom_evenement"),rs1.getString("description"),rs1.getString("type_evenement"),rs1.getString("localisation"),rs1.getString("image_evenement"),rs1.getDate("date_debut"),rs1.getDate("date_fin"),rs1.getString("pays"),rs1.getInt("nombre_participants"),rs1.getInt("prix")),
//                        new Hotel(rs1.getInt("id_hotel"),rs1.getString("nom_hotel"),rs1.getString("localisation"),rs1.getString("categorie"),rs1.getInt("avis_hotel"),rs1.getString("image_hotel"))));
//            }
//            }
//             if(list.get(0).getId_vol()!=0&&list.get(0).getId_bateau()!=0&&list.get(0).getId_espace()!=0&&list.get(0).getId_evenement()!=0&&list.get(0).getId_hotel()!=0&&list.get(0).getId_monument()!=0){
//                 list.clear();
//                String req1 ="SELECT * FROM `offer_option` inner join vols USING(id_vol) INNER join bateaux using(id_bateau) inner join espace_culturels using(id_espace)  inner join evenement using(id_evenement) inner join hotels using (id_hotel) inner join monuments using(id_monument)  where offer_option.id_offer="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau")),
//                        new Espace_culturels(rs1.getInt("id_espace"),rs1.getString("nom_espace"),rs1.getString("image_espace"),rs1.getString("horaire"),rs1.getInt("prix"),rs1.getInt("paye"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getString("description"),rs1.getInt("avis_espace")),
//                        new Evenement(rs1.getInt("id_evenement"),rs1.getString("nom_evenement"),rs1.getString("description"),rs1.getString("type_evenement"),rs1.getString("localisation"),rs1.getString("image_evenement"),rs1.getDate("date_debut"),rs1.getDate("date_fin"),rs1.getString("pays"),rs1.getInt("nombre_participants"),rs1.getInt("prix")),
//                        new Hotel(rs1.getInt("id_hotel"),rs1.getString("nom_hotel"),rs1.getString("localisation"),rs1.getString("categorie"),rs1.getInt("avis_hotel"),rs1.getString("image_hotel")),
//                        new Monuments(rs1.getInt("id_monument"),rs1.getString("nom_monument"),rs1.getString("image_monument"),rs1.getInt("payant"),rs1.getInt("prix"),rs1.getString("description"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getInt("avis_monument"))));
//            }
//            }
//              if(list.get(0).getId_vol()!=0&&list.get(0).getId_bateau()!=0&&list.get(0).getId_espace()!=0&&list.get(0).getId_evenement()!=0&&list.get(0).getId_hotel()!=0&&list.get(0).getId_monument()!=0&&list.get(0).getId_restaurant()!=0){
//                 list.clear();
//                String req1 ="SELECT * FROM `offer_option` inner join vols USING(id_vol) INNER join bateaux using(id_bateau) inner join espace_culturels using(id_espace)  inner join evenement using(id_evenement) inner join hotels using (id_hotel) inner join monuments using(id_monument) inner join restaurants using(id_restaurant) where offer_option.id_offer ="+id+"";
//                Statement st1 = connection.createStatement();
//                ResultSet rs1 = st.executeQuery(req1);
//                System.out.println("azdazdazd");
//                while (rs1.next()){
//                     
//                list.add(new OfferOption(rs1.getInt("id_offer_option"),rs1.getInt("id_offer"),rs1.getInt("id_bateau"),rs1.getInt("id_espace"),rs1.getInt("id_vol"),rs1.getInt("id_hotel"),rs1.getInt("id_monument"),rs1.getInt("id_restaurant"),rs1.getInt("id_evenement"),rs1.getInt("id_plan"),
//                        new Vols(rs1.getInt("id_vol"),rs1.getString("compagnie_aerien"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("type_avion"),rs1.getString("image_vol"),rs1.getInt("avis_vol")),
//                        new Bateaux(rs1.getInt("id_bateau"),rs1.getString("compagnie_maritime"),rs1.getString("depart"),rs1.getString("destination"),rs1.getDate("date_depart"),rs1.getDate("date_arrive"),rs1.getInt("prix"),rs1.getInt("duree"),rs1.getString("nom_bateau"),rs1.getString("image_bateau"),rs1.getInt("image_bateau")),
//                        new Espace_culturels(rs1.getInt("id_espace"),rs1.getString("nom_espace"),rs1.getString("image_espace"),rs1.getString("horaire"),rs1.getInt("prix"),rs1.getInt("paye"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getString("description"),rs1.getInt("avis_espace")),
//                        new Evenement(rs1.getInt("id_evenement"),rs1.getString("nom_evenement"),rs1.getString("description"),rs1.getString("type_evenement"),rs1.getString("localisation"),rs1.getString("image_evenement"),rs1.getDate("date_debut"),rs1.getDate("date_fin"),rs1.getString("pays"),rs1.getInt("nombre_participants"),rs1.getInt("prix")),
//                        new Hotel(rs1.getInt("id_hotel"),rs1.getString("nom_hotel"),rs1.getString("localisation"),rs1.getString("categorie"),rs1.getInt("avis_hotel"),rs1.getString("image_hotel")),
//                        new Monuments(rs1.getInt("id_monument"),rs1.getString("nom_monument"),rs1.getString("image_monument"),rs1.getInt("payant"),rs1.getInt("prix"),rs1.getString("description"),rs1.getString("date_creation"),rs1.getString("pays"),rs1.getString("localisation"),rs1.getInt("avis_monument")),
//                        new restaurants(rs1.getInt("id_restaurant"),rs1.getString("nom_restaurant"),rs1.getString("localisation"),rs1.getString("horaire"),rs1.getString("numero_restaurant"),rs1.getString("cuisinies"),rs1.getInt("nombre_fourchet"),rs1.getInt("avis_restaurant"),rs1.getString("image_restaurant"))));
//            }
//            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public void ajout(OfferOption t) {
        try {
            String req = "insert into offer_option (id_offer,id_bateau,id_espace,id_vol,id_hotel,id_monument,id_restaurant,id_evenement,id_plan) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            if(t.getId_offer() == 0){
                ps.setNull(1, 0);
            }else{
                ps.setInt(1, t.getId_offer());
            }
            if(t.getId_bateau() ==0){
                ps.setNull(2, 0);
            }else{
                ps.setInt(2, t.getId_bateau());
            }
            if(t.getId_espace()==0){
                ps.setNull(3, 0);
            }else{
                ps.setInt(3, t.getId_espace());
            }
            if(t.getId_vol()==0){
                ps.setNull(4, 0);
            }else{
                ps.setInt(4, t.getId_vol());
            }
            if(t.getId_hotel()==0){
                ps.setNull(5, 0);
            }else{
                ps.setInt(5, t.getId_hotel());
            }
            if(t.getId_monument()==0){
                 ps.setNull(6, 0);
            }else{
                ps.setInt(6, t.getId_monument());
            }
            if(t.getId_restaurant()==0){
                 ps.setNull(7, 0);
            }else{
                ps.setInt(7, t.getId_restaurant());
            }
            if(t.getId_evenement()==0){
                 ps.setNull(8, 0);
            }else{
                ps.setInt(8, t.getId_evenement());
            }
            if(t.getId_plan() == 0){
                ps.setNull(9, 0);
            }else{
                ps.setInt(9, t.getId_plan());
            }
            
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(OfferOption t) {
        try {
            String req ="update offer_option set id_bateau =?,id_espace =? ,id_vol =?,id_hotel=?,id_monument =?,id_monument =?,id_evenement =? where id_offer_option =?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, t.getId_bateau());
            ps.setInt(2, t.getId_espace());
            ps.setInt(3, t.getId_vol());
            ps.setInt(4, t.getId_hotel());
            ps.setInt(5, t.getId_monument());
            ps.setInt(6, t.getId_restaurant());
            ps.setInt(7, t.getId_evenement());
            ps.setInt(8, t.getId_offer_option());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprime(int id) {
        
        try {
            String req = "delete from offer_option where id_offer_option ="+id+"";
            Statement st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OfferOption> affiche() {
        List<OfferOption> list = new ArrayList<>();
        try {
            String req = "select * from offer_option";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                list.add(new OfferOption(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOfferOption.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);
        return list;
    }
    
}
