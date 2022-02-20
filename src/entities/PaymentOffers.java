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
public class PaymentOffers {
    private int id_pay_offer;
    private int id_offer;
    private int id_user;
    private String type_payment;

    public PaymentOffers() {
    }

    public PaymentOffers(int id_offer, int id_user, String type_payment) {
        this.id_offer = id_offer;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public PaymentOffers(int id_pay_offer, int id_offer, int id_user, String type_payment) {
        this.id_pay_offer = id_pay_offer;
        this.id_offer = id_offer;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public int getId_pay_offer() {
        return id_pay_offer;
    }

    public void setId_pay_offer(int id_pay_offer) {
        this.id_pay_offer = id_pay_offer;
    }

    public int getId_offer() {
        return id_offer;
    }

    public void setId_offer(int id_offer) {
        this.id_offer = id_offer;
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
        return "PaymentOffers{" + "id_pay_offer=" + id_pay_offer + ", id_offer=" + id_offer + ", id_user=" + id_user + ", type_payment=" + type_payment + '}';
    }
    
    
}
