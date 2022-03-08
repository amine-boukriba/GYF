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
public class PaymentPlan {
    private int id_pay_plan;
    private int id_plan;
    private int id_user;
    private String type_payment;

    public PaymentPlan() {
    }

    public PaymentPlan(int id_plan, int id_user, String type_payment) {
        this.id_plan = id_plan;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public PaymentPlan(int id_pay_plan, int id_plan, int id_user, String type_payment) {
        this.id_pay_plan = id_pay_plan;
        this.id_plan = id_plan;
        this.id_user = id_user;
        this.type_payment = type_payment;
    }

    public int getId_pay_plan() {
        return id_pay_plan;
    }

    public void setId_pay_plan(int id_pay_plan) {
        this.id_pay_plan = id_pay_plan;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
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
        return "PaymentPlan{" + "id_pay_plan=" + id_pay_plan + ", id_plan=" + id_plan + ", id_user=" + id_user + ", type_payment=" + type_payment + '}';
    }
    
    
}
