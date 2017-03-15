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
import modelos.Curso;

/**
 *
 * @author Steeltwins
 */
public class CursoRequest implements Runnable{
     GUI_Curso parent;
    private Curso curso;
    private int operation;
    private char request;
    private final String IP_ADDRESS = "127.0.0.1";
    private final int PORT = 8200;

    public CursoRequest(GUI_Curso parent, Curso curso, int operation, char request) {
        this.parent = parent;
        this.curso = curso;
        this.operation = operation;
        this.request = request;
    }

    public CursoRequest(GUI_Curso parent, Curso curso, char request) {
        this.parent = parent;
        this.curso = curso;
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
            peticion.writeObject("curso");

            //SE MANDA EL TIPO DE OPERACION
            if (this.operation == 1) {
                peticion.writeObject("insertar");
            } else {
                peticion.writeObject("editar");
            }
            peticion.writeObject(this.curso);//Se manda el objeto
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
                    this.parent.getCourses();
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
            peticion.writeObject("curso");

            peticion.writeObject("borrar");//Se manda operacion
            peticion.writeObject(this.curso);//Se manda objeto
            exitoso = (boolean) respuesta.readObject();
            if (exitoso) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                synchronized (this.parent) {
                    this.parent.getCourses();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exitoso;
    }

    public Curso sendBuscar() {
        Curso curso = new Curso();

        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("curso");

            peticion.writeObject("buscar");//Se manda operacion
            peticion.writeObject(this.curso);//Se manda objeto
            curso = (Curso) respuesta.readObject();

            JOptionPane.showMessageDialog(null, "Curso encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.setValuesSearched(curso);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada");

        } catch (IOException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curso;
    }

    public ArrayList<Curso> sendListar() {
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
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cursos;
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
            }
        } catch (IOException ex) {
            Logger.getLogger(CursoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
