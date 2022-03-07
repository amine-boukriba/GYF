/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author boukr
 */
public class main_main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {

    // try code
   Parent root=FXMLLoader.load(getClass().getResource("../GUI/auth.fxml"));
            Scene scene =new Scene(root,600,400);
            primaryStage.setScene(scene);
            primaryStage.show();

}catch (Exception e) {

    // generic exception handling
    e.printStackTrace();
}
        // Answer:
        
            
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
