/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Clase que crea objetos Correo.
 * @author Samuel Osuna Alcaide
 */
public class Correo {
     private int id;
     private String email;
     private int idSospechoso;

    public Correo(int id, String email, int idSospechoso) {
        this.id = id;
        this.email = email;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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




