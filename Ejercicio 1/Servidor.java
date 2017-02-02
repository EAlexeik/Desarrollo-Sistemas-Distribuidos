public class Servidor{
	public static final int PUERTO=5000;
	private static String metodoUno(){
		GregorianCalendar calendario=new GregorianCalendar();
		Date fecha=calendario.getTime();
		DateFormat hora=DateFormat.getTimeInstance(DateFormat.SHORT);
		return hora.format(fecha);
	}
	public satic void main(String[] args) throws IOException{
		ServerSocket socketServidor=new ServerSocket(PUERTO);
		while(true){
			Socket socketCliente=socketServidor.accept();
			PrintWriter pw=new PrintWriter(socketCliente.getOutputStream());
			pw.close();
			socketCliente.close();
		}
	}
}

