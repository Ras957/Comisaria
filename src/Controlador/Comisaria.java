package Controlador;

import Modelo.Conexion;
import Vista.GUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Clase Main para mostrar por consola la conexion a la Base de Datos
 * e iniciar la GUI.
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
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




















