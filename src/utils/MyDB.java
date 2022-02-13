/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anwer
 */
public class MyDB {
    
    private String url="jdbc:mysql://localhost/gyf";
    private String user="root";
    private String pass="";
    private Connection connection;
    static MyDB instance ;
    
    private MyDB(){
        try {
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("succes");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MyDB getInstance(){
        if (instance == null)
            instance = new MyDB();
        return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
