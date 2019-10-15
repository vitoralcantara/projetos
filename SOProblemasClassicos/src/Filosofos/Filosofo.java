package filosofos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import semaforo.Semaforo;

public class Filosofo extends Thread {

	//Filósofo está tentando pegar os garfos
	public static int FOME = 1;
	
	//Filósofo está pensando
	public static int PENSANDO = 2;
	
	//Filósofo está comendo
	public static int COMENDO = 3;
	
	//ID do filósofo
	public int i;

	//Tempo máximo para Pensar 
	public static int tempoMaximoParaPensar;
	
	//Tempo máximo para Comer
	public static int tempoMaximoParaComer;

	//Número de Filósofos
	public static int numeroDeFilosofos;
	
	//Matriz para monitorar o estado de todos os filósofos
	public static int[] estado;
	
	//Um semáforo por filósofo
	public static Semaforo[] filosofos;

	//Exclusão mútua para regiões críticas
	public static Semaforo mutex = new Semaforo(1);

	//Inicializa o filósofo com o ID
	public Filosofo(int i){
		this.i = i;
	}

	//Número do vizinho a esquerda de i
	int esq(int i)
	{
		if(i == 0) return numeroDeFilosofos -1;
		return i-1;
	}

	//Número do vizinho a direita de i
	int dir(int i)
	{
		if(i == numeroDeFilosofos - 1) return 0;
		return i+1;

	}	

	//Executa o filósofo indefinidamente
	public void run()
	{
		while(true) //repete eternamente
		{
			pensar(); //filósofo está pensando
			pegarGarfos(i); //pega dois garfos ou bloqueia
			System.out.println("Filosofo " + (i+1) + " pegou garfos"); // imprime que o filósofo atual pegou garfos
			comer(); //filósofo está comendo espaguete
			deixarGarfos(i); //coloca de volta os espaguetes na mesa
			System.out.println("Filosofo " + (i+1) + " soltou garfos"); //imprime que o filósofo atual soltou os garfos
		}
	}

	void comer()
	{
		try {
			sleep((long) (Math.random()*tempoMaximoParaComer));
		} catch (InterruptedException e) {}
	}
	
	void pensar()
	{
		try {
			sleep((long) (Math.random()*tempoMaximoParaPensar));
		} catch (InterruptedException e) {}
	}

	//i = número do filósofo
	void pegarGarfos(int i)
	{
		mutex.down(); //Entra na região crítica
		estado[i] = FOME; // Registra o fato de que o filósofo está com fome
		verificar(i); //Tenta pegar 2 garfos
		mutex.up(); //Sai da região crítica
		filosofos[i].down();//Bloqueia se os garfos não foram pegos	
	}

	//i = número do filósofo
	void deixarGarfos(int i)
	{
		mutex.down(); //Entra na região crítica
		estado[i] = PENSANDO; //Filósofo terminou de comer
		verificar(esq(i)); //Vê se o vizinho esquerdo agora pode comer
		verificar(dir(i)); //Vê se o vizinho direito agora pode comer
		mutex.up(); //Sai da região crítica
	}

	void verificar(int i)
	{
		if(estado[i] == FOME && estado[esq(i)] != COMENDO && estado[dir(i)] != COMENDO)
		{
			estado[i] = COMENDO;
			filosofos[i].up();			
		}
	}

	public static void main(String[] args)
	{
		
		//Trecho de código para pegar os dados do usuário
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bem-vindo ao restaruante dos filósofos");
		System.out.println("Quantos são os filósofos (por favor me responda um inteiro positivo)?");
		boolean numeroCorreto = false;
		while(!numeroCorreto)
			try {
				numeroDeFilosofos = Integer.parseInt(leitor.readLine());
				if(numeroDeFilosofos <= 0)
				{
					System.out.println("Me desculpe, mas você não inseriu um número inteiro positivo");
				}
				else
				{
					numeroCorreto = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Me desculpe, mas você não inseriu um número inteiro");
			} catch (IOException e) {
				System.out.println("Houve um erro de entrada e saída. Verifique sua máquina, por favor.");
			}
			System.out.println("Qual o tempo máximo que deve comer um filósofo (em segundos)?");
			numeroCorreto = false;
			while(!numeroCorreto)
				try {
					tempoMaximoParaComer = Integer.parseInt(leitor.readLine()) * 1000;
					if(tempoMaximoParaComer <= 0)
					{
						System.out.println("Me desculpe, mas você não inseriu um número inteiro positivo");
					}
					else
					{
						numeroCorreto = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("Me desculpe, mas você não inseriu um número inteiro");
				} catch (IOException e) {
					System.out.println("Houve um erro de entrada e saída. Verifique sua máquina, por favor.");
				}

				System.out.println("Qual o tempo máximo que deve pensar um filósofo (em segundos)?");
				numeroCorreto = false;
				while(!numeroCorreto)
					try {
						tempoMaximoParaPensar = Integer.parseInt(leitor.readLine()) * 1000;
						if(tempoMaximoParaPensar <= 0)
						{
							System.out.println("Me desculpe, mas você não inseriu um número inteiro positivo");
						}
						else
						{
							numeroCorreto = true;
						}
					} catch (NumberFormatException e) {
						System.out.println("Me desculpe, mas você não inseriu um número inteiro");
					} catch (IOException e) {
						System.out.println("Houve um erro de entrada e saída. Verifique sua máquina, por favor.");
					}

					Filosofo filosofo;
					estado = new int[numeroDeFilosofos];
					filosofos = new Semaforo[numeroDeFilosofos];
					for(int i=0; i < numeroDeFilosofos; i++) {
						// Cria os semáforos dos filósofos
						filosofos[i] = new Semaforo();
					}				
					for(int i=0; i < numeroDeFilosofos; i++) {
						// Cria os filósofos
						filosofo = new Filosofo(i);
						filosofo.start();
					}
	}


}
