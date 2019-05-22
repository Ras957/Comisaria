/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dj_ra
 */
public class Estructura {
    
    
    public static boolean generarEstructura(Conexion myConexion) {
        boolean generada = true;
        String lineaSQL;
        Statement sentencia;
        try {
            lineaSQL = "CREATE TABLE IF NOT EXISTS SOSPECHOSO"
                    + "(Id          integer primary key AUTO_INCREMENT,"
                    + " Nombre      varchar(50),"
                    + " Apellidos   varchar(100))ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS ACOMPANYA"
                    + " (Id_Sospechoso1           integer,"
                    + " Id_Sospechoso2            integer,"
					+ " primary key(Id_Sospechoso1,Id_Sospechoso2),"
                    + " foreign key (id_Sospechoso1) references Sospechoso(Id) on delete cascade,"
                    + " foreign key (id_Sospechoso2) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS TELEFONO("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    Telefono         int(10),"
                    + "    Tipo             varchar(20),"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS ANTECEDENTES("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    Descripcion      varchar(200),"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS CORREOS("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    email            char(50),"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS DIRECCION("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    Direccion        varchar(200),"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS HECHOS("
                    + "    Id                   integer primary key AUTO_INCREMENT,"
                    + "    Descripcion          varchar(200),"
                    + "    id_Sospechoso        integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS FOTOS("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    Descripcion      varchar(200),"
                    + "    imagen           mediumblob,"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

            lineaSQL = "CREATE TABLE IF NOT EXISTS VEHICULO("
                    + "    Id               integer primary key AUTO_INCREMENT,"
                    + "    Matricula        char(10),"
                    + "    id_Sospechoso    integer,"
                    + "    foreign key (id_Sospechoso) references Sospechoso(Id) on delete cascade"
                    + ")ENGINE=InnoDB";

            sentencia = myConexion.getMiConexion().createStatement();
            sentencia.executeUpdate(lineaSQL);

        } catch (SQLException se) {
            generada = false;
            se.printStackTrace();
        }
        return generada;
    }
    
}


