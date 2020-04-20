package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.Obi;
import core.ParametroInconsistenteException;

/**
 * Esta classe é responsável pelos testes de Classe de Equivalência
 * 
 * 
 * 
 */
public class ObiTestCE {

	@Test(expected = ParametroInconsistenteException.class)
	public void testeFalhaPontuacaoMin1()
			throws ParametroInconsistenteException {

		int notas[][] = new int[2][2];
		notas[0][0] = 999;
		notas[0][1] = 2;

		Obi o = new Obi();
		o.verificaPremioCurso(2, -1, notas);

	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testeFalhaPontuacaoMin2()
			throws ParametroInconsistenteException {

		int notas[][] = new int[2][2];
		notas[0][0] = -1;
		notas[0][1] = -1;

		Obi o = new Obi();
		o.verificaPremioCurso(2, 1001, notas);

	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testeFalhaNumCompetidores1()
			throws ParametroInconsistenteException {

		int notas[][] = new int[1001][2];

		Obi o = new Obi();
		o.verificaPremioCurso(1001, 2, notas);
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testeFalhaNumCompetidores2()
			throws ParametroInconsistenteException {

		int notas[][] = new int[2][2];

		Obi o = new Obi();
		o.verificaPremioCurso(-10, 2, notas);

	}

	@Test
	public void testeSucessoNota1() throws ParametroInconsistenteException {
		int notas[][] = new int[2][2];
		notas[0][0] = 200;
		notas[0][1] = 235;

		notas[1][0] = 230;
		notas[1][1] = 235;

		Obi o = new Obi();
		Boolean expecteds[] = { true, true };

		assertTrue(java.util.Arrays.equals(expecteds,
				o.verificaPremioCurso(2, 235, notas)));

	}

	@Test
	public void testeSucessoNota2() throws ParametroInconsistenteException {
		int notas[][] = new int[3][2];
		notas[0][0] = 10;
		notas[0][1] = 235;

		notas[1][0] = 200;
		notas[1][1] = 199;

		notas[2][0] = 2;
		notas[2][1] = 35;

		Obi o = new Obi();
		Boolean expecteds[] = { false, false, false };

		assertTrue(java.util.Arrays.equals(expecteds,
				o.verificaPremioCurso(3, 400, notas)));

	}

	@Test
	public void testeSucessoNota3() throws ParametroInconsistenteException {
		int notas[][] = new int[3][2];

		notas[0][0] = 300;
		notas[0][1] = 250;

		notas[1][0] = 230;
		notas[1][1] = 235;

		notas[2][0] = 350;
		notas[2][1] = 150;

		Obi o = new Obi();
		Boolean expecteds[] = { true, false, true };

		assertTrue(java.util.Arrays.equals(expecteds,
				o.verificaPremioCurso(3, 500, notas)));

	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testArrayNull() throws ParametroInconsistenteException {
		int notas[][] = null;

		Obi o = new Obi();
		Boolean expecteds[] = { true, false, true };

		assertTrue(java.util.Arrays.equals(expecteds,
				o.verificaPremioCurso(3, 500, notas)));
	}

}
