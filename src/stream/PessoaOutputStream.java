package stream;
import java.io.IOException;
import java.io.OutputStream;

import entities.Pessoa;

public class PessoaOutputStream extends OutputStream{

	private Pessoa[] pessoas;
	private OutputStream outputStream;
	
	//1.c)
	public PessoaOutputStream(Pessoa[] pessoas, OutputStream outputStream) {
		this.pessoas = pessoas;
		this.outputStream = outputStream;
	}
	private static String intToString(int valor) {
		return String.valueOf(valor);
	}
	
	//Contando o número de pessoas cadastradas 
	private static int numOfPos(Pessoa[] pessoas) {
		int contador=0;
		for (int i = 0; i < pessoas.length; i++){
			if(pessoas[i] != null){
				contador++;
			}
		}	
		return contador;
	}
	public void writeScreen() {
		//1.a)
		//1.d)
		System.out.printf("Número de pessoas: %d\n", numOfPos(this.pessoas));
		
		//1.b)
		//1.d)
		for(int i = 0; i < numOfPos(this.pessoas); i++) {
			System.out.printf("Quantidade de bytes: %d\n", pessoas[i].getNome().getBytes().length);
			System.out.printf("Nome: %s\n", pessoas[i].getNome());
			System.out.printf("CPF: %s\n", pessoas[i].getCpf());
			System.out.printf("Idade: %s anos\n\n", pessoas[i].getIdade());
		}
	}
	
	//1.e) - Imprimir no arquivo de saida
	public void writeFileOutput() {
		int numPessoas = numOfPos(this.pessoas);
		try {
			outputStream.write("Número de pessoas: ".getBytes());
			outputStream.write(intToString(numPessoas).getBytes());
			outputStream.write("\n".getBytes());
			
			for(int i=0; i < numOfPos(this.pessoas); i++) {
				int tamNome = pessoas[i].getNome().getBytes().length;
				int idade = pessoas[i].getIdade();
				
				outputStream.write("Tamanho do nome: ".getBytes());
				outputStream.write(intToString(tamNome).getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("Nome: ".getBytes());
				outputStream.write(pessoas[i].getNome().getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("CPF: ".getBytes());
				outputStream.write(pessoas[i].getCpf().getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("Idade: ".getBytes());
				outputStream.write(intToString(idade).getBytes());
				outputStream.write("\n\n".getBytes());
			}
			
			outputStream.close();
			
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("\nErro ao escrever no arquivo!\n");
		}
	}
	
	//1.f) - Escrever no socket
	public void writeSocket() {
		int numPessoas = numOfPos(this.pessoas);
		try {
			outputStream.write("Número de pessoas: ".getBytes());
			outputStream.write(intToString(numPessoas).getBytes());
			outputStream.write("\n".getBytes());
			
			for(int i=0; i < numOfPos(this.pessoas); i++) {
				int tamNome = pessoas[i].getNome().getBytes().length;
				int idade = pessoas[i].getIdade();
				
				outputStream.write("Tamanho do nome: ".getBytes());
				outputStream.write(intToString(tamNome).getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("Nome: ".getBytes());
				outputStream.write(pessoas[i].getNome().getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("CPF: ".getBytes());
				outputStream.write(pessoas[i].getCpf().getBytes());
				outputStream.write("\n".getBytes());
				
				outputStream.write("Idade: ".getBytes());
				outputStream.write(intToString(idade).getBytes());
				outputStream.write("\n\n".getBytes());
			}
			
			outputStream.close();
			
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("\nErro ao escrever no Socket!\n");
		}
	}
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
}
