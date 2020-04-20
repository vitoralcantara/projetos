import java.util.ArrayList;
import java.util.List;

public class KNNCalc {

	public class Store {

		public Store(int numero, int x, int y, String classe) {
			super();
			this.numero = numero;
			this.x = x;
			this.y = y;
			this.classe = classe;
		}

		final int numero;
		final int x;
		final int y;
		final String classe;
		String predita;

		@Override
		public String toString() {
			return "n: " + numero + ", x: " + x + ", y: " + y + ",classe: "
					+ classe;
		}

	}

	public double calcularDistancia(float x1, float y1, float x2, float y2) {
		double a = x1 - x2;
		double b = Math.pow(a, 2);

		double c = y1 - y2;
		double d = Math.pow(c, 2);

		double e = d + b;
		return Math.sqrt(e);

	}

	public void calcular() {
		List<Store> lista = new ArrayList<Store>();
		lista.add(new Store(1, 1, 1, "A"));//
		lista.add(new Store(2, 1, 7, "A"));//
		lista.add(new Store(3, 1, 9, "A"));//
		lista.add(new Store(4, 2, 3, "A"));//
		lista.add(new Store(5, 3, 8, "A"));//
		lista.add(new Store(6, 4, 2, "A"));//
		lista.add(new Store(7, 6, 4, "A"));//
		lista.add(new Store(8, 7, 3, "B"));//
		lista.add(new Store(9, 7, 6, "A"));//
		lista.add(new Store(10, 7, 8, "A"));//
		lista.add(new Store(11, 8, 4, "B"));//
		lista.add(new Store(12, 9, 2, "B"));//
		lista.add(new Store(13, 9, 9, "A"));//
		lista.add(new Store(14, 10, 4, "B"));//

		for (int i = 0; i < 14; i++) {
			Store s = lista.get(i);
			double dist1 = 1000;
			double dist2 = 1000;
			double dist3 = 1000;

			Store comp1 = null;
			Store comp2 = null;
			Store comp3 = null;

			for (int j = 0; j < 14; j++) {
				if (i == j)
					continue;
				double temp = calcularDistancia(s.x, s.y, lista.get(j).x,
						lista.get(j).y);
				if (temp < dist3) {
					if (temp < dist2) {
						if (temp < dist1) {
							dist1 = temp;
							comp1 = lista.get(j);
						} else {
							dist2 = temp;
							comp2 = lista.get(j);
						}
					} else {
						dist3 = temp;
						comp3 = lista.get(j);
					}
				}
			}
			System.out.println("Mais próximos de: " + s.numero + ": "
					+ comp1.toString() + " | " + comp2.toString() + " | "
					+ comp3.toString());
		}
	}

	public static void main(String[] args) {
		KNNCalc k = new KNNCalc();
		k.calcular();

	}
}
