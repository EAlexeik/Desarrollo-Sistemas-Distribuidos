import java.net.Socket;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;

public class Cliente{
	public static void main(String arg[]) throws UnknownHostException, IOException{
		Socket socket=new Socket("127.0.0.1",Servidor.PUERTO);
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		System.out.println(br.readLine());
		br.close();
		socket.close();
	}
}
