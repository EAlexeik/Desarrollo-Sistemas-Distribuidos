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

public class AlumnoRequest implements Runnable {
     GUI_Alumno parent;
    private Alumno alumno;
    private int operation;
    private char request;
    private final String IP_ADDRESS = "127.0.0.1";
    private final int PORT = 8200;

    public AlumnoRequest(GUI_Alumno parent, Alumno alumno, int operation, char request) {
        this.parent = parent;
        this.alumno = alumno;
        this.operation = operation;
        this.request = request;
    }
    public AlumnoRequest(GUI_Alumno parent, Alumno alumno, char request) {
        this.parent = parent;
        this.alumno = alumno;
        this.request = request;
    }
    public boolean sendUpdate() throws UnknownHostException, IOException {
        boolean exitoso = false;
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            //SE MANDA EL TIPO DE OPERACION
            if (this.operation == 1) {
                peticion.writeObject("insertar");
            } else {
                peticion.writeObject("editar");
            }
            peticion.writeObject(this.alumno);//Se manda el objeto
            System.out.println("Elemento enviado");
            exitoso = (boolean) respuesta.readObject();
            System.out.println("Respuesta devuielta");
            if (exitoso) {
                if (operation == 1) {
                    JOptionPane.showMessageDialog(null, "Insercion exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                synchronized (this.parent) {
                    this.parent.getStudents();
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
            peticion.writeObject("alumno");

            peticion.writeObject("borrar");//Se manda operacion
            peticion.writeObject(this.alumno);//Se manda objeto
            exitoso = (boolean) respuesta.readObject();
            if (exitoso) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                synchronized (this.parent) {
                    this.parent.getStudents();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada 1");

        } catch (IOException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exitoso;
    }

    public Alumno sendBuscar() {
        Alumno a = new Alumno();

        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            peticion.writeObject("buscar");//Se manda operacion
            peticion.writeObject(this.alumno);//Se manda objeto
            a = (Alumno) respuesta.readObject();

            JOptionPane.showMessageDialog(null, "Alumno encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            synchronized (this.parent) {
                this.parent.setValuesSearched(a);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada 2");

        } catch (IOException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    public ArrayList<Alumno> sendListar() {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            peticion.writeObject("listar");//Se manda operacion
            alumnos = (ArrayList<Alumno>) respuesta.readObject();
            synchronized (this.parent) {
                this.parent.listStudents(alumnos);
            }
            peticion.close();
            respuesta.close();
            socket.close();
            System.out.println("Conexion cerrada 3");

        } catch (IOException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
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
            }
        } catch (IOException ex) {
            Logger.getLogger(AlumnoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
