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
public class Curso implements java.io.Serializable {

    private String nombre, fechaInicio, fechaTermino;
    private int idCurso;

    private double cuota;

    public Curso() {

    }

    public Curso(int idCurso,String nombre, String fechaInicio, String fechaTermino, double cuota) {
        this.idCurso=idCurso;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.cuota = cuota;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int curso) {
        this.idCurso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

}
