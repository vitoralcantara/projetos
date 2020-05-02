import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Teste {
	

	public static void main(String[] args)
//	{
//		double[][] a = {{1,4},{0.003,30}};
//		double[][] b = {{1},{5.001}};
//		double[][] semP = CalculoNumerico.fatoracaoLU(a, b, false);
//		double[][] comP = CalculoNumerico.fatoracaoLU(a, b, true);
//	}
	
	{
		int choose = 0;
		while(choose != -1)
		{
			System.out.println("Por favor, escolha uma das fun��es abaixo de acordo com o numero:");
			System.out.println("1: Binario para Decimal(Briot-Ruffini)");
			System.out.println("2: Binario Inteiro para Decimal (Briot-Ruffini)");
			System.out.println("3: Binario Fra��o para Decimal (Briot-Ruffini)");
			System.out.println("4: Decimal para Binario");
			System.out.println("5: Decimal Inteiro para Binario");
			System.out.println("6: Decimal Fra��o para Binario");
			System.out.println("7: Fatora��o LU");
			System.out.println("9: Algoritmo Troca-Linha");
			System.out.println("10: Fatora��o de Cholesky");
			System.out.println("11: Multiplicar duas matrizes");
			System.out.println("12: Sair do Programa");
			System.out.println("13: Binario Inteiro para Decimal (Forca Bruta)");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try
			{
				choose = Integer.parseInt(reader.readLine());
				System.out.println("Voce selecionou a op��o: " + choose);
				if(choose == 1 || choose == 2 || choose == 3)
				{
					System.out.println("Digite a representa��o em String do Numero Binario");
					System.out.println("Neste caso, a v�rgula difere a parte inteira da binaria");
					String bNumber = reader.readLine().trim();
					double number = CalculoNumerico.binaryToDecimal(bNumber);
					System.out.println("O numero decimal para o binario dado eh: " + number);
					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
				if(choose == 4 | choose == 5 || choose == 6)
				{
					System.out.println("Digite o numero na base decimal");
					double decimal = Double.valueOf(reader.readLine().trim());
					String bNumber = CalculoNumerico.decimalToBinary(decimal);
					System.out.println("A representa��o no Sistema Binario eh: "+bNumber);
					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
				if(choose == 7)
				{
					System.out.println("Digite os elementos da matriz A a ser calculada");
					String elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a matriz A");
					int lines = Integer.valueOf(reader.readLine().trim());
					double[][] A = CalculoNumerico.createMatriz(elements, lines);
					System.out.println("Digite os elementos da matriz b a ser calculado");
					elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a matriz b");
					lines = Integer.valueOf(reader.readLine().trim());
					double[][] b = CalculoNumerico.createMatriz(elements, lines);
					//double[][] res = CalculoNumerico.fatoracaoLU(A, b,false);
					double[][] res = CalculoNumerico.fatoracaoLU(A, b);
					System.out.println("Imprimindo o resultado da Fatora��o LU SEM pivotamento parcial:");
					CalculoNumerico.printMatriz(res);
					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
				if(choose == 9)
				{
					System.out.println("Digite a matriz A a ter as linhas trocadas");
					String elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a matriz A");
					int lines = Integer.valueOf(reader.readLine().trim());
					double[][] A = CalculoNumerico.createMatriz(elements, lines);
					double[][] res = CalculoNumerico.troca_linha(A);
					System.out.println("Imprimindo a matriz  A do resultado do troca-linha");
					CalculoNumerico.printMatriz(res);

					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
				if(choose == 10)
				{
					System.out.println("Digite os elementos da matriz A a ser calculada");
					String elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a matriz A");
					int lines = Integer.valueOf(reader.readLine().trim());
					double[][] A = CalculoNumerico.createMatriz(elements, lines);
					double[][] res = CalculoNumerico.cholesky(A);
					if(res == null)
					{
						System.out.println("A matriz n�o pode ser calculada pois n�o eh positiva definida ou simetrica");
						
					}
					else
					{
						System.out.println("Imprimindo a matriz resultado da fatora��o de Cholesky (R e R transposta) como no algoritmo do Professor:");
						CalculoNumerico.printMatriz(res);
					}
					System.out.println("Digite Enter para continuar...");
					reader.readLine();										
				}
				if(choose == 11)
				{
					System.out.println("Digite os elementos da primeira matriz");
					String elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a primeira matriz");
					int lines = Integer.valueOf(reader.readLine().trim());
					double[][] y = CalculoNumerico.createMatriz(elements, lines);
					System.out.println("Digite os elementos da segunda matriz");
					elements = reader.readLine();
					System.out.println("Digite a quantidade de linhas que tem a segunda matriz");
					lines = Integer.valueOf(reader.readLine().trim());
					double[][] u = CalculoNumerico.createMatriz(elements, lines);
					double[][] res = CalculoNumerico.multiplicarMatrizes(y, u);
					System.out.println("Imprimindo a multiplica��o das matrizes");
					CalculoNumerico.printMatriz(res);
					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
				if(choose == 12)
				{
					System.out.println("Saindo do programa...");
					return;
				}
				if(choose == 13)
				{
					System.out.println("Digite o numero binario inteiro");
					String br = reader.readLine().trim();
					int result = CalculoNumerico.binaryToDecimalForcaBruta(br);
					System.out.println("O Resultado da convers�o para a base decimal eh: " + result);
					System.out.println("Digite Enter para continuar...");
					reader.readLine();
				}
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println("Voce nao digitou um numero");
				System.out.println("Saindo do Programa");
				return;
			}	
		}
	}
}
