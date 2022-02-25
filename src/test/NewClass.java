/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author boukr
 */
public class NewClass {
    public static void main(String[] args) {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
System.out.println("After formatting: " + formattedDate);
    }
    
    
}
