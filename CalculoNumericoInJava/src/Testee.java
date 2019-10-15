
public class Testee {
	
	public static void hanoi(
							 int n,
							 int origem,
							 int destino,
							 int auxiliar,
							 int[] vetOrigem,
							 int[] vetAuxiliar,
							 int[] vetDestino
							 )
	{
		if(n==1)
		{
			if(origem == 1 )
			{
				
			}
			System.out.println("Move disco de " +  origem + " para " + destino);
			int v = -1;
			for(int i = 1 ; i < vetOrigem.length ; i++)
			{
				if(vetOrigem[i] != 0)
				{
					v = vetOrigem[i];
					vetOrigem[i] = 0;
					break;
				}
			}
			for(int i = 0 ; i < vetDestino.length ; i++)
			{
				if(vetOrigem[i] == 0)
				{
					vetDestino[i] = v;
					break;
				}				
			}
			return;
		}
		hanoi(n-1,origem,auxiliar,destino,vetOrigem,vetAuxiliar,vetDestino);
		System.out.println("Move disco de " + origem + " para " + destino);
		
		
		
		hanoi(n-1,auxiliar,destino,origem,vetOrigem,vetAuxiliar,vetDestino);
	}
	
	public static void main(String[] args)
	{
		int[] vetOrigem = {1,2,3,4,5};
		int[] vetAuxiliar = {0,0,0,0,0};
		int[] vetDestino = {0,0,0,0,0};
		hanoi(5,1,2,3,vetOrigem,vetAuxiliar,vetDestino);
	}
	

}
