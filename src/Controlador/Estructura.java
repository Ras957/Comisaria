/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.*;
import Modelo.Sospechoso;
import Modelo.Telefono;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public static int getMaxIDSospechoso(Conexion conn) throws SQLException{
        int id = 0;
        PreparedStatement stmt = conn.getMiConexion().prepareStatement("Select max(id) id from sospechoso");
        ResultSet rs=stmt.executeQuery();
        if(rs.next()){
            id = rs.getInt("id");
        }
        return id;
    }
    
    public static ArrayList<Sospechoso> getPersonFromBBDD(Conexion conn) throws SQLException {
        ArrayList<Sospechoso> AllSos=new ArrayList<>();
        int max=getMaxIDSospechoso(conn);
        
        for(int i=1;i<max+1;i++){
        String id = Integer.toString((i));
        
        PreparedStatement stmt = conn.getMiConexion().prepareStatement("SELECT * FROM SOSPECHOSO WHERE  Id=?");
        stmt.setString(1, id);
        ResultSet rs=stmt.executeQuery();
        Sospechoso sos=new Sospechoso(0, null, null, null, null, null, null, null, null, null, null);
        if(rs.next()){
            sos.setId(rs.getInt("Id"));
            sos.setNombre(rs.getString("Nombre"));
            sos.setApellidos(rs.getString("Apellidos"));
        }
        rs.close();
        stmt.close();
        
        ArrayList<Telefono> telefonos=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM TELEFONO WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Telefono tel=new Telefono(0, null, 0);
            tel.setId(rs.getInt("id"));
            tel.setNumero(Integer.toString(rs.getInt("Telefono")));
            tel.setIdSospechoso(rs.getInt("id_Sospechoso"));
            telefonos.add(tel);
        }
        sos.setTelefonos(telefonos);
        rs.close();
        stmt.close();
        
        ArrayList<Vehiculo> matriculas=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM VEHICULO WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Vehiculo ve=new Vehiculo(0, null, 0);
            ve.setId(rs.getInt("id"));
            ve.setMatricula(rs.getString("Matricula"));
            ve.setIdSospechoso(rs.getInt("id_Sospechoso"));
            matriculas.add(ve);
        }
        sos.setMatriculas(matriculas);
        rs.close();
        stmt.close();
        
        ArrayList<Correo> correos=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM CORREOS WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Correo co=new Correo(0, null, 0);
            co.setId(rs.getInt("id"));
            co.setEmail(rs.getString("email"));
            co.setIdSospechoso(rs.getInt("id_Sospechoso"));
            correos.add(co);
        }
        sos.setCorreos(correos);
        rs.close();
        stmt.close();
        
        ArrayList<Direccion> direcciones=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM DIRECCION WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Direccion di=new Direccion(0, null, 0);
            di.setId(rs.getInt("id"));
            di.setDireccion(rs.getString("Direccion"));
            di.setIdSospechoso(rs.getInt("id_Sospechoso"));
            direcciones.add(di);
        }
        sos.setDirecciones(direcciones);
        rs.close();
        stmt.close();
        
        /*ArrayList<Sospechoso> acomps=new ArrayList<>();
        stmt=conn.prepareStatement("SELECT * FROM ACOMPANYA WHERE  Id_Sospechoso1=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Sospechoso aco=new Sospechoso(0, null, null, null, null, null, null, null, null, null, null);
            sos.setId(rs.getInt("Id"));
            sos.setNombre(rs.getString("Nombre"));
            sos.setApellidos(rs.getString("Apellidos"));
            acomps.add(aco);
        }
        sos.setCorreos(correos);
        rs.close();
        stmt.close();*/
        
        ArrayList<Hecho> hechos=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM HECHOS WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Hecho he=new Hecho(0, null, 0);
            he.setId(rs.getInt("id"));
            he.setDescripcion(rs.getString("Descripcion"));
            he.setIdSospechoso(rs.getInt("id_Sospechoso"));
            hechos.add(he);
        }
        sos.setHechos(hechos);
        rs.close();
        stmt.close();
        
        ArrayList<Antecedente> antecedentes=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM ANTECEDENTES WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Antecedente an=new Antecedente(0, null, 0);
            an.setId(rs.getInt("id"));
            an.setDescripcion(rs.getString("Descripcion"));
            an.setIdSospechoso(rs.getInt("id_Sospechoso"));
            antecedentes.add(an);
        }
        sos.setAntecedentes(antecedentes);
        rs.close();
        stmt.close();
        
         ArrayList<Foto> fotos=new ArrayList<>();
        stmt=conn.getMiConexion().prepareStatement("SELECT * FROM FOTOS WHERE  Id_Sospechoso=?");
        stmt.setString(1, id);
        rs=stmt.executeQuery();
        while(rs.next()){
            Foto fo=new Foto(0,null, 0, null);
            fo.setId(rs.getInt("id"));
            fo.setDescripcion(rs.getString("Descripcion"));
            //fo.setImagen(rs.getString("imagen"));
            fo.setIdSospechoso(rs.getInt("id_Sospechoso"));
            fotos.add(fo);
        }
        sos.setFotos(fotos);
        rs.close();
        stmt.close();
        AllSos.add(sos);
        }
        
        return AllSos;
    }
    public static int borrarSospechoso(int codigo, Conexion myConexion){
        String lineaSQL;
		
		PreparedStatement preparedStmt;
		
		int nFilas=0;
		
		
		
		lineaSQL="DELETE FROM SOSPECHOSO WHERE ID = ?";
		try
		{		
		
			
			preparedStmt = myConexion.getMiConexion().prepareStatement(lineaSQL);
			
			
		    preparedStmt.setInt (1, codigo);
		
			
			nFilas=preparedStmt.executeUpdate();
		       
			
		}catch(SQLException se)
		{
		
			se.printStackTrace();
		}
		
		return nFilas;
    }
}






