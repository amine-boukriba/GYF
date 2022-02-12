/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author boukr
 */
public class Users {
    
    private int id;
    
    private String First_name;
    
    private String Last_name;
    
    private String sexe;
    
    private int tel;
    
    private String email;
    
    private String pays;
private String ville;
private int zip;
private Date date;
private int id_role;

    public Users(int id, String First_name, String Last_name, String sexe, int tel, String email, String pays, String ville, int zip, Date date, int id_role) {
        this.id = id;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.sexe = sexe;
        this.tel = tel;
        this.email = email;
        this.pays = pays;
        this.ville = ville;
        this.zip = zip;
        this.date = date;
        this.id_role = id_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String First_name) {
        this.First_name = First_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", sexe=" + sexe + ", tel=" + tel + ", email=" + email + ", pays=" + pays + ", ville=" + ville + ", zip=" + zip + ", date=" + date + ", id_role=" + id_role + '}';
    }


}
