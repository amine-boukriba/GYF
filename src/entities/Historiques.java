/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author boukr
 */
public class Historiques {
   int id_historique ;
           
   String entre_date ;

  String sortie_date ;

   long duree ;

int id_user;

    public Historiques() {
    }

    public Historiques(String entre_date, String sortie_date, long duree, int id_user) {
        this.entre_date = entre_date;
        this.sortie_date = sortie_date;
        this.duree = duree;
        this.id_user = id_user;
    }

    public Historiques(int id_historique, String entre_date, String sortie_date, long duree, int id_user) {
        this.id_historique = id_historique;
        this.entre_date = entre_date;
        this.sortie_date = sortie_date;
        this.duree = duree;
        this.id_user = id_user;
    }

    public int getId_historique() {
        return id_historique;
    }

    public void setId_historique(int id_historique) {
        this.id_historique = id_historique;
    }

    public String getEntre_date() {
        return entre_date;
    }

    public void setEntre_date(String entre_date) {
        this.entre_date = entre_date;
    }

    public String getSortie_date() {
        return sortie_date;
    }

    public void setSortie_date(String sortie_date) {
        this.sortie_date = sortie_date;
    }

    public long getDuree() {
        return duree;
    }

    public void setDuree(long duree) {
        this.duree = duree;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    
}
