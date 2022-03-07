/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author anwer
 */
public class OfferOptionItemController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label title_text;
    @FXML
    private Label desc_text;
    @FXML
    private Label durr_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setItemm(List<String> list){
        //System.out.println("oofer option "+list);
        Image image = new Image(getClass().getResourceAsStream("..\\Images\\"+list.get(0)));
        this.image.setImage(image);
        title_text.setText(list.get(1));
        desc_text.setText(list.get(2));
        durr_text.setText(list.get(3));
    }
}
