import Jama.Matrix;
import Jama.util.Maths;

public class SistemaNaoLinear2Unidade {
	
	public int funcao;
	public static int iteracoes = 100;
	
	public double[][] F1(double[][] x)
	{
		if(x.length > 2)
		{
			System.out.println("Tamanho maior que 2");
			return null;
		}
		if(x[0].length > 1)
		{
			System.out.println("Quantidade de colunas maior que 2");
			return null;
		}
		double[][] result = new double[2][1];
		result[0][0] = Math.pow(x[0][0], 2) + Math.pow(x[1][0], 2) - 1;
		result[1][0] = x[0][0] - Math.pow(x[1][0], 2);
		return result;
	}
	
	public double[][] F2(double[][] x)
	{
		if(x.length > 2)
		{
			System.out.println("Tamanho maior que 2");
			return null;
		}
		if(x[0].length > 1)
		{
			System.out.println("Quantidade de colunas maior que 2");
			return null;
		}
		double[][] result = new double[2][1];
		result[0][0] = Math.pow(x[0][0], 2) + Math.pow(x[1][0], 2) - 2;
		result[1][0] = Math.pow(x[0][0], 2) - Math.pow(x[1][0], 2) - 1;
		return result;
	}
	
			
	public static double[][] inversaDaMatriz(double[][] matriz)
	{
		Matrix m = new Matrix(matriz);
		m = m.inverse();
		matriz = m.getArray();
		return matriz;
	}
	
	public static boolean isNumber(String string)
	{
		try
		{
			double re = Double.parseDouble(string);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}		
	}
	
	public double[][] F(double[][] x)
	{
		if(funcao == CN2Unidade.FUNCAO_1)
			return F1(x);
		else if(funcao == CN2Unidade.FUNCAO_2)
			return F2(x);
		return null;			
	}
	
	
	public boolean condicaoDeParada(double[][] matriz, double erro)
	{
		matriz = F(matriz);
		for(int i = 0 ; i < matriz.length ; i++)
		{
			for(int j = 0 ; j < matriz[0].length ; j++ )
			{
				if(Math.abs(matriz[i][j]) > erro)
					return false;
			}
		}
		return true;
	}
	
	
	public double[][] subtrairMatrizes(double[][] a,double[][] b)
	{
		double [][] result = new double[a.length][a[0].length];
		for(int i = 0 ; i < a.length ; i++)
		{
			for(int j = 0 ; j < a[0].length ; j++)
			{
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}	
	
	public static double[][] criarMatrizSDeVetor(double[] vetor)
	{
		double[][] vetorMatriz = new double[vetor.length][1];
		for(int i = 0 ; i < vetor.length ; i++)
		{
			vetorMatriz[i][0] = vetor[i];
		}
		return vetorMatriz;
	}
	
	public static double[][] dividirMatrizPorNumero(double[][] matriz,double n)
	{
		double[][] result = new double[matriz.length][matriz[0].length];
		for(int i = 0 ; i < matriz.length ; i++)
		{
			for(int j = 0 ; j< matriz[0].length ; j++)
			{
				result[i][j] = matriz[i][j]/n;
			}
		}
		return result;
	}
	
	public static double[][] transpostaDaMatriz(double[][] matriz)
	{
		double[][] result = new double[matriz[0].length][matriz.length];
		for(int i = 0 ; i < matriz.length ; i++)
		{
			for(int j = 0 ; j < matriz[0].length ; j++)
			{
				result[j][i] = matriz[i][j];
			}
		}
		return result;
	}
	
	public static double[][] somarMatrizes(double[][] a,double[][] b)
	{
		double[][] result = new double[a.length][a[0].length];
		for(int i = 0 ; i < a.length ; i++ )
		{
			for(int j = 0 ; j < a[0].length ; j++)
			{
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	
	public static boolean hasNan(double[][] matriz)
	{
		for(int i = 0 ; i < matriz.length ; i++)
		{
			for(int j = 0 ; j < matriz[0].length ; j++)
			{
				if(Double.isNaN(matriz[i][j]))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	
	public double[][] quaseNewton(double[][] x,double erro)
	{
		double[][] B = new double[x.length][x.length];
		CalculoNumerico.setIdentidadeToMatriz(B);
		double[][] xqn,y,s,u,Binversa,sT;
		double[][] dividendo;
		double[][] backup;
		double divisor;
		int i = 0;
		do
		{
			backup = x;
			try
			{
				Binversa = inversaDaMatriz(B);
			}
			catch(Exception e)
			{
				System.out.println("Quantidade de Iterações feitas:" + i);
				return backup;
			}			
			xqn = subtrairMatrizes(x,CalculoNumerico.multiplicarMatrizes(Binversa,F(x)));
			y = subtrairMatrizes(F(xqn),F(x));
			s = subtrairMatrizes(xqn, x);
			sT = transpostaDaMatriz(s);
			u = dividirMatrizPorNumero
				(subtrairMatrizes
				(y, CalculoNumerico.multiplicarMatrizes(B, s)),CalculoNumerico.multiplicarMatrizes(sT,s)[0][0]);
			dividendo = CalculoNumerico.multiplicarMatrizes
						(CalculoNumerico.multiplicarMatrizes
						(CalculoNumerico.multiplicarMatrizes(Binversa, u),sT),Binversa);
			divisor = 1 + CalculoNumerico.multiplicarMatrizes(CalculoNumerico.multiplicarMatrizes(sT, Binversa),u)[0][0];
			Binversa = subtrairMatrizes(Binversa, dividirMatrizPorNumero(dividendo, divisor));
			B = somarMatrizes(B,CalculoNumerico.multiplicarMatrizes(u, sT));
			x = xqn;
			if(SistemaNaoLinear2Unidade.hasNan(x))
			{
				System.out.println("Quantidade de Iterações feitas:" + i);
				return backup;
			}
			i++;
		}
		while(!this.condicaoDeParada(x, erro) && i < iteracoes);
		System.out.println("Quantidade de Iterações feitas:" + i);
		return x;
	}
	
}
