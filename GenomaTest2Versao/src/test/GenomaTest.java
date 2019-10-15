package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import principal.CaractereIncorretoException;
import principal.Genoma;
import principal.RangeException;

public class GenomaTest {

	Genoma g;
	Genoma d;
	
//Casos de Testes atendendo ao Criterio de Analise do Valor Limite
	
	@Test (expected=RangeException.class)	
	public void testCaseghMin1() throws RangeException
	{
		d = new Genoma(0,4);
	}
	
	@Test (expected=RangeException.class)	
	public void testCaseghMin2() throws RangeException
	{
		d = new Genoma(15001,4);
	}
	
	@Test (expected=RangeException.class)	
	public void testCaseghNin1() throws RangeException
	{
		d = new Genoma(2,0);
	}
	
	@Test (expected=RangeException.class)	
	public void testCaseghNin2() throws RangeException
	{
		d = new Genoma(2,15001);
	}
	@Test
	public void testCaseghMvar1EghNvar1() throws RangeException
	{
		d = new Genoma(1, 1);
		d = new Genoma(2, 2);
		d = new Genoma(14999, 14999);
		d = new Genoma(15000, 15000);
		d = new Genoma(1,4);
	}
	
	@Test
	public void testCaseghPTvar1() throws RangeException, CaractereIncorretoException
	{
		d = new Genoma(1,4);
		char[] p = {'A'};
		char[] t = {'A','A','A','A'};
		
		d.setCadeias(p, t);		
		
		int[] result = d.checarOcorrenciasPemT();
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
		assertEquals(3, result[2]);
		assertEquals(4, result[3]);
		
		int[] resultInverse = d.checarOcorrenciasPemT_Invertida();
		assertEquals(0,resultInverse.length);
	}
	
	@Test
	public void testCaseghPTvar2() throws RangeException, CaractereIncorretoException
	{
		d = new Genoma(1,4);
		char[] p = {'T'};
		char[] t = {'A','A','A','A'};
		
		d.setCadeias(p, t);		
		
		int[] result = d.checarOcorrenciasPemT();
		assertEquals(0,result.length);
		
		int[] resultInverse = d.checarOcorrenciasPemT_Invertida();		
		assertEquals(1, resultInverse[0]);
		assertEquals(2, resultInverse[1]);
		assertEquals(3, resultInverse[2]);
		assertEquals(4, resultInverse[3]);
	}
	
	//TestCases antigos, do trabalho anterior, porém com alguns aspectos corrigidos para refletir o uso do Junit 4.0
	
	@Before
	public void setUp() throws Exception {
		d = new Genoma(2,4);
		g = new Genoma(4,25);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenoma() {
		assertEquals(4, g.getpComp());
		assertEquals(25, g.gettComp());
		assertEquals(2, d.getpComp());
		assertEquals(4, d.gettComp());
	}

	@Test
	public void testSetCadeiasSuccess() throws CaractereIncorretoException {
		char[] p = {'C','A','T','A'};
		char[] t = {'T','C','A','T','A','T','G','C','A','A','A','T','A','G','C','T','G','C','A','T','A','C','C','G','A'};
	
		g.setCadeias(p, t);
		assertNotNull(g.getP());
		assertNotNull(g.getT());
		assertEquals(p, g.getP());
		assertEquals(t, g.getT());
		
		char[] p2 = {'A','C'};
		char[] t2 = {'T','G','G','T'};
		
		d.setCadeias(p2, t2);
		
		assertNotNull(g.getP());
		assertNotNull(g.getT());
		assertEquals(p, g.getP());
		assertEquals(t, g.getT());
	}
	
	@Test (expected=CaractereIncorretoException.class)
	public void testSetCadeiasFailureCaractereIncorreto() throws CaractereIncorretoException {
		char[] p = {'C','A','T','A'};
		char[] t = {'T','C','A','T','A','T','G','C','A','A','A','X','A','G','C','T','G','C','A','T','A','C','C','G','A'};
			g.setCadeias(p, t);
	}
	
	@Test (expected=NullPointerException.class)
	public void testSetCadeiasNull() throws CaractereIncorretoException{
		char[] p = null;
		char[] t = null;
		g.setCadeias(p, t);			
	}

	@Test
	public void testSomenteValoresValidosSucess() {
		int[] v1 = {0,0,0,0,0,0,0,0,0,0,0};
		int[] v2 = {2,18,0,0,0,0,0,0,0,0,0};
		int[] v3 = {3,0,0,0,0,0,0,0,0,0,0,0};
		int[] v1f = Genoma.somenteValoresValidos(v1);
		int[] v2f = Genoma.somenteValoresValidos(v2);
		int[] v3f = Genoma.somenteValoresValidos(v3);
		
		assertNotNull(v1f);
		assertNotNull(v2f);
		assertNotNull(v3f);
		assertEquals(0, v1f.length);
		assertEquals(2, v2f.length);
		assertEquals(1, v3f.length);
		for(int i = 0 ; i < v1f.length ; i++){
			assertEquals(v1[i],v1f[i]);
		}
		for(int i = 0 ; i < v2f.length ; i++){
			assertEquals(v2[i],v2f[i]);
		}
		for(int i = 0 ; i < v3f.length ; i++){
			assertEquals(v3[i],v3f[i]);
		}	
	}

	@Test
	public void testChecarOcorrenciasPemT() throws CaractereIncorretoException {
		char[] p = {'C','A','T','A'};
		char[] t = {'T','C','A','T','A','T','G','C','A','A','A','T','A','G','C','T','G','C','A','T','A','C','C','G','A'};
		g.setCadeias(p, t);
		int[] result = g.checarOcorrenciasPemT();
		assertNotNull(result);
		assertEquals(2,result.length);
		assertEquals(2,result[0]);
		assertEquals(18,result[1]);
		
		char[] p2 = {'A','C'};
		char[] t2 = {'T','G','G','T'};

		d.setCadeias(p2, t2);
		result = d.checarOcorrenciasPemT();
		assertNotNull(result);
		assertEquals(0,result.length);
	}
	
	@Test 
	public void testChecarOcorrenciasPemT_Invertida() throws CaractereIncorretoException {
		char[] p = {'C','A','T','A'};
		char[] t = {'T','C','A','T','A','T','G','C','A','A','A','T','A','G','C','T','G','C','A','T','A','C','C','G','A'};
		g.setCadeias(p, t);
		System.out.println("imprimindo o falling teste");
		int[] result = g.checarOcorrenciasPemT_Invertida();
		assertNotNull(result);
		assertEquals(1,result.length);
		assertEquals(4,result[0]);		
		
		char[] p2 = {'A','C'};
		char[] t2 = {'T','G','G','T'};
		d.setCadeias(p2, t2);
		result = d.checarOcorrenciasPemT_Invertida();
		assertNotNull(result);
		assertEquals(1,result.length);
		assertEquals(3,result[0]);		
	}
	
	
}
