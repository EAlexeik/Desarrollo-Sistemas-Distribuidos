/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_minialmacen;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author alexeik
 */
public class ProductoDAO {
    private Connection conn;
    
    public void inicializar(Connection conn){
        this.conn=conn;
    }
    
    public void insertarProducto(Producto p) throws SQLException{
        CallableStatement cs=conn.prepareCall("{call insertar_producto(?,?,?,?)}");
        cs.setInt(1,p.getId());
        cs.setString(2,p.getNombre());
        cs.setDouble(3,p.getPrecio());
        cs.setInt(4,p.getExistencia());
        cs.executeUpdate();
    }
    public void eliminarProducto(Producto p) throws SQLException{
        CallableStatement cs=conn.prepareCall("{call eliminar_producto(?)}");
        cs.setInt(1,p.getId());
        cs.executeUpdate();
    }
    public void modificarProducto(){
        
    }
    public void mostrarProducto(){
        
    }
}
