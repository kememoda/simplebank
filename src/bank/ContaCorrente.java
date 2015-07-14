package bank;
import java.util.Scanner;

public class ContaCorrente implements Conta{
    private String nome;
    private int conta, saques;
    private double saldo;
    Scanner in = new Scanner(System.in);
    
    public ContaCorrente(String nome, int conta, double saldo_inicial){
    	super();
        this.nome=nome;
        this.conta=conta;
        saldo=saldo_inicial;
        saques=0;
    }
    
    public void extrato(){
        System.out.println("\n\tEXTRATO");
        System.out.println("Nome: " + this.nome);
        System.out.println("Número da conta: " + this.conta);
        System.out.printf("Saldo atual: R$ %.2f\n",this.saldo);
        System.out.println("Saques realizados hoje: " + this.saques);
        System.out.println("Saques restantes para hoje: " + (3 - this.saques) + "\n");
        
    }
    
    public void sacar(double valor){
    	if(valor >0){
	        if(saldo >= valor){
	            saldo -= valor;
	            saques++;
	            System.out.println("Sacado: R$ " + valor);
	            System.out.println("Novo saldo: R$ " + saldo + "\n");
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
	        saldo += valor;
	        System.out.println("Depositado: R$ " + valor);
	        System.out.println("Novo saldo: R$ " + saldo + "\n");
    	} else{
    		System.out.println("\nValor inválido. Digite um valor posisito.\n");
    	}
    }

	public void transferir(int conta, String nome, double valor) {
		if(valor >0){
	        if(saldo >= valor){
	            saldo -= valor;
	            saques++;
	            System.out.println("\n\tTransferência");
	            System.out.println("Favorecido: " + nome);
	            System.out.println("Conta favorecida: " + conta);
	            System.out.println("Valor transferido: R$ " + valor);
	            System.out.println("Novo saldo: R$ " + saldo + "\n");
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
            exibeMenu();
            opcao = in.nextInt();
            escolheOpcao(opcao);
        }while(opcao!=5);
    }
    
    public void exibeMenu(){
        
        System.out.println("\n\t Escolha a opção desejada");
        System.out.println("1 - Consultar Extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair\n");
        System.out.print("Opção: ");
        
    }
    
    public void escolheOpcao(int opcao){
        double valor;
        String nome;
        int conta;
        
        switch( opcao ){
            case 1:    
                    extrato();
                    break;
            case 2: 
                    if(saques<3){
                        System.out.print("Quanto deseja sacar: ");
                        valor = in.nextDouble();
                        sacar(valor);
                    } else{
                        System.out.println("Limite de saques diários atingidos.\n");
                    }
                    break;
                    
            case 3:
                    System.out.print("Quanto deseja depositar: ");
                    valor = in.nextDouble();
                    depositar(valor);
                    break;
            case 4:
	                System.out.print("Quanto deseja transferir: ");
	                valor = in.nextDouble();
	                System.out.print("Qual o número da conta favorecida: ");
	                conta = in.nextInt();
	                System.out.print("Qual o nome do favorecido: ");
	                nome = in.next();
	                transferir(conta, nome, valor);
	                break;                    
            case 5: 
                    System.out.println("Sistema encerrado.");
                    break;
                    
            default:
                    System.out.println("Opção inválida");
        }
    }
}
