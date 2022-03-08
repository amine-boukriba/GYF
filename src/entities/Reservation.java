/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author akram
 */
public class Reservation {
    private int id;
    private int user;
    private Boolean type;
    private int id_esp;
    private int num_card;
    private String Date_reservation;
    private String card_password;

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public int getId_esp() {
        return id_esp;
    }

    public void setId_esp(int id_esp) {
        this.id_esp = id_esp;
    }

    public int getNum_card() {
        return num_card;
    }

    public void setNum_card(int num_card) {
        this.num_card = num_card;
    }

    public String getDate_reservation() {
        return Date_reservation;
    }

    public void setDate_reservation(String Date_reservation) {
        this.Date_reservation = Date_reservation;
    }

    public String getCard_password() {
        return card_password;
    }

    public void setCard_password(String card_password) {
        this.card_password = card_password;
    }
    
    
    
}
