package sockets.TCP;
import java.net.*;

import stream.PessoaInputStream;

import java.io.*;
public class TCPServer {
	public static void main (String args[]) {
		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				System.out.print("Porta: "+serverPort);
				System.out.println(" | Servidor escutando...\n");
				Socket clientSocket = listenSocket.accept();
				
				InputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
	           	PessoaInputStream pessoaInputStream = new PessoaInputStream(dataInputStream);
	           	pessoaInputStream.readSocket();
			}
		} catch(IOException e) {
			System.out.println("Listen socket: "+e.getMessage()); 
		} 
	}
}

