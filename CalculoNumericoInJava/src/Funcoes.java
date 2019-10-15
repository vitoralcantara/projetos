import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Funcoes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		while(true)
		{
			System.out.println("Escolha uma das funções para execuar");
			System.out.println("1: f(x) = x² - 2");
			System.out.println("2: f(x) = x² + x - 6");
			System.out.println("3: f(x) = senx² - x");		
			System.out.println("4: f1(x,y) = x² + y² -1");
			System.out.println("5: f2(x,y) = x - y²");
			System.out.println("6: g1(x,y) = x² + y² - 2");
			System.out.println("7:  g2(x,y) = x² - y² - 1");
			System.out.println("8: Sair do programa");
			try {
				choose = Integer.parseInt(reader.readLine());
				if(choose == 1)
				{
					double x = Double.parseDouble(args[0]);
					System.out.println(CN2Unidade.funcao1(x));
					return;
				}
				else if(choose == 2)
				{
					double x = Double.parseDouble(args[0]);
					System.out.println(CN2Unidade.funcao2(x));
					return;
				}
				else if(choose == 3)
				{
					double x = Double.parseDouble(args[0]);
					System.out.println(CN2Unidade.funcao3(x));
					return;
				}
				else if(choose == 4)
				{
					double x = Double.parseDouble(args[0]);
					double y = Double.parseDouble(args[1]);
					double result = Math.pow(x, 2) + Math.pow(y, 2) - 1;
					System.out.println(result);
					return;
				}
				else if(choose == 5)
				{
					double x = Double.parseDouble(args[0]);
					double y = Double.parseDouble(args[1]);
					double result = x - Math.pow(y, 2);
					System.out.println(result);
					return;
				}
				else if(choose == 6)
				{
					double x = Double.parseDouble(args[0]);
					double y = Double.parseDouble(args[1]);
					double result = Math.pow(x, 2) + Math.pow(y, 2) - 2;
					System.out.println(result);
					return;
				}
				else if(choose == 7)
				{
					double x = Double.parseDouble(args[0]);
					double y = Double.parseDouble(args[1]);
					double result = Math.pow(x, 2) - Math.pow(y, 2) - 1;
					System.out.println(result);
					return;
				}
				else if (choose == 8)
				{
					return;
				}
				else
				{
					continue;
				}				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Não é um número.");
				continue;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Não é um número.");
				continue;
			} catch (Exception e){
				System.out.println("Faltou os argumentos");
				return;
			}
			
			
		}
		
		
	}

}
