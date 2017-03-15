package server;

import modelos.Curso;
import modelos.Alumno;
import modelos.Asignacion;
import java.util.*;
import java.io.*;
import java.net.*;
import servicios.*;

public class Servidor {

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
            ArrayList<Alumno> busquedaA; //Lista de estructuras de tipo alumno
            ArrayList<Curso> busquedaC;  //Lista de estructuras de tipo curso
            ArrayList<Asignacion> busquedaS; //Lista de estructuras de tipo asignacion
            Alumno al;
            Curso cu;
            Asignacion as;
            String tabla, accion, nombreA, nombreC;
            socketCliente = servidor.accept();
            respuesta = new ObjectOutputStream(socketCliente.getOutputStream());
            peticion = new ObjectInputStream(socketCliente.getInputStream());

            while ((tabla = (String) peticion.readObject()) != null) {

                if (tabla.equals("alumno")) {

                    accion = (String) peticion.readObject();

                    switch (accion) {

                        case "insertar":
                            al = (Alumno) peticion.readObject();
                            if (cru.insertA(al)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "editar":
                            al = (Alumno) peticion.readObject();
                            if (cru.updateA(al)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "borrar":
                            al = (Alumno) peticion.readObject();
                            if (cru.deleteA(al)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;
                        case "buscar":

                            al = (Alumno) peticion.readObject();
                            al = cru.buscaNombreA(al.getIdAlumno());
                            respuesta.writeObject(al);

                            break;
                        case "listar":
                            busquedaA = em.ListaTodosA();
                            respuesta.writeObject(busquedaA);
                            break;
                    }

                } else if (tabla.equals("curso")) {

                    accion = (String) peticion.readObject();

                    switch (accion) {
                        case "insertar":
                            cu = (Curso) peticion.readObject();
                            //System.out.println(" a punto de insertar");
                            if (cru.insertC(cu)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "editar":
                            cu = (Curso) peticion.readObject();
                            if (cru.updateC(cu)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "borrar":
                            cu = (Curso) peticion.readObject();
                            if (cru.deleteC(cu.getIdCurso())) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "buscar":
                            cu = (Curso) peticion.readObject();
                            cu = cru.buscaNombreC(cu.getIdCurso());
                            respuesta.writeObject(cu);
                            break;

                        case "listar":
                            busquedaC = em.ListaTodosC();
                            respuesta.writeObject(busquedaC);
                            break;
                    }

                } else if (tabla.equals("asignacion")) {

                    accion = (String) peticion.readObject();

                    switch (accion) {
                        case "insertar":
                            as = (Asignacion) peticion.readObject();
                            if (cru.insertS(as)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "editar":
                            as = (Asignacion) peticion.readObject();
                            if (cru.updateS(as)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;

                        case "borrar":
                            as = (Asignacion) peticion.readObject();
                            if (cru.deleteS(as)) {
                                respuesta.writeObject(true);
                            } else {
                                respuesta.writeObject(false);
                            }
                            break;
                        case "buscar":
                            as = (Asignacion) peticion.readObject();
                            as=cru.buscaS(as);
                            respuesta.writeObject(as);
                            break;

                        case "listar":
                            busquedaS = cru.ListaTodosS();
                            respuesta.writeObject(busquedaS);
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
                    }
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
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
