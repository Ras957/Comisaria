/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *  Clase que crea objetos Vehiculo.
 * @author Daniel Perez Ramírez
 */
public class Vehiculo {
    private int id;
    private String matricula;
    private int idSospechoso;

    public Vehiculo(int id, String matricula, int idSospechoso) {
        this.id = id;
        this.matricula = matricula;
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
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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




