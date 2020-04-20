import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LeitorDados {

	public static void main(String[] args) {

		int somaTempo = 0;
		int somaResultado = 0;
		int max = 0;
		int qtVezesMelhorSolucao = 0;
		int count = 0;

		File f = new File(args[0]);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			try {
				while (br.ready()) {
					String srt = br.readLine();
					StringTokenizer st = new StringTokenizer(srt, " ");
					while (st.hasMoreTokens()) {
						String elem = st.nextToken();
						if (elem.equals("algoritmo:")) {
							elem = st.nextToken();
							int value = Integer.valueOf(elem);
							somaTempo += value;
						} else if (elem.equals("maximo:")) {
							elem = st.nextToken();
							int value = Integer.valueOf(elem.substring(0,
									elem.indexOf(".")));
							// System.out.println(value);
							somaResultado += value;
							count = count + 1;
							if (value > max) {
								max = value;
								qtVezesMelhorSolucao = 1;
							} else if (value == max) {
								++qtVezesMelhorSolucao;
							}
						}
					}
					if (count >= 30) {
						break;
					}
				}
				System.out.println("Soma resultado: " + somaResultado);
				System.out.println("Tempo médio execucao: " + (somaTempo / 30));
				System.out.println("Melhor solução encontrada: " + max);
				System.out.println("Média das soluções: " + (somaResultado)
						/ 30);
				System.out.println("Quantidade de vezes da melhor solucao: "
						+ qtVezesMelhorSolucao);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
