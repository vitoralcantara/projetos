package main;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes para a Interface Fachada Uno. Foi criado uma classe FachadaUno, vazia somente para poder
 * executar os testes.
 * <br/> Foi considerado que o próximo jogador é sempre o jogadorAtual + 1 no
 * vetor de jogadores da classe FachadaUno, ou o jogador na posição 0 se o jogador anterior for qtdJogador-1 (se isto não for respeitado na classe FachadaUno final, haverá muitos erros).
 * <br/>
 * Também foi considerado que um jogo só começa depois de executar os métodos {@link InterfaceFachadaUno#inicializaJogo(String[])} seguido de
 * {@link InterfaceFachadaUno#distribuiCartas(int)}.
 * 
 * 
 * @author Vitor Alcântara de Almeida e Renato Gondim Sarmento
 *
 */
public class InterfaceFachadaUnoTest {
	
	FachadaUno uno;

	/**
	 * Apenas inicializa a variável uno
	 */
	@Before
	public void setUp() {
		uno = new FachadaUno();
	}

	@After
	public void tearDown() {
	}

	/**
	 * Verifica se o objeto da classe uno retorna uma excessão caso sejam inserido <strong>null<strong> como parâmetro de nomes.
	 * @throws ArgumentoInvalidoException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testInicializaJogoFail1() throws ArgumentoInvalidoException {
		uno.inicializaJogo(null);
	}
	
	/**
	 * Verifica se o objeto da classe uno inicializa o jogo com sucessso.
	 * @throws ArgumentoInvalidoException
	 */
	public void testInicializaJogoSucesso() throws ArgumentoInvalidoException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);		
	}
	
	/**
	 * Verifica se o objeto da classe uno retorna uma excessão caso seja inserido como parâmetro mais de 30 jogadores.
	 * @throws ArgumentoInvalidoException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testInicializaJogoFail2() throws ArgumentoInvalidoException {
		String[] name = {"1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2"};
		uno.inicializaJogo(name);		
	}
	
	/**
	 * Verifica se o objeto da classe uno retorna uma excessão caso seja inserido <strong>null<strong> como parâmetro de nomes.
	 * @throws ArgumentoInvalidoException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testReInicializaJogoFail1() throws ArgumentoInvalidoException {
		String[] name = {"maria","pedro"};
		int z = uno.inicializaJogo(name);
		uno.pausaJogo();
		uno.reInicializaJogo(null, z);		
	}
	
	/**
	 *  Verifica se o objeto da classe uno retorna uma excessão caso seja inserido como parâmetro mais de 30 jogadores.
	 * @throws ArgumentoInvalidoException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testReInicializaJogoFail2() throws ArgumentoInvalidoException {
		String[] n = {"casa","pedro"};
		int z = uno.inicializaJogo(n);
		uno.pausaJogo();
		String[] name = {"1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","pedro"};	
		uno.reInicializaJogo(name, z);		
	}	

	/**
	 * Verifica se o objeto da classe uno retorna uma excessão caso o jogo seja reinicializado com um código de partida anterior inexistente.
	 * @throws ArgumentoInvalidoException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testReInicializaJogoFail3() throws ArgumentoInvalidoException {
		String[] name = {"casa"};
		uno.reInicializaJogo(name, -1);		
	}
	
	/**
	 * Verifica se um jogo é reinicializado com sucesso
	 * @throws ArgumentoInvalidoException
	 */
	public void testReInicializaJogoSucesso() throws ArgumentoInvalidoException {
		String[] name = {"casa","amigo"};
		int z = uno.inicializaJogo(name);
		uno.pausaJogo();
		uno.reInicializaJogo(name, z);		
	}	

	/**
	 * Teste dos valores limites: Sendo 108 cartas e 4 jogadores, respeitando a regra de que o número de jogadores
	 * não pode ser maior que tamanho do baralho / cartas. Então 108 / 27 = 4. Testando com 4 jogadores,
	 * temos 3 casos limite: 26(sucesso, menor que 4),27(exatamente 4) e 28(falha: maior que 4).
	 * Este é o caso com 26
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testDistribuiCartasSucessoLimite1() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","lego","roberta"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(26);
	}
	
	/**
	 * Ver explicação do método {@link #testDistribuiCartasSucessoLimite1()}.
	 * Este é o caso com 27
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testDistribuiCartasSucessoLimite2() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","lego","roberta"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(27);
	}
	
	/**
	 * Ver explicação do método {@link #testDistribuiCartasSucessoLimite1()}.
	 * Este é o caso com 28
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=NumInsuficienteException.class)
	public void testDistribuiCartasFailLimite3() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","lego","roberta"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(28);
	}

	/**
	 * Caso de teste Pair-Wise da função {@link InterfaceFachadaUno#jogadorBaixaCartaNumerica(int, int, int, boolean)}. Parâmetros usados:
	 * <ul>
	 *	<li>Quantidade de Jogadores: 2</li>
	 *	<li>Cor: 4</li>
	 *	<li>Numero da Carta: 10</li>
	 *	<li>Disse Uno: 2</li>
	 *	</ul>
	 *  O casos de testes gerados estão em
	 *  <a href="testJogadorBaixaCartaNumericaSucessPairWise.pdf">PairWiseNumerica</a>.
	 *  Eles foram gerados usando a ferramenta TConfig.
	 * 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testJogadorBaixaCartaNumericaPairWise() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);				
		compareCartasNumericas(1, 1, 0, false);
		compareCartasNumericas(2, 2, 1, true);
		compareCartasNumericas(1, 3, 2, false);
		
		//TODO Terminar de Fazer o Pair-Wise dos que est�o abaixo
		/*compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);

		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);
		compareCartasNumericas(1, 1, 13, false);*/
		
	}
	
	/**
	 * Este método foi criado para facilitar e agilizar testes pairWise da função {@link #testJogadorBaixaCartaNumericaPairWise()}.
	 * Os parâmetros desta função são as mesmas que seriam utilizados no método acima da classe {@link InterfaceFachadaUno#jogadorBaixaCartaNumerica(int, int, int, boolean)}.
	 * @param idJogadorCorrente
	 * @param cor
	 * @param numCarta
	 * @param disseUno
	 * @throws ArgumentoInvalidoException
	 */
	private void compareCartasNumericas(int idJogadorCorrente, int cor, int numCarta, boolean disseUno) throws ArgumentoInvalidoException
	{
		Carta carta = uno.getCartaTopoMesa();
		if(carta.getCor() == cor)
		{
			Carta[] cartas = uno.getCartasPorJogador(uno.getProxJogador());
			if(cartas.length == 2)
			{
				if(disseUno)
				{
					assertEquals(true,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
				else
				{
					assertEquals(false,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
			}
			else
			{
				if(disseUno)
				{
					assertEquals(false,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
				else
				{
					assertEquals(true,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
			}
		}
		else if(carta.getTipo_ou_Num() == numCarta)
		{
			Carta[] cartas = uno.getCartasPorJogador(uno.getProxJogador());
			if(cartas.length == 2)
			{
				if(disseUno)
				{
					assertEquals(true,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
				else
				{
					assertEquals(false,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
			}
			else
			{
				if(disseUno)
				{
					assertEquals(false,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
				else
				{
					assertEquals(true,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
				}
			}
		}
		else
		{
			assertEquals(false,uno.jogadorBaixaCartaNumerica(idJogadorCorrente, cor, numCarta, disseUno));
		}		
	}
	
	/**
	 * Este método foi criado para facilitar e agilizar testes pairWise da função {@link #testJogadorBaixaCartaEspecial1CorPairWise()}.
	 * Os parâmetros desta função são as mesmas que seriam utilizados no método acima da classe {@link InterfaceFachadaUno#jogadorBaixaCartaEspecial1Cor(int, int, int, boolean)}.
	 * <ul>
	 * 	<li>(VER1): Esta função também verifica se, caso a carta seja um {@link InterfaceFachadaUno#INVERTE},
	 * o próximo jogador é o mesmo que o anterior (houve inversão)</li>
	 * <li> (VER2): Esta função também verifica se, caso a carta seja um {@link InterfaceFachadaUno#PASSAVEZ},
	 * o próximo jogador é um jogador a frente do que normalmente seria.</li>
	 * <li> (VER3): Esta função também verifica se, caso a carta seja um {@link InterfaceFachadaUno#PESCA2},
	 * o jogador que seria o próximo a jogar terá duas cartas a mais que antes.</li>
	 * </lu>
	 * 
	 * @param idJogadorCorrente
	 * @param cor
	 * @param cartaEspecial
	 * @param disseUno
	 * @throws ArgumentoInvalidoException
	 */
	private void compareCartasEspeciais1Cor(int qtdJogadores,int idJogadorCorrente, int cor, int cartaEspecial, boolean disseUno) throws ArgumentoInvalidoException
	{
		Carta carta = uno.getCartaTopoMesa();
		
		int jogador = uno.getProxJogador();
		
		int nextJogador = (uno.getProxJogador() + 1) % qtdJogadores;
		int nextJogadorCartas = uno.getCartasPorJogador(nextJogador).length;
		
		if(carta.getCor() == cor)
		{
			Carta[] cartas = uno.getCartasPorJogador(uno.getProxJogador());
			if(cartas.length == 2)
			{
				if(disseUno)
				{
					assertEquals(true,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
					/**
					 * (VER1)
					 */
					if(cartaEspecial == InterfaceFachadaUno.INVERTE)
					{
						assertEquals(jogador, uno.getProxJogador());
					}
					/**
					 * (VER2)
					 */
					else if(cartaEspecial == InterfaceFachadaUno.PASSAVEZ)
					{
						if(jogador == qtdJogadores - 1)
						{
							assertEquals(1,uno.getProxJogador());
						}
						else if(jogador == qtdJogadores - 2)
						{
							assertEquals(0,uno.getProxJogador());
						}
						else
						{
							assertEquals(jogador+2,uno.getProxJogador());
						}
					}
					/**
					 * (VER3)
					 */
					else if(cartaEspecial == InterfaceFachadaUno.PESCA2)
					{
						assertEquals(nextJogadorCartas, uno.getCartasPorJogador(nextJogador).length);
					}
				}
				else
				{
					assertEquals(false,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
			}
			else
			{
				if(disseUno)
				{
					assertEquals(false,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
				else
				{
					assertEquals(true,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
					/**
					 * (VER1)
					 */
					if(cartaEspecial == InterfaceFachadaUno.INVERTE)
					{
						assertEquals(jogador, uno.getProxJogador());
					}
					/**
					 * (VER2)
					 */
					else if(cartaEspecial == InterfaceFachadaUno.PASSAVEZ)
					{
						if(jogador == qtdJogadores - 1)
						{
							assertEquals(1,uno.getProxJogador());
						}
						else if(jogador == qtdJogadores - 2)
						{
							assertEquals(0,uno.getProxJogador());
						}
						else
						{
							assertEquals(jogador+2,uno.getProxJogador());
						}
					}
					/**
					 * (VER3)
					 */
					else if(cartaEspecial == InterfaceFachadaUno.PESCA2)
					{
						assertEquals(nextJogadorCartas, uno.getCartasPorJogador(nextJogador).length);
					}
				}
			}
		}
		else if(carta.getTipo_ou_Num() == cartaEspecial)
		{
			Carta[] cartas = uno.getCartasPorJogador(uno.getProxJogador());
			if(cartas.length == 2)
			{
				if(disseUno)
				{
					assertEquals(true,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
				/**
				 * (VER1)
				 */
				if(cartaEspecial == InterfaceFachadaUno.INVERTE)
				{
					assertEquals(jogador, uno.getProxJogador());
				}
				/**
				 * (VER2)
				 */
				else if(cartaEspecial == InterfaceFachadaUno.PASSAVEZ)
				{
					if(jogador == qtdJogadores - 1)
					{
						assertEquals(1,uno.getProxJogador());
					}
					else if(jogador == qtdJogadores - 2)
					{
						assertEquals(0,uno.getProxJogador());
					}
					else
					{
						assertEquals(jogador+2,uno.getProxJogador());
					}
				}
				/**
				 * (VER3)
				 */
				else if(cartaEspecial == InterfaceFachadaUno.PESCA2)
				{
					assertEquals(nextJogadorCartas, uno.getCartasPorJogador(nextJogador).length);
				}
				else
				{
					assertEquals(false,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
			}
			else
			{
				if(disseUno)
				{
					assertEquals(false,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
				else
				{
					assertEquals(true,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
				}
				/**
				 * (VER1)
				 */
				if(cartaEspecial == InterfaceFachadaUno.INVERTE)
				{
					assertEquals(jogador, uno.getProxJogador());
				}
				/**
				 * (VER2)
				 */
				else if(cartaEspecial == InterfaceFachadaUno.PASSAVEZ)
				{
					if(jogador == qtdJogadores - 1)
					{
						assertEquals(1,uno.getProxJogador());
					}
					else if(jogador == qtdJogadores - 2)
					{
						assertEquals(0,uno.getProxJogador());
					}
					else
					{
						assertEquals(jogador+2,uno.getProxJogador());
					}
				}
				/**
				 * (VER3)
				 */
				else if(cartaEspecial == InterfaceFachadaUno.PESCA2)
				{
					assertEquals(nextJogadorCartas, uno.getCartasPorJogador(nextJogador).length);
				}
			}
		}
		else
		{
			assertEquals(false,uno.jogadorBaixaCartaEspecial1Cor(idJogadorCorrente,cor,cartaEspecial,disseUno));
		}		
	}
	
	/**
	 * Este método foi criado para facilitar e agilizar testes pairWise da função {@link #testJogadorBaixaCartaEspecialMultiCorPairWise()}.
	 * Os parâmetros desta função são as mesmas que seriam utilizadas nos método acima da classe {@link InterfaceFachadaUno#jogadorBaixaCartaEspecialMultiCor(int, int, int, int, boolean)}.
	 * <br>
	 * (VER1)Este método também verifica se, caso a carta jogada for {@link InterfaceFachadaUno#CORINGAPESCA4},
	 * o próximo jogador terá 4 cartas a mais que antes.
	 * @param idJogadorCorrente
	 * @param cartaEspecial
	 * @param cor
	 * @param corEscolhida
	 * @param disseUno
	 * @throws ArgumentoInvalidoException
	 */
	private void compareCartasEspeciaisMultiCor(int qtdJogador, int idJogadorCorrente, int cartaEspecial, int cor, int corEscolhida, boolean disseUno) throws ArgumentoInvalidoException
	{
		
		int numCartas = uno.getCartasPorJogador(uno.getProxJogador()).length;
		
		int nextJogador = (uno.getProxJogador() + 1) % qtdJogador;
		int qtdCartasJogador = uno.getCartasPorJogador(nextJogador).length;
		
		if(numCartas == 2)
		{
			if(disseUno)
			{
				assertEquals(true,uno.jogadorBaixaCartaEspecialMultiCor(idJogadorCorrente, cartaEspecial, cor, corEscolhida, disseUno));
				/**
				 * (VER1)
				 */
				if(cartaEspecial == InterfaceFachadaUno.CORINGAPESCA4)
				{
					assertEquals(qtdCartasJogador+4,uno.getCartasPorJogador(nextJogador).length);
				}
			}
			else
			{
				assertEquals(false,uno.jogadorBaixaCartaEspecialMultiCor(idJogadorCorrente, cartaEspecial, cor, corEscolhida, disseUno));
			}
		}
	}
	
	/**
	 * Caso de teste Pair-Wise da função {@link InterfaceFachadaUno#jogadorBaixaCartaEspecial1Cor(int, int, int, boolean)}. 
	 * Parâmetros usados:
	 * <ul>
	 *	<li>Quantidade de Jogadores: 2</li>
	 *	<li>Cor: 4</li>
	 *	<li>Cartas Especiais: 3</li>
	 *	<li>Disse Uno: 2</li>
	 *	</ul>
	 *  O casos de testes gerados estão em
	 *  <a href="testJogadorBaixaCartaEspecial1CorSucessPairWise.pdf">PairWise1Cor</a>.
	 *  Eles foram gerados usando a ferramenta TConfig. 
	 * 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testJogadorBaixaCartaEspecial1CorPairWise() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		
		compareCartasEspeciais1Cor(2,1, 1, 13, false);
		compareCartasEspeciais1Cor(2,1, 2, 14, true);	
		compareCartasEspeciais1Cor(2,1, 3, 15, false);
		compareCartasEspeciais1Cor(2,2, 1, 14, false);
		compareCartasEspeciais1Cor(2,2, 2, 15, false);
		compareCartasEspeciais1Cor(2,2, 3, 13, true);
		compareCartasEspeciais1Cor(2,1, 1, 15, true);
		compareCartasEspeciais1Cor(2,1, 2, 13, false);
		compareCartasEspeciais1Cor(2,1, 3, 14, false);
		compareCartasEspeciais1Cor(2,1, 4, 13, false);
		compareCartasEspeciais1Cor(2,2, 4, 14, true);
		compareCartasEspeciais1Cor(2,1, 4, 15, false);
	}
		
	/**
	 * Caso de teste por valores limites de número de carta. Esses valores são:
	 * <lu>
	 * 		<li>Limite inferior: -1,0,1</li>
	 * 		<li>Limite Superior: 8,9,10</li>
	 * </lu>
	 * 
	 * Este método verifica para -1.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaNumericaFailLimiteInferiorNumeroCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaNumerica(0, 1, -1, false);		
	}
	
	/**
	 * Este método verifica para 10. Ver {@link #testJogadorBaixaCartaNumericaFailLimiteInferiorCorCarta()}.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaNumericaFailLimiteSuperiorNumeroCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaNumerica(0, 1, 10, false);		
	}
	
	/**
	 * Caso de teste por valores limites de cor de carta. Esses valores são:
	 * <lu>
	 * 		<li>Limite inferior: 0,1,2</li>
	 * 		<li>Limite Superior: 3,4,5</li>
	 * </lu>
	 * 
	 * Este método verifica para 0.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaNumericaFailLimiteInferiorCorCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaNumerica(1, 0,6, false);		
	}
	
	/**
	 * Este método verifica para 5. Ver {@link #testJogadorBaixaCartaNumericaFailLimiteSuperiorCorCarta()}.
	 * Apesar de 5 ser {@link InterfaceFachadaUno#MULTICOLORIDA}, ela é inválida para carta numérica.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaNumericaFailLimiteSuperiorCorCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaNumerica(1, 5, 7, false);		
	}
	
	/**
	 * Casos de Sucesso dos testes de valor limite. Ver {@link #testJogadorBaixaCartaNumericaFailLimiteSuperiorCorCarta()}
	 * e {@link #testJogadorBaixaCartaNumericaFailLimiteInferiorCorCarta()}.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	public void testJogadorBaixaCartaNumericaCorEnumeroSucess() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo","legal"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaNumerica(0, 1, 0, false);
		uno.jogadorBaixaCartaNumerica(1, 2, 1, false);
		uno.jogadorBaixaCartaNumerica(2, 3, 8, false);
		uno.jogadorBaixaCartaNumerica(0, 4, 9, false);
	}
	
	/**
	 * Caso de teste por valores limites de tipo de carta. Esses valores são:
	 * <lu>
	 * 		<li>Limite inferior: 12,13,14</li>
	 * 		<li>Limite Superior: 14,15,16</li>
	 * </lu>
	 * 
	 * Este método verifica para 12.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecial1CorFailLimiteInferiorTipoCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecial1Cor(1, 1, 12, false);		
	}
	
	/**
	 * Este método verifica para 16. Ver {@link #testJogadorBaixaCartaEspecial1CorFailLimiteInferiorTipoCarta()}.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecial1CorFailLimiteSuperiorTipoCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecial1Cor(1, 2, 16, false);		
	}
	
	/**
	 * Caso de teste por valores limites de cor de carta. Esses valores são:
	 * <lu>
	 * 		<li>Limite inferior: 0,1,2</li>
	 * 		<li>Limite Superior: 3,4,5</li>
	 * </lu>
	 * 
	 * Este método verifica para 0.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecial1CorFailLimiteInferiorCorCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecial1Cor(1, 0, InterfaceFachadaUno.PASSAVEZ, false);		
	}
	
	/**
	 * Este método verifica cor carta 5. 5 representa {@link InterfaceFachadaUno#MULTICOLORIDA},
	 * mas ainda assim é uma cor inválida para este caso.
	 * Ver {@link #testJogadorBaixaCartaEspecial1CorFailLimiteInferiorCorCarta()}
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecial1CorFailLimiteSuperiorCorCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecial1Cor(1, 5, InterfaceFachadaUno.PASSAVEZ, false);		
	}
	
	/**
	 * Verifica entradas de sucesso para os valores limites mostrados em {@link #testJogadorBaixaCartaEspecial1CorFailLimiteInferiorCorCarta()}
	 * e {@link #testJogadorBaixaCartaEspecial1CorFailLimiteInferiorTipoCarta()}
	 * 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	public void testJogadorBaixaCartaEspecial1CorETipoSucess() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo","legal"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecial1Cor(0, 1, InterfaceFachadaUno.PASSAVEZ, false);
		uno.jogadorBaixaCartaEspecial1Cor(1, 2, InterfaceFachadaUno.PESCA2, false);
		uno.jogadorBaixaCartaEspecial1Cor(2, 3, InterfaceFachadaUno.INVERTE, false);
		uno.jogadorBaixaCartaEspecial1Cor(0, 4, InterfaceFachadaUno.INVERTE, false);
	}
	
	/**
	 * Caso de teste Pair-Wise da função {@link InterfaceFachadaUno#jogadorBaixaCartaEspecialMultiCor(int, int, int, int, boolean)}. 
	 * Parâmetros usados:
	 * <ul>
	 *	<li>Quantidade de Jogadores: 2</li>
	 *	<li>Cor: 4</li>
	 *	<li>Cartas Especiais: 2</li>
	 *	<li>Disse Uno: 2</li>
	 *	</ul>
	 *  O casos de testes gerados estão em
	 *  <a href="testJogadorBaixaCartaEspecialMultiCorSucessPairWise.pdf">PairWiseMultiCor</a>.
	 *  Eles foram gerados usando a ferramenta TConfig. 
	 * 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testJogadorBaixaCartaEspecialMultiCorPairWise() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		
		compareCartasEspeciaisMultiCor(2,1,16, InterfaceFachadaUno.MULTICOLORIDA, 1, false);
		compareCartasEspeciaisMultiCor(2,1,17, InterfaceFachadaUno.MULTICOLORIDA, 2, false);
		compareCartasEspeciaisMultiCor(2,2,16, InterfaceFachadaUno.MULTICOLORIDA, 2, false);
		compareCartasEspeciaisMultiCor(2,2,17, InterfaceFachadaUno.MULTICOLORIDA, 1, false);
		compareCartasEspeciaisMultiCor(2,2,17, InterfaceFachadaUno.MULTICOLORIDA, 2, true);
		compareCartasEspeciaisMultiCor(2,1,16, InterfaceFachadaUno.MULTICOLORIDA, 1, true);
		compareCartasEspeciaisMultiCor(2,1,16, InterfaceFachadaUno.MULTICOLORIDA, 3, false);
		compareCartasEspeciaisMultiCor(2,2,17, InterfaceFachadaUno.MULTICOLORIDA, 3, true);
		compareCartasEspeciaisMultiCor(2,1,16, InterfaceFachadaUno.MULTICOLORIDA, 4, false);
		compareCartasEspeciaisMultiCor(2,2,17, InterfaceFachadaUno.MULTICOLORIDA, 4, true);		
	}
	
	/**
	 * Caso de teste por valores limites de tipos de carta. Esses valores são:
	 * <lu>
	 * 		<li>Limite inferior: 15,16,17</li>
	 * 		<li>Limite Superior: 16,17,18</li>
	 * </lu>
	 * 
	 * Este m�todo verifica para 15.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailLimiteInferiorTipoCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 15,InterfaceFachadaUno.MULTICOLORIDA, 1, true);		
	}
	
	/**
	 * Este método verifica para 18. Ver {@link #testJogadorBaixaCartaEspecialMultiCorFailLimiteInferiorTipoCarta()}.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailLimiteSuperiorTipoCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 18,InterfaceFachadaUno.MULTICOLORIDA, 1, true);		
	}
	
	/**
	 * Este método verifica os casos de sucesso. Ver {@link #testJogadorBaixaCartaEspecialMultiCorFailLimiteInferiorTipoCarta()}.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testJogadorBaixaCartaEspecialMultiCorSucessoValoresLimitesTipoCarta() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 16,InterfaceFachadaUno.MULTICOLORIDA, 1, true);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 17,InterfaceFachadaUno.MULTICOLORIDA, 1, true);
	}
	
	/**
	 * Este método verifica se o uno joga uma excessão caso a carta seja especial (Coringa ou Coringa + 4)
	 * E a cor de carta inserida não é multicolorida.
	 * Teste com Amarelo.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailCorCarta1() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 16,InterfaceFachadaUno.AMARELO, 1, true);		
	}
	/**
	 * 
	 * Este método verifica se o uno joga uma excessão caso a carta seja especial (Coringa ou Coringa + 4)
	 * E a cor de carta inserida não é multicolorida.
	 * Teste com Verde.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailCorCarta2() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 16,InterfaceFachadaUno.VERDE, 2, true);		
	}
	
	/**
	 * Este método verifica se o uno joga uma excessão caso a carta seja especial (Coringa ou Coringa + 4)
	 * E a cor de carta inserida não é multicolorida.
	 * Teste com Vermelho. 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailCorCarta3() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 16,InterfaceFachadaUno.VERMELHO, 3, true);		
	}
	
	/**
	 * Este método verifica se o uno joga uma excessão caso a carta seja especial (Coringa ou Coringa + 4)
	 * E a cor de carta inserida não é multicolorida.
	 * Teste com Azul.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testJogadorBaixaCartaEspecialMultiCorFailCorCarta4() throws ArgumentoInvalidoException, NumInsuficienteException
	{
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		uno.jogadorBaixaCartaEspecialMultiCor(1, 16,InterfaceFachadaUno.AZUL, 4, true);		
	}
	
	/**
	 * Verifica se, após distribuir as cartas, cada jogador possui a mesma quantidade de cartas.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testGetCartasPorJogador() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		
		for(int i = 0 ; i < 2 ; i++)
		{
			assertEquals(7,uno.getCartasPorJogador(i).length);
		}
	}

	/**
	 * Verifica se a carta no topo da mesa é a mesma que foi anteriormente jogada.
	 * <ul>
	 * <li>Se uma carta c1 jogada for aceita, então a carta no topo da mesa
	 * deve ser c1. Se ela não for aceita porque a carta na mesa difere de c1, então a carta no topo
	 * deve ser diferente de c1. Se ela não for aceita porque o jogador não disse uno, então a carta no topo
	 * da mesa deve ser c1.
	 * </ul>
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testGetCartaTopoMesa() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		
		int numCartas = uno.getCartasPorJogador(uno.getProxJogador()).length;	
		
		if(uno.jogadorBaixaCartaNumerica(1,InterfaceFachadaUno.VERMELHO,0,false))
		{
			assertTrue(uno.getCartaTopoMesa().getCor() == InterfaceFachadaUno.VERMELHO);
			assertTrue(uno.getCartaTopoMesa().getTipo_ou_Num() == 0);
		}
		else
		{
			if(numCartas != 2)
			{
				assertTrue(uno.getCartaTopoMesa().getCor() != InterfaceFachadaUno.VERMELHO);
				assertTrue(uno.getCartaTopoMesa().getTipo_ou_Num() != 0);	
			}
			else
			{
				assertTrue(uno.getCartaTopoMesa().getCor() == InterfaceFachadaUno.VERMELHO);
				assertTrue(uno.getCartaTopoMesa().getTipo_ou_Num() == 0);
			}
			//TODO Explicar como funciona o false...
		}
	}

	/**
	 * Verifica se a função {@link InterfaceFachadaUno#getCartaTopoMesa()} funciona corretamente.
	 * Elas faz um if else, pois o nosso grupo não sabia se seria colocada uma carta na mesa imediatamente 
	 * após chamar a função {@link InterfaceFachadaUno#distribuiCartas(int)} ou quando fosse executada
	 * a primeira função de jogar carta.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testGetTamBaralhoRestante() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","pessoa"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(7);
		if(uno.getCartaTopoMesa() != null)
		{
			assertEquals(86,uno.getTamBaralhoRestante());
		}
		else
		{
			assertEquals(87,uno.getTamBaralhoRestante());
		}
	}

	/**
	 * Verifica se o uno retorna o vencedor corretamente
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testGetVencedorSuccess() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","pessoa"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(1);
		uno.jogadorBaixaCartaEspecialMultiCor(1, InterfaceFachadaUno.CORINGA, InterfaceFachadaUno.MULTICOLORIDA, InterfaceFachadaUno.VERDE,false);
		assertEquals("amigo", uno.getVencedor());
	}
	
	/**
	 * verifica se a função {@link InterfaceFachadaUno#getVencedor()} funciona corretamente.
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test
	public void testGetVencedorNull() throws ArgumentoInvalidoException, NumInsuficienteException {
		String[] name = {"casa","amigo","pessoa"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(1);
		boolean accepted = uno.jogadorBaixaCartaNumerica(1,InterfaceFachadaUno.VERMELHO,0,false);
		if(!accepted)
		{
			assertNull(uno.getVencedor());
		}
		else
		{
			assertEquals("amigo", uno.getVencedor());
		}		
	}

	/**
	 * Verifica se o uno retorna alguma excessão quando executa um método que não seja {@link InterfaceFachadaUno#reInicializaJogo(String[], int)}
	 * quando está pausada.
	 * Nosso grupo definiu que neste caso ele deve retornar um ArgumentoInvalidoException.class.
	 * 
	 * @throws ArgumentoInvalidoException
	 * @throws NumInsuficienteException
	 */
	@Test(expected=ArgumentoInvalidoException.class)
	public void testPausaJogo() throws ArgumentoInvalidoException, NumInsuficienteException {
		//TODO Saber comportamento da Classe quando for pausada
		String[] name = {"casa","amigo","pessoa"};
		uno.inicializaJogo(name);
		uno.distribuiCartas(1);
		uno.pausaJogo();
		uno.jogadorBaixaCartaEspecialMultiCor(0,InterfaceFachadaUno.CORINGA , InterfaceFachadaUno.MULTICOLORIDA , InterfaceFachadaUno.VERMELHO, false);
		
	}

}
