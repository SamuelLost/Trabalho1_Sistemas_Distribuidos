package banco;

import java.io.IOException;

public class GerenciamentoConta {
	public static void main(String args[]){
		try {
			Conta[] contas = new Conta[10];
			Conta conta1 = new Conta(473360, "Samuel", 4);
			Conta conta2 = new Conta(123456, "Henrique", 50);
			contas[0] = conta1;
			contas[1] = conta2;
			
			BancoDeDados bancodedados = new BancoDeDados(contas);
			int qntdContas = bancodedados.numOfPos(contas);
			
//			bancodedados.carregarContasArquivo("banco.txt");
			bancodedados.gravarContasArquivo("banco.txt");
			System.out.println("Dados que estão armazenados em banco.txt:\n");
			for(int i=0; i < qntdContas; i++) {
				System.out.printf("Número da conta %d: %d\n", i+1, contas[i].getNumero_da_conta());
				System.out.printf("Nome: %s\n", contas[i].getNome());
				System.out.printf("Saldo: %d\n\n", contas[i].getSaldo());
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
