package principal;




public class Genoma {
	
	private int  pComp;
	private int  tComp;
	private char[] p;
	private char[] t;
	
	public Genoma(int m,int n) throws RangeException{
		if(m < 1 || m > 15000 || n < 1 || n > 15000 || m > n)
		{
			throw new RangeException();
		}
		pComp = m;
		tComp = n;
	}
	
	public int getpComp() {
		return pComp;
	}

	public void setpComp(int pComp) {
		this.pComp = pComp;
	}

	public int gettComp() {
		return tComp;
	}

	public void settComp(int tComp) {
		this.tComp = tComp;
	}

	public char[] getP() {
		return p;
	}

	public void setP(char[] p) {
		this.p = p;
	}

	public char[] getT() {
		return t;
	}

	public void setT(char[] t) {
		this.t = t;
	}

	public void setCadeias(char[] pE, char[] tE) throws CaractereIncorretoException
	{
		if(pE == null || tE == null){
			throw new NullPointerException();
		}
		for(int i = 0 ; i < pE.length;i++)
		{
			if(pE[i] != 'A' && pE[i] != 'G' && pE[i] != 'C' && pE[i] != 'T')
			{
				throw new CaractereIncorretoException();
			}
		}
		for(int i = 0 ; i < tE.length;i++)
		{
			if(tE[i] != 'A' && tE[i] != 'G' && tE[i] != 'C' && tE[i] != 'T')
			{
				throw new CaractereIncorretoException();
			}
		}
		this.p = pE;
		this.t = tE; 
	}
	
	public static int[] somenteValoresValidos(int[] v)
	{
		if(v == null)
		{
			throw new NullPointerException();
		}
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
	
	public int[] checarOcorrenciasPemT()
	{
		return checarOcorrenciasPemT(this.p);
	}
	
	private int[] checarOcorrenciasPemT(char[] p)
	{
		for(int i = 0 ; i < p.length ; i++)
		{
			System.out.print(p[i]);
		}
		System.out.println();
		
		for(int i = 0 ; i < t.length ; i++)
		{
			System.out.print(t[i]);
		}
		System.out.println();
		
		int[] posicoes = new int[t.length];
		int pos = 0;
		int j=0;
		for(int i = 0 ; i < t.length ; i++)
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
				if(j > 0)
				{
					i -=1;
				}
				j = 0;
			}
		}
		return somenteValoresValidos(posicoes);		
	}
	
	
	public int[] checarOcorrenciasPemT_Invertida()
	{		
		char[] p_invertida = new char[p.length];		
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
				p_invertida[i] = 'T';
			}
			else if (p[i] == 'T')
			{
				p_invertida[i] = 'A';
			}
			else if(p[i] == 'G')
			{
				p_invertida[i] = 'C';
			}
			else if(p[i] == 'C')
			{
				p_invertida[i] = 'G';
			}
			
			if( p[p.length - i - 1] == 'A')
			{
				p_invertida[p.length - i - 1] = 'T';
			}
			else if (p[p.length - i - 1] == 'T')
			{
				p_invertida[p.length - i - 1] = 'A';
			}
			else if(p[p.length - i - 1] == 'G')
			{
				p_invertida[p.length - i - 1] = 'C';
			}
			else if(p[p.length - i - 1] == 'C')
			{
				p_invertida[p.length - i - 1] = 'G';
			}	
			char temp = p_invertida[p_invertida.length - i - 1];
			p_invertida[p_invertida.length - i - 1] = p_invertida[i];
			p_invertida[i] = temp;
		}
		if(impar)
		{
			++lim;
			if( p[lim] == 'A')
			{
				p_invertida[lim] = 'T';
			}
			else if (p[lim] == 'T')
			{
				p_invertida[lim] = 'A';
			}
			else if(p[lim] == 'G')
			{
				p_invertida[lim] = 'C';
			}
			else if(p[lim] == 'C')
			{
				p_invertida[lim] = 'G';
			}
		}	
		
		return checarOcorrenciasPemT(p_invertida);
	}
}
