package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Todas as condições abaixo cobriram todas as arestas do método
 * {@link Quicksort#quicksort(int[], int, int)}
 * 
 * 
 * @author Vitor
 * 
 */
public class QuicksortTestTodasAsArestas {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] a = { 1, 2 };
		int[] expected = { 1, 2 };
		Quicksort.quicksort(a, 0, 1);
		assertArrayEquals(expected, a);
	}

	@Test
	public void test1() {
		int[] a = { 2, 3, 1 };
		int[] expected = { 1, 2, 3 };
		Quicksort.quicksort(a, 0, 2);
		assertArrayEquals(expected, a);
	}

	@Test
	public void test2() {
		int[] a = { 3, 1, 2 };
		int[] expected = { 1, 2, 3 };
		Quicksort.quicksort(a, 0, 2);
		assertArrayEquals(expected, a);
	}
}
