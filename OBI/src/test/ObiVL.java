package test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import core.Obi;
import core.ParametroInconsistenteException;

/**
 * Os primeiros 8 testes são testes similares aos da classe de equivalência.
 * Contudo, são utilizados somente valores limites. Veja a tabela (em formato
 * .ods ) que está junto ao projeto.
 * 
 * Os demais projetos testam cada variável isoladamente, verificando os limites
 * das mesmas.
 * 
 * As variáveis verificadas a partir da segunda parte são: número de
 * participantes, array de notas, pontuação mínima.
 * 
 * 
 * 
 * 
 */
public class ObiVL {

	/**
	 * Tests: l1,l9,l16,l22
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test1() throws ParametroInconsistenteException {

		int numCompetidores = 0;
		int pontuacaoMinima = 1;
		int[][] arrayNotas = { { 0, 0 } };

		Obi obi = new Obi();

		assertTrue(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);
	}

	/**
	 * l2,l8,l17,l23,
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test2() throws ParametroInconsistenteException {

		int numCompetidores = 1;
		int pontuacaoMinima = 0;
		int[][] arrayNotas = { { -1, -1 } };

		Obi obi = new Obi();

		assertTrue(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);

	}

	/**
	 * l3,l10,l15,l24
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test3() throws ParametroInconsistenteException {

		int numCompetidores = 2;
		int pontuacaoMinima = 0;
		int[][] arrayNotas = { { 1, 1 } };

		Obi obi = new Obi();

		assertTrue(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);

	}

	/**
	 * l4,l11,l18,l25
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test
	public void test4() throws ParametroInconsistenteException {

		int numCompetidores = 500;
		int pontuacaoMinima = 500;
		int[][] arrayNotas = new int[numCompetidores][2];
		for (int i = 0; i < numCompetidores; i++) {
			arrayNotas[i][0] = 200;
			arrayNotas[i][1] = 200;
		}

		Obi obi = new Obi();

		assertFalse(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);

	}

	/**
	 * l5,l12,l19,l26
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test
	public void test5() throws ParametroInconsistenteException {

		int numCompetidores = 999;
		int pontuacaoMinima = 999;
		int[][] arrayNotas = new int[numCompetidores][2];
		for (int i = 0; i < numCompetidores; i++) {
			arrayNotas[i][0] = 399;
			arrayNotas[i][1] = 399;
		}

		Obi obi = new Obi();

		assertFalse(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);

	}

	/**
	 * l6,l14,l20,l22
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test6() throws ParametroInconsistenteException {

		int numCompetidores = 1000;
		int pontuacaoMinima = 1000;
		int[][] arrayNotas = new int[numCompetidores][2];
		for (int i = 0; i < numCompetidores; i++) {
			arrayNotas[i][0] = 401;
			arrayNotas[i][1] = 401;
		}

		Obi obi = new Obi();

		assertFalse(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);

	}

	/**
	 * l7,l13,15,l23
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test7() throws ParametroInconsistenteException {

		int numCompetidores = 1001;
		int pontuacaoMinima = 1;
		int[][] arrayNotas = { { 400, 400 } };

		Obi obi = new Obi();

		assertTrue(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);
	}

	/**
	 * l2,l9,l21,l22
	 * 
	 * @throws ParametroInconsistenteException
	 */
	@Test(expected = ParametroInconsistenteException.class)
	public void test8() throws ParametroInconsistenteException {

		int numCompetidores = 1;
		int pontuacaoMinima = 1001;
		int[][] arrayNotas = { { 0, 0 } };

		Obi obi = new Obi();

		assertTrue(obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0]);
	}

	public void testNumeroParticipantes(int numCompetidores)
			throws ParametroInconsistenteException {

		Obi obi = new Obi();
		int pontuacaoMinima = 1;
		int[][] arrayNotas = new int[numCompetidores][2];
		for (int i = 0; i < arrayNotas.length; i++) {
			arrayNotas[i][0] = 1;
			arrayNotas[i][1] = 1;
		}

		Boolean[] result = new Boolean[numCompetidores];
		for (int i = 0; i < result.length; i++) {
			result[i] = true;
		}

		assertArrayEquals(result, obi.verificaPremioCurso(numCompetidores,
				pontuacaoMinima, arrayNotas));
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testNP1() throws ParametroInconsistenteException {
		testNumeroParticipantes(0);
	}

	@Test
	public void testNP2() throws ParametroInconsistenteException {
		testNumeroParticipantes(1);
	}

	@Test
	public void testNP3() throws ParametroInconsistenteException {
		testNumeroParticipantes(2);
	}

	@Test
	public void testNP4() throws ParametroInconsistenteException {
		testNumeroParticipantes(500);
	}

	@Test
	public void testNP5() throws ParametroInconsistenteException {
		testNumeroParticipantes(999);
	}

	@Test
	public void testNP6() throws ParametroInconsistenteException {
		testNumeroParticipantes(1000);
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testNP7() throws ParametroInconsistenteException {
		testNumeroParticipantes(1001);
	}

	public void testPontuacaoMinima(int pontuacaoMinima)
			throws ParametroInconsistenteException {
		Obi obi = new Obi();

		int numCompetidores = 1;
		int[][] arrayNotas = { { 200, 200 } };

		obi.verificaPremioCurso(numCompetidores, pontuacaoMinima, arrayNotas);
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testPM1() throws ParametroInconsistenteException {
		testPontuacaoMinima(0);
	}

	@Test
	public void testPM2() throws ParametroInconsistenteException {
		testPontuacaoMinima(1);
	}

	@Test
	public void testPM3() throws ParametroInconsistenteException {
		testPontuacaoMinima(2);
	}

	@Test
	public void testPM4() throws ParametroInconsistenteException {
		testPontuacaoMinima(500);
	}

	@Test
	public void testPM5() throws ParametroInconsistenteException {
		testPontuacaoMinima(999);
	}

	@Test
	public void testPM6() throws ParametroInconsistenteException {
		testPontuacaoMinima(1000);
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testPM7() throws ParametroInconsistenteException {
		testPontuacaoMinima(1001);
	}

	public boolean testArrayLimites(int[][] arrayNotas)
			throws ParametroInconsistenteException {

		int numCompetidores = 1;
		int pontuacaoMinima = 1;

		Obi obi = new Obi();

		return obi.verificaPremioCurso(numCompetidores, pontuacaoMinima,
				arrayNotas)[0];

	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testAL1() throws ParametroInconsistenteException {
		int[][] array = { { -1, 0 } };
		assertTrue(testArrayLimites(array));
	}

	@Test
	public void testAL2() throws ParametroInconsistenteException {
		int[][] array = { { 0, 0 } };
		assertFalse(testArrayLimites(array));
	}

	@Test
	public void testAL3() throws ParametroInconsistenteException {
		int[][] array = { { 1, 0 } };
		assertTrue(testArrayLimites(array));
	}

	@Test
	public void testAL4() throws ParametroInconsistenteException {
		int[][] array = { { 200, 0 } };
		assertTrue(testArrayLimites(array));
	}

	@Test
	public void testAL5() throws ParametroInconsistenteException {
		int[][] array = { { 399, 0 } };
		assertTrue(testArrayLimites(array));
	}

	@Test
	public void testAL6() throws ParametroInconsistenteException {
		int[][] array = { { 400, 0 } };
		assertTrue(testArrayLimites(array));
	}

	@Test(expected = ParametroInconsistenteException.class)
	public void testAL7() throws ParametroInconsistenteException {
		int[][] array = { { 401, 0 } };
		assertTrue(testArrayLimites(array));
	}
}
