/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import modelos.Curso;
import modelos.Alumno;
import modelos.Asignacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author Lock
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

//-------------------------------------------------Aqui comienza el CRUD para la clase alumno----------------------------------------------------------
    //Insertar alumno
    public boolean insertA(Alumno al) {
        try {
            String query = "INSERT INTO alumno VALUES(NULL,'" + al.getNombre() + "','" + al.getApellidoPaterno() + "','" + al.getApellidoMaterno() + "','" + al.getMail() + "','" + al.getCalle() + "','" + al.getNumero() + "','" + al.getColonia() + "','" + al.getDelegación() + "','" + al.getEntidad() + "','" + al.getTelefono() + "');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos los alumnos
    public ResultSet buscaTodosA() {
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
    public Alumno buscaNombreA(int id) {
        try {
            String query = "SELECT * FROM alumno WHERE idAlumno = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Alumno(rs.getInt("idAlumno"), rs.getString("nombre"), rs.getString("paterno"), rs.getString("materno"), rs.getString("email"), rs.getString("calle"), rs.getString("numero"), rs.getString("colonia"), rs.getString("delegacion"), rs.getString("entidad"), rs.getString("telefono"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar Alumno
    public boolean updateA(Alumno al) {
        try {
            String query = "UPDATE alumno SET " + "nombre='" + al.getNombre() + "'," + "paterno='" + al.getApellidoPaterno() + "'," + "materno='" + al.getApellidoMaterno() + "'," + "email='" + al.getMail() + "'," + "calle='" + al.getCalle() + "'," + "numero='" + al.getNumero() + "'," + "colonia='" + al.getColonia() + "'," + "delegacion='" + al.getDelegación() + "'," + "entidad='" + al.getEntidad() + "'," + "telefono='" + al.getTelefono() + "' WHERE idAlumno = " + al.getIdAlumno() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar Alumno
    public boolean deleteA(Alumno al) {
        try {
            String query = "DELETE FROM asignacion WHERE idAlumno = " + al.getIdAlumno() + "";
            st.executeUpdate(query);
            query = "DELETE FROM alumno WHERE idAlumno = " + al.getIdAlumno() + "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//Obtener el id de un Alumno especifico

    public int getIdE(String nombre, String paterno, String materno) {
        try {
            int id;
            String query = "SELECT * FROM alumno WHERE nombre = '" + nombre + "' AND paterno = '" + paterno + "' AND materno = '" + materno + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idAlumno");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //--------------------------------------------------Aqui empuieza el Crud de curso------------------------------------------------------
    //Insertar curso
    public boolean insertC(Curso cu) {

        LocalDate fechaInicio, fechaTermino;

        //Convertimos los string a LocalDate en formato "yyyy-mm-dd"
        System.out.println(cu.getFechaInicio());
        fechaInicio = LocalDate.parse(cu.getFechaInicio());
        fechaTermino = LocalDate.parse(cu.getFechaTermino());

        //Convertimos los LocalDate a SQL date
        java.sql.Date fi = java.sql.Date.valueOf(fechaInicio);
        java.sql.Date fe = java.sql.Date.valueOf(fechaTermino);

        try {
            String query = "INSERT INTO curso VALUES(NULL,'" + cu.getNombre() + "','" + fi + "','" + fe + "'," + cu.getCuota() + ");";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar todos los cursos
    public ResultSet buscaTodosC() {
        try {
            String query = "SELECT * FROM curso";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Buscar un curso por nombre 
    public Curso buscaNombreC(int id) {
        try {
            String query = "SELECT * FROM curso WHERE idCurso = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            return new Curso(rs.getInt("idCurso"), rs.getString("nombreC"), rs.getString("fechaInicio"), rs.getString("fechaTermino"), rs.getDouble("cuotaDeRecuperacion"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar curso
    public boolean updateC(Curso cu) {

        LocalDate fechaInicio, fechaTermino;

        //Convertimos los string a LocalDate en formato "yyyy-mm-dd"
        fechaInicio = LocalDate.parse(cu.getFechaInicio());
        fechaTermino = LocalDate.parse(cu.getFechaTermino());

        //Convertimos los LocalDate a SQL date
        java.sql.Date fi = java.sql.Date.valueOf(fechaInicio);
        java.sql.Date fe = java.sql.Date.valueOf(fechaTermino);

        try {
            String query = "UPDATE curso SET " + "nombreC='" + cu.getNombre() + "'," + "fechaInicio='" + fi + "'," + "fechaTermino='" + fe + "'," + "cuotaDeRecuperacion='" + cu.getCuota() + "' WHERE idCurso = " + cu.getIdCurso() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar curso
    public boolean deleteC(int id) {
        try {

            String query = "DELETE  FROM  asignacion  WHERE idCurso = " + id + "";
            st.executeUpdate(query);
            query = "DELETE  FROM  curso  WHERE idCurso = " + id + "";
            st.executeUpdate(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//Obtener el id de un curso con su nombre
    public int getIdC(String nombre) {
        try {
            int id;
            String query = "SELECT * FROM curso WHERE nombreC = '" + nombre + "'";
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("idCurso");
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

//Obtener el nombre de un curso con su id
    public String getNombreC(int id) {
        try {
            String nombre;
            String query = "SELECT * FROM curso WHERE idCurso = '" + id + "'";
            rs = st.executeQuery(query);
            rs.next();
            nombre = rs.getString("nombreC");
            return nombre;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//----------------------------------Aqui comienzan los crud de asignación--------------------------------------
//Insertar una asignación
    public boolean insertS(Asignacion as) {
        try {
            String query = "INSERT INTO asignacion VALUES('" + as.getIdAlumno() + "','" + as.getIdCurso() + "','" + as.getHorario() + "','" + as.getTipo() + "');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Insertar una asignación
    public Asignacion buscaS(Asignacion as) {
        try {
            String query = "SELECT FROM asignacion WHERE idAlumno = " + as.getIdAlumno() + " AND idCurso = " + as.getIdCurso() + "";
            rs=st.executeQuery(query);
            rs.next();
            as.setHorario(rs.getString("horario"));
            as.setTipo(rs.getInt("tipoCurso"));
            return as;
        } catch (Exception e) {
            e.printStackTrace();
            return as;
        }
    }
    
//Buscar todas las asignaciones
    public ResultSet buscaTodosS() {
        try {
            String query = "SELECT nombre, paterno, materno, horario, tipoCurso, nombreC\n" + "FROM alumno inner join asignacion ON  alumno.idAlumno = asignacion.idAlumno inner join curso ON asignacion.idCurso = curso.idCurso;";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

// Buscar asignación por alumno
    public ResultSet buscaAsignacionAlumno(String nombre) {
        try {
            String query = "SELECT nombre, paterno, materno, horario, tipoCurso, nombreC\n" + "FROM alumno join asignacion ON  alumno.idAlumno = asignacion.idAlumno inner join curso ON asignacion.idCurso = curso.idCurso WHERE nombre = '" + nombre + "'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//Buscar asignación por curso

    public ResultSet buscaAsignacionCurso(String nombre) {
        try {
            String query = "SELECT nombre, paterno, materno, horario, tipoCurso, nombreC\n" + "FROM alumno join asignacion ON  alumno.idAlumno = asignacion.idAlumno inner join curso ON asignacion.idCurso = curso.idCurso where nombreC = '" + nombre + "'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Modificar asignación
    public boolean updateS(Asignacion as) {
        try {
            String query = "UPDATE asignacion SET " + "horario='" + as.getHorario() + "'," + "tipoCurso=" + as.getTipo() + " WHERE idAlumno = " + as.getIdAlumno() + " AND idCurso = " + as.getIdCurso() + ";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Eliminar asignacion
    public boolean deleteS(Asignacion as) {
        try {
            String query = "DELETE FROM asignacion WHERE idAlumno = " + as.getIdAlumno() + " AND idCurso = " + as.getIdCurso() + "";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Genera una lista de las asignaciones
    public ArrayList<Asignacion> ListaTodosS() {

        ArrayList<Asignacion> asignacion = new ArrayList<Asignacion>();

        try {

            Crud cr = new Crud();
            String query = "select * from asignacion";
            ResultSet res = st.executeQuery(query);

            while (res.next()) {

                asignacion.add(new Asignacion(res.getInt("idAlumno"), res.getInt("idCurso"), res.getString("horario"), res.getInt("tipoCurso")));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return asignacion;
    }

}
