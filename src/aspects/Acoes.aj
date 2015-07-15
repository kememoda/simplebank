package aspects;

import bank.*;

public privileged aspect Acoes {
	
	pointcut changeSaldo(): execution(public void Conta.sacar(double)) ||
	                   execution(public void Conta.depositar(double)) ||
	                   execution(public void Conta.transferir(int, String, double));
	
	pointcut verifySaldo(): execution(public void Conta.extrato());
	
//	after(double valor, Conta obj): changeSaldo() && args(valor) && this(obj) {
//		String depositar = "execution(void bank.ContaCorrente.depositar(double))";
//		String sacar = "execution(void bank.ContaCorrente.sacar(double))";
//		if (valor > 0){
//			if (thisJoinPoint.toString().equals(sacar) && ((ContaCorrente) obj).getSaldo() >= valor){
//				System.out.println("Sacado: R$ " + valor);
//				System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
//			} else if (thisJoinPoint.toString().equals(depositar)){
//				System.out.println("Depositado: R$ " + valor);
//				System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
//			}
//		}
//	}
	
	void around(double valor, Conta obj): changeSaldo() && args(valor) && this(obj){
		String depositar = "execution(void bank.ContaCorrente.depositar(double))";
		String sacar = "execution(void bank.ContaCorrente.sacar(double))";
		if (valor > 0){
			if (thisJoinPoint.toString().equals(sacar) && ((ContaCorrente) obj).getSaldo() >= valor){
				((ContaCorrente) obj).setSaldo(((ContaCorrente) obj).getSaldo() - valor);
	            ((ContaCorrente) obj).setSaques(((ContaCorrente) obj).getSaques() + 1);
	            System.out.println("\n\tSAQUE");
				System.out.println("Sacado: R$ " + valor);
				System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
			} else if (thisJoinPoint.toString().equals(depositar)){
				((ContaCorrente) obj).setSaldo(((ContaCorrente) obj).getSaldo() + valor);
		        System.out.println("\n\tDEPÓSITO");
				System.out.println("Depositado: R$ " + valor);
				System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
			}
		}
		proceed(valor, obj);
	}
	
//	after(int conta, String nome, double valor, Conta obj): changeSaldo() && args(conta, nome, valor) && this(obj) {
//		if (((ContaCorrente) obj).getSaldo() >= valor){
//	        System.out.println("Favorecido: " + nome);
//	        System.out.println("Conta favorecida: " + conta);
//	        System.out.printf("Valor transferido : R$ %.2f\n",valor);
//			System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
//		}
//	}
	
	void around(int conta, String nome, double valor, Conta obj): changeSaldo() && args(conta, nome, valor) && this(obj){
		if (((ContaCorrente) obj).getSaldo() >= valor){
			((ContaCorrente) obj).setSaldo(((ContaCorrente) obj).getSaldo() - valor);
            System.out.println("\n\tTransferência");
	        System.out.println("Favorecido: " + nome);
	        System.out.println("Conta favorecida: " + conta);
	        System.out.printf("Valor transferido : R$ %.2f\n",valor);
			System.out.printf("Novo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
		}
		proceed(conta, nome, valor, obj);
	}
	
//	after(Conta obj): verifySaldo() && this(obj){
//		System.out.println("Nome: " + ((ContaCorrente) obj).getNome());
//        System.out.println("Número da conta: " + ((ContaCorrente) obj).getConta());
//        System.out.println("Saques realizados hoje: " + ((ContaCorrente) obj).getSaques());
//        System.out.println("Saques restantes para hoje: " + ((ContaCorrente) obj).getSaquesRestantes());
//		System.out.printf("Saldo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
//	}
	
	void around(Conta obj): verifySaldo() && this(obj){
		System.out.println("\n\tEXTRATO");
		System.out.println("Nome: " + ((ContaCorrente) obj).getNome());
        System.out.println("Número da conta: " + ((ContaCorrente) obj).getConta());
        System.out.println("Saques realizados hoje: " + ((ContaCorrente) obj).getSaques());
        System.out.println("Saques restantes para hoje: " + ((ContaCorrente) obj).getSaquesRestantes());
		System.out.printf("Saldo atual: R$ %.2f\n",((ContaCorrente) obj).getSaldo());
	}

}
