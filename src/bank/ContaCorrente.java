package bank;
import java.util.Scanner;

public class ContaCorrente implements Conta{
    private String nome;
    private int conta, saques;
    private double saldo;
    Scanner in = new Scanner(System.in);
    
    public int getSaquesRestantes(){
    	return 3 - getSaques();
    }
    
    private String getNome() {
		return nome;
	}

	private int getConta() {
		return conta;
	}

	private int getSaques() {
		return saques;
	}

	private void setSaques(int saques) {
		this.saques = saques;
	}

	private double getSaldo() {
		return saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ContaCorrente(String nome, int conta, double saldo_inicial){
    	super();
        this.nome = nome;
        this.conta = conta;
        setSaldo(saldo_inicial);
        setSaques(0);
    }
    
    public void extrato(){
//        System.out.println("\n\tEXTRATO"); // Usar isso se for com Advice before!
//        System.out.println("Nome: " + this.getNome());
//        System.out.println("Número da conta: " + this.getConta());
//        System.out.println("Saques realizados hoje: " + this.getSaques());
//        System.out.println("Saques restantes para hoje: " + getSaquesRestantes());
//        System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
        
    }
    
    public void sacar(double valor){
    	if(valor >0){
	        if(getSaldo() >= valor){
//	            setSaldo(getSaldo() - valor);
//	            setSaques(getSaques() + 1);
//	            System.out.println("\n\tSAQUE"); // Usar daqui pra cima se for com Advice before!
//	            System.out.println("Sacado: R$ " + valor);
//	            System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
	        } else {
	            System.out.println("\nSaldo insuficiente. Faça um depósito\n");
	        }
    	} else {
    		System.out.println("\nValor inválido. Digite um valor positivo.\n");
    	}
    }
    
    public void depositar(double valor)
    {
    	if (valor > 0){
//	        setSaldo(getSaldo() + valor);
//	        System.out.println("\n\tDEPÓSITO"); // Usar daqui pra cima se for com Advice before!
//	        System.out.println("Depositado: R$ " + valor);
//	        System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
    	} else{
    		System.out.println("\nValor inválido. Digite um valor posisito.\n");
    	}
    }

	public void transferir(int conta, String nome, double valor) {
		if(valor >0){
	        if(getSaldo() >= valor){
//	            setSaldo(getSaldo() - valor);
//	            System.out.println("\n\tTransferência"); // Usar daqui pra cima se for com Advice before!
//	            System.out.println("Favorecido: " + nome);
//	            System.out.println("Conta favorecida: " + conta);
//	            System.out.printf("Valor transferido : R$ %.2f\n",valor);
//	            System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
	        } else {
	            System.out.println("\nSaldo insuficiente. Faça um depósito\n");
	        }
    	} else {
    		System.out.println("\nValor inválido. Digite um valor positivo.\n");
    	}		
	}
}
