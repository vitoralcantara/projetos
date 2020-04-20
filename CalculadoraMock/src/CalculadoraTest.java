import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	Calculadora c;

	@Before
	public void setUp() throws Exception {
		c = new Calculadora();
		c.ms = createMock(MultiplicationService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		expect(c.ms.multiply(12, 3)).andReturn(36);
		replay(c.ms);
		assertEquals(30, c.calculatePrice(12, 3, 6).intValue());
		verify(c.ms);
	}

}
