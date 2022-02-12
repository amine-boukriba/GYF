/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boukr
 */
public class Mydb {
    private String url ="jdbc:mysql://localhost/gyf";
    private String user="root";
    private String pass="";
    private Connection connection;
    static Mydb instance;
    
    private Mydb(){ 
        
        try {
            connection=DriverManager.getConnection(url, user, pass);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(Mydb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public static Mydb getInstance()
    {
        if(instance==null) 
         instance=new Mydb();
            return instance;
    }
    public Connection getConnection(){
        return connection;
    }
    
}
