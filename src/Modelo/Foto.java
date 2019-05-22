/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;

/**
 *
 * @author dj_ra
 */
public class Foto extends Hecho{
    
    private Image imagen;

    public Foto(int id, String descripcion, int idSospechoso, Image imagen) {
        super(id, descripcion, idSospechoso);
        this.imagen=imagen;
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}



