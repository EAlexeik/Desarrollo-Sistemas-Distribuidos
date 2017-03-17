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
public class Parcial {
    private int idParcial;
    private String nombre;
    private int idExamen;
    private int idAsignatura;

    public Parcial(int idParcial, String nombre, int idExamen, int idAsignatura) {
        this.idParcial = idParcial;
        this.nombre = nombre;
        this.idExamen = idExamen;
        this.idAsignatura = idAsignatura;
    }

    public int getIdParcial() {
        return idParcial;
    }

    public void setIdParcial(int idParcial) {
        this.idParcial = idParcial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    
    
}
