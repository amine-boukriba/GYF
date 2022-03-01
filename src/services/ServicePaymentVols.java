/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.stripe.exception.StripeException;
import entities.PaymentBateaux;
import entities.PaymentVols;
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
public class ServicePaymentVols implements IService<PaymentVols>{

    Connection connection;

    public ServicePaymentVols() {
        connection = MyDB.getInstance().getConnection();
    }
    
    public void ajoutPay(PaymentVols t,List<String> listItems) {
        List<String> list = new ArrayList<>();
        int prix = (int)Float.parseFloat(listItems.get(0)) ;
        
//        System.out.println(prix);
//        System.out.println(listItems.get(1));
        try {
            if(t.getType_payment().equals("en ligne")){
                ServicePaymentStripe spt = new ServicePaymentStripe("annnn@gmail.com","ann",prix*100,listItems.get(1));
        
            spt.payer();
            }
            String req = "insert into payment_vols (id_vol,id_user ,type_payment) values (?,?,?)";
            
            PreparedStatement ps = connection.prepareStatement(req);
            
            ps.setInt(1, t.getId_vol());
            ps.setInt(2, t.getId_user());
            ps.setString(3, t.getType_payment());
            
            ps.executeUpdate();


            
            String reqP ="SELECT id_pay_vol ,type_payment,compagnie_aerien,prix,nom_user,prenom_user,email_user FROM payment_vols p inner join vols v on p.id_vol=v.id_vol and p.id_vol=? inner join users u on p.id_user=u.id_user and p.id_user=?";
            
            PreparedStatement ps1 = connection.prepareStatement(reqP);
            
            ps1.setInt(1, t.getId_vol());
            ps1.setInt(2,t.getId_user());
            
            ResultSet rs = ps1.executeQuery();

            
                while(rs.next()){
                list.add(0,rs.getString(1));
                list.add(1,rs.getString(2));
                list.add(2,rs.getString(3));
                list.add(3,rs.getString(4));
                list.add(4,rs.getString(5));
                list.add(5,rs.getString(6));
                list.add(6,rs.getString(7));
                list.add(7,"vol");
            }
            
            ServiceMail sm = new ServiceMail(list);
            sm.sendMail(list);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePaymentBateaux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (StripeException ex) {
            Logger.getLogger(ServicePaymentVols.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(PaymentVols t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaymentVols> affiche() {
        String req = "SELECT * FROM payment_bateaux ";
        List<PaymentVols> list = new ArrayList();
        try {
            Statement st = connection.createStatement();
            
            ResultSet rs= st.executeQuery(req);
            
            while(rs.next()){
                list.add(new PaymentVols(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePaymentBateaux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void ajout(PaymentVols t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
