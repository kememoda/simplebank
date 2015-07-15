package bank;
import java.util.Scanner;
import java.util.Random;

public class Caixa {
    
	static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        // Declarando as variáveis, Scanner e Random
        String nome;
        double inicial;
        //Obtendo os dados iniciais do Cliente
        System.out.println("\tCadastrando novo cliente.\n");
        System.out.print("Digite o seu nome: ");
        nome = in.nextLine();
        System.out.print("Digite o seu sobrenome: ");
        nome += " "+in.nextLine();
        System.out.print("Digite o valor para o depósito inicial na conta: ");
        inicial = in.nextDouble();
        
        //Criando a conta de um cliente
        iniciar(criar_conta(nome, inicial));
    }
    
    public static Conta criar_conta(String nome, double valor){
    	Random numero = new Random();
    	int conta = 1 + numero.nextInt(9999);
    	ContaCorrente minhaConta = new ContaCorrente(nome, conta, valor);
    	return minhaConta;
    }      
    
    public static void iniciar(Conta conta){
        int opcao;
        do{
        	Menu.exibeMenu();
            opcao = in.nextInt();
            Menu.escolheOpcao(conta, opcao, conta.getSaquesRestantes());
        }while(opcao!=5);
    }
}
