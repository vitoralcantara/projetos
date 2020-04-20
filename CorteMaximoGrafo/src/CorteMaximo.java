import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe é responsável por ler um arquivo, criar um grafo, e encontrar o
 * conjunto de corte máximo deste grafo. Para mais detalhes, acesse
 * <code>Trabalho Corte Máximo.odt</code>.
 * 
 * @author Vitor Alcântara de Almeida
 * 
 */
public class CorteMaximo {

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
	 * Esta variável é usada para contar a quantidade de cálculos de corte
	 * máximo que são feitos. Não influenciam no algoritmo, apenas provê uma
	 * informação a mais em relação ao processamento da informação.
	 */
	public int totalCount = 0;

	/**
	 * esta variável armazena a quantidade de arestas que não está no conjunto
	 * de corte definido em {@link #corteMaximo}.
	 */
	int totalArestasNaoCorte;

	/**
	 * Este método é o construtor da classe {@link CorteMaximo}. Ela só é
	 * inicializada com um grafo dado como entrada, no qual ela armazena este
	 * grafo em {@link #conjuntoDeArestas} e {@link #conjuntoDeVertices}. Além
	 * disso, salva em {@link #totalArestasNaoCorte} a quantidade de arestas do
	 * conjunto de arestas, pois o conjunto de corte máximo está inicialmente
	 * vazia.
	 * 
	 * @param g
	 *            O grafo que será processado
	 */
	public CorteMaximo(Grafo g) {
		this.conjuntoDeVertices = g.nos;
		this.conjuntoDeArestas = g.arestas;
		totalArestasNaoCorte = conjuntoDeArestas.size();
	}

	/**
	 * 
	 * Esta classe representa um grafo. Ela possui uma lista de arestas e uma
	 * lista de arestas.
	 */
	static class Grafo {
		List<Vertice> nos = new ArrayList<Vertice>();
		List<Aresta> arestas = new ArrayList<Aresta>();
	}

	/**
	 * Esta classe representa um vértice. Ela possui um identificador, uma lista
	 * de arestas que se ligam a este vértice e um método que retorna uma string
	 * representando o vértice.
	 */
	static class Vertice {
		int id;
		int pos;
		List<Aresta> arestas = new ArrayList<Aresta>();
		boolean primeiroConjunto = false;

