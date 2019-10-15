package principal;

public class Conta {
	
	private /*@ spec_public @*/ int saldo;
	
	//@ requires x >= 0;
	//@ ensures \result >= x;	
	public static double raiz(int x){
		return Math.sqrt(x);
	}

	//@ ensures \result == saldo;
	public /*@ pure @*/ int consultarSaldo(){
		return saldo;
	}
	
	//@ requires valor >= 0;
	//@ ensures saldo == \old(saldo) + valor;
	public int depositar(int valor){
		saldo += valor;
		return saldo;
	}
	
	//@requires saldo - valor > 0;
	//@ensures saldo == (\old(saldo) - valor);
	//@ensures c.consultarSaldo() == (\old(c.consultarSaldo()) + valor);	
	public int transferir(Conta c,int valor){
		this.saldo-=valor;
		c.depositar(valor);
		return c.consultarSaldo();
	}
	
	public static void main(String[] args)
	{
		Conta c = new Conta();
		c.depositar(10);
		int x = c.consultarSaldo();
		
		double z = raiz(x);
		
		Conta d = new Conta();
		c.transferir(d, 5);
		
		
	}
}
