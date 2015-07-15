package aspects;

import bank.*;
import java.util.Date;

public privileged aspect Logging {
	
	declare soft: Exception: execution(* *(..));
	
	pointcut log(): execution(* ContaCorrente.*(*)) ||
					execution(* Menu.*(*)) ||
					execution(* Caixa.*(*)) ||
					execution(* *.*()) ||
					execution(* *.*(*,*,*));
//				    execution(public void Conta.depositar(double));
//				    execution(public void Conta.transferir(int, String, double));
//				    execution(public void Conta.extrato());
	
	before(): log(){
		Date d = new Date();
		Logger.escrever(d + " = " + thisJoinPoint.toLongString());
	}
}
