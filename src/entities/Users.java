/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author boukr
 */
public class Users {
    
    private int id_user;
    
    private String nom_user;
    
    private String prenom_user;
    
    private String sexe;
    
    private int numero_tel ;
    
    private String email_user ;
    
    private String pays_user;
    
    private String ville_user;

    private int code_postal;
    
    private Date date_naissance ;
    
    private int id_role;

    public Users() {
    }

    public Users(int id_user, String nom_user, String prenom_user, String sexe, int numero_tel, String email_user, String pays_user, String ville_user, int code_postal, String date_naissance, int id_role) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.sexe = sexe;
        this.numero_tel = numero_tel;
        this.email_user = email_user;
        this.pays_user = pays_user;
        this.ville_user = ville_user;
        this.code_postal = code_postal;
        Date date1=Date.valueOf(date_naissance);
        this.date_naissance = date1;
        this.id_role = id_role;
    }

    public Users(String nom_user, String prenom_user, String sexe, int numero_tel, String email_user, String pays_user, String ville_user, int code_postal, String date_naissance, int id_role) {
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.sexe = sexe;
        this.numero_tel = numero_tel;
        this.email_user = email_user;
        this.pays_user = pays_user;
        this.ville_user = ville_user;
        this.code_postal = code_postal;
        Date date1=Date.valueOf(date_naissance);
        this.date_naissance = date1;
        this.id_role = id_role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPays_user() {
        return pays_user;
    }

    public void setPays_user(String pays_user) {
        this.pays_user = pays_user;
    }

    public String getVille_user() {
        return ville_user;
    }

    public void setVille_user(String ville_user) {
        this.ville_user = ville_user;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "Users{" + "id_user=" + id_user + ", nom_user=" + nom_user + ", prenom_user=" + prenom_user + ", sexe=" + sexe + ", numero_tel=" + numero_tel + ", email_user=" + email_user + ", pays_user=" + pays_user + ", ville_user=" + ville_user + ", code_postal=" + code_postal + ", date_naissance=" + date_naissance + ", id_role=" + id_role + '}';
    }

    
}