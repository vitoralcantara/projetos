package main;

/***
 *
 * Esta classe representa a fachada do Jogo Uno, ou seja, define todos os comandos 
 * disponiveis numa versao simples do Jogo Uno.
 *
 * O baralho é composto por cartas de quatro cores: verde, amarelo, vermelho e azul.
 *  As fileiras de cada cor variam entre 0 e 9. Existem três ações especiais para cada  
 *  tipo de cor de carta, identificadas como "pular", "pescar duas" e "inverter".  
 *  Há também cartas de ações especiais com fundo preto, "coringa" e "coringa comprar quatro". 
 *  Para cada carta regular ou de ação, existem duas das mesmas no baralho, com exceção  
 *  do 0, que s� possui uma unidade.
 *
 *   Total de Cartas:	108
 * 
 * @author Roberta Coelho
 *
 */

public interface InterfaceFachadaUno {

	public static int VERMELHO = 1, AMARELO=2, VERDE=3, AZUL=4, MULTICOLORIDA=5;
	public static int PASSAVEZ = 13, INVERTE=14, PESCA2=15, CORINGAPESCA4=16,CORINGA=17;
	public static int UM = 1, DOIS=2, TRES=3, QUATRO=4,CINCO=5, SEIS = 6, SETE=7, OITO=8, NOVE=9,ZERO=0;

	
	/**
	 * @param nomesParticipantes qq String definindo o nome dos participantes, tal que nomesParticipantes.length() <= 30
	 * @param codPartidaAnterior código de uma partida anteior, caso 
	 *  esta jogada esteja dando continuidade a uma jogada que foi pausada.
	 * @return o codigo da partida iniciada.
	 * @exception lanca a excecao ArgumentoInvalidoException se algum dos parametros enviados para esta funcao possuir um valor invalido ex: nomeParticipantes==null, 
	 **/
	public int inicializaJogo (String[] nomesParticipantes) throws ArgumentoInvalidoException;

	
	
/**
 * @param nomesParticipantes qq String definindo o nome dos participantes, tal que nomesParticipantes.length() <= 30
 * @param codPartidaAnterior c�digo de uma partida anteior, caso 
 *  esta jogada esteja dando continuidade a uma jogada que foi pausada.
 * @return o codigo da partida iniciada.
 * @exception lanca a excecao ArgumentoInvalidoException se algum dos parametros enviados para esta funcao possuir um valor invalido ex: nomeParticipantes==null,
 * ou codPartidaAnterior inexistente. 
 **/
public int reInicializaJogo (String[] nomesParticipantes, int codPartidaAnterior) throws ArgumentoInvalidoException;

//Comandos do Jogo:

/**
 * Este m�todo distribui numCartas para cada um dos Jogadores. 
 * Lanca uma excecao se o numero de participantes for maior que tamBaralho / num_cartas.
 **/ 
public void distribuiCartas (int numCartas) throws NumInsuficienteException;

/****
 * @return retorna o codigo do proximo Jogador, o codigo corresponde ao indice no array
 * que armazenou o nome dos jogadores.
 * 
 */
public int getProxJogador();


/**
 * @param idJogadorCorrente (0 <= idJogadorCorrente < numJogadores )
 * @param numcarta(0<= cartas <= 9)
 * @param cor pertence ao conjunto {VEMELHO, VERDE, AMARELO, AZUL}
 * @return retorna true se a carta foi aceita segundo a regras do jogo e false caso contrario.
 */
public boolean jogadorBaixaCartaNumerica (int idJogadorCorrente, int cor, int numCarta, boolean disseUno ) throws ArgumentoInvalidoException;

/**
 * @param idJogadorCorrente ( 0 <= idJogadorCorrente < numJogadores )
 * @param carta pertence ao conjunto PASSAVEZ, INVERTE, PESCA2
 * @param cor pertence ao conjunto VEMELHO, VERDE, AMARELO, AZUL
 * @return retorna true se a carta foi aceita segundo a regras do jogo e false caso contrario.
 */
public boolean jogadorBaixaCartaEspecial1Cor (int idJogadorCorrente, int cor, int cartaEspecial, boolean disseUno) throws ArgumentoInvalidoException;

/**
 * @param idJogadorCorrente ( 0 <= idJogadorCorrente < numJogadores )
 * @param carta pertence ao conjunto CORINGA, e CORINGAPESCA4
 * @param cor pertence ao conjunto VEMELHO, VERDE, AMARELO, AZUL
 * @param corEscolhida pertence ao conjunto VEMELHO, VERDE, AMARELO, AZUL - como esta carta eh coringa
 *         o usuario podera escolher a nova cor do topo.
 * @return retorna true se a carta foi aceita segundo a regras do jogo e false caso contrario.
 */
public boolean jogadorBaixaCartaEspecialMultiCor (int idJogadorCorrente, int cartaEspecial, int cor, int corEscolhida, boolean disseUno) throws ArgumentoInvalidoException;


/***
 * 
 * @param idJogador
 * @return as cartas que o jogador possui.
 */
public Carta[] getCartasPorJogador(int idJogador);

/**
 * 
 * @return retorna a carta que esta no topo da mesa e cuja cor deve ser obedecida pelo proximo jogador.
 */
public Carta getCartaTopoMesa();

/***
 * 
 * @return retorna o numero de cartas que ainda podem ser compradas
 */
public int getTamBaralhoRestante();

/***
 *  @return retorna o nome do jogador que concluiu primeiro
 */
public String getVencedor ();

public void pausaJogo();


}
