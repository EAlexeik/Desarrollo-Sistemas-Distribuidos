import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Date;
import java.io.IOException;

public class Servidor{
	public static final int PUERTO=5000;
	private static String metodoUno(){
		GregorianCalendar calendario=new GregorianCalendar();
		Date fecha=calendario.getTime();
		DateFormat hora=DateFormat.getTimeInstance(DateFormat.SHORT);
		return hora.format(fecha);
	}
	private static String metodoDos(){
		GregorianCalendar calendario=new GregorianCalendar();
                Date fecha=calendario.getTime();
                return fecha.toString();
	}
	public static void main(String[] args) throws IOException{
		ServerSocket socketServidor=new ServerSocket(PUERTO);
		while(true){
			Socket socketCliente=socketServidor.accept();
			PrintWriter pw=new PrintWriter(socketCliente.getOutputStream());
			System.out.println(Servidor.metodoDos());
			System.out.println(Servidor.metodoUno());
			pw.close();
			socketCliente.close();
		}
	}
}

