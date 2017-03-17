/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author alexeik
 */
public class Crud {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Crud() {
        try {
            if ((con = conexion.getConexionMYSQL()) == null) {
                JOptionPane.showMessageDialog(null, "Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //--------------------------------------Alumno------------------------------------------
    
    //Insertar alumno
    public boolean insertAlum(Alumno al) {
        try {
            String query = "INSERT INTO alumno VALUES(NULL,'" + al.getContrasenia()+ "','" + al.getEmailEscolar()+ "','" + al.getFechaIngreso()+ "','" + al.getIdGrupo()+ "','" + al.getIdPersona()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos los alumnos
    public ResultSet buscaTodosAlum() {
        try {
            String query = "SELECT * FROM alumno";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Alumno buscaNombreAlum(int id) {
        try {
            String query = "SELECT * FROM alumno WHERE idAlumno = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Alumno(rs.getInt("idAlumno"), rs.getString("contrasenia"), rs.getString("emailEscolar"), rs.getString("fechaIngreso"), rs.getInt("idGrupo"),rs.getInt("idPersona"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Buscar Usuario y Contraseña
    public Alumno buscarAlumnoContrasenia(int id, String contrasenia){
        try {
            String query = "SELECT * FROM alumno WHERE idAlumno = '" + id + "' AND contrasenia = '"+contrasenia+"'";
            rs = st.executeQuery(query);
            rs.next();
            return new Alumno(rs.getInt("idAlumno"), rs.getString("contrasenia"), rs.getString("emailEscolar"), rs.getString("fechaIngreso"), rs.getInt("idGrupo"),rs.getInt("idPersona"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Alumno
    public boolean updateAlum(Alumno al) {
        try {
            String query = "UPDATE alumno SET " + "contrasenia='" + al.getContrasenia()+ "'," + "emailEscolar='" + al.getEmailEscolar()+ "'," + "fechaIngreso='" + al.getFechaIngreso()+ "'," + "idGrupo='" + al.getIdGrupo()+ "'," + "idPersona='" + al.getIdPersona()+ "' WHERE idAlumno = " + al.getIdAlumno() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Alumno
    public boolean deleteAlum(Alumno al) {
        try {
            String query = "DELETE FROM examen WHERE idAlumno = " + al.getIdAlumno() + "";
            st.executeUpdate(query);
            query = "DELETE FROM alumno WHERE idAlumno = " + al.getIdAlumno() + "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
        //--------------------------------------Asignaturas------------------------------------------

    //Insertar Asignaturas
    public boolean insertAsig(Asignatura as) {
        try {
            String query = "INSERT INTO Asignaturas VALUES(NULL,'" + as.getNombre()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Asignaturas
    public ResultSet buscaTodosAsig() {
        try {
            String query = "SELECT * FROM asignaturas";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Asignatura buscaNombreAsig(int id) {
        try {
            String query = "SELECT * FROM asignaturas WHERE idAsignaturas = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Asignatura(rs.getInt("idAsignaturas"), rs.getString("nombre"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar asignaturas
    public boolean updateAsig(Asignatura as) {
        try {
            String query = "UPDATE asignaturas SET " + "nombre='" + as.getNombre()+"' WHERE idAsignaturas = " + as.getIdAsignatura() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Asignaturas
    public boolean deleteAsig(Asignatura as) {
        try {
            String query = "DELETE FROM Prueba WHERE idAsignaturas = " + as.getIdAsignatura()+ "";
            st.executeUpdate(query);
            query = "DELETE FROM Asignaturas WHERE idAsignaturas = " + as.getIdAsignatura()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Asignaturas especifico

    public int getIdAsigE(String nombre) {
        try {
            int id;
            String query = "SELECT * FROM asignaturas WHERE nombre = '" + nombre+ "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idAsignaturas");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //--------------------------------------Carrera------------------------------------------
    
    //Insertar Carrera
    public boolean insertCarrera(Carrera c) {
        try {
            String query = "INSERT INTO Asignaturas VALUES(NULL,'" + c.getNombre()+ "','" + c.getNumSemestre()+"','" +c.getIdEscuela()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Carrera
    public ResultSet buscaTodosCarrera() {
        try {
            String query = "SELECT * FROM Carrera";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Carrera buscaNombreCarrera(int id) {
        try {
            String query = "SELECT * FROM Carrera WHERE idCarrera = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Carrera(rs.getInt("idCarrera"), rs.getString("nombre"),rs.getInt("numSemestre"), rs.getInt("idEscuela"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Carrera
    public boolean updateCarrera(Carrera c) {
        try {
            String query = "UPDATE Carrera SET " + "nombre='" + c.getNombre()+ "'," + "numSemestre='" + c.getNumSemestre()+"'," + "idEscuela='"+c.getIdEscuela()+"' WHERE idAsignaturas = " + c.getIdCarrera() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Carrera
    public boolean deleteCarrera(Carrera c) {
        try {
            String query = "DELETE FROM Asignaturas WHERE idAsignaturas = " + c.getIdCarrera()+ "";
            st.executeUpdate(query);
            query = "DELETE FROM Carrera WHERE idAsignaturas = " + c.getIdCarrera()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Carrera especifico

    public int getIdCarreraE(String nombre, int numSemestre, int idEscuela) {
        try {
            int id;
            String query = "SELECT * FROM Carrera WHERE nombre = '" + nombre +"' AND numSemestre = '"+numSemestre+"' AND idEscuela = '" + idEscuela + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idAsignaturas");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //--------------------------------------Escuela------------------------------------------
    //Insertar Escuela
    public boolean insertEscuela(Escuela es) {
        try {
            String query = "INSERT INTO Escuela VALUES(NULL,'" + es.getNombre()+ "');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Escuela
    public ResultSet buscaTodosEscuela() {
        try {
            String query = "SELECT * FROM Escuela";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Escuela buscaNombreEscuela(int id) {
        try {
            String query = "SELECT * FROM Carrera WHERE idCarrera = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Escuela(rs.getInt("idEscuela"), rs.getString("nombre"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Escuela
    public boolean updateEscuela(Escuela es) {
        try {
            String query = "UPDATE Escuela SET " + "nombre='" + es.getNombre()+"' WHERE idEscuela = " + es.getIdEscuela()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Escuela
    public boolean deleteEscuela(Escuela es) {
        try {
            String query = "DELETE FROM Escuela WHERE idEscuela = " + es.getIdEscuela()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Escuela especifico

    public int getIdEscuelaE(String nombre) {
        try {
            int id;
            String query = "SELECT * FROM Carrera WHERE nombre = '" + nombre + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idEscuela");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //--------------------------------------Examen------------------------------------------
    //Insertar Examen
    public boolean insertExamen(Examen ex) {
        try {
            String query = "INSERT INTO Examen VALUES(NULL,'" + ex.getCurrent_date()+ "','" +ex.getCalificacion()+ "','" +ex.getIdAlumno() +"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Examen
    public ResultSet buscaTodosExamen() {
        try {
            String query = "SELECT * FROM Examen";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Examen buscaNombreExamen(int id) {
        try {
            String query = "SELECT * FROM Examen WHERE idExamen = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Examen(rs.getInt("idExamen"),rs.getString("current_date"),rs.getDouble("calificacion"),rs.getInt("idAlumno"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Examen
    public boolean updateExamen(Examen ex) {
        try {
            String query = "UPDATE Escuela SET " + "current_date='" + ex.getCurrent_date()+"'," + "calificacion='" +ex.getCalificacion()+"'," + "idAlumno='"+ex.getIdAlumno() +"' WHERE idEscuela = " + ex.getIdExamen()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Examen
    public boolean deleteExamen(Examen ex) {
        try {
            String query = "DELETE FROM Parcial WHERE idEscuela = " + ex.getIdExamen()+ "";
            st.executeUpdate(query);
            query = "DELETE FROM Examen WHERE idExamen = " + ex.getIdExamen()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Examen especifico

    public int getIdExamenE(String current_date) {
        try {
            int id;
            String query = "SELECT * FROM Examen WHERE current_date = '" + current_date + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idExamen");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //--------------------------------------Parcial------------------------------------------
    //Insertar Parcial
    public boolean insertParcial(Parcial p) {
        try {
            String query = "INSERT INTO Parcial VALUES(NULL,'" + p.getNombre()+ "','" +p.getIdExamen()+ "','" +p.getIdAsignatura() +"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Parcial
    public ResultSet buscaTodosParcial() {
        try {
            String query = "SELECT * FROM Parcial";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Parcial buscaNombreParcial(int id) {
        try {
            String query = "SELECT * FROM Parcial WHERE idParcial = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Parcial(rs.getInt("idParcial"),rs.getString("nombre"),rs.getInt("idExamen"),rs.getInt("idAsignaturas"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Parcial
    public boolean updateParcial(Parcial p) {
        try {
            String query = "UPDATE Parcial SET " + "nombre='" + p.getNombre()+"'," + "idExamen='" +p.getIdExamen()+"'," + "idAsignatura='"+p.getIdAsignatura() +"' WHERE idParcial = " + p.getIdParcial()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Parcial
    public boolean deleteParcial(Parcial p) {
        try {
            String query = "DELETE FROM Parcial WHERE idExamen = " + p.getIdParcial()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Parcial especifico

    public int getIdParcialE(String nombre) {
        try {
            int id;
            String query = "SELECT * FROM Parcial WHERE nombre = '" + nombre + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idExamen");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //--------------------------------------Pregunta------------------------------------------
    //Insertar Pregunta
    public boolean insertPregunta(Pregunta p) {
        try {
            String query = "INSERT INTO Pregunta VALUES(NULL,'" + p.getPregunta()+ "','" +p.getRespuesta()+ "','" +p.getIdExamen()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Pregunta
    public ResultSet buscaTodosPregunta() {
        try {
            String query = "SELECT * FROM Pregunta";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Pregunta buscaNombrePregunta(int id) {
        try {
            String query = "SELECT * FROM Pregunta WHERE idPregunta = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Pregunta(rs.getInt("idPregunta"),rs.getString("pregunta"),rs.getString("respuesta"),rs.getInt("idExamen"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Pregunta
    public boolean updatePregunta(Pregunta p) {
        try {
            String query = "UPDATE Pregunta SET " + "pregunta='" + p.getPregunta()+"'," + "respuesta='" +p.getRespuesta()+"'," + "idExamen='"+p.getIdExamen()+"' WHERE idPregunta = " + p.getIdPregunta()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Pregunta
    public boolean deletePregunta(Pregunta p) {
        try {
            String query = "DELETE FROM Parcial WHERE idPregunta = " + p.getIdPregunta()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Pregunta especifico

    public int getIdPreguntaE(int idExamen) {
        try {
            int id;
            String query = "SELECT * FROM Pregunta WHERE idExamen = '" + idExamen + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idExamen");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //--------------------------------------Respuesta------------------------------------------
    //Insertar Respuesta
    public boolean insertRespuesta(Respuesta r) {
        try {
            String query = "INSERT INTO Pregunta VALUES(NULL,'" + r.getRespuesta()+ "','" +r.getIdPregunta()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Respuesta
    public ResultSet buscaTodasRespuestas() {
        try {
            String query = "SELECT * FROM Respuestas";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Respuesta buscaNombreRespuestas(int id) {
        try {
            String query = "SELECT * FROM Respuestas WHERE idRespuestas = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Respuesta(rs.getInt("idRespuesta"),rs.getString("respuesta"),rs.getInt("idPreguntas"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Respuesta
    public boolean updateRespuesta(Respuesta r) {
        try {
            String query = "UPDATE Respuesta SET " + "respuesta='" + r.getRespuesta()+"'," + "idPregunta='" +r.getIdPregunta()+"' WHERE idPregunta = " + r.getIdRespuesta()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Respuesta
    public boolean deleteRespuesta(Respuesta r) {
        try {
            String query = "DELETE FROM Respuesta WHERE idRespuesta = " + r.getIdRespuesta()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Pregunta especifico

    public int getIdRespuestaE(int idPregunta) {
        try {
            int id;
            String query = "SELECT * FROM Pregunta WHERE idPregunta = '" + idPregunta + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idExamen");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //--------------------------------------Grupo------------------------------------------
    //Insertar Respuesta
    public boolean insertGrupo(Grupo g) {
        try {
            String query = "INSERT INTO Pregunta VALUES(NULL,'" + g.getSalon()+ "','" +g.getIdCarrera()+ "','" +g.getIdMaestro()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Respuesta
    public ResultSet buscaTodosGrupos() {
        try {
            String query = "SELECT * FROM Grupo";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Grupo buscaNombreGrupos(int id) {
        try {
            String query = "SELECT * FROM Grupo WHERE idGrupo = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Grupo(rs.getInt("idGrupo"),rs.getString("salon"),rs.getInt("idCarrera"),rs.getInt("idMaestro"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Respuesta
    public boolean updateGrupo(Grupo g) {
        try {
            String query = "UPDATE Grupo SET " + "salon='" + g.getSalon()+"'," + "idCarrera='" +g.getIdCarrera()+"'," + "idMaestro='" +g.getIdMaestro()+"' WHERE idGrupo = " + g.getIdGrupo()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Respuesta
    public boolean deleteGrupo(Grupo g) {
        try {
            String query = "DELETE FROM Grupo WHERE idGrupo = " + g.getIdGrupo()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Pregunta especifico

    public int getIdGrupoE(String salon) {
        try {
            int id;
            String query = "SELECT * FROM Grupo WHERE salon = '" + salon + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idExamen");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //--------------------------------------Mestro------------------------------------------
    //Insertar Respuesta
    public boolean insertMaestro(Maestro m) {
        try {
            String query = "INSERT INTO Maestro VALUES(NULL,'" + m.getContrasenia()+ "','" +m.getGrado()+ "','" +m.getFechaIngreso()+ "','" +m.getIdPersona()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos las Respuesta
    public ResultSet buscaTodosMaestros() {
        try {
            String query = "SELECT * FROM Maestro";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Maestro buscaNombreMaestros(int id) {
        try {
            String query = "SELECT * FROM Maestro WHERE idMaestro = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Maestro(rs.getInt("idMaestro"),rs.getString("contrasenia"),rs.getString("grado"),rs.getString("fechaIngreso"),rs.getInt("idPersona"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Respuesta
    public boolean updateMaestro(Maestro m) {
        try {
            String query = "UPDATE Grupo SET " + "contrasenia='" + m.getContrasenia()+"'," + "grado='" +m.getGrado()+"'," + "fechaIngreso='" +m.getFechaIngreso()+"'," + "idPersona='" +m.getIdPersona()+"' WHERE idMaestro = " + m.getIdMaestro()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Respuesta
    public boolean deleteMaestro(Maestro m) {
        try {
            String query = "DELETE FROM Maestro WHERE idMaestro = " + m.getIdMaestro()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //--------------------------------------Alumno------------------------------------------
    
    //Insertar alumno
    public boolean insertPersona(Persona p) {
        try {
            String query = "INSERT INTO Persona VALUES(NULL,'" + p.getCurp()+ "','" + p.getNombre()+ "','" + p.getApellidoPat()+ "','" + p.getApellidoMat()+ "','" + p.getEmail()+ "','" + p.getFechaNacimiento()+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos los alumnos
    public ResultSet buscaTodaPersona() {
        try {
            String query = "SELECT * FROM Persona";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar por nombre
    public Persona buscaNombrePersona(int id) {
        try {
            String query = "SELECT * FROM Persona WHERE idPersona = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Persona(rs.getInt("idPersona"), rs.getString("curp"), rs.getString("nombre"), rs.getString("apellidoPat"), rs.getString("apellidoMat"), rs.getString("email"),rs.getString("fechaNacimiento"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Alumno
    public boolean updatePersona(Persona p) {
        try {
            String query = "UPDATE Persona SET " + "curp='" + p.getCurp()+ "'," + "nombre='" + p.getNombre()+ "'," + "apellidoPat='" + p.getApellidoPat()+ "'," + "apellidoMat='" + p.getApellidoMat()+ "'," + "email='" + p.getEmail()+"'," + "fechaNacimiento='" + p.getFechaNacimiento()+ "' WHERE idPersona = " + p.getIdPersona()+ ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Alumno
    public boolean deletePersona(Persona p) {
        try {
            String query = "DELETE FROM Persona WHERE idPersona = " + p.getIdPersona()+ "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Alumno especifico

    public int getIdAlumE(String nombre, String paterno, String materno) {
        try {
            int id;
            String query = "SELECT * FROM Persona WHERE nombre = '" + nombre + "' AND apellidoPat = '" + paterno + "' AND apellidoMat = '" + materno + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idPersona");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
