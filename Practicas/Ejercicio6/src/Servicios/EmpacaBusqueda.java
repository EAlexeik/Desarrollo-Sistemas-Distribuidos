/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Esta clase sirve para empaquetar las busquedas en listas para enviarlas al cliente.

package Servicios;

import Modelo.Alumno;
import java.util.*;
import java.sql.*;
import java.time.*;

/**
 *
 * @author Lock
 */
public class EmpacaBusqueda {
    
    public EmpacaBusqueda(){
    }
    
    //___________________________________Empaquetados de busqueda Alumno_____________________________________
    
    //Genera una lista con todos los alumnos en la tabla
    
    public ArrayList<Alumno> ListaTodosA(){
        
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosA();
           if(res!= null){
                while(res.next()){
                 alumnos.add(new Alumno(res.getInt("IdAlumno"),res.getString("nombre"), res.getString("paterno"), res.getString("materno"), res.getString("email"),res.getString("fecha_nac"), res.getInt("idCarrera")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
    }
        
       return alumnos;  
    }
    
}
