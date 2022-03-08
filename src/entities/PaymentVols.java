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
public class PaymentVols {
    private int id_pay_vol;
    private int id_vol;
    private int id_user;
    private String type_payment;

    public PaymentVols() {
    }

    public PaymentVols(int id_vol, int id_user, String type_payment) {
        this.id_vol = id_vol;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public PaymentVols(int id_pay_vol, int id_vol, int id_user, String type_payment) {
        this.id_pay_vol = id_pay_vol;
        this.id_vol = id_vol;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public int getId_pay_vol() {
        return id_pay_vol;
    }

    public void setId_pay_vol(int id_pay_vol) {
        this.id_pay_vol = id_pay_vol;
    }

    public int getId_vol() {
        return id_vol;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
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
        return "PaymentVols{" + "id_pay_vol=" + id_pay_vol + ", id_vol=" + id_vol + ", id_user=" + id_user + ", type_payment=" + type_payment + '}';
    }
    
    
}
