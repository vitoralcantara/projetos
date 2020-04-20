import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciciosAA {

	private class Tabela {
		int t[][];
	}

	public int backpackBacktrack(int index, int capacidade, int[] pesos,
			int[] valores) {
		int b = 0;
		for (int k = index; k < pesos.length; k++) {
			if (pesos[k] <= capacidade) {
				b = Math.max(
						b,
						valores[k]
								+ backpackBacktrack(k, capacidade - pesos[k],
										pesos, valores));
			}
		}
		return b;
	}

	public List<Integer> rainhasProbabilistico(int r, int n, List<Integer> v,
			Tabela tabuleiro) {
		List<Integer> solucao = new ArrayList<Integer>();
		int cont = 0;
		int k;
		while (cont < r) {
			int i = 0;
			for (; i < n; i++) {
				k = n;
				boolean h = true;
				while (h && k != 0) {
					int rand = (int) Math.random() * (v.size() - 1);
					int j = v.get(rand);
					boolean houveColisao = testaTabuleiro(i, j, solucao, n);
					if (!houveColisao) {
						solucao.add(j);
						h = false;
					} else {
						Collections.swap(v, j, k);
						k--;
					}
				}
				if (k == 0) {
					i = n + 2;
					cont++;
				}
			}
			if (i == n + 1) {
				return solucao;
			}
		}
		return null;
	}

	private boolean testaTabuleiro(int i, int j, List<Integer> solucao, int n) {
		for (int k = i - 1, upper = j, lower = j; k >= 0; k--, upper--, lower++) {
			if (solucao.get(k) == j) {
				return false;
			}
			if (upper >= 0) {
				if (solucao.get(k) == upper) {
					return false;
				}
			}
			if (lower < n) {
				if (solucao.get(k) == lower) {
					return false;
				}
			}
		}
		return true;
	}

	// private Tabela hillClimbConfig8(Tabela tabela, int iInicial, int
	// jInicial,
	// boolean primeiraEstrategia) {
	// boolean configuracaoFinal = verificarConfiguracao(tabela);
	// if (configuracaoFinal)
	// return tabela;
	// else {
	// while (!configuracaoFinal) {
	// List<Tabela> configuracoes = new ArrayList<Tabela>();
	//
	//
	// int posicaoCorreta = verificarNumeroDeAlocaocesNaPosicaoCorreta(tabela);
	// int movimentosFaltantes =
	// verificarPassosFaltantesParaPosicaoCorreta(tabela);
	//
	// }
	// }
	//
	// }
	//
	// private int verificarPassosFaltantesParaPosicaoCorreta(Tabela tabela) {
	// int count = 0;
	// for (int i = 0; i < tabela.t.length; i++) {
	// for (int j = 0; j < tabela.t.length; j++) {
	// if (tabela.t[i][j] == 1) {
	// count = count + i + j;
	// }
	// if (tabela.t[i][j] == 2) {
	// count = count + i + Math.abs(j - 1);
	// }
	// if (tabela.t[i][j] == 3) {
	// count = count + i + Math.abs(j - 2);
	// }
	// if (tabela.t[i][j] == 4) {
	// count = count + Math.abs(i - 1) + Math.abs(j - 2);
	// }
	// if (tabela.t[i][j] == 5) {
	// count = count + Math.abs(i - 2) + Math.abs(j - 2);
	// }
	// if (tabela.t[i][j] == 6) {
	// count = count + Math.abs(i - 2) + Math.abs(j - 1);
	// }
	// if (tabela.t[i][j] == 7) {
	// count = count + Math.abs(i - 2) + Math.abs(j - 0);
	// }
	// if (tabela.t[i][j] == 8) {
	// count = count + Math.abs(i - 1) + Math.abs(j - 0);
	// }
	// }
	// }
	// return count;
	// }
	//
	// private int verificarNumeroDeAlocaocesNaPosicaoCorreta(Tabela tabela) {
	// int count = 0;
	// if (tabela.t[0][0] != 1)
	// ++count;
	// if (tabela.t[0][1] != 2)
	// ++count;
	// if (tabela.t[0][2] != 3)
	// ++count;
	// if (tabela.t[1][2] != 4)
	// ++count;
	// if (tabela.t[2][2] != 5)
	// ++count;
	// if (tabela.t[2][1] != 6)
	// ++count;
	// if (tabela.t[2][0] != 7)
	// ++count;
	// if (tabela.t[1][0] != 8)
	// ++count;
	// return count;
	// }

	private boolean verificarConfiguracao(Tabela tabela) {
		if (tabela.t[0][0] != 1)
			return false;
		if (tabela.t[0][1] != 2)
			return false;
		if (tabela.t[0][2] != 3)
			return false;
		if (tabela.t[1][0] != 8)
			return false;
		if (tabela.t[1][1] != 0)
			return false;
		if (tabela.t[1][2] != 4)
			return false;
		if (tabela.t[2][0] != 7)
			return false;
		if (tabela.t[2][1] != 6)
			return false;
		if (tabela.t[2][2] != 5)
			return false;
		return true;
	}

	public static int fibPD(int n) {
		if (n == 1 || n == 0)
			return 1;
		else {
			int menor = 1;
			int maior = 1;
			int result = 0;
			for (int i = 2; i <= n; i++) {
				result = menor + maior;
				menor = maior;
				maior = result;
			}
			return result;
		}
	}

	public static int fib(int n) {
		if (n == 1 || n == 0)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

}
