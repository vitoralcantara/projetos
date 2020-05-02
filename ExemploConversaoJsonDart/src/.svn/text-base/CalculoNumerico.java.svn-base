import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Vitor
 *
 */
public class CalculoNumerico {

	private static int getIntegerFromChar(char i)
	{
		switch (i) {
		case '1':
			return 1;			
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case '0':
			return 0;
		default:
			return -1;
		}		
	}
	
	public static String decimalToBinary(double decimal)
	{
		String leftSide = divisao_sucessiva((int)decimal);
		String rightSide = multiplicacao_sucessiva(decimal - (int)decimal);
		return leftSide +","+ rightSide;
	}
	
	public static double[][] multiplicarMatrizes(double[][] multiplicadora,double[][] multiplicando)
	{
		if(multiplicadora[0].length != multiplicando.length)
		{
			System.out.println("O tamanho das matrizes não são compatíveis");
			return null;
		}		
				
		double[][] resultado = new double[multiplicadora.length][multiplicando[0].length];
		for(int i = 0 ; i < resultado.length ; i++)
		{
			for(int j = 0 ; j < resultado[0].length ; j++)
			{
				resultado[i][j] = 0;
			}
		}		
		for(int i = 0 ; i < multiplicadora.length ; i++)
		{
			for(int j = 0 ; j < multiplicando[0].length ; j++)
			{
				for(int k = 0 ; k < multiplicando.length ; k++)
				{
					resultado[i][j] += multiplicadora[i][k] * multiplicando[k][j];
				}
			}
		}
		return resultado;
		
	}
	
		public static boolean ehSimetrica(double[][] matriz)
		{
			if(matriz.length != matriz[0].length)
			{
				return false;
			}
			for(int i = 0,j = matriz.length -1 ; i < matriz.length ; i++,j--)
			{
				if(matriz[i][j] != matriz[j][i])
				{
					return false;
				}
			}
			return true;
		}
	
	public static boolean ehPositivaDefinida(double[][] a)
	{
		double[][] u = a;
		double[][] m = new double[a.length][a[0].length];
		for(int i = 0 ; i < a.length -1 ; i++)
		{
			setIdentidadeToMatriz(m);
			for(int j = i + 1 ; j < a.length ; j++)
			{
				m[j][i] = -u[j][i] / u[i][i];
			}
			u = multiplicarMatrizes(m, u);		
		}
		//printMatriz(u);
		
		for(int i = 0 ; i < u.length ; i++)
		{
			if(u[i][i] < 0)
			{
				return false;
			}
				
		}
		return true;	
	}
	
	/**
	 * 
	 * @param binaryValue
	 * @return
	 */
	public static int binaryToDecimalForcaBruta(String binaryValue)
	{
		int valor = 0;
		int cont = 0;
		while(cont < binaryValue.length())
		{
			valor = valor + getIntegerFromChar(binaryValue.charAt(cont)) * (int)Math.pow(2, binaryValue.length() - cont - 1);
			cont = cont + 1;
		}
		return valor;
	}
	
	public static void printMatriz(double[][] matriz)
	{
		for(int i = 0 ; i < matriz.length ; i++)
			{
				for(int k = 0 ; k < matriz[0].length ; k++)
				{
					System.out.print(matriz[i][k]+ ",");
				}
				System.out.println();
					
			}
	}
	
    public static double[][] setIdentidadeToMatriz(double[][] matriz)
	{
		for(int index = 0 ; index < matriz.length ; index++)
		{
			for(int j = 0; j < matriz[0].length ; j++ )
			{
				if(j == index)
				{
					matriz[index][j] = 1;
				}
				else
				{
					matriz[index][j] = 0;
				}
			}
		}
		return matriz;
	}
	
