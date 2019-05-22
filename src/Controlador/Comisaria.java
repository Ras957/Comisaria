/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Sospechoso;
import Vista.GUI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dj_ra
 */
public class Comisaria {
    
    public static Conexion con;
    public static GUI vista=new GUI();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            con = Conexion.getInstance();
        } catch (SQLException ex) {
            Logger.getLogger(Comisaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(con.conectar()){
                System.out.println("Conexion establecida con la base de datos");
            }
        } catch (Exception ex) {
            Logger.getLogger(Comisaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Estructura.generarEstructura(con)){
            System.out.println("Tablas creadas correctamente");
        }
        vista.setVisible(true);
    }
    
}












