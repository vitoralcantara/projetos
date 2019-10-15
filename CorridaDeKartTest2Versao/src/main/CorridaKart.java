package main;

import org.junit.Test;

import main.CorridaKart;

public class CorridaKart {
	
	private int nPostos;
	private int distanciaIM;

	public CorridaKart(int n,int m) throws RangeException {
		if(n < 2 || n > 10000 || m < 1 || m > 42195)
		{
			throw new RangeException();
		}
		else
		{
			nPostos = n;
			distanciaIM = m;
		}				
	}
	
	public char preverTermino(int[] posicao_i) throws OrdemNaoCrescenteException,NonNumberZeroException, RangeException
	{
		if(posicao_i[posicao_i.length - 1] > 42195)
		{
			throw new RangeException();
		}		
		if(posicao_i[0] != 0){
			throw new NonNumberZeroException();
		}
		for(int i = 0 ; i < posicao_i.length - 1 ; i++)
		{
			if((posicao_i[i+1] - posicao_i[i]) < 0){
				throw new OrdemNaoCrescenteException();
			}
			if((posicao_i[i+1] - posicao_i[i]) > distanciaIM)
			{
				return 'N';
			}
		}
		return 'S';
	}
	
	

}
