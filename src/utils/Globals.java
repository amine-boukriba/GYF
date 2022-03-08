/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Historiques;
import entities.Users;
import services.ServicesHistorique;
import services.ServicesUsers;

/**
 *
 * @author boukr
 */
public class Globals {
    public static Users user =new Users();
    public static Historiques historique=new Historiques();
    public static ServicesUsers serviceuser=new ServicesUsers();
    public static ServicesHistorique servicehistoriques=new ServicesHistorique();
    public Globals() {
    }
    
}
