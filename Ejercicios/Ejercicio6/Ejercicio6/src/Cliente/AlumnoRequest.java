/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Modelo.Alumno;
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
public class AlumnoRequest implements Runnable{
    private Alumno alumno;
    private int id;
    private String contrasenia;
    private int operation;
    private char request;
    private final String IP_ADDRESS = "127.0.0.1";
    private final int PORT = 8200;
    
    AlumnoRequest(Alumno alumno, char c) {
        this.alumno=alumno;
        this.request=c;
    }
   
    public Alumno sendAutentificar(){
        Alumno a = new Alumno();

        try {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            ObjectOutputStream peticion = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream respuesta = new ObjectInputStream(socket.getInputStream());
            //SE MANDA CADENA DE LA TABLA ESPECÍFICA
            peticion.writeObject("alumno");

            peticion.writeObject("autentificar");//Se manda operacion
            peticion.writeObject(this.alumno);//Se manda objeto
            a = (Alumno) respuesta.readObject();

            JOptionPane.showMessageDialog(null, "Alumno encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
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
    
    @Override
    public void run() {
        if (this.request == 'u') {
            //sendUpdate();
        } else if (this.request == 'd') {
            //sendDelete();
        } else if (this.request == 'b') {
            //sendBuscar();
        } else if (this.request == 'l') {
            //sendListar();
        } else if (this.request == 'c'){
            sendAutentificar();
        }
    }
}
