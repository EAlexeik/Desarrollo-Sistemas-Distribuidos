/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alexeik
 */
public class Carrera {
    private int idCarrera;
    private String nombre;
    private int numSemestre;
    private int idEscuela;

    public Carrera(int idCarrera, String nombre, int numSemestre, int idEscuela) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.numSemestre = numSemestre;
        this.idEscuela = idEscuela;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSemestre() {
        return numSemestre;
    }

    public void setNumSemestre(int numSemestre) {
        this.numSemestre = numSemestre;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(int idEscuela) {
        this.idEscuela = idEscuela;
    }
    
}
