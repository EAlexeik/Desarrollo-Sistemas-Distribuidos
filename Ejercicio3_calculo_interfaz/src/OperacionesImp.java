/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexeik
 */
public class OperacionesImp implements Operaciones{
    
    /*
    public static void main(String args[]){
        int aux[]={4,1,11,13,2,7};
        Operaciones op=new OperacionesImp();
        System.out.println(op.Promedio(aux));
        System.out.println(op.DesviacionEstandar(aux));
    }
    */
    @Override
    public float Promedio(int[] datos) {
        float promedio=0;
        for(int dato:datos){
            promedio+=dato;
        }
        promedio/=datos.length;
        return promedio;
    }

    @Override
    public float DesviacionEstandar(int[] datos) {
        if(datos.length==1)
            return -1;
        float promedio=Promedio(datos);
        float desviacion=0;
        for(int i=0;i<datos.length;i++){
            desviacion+=Math.pow(datos[i]-promedio, 2);
        }
        desviacion=(float) Math.sqrt(desviacion/(datos.length-1));
        return desviacion;
    }
}
