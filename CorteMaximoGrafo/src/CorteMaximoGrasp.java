import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe é responsável por ler um arquivo, criar um grafo, e encontrar o
 * conjunto de corte máximo deste grafo. Para mais detalhes, acesse
 * <code>Trabalho Corte Máximo GRASP.odt</code>.
 * 
 * @author Vitor Alcântara de Almeida
 * 
 */
public class CorteMaximoGrasp {
	/**
	 * Este enumerador é usado para identificar o conjunto ao qual cada vértice
	 * pertence. Se um vértice estiver marcado como <code>PRIMEIRO</code>, então
	 * o vértice pertence ao primeiro conjunto. Se ele estiver marcado como
	 * <code>SEGUNDO</code>, então o vértice pertence ao segundo conjunto. Se
	 * ele estiver marcado como <code>NENHUM</code>, então o vértice pertence a
	 * nenhum conjunto. Os conjuntos <code>PRIMEIRO</code> e
	 * <code>SEGUNDO</code> são disjuntos e a união de ambos forma o conjunto de
	 * vértices do grafo.
	 * 
	 * @author Vitor
	 * 
	 */
	public enum IDConjunto {
		PRIMEIRO, SEGUNDO, NENHUM
	}

	/**
	 * Esta variável contém o valor alfa que é usado no cálculo da lista de
	 * candidatos restritos. Veja o documento para mais detalhes.
	 */
	final double alfa;

	/**
	 * Esta lista armazena o conjunto de vértices do grafo. A estrutura de dados
	 * para armazenar o elemento é um vetor.
	 */
	final List<Vertice> conjuntoDeVertices;

	/**
	 * Esta lista armazena o conjunto de arestas do grafo. A estrutura de dados
	 * para armazenar o elemento é um vetor.
	 */
	final List<Aresta> conjuntoDeArestas;

	/**
	 * Esta lista armazena o wmax conjunto de arestas encontrado no grafo. A
	 * estrutura de dados para armazenar o elemento é um vetor.
	 */
	List<Aresta> corteMaximo = new ArrayList<Aresta>();

	/**
	 * Esta classe representa um vértice. Ela possui um identificador, uma lista
	 * de arestas que se ligam a este vértice, um identificador de conjunto e um
	 * método que retorna uma string representando o vértice.
	 */
	static class Vertice implements Comparable<Vertice> {
		int id;
		List<Aresta> arestas = new ArrayList<Aresta>();
		IDConjunto idConjunto;
		int custo = 0;

		@Override
		public String toString() {
			return "Vertice [id=" + id + ", arestas=" + arestas + "]";
		}

