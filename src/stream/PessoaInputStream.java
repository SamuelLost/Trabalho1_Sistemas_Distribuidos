package stream;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class PessoaInputStream extends InputStream { 
	
	private InputStream inputStream;
	//2.a)
	public PessoaInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	//2.d) - Lendo do Socket
	public void readSocket() {
		try {			                
			int dados = this.inputStream.read();
			System.out.println("Dados que foram passados pelo Cliente:\n");
			while (dados != -1) {
		        System.out.print((char) dados);
		        dados = inputStream.read();
			}
		} catch (EOFException e){
			
			System.out.println("EOF: "+e.getMessage());
			
		} catch(IOException e) {
			
			System.out.println("Readline: "+e.getMessage());
			
		} finally {
			
			try {
				
				inputStream.close();
				
			}catch (IOException e){
				System.out.println("Erro ao fechar o arquivo!\n");
			}
		}
	}
	
	//2.c) - LENDO DO ARQUIVO
	public void FileInputStream(/*InputStream inputStream*/) {
		try {
			//inputStream = new FileInputStream("saida.txt");
			
			//PessoaInputStream pessoaInputStream = new PessoaInputStream(inputStream);
			
			int dados = inputStream.read();
			
			System.out.println("Dados lidos do arquivo:\n");
			
			while (dados != -1) {
				System.out.print((char) dados);
				dados = inputStream.read();
			}
			
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return inputStream.read();
	}
	
}
