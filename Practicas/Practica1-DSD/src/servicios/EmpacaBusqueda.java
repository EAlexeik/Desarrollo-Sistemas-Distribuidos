/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Esta clase sirve para empaquetar las busquedas en listas para enviarlas al cliente.

package servicios;

import modelos.Curso;
import modelos.Alumno;
import modelos.Asignacion;
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
                 alumnos.add(new Alumno(res.getInt("IdAlumno"),res.getString("nombre"), res.getString("paterno"), res.getString("materno"), res.getString("email"),res.getString("calle"), res.getString("numero"), res.getString("colonia"), res.getString("delegacion"), res.getString("entidad"), res.getString("telefono")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
    }
        
       return alumnos;  
    }
         
 //Genera una lista con los alumnos encontrados por nombre
    
//        public ArrayList<Alumno> ListaNombreA(String nombre){
//        
//        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
//        
//        try{
//                
//           Crud cr = new Crud(); 
//           ResultSet res = cr.buscaNombreA(nombre);
//           if(res!= null){
//                while(res.next()){
//                 alumnos.add(new Alumno(res.getInt("IdAlumno"),res.getString("nombre"), res.getString("paterno"), res.getString("materno"), res.getString("email"),res.getString("calle"), res.getString("numero"), res.getString("colonia"), res.getString("delegacion"), res.getString("entidad"), res.getString("telefono")));
//                }
//               
//           }
//         
//        }catch(Exception e){
//           e.printStackTrace();
//           
//    }
//        
//       return alumnos;  
//    }
        
    //________________________________________Empaquetados de busqueda de curso______________________________________________
        
     //Busqueda de todos los cursos
        
        public ArrayList<Curso> ListaTodosC(){
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        
        try{
                
           Crud cr = new Crud(); 
           ResultSet res = cr.buscaTodosC();
           if(res!= null){
                while(res.next()){
                 LocalDate fechaInicio,fechaTermino;
                 String fi,fe;
                 fechaInicio = res.getDate("fechaInicio").toLocalDate();
                 fechaTermino = res.getDate("fechaTermino").toLocalDate();
                 fi = fechaInicio.getYear()+"-"+fechaInicio.getMonthValue()+"-"+fechaInicio.getDayOfMonth();
                 fe = fechaTermino.getYear()+"-"+fechaTermino.getMonthValue()+"-"+fechaTermino.getDayOfMonth();
                 
                 cursos.add(new Curso(res.getInt("IdCurso"),res.getString("nombreC"), fi,fe,res.getDouble("cuotaDeRecuperacion")));
                }
               
           }
         
        }catch(Exception e){
           e.printStackTrace();
    }
        
       return cursos;  
    }
    
    //  Genera una lista de los cursos buscados por nombre
        
//    public ArrayList<Curso> ListaNombreC(String nombre){
//        
//        ArrayList<Curso> cursos = new ArrayList<Curso>();
//        
//        try{
//                
//           Crud cr = new Crud(); 
//           ResultSet res = cr.buscaNombreC(nombre);
//           if(res!= null){
//                while(res.next()){
//                 LocalDate fechaInicio,fechaTermino;
//                 String fi,fe;
//                 fechaInicio = res.getDate("fechaInicio").toLocalDate(); //Pasamos de sql a LocalDate
//                 fechaTermino = res.getDate("fechaTermino").toLocalDate();
//                 fi = fechaInicio.getYear()+"-"+fechaInicio.getMonthValue()+"-"+fechaInicio.getDayOfMonth(); //Construimos el String con los valores del LocalDate
//                 fe = fechaTermino.getYear()+"-"+fechaTermino.getMonthValue()+"-"+fechaTermino.getDayOfMonth();
//                 
//                 cursos.add(new Curso(res.getInt("IdCurso"),res.getString("nombreC"), fi,fe,res.getDouble("cuotaDeRecuperacion")));
//                }
//               
//           }
//         
//        }catch(Exception e){
//           e.printStackTrace();
//    }
//        
//       return cursos;  
//    }
   
