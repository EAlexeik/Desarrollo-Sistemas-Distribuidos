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
public class Examen implements Serializable{
    private int idExamen;
    private String current_date;
    private double calificacion;
    private int idAlumno;

    public Examen(int idExamen, String current_date, double calificacion, int idAlumno) {
        this.idExamen = idExamen;
        this.current_date = current_date;
        this.calificacion = calificacion;
        this.idAlumno = idAlumno;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
}
