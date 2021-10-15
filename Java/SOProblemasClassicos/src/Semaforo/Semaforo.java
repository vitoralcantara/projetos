package semaforo;
// Implementa um semáforo clássico
// Incrementa contador do semáforo e äcorda "threads" que estejam em espera se for "up"
// e "down" decrementa o contador e se for zero suspende a thread

public class Semaforo
{
	private int indice;

	public Semaforo(int indiceInicial){
		indice = indiceInicial;
	}
	
	public Semaforo(){
		indice = 0;
	}

	public void down(){
		synchronized (this) {
			while (indice <= 0) {
				try {
					wait();
				} catch (InterruptedException ex) { }
			}
			indice--; // Decrementa contador
		}

	}

	public void up(){
		synchronized (this) {
			indice++;
			//notifica uma espera para acordar
			if (indice == 1 ) {
				notify();
			}
		}
	}
}