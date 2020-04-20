package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTestTodosOsNos {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Este método sozinho cobriu todos os nós, isto é, todos os comandos do
	 * método {@link Quicksort#quicksort(int[], int, int)}
	 */
	@Test
	public void test() {
		int[] a = { 4, 3, 5, 2, 1 };
		int[] expected = { 1, 2, 3, 4, 5 };
		Quicksort.quicksort(a, 0, 4);
		assertArrayEquals(expected, a);
	}
}
