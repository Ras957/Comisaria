/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author dj_ra
 */
public class Direccion {
    
    private int id;
    private String direccion;
    private int idSospechoso;

    public Direccion(int id, String direccion, int idSospechoso) {
        this.id = id;
        this.direccion = direccion;
        this.idSospechoso = idSospechoso;
    }
   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the idSospechoso
     */
    public int getIdSospechoso() {
        return idSospechoso;
    }

    /**
     * @param idSospechoso the idSospechoso to set
     */
    public void setIdSospechoso(int idSospechoso) {
        this.idSospechoso = idSospechoso;
    }
    
    
}



