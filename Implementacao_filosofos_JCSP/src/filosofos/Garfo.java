package filosofos;

import org.jcsp.lang.Any2AnyChannel;
import org.jcsp.lang.CSProcess;
import org.jcsp.lang.Channel;

public class Garfo implements CSProcess {

	private final Any2AnyChannel[] colocar;
	private final Any2AnyChannel[] pegar;
	private final int i;

	public Garfo(Any2AnyChannel[] pegar2, Any2AnyChannel[] colocar2, int i) {
		this.colocar = colocar2;
		this.pegar = pegar2;
		this.i = i;
	}

	public void run() {

		pegar[i].out().write("");
		System.out.println("pegar"+i);
		colocar[i].out().write(null);
		System.out.println("colocar"+i);

		// pegar[i][i].write("pegar.i.i");
		// colocar[i][i].write("colocar.i.i");

		// final Guard[] guards = new Guard[] { choc, conf };
		// Alternative alt = new Alternative(guards);
		//
		// final int C_CHOC = 0;
		// final int C_CONF = 1;
		//
		// switch (alt.select()) {
		// case C_CHOC:
		// System.out.println("Cliente escolheu chocolate...");
		// (new Skip()).run();
		// break;
		// case C_CONF:
		// System.out.println("Cliente escolheu confeito...");
		// (new Skip()).run();
		// break;
		// }
	}

	public static void main(String[] args) {
		Any2AnyChannel[] colocar = Channel.any2anyArray(5);
		Any2AnyChannel[] pegar = Channel.any2anyArray(5);
		Garfo g = new Garfo(pegar, colocar, 0);
		g.run();
	}
}
