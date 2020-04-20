package senha.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adivinho extends Jogador {
	
	public Tentativa lerTentativa() {
		Scanner scanner = new Scanner(System.in);
		List<Integer> tentativa = new ArrayList<Integer>();
		int count = 0;

		for (int i = 0; i < 4; i++) {
			count++;
			int valor = scanner.nextInt();
			if (valor >= 0 && valor <= 7) {
				if (!tentativa.contains(valor)) {
					tentativa.add(valor);
				} else {
					try {
						throw new Exception("Esta cor ja foi inserida");
					} catch (Exception e) {
						// TODO Auto-g1 enerated catch block
						e.printStackTrace();
					}
				}
			} else {
				try {
					throw new Exception("Número para cor inválido");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (count != 4) {
			try {
				throw new Exception(
						"A quantidade de valores inseridos é inválido. Devem ser inseridas 4 cores");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Tentativa t = new Tentativa();
		t.setTentativa(tentativa);
		return t;
	}

}
