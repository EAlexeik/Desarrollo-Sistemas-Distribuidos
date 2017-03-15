/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
 
/**
 *
 * @author Lock
 */
public class Conexion {
    
    //Configuracion de los datos de la BD
    private String usuario = "root";
    private String pass = "EAvs.1993";
    private String host = "127.0.0.1";
    private String nombre_BD = "saes";
 
    private Connection con = null;
 
    public Conexion() {
    }
    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
    
     
}
