package main;

public class CorridaKart {
		
	private /*@ spec_public @*/ int nPostos;
	//@ invariant nPostos >= 2 && nPostos <= 10000;
	private /*@ spec_public @*/ int distanciaIM;
	//@ invariant distanciaIM >= 1 && distanciaIM <= 42195;
	
	//@ requires n >= 2 && n <= 10000 && m >= 1 && m <= 42195;
	//@assignable nPostos;
	//@assignable distanciaIM;
	//@ ensures nPostos == n && distanciaIM == m;
	public CorridaKart(int n,int m) {
		nPostos = n;
		distanciaIM = m;
		//@assert nPostos == n;
	}
	
	//@ requires posicao_i != null;
	//@ also
	//@ requires posicao_i.length == nPostos;
	//@ ensures \result == 'N' || \result == 'S';
	public /*@ pure @*/ char preverTermino(int[] posicao_i)
	{
		for(int i = 0 ; i < posicao_i.length - 1 ; i++)
		{
			if((posicao_i[i+1] - posicao_i[i]) > distanciaIM)
			{
				return 'N';
			}
		}
		return 'S';
	}
	
	public static void main(String[] args)
	{
		CorridaKart  c = new CorridaKart(3, 20000);
		int[] arrayPosicoes = {0,20000,33333};
		System.out.println(c.preverTermino(arrayPosicoes));
		CorridaKart  p = new CorridaKart(8,6000);
		int[] arrayPosicoes2 = {0,6000,12000,18000,24000,32000,37000,40000};
		System.out.println(p.preverTermino(arrayPosicoes2));
		
		
	}

}
