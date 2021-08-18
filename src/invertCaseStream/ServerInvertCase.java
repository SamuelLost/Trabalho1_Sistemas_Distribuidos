package invertCaseStream;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerInvertCase {
	public static void main (String args[]) {
		//5.d)
		DataInputStream dataInputStream;
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				System.out.print("Porta: "+serverPort);
				System.out.println(" | Servidor escutando...\n");
				Socket clientSocket = listenSocket.accept();
				
				dataInputStream = new DataInputStream(clientSocket.getInputStream());
				int dado = dataInputStream.read();
				System.out.println("Frase que foi passada pela classe ClientInvertCase:\n");
				while(dado != -1) {
					System.out.printf("%c", (char) dado);
					dado = dataInputStream.read();
				}
				System.out.println("\n");
			}
		} catch(IOException e) {
			System.out.println("Listen socket: "+e.getMessage()); 
		} 
	}
}
