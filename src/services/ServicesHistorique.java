/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Historiques;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author boukr
 */
public class ServicesHistorique {
      Connection cnx;
    public ServicesHistorique(){
    cnx=MyDB.getInstance().getConnection();  }
    void add_session(Historiques h){
        LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    h.setEntre_date(formattedDate);
    
    }
    void calcul_duration(Historiques h){
    
    
          try {
              SimpleDateFormat sdf
                      = new SimpleDateFormat(
                              "dd-MM-yyyy HH:mm:ss");
              
              // parse method is used to parse
              // the text from a string to
              // produce the date
              Date d1 = sdf.parse(h.getEntre_date());
              Date d2 = sdf.parse(h.getSortie_date());
              
              // Calucalte time difference
              // in milliseconds
              long difference_In_Time
                      = d2.getTime() - d1.getTime();
              
              // Calucalte time difference in
              // seconds, minutes, hours, years,
              // and days
              long difference_In_Seconds
                      = (difference_In_Time
                      / 1000)
                      % 60; 
              h.setDuree(difference_In_Seconds);
          } catch (ParseException ex) {
              Logger.getLogger(ServicesHistorique.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
  
    void exit_session(Historiques h){
            LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    h.setSortie_date(formattedDate);
    calcul_duration(h);
    }
    
}
