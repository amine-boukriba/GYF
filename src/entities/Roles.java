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
public class Roles {
    private int idr;
    private String label;

    public Roles(String label) {
        this.label = label;
    }

    public Roles() {
    }

    public int getIdr() {
        return idr;
    }

    public String getLabel() {
        return label;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Roles{" + "idr=" + idr + ", label=" + label + '}';
    }
    
}
