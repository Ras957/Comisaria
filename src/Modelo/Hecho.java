/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase que crea objetos Hecho.
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
 */
public class Hecho {
    private int id;
    private String descripcion;
    private int idSospechoso;

    public Hecho(int id, String descripcion, int idSospechoso) {
        this.id = id;
        this.descripcion = descripcion;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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




