package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyDB {
    
    private String url = "jdbc:mysql://localhost/gyf1";
    private String user = "root";
    private String password =""; 
    private  Connection connection;
    static MyDB instance;
    
    private MyDB(){
    
        
        try {
            connection= DriverManager.getConnection(url, user, password);
            System.out.println("connexion établie!");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public static MyDB getInstance(){
        if(instance==null)
            instance=new MyDB();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
       
}