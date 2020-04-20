package fifo;

public class FilaCircular {

	private static final int tamInicial = 3;
	int val[];
	int in = -1;
	int out = -1;

	public FilaCircular() {
		val = new int[tamInicial];
	}

	public boolean isEmpty() {
		if (in == -1 && out == -1) {
			return true;
		}
		return false;
	}

	public void put(int i) throws FilaCheiaException {
		if ((in + 1) % tamInicial == out) {
			throw new FilaCheiaException();
		}

		if (in == -1 && out == -1) {
			in = 0;
			out = 0;
			val[in] = i;
		} else {
			in = (in + 1) % tamInicial;
			val[in] = i;
		}
	}

	public int get() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		int i = val[out];
		if (out == in) {
			out = -1;
			in = -1;
		} else {
			out = (out + 1) % tamInicial;
		}
		return i;
	}
}