		@Override
		public int compareTo(Vertice o) {
			if (this.custo > o.custo) {
				return 1;
			} else if (this.custo == o.custo) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	/**
	 * Esta classe representa uma aresta. Ela possui um identificador, os dois
	 * vértices que são ligadas pela aresta, e um método que retorna uma string
	 * representando a aresta.
	 */
	static class Aresta {
		int id;
		Vertice v1;
		Vertice v2;

		@Override
		public String toString() {
			return "Aresta [id=" + id + ", v1=" + v1 + ", v2=" + v2 + "]";
		}
	}

	/**
	 * 
	 * Esta classe representa um grafo. Ela possui uma lista de arestas e uma
	 * lista de vértices.
	 */
	static class Grafo {
		List<Vertice> nos = new ArrayList<Vertice>();
		List<Aresta> arestas = new ArrayList<Aresta>();
	}

	/**
	 * Construtor da classe. Esta classe é responsável por calcular o corte
	 * máximo de um grafo usando a meta-heurística GRASP.
	 * 
	 * @param g
	 *            O grafo que será processado
	 */
	public CorteMaximoGrasp(Grafo g, double alfa) {
		this.conjuntoDeArestas = g.arestas;
		this.conjuntoDeVertices = g.nos;
		this.alfa = alfa;
	}

	/**
	 * Procedimento GRASP inicial. Este método é composto de duas etapas: Uma
	 * etapa de construção, no qual utiliza-se um algoritmo guloso randômico, e
	 * uma etapa de busca local. A fase de construção adiciona um elemento por
	 * vez em um conjunto que finaliza com a representação de uma solução
	 * possível. A cada iteração, um elemento é selecionado aleatoriamente de
	 * lista de candidatos restritos, no qual seus elementos são bem
	 * selecionados de acordo com alguma função gulosa. Após encontrar uma
	 * solução plausível, o procedimento de busca local tenta melhorá-lo
	 * produzindo uma solução ótima local em relação a alguma estrutura de
	 * vizinhança. As fases de construção e de busca local são aplicadas
	 * repetidamente. A melhor solução encontrada é retornada como uma
	 * aproximação para a solução ótima.
	 * 
	 * @param maximoIteracoes
	 */
	public void procedimentoGRASP(int maximoIteracoes) {
		for (int i = 0; i < maximoIteracoes; i++) {
			zerarIDConjuntoDosVertices();
			construirSolucaoRandomicaGulosaAdaptativa();
			buscaLocal();
			List<Aresta> corte = calcularArestasdoCorte();
			if (i == 1) {
				corteMaximo = corte;
			} else if (corte.size() > corteMaximo.size()) {
				corteMaximo = corte;
			}
		}
	}

	/**
	 * Este método zera a configuração do grafo, isto é, todos os vértices são
	 * marcados que pertencem a nenhum conjunto.
	 */
	private void zerarIDConjuntoDosVertices() {
		for (Vertice v : conjuntoDeVertices) {
			v.idConjunto = IDConjunto.NENHUM;
		}
	}

	/**
	 * Este método calcula o corte dada a configuração atual (Já estão definidos
	 * os dois conjuntos complementares de vértices do grafo). Ele percorre o
	 * vetor de arestas e adiciona em um contêiner as arestas que ligam vértices
	 * de conjuntos diferentes.
	 * 
	 * @return O conjunto de corte encontrado.
	 */
	private List<Aresta> calcularArestasdoCorte() {
		List<Aresta> corte = new ArrayList<Aresta>();
		for (Aresta a : conjuntoDeArestas) {
			if (a.v1.idConjunto == IDConjunto.PRIMEIRO
					&& a.v2.idConjunto == IDConjunto.SEGUNDO) {
				corte.add(a);
			} else if (a.v1.idConjunto == IDConjunto.SEGUNDO
					&& a.v2.idConjunto == IDConjunto.PRIMEIRO) {
				corte.add(a);
			}
		}
		return corte;
	}

	/**
	 * Etapa de busca local. A fase de busca local é baseada na seguinte
	 * estrutura de vizinhança. Sejam X e Y os conjuntos encontrados com a
	 * função gulosa (X,Y). Para cada vértice v pertencente a V associa-se tanto
	 * o vizinho (X \ {v}, Y união {v}) se v pertence a X, ou o vizinho (X uniao
	 * {v}, Y \ {v}) caso contrário. São então investigadas todas as mudanças
	 * possíveis. Se uma mudança resulta em um corte wmax que o atual, este novo
	 * corte torna-se a nova solução temporária. A procura é finalizada após
	 * todos os movimentos serem avaliados e nenhum vizinho melhor for
	 * encontrado.
	 * */
	private void buscaLocal() {
		boolean change = true;
		while (change) {
			change = false;
			for (Vertice v : conjuntoDeVertices) {
				if (v.idConjunto == IDConjunto.PRIMEIRO
						&& ro(IDConjunto.PRIMEIRO, v)
								- ro(IDConjunto.SEGUNDO, v) > 0) {
					v.idConjunto = IDConjunto.SEGUNDO;
					change = true;
				} else if (v.idConjunto == IDConjunto.SEGUNDO
						&& ro(IDConjunto.SEGUNDO, v)
								- ro(IDConjunto.PRIMEIRO, v) > 0) {
					v.idConjunto = IDConjunto.PRIMEIRO;
					change = true;
				}
				if (change)
					break;
			}
		}
	}

	/**
	 * Esta classe tem a função de armazenar os valores wmax e wmin encontrados
	 * na busca gulosa para calcular o valor de corte usado na definição da
	 * lista de candidatos restritos. Estas duas variáveis, wmax e wmin, estão
	 * detalhados no documento.
	 */
	private class Pair {
		final int wmin;
		final int wmax;

		public Pair(int wmin, int wmax) {
			this.wmin = wmin;
			this.wmax = wmax;
		}
	}

	/**
	 * Etapa gulosa aleatória adaptativa do GRASP. Este método primeiramente
	 * ordena aleatoriamente o conjunto de vértices, depois define que o
	 * primeiro vértice do conjunto de vértices é do primeiro conjunto, e, então
	 * percorre-se a lista de vértices verificando se cada vértice está ligado
	 * com mais vértices do primeiro conjunto ou de seu complemento (conjunto
	 * segundo). Se o vértice possuir mais arestas ligados ao primeiro conjunto,
	 * então este vértice é adicionado ao segundo conjunto, caso contrário, ele
	 * é definido como do primeiro conjunto. Veja o documento para mais
	 * detalhes.
	 * */
	private void construirSolucaoRandomicaGulosaAdaptativa() {
		while (!ehSolucaoFinal()) {
			Pair limites = calcularCustoDosElementos();
			List<Integer> lcr = construirLCR(limites);
			adicionarElementoASolucao(lcr);
		}
	}

	/**
	 * Este método seleciona aleatoriamente um dos elementos da lista de
	 * candidatos restritos e o adiciona ao conjunto solução
	 * 
	 * @param listaDeCandidatosRestritos
	 *            a lista de candidatos restritos
	 */
	private void adicionarElementoASolucao(
			List<Integer> listaDeCandidatosRestritos) {
		int randomPos = (int) (Math.random() * (listaDeCandidatosRestritos
				.size() - 1));
		int posicao = listaDeCandidatosRestritos.get(randomPos);
		Vertice v = conjuntoDeVertices.get(posicao);
		if (ro(IDConjunto.PRIMEIRO, v) > ro(IDConjunto.SEGUNDO, v)) {
			v.idConjunto = IDConjunto.SEGUNDO;
		} else {
			v.idConjunto = IDConjunto.PRIMEIRO;
		}
	}

	/**
	 * Este método calcula o custo de cada vértice do grafo. Além disso, este
	 * método calcula e retorna os valores <code>wmin</code> e <code>wmax</code>
	 * . Veja a documentação para mais detalhes.
	 * 
	 * @return Os valores <code>wmin</code> e <code>wmax</code>
	 */
	private Pair calcularCustoDosElementos() {
		int wmin = 0;
		int wmax = 0;
		for (Vertice v : conjuntoDeVertices) {
			if (v.idConjunto == IDConjunto.NENHUM) {
				v.custo = Math.max(ro(IDConjunto.PRIMEIRO, v),
						ro(IDConjunto.SEGUNDO, v));
				if (v.custo < wmin)
					wmin = v.custo;
				if (v.custo > wmax)
					wmax = v.custo;
			}
		}
		return new Pair(wmin, wmax);
	}

	/**
	 * Este método constrói a lista de candidatos restritos. Veja a documentação
	 * para mais detalhes.
	 * 
	 * @param limites
	 *            Os valores <code>wmin</code> e <code>wmax</code>
	 * @return A lista de candidatos restritos.
	 */
	private List<Integer> construirLCR(Pair limites) {
		List<Integer> listaDeCandidatosRestritos = new ArrayList<Integer>();
		int valorDeCorte = (int) (limites.wmin + alfa
				* (limites.wmax - limites.wmax));
		for (int i = 0; i < conjuntoDeVertices.size(); i++) {
			Vertice v = conjuntoDeVertices.get(i);
			if (v.custo >= valorDeCorte) {
				if (v.idConjunto == IDConjunto.NENHUM) {
					listaDeCandidatosRestritos.add(i);
				}
			}
		}
		return listaDeCandidatosRestritos;
	}

	/**
	 * Verifica se a configuração atual constitui uma solução, isto é, todos os
	 * vértices estão definidos como pertencentes ao conjunto PRIMEIRO ou
	 * SEGUNDO.
	 * 
	 * @return true se a configuração constitui uma solução válida, falso caso
	 *         contrário.
	 */
	private boolean ehSolucaoFinal() {
		for (Vertice v : conjuntoDeVertices) {
			if (v.idConjunto == IDConjunto.NENHUM) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Este método calcula quantas arestas ligam v a vértices do conjunto
	 * <code>idConjunto</code>.
	 * 
	 * @param idConjunto
	 *            o identificador do conjunto.
	 * @param v
	 *            o vértice avaliado.
	 * @return a quantidade de arestas que liga v a vértices do conjunto
	 *         <code>idConjunto</code>
	 */
	private int ro(IDConjunto idConjunto, Vertice v) {
		int count = 0;
		for (Aresta a : v.arestas) {
			Vertice outroVertice = null;
			if (a.v1 == v) {
				outroVertice = a.v2;
			} else if (a.v2 == v) {
				outroVertice = a.v1;
			} else {
				try {
					throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (outroVertice.idConjunto == idConjunto) {
				++count;
			}
		}
		return count;
	}

	/**
	 * Este método cria o grafo a partir do arquivo especificado. Ele armazena
	 * os vértices e arestas em dois vetores distintos, armazena em cada aresta
	 * a refeferência aos dois vértices que ela liga e em cada vértice as
	 * arestas que se ligam a ele.
	 * <p>
	 * Na primeira linha do arquivo deve-se conter o número de vértices e o
	 * número de arestas, e, deve-se ter, na próxima linha e nas suas
	 * subsequentes, o id de 2 vértices que estão diretamente ligados por uma
	 * aresta.
	 * <p>
	 * Por exemplo:
	 * <p>
	 * 2 3 <br>
	 * 1 2 <br>
	 * 2 3 <br>
	 * 1 3
	 * 
	 * 
	 * @param arquivo
	 *            O arquivo onde se encontra o grafo a ser processado
	 * @return A estrutura {@link Grafo} que contém o vetor de vértices e de
	 *         arestas
	 * @throws FileNotFoundException
	 *             Se o arquivo não foi encontrado no sistema
	 */
	public static Grafo extrairGrafoDeArquivo(String arquivo)
			throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(new File(arquivo)));
		int numeroDeVertices = scanner.nextInt();
		int numeroDeArestas = scanner.nextInt();
		List<Vertice> nos = new ArrayList<Vertice>(numeroDeVertices);
		List<Aresta> arestas = new ArrayList<Aresta>(numeroDeArestas);
		int i = 1;
		while (scanner.hasNextInt()) {
			int v1 = scanner.nextInt();
			int v2 = scanner.nextInt();
			if (scanner.hasNext())
				scanner.nextLine();
			Vertice no1 = null;
			Vertice no2 = null;
			for (Vertice no : nos) {
				if (no.id == v1) {
					no1 = no;
				} else if (no.id == v2) {
					no2 = no;
				}
			}
			if (no1 == null) {
				no1 = new Vertice();
				no1.id = v1;
				nos.add(no1);
			}
			if (no2 == null) {
				no2 = new Vertice();
				no2.id = v2;
				nos.add(no2);
			}
			Aresta a = new Aresta();
			a.id = i;
			a.v1 = no1;
			a.v2 = no2;
			no1.arestas.add(a);
			no2.arestas.add(a);
			arestas.add(a);
			++i;
		}
		Grafo g = new Grafo();
		g.arestas = arestas;
		g.nos = nos;
		return g;
	}

	/**
	 * O programa começa sua execução através deste método. O primeiro argumento
	 * é a lista de parâmetros que o usuário passa linha de comando quando se
	 * começa a execução.
	 * <p>
	 * O programa pode ser ajustado com 4 parâmetros:
	 * <p>
	 * t - Caso este parâmetro seja adicionado, mostra-se ao final do programa o
	 * tempo gasto na execução do mesmo. Por padrão, não mostra-se esta
	 * informação.
	 * <p>
	 * a - Caso este parâmetro seja adicionado, mostra-se ao final do programa o
	 * tempo gasto na execução apenas do algoritmo de corte. Por padrão, não
	 * mostra-se esta informação.
	 * <p>
	 * d - Caso este parâmetro seja adicionado, mostra-se, além do identificador
	 * das arestas do conjunto de corte, o identificador dos vértices que são
	 * ligados por cada aresta. Por padrão, mostra-se apenas o identificador das
	 * arestas do conjunto de corte.
	 * <p>
	 * i -Este parâmetro define a quantidade de iterações máximas que o GRASP
	 * deve fazer (olhar função GRASP inicial para mais detalhes). Este
	 * parâmetro deve ser seguido de dois pontos e um número inteiro positivo
	 * (i:35, por exemplo). Caso este parâmetro não seja definido, o algoritmo é
	 * executado com 10 iterações. Importante: Se este parâmetro for adicionado,
	 * ele deve ser o último da lista de parâmetros.
	 * <p>
	 * Um exemplo de execução do algoritmo é:
	 * <p>
	 * 4 parâmetros:
	 * <p>
	 * <code>java CorteMaximo adti:18 "C:\Users\g70.n"</code>
	 * <p>
	 * Nenhum parâmetro:
	 * <p>
	 * <code>java CorteMaximo "C:\Users\g70.n"</code>
	 * <p>
	 * O segundo argumento é o caminho do arquivo a ser a processado.
	 * 
	 * @param args
	 *            Os argumentos que são passados pela linha de comando
	 * 
	 */
	public static void main(String[] args) {
		boolean calcularTempoTotal = false;
		boolean calcularTempoAlgoritmo = false;
		boolean mostrarVerticesLigados = false;
		int numberOfIterations = 10;
		int i;
		double alfa = 0.5;
		if (args.length == 0) {
			System.out
					.println("Este programa deve ser iniciado com o caminho do arquivo que especifica o grafo no primeiro argumento. Peco desculpas pelo incomodo.");
			return;
		}
		for (i = 0; i < args.length - 1; i++) {
			if (args[i].equals("t")) {
				calcularTempoTotal = true;
			}
			if (args[i].equals("a")) {
				calcularTempoAlgoritmo = true;
			}
			if (args[i].equals("d")) {
				mostrarVerticesLigados = true;
			}
			if (args[i].startsWith("i:")) {
				int startIndex = args[i].indexOf("i:") + 2;
				String intString = args[i].substring(startIndex);
				numberOfIterations = Math.abs(Integer.parseInt(intString));
			}
			if (args[i].startsWith("alfa:")) {
				int startIndex = args[i].indexOf("alfa:") + 5;
				String doubleString = args[i].substring(startIndex);
				alfa = Double.parseDouble(doubleString);
				if (alfa > 1)
					alfa = 1;
				if (alfa < 0)
					alfa = 0;
			}
		}
		i = args.length - 1;
		long tempoInicialTotal = System.currentTimeMillis();
		Grafo g;
		try {
			g = extrairGrafoDeArquivo(args[i]);
			CorteMaximoGrasp c = new CorteMaximoGrasp(g, alfa);
			long tempoInicialAlgoritmo = System.currentTimeMillis();
			c.procedimentoGRASP(numberOfIterations);
			long tempoFinalAlgoritmo = System.currentTimeMillis();

			System.out.println("Tamanho do corte maximo: "
					+ c.corteMaximo.size()
					+ ". ID das arestas do corte máximo:");
			if (mostrarVerticesLigados) {
				for (Aresta aresta : c.corteMaximo) {
					System.out.println("Aresta " + aresta.id
							+ ": liga vertice " + aresta.v1.id + " ao vertice "
							+ aresta.v2.id);
				}
			} else {
				for (Aresta aresta : c.corteMaximo) {
					System.out.print(aresta.id + " ");
				}
			}
			long tempoFinalTotal = System.currentTimeMillis();
			System.out.println();
			if (calcularTempoAlgoritmo) {
				long tempoDecorrido = tempoFinalAlgoritmo
						- tempoInicialAlgoritmo;
				System.out.println("Tempo decorrido do algoritmo: "
						+ tempoDecorrido + " milisegundos.");
			}
			if (calcularTempoTotal) {
				long tempoDecorrido = (tempoFinalTotal - tempoInicialTotal);
				System.out.println("Tempo decorrido do programa: "
						+ tempoDecorrido + " milisegundos.");
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Houve um erro ao ler o arquivo. Por favor, verifique o caminho especificado do mesmo. Obrigado.");
		}
	}

}
