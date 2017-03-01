package com.ipn.mx.otros;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {
    public static final int PUERTO=6666;
    ServerSocket socketServidor;
    public Servidor(){
        try{
            socketServidor = new ServerSocket(PUERTO);
            System.out.println("Funcionando");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        start();        
    }
    
    @Override
    public void run(){
        try{
            while(true){
                Socket socketCliente = socketServidor.accept();
                SQLConexion miConexion = new SQLConexion(socketCliente);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Servidor();
    }
}




