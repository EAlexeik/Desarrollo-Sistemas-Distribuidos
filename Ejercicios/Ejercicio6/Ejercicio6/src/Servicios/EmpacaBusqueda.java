/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Esta clase sirve para empaquetar las busquedas en listas para enviarlas al cliente.

package Servicios;

import Modelo.Alumno;
import Modelo.Asignatura;
import Modelo.Carrera;
import Modelo.Escuela;
import Modelo.Examen;
import Modelo.Grupo;
import Modelo.Maestro;
import Modelo.Parcial;
import Modelo.Persona;
import Modelo.Pregunta;
import Modelo.Respuesta;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Lock
 */
public class EmpacaBusqueda {
    
    public EmpacaBusqueda(){
    }
    
    //___________________________________Empaquetados de busqueda Alumno_____________________________________
    
    //Genera una lista con todos los alumnos en la tabla
    
    public ArrayList<Alumno> ListaTodosAlumno(){
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 alumnos.add(new Alumno(res.getInt("idAlumno"),res.getString("contrasenia"), res.getString("emailEscolar"), res.getString("fechaIngreso"), res.getInt("idGrupo"), res.getInt("idPersona")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
    }
        
       return alumnos;  
    }
    public ArrayList<Asignatura> ListaTodosAsignatura(){
        
        ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();
        
        try{
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAsig();
           if(res!= null){
                while(res.next()){
                    asignatura.add(new Asignatura(res.getInt("idAsignaturas"),res.getString("nombre")));
                }
               
           }
        }catch(Exception e){
           e.printStackTrace();
        }
        return asignatura;
    }
    public ArrayList<Carrera> ListaTodosCarrera(){
        
        ArrayList<Carrera> carrera = new ArrayList<Carrera>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 carrera.add(new Carrera(res.getInt("idCarrera"),res.getString("nombre"), res.getInt("numSemestre"), res.getInt("idEscuela")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return carrera;
    }
     public ArrayList<Escuela> ListaTodosEscuela(){
        
        ArrayList<Escuela> escuela = new ArrayList<Escuela>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 escuela.add(new Escuela(res.getInt("idEscuela"),res.getString("nombre")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return escuela;
    }
     public ArrayList<Examen> ListaTodosExamen(){
        
        ArrayList<Examen> examen = new ArrayList<Examen>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 examen.add(new Examen(res.getInt("idExamen"),res.getString("current_date"),res.getDouble("calificacion"),res.getInt("idAlumno")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return examen;
    }
     public ArrayList<Grupo> ListaTodosGrupo(){
        
        ArrayList<Grupo> grupo = new ArrayList<Grupo>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 grupo.add(new Grupo(res.getInt("idGrupo"),res.getString("salon"),res.getInt("idCarrera"),res.getInt("idMaestro")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return grupo;
    }
     public ArrayList<Maestro> ListaTodosMaestro(){
        
        ArrayList<Maestro> maestro = new ArrayList<Maestro>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 maestro.add(new Maestro(res.getInt("idMaestro"),res.getString("contrasenia"),res.getString("grado"),res.getString("fechaIngreso"),res.getInt("idCarrera")));
                }
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return maestro;
    }
     public ArrayList<Parcial> ListaTodosParcial(){
        
        ArrayList<Parcial> parcial = new ArrayList<Parcial>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 parcial.add(new Parcial(res.getInt("idParcial"),res.getString("nombre"),res.getInt("idExamen"),res.getInt("idAsignaturas")));
                }
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return parcial;
    }
     public ArrayList<Persona> ListaTodosPersona(){
        
        ArrayList<Persona> persona = new ArrayList<Persona>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 persona.add(new Persona(res.getInt("idPersona"),res.getString("curp"),res.getString("nombre"),res.getString("apellidoPat"),res.getString("apellidoMat"),res.getString("email"),res.getString("fechaNacimiento")));
                }
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return persona;
    }
     public ArrayList<Pregunta> ListaTodosPregunta(){
        
        ArrayList<Pregunta> pregunta = new ArrayList<Pregunta>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 pregunta.add(new Pregunta(res.getInt("idPregunta"),res.getString("pregunta"),res.getString("respuesta"),res.getInt("idExamen")));
                }
           }
         
        }catch(Exception e){
           e.printStackTrace();
        }
        return pregunta;
    }
     public ArrayList<Respuesta> ListaTodosRespuesta(){
        
        ArrayList<Respuesta> respuesta = new ArrayList<Respuesta>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosAlum();
           if(res!= null){
                while(res.next()){
                 respuesta.add(new Respuesta(res.getInt("idRespuesta"),res.getString("respuesta"),res.getInt("idPregunta")));
                }
           }
        }catch(Exception e){
           e.printStackTrace();
        }
        return respuesta;
    }
}
