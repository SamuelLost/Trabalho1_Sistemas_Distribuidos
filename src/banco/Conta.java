package banco;

public class Conta {
	private int numero_da_conta;
	private String nome;
	private int saldo;
	
	public Conta(int numero_da_conta, String nome, int saldo) {
		this.numero_da_conta = numero_da_conta;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public int getNumero_da_conta() {
		return numero_da_conta;
	}
	
	public void setNumero_da_conta(int numero_da_conta) {
		this.numero_da_conta = numero_da_conta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
