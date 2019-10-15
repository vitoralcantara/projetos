package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import main.CorridaKart;
import main.NonNumberZeroException;
import main.OrdemNaoCrescenteException;
import main.RangeException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CorridaKartTest {

	CorridaKart c,d;
	
//Casos de Testes atendendo ao Criterio de Analise do Valor Limite
	
	@Test (expected=RangeException.class)
	public void testCase_ckNin1() throws RangeException
	{
		c = new CorridaKart(1,1);
	}
	
	@Test (expected=RangeException.class)
	public void testCase_ckNin2() throws RangeException
	{
		c = new CorridaKart(11111,1);
	}
	
	@Test (expected=RangeException.class)
	public void testCase_ckMin1() throws RangeException
	{
		c = new CorridaKart(2,0);
	}
	
	@Test (expected=RangeException.class)
	public void testCase_ckMin2() throws RangeException
	{
		c = new CorridaKart(2,42196);
	}
	
	@Test(expected=OrdemNaoCrescenteException.class)
	public void testCase_ckPosicao_Iin1() throws RangeException, OrdemNaoCrescenteException, NonNumberZeroException
	{
		c = new CorridaKart(2,1);
		int[] arrayPosicoes = {0,-1};
		
		c.preverTermino(arrayPosicoes);
			fail();
	}
	
	@Test(expected=Exception.class)
	public void testCase_ckPosicao_Iin2() throws RangeException, OrdemNaoCrescenteException, NonNumberZeroException
	{
		c = new CorridaKart(2,1);
		int[] arrayPosicoes = {0,42196};
		
		c.preverTermino(arrayPosicoes);
	}	
	
	@Test
	public void testCase_kNval1_E_ckMval1() throws RangeException
	{
		c = new CorridaKart(2,1);
		c = new CorridaKart(3,2);
		c = new CorridaKart(9999,42194);
		c = new CorridaKart(10000,42195);
	}
	
	@Test
	public void testCase_ckPosicao_Ival1() throws RangeException, OrdemNaoCrescenteException, NonNumberZeroException
	{
		c = new CorridaKart(2,1);
		int[] arrayPosicoes = {0,0};
		char result = c.preverTermino(arrayPosicoes);
		assertEquals('S',result);
		
		arrayPosicoes[0] = 0;
		arrayPosicoes[1] = 1;
		result = c.preverTermino(arrayPosicoes);
		assertEquals('S',result);
		
		arrayPosicoes[0] = 0;
		arrayPosicoes[1] = 42194;
		result = c.preverTermino(arrayPosicoes);
		assertEquals('N',result);
		
		arrayPosicoes[0] = 0;
		arrayPosicoes[1] = 42195;		
		result = c.preverTermino(arrayPosicoes);		
		assertEquals('N',result);		
	}
	
	//TestCases antigos, do trabalho anterior, porém com alguns aspectos corrigidos para refletir o uso do Junit 4.0
	
	@Before
	public void setUp() throws Exception {
		c = new CorridaKart(3, 20000);
		d = new CorridaKart(8,6000);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCorridaKartSuccess() {
		int[] arrayPosicoes = {0,20000,33333};
		assertEquals(3,arrayPosicoes.length);
		
		int[] arrayPosicoes2 = {0,6000,12000,18000,24000,32000,37000,40000};
		assertEquals(8,arrayPosicoes2.length);				
	}
		
	@Test
	public void testPreverTerminoSuccess() throws OrdemNaoCrescenteException, NonNumberZeroException, RangeException {
		int[] arrayPosicoes = {0,20000,33333};
		assertEquals('S', c.preverTermino(arrayPosicoes));
		
		int[] arrayPosicoes2 = {0,6000,12000,18000,24000,32000,37000,40000};
		assertEquals('N',d.preverTermino(arrayPosicoes2));
	}
	
	@Test (expected=NonNumberZeroException.class)
	public void testPreverTerminoFailNonZeroNumber() throws OrdemNaoCrescenteException, NonNumberZeroException, RangeException {
		int[] arrayPosicoes = {2,3,4};
		c.preverTermino(arrayPosicoes);
	}
	
	@Test (expected=OrdemNaoCrescenteException.class)
	public void testPreverTerminoFailOrdemNaoCrescente() throws OrdemNaoCrescenteException, NonNumberZeroException, RangeException {
		int[] arrayPosicoes = {0,2,1};	
		c.preverTermino(arrayPosicoes);
		
	}
	
	
}
