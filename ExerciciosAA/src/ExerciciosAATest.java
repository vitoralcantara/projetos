import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ExerciciosAATest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFib() {
		assertEquals(2,ExerciciosAA.fib(2));
		assertEquals(5,ExerciciosAA.fib(4));
		assertEquals(89,ExerciciosAA.fib(10));
	}
	
	@Test
	public void testFibPD() {
		assertEquals(2,ExerciciosAA.fibPD(2));
		assertEquals(5,ExerciciosAA.fibPD(4));
		assertEquals(89,ExerciciosAA.fibPD(10));
	}
	
	

}
