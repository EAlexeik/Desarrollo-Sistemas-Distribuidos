public class Cliente{
	public satic void main(String arg[]) throws UnknownHostException, IOException{
		Socket socket=new Socket("127.0.0.1",Servidor.PUERTO);
		InputStreamReader is=socket.getInputStream();
		BufferedReader br=new BufferedReader(is);
		System.out.println(br.readline());
		br.close();
		socket.close();
	}
}
