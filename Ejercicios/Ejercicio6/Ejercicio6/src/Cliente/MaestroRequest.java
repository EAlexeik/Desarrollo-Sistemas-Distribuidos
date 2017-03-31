/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Modelo.Alumno;
import Modelo.Maestro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alexeik
 */
public class MaestroRequest implements Runnable{
    GUILogin parent;
    private Maestro maestro;
    private int id;
    private String contrasenia;
    private int operation;
    private char request;
    private final String IP_ADDRESS = "127.0.0.1";
    private final int PORT = 8200;

    MaestroRequest(GUILogin aThis, Maestro maestro, char c) {
        this.maestro=maestro;
        this.request=c;
        this.parent=aThis;
    }
    
    public Maestro sendAutentificar(){
        Maestro m = new Maestro();
        boolean exitoso = false;
        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            peticion.writeObject("autentificar");//Se manda operacion
            peticion.writeObject(this.maestro);//Se manda objeto
            m = (Maestro) respuesta.readObject();
            exitoso = (boolean) respuesta.readObject();
            if (exitoso) {
                JOptionPane.showMessageDialog(null, "Maestro Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                synchronized (this.parent) {
                    this.parent.cerrar(maestro);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Se produjo un error", "Error", JOptionPane.INFORMATION_MESSAGE);
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
        return m;
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
