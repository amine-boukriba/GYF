/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.sql.Date;
/**
 *
 * @author moham
 */
public class ResEvents {

    public ResEvents(int id_re_event) {
        this.id_re_event = id_re_event;
    }
    private int id_re_event;
    private int payment_event;
    private int  id_user;
    private int id_evenement;
    private Date date_expiration;

    public ResEvents() {
    }

    public ResEvents(int payment_event, int id_user, int id_evenement, Date date_expiration) {
        this.payment_event = payment_event;
        this.id_user = id_user;
        this.id_evenement = id_evenement;
        this.date_expiration = date_expiration;
    }

    public ResEvents(int id_re_event, int payment_event, int id_user, int id_evenement, Date date_expiration) {
        this.id_re_event = id_re_event;
        this.payment_event = payment_event;
        this.id_user = id_user;
        this.id_evenement = id_evenement;
        this.date_expiration = date_expiration;
    }

    public int getId_re_event() {
        return id_re_event;
    }

    public int getPayment_event() {
        return payment_event;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setId_re_event(int id_re_event) {
        this.id_re_event = id_re_event;
    }

    public void setPayment_event(int payment_event) {
        this.payment_event = payment_event;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    @Override
    public String toString() {
        return "ResEvents{" + "id_re_event=" + id_re_event + ", payment_event=" + payment_event + ", id_user=" + id_user + ", id_evenement=" + id_evenement + ", date_expiration=" + date_expiration + '}';
    }
    
   
    
    
    
}
