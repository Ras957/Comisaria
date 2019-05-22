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
public class Telefono {
     
    private int id;
    private String numero;
    enum tipo{FIJO,MOVIL};
    private int idSospechoso;

    public Telefono(int id, String numero, int idSospechoso) {
        this.id = id;
        this.numero = numero;
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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



