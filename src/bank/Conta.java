package bank;

public interface Conta {
	
	public void extrato();
	public void sacar(double valor);
	public void depositar(double valor);
	public void transferir(int conta, String nome, double valor);

}