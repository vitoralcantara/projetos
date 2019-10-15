package barbeiro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import semaforo.Semaforo;


public class BarbeiroDorminhoco extends Thread {

	//-1 Significa infinito	
	public static int numeroDeClientes = -1;
	public static int numeroDeBarbeiros = 3;
	public static int duracaoDoCorte = 7500;
	public static int intervaloEntreCortes = 15000;
	public static boolean dormindo = false;

	/*
	*clientes - número de clientes
	*barbeiros - número de barbeiros
	*mutex - exclusão mútua
	*espera - clientes em espera nas cadeiras
	*cadeiras - número de cadeiras
	*/
	public static Semaforo clientes = new Semaforo(0);
	public static Semaforo barbeiros = new Semaforo(0);
	public static Semaforo mutex = new Semaforo(1);
	public static int espera = 0;
	public static int cadeiras = 5;

	class Barbeiro extends Thread {
		private int idBarbeiro;

		public Barbeiro(int i) { 
			idBarbeiro = i;
		}

		public void run(){ // funções barbeiro
			while(true) {
				clientes.down(); // Dorme se não houver clientes
				mutex.down(); // Requer acesso para esperar
				espera = espera - 1; // Decrementa o numero de clientes em espera
				barbeiros.up(); // Acorda um barbeiro
				mutex.up(); // Sai da espera		
				cortarCabelo();
			}
		}

		
		public void cortarCabelo(){
			System.out.println("barbeiro " + idBarbeiro + " está cortando cabelo");
			try {
				sleep(duracaoDoCorte);
			} catch (InterruptedException ex){ }
			if(espera == 0)
			{
				dormindo = true;
				System.out.println("barbeiro " + idBarbeiro + " está dormindo");
			}
		}
	}
	
	private class Cliente extends Thread {
		private int idCliente;

		public Cliente(int i) {
			idCliente = i;
		}

		public void run(){ // funções clientes
			
			mutex.down(); // Requer acesso para esperar
			if(espera < cadeiras){
				espera = espera + 1; // Senta em uma cadeira
				if(espera == 1 && dormindo == true)
				{
					dormindo = false;
					System.out.println("Um barbeiro foi acordado");
				}
				System.out.println("Cliente " + idCliente + " está esperando");
				clientes.up(); // Se necessário acorda um barbeiro
				mutex.up(); // Sai da espera
				barbeiros.down(); // Fica na cadeira se nao houver barbeiro disponíveis
				//clientes.down();
				terCabeloCortado();
			} else {
				mutex.up(); // Barbearia cheia, vai embora
				System.out.println("Cliente " + idCliente + " foi embora pois não havia cadeira");
			}
		}

		public void terCabeloCortado(){
			System.out.println("O Cabelo do Cliente " + idCliente + " está sendo cortado");
			try {
				sleep(duracaoDoCorte);
			} catch (InterruptedException ex){ }
		}
	}


	public static void main(String args[]) {
	
		//Pega do usuário o número de barbeiros e cadeiras da barbearia

		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bem-vindo a barbearia do Pablo Thiago Chico");
		System.out.println("Quantos barbeiros há na barbearia (por favor me responda um inteiro positivo)?");
		boolean numeroCorreto = false;
		while(!numeroCorreto)
			try {
				numeroDeBarbeiros = Integer.parseInt(leitor.readLine());
				if(numeroDeBarbeiros <= 0)
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
			System.out.println("Quantas cadeiras há na barbearia (por favor me responda novamente um inteiro positivo)?");
			numeroCorreto = false;
			while(!numeroCorreto)
				try {
					cadeiras = Integer.parseInt(leitor.readLine());
					if(cadeiras <= 0)
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
				
				System.out.println("Qual o tempo de duracao de um corte (em segundos)?");
				numeroCorreto = false;
				while(!numeroCorreto)
					try {
						duracaoDoCorte = Integer.parseInt(leitor.readLine()) * 1000;
						if(cadeiras <= 0)
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
					
					System.out.println("Qual o intervalo médio de chegada de novos clientes (em segundos)?");
					numeroCorreto = false;
					while(!numeroCorreto)
						try {
							intervaloEntreCortes = Integer.parseInt(leitor.readLine() )* 1000;
							if(cadeiras <= 0)
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
							
				System.out.println("Iniciando barbearia com:");
				System.out.println("Numero de Barbeiros: " + numeroDeBarbeiros);
				System.out.println("Numero de Cadeiras: " + cadeiras);
				System.out.println("Intervalo entre Cortes: " + intervaloEntreCortes);
				System.out.println("Duração do corte: " + duracaoDoCorte);
				System.out.println();
								
				BarbeiroDorminhoco principal = new BarbeiroDorminhoco();
				principal.start();

	}

	// Gera os clientes que chegam
	public void run(){

		final int barbeiros = numeroDeBarbeiros;

		Barbeiro umBarbeiro;
		Cliente umCliente;
				
		for(int i=0; i < barbeiros; i++) {
			// Cria os barbeiros
			umBarbeiro = new Barbeiro(i);
			umBarbeiro.start();
		}

		int numeroDoCliente = 0;
		while(true){
			umCliente = new Cliente(numeroDoCliente++);
			umCliente.start();

			// Tempo de espera para gerar outro cliente
			try {
				int x = (int) (Math.random() * intervaloEntreCortes);
				sleep(x);
			} catch(InterruptedException ex) {};
		}
	} 

}