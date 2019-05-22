/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author dj_ra
 */
public class Sospechoso {
    
    private int id;
    private String nombre;
    private String apellidos;
    private List<Telefono> telefonos;
    private List<Vehiculo> matriculas;
    private List<Correo> correos;
    private List<Direccion> direcciones;
    private List<Sospechoso> acompanyantes;
    private List<Hecho> hechos;
    private List<Antecedente> antecedentes;
    private List<Foto> fotos;

    public Sospechoso(int id, String nombre, String apellidos, List<Telefono> telefonos, 
            List<Vehiculo> matriculas, List<Correo> correos, List<Direccion> direcciones, 
            List<Sospechoso> acompanyantes, List<Hecho> hechos, List<Antecedente> antecedentes, 
            List<Foto> fotos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefonos = telefonos;
        this.matriculas = matriculas;
        this.correos = correos;
        this.direcciones = direcciones;
        this.acompanyantes = acompanyantes;
        this.hechos = hechos;
        this.antecedentes = antecedentes;
        this.fotos = fotos;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the telefonos
     */
    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the matriculas
     */
    public List<Vehiculo> getMatriculas() {
        return matriculas;
    }

    /**
     * @param matriculas the matriculas to set
     */
    public void setMatriculas(List<Vehiculo> matriculas) {
        this.matriculas = matriculas;
    }

    /**
     * @return the correos
     */
    public List<Correo> getCorreos() {
        return correos;
    }

    /**
     * @param correos the correos to set
     */
    public void setCorreos(List<Correo> correos) {
        this.correos = correos;
    }

    /**
     * @return the direcciones
     */
    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    /**
     * @param direcciones the direcciones to set
     */
    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * @return the acompanyantes
     */
    public List<Sospechoso> getAcompanyantes() {
        return acompanyantes;
    }

    /**
     * @param acompanyantes the acompanyantes to set
     */
    public void setAcompanyantes(List<Sospechoso> acompanyantes) {
        this.acompanyantes = acompanyantes;
    }

    /**
     * @return the hechos
     */
    public List<Hecho> getHechos() {
        return hechos;
    }

    /**
     * @param hechos the hechos to set
     */
    public void setHechos(List<Hecho> hechos) {
        this.hechos = hechos;
    }

    /**
     * @return the antecedentes
     */
    public List<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    /**
     * @param antecedentes the antecedentes to set
     */
    public void setAntecedentes(List<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }

    /**
     * @return the fotos
     */
    public List<Foto> getFotos() {
        return fotos;
    }

    /**
     * @param fotos the fotos to set
     */
    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
    
    
    
    
    
    
    
}






