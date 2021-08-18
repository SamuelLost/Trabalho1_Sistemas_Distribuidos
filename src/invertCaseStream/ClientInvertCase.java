package invertCaseStream;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientInvertCase {
	public static void main (String args[]) {
		// arguments supply message and hostname
		//4.f)
		
		Socket s = null;
		String frase = "OlÁ, Meu NOme é SAMUEL";
				
		try{
			
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);    
			
			DataOutputStream dataOutput = new DataOutputStream(s.getOutputStream());
			
			char[] caracteres = frase.toCharArray();
			
			for(int i=0; i < caracteres.length; i++) {
				char ch = caracteres[i];
				
				if(Character.isUpperCase(ch)) {
					caracteres[i] = Character.toLowerCase(ch);
				}
				else if(Character.isLowerCase(ch)) {
					caracteres[i] = Character.toUpperCase(ch);
				}
				
				dataOutput.write(caracteres[i]);
			}
			
//			for(int i=0; i < caracteres.length; i++) {
//				dataOutput.write(caracteres[i]);
//			}
			
			dataOutput.close();
						
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
