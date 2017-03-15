/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Lock
 */
public class Asignacion implements java.io.Serializable {
    
    int idAlumno,idCurso;
    String horario;
    int tipo;

    public Asignacion()
    {
        
    }
    
    public Asignacion(int idAlumno, int idCurso, String horario, int tipo) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.horario = horario;
        this.tipo = tipo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
   
    
    
    
}
