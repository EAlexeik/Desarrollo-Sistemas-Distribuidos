/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_minialmacen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alexeik
 */
public class ConectorMysql {
    private final String USUARIO="alexeik";
    private final String CONTRASENIA="EAvs.1993";
    private Connection con;
    
    public void RealizarConexion(String nomBase) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println("Registro exitoso");
        con = DriverManager.getConnection("jdbc:mysql://localhost/"+nomBase+"?user="+USUARIO+"&password="+CONTRASENIA);
    }

    public Connection getCon() {
        return con;
    }
    
    public void Desconectar() throws SQLException{
        con.close();
    }
}
