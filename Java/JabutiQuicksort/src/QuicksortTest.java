import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuicksortTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	// Testes critério todos os nós

	@Test
	public void testNos1() {
		int[] a = { 4, 3, 5, 2, 1 };
		int[] expected = { 1, 2, 3, 4, 5 };
		new Quicksort().sort(a);
		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void testNos2() {
		int[] a = {};
		int[] expected = {};
		new Quicksort().sort(a);
		Assert.assertArrayEquals(expected, a);
	}

	// Testes critério todas as arestas

	@Test
	public void test() {
		int[] a = { 1, 2 };
		int[] expected = { 1, 2 };
		new Quicksort().sort(a);
		assertArrayEquals(expected, a);
	}

	@Test
	public void test1() {
		int[] a = { 2, 3, 1 };
		int[] expected = { 1, 2, 3 };
		new Quicksort().sort(a);
		assertArrayEquals(expected, a);
	}

	@Test
	public void test2() {
		int[] a = { 3, 1, 2 };
		int[] expected = { 1, 2, 3 };
		new Quicksort().sort(a);
		assertArrayEquals(expected, a);
	}

}
