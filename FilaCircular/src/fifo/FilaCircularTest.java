package fifo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilaCircularTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsEmpty() {
		FilaCircular fi = new FilaCircular();
		assertTrue(fi.isEmpty());
	}

	@Test
	public void testPut() throws FilaVaziaException, FilaCheiaException {
		FilaCircular fi = new FilaCircular();
		fi.put(1);
		assertEquals(fi.get(), 1);
	}

	@Test(expected = FilaVaziaException.class)
	public void testGet() throws FilaVaziaException {
		FilaCircular fi = new FilaCircular();
		fi.get();
	}

	@Test
	public void testPut_2Element() throws FilaVaziaException,
			FilaCheiaException {
		FilaCircular fi = new FilaCircular();
		fi.put(1);
		fi.put(2);
		assertEquals(fi.get(), 1);
		assertEquals(fi.get(), 2);

	}

	@Test(expected = FilaCheiaException.class)
	public void testInsereFilaCheia() throws FilaCheiaException {
		FilaCircular fi = new FilaCircular();
		fi.put(1);
		fi.put(2);
		fi.put(3);
		fi.put(4);
	}

	@Test
	public void testPut3Elements() throws FilaCheiaException,
			FilaVaziaException {
		FilaCircular fi = new FilaCircular();
		fi.put(3);
		fi.put(1);
		fi.put(2);
		assertEquals(fi.get(), 3);
		assertEquals(fi.get(), 1);
		assertEquals(fi.get(), 2);
	}

	@Test
	public void testPut_2ElementDiff() throws FilaVaziaException,
			FilaCheiaException {
		FilaCircular fi = new FilaCircular();
		fi.put(2);
		fi.put(1);
		assertEquals(fi.get(), 2);
		assertEquals(fi.get(), 1);
	}

}
