import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Vitor
 *
 */
public class ContaTest {

	Conta c;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Conta("123",50);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

//	/**
//	 * Test method for {@link Conta#Conta(java.lang.String, double)}.
//	 */
//	@Test
//	public void testConta() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link Conta#debitar(double)}.
	 */
	
	@Test
	public void testDebitar() throws OperacaoIlegalException {
		try{
			c.debitar(70);	
			fail();
		}
		catch(OperacaoIlegalException o)
		{
			o.printStackTrace();
			assertEquals(c.saldo, 50 , 0);
		}
	}
	
	@Test  
	public void testTransferirFalha() throws OperacaoIlegalException{
		Conta d = new Conta("outra",20);
		try{
			c.transferir(d, 60);
			fail();
		}
		catch(OperacaoIlegalException o){
			o.printStackTrace();
			assertEquals(20,d.saldo,0);
			assertEquals(50,c.saldo,0);
		}
		
	}
	
	@Test  
	public void testTransferirSucesso() throws OperacaoIlegalException{
		Conta d = new Conta("outra",20);
		try{
			c.transferir(d, 40);
			assertEquals(60,d.saldo,0);
			assertEquals(10,c.saldo,0);			
		}
		catch(OperacaoIlegalException o){
			fail();
		}
		
	}
	
	
}
