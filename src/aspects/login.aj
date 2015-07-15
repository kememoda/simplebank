package aspects;

import bank.*;
public aspect login {

	pointcut log(): execution(public void Caixa.criar_conta*(String,double));
   
	before() : execution (public void criar_conta()){
		System.out.println("nova conta criada");
	}
	
	before(): log(){
		System.out.println("criando conta  = "+thisJoinPoint.toLongString());
	}
	
	after(): log(){
		System.out.println("encerrando movimentação  = "+thisJoinPoint.toLongString());
	}

}
