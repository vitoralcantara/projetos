package main;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author Vitor
 *
 */
public class FachadaUno implements InterfaceFachadaUno {

	boolean primeiraPartida = true;
	private String[] participantes;
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	private Partida partidaAtual;
	
	private ArrayList<Carta> gerarCartas()
	{
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		
		for(int i = 1 ; i <= 4 ; i++ )
		{
			for(int j = 1 ; j <= 9 ; j++)
			{
				cartas.add(new Carta(i,j));
				cartas.add(new Carta(i,j));
			}
		}
		cartas.add(new Carta(1,0));
		cartas.add(new Carta(2,0));
		cartas.add(new Carta(3,0));
		cartas.add(new Carta(4,0));
		cartas.add(new Carta(1,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(1,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(2,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(2,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(3,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(3,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(4,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(4,InterfaceFachadaUno.PESCA2));
		cartas.add(new Carta(1,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(1,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(2,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(2,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(3,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(3,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(4,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(4,InterfaceFachadaUno.PASSAVEZ));
		cartas.add(new Carta(1,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(1,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(2,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(2,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(3,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(3,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(4,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(4,InterfaceFachadaUno.INVERTE));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGA));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGA));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGA));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGA));		
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGAPESCA4));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGAPESCA4));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGAPESCA4));
		cartas.add(new Carta(InterfaceFachadaUno.MULTICOLORIDA,InterfaceFachadaUno.CORINGAPESCA4));
		
		return cartas;
}
	
	
	/**
	 * 
	 */
	public FachadaUno() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#inicializaJogo(java.lang.String[])
	 */
	@Override
	public int inicializaJogo(String[] nomesParticipantes)
			throws ArgumentoInvalidoException {
		partidaAtual = new Partida();
		partidaAtual.setCartasNaMesa(gerarCartas());
		partidaAtual.setCodigoPartida(partidas.size());
		return partidas.size();		
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#reInicializaJogo(java.lang.String[], int)
	 */
	@Override
	public int reInicializaJogo(String[] nomesParticipantes,
			int codPartidaAnterior) throws ArgumentoInvalidoException {
		participantes = nomesParticipantes;
		
		this.pausaJogo();
		
		for(int i = 0 ; i < partidas.size() ; i++)
		{
			if(partidas.get(i).getCodigoPartida() == codPartidaAnterior)
			{
				partidaAtual = partidas.remove(i);
			}
		}		
		return codPartidaAnterior;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#distribuiCartas(int)
	 */
	@Override
	public void distribuiCartas(int numCartas) throws NumInsuficienteException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#getProxJogador()
	 */
	@Override
	public int getProxJogador() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#jogadorBaixaCartaNumerica(int, int, int, boolean)
	 */
	@Override
	public boolean jogadorBaixaCartaNumerica(int idJogadorCorrente, int cor,
			int numCarta, boolean disseUno)
			throws ArgumentoInvalidoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#jogadorBaixaCartaEspecial1Cor(int, int, int, boolean)
	 */
	@Override
	public boolean jogadorBaixaCartaEspecial1Cor(int idJogadorCorrente,
			int cor, int cartaEspecial, boolean disseUno)
			throws ArgumentoInvalidoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#jogadorBaixaCartaEspecialMultiCor(int, int, int, int, boolean)
	 */
	@Override
	public boolean jogadorBaixaCartaEspecialMultiCor(int idJogadorCorrente,
			int cartaEspecial, int cor, int corEscolhida, boolean disseUno)
			throws ArgumentoInvalidoException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#getCartasPorJogador(int)
	 */
	@Override
	public Carta[] getCartasPorJogador(int idJogador) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#getCartaTopoMesa()
	 */
	@Override
	public Carta getCartaTopoMesa() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#getTamBaralhoRestante()
	 */
	@Override
	public int getTamBaralhoRestante() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#getVencedor()
	 */
	@Override
	public String getVencedor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see InterfaceFachadaUno#pausaJogo()
	 */
	@Override
	public void pausaJogo() {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
