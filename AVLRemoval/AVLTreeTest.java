//
// Programa: AVLTreeTest.java
//

public class AVLTreeTest {
	public static void main(String args[]) {
		var tree = new AVLTree(); // Cria um objeto AVLTree.

		// Insere uma sequência de inteiros na árvore.
		try {
			System.out.println();
			System.out.println();

			tree.insert(5);
			tree.insert(3);
			tree.insert(8);
			tree.insert(2);
			tree.insert(4);
			tree.insert(7);
			tree.insert(10);
			tree.insert(1);
			tree.insert(6);
			tree.insert(9);
			tree.insert(11);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Uma rotação simples à direita deve ocorrer na remoção de
			// 4.

			System.out.println("Delete number 4:");

			tree.delete(4);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Nenhuma rotação deve ocorrer.

			System.out.println("Delete number 8:");

			tree.delete(8);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Uma rotação simples à esquerda deve ocorrer na remoção de
			// 6.

			System.out.println("Delete number 6:");

			tree.delete(6);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Nenhuma rotação deve ocorrer.

			System.out.println("Delete number 5:");

			tree.delete(5);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Uma rotação dupla à esquerda deve ocorrer na remoção de
			// 2.

			System.out.println("Delete number 2:");

			tree.delete(2);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Nenhuma rotação deve ocorrer.

			System.out.println("Delete number 1:");

			tree.delete(1);

			tree.printAll();

			System.out.println();
			System.out.println();

			// Uma rotação dupla à esquerda deve ocorrer na remoção de
			// 7.

			System.out.println("Delete number 7:");

			tree.delete(7);

			tree.printAll();

			System.out.printf("\n\n");

			// Uma rotação dupla à direita deve ocorrer na remção de
			// 11.

			System.out.println("Delete number 11:");

			tree.delete(11);

			tree.printAll();

			System.out.println();
			System.out.println();

		} catch (RuntimeException exception) {
			exception.printStackTrace();
		}
	}
}
