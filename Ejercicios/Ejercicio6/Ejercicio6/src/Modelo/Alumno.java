/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author alexeik
 */
public class Alumno implements Serializable{
    private int idAlumno;
    private String contrasenia;
    private String emailEscolar;
    private String fechaIngreso;
    private int idGrupo;
    private int idPersona;

    public Alumno(int idAlumno, String contrasenia, String emailEscolar, String fechaIngreso, int idGrupo, int idPersona) {
        this.idAlumno = idAlumno;
        this.contrasenia = contrasenia;
        this.emailEscolar = emailEscolar;
        this.fechaIngreso = fechaIngreso;
        this.idGrupo = idGrupo;
        this.idPersona = idPersona;
    }

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getEmailEscolar() {
        return emailEscolar;
    }

    public void setEmailEscolar(String emailEscolar) {
        this.emailEscolar = emailEscolar;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", contrasenia=" + contrasenia + ", emailEscolar=" + emailEscolar + ", fechaIngreso=" + fechaIngreso + ", idGrupo=" + idGrupo + ", idPersona=" + idPersona + '}';
    }

    
}
