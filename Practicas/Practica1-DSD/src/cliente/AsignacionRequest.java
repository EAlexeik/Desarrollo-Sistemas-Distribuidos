/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Alumno;
import modelos.Asignacion;
import modelos.Curso;

/**
 *
 * @author Steeltwins
 */
public class AsignacionRequest implements Runnable {
     GUI_Asignacion parent;
    private Asignacion asignacion;
    private int operation;
    private char request;
    private final String IP_ADDRESS = "127.0.0.1";
    private final int PORT = 8200;

    public AsignacionRequest(GUI_Asignacion parent, Asignacion asignacion, int operation, char request) {
        this.parent = parent;
        this.asignacion = asignacion;
        this.operation = operation;
        this.request = request;
    }

    public AsignacionRequest(GUI_Asignacion parent, Asignacion asignacion, char request) {
        this.parent = parent;
        this.asignacion = asignacion;
        this.request = request;
    }
    
     public AsignacionRequest(GUI_Asignacion parent,char request) {
        this.parent = parent;
        this.request = request;
    }

    public boolean sendUpdate() throws UnknownHostException, IOException {
        boolean exitoso = false;
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            //System.out.println("Antes de enviar la operacion");
            peticion.writeObject("asignacion");

            //SE MANDA EL TIPO DE OPERACION
            if (this.operation == 1) {
                peticion.writeObject("insertar");
            } else {
                peticion.writeObject("editar");
            }
            peticion.writeObject(this.asignacion);//Se manda el objeto
            System.out.println("Elemento enviado");
            exitoso = (boolean) respuesta.readObject();
            System.out.println("Respuesta devuelta");
            if (exitoso) {
                if (operation == 1) {
                    JOptionPane.showMessageDialog(null, "Insercion exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                synchronized (this.parent) {
                    this.parent.getAssignations();
                }
            } else {
                System.out.println("Respuesta false");
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            exitoso = false;
        } catch (IOException e) {
            e.printStackTrace();
            exitoso = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            exitoso = false;
        }
        return exitoso;
    }

    public boolean sendDelete() {
        boolean exitoso = false;

        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("asignacion");

            peticion.writeObject("borrar");//Se manda operacion
            peticion.writeObject(this.asignacion);//Se manda objeto
            exitoso = (boolean) respuesta.readObject();
            if (exitoso) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                synchronized (this.parent) {
                    this.parent.getAssignations();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exitoso;
    }

    public Asignacion sendBuscar() {
        Asignacion asignacion = new Asignacion();

        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("asignacion");

            peticion.writeObject("buscar");//Se manda operacion
            peticion.writeObject(this.asignacion);//Se manda objeto
            asignacion = (Asignacion) respuesta.readObject();

            JOptionPane.showMessageDialog(null, "Curso encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.setValuesSearched(asignacion);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignacion;
    }

    public ArrayList<Asignacion> sendListar() {
        ArrayList<Asignacion> asignacion = new ArrayList<Asignacion>();
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("asignacion");
            System.out.println("asignacion enviada");
            peticion.writeObject("listar");//Se manda operacion
            asignacion = (ArrayList<Asignacion>) respuesta.readObject();
            //JOptionPane.showMessageDialog(null, "Producto encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.listAssignations(asignacion);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asignacion;
    }

    public ArrayList<Curso> sendListarCursos() {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("curso");

            peticion.writeObject("listar");//Se manda operacion
            cursos = (ArrayList<Curso>) respuesta.readObject();
            //JOptionPane.showMessageDialog(null, "Producto encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.listCourses(cursos);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
    }
    
    public ArrayList<Alumno> sendListarAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            peticion.writeObject("listar");//Se manda operacion
            alumnos = (ArrayList<Alumno>) respuesta.readObject();
            //JOptionPane.showMessageDialog(null, "Producto encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.listStudents(alumnos);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnos;
    }
    

    @Override
    public void run() {
        try {
            if (this.request == 'u') {
                sendUpdate();
            } else if (this.request == 'd') {
                sendDelete();
            } else if (this.request == 'b') {
                sendBuscar();
            } else if (this.request == 'l') {
                sendListar();
            } else if (this.request == 'c') {
                sendListarCursos();
            } else if (this.request == 's') {
                sendListarAlumnos();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(AsignacionRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
