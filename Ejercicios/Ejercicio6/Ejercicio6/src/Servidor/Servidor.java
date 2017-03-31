/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

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
import Servicios.Crud;
import Servicios.EmpacaBusqueda;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author alexeik
 */
public class Servidor{

    private final static int PORT = 8200;

    public static void startServer() throws IOException {

        ServerSocket servidor = null;
        Socket socketCliente = null;
        ObjectOutputStream respuesta = null;
        ObjectInputStream peticion = null;

        try {

            servidor = new ServerSocket(PORT);
            System.out.println("Socket TCP iniciado. . .");
            Crud cru = new Crud(); //Objeto de tipo crud
            EmpacaBusqueda em = new EmpacaBusqueda();//objeto usado para crear las listas de busquedas y manipulacion de asignaciones
            ArrayList<Alumno> busquedaAlumno; //Lista de estructuras de tipo alumno
            ArrayList<Asignatura> busquedaAsignatura; //Lista de estructuras de tipo asignacion
            ArrayList<Carrera> busquedaCarrera;
            ArrayList<Escuela> busquedaEscuela;
            ArrayList<Examen> busquedaExamen;
            ArrayList<Grupo> busquedaGrupo;
            ArrayList<Maestro> busquedaMaestro;
            ArrayList<Parcial> busquedaParcial;
            ArrayList<Persona> busquedaPersona;
            ArrayList<Pregunta> busquedaPregunta;
            ArrayList<Respuesta> busquedaRespuesta;
            Alumno al;
            Asignatura as;
            Carrera ca;
            Escuela es;
            Examen ex;
            Grupo gru;
            Maestro ma;
            Parcial pa;
            Persona pe;
            Pregunta pre;
            Respuesta re;
            String tabla, accion, nombreA, nombreC;
            socketCliente = servidor.accept();
            respuesta = new ObjectOutputStream(socketCliente.getOutputStream());
            peticion = new ObjectInputStream(socketCliente.getInputStream());

            while ((tabla = (String) peticion.readObject()) != null) {

                switch (tabla) {
                    case "alumno":
                        System.out.println("Entro al alumno");
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            
                            case "insertar":
                                al = (Alumno) peticion.readObject();
                                if (cru.insertAlum(al)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                al = (Alumno) peticion.readObject();
                                if (cru.updateAlum(al)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                al = (Alumno) peticion.readObject();
                                if (cru.deleteAlum(al)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                            case "buscar":
                                
                                al = (Alumno) peticion.readObject();
                                al = cru.buscaNombreAlum(al.getIdAlumno());
                                respuesta.writeObject(al);
                                
                                break;
                            case "listar":
                                busquedaAlumno = em.ListaTodosAlumno();
                                respuesta.writeObject(busquedaAlumno);
                                break;
                            case "autentificar":
                                al= (Alumno)peticion.readObject();
                                al=cru.buscarAlumnoContrasenia(al.getIdAlumno(), al.getContrasenia());
                                System.out.println(al.toString());
                                respuesta.writeObject(al);
                                break;
                        }   break;
                    case "asignatura":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                as = (Asignatura) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertAsig(as)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                as = (Asignatura) peticion.readObject();
                                if (cru.updateAsig(as)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                as = (Asignatura) peticion.readObject();
                                if (cru.deleteAsig(as)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                as = (Asignatura) peticion.readObject();
                                as = cru.buscaNombreAsig(as.getIdAsignatura());
                                respuesta.writeObject(as);
                                break;
                                
                            case "listar":
                                busquedaAsignatura = em.ListaTodosAsignatura();
                                respuesta.writeObject(busquedaAsignatura);
                                break;
                        }   break;
                    case "carrera":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                ca = (Carrera) peticion.readObject();
                                if (cru.insertCarrera(ca)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                ca = (Carrera) peticion.readObject();
                                if (cru.updateCarrera(ca)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                ca = (Carrera) peticion.readObject();
                                if (cru.deleteCarrera(ca)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                            case "buscar":
                                ca = (Carrera) peticion.readObject();
                                ca=cru.buscaNombreCarrera(ca.getIdCarrera());
                                respuesta.writeObject(ca);
                                break;
                                
                            case "listar":
                                busquedaCarrera = em.ListaTodosCarrera();
                                respuesta.writeObject(busquedaCarrera);
                                break;
                                
//                        case "buscarAlumno":
//                            nombreA = (String)peticion.readObject();
//                            busquedaS = em.ListaNombreAlumnoS(nombreA);
//                            respuesta.writeObject(busquedaS);                            
//                            break;
//                            
//                        case "buscarCurso":
//                            nombreC = (String)peticion.readObject();
//                            //busquedaS = em.ListaNombreCursoS(nombreC);
//                            respuesta.writeObject(busquedaS); 
//                            break;
//                            
//                        case "buscarTodos":
//                            busquedaS = em.ListaTodosS();
//                            respuesta.writeObject(busquedaS); 
//                            break;
                        }   break;
                    case "escuela":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                es = (Escuela) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertEscuela(es)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                es = (Escuela) peticion.readObject();
                                if (cru.updateEscuela(es)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                es = (Escuela) peticion.readObject();
                                if (cru.deleteEscuela(es)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                es = (Escuela) peticion.readObject();
                                es = cru.buscaNombreEscuela(es.getIdEscuela());
                                respuesta.writeObject(es);
                                break;
                                
                            case "listar":
                                busquedaEscuela = em.ListaTodosEscuela();
                                respuesta.writeObject(busquedaEscuela);
                                break;
                        }   break;
                    case "examen":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                ex = (Examen) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertExamen(ex)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                ex = (Examen) peticion.readObject();
                                if (cru.updateExamen(ex)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                ex = (Examen) peticion.readObject();
                                if (cru.deleteExamen(ex)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                ex = (Examen) peticion.readObject();
                                ex = cru.buscaNombreExamen(ex.getIdExamen());
                                respuesta.writeObject(ex);
                                break;
                                
                            case "listar":
                                busquedaExamen = em.ListaTodosExamen();
                                respuesta.writeObject(busquedaExamen);
                                break;
                        }   break;
                    case "grupo":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                gru = (Grupo) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertGrupo(gru)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                gru = (Grupo) peticion.readObject();
                                if (cru.updateGrupo(gru)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                gru = (Grupo) peticion.readObject();
                                if (cru.deleteGrupo(gru)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                gru = (Grupo) peticion.readObject();
                                gru = cru.buscaNombreGrupos(gru.getIdGrupo());
                                respuesta.writeObject(gru);
                                break;
                                
                            case "listar":
                                busquedaGrupo = em.ListaTodosGrupo();
                                respuesta.writeObject(busquedaGrupo);
                                break;
                        }   break;
                    case "maestro":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                ma = (Maestro) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertMaestro(ma)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                ma = (Maestro) peticion.readObject();
                                if (cru.updateMaestro(ma)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                ma = (Maestro) peticion.readObject();
                                if (cru.deleteMaestro(ma)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                ma = (Maestro) peticion.readObject();
                                ma = cru.buscaNombreMaestros(ma.getIdMaestro());
                                respuesta.writeObject(ma);
                                break;
                                
                            case "listar":
                                busquedaMaestro = em.ListaTodosMaestro();
                                respuesta.writeObject(busquedaMaestro);
                                break;
                        }   break;
                    case "parcial":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                pa = (Parcial) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertParcial(pa)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                pa = (Parcial) peticion.readObject();
                                if (cru.updateParcial(pa)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                pa = (Parcial) peticion.readObject();
                                if (cru.deleteParcial(pa)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                pa = (Parcial) peticion.readObject();
                                pa = cru.buscaNombreParcial(pa.getIdParcial());
                                respuesta.writeObject(pa);
                                break;
                                
                            case "listar":
                                busquedaParcial = em.ListaTodosParcial();
                                respuesta.writeObject(busquedaParcial);
                                break;
                        }   break;
                    case "persona":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                pe = (Persona) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertPersona(pe)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                pe = (Persona) peticion.readObject();
                                if (cru.updatePersona(pe)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                pe = (Persona) peticion.readObject();
                                if (cru.deletePersona(pe)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                pe = (Persona) peticion.readObject();
                                pe = cru.buscaNombrePersona(pe.getIdPersona());
                                respuesta.writeObject(pe);
                                break;
                                
                            case "listar":
                                busquedaPersona = em.ListaTodosPersona();
                                respuesta.writeObject(busquedaPersona);
                                break;
                        }   break;
                    case "pregunta":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                pre = (Pregunta) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertPregunta(pre)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                pre = (Pregunta) peticion.readObject();
                                if (cru.updatePregunta(pre)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                pre = (Pregunta) peticion.readObject();
                                if (cru.deletePregunta(pre)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                pre = (Pregunta) peticion.readObject();
                                pre = cru.buscaNombrePregunta(pre.getIdPregunta());
                                respuesta.writeObject(pre);
                                break;
                                
                            case "listar":
                                busquedaPregunta = em.ListaTodosPregunta();
                                respuesta.writeObject(busquedaPregunta);
                                break;
                        }   break;
                    case "respuesta":
                        accion = (String) peticion.readObject();
                        switch (accion) {
                            case "insertar":
                                re = (Respuesta) peticion.readObject();
                                //System.out.println(" a punto de insertar");
                                if (cru.insertRespuesta(re)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "editar":
                                re = (Respuesta) peticion.readObject();
                                if (cru.updateRespuesta(re)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "borrar":
                                re = (Respuesta) peticion.readObject();
                                if (cru.deleteRespuesta(re)) {
                                    respuesta.writeObject(true);
                                } else {
                                    respuesta.writeObject(false);
                                }
                                break;
                                
                            case "buscar":
                                re = (Respuesta) peticion.readObject();
                                re = cru.buscaNombreRespuestas(re.getIdRespuesta());
                                respuesta.writeObject(re);
                                break;
                                
                            case "listar":
                                busquedaRespuesta = em.ListaTodosRespuesta();
                                respuesta.writeObject(busquedaRespuesta);
                                break;
                        }   break;
                    default:
                        break;
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Conexion finalizada");

            respuesta.close();
            peticion.close();
            socketCliente.close();
            servidor.close();

        }

    }

    public static void main(String[] args) throws IOException {
        int limite = 1000;
        int peticiones = 0;
        do {
            startServer();
        } while (peticiones++ < limite);

    }

}
