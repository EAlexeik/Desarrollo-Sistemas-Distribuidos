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
public class Maestro implements Serializable{
    private int idMaestro;
    private String contrasenia;
    private String grado;
    private String fechaIngreso;
    private int idPersona;

    public Maestro(int idMaestro, String contrasenia, String grado, String fechaIngreso, int idPersona) {
        this.idMaestro = idMaestro;
        this.contrasenia = contrasenia;
        this.grado = grado;
        this.fechaIngreso = fechaIngreso;
        this.idPersona = idPersona;
    }

    public Maestro() {
    }

    public int getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
}
