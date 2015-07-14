package bank;
import java.util.Scanner;
import java.util.Random;

public class Caixa {
    
    
    public static void main(String[] args){
        // Declarando as variáveis, Scanner e Random
        String nome;
        double inicial;
        Scanner in = new Scanner(System.in);
        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);
    
        //Obtendo os dados iniciais do Cliente
        System.out.println("Cadastrando novo cliente.");
        System.out.print("Digite o seu nome: ");
        nome = in.nextLine();
        System.out.print("Digite o seu sobrenome: ");
        nome += " "+in.nextLine();
        
        System.out.print("Digite o valor para o depósito inicial na conta: ");
        inicial = in.nextDouble();
        
        //Criando a conta de um cliente
        ContaCorrente minhaConta = new ContaCorrente(nome, conta, inicial);
        minhaConta.iniciar();
    }
    
    
}
