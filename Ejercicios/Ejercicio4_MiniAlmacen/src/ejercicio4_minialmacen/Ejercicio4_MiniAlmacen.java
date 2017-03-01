/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_minialmacen;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexeik
 */
public class Ejercicio4_MiniAlmacen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        ConectorMysql cmysql=new ConectorMysql();
        try {
            cmysql.RealizarConexion("tienda");
            ProductoDAO pdao=new ProductoDAO();
            pdao.inicializar(cmysql.getCon());
            
            cmysql.Desconectar();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Ejercicio4_MiniAlmacen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