//______________________________________Empaquetado de busqueda de asignacion________________________________
    
    
//Genera una lista de las asignaciones
    
//     public ArrayList<Asignacion> ListaTodosS(){
//        
//        ArrayList<Asignacion> asignacion = new ArrayList<Asignacion>();
//        
//        
//        try{
//                
//           Crud cr = new Crud(); 
//           ResultSet res = cr.buscaTodosS();
//           
//                            
//           if(res!= null){
//                while(res.next()){    
//                
//                 asignacion.add(new Asignacion(res.getString("nombre"),res.getString("paterno"),res.getString("materno"),res.getString("nombreC"),res.getString("horario"),res.getInt("tipoCurso")));
//                 
//                }
//               
//           }
//         
//        }catch(Exception e){
//           e.printStackTrace();
//    }
//        
//       return asignacion;  
//    }

     
//Genera una lista con la busqueda por alumno
     
//    public ArrayList<Asignacion> ListaNombreAlumnoS(String nombre){
//        
//        ArrayList<Asignacion> asignacion = new ArrayList<Asignacion>();
//        
//        
//        try{
//                
//           Crud cr = new Crud();
//           ResultSet res = cr.buscaAsignacionAlumno(nombre);
//           if(res!= null){
//                while(res.next()){
//                 asignacion.add(new Asignacion(res.getString("nombre"),res.getString("paterno"),res.getString("materno"),res.getString("nombreC"),res.getString("horario"),res.getInt("tipoCurso")));
//                }
//               
//           }
//         
//        }catch(Exception e){
//           e.printStackTrace();
//    }
//        
//       return asignacion;  
//    } 
    
////Genera una lista buscando por curso
//
//    
//    public ArrayList<Asignacion> ListaNombreCursoS(String nombre){
//        
//        ArrayList<Asignacion> asignacion = new ArrayList<Asignacion>();
//       
//        
//        try{
//                
//           Crud cr = new Crud();
//           ResultSet res = cr.buscaAsignacionCurso(nombre);
//           if(res!= null){
//                while(res.next()){
//                    asignacion.add(new Asignacion(res.getString("nombre"),res.getString("paterno"),res.getString("materno"),res.getString("nombreC"),res.getString("horario"),res.getInt("tipoCurso")));                      
//                }
//               
//           }
//         
//        }catch(Exception e){
//           e.printStackTrace();
//    }
//        
//       return asignacion;  
//    }
//    
    
//Genera el paquete a insertar en la asignacion
    
//    public boolean insertaAsignacion( Asignacion as){
//        
//        
//        
//        try{
//           Crud cr = new Crud();
//           int idA,idC;
//           
//           idA = cr.getIdE(as.getAlumno(), as.getPaterno(),as.getMaterno());
//           idC = cr.getIdC(as.getCurso());
//           cr.insertS(idA, idC, as);
//           
//           return true; 
//        }catch(Exception e){
//           e.printStackTrace();
//        }return false;
//        
//    }
    
//Genera el paquete a actualizar en la base
    
//    public boolean actualizaAsignacion( Asignacion as){
//        
//        
//        
//        try{
//           Crud cr = new Crud();
//           int idA,idC;
//           
//           idA = cr.getIdE(as.getAlumno(),as.getPaterno(),as.getMaterno());
//           idC = cr.getIdC(as.getCurso());
//           cr.updateS(idA, idC, as);
//           
//           return true; 
//        }catch(Exception e){
//           e.printStackTrace();
//        }return false;
//        
//    }
    
//Borra la asignacion
    
//    public boolean borraAsignacion( Asignacion as){
//        
//        
//        
//        try{
//           Crud cr = new Crud();
//           int idA,idC;
//           
//           idA = cr.getIdE(as.getAlumno(),as.getPaterno(),as.getMaterno());
//           idC = cr.getIdC(as.getCurso());
//           cr.deleteS(idA, idC);
//           
//           return true; 
//        }catch(Exception e){
//           e.printStackTrace();
//        }return false;
//        
//    }
        
    
}
