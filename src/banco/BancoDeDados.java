package banco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BancoDeDados {
	private Conta[] contas;
	
	public BancoDeDados(Conta[] contas) {
		this.contas = contas;
	}
	
	public int numOfPos(Conta[] contas) {
		int contador=0;
		for (int i = 0; i < contas.length; i++){
			if(contas[i] != null){
				contador++;
			}
		}	
		return contador;
	}
	
	public void gravarContasArquivo(String nomeArquivo) throws IOException {
		FileWriter fw = new FileWriter(nomeArquivo);
		PrintWriter pw = new PrintWriter(fw);
		int numContas = numOfPos(contas);
		
		for(int i=0; i < numContas; i++) {
			pw.printf("Nome: %s\n", contas[i].getNome());
			pw.printf("Número da Conta: %d\n", contas[i].getNumero_da_conta());
			pw.printf("Saldo: %d\n", contas[i].getSaldo());
		}
		
		pw.close();
		fw.close();
	}
	
	public void carregarContasArquivo(String nomeArquivo) throws IOException{
		FileReader file = new FileReader("banco.txt");
		BufferedReader readFile = new BufferedReader(file);
		int i = 0;
		String Line = "";
		Line = readFile.readLine();
		
		try {
			while(Line != null && i < numOfPos(contas)) {
				contas[i].setNumero_da_conta(Integer.parseInt(Line));
				Line = readFile.readLine();
				contas[i].setNome(Line);
				Line = readFile.readLine();
				contas[i].setSaldo(Integer.parseInt(Line));
				i++;
			}
		} catch (NumberFormatException e) {
            System.out.println("Número inválido!");
		}
		
		file.close();
	}
}
