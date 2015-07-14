package bank;
import java.util.Scanner;

public class ContaCorrente implements Conta{
    private String nome;
    private int conta, saques;
    private double saldo;
    Scanner in = new Scanner(System.in);
    
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
        System.out.println("\n\tEXTRATO");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Número da conta: " + this.getConta());
        System.out.println("Saques realizados hoje: " + this.getSaques());
        System.out.println("Saques restantes para hoje: " + (3 - this.getSaques()));
        System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
        
    }
    
    public void sacar(double valor){
    	if(valor >0){
	        if(getSaldo() >= valor){
	            setSaldo(getSaldo() - valor);
	            setSaques(getSaques() + 1);
	            System.out.println("Sacado: R$ " + valor);
	            System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
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
	        setSaldo(getSaldo() + valor);
	        System.out.println("Depositado: R$ " + valor);
	        System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
    	} else{
    		System.out.println("\nValor inválido. Digite um valor posisito.\n");
    	}
    }

	public void transferir(int conta, String nome, double valor) {
		if(valor >0){
	        if(getSaldo() >= valor){
	            setSaldo(getSaldo() - valor);
	            setSaques(getSaques() + 1);
	            System.out.println("\n\tTransferência");
	            System.out.println("Favorecido: " + nome);
	            System.out.println("Conta favorecida: " + conta);
	            System.out.printf("Valor transferido : R$ %.2f\n",valor);
	            System.out.printf("Saldo atual: R$ %.2f\n",this.getSaldo());
	        } else {
	            System.out.println("\nSaldo insuficiente. Faça um depósito\n");
	        }
    	} else {
    		System.out.println("\nValor inválido. Digite um valor positivo.\n");
    	}		
	}
    
    public void iniciar(){
        int opcao;
        do{
        	Menu.exibeMenu();
            opcao = in.nextInt();
            Menu.escolheOpcao(this, opcao, getSaques());
        }while(opcao!=5);
    }
}
