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
public class Grupo {
    private int idGrupo;
    private String salon;
    private int idCarrera;
    private int idMaestro;

    public Grupo(int idGrupo, String salon, int idCarrera, int idMaestro) {
        this.idGrupo = idGrupo;
        this.salon = salon;
        this.idCarrera = idCarrera;
        this.idMaestro = idMaestro;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(int idMaestro) {
        this.idMaestro = idMaestro;
    }
    
}
