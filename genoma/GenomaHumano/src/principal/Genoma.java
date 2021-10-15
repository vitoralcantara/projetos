package principal;


public class Genoma {
	
	private /*@ spec_public @*/ int  pComp;
	//@ invariant pComp >= 1 && pComp <= 15000;
	private /*@ spec_public @*/ int  tComp;
	//@ invariant tComp >= 1 && tComp <= 15000;
	private /*@ spec_public @*/ /*@ nullable @*/ char[] p;
	private /*@ spec_public @*/ /*@ nullable @*/ char[] t;
	
	//@ requires m >= 1 && m <= 15000 && n >= 1 && n <= 15000;
	//@assignable pComp;
	//@assignable tComp;
	//@ ensures pComp == m && tComp == n;
	public Genoma(int m,int n){
		pComp = m;
		tComp = n;
	}
	
	//@ requires pE != null && pE.length == pComp &&  tE != null && tE.length == tComp;  	
	//@assignable p;
	//@assignable t;
	//@ ensures this.p == pE && this.t == tE;
	public void setCadeias(char[] pE, char[] tE)
	{
		this.p = pE;
		this.t = tE; 
	}
	
	
	//@ requires v != null;
	//@ensures \result != null && \result.length <= v.length;
	public /*@ pure @*/ static int[] somenteValoresValidos(int[] v)
	{
		int i;
		for(i=0; i < v.length; i++)
		{
			if(v[i] == 0)
			{
				break;
			}
		}
		int[] newV = new int[i];
		for(i = 0; i < newV.length ; i++)
		{
			newV[i] = v[i];
		}
		return newV;
	}	
	
	//@requires p != null && p.length == pComp && t != null && t.length == tComp;
	//@ensures \result != null;
	public /*@ pure @*/  int[] checarOcorrenciasPemT()
	{
		int[] posicoes = new int[tComp];
		int pos = 0;
		int j=0;
		for(int i = 0 ; i < tComp ; i++)
		{
			if(t[i] == p[j])
			{
				++j;
				if(j == pComp)
				{
					posicoes[pos++] = i - pComp + 2;
					j = 0;
				}
			}
			else
			{
				j = 0;
			}
		}
		return somenteValoresValidos(posicoes);		
	}
	
	
	//@requires p != null && p.length == pComp && t != null && t.length == tComp;
	//@ensures \result != null;
	public /*@ pure @*/ int[] checarOcorrenciasPemT_Invertida()
	{		
		int lim;
		boolean impar;
		if(pComp % 2 != 0)
		{
			lim = pComp/2 - 1;
			impar = true;
		}
		else
		{
			lim = pComp/2;
			impar = false;
		}
				
		for(int i = 0; i < lim; i++)
		{
			if( p[i] == 'A')
			{
				p[i] = 'T';
			}
			else if (p[i] == 'T')
			{
				p[i] = 'A';
			}
			else if(p[i] == 'G')
			{
				p[i] = 'C';
			}
			else if(p[i] == 'C')
			{
				p[i] = 'G';
			}
			
			if( p[pComp - i - 1] == 'A')
			{
				p[pComp - i - 1] = 'T';
			}
			else if (p[pComp - i - 1] == 'T')
			{
				p[pComp - i - 1] = 'A';
			}
			else if(p[pComp - i - 1] == 'G')
			{
				p[pComp - i - 1] = 'C';
			}
			else if(p[pComp - i - 1] == 'C')
			{
				p[pComp - i - 1] = 'G';
			}	
			char temp = p[pComp - i - 1];
			p[pComp - i - 1] = p[i];
			p[i] = temp;
		}
		if(impar)
		{
			++lim;
			if( p[lim] == 'A')
			{
				p[lim] = 'T';
			}
			else if (p[lim] == 'T')
			{
				p[lim] = 'A';
			}
			else if(p[lim] == 'G')
			{
				p[lim] = 'C';
			}
			else if(p[lim] == 'C')
			{
				p[lim] = 'G';
			}
		}		
		return checarOcorrenciasPemT();
	}
		
	//@ signals_only SimpleException;
	//@ signals (SimpleException e) true;
	public void throwException() throws SimpleException
	{
		throw new SimpleException();
	}


	
	
	
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Genoma g = new Genoma(4, 25);
//		char[] p = {'C','A','T','A'};
//		char[] t = {'T','C','A','T','A','T','G','C','A','A','A','T','A','G','C','T','G','C','A','T','A','C','C','G','A'};			
//		g.setCadeias(p, t);
//		System.out.println("Ocorrencia direta:");
//		int[] oc = g.checarOcorrenciasPemT();
//		for(int i = 0 ; i < oc.length ; i++)
//		{
//			System.out.print(oc[i] + " ");
//		}
//		System.out.println();
//		System.out.println("Ocorrencia complementar invertida:");
//		oc = g.checarOcorrenciasPemT_Invertida();
//		for(int i = 0 ; i < oc.length ; i++)
//		{
//			System.out.print(oc[i] + " ");
//		}
//	}

}
