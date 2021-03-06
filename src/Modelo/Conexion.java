package Modelo;

import Controlador.CargarXML;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Clase Conexion que sirve para conectarnos a la Base de Datos.
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba
 */
public class Conexion {
    
    private static Conexion instance;
    private Connection miConexion;
    private String host; //Host que contiene la BBDD
    private String bbdd; //Nombre de la BBDD
    private String login; //Login 
    private String password; //Password
    private boolean estado = false;//Estado de la conexión
    
    private Conexion(){
        CargarXML.ConexionXML(this,"bbdd.xml");
    }
    
    /**
     * Aplicación del método Singleton.
     * @return devuelve la Conexion si ya está creada o una nueva.
     * @throws SQLException
     */
    public static Conexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexion();
        } else if (instance.getMiConexion().isClosed()) {
            instance = new Conexion();
        }
        return instance;
    }
    
    /**
     *  Método para establecer la conexion con la Base de Datos.
     * @return  devuelve true si se conecta.
     * @throws Exception
     */
    public boolean conectar() throws Exception
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
         // Setup the connection with the DB
         
		//conexion nomral
		//miConexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd+"?user="+this.login+"&password="+this.password);
		
		//conexión completa para evitar errores de sincronizacion con el servidor
		//miConexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user= "+this.login+"&password=S"+this.password);
		//miConexion = DriverManager.getConnection("jdbc:mysql://localhost/policia", "root", "");
                //System.out.println(this.host+", "+this.bbdd+", "+this.login+", "+this.password);
                miConexion = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd, this.login, this.password);
		this.estado=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
           }
         
		return this.estado;
	}
    
    public boolean cerrarConexion() throws Exception
	{
		boolean seCerro=false;
		try
		{
			this.miConexion.close();
			seCerro=true;
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		return seCerro;
		
	}

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the bbdd
     */
    public String getBbdd() {
        return bbdd;
    }

    /**
     * @param bbdd the bbdd to set
     */
    public void setBbdd(String bbdd) {
        this.bbdd = bbdd;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the miConexion
     */
    public Connection getMiConexion() {
        return miConexion;
    }

    /**
     * @param miConexion the miConexion to set
     */
    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
    
}

















