package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTestTodasAsCondicoes {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Este método sozinho executou todos as condições, isto é, resultou em TRUE
	 * e FALSE cada sentença dos comandos while e for.
	 * 
	 */
	@Test
	public void test() {
		int[] a = { 4, 3, 2, 5, 34, 6, 10, 10, 0 };
		int[] expected = { 0, 2, 3, 4, 5, 6, 10, 10, 34 };
		Quicksort.quicksort(a, 0, a.length - 1);
		assertArrayEquals(expected, a);
	}

}
