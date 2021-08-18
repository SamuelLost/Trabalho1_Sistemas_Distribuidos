package sockets.TCP;
import java.net.*;
import java.io.*;
import entities.*;
import stream.PessoaInputStream;
import stream.PessoaOutputStream;

public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		Socket s = null;
		Pessoa[] pessoas = new Pessoa[10];
		Pessoa pessoa1 = new Pessoa("Samuel", "123.456.789-00", 20);
		Pessoa pessoa2 = new Pessoa("Henrique", "001.234.567-89", 18);
		pessoas[0] = pessoa1;
		pessoas[1] = pessoa2;
		try{
			
			int serverPort = 7896;
			OutputStream fileOutput = new FileOutputStream("saida.txt");
			PessoaOutputStream pessoaOutput = new PessoaOutputStream(pessoas, fileOutput);
			
			InputStream fileInput = new FileInputStream("saida.txt");
			PessoaInputStream pessoaInput = new PessoaInputStream(fileInput);
			
			//1.e)
			pessoaOutput.writeFileOutput();
			
			//1.d)
			pessoaOutput.writeScreen();
			
			s = new Socket("localhost", serverPort);    
//			DataInputStream in = new DataInputStream( s.getInputStream());
//			DataOutputStream out =new DataOutputStream( s.getOutputStream());
			
			//1.f)
			OutputStream dataOutput = new DataOutputStream(s.getOutputStream());
			PessoaOutputStream pessoaOutputSockets = new PessoaOutputStream(pessoas, dataOutput);
			pessoaOutputSockets.writeSocket();
			
			pessoaInput.FileInputStream();
			
			pessoaOutput.close();
			pessoaOutputSockets.close();
			pessoaInput.close();
//			out.writeUTF("teste");      	// UTF is a string encoding see Sn. 4.4
//			String data = in.readUTF();	    // read a line of data from the stream
//			System.out.println("Received: "+ data) ; 
			
		} catch (UnknownHostException e){
			System.out.println("Socket: "+e.getMessage());
		} catch (EOFException e){
			System.out.println("EOF: "+e.getMessage());
		} catch (IOException e){
			System.out.println("Readline: "+e.getMessage());
		} finally {if(s!=null) 
			try {
				s.close();
			} catch (IOException e){
				System.out.println("Close: "+e.getMessage());
			}
		}
     }
}