    public static double[][] createMatriz(String elements, int numberOfLines)
    {
    	String[] itens = elements.split(",");
    	if(itens.length % numberOfLines != 0)
    	{
    		System.out.println("A quantidade de elementos é incompatível com uma matriz");
    		return null;
    	}
    	int numberOfCols = itens.length / numberOfLines;
    	double[][] matriz = new double[numberOfLines][numberOfCols];
    	int l=0,c=0;
    	for(int i = 0 ; i < itens.length ; i++)
    	{
    		matriz[l][c] = Double.valueOf(itens[i].trim());
    		if((c + 1) % numberOfCols == 0)
    		{
    			c = 0;
    			++l;
    		}
    		else
    		{
    			++c;
    		}    		
    	}
    	System.out.println("Imprinindo a matriz criada");
    	printMatriz(matriz);
    	return matriz;
    }
    
    
	/**
	 * Algoritmo da folha do Professor.
	 */
	public static double[][] fatoracaoLU(double[][] a,double[][] b)//, boolean comPivotamentoParcial)
	{
//		if(comPivotamentoParcial)
//		{
//			ArrayList<double[][]> AeB = troca_linha(a,b);
//			a = AeB.get(0);
//			b = AeB.get(1);			
//		}
//		if(comPivotamentoParcial)
//		{
//			System.out.println("Reimprinindo a matriz A, com as linhas permutadas");
//			printMatriz(a);
//			System.out.println("Reimprinindo a matriz b, com as linhas permutadas");
//			printMatriz(b);			
//		}
		double[][] u = a;
		double[][] linv = new double[a.length][a[0].length];
		linv = setIdentidadeToMatriz(linv);
		double[][] m = new double[a.length][a[0].length];
		for(int i = 0 ; i < a.length -1 ; i++)
		{
//			if(comPivotamentoParcial)
//			{
//				ArrayList<double[][]> AeB = troca_linha(u);
//				u = AeB.get(0);
//			}						
			setIdentidadeToMatriz(m);
			for(int j = i + 1 ; j < a.length ; j++)
			{
				m[j][i] = -u[j][i] / u[i][i];
			}
			linv = multiplicarMatrizes(m, linv);
			u = multiplicarMatrizes(m, u);
			b = multiplicarMatrizes(m, b);		
		}
		
		double[][] x = new double[a.length][1];
		
		for(int i = a.length -1 ; i>=0 ; i--)
		{
			x[i][0] = b[i][0];
			for(int j = i + 1; j < a.length ; j++)
			{
				x[i][0] = x[i][0] - u[i][j] * x[j][0];
			}
			x[i][0] = x[i][0] / u[i][i];
		}
		System.out.println("Imprinindo a matriz resultado");
		printMatriz(x);
		return x;		
	}
	
	/**
	 * Algoritmo do Professor
	 * @param x
	 * @param y
	 * @param u
	 */
	public static double[][] substituicao_regressiva(double[][] y,double[][] u)
	{
		double[][] x = new double[y.length][y[0].length];
		for(int i = x.length - 1; i >= 0 ; i--)
		{
			x[i][0] = y[i][0];
			for(int j = i+1; j < x.length ; j++ )
			{
				x[i][0] = x[i][0] - u[i][j] * x[i][0]; 
			}
			x[i][0] = x[i][0] / u[i][i];
		}
		return x;
	}
	/**
	 * Algoritmo do Professor.
	 * @param l
	 * @param b
	 */
	public static double[][] substituicao_progressiva(double[][] l, double[][] b)
	{
		double[][] y = new double[b.length][b[0].length];
		for(int i = 0 ; i < y.length ; i++)
		{
			y[i][0] = b[i][0];
			for(int j = 0 ; j < i ; j++)
			{
				y[i][0] = y[i][0] - l[i][j] * y[j][0];
			}
			y[i][0] = y[i][0] / l[i][i];
		}
		return y;
	}
	
	public static double[][] /*double[][]*/ troca_linha(double[][] matriz)
	{
		System.out.println("Imprimindo  matriz antes de troca linha");
		printMatriz(matriz);
		for(int i = 0 ; i < matriz[0].length;i++)
		{
			for(int j = i + 1 ; j < matriz.length ; j++)
			{
				if(matriz[j][i] > matriz[i][i])
				{
					for(int z = 0 ; z < matriz.length ; z++)
					{
						double temp = matriz[j][z];
						matriz[j][z] = matriz[i][z];
						matriz[i][z] = temp;
					}
				}
			}
		}
		System.out.println("Imprimindo a matriz depois de troca linha");
		printMatriz(matriz);
		System.out.println();
//		ArrayList<double[][]> AeB = new ArrayList<double[][]>();
//		AeB.add(matriz);
		return matriz;
	}
	
	
	/**
	 * Algoritmo feito por mim, mas que é do trabalho. Precisa ser recorrigido
	 * @param matriz
	 * @return
	 */
	public static ArrayList<double[][]> /*double[][]*/ troca_linha(double[][] matriz,double[][] b)
	{
		System.out.println("Imprimindo  matriz antes de troca linha");
		printMatriz(matriz);
		System.out.println("Imprimindo b antes de troca linha");
		printMatriz(b);
		for(int i = 0 ; i < matriz[0].length;i++)
		{
			for(int j = i + 1 ; j < matriz.length ; j++)
			{
				if(matriz[j][i] > matriz[i][i])
				{
					for(int z = 0 ; z < matriz.length ; z++)
					{
						double temp = matriz[j][z];
						matriz[j][z] = matriz[i][z];
						matriz[i][z] = temp;
					}
					for(int z = 0 ; z < b.length ; z++)
					{
						double temp = b[j][0];
						b[j][0] = b[i][0];
						b[i][0] = temp;
					}
				}
			}
		}
		System.out.println("Imprimindo a matriz depois de troca linha");
		printMatriz(matriz);
		System.out.println("Imprimindo a matriz b depois de troca linha");
		printMatriz(b);
		System.out.println();
		ArrayList<double[][]> AeB = new ArrayList<double[][]>();
		AeB.add(matriz);
		AeB.add(b);
//		AeB.add(a);
		//return matriz;
		return AeB;
	}
	/**
	 * Algoritmo do Professor
	 * @param a
	 * @return
	 */
	public static double[][] cholesky(double[][] a)
	{
		if(!ehSimetrica(a))
		{
			return null;
		}
		if(!ehPositivaDefinida(a))
		{
			return null;
		}		
		double[][] r = a;
		for(int k=0 ; k < a.length ; k++)
		{
			double primeiroSomatorio = 0;
			for(int p = 0 ; p < k ; p++)
			{
				primeiroSomatorio += Math.pow(r[k][p], 2);
			}
			r[k][k] = Math.sqrt( r[k][k] - primeiroSomatorio );
			//printMatriz(r);
			//System.out.println();
			for(int i = k + 1 ; i < a.length ; i++)
			{
				double segundoSomatorio = 0;
				for(int p = 0 ; p < k ; p++)
				{
					segundoSomatorio += r[i][p] * r[k][p];
				}
				r[i][k] = (r[i][k] - segundoSomatorio) / r[k][k];
				r[k][i] = r[i][k];
			}			
		}
		//printMatriz(r);
		return r;
	}
	
	/**
	 * Algoritmo do trabalho
	 * @param decimal
	 * @return
	 */
	public static String divisao_sucessiva(int decimal)
	{
		String binaryRepresentation = "";
		while(decimal != 0)
		{
			int value = decimal % 2;
			binaryRepresentation = String.valueOf(value) + binaryRepresentation;
			decimal = decimal / 2;
		}
		return binaryRepresentation;
	}
	
	/**
	 * Algoritmo do Trabalho
	 * @param fracao
	 * @return
	 */
	public static String multiplicacao_sucessiva(double fracao)
	{
		String binaryRepresentation = "";
		if(fracao == 0)
		{
			return "0";
		}
		while(fracao != 0 && binaryRepresentation.length() < 2000)
		{
			fracao = fracao * 2;
			int decimal = (int)fracao;
			binaryRepresentation = binaryRepresentation + String.valueOf(decimal);
			fracao = fracao - decimal;
		}
		return binaryRepresentation;
	}
	
	
//	public static int conversaoInteiroBinarioToDecimal(String binaryValue)
//	{
//		int value = 0;
//		for(int i = 0,b = binaryValue.length()-1; i < binaryValue.length() ; i++,b--)
//		{
//			value = (int) (value + getIntegerFromChar(binaryValue.charAt(i)) * Math.pow(2, b));
//		}
//		return value;
//		
//	}
	
	public static int briot_Ruffine_Inteiro(String binaryValue)
	{
		int valor = getIntegerFromChar(binaryValue.charAt(0));
		
		for (int i = 1 ; i < binaryValue.length() ; i++ )
		{
			valor = getIntegerFromChar(binaryValue.charAt(i)) + 2 * valor;			
		}
		return valor;
	}
	
	/**
	 * Algoritmo do Trabalho
	 * @param binaryValue
	 * @return
	 */
	public static float briot_Ruffine_Fracao(String binaryValue)
	{
		float valor = getIntegerFromChar(binaryValue.charAt(binaryValue.length()-1));
		for(int i = binaryValue.length()-2; i >= 0 ; i--)
		{
			valor = getIntegerFromChar(binaryValue.charAt(i)) + valor/2;
		}
		valor = valor/2;
		return valor;
	}
	
	/**
	 * Algoritmo para o Trabalho
	 * @param binaryValue
	 * @return
	 */
	public static float binaryToDecimal(String binaryValue)
	{
		String[] valores = binaryValue.split(",");
		if(valores.length == 1)
		{
			return briot_Ruffine_Inteiro(binaryValue);
		}
		else
		{
			return briot_Ruffine_Inteiro(valores[0].trim()) + briot_Ruffine_Fracao(valores[1].trim());
		}
	}
	
}
