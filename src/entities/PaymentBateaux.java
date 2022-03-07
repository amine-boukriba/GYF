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
public class PaymentBateaux {
    private int id_pay_bateau;
    private int id_bateau;
    private int id_user;
    private String type_payment;

    
    public PaymentBateaux() {
    }

    public PaymentBateaux(int id_bateau, int id_user, String type_payment) {
        this.id_bateau = id_bateau;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public PaymentBateaux(int id_pay_bateau, int id_bateau, int id_user, String type_payment) {
        this.id_pay_bateau = id_pay_bateau;
        this.id_bateau = id_bateau;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public int getId_pay_bateau() {
        return id_pay_bateau;
    }

    public void setId_pay_bateau(int id_pay_bateau) {
        this.id_pay_bateau = id_pay_bateau;
    }

    public int getId_bateau() {
        return id_bateau;
    }

    public void setId_bateau(int id_bateau) {
        this.id_bateau = id_bateau;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getType_payment() {
        return type_payment;
    }

    public void setType_payment(String type_payment) {
        this.type_payment = type_payment;
    }

    @Override
    public String toString() {
        return "PaymentBateaux{" + "id_pay_bateau=" + id_pay_bateau + ", id_bateau=" + id_bateau + ", id_user=" + id_user + ", type_payment=" + type_payment + '}';
    }
    
    
}
