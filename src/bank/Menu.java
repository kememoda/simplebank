package bank;

import java.util.Scanner;

public class Menu {
	static Scanner in = new Scanner(System.in);
	
	public static void exibeMenu(){        
        System.out.println("\n\t Escolha a opção desejada");
        System.out.println("1 - Consultar Extrato");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Sair\n");
        System.out.print("Opção: ");
    }
	
	public static void escolheOpcao(Conta conta, int opcao, int saques_restantes){
        double valor;
        String nome;
        int numero_conta;
        switch( opcao ){
            case 1:    
                    conta.extrato();
                    break;
            case 2: 
                    if(saques_restantes > 0){
                        System.out.print("Quanto deseja sacar: ");
                        valor = in.nextDouble();
                        conta.sacar(valor);
                    } else{
                        System.out.println("Limite de saques diários atingidos.\n");
                    }
                    break;
            case 3:
                    System.out.print("Quanto deseja depositar: ");
                    valor = in.nextDouble();
                    conta.depositar(valor);
                    break;
            case 4:
	                System.out.print("Quanto deseja transferir: ");
	                valor = in.nextDouble();
	                System.out.print("Qual o número da conta favorecida: ");
	                numero_conta = in.nextInt();
	                System.out.print("Qual o nome do favorecido: ");
	                nome = in.next();
	                conta.transferir(numero_conta, nome, valor);
	                break;                    
            case 5: 
                    System.out.println("Sistema encerrado.");
                    break;
                    
            default:
                    System.out.println("Opção inválida");
        }
    }
}
