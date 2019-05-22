/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samuel Osuna Alcaide
 * 
 */
public class Metodos {
    public static void mostrarTabla(DefaultTableModel m, ArrayList<Sospechoso> sos){
        int size=sos.size();
        
        for(int i=0;i<size;i++){
            m.addRow(new Object[]{sos.get(i).getId(),sos.get(i).getNombre(),sos.get(i).getApellidos()});
        }
    }
    
    public static String mostrarTelefonos(Sospechoso sos){
       String devolver = null;
       int sizeTelefonos=sos.getTelefonos().size();
       for(int i=0;i<sizeTelefonos;i++){
           String tel=sos.getTelefonos().get(i).getNumero();
           String cadena=tel;
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    
    public static String mostrarCorreos(Sospechoso sos){
       String devolver = null;
       int sizelist=sos.getCorreos().size();
       for(int i=0;i<sizelist;i++){
           String tel=sos.getCorreos().get(i).getEmail();
           String cadena=(tel);
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    
    public static String mostrarMatricula(Sospechoso sos){
       String devolver = null;
       int sizelist=sos.getMatriculas().size();
       for(int i=0;i<sizelist;i++){
           String tel=sos.getMatriculas().get(i).getMatricula();
           String cadena=(tel);
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    public static String mostrarDireccion(Sospechoso sos){
       String devolver = null;
       int sizelist=sos.getDirecciones().size();
       for(int i=0;i<sizelist;i++){
           String tel=sos.getDirecciones().get(i).getDireccion();
           String cadena=(tel);
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    public static String mostrarAntecedentes(Sospechoso sos){
       String devolver = null;
       int sizelist=sos.getAntecedentes().size();
       for(int i=0;i<sizelist;i++){
           String tel=sos.getAntecedentes().get(i).getDescripcion();
           String cadena=(tel);
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    public static String mostrarHechos(Sospechoso sos){
       String devolver = null;
       int sizelist=sos.getHechos().size();
       for(int i=0;i<sizelist;i++){
           String tel=sos.getHechos().get(i).getDescripcion();
           String cadena=(tel);
           devolver+=cadena+"\n";
       }
      return devolver;
    }
    
    public static Sospechoso buscarSospechosoId(int id, ArrayList<Sospechoso> sos){
        Sospechoso devolver = null;
        
        for(int i=0;i<sos.size();i++){
            if(sos.get(i).getId()==id){
                devolver=sos.get(i);
            }
        }
        return devolver;
    }
}