		@Override
		public String toString() {
			return "Vertice [id=" + id + ", arestas=" + arestas
					+ ", primeiroConjunto=" + primeiroConjunto + "]";
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
	 * Este método é executado em um nó folha da árvore e calcula o conjunto de
	 * corte dada uma configuração atual (os vértices já estão definidos em seus
	 * respectivos conjuntos).
	 * <p>
	 * O que este método faz é percorrer o conjunto de arestas e verificar, para
	 * cada aresta, se os vértices que ele liga estão em conjuntos distintos. Se
	 * sim, adiciona-se esta aresta em um conjunto de arestas inicialmente vazia
	 * (<code>corteAtual</code>).
	 * <p>
	 * Ao final, Se <code>corteAtual</code> for wmax que o wmax conjunto de
	 * corte encontrado até o momento (armazenado em {@link #corteMaximo}),
	 * então este torna-se o novo wmax conjunto de corte, e define-se em outra
	 * variável ( {@link #totalArestasNaoCorte}) a quantidade de arestas que não
	 * fazem parte do conjunto de corte.
	 */
	private void calcularCorte() {
		List<Aresta> corteAtual = new ArrayList<Aresta>(
				conjuntoDeArestas.size());
		for (Aresta aresta : conjuntoDeArestas) {
			if (aresta.v1.primeiroConjunto == !aresta.v2.primeiroConjunto) {
				corteAtual.add(aresta);
			}
		}
		if (corteAtual.size() > corteMaximo.size()) {
			corteMaximo = corteAtual;
			totalArestasNaoCorte = conjuntoDeArestas.size()
					- corteMaximo.size();
			return;
		}
		return;
	}

	/**
	 * Este método é executado no nó da árvore, e é dividido em duas partes.
	 * Nesta primeira parte, o vértice correspondente ao nó é marcado como sendo
	 * do primeiro conjunto se o o nó atual for o nó 1, e 2 caso contrário.
	 * <p>
	 * Depois disso, verifica-se se a quantidade de arestas que não fazem parte
	 * do conjunto de corte no caminho atual da arvore é wmax do que a
	 * quantidade de arestas que não fazem parte do wmax conjunto de corte
	 * encontrado até o momento. Se o primeiro for wmax que o segundo, então,
	 * os filhos são cortados e a execução volta para o nó pai. Caso contrário,
	 * continua-se a execução na segunda parte do método.
	 * 
	 * 
	 * @param no1
	 *            booleano indicando se o nó tem flag "1", caso o valor seja
	 *            true, ou "0", caso o valor seja "0".
	 * @param profundidade
	 *            profundidade atual do nó.
	 * @param somaArestasNaoCorte
	 *            este parâmetro armazena o total de arestas que não fazem parte
	 *            do conjunto de corte no caminho atual da árvore.
	 */
	private void percorrerNo(boolean no1, int profundidade,
			int somaArestasNaoCorte) {
		Vertice vertice = conjuntoDeVertices.get(profundidade);
		if (no1) {
			vertice.primeiroConjunto = true;
		} else {
			vertice.primeiroConjunto = false;
		}

		int arestasNAOCorte = 0;
		for (Aresta a : vertice.arestas) {
			Vertice temp;
			if (a.v1 == vertice) {
				temp = a.v2;
			} else {
				temp = a.v1;
			}
			if (temp.pos < profundidade) {
				if (temp.primeiroConjunto == vertice.primeiroConjunto) {
					++arestasNAOCorte;
				}
			}
			if (somaArestasNaoCorte + arestasNAOCorte > totalArestasNaoCorte) {
				return;
			}
		}
		percorrerNo(no1, profundidade, somaArestasNaoCorte, arestasNAOCorte);
	}

	/**
	 * Esta é a segunda parte do método de percorrer o nó. Nesta parte,
	 * verifica-se:
	 * 
	 * 
	 * <ol>
	 * <li>Se a profundidade for máxima (tamanho do conjunto de vértices do
	 * grafo - 1), então calcular o conjunto de corte.</li>
	 * <li>Caso contrário, se o nó atual tiver flag "1", percorrer o filho
	 * direito e depois o filho esquerdo, senão, percorrer o filho esquerdo e
	 * depois o filho direito</li>
	 * </ol>
	 * 
	 * @param no1
	 *            booleano indicando se o nó tem flag "1", caso o valor seja
	 *            true, ou "0", caso o valor seja "0".
	 * @param profundidade
	 *            profundidade atual do nó.
	 * @param somaArestasNaoCorte
	 *            este parâmetro armazena o total de arestas que não fazem parte
	 *            do conjunto de corte no caminho atual da árvore.
	 * @param arestasNAOCorte
	 *            este parâmetro armazena as arestas que não fazem parte do
	 *            conjunto de corte calculados para o vértice deste nó.
	 */
	private void percorrerNo(boolean no1, int profundidade,
			int somaArestasNaoCorte, int arestasNAOCorte) {
		if (profundidade >= conjuntoDeVertices.size() - 1) {
			calcularCorte();
			++totalCount;
		} else {
			percorrerNo(!no1, profundidade + 1, somaArestasNaoCorte
					+ arestasNAOCorte);
			percorrerNo(no1, profundidade + 1, somaArestasNaoCorte
					+ arestasNAOCorte);
		}
	}

	/**
	 * Este método inicia a execução da árvore de chamadas para calcular o corte
	 * máximo. Define-se o primeiro nó filho como nó esquerdo (flag "1"), define
	 * a profundidade = 0, e o total de arestas que não fazem parte do conjunto
	 * de corte = 0.
	 * 
	 */
	public void calcularMaxCut() {
		definirId();
		percorrerNo(true, 0, 0);
	}

	/**
	 * Este método define, para cada vértice v, v.id = posicao de v no vetor de
	 * vértices.
	 */
	private void definirId() {
		for (int i = 0; i < conjuntoDeVertices.size(); i++) {
			conjuntoDeVertices.get(i).pos = i;
		}
	}

	/**
	 * Este método cria o grafo a partir do arquivo especificado. Ele armazena
	 * os vértices e arestas em dois vetores distintos, armazena em cada aresta
	 * a refeferência aos dois vértices que ela liga e em cada vértice as
	 * arestas que se ligam a ele.
	 * <p>
	 * O arquivo que será lido deve ter o seguinte formato:
	 * 
	 * <numero de vertices> <numero de arestas> <id de vertice> <id de vertice>
	 * <id de vertice> <id de vertice> ...
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
	 * O programa começa sua execução através deste método. O primeiro parâmetro
	 * é a lista de argumentos que o usuário passa linha de comando quando se
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
	 * i - Caso este parâmetro seja adicionado, mostra-se a quantidade de
	 * cálculos de corte que foram feitos (cálculos de corte ao chegar na raiz
	 * da árvore). Por padrão, esta informação não é mostrada.
	 * <p>
	 * Um exemplo de execução do algoritmo é:
	 * <p>
	 * 3 parâmetros:
	 * <p>
	 * <code>java CorteMaximo adt "C:\Users\g70.n"</code>
	 * <p>
	 * Nenhum parâmetro:
	 * <p>
	 * <code>java CorteMaximo "C:\Users\g70.n"</code>
	 * <p>
	 * O segundo parâmetro é o caminho do arquivo a ser a processado.
	 * 
	 * @param args
	 *            Os argumentos que são passados pela linha de comando
	 */
	public static void main(String[] args) {
		boolean calcularTempoTotal = false;
		boolean calcularTempoAlgoritmo = false;
		boolean mostrarVerticesLigados = false;
		boolean mostrarQuantidadeIteracoes = false;
		int i = 0;
		if (args.length == 0) {
			System.out
					.println("Este programa deve ser iniciado com o caminho do arquivo que especifica o grafo no primeiro argumento. Peco desculpas pelo incomodo.");
			return;
		}
		if (args.length == 2) {
			String options = args[0];
			if (options.contains("t")) {
				calcularTempoTotal = true;
			}
			if (options.contains("a")) {
				calcularTempoAlgoritmo = true;
			}
			if (options.contains("d")) {
				mostrarVerticesLigados = true;
			}
			if (options.contains("i")) {
				mostrarQuantidadeIteracoes = true;
			}
			i = 1;
		}

		long tempoInicialTotal = System.currentTimeMillis();
		Grafo g;
		try {
			g = extrairGrafoDeArquivo(args[i]);
			CorteMaximo c = new CorteMaximo(g);
			long tempoInicialAlgoritmo = System.currentTimeMillis();
			c.calcularMaxCut();
			long tempoFinalAlgoritmo = System.currentTimeMillis();
			if (mostrarQuantidadeIteracoes) {
				System.out.println("Foram calculados " + c.totalCount
						+ " conjuntos de corte.");
			}
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
				long tempoDecorrido = tempoFinalTotal - tempoInicialTotal;
				System.out.println("Tempo decorrido do programa: "
						+ tempoDecorrido + " milisegundos.");
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Houve um erro ao ler o arquivo. Por favor, verifique o caminho especificado do mesmo. Obrigado.");
		}
	}
}
