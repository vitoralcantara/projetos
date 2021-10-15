//
// Programa: AVLTree.java
//

//
// Definição da classe AVLTree
//

public class AVLTree {
	// ---------------------------------------------------------------
	//
	// Atributos
	//
	// ---------------------------------------------------------------

	// Apontador para nó raiz
	private AVLTreeNode mRoot;

	// Atributo para indicar que a altura de uma �rvore aumentou ou
	// diminuiu.
	private boolean mH;

	// ---------------------------------------------------------------
	//
	// Métodos públicos
	//
	// ---------------------------------------------------------------

	// ---------------------------------------------------------------
	// AVLTree()
	//
	// Construtor cria uma Árvore AVL vazia.
	// ---------------------------------------------------------------
	public AVLTree() {
		mRoot = null;
		mH = false;
	}

	// ---------------------------------------------------------------
	// isEmpty()
	//
	// Determina se a árvore está vazia.
	// ---------------------------------------------------------------
	public boolean isEmpty() {
		return mRoot == null;
	}

	// ---------------------------------------------------------------
	// printAll()
	//
	// Exibe os elementos da árvore em ordem simétrica e em pré pós
	// ordem na saída padrão.
	// ---------------------------------------------------------------
	public void printAll() {
		printPreOrder();

		printInOrder();

		printPostOrder();
	}

	// ---------------------------------------------------------------
	// printPreOrder()
	//
	// Exibe os elementos da árvore em pré-ordem na saída padrão.
	// ---------------------------------------------------------------
	public void printPreOrder() {
		if (mRoot != null) {
			System.out.printf("Pre-order: %d(%d)", mRoot.getItem(), mRoot.getBal());
			printPreOrder(mRoot.getLeft());
			printPreOrder(mRoot.getRight());

			System.out.println();
		}
	}

	// ---------------------------------------------------------------
	// printInOrder()
	//
	// Exibe os elementos da árvore em ordem simétrica na saída
	// padrão.
	// ---------------------------------------------------------------
	public void printInOrder() {
		if (mRoot != null) {
			System.out.print("In-order: ");

			printInOrder(mRoot.getLeft());

			System.out.printf(" %d(%d)", mRoot.getItem(), mRoot.getBal());

			printInOrder(mRoot.getRight());

			System.out.println();
		}
	}

	// ---------------------------------------------------------------
	// printPostOrder()
	//
	// Exibe os elementos da �rvore em p�s-ordem na sa�da padr�o.
	// ---------------------------------------------------------------
	public void printPostOrder() {
		if (mRoot != null) {
			System.out.printf("Post-order:");

			printPostOrder(mRoot.getLeft());

			printPostOrder(mRoot.getRight());

			System.out.printf(" %d(%d)", mRoot.getItem(), mRoot.getBal());

			System.out.printf("\n");
		}
	}

	// ---------------------------------------------------------------
	// insert()
	//
	// Insere um int na �rvore.
	// ---------------------------------------------------------------
	public void insert(int item) throws InsertionOfExistingItemException {
		mRoot = insert(mRoot, item);
	}

	// ---------------------------------------------------------------
	// delete()
	//
	// Remove um int da �rvore.
	// ---------------------------------------------------------------
	public void delete(int item) throws DeletionOfNonExistingItemException {
		mRoot = delete(mRoot, item);
	}

	// ---------------------------------------------------------------
	//
	// M�todos privados
	//
	// ---------------------------------------------------------------

	// ---------------------------------------------------------------
	// printPreOrder()
	//
	// Exibe os elementos da �rvore em pr�-ordem na sa�da padr�o.
	// ---------------------------------------------------------------
	private void printPreOrder(AVLTreeNode node) {
		if (node == null) {
			return;
		}

		System.out.printf(" %d(%d)", node.getItem(), node.getBal());

		printPreOrder(node.getLeft());

		printPreOrder(node.getRight());
	}

	// ---------------------------------------------------------------
	// printInOrder()
	//
	// Exibe os elementos da �rvore em ordem sim�trica na sa�da padr�o.
	// ---------------------------------------------------------------
	private void printInOrder(AVLTreeNode node) {
		if (node == null) {
			return;
		}

		printInOrder(node.getLeft());

		System.out.printf(" %d(%d)", node.getItem(), node.getBal());

		printInOrder(node.getRight());
	}

	// ---------------------------------------------------------------
	// printPostOrder()
	//
	// Exibe os elementos da �rvore em p�s-ordem na sa�da padr�o.
	// ---------------------------------------------------------------
	private void printPostOrder(AVLTreeNode node) {
		if (node == null) {
			return;
		}

		printPostOrder(node.getLeft());

		printPostOrder(node.getRight());

		System.out.printf(" %d(%d)", node.getItem(), node.getBal());
	}

	// ---------------------------------------------------------------
	// insert()
	//
	// Insere um int na �rvore.
	// ---------------------------------------------------------------
	private AVLTreeNode insert(AVLTreeNode node, int item) {
		// Cria uma refer�ncia auxiliar e a inicializa com o endere�o
		// de n� referenciado por "node". Ao final deste m�todo, esta
		// refer�ncia conter� o endere�o da raiz da sub�rvore na qual
		// "item" foi inserido.
		AVLTreeNode res = node;

		// Se a sub�rvore for vazia, crie um novo n�. Caso contr�rio,
		// continue a busca por uma sub�rvore vazia onde o novo
		// elemento deve ser inserido.
		if (node == null) {
			// Mude o status do indicador de mudan�a de altura.
			mH = true;

			// Crie e retorne o novo n�.
			res = new AVLTreeNode(item);
		} else {
			// Verifique se o novo elemento ser� inserido na sub�rvore
			// esquerda ou direita do n� atual (se essas sub�rvores
			// existirem).
			if (item < node.getItem()) {
				// Insere o novo elemento na sub�rvore esquerda.
				node.setLeft(insert(node.getLeft(), item));

				// Se a altura da sub�rvore enraizada no filho
				// esquerdo da raiz aumentou, ent�o verifique se a
				// �rvore precisa de rebalanceamento.
				if (mH) {
					res = balanceL(node, true);
				}
			} else if (item > node.getItem()) {
				// Insere o novo elemento na sub�rvore direita.
				node.setRight(insert(node.getRight(), item));

				// Se a altura da sub�rvore enraizada no filho direito
				// da raiz aumentou, ent�o verifique se a �rvore
				// precisa de rebalanceamento.
				if (mH) {
					res = balanceR(node, true);

					// Verifica se o status de balanceamento do n� �
					// 0. Se for, mudamos o valor da vari�vel
					// indicadora de altura para "false". Caso
					// contr�rio, deixamos este valor com "true" (pois
					// o balanceamento n�o foi realizado).
					if (node.getBal() == 0) {
						mH = false;
					}
				}
			} else {
				// O elemento a ser inserido j� est� na �rvore.
				throw new InsertionOfExistingItemException();
			}
		}

		// Se chegarmos at� aqui, ent�o a inser��o ocorreu com sucesso
		// e a refer�ncia para o n� atual deve ser devolvida para
		// manter a �rvore encadeada.
		return res;
	}

	// ---------------------------------------------------------------
	// delete()
	//
	// Remove um int da �rvore
	// ---------------------------------------------------------------
	private AVLTreeNode delete(AVLTreeNode node, int item) {
		// Cria uma refer�ncia auxiliar e a inicializa com o endere�o
		// de n� referenciado por "node". Ao final deste m�todo, esta
		// refer�ncia conter� o endere�o da raiz da sub�rvore da qual
		// "item" foi removido.
		AVLTreeNode res = node;

		// Se a �rvore for vazia, disparamos uma exce��o para indicar
		// que o elemento procurado n�o est� na �rvore. Caso
		// contr�rio, comparamos o elemento a ser removido com o n�
		// raiz.
		if (node == null) {
			throw new DeletionOfNonExistingItemException();
		} else if (item < node.getItem()) {
			// Verifique se o elemento a ser removido est� na
			// sub�rvore esquerda. Se sim, remova o elemento e
			// rebalanceie a �rvore (se necess�rio).
			node.setLeft(delete(node.getLeft(), item));

			// Se a altura da sub�rvore enraizada no filho esquerdo da
			// raiz diminuiu, ent�o verifique se a �rvore precisa de
			// rebalanceamento.
			if (mH) {
				res = balanceR(node, false);
			}
		} else if (item > node.getItem()) {

			// Verifique se o elemento a ser removido est� na
			// sub�rvore direita. Se sim, remova o elemento e
			// rebalanceie a �rvore (se necess�rio).
			node.setRight(delete(node.getRight(), item));

			// Se a altura da sub�rvore enraizada no filho direito da
			// raiz diminuiu, ent�o verifique se a �rvore precisa de
			// rebalanceamento.
			if (mH) {
				res = balanceL(node, false);
			}
		} else {
			// O n� raiz � o n� a ser removido. Se o n� raiz n�o
			// possui filho esquerdo ou direito, a remo��o �
			// trivial. Caso contr�rio, precisamos encontrar o n� mais
			// � direita da sub�rvore esquerda do n� raiz.
			if (node.getRight() == null) {
				res = node.getLeft();

				// Indique a diminui��o de altura.
				mH = true;
			} else if (node.getLeft() == null) {
				res = node.getRight();

				// Indique a diminui��o de altura.
				mH = true;
			} else {
				res.setLeft(delete(node.getLeft(), node));
				res.setItem(node.getItem());
			}
		}

		return res;
	}

	// ---------------------------------------------------------------
	// delete()
	//
	// Remove o n� mais � direita da sub�rvore esquerda de um dado
	// n�. O conte�do do n� removido substitui o conte�do do
	// n� dado.
	// ---------------------------------------------------------------
	private AVLTreeNode delete(AVLTreeNode r, AVLTreeNode node) {
		// Por hip�tese, "r" n�o pode ser uma refer�ncia nula.
		assert (r != null);

		// Enquanto o ultimo no direito nao eh encontrado, continua-se a procura
		if (r.getRight() != null) {

			r.setRight(delete(r.getRight(), node));

			// Apos encontrar o no e e substituir seu valor pelo no a ser deletado,
			// verifica-se se a arvore precisa ser balanceada
			if (mH) {

				r = balanceL(r, false);
			}
		} else {

			// O ultimo no direito a esquerda do no a ser deletado foi encontrado,
			// entao faz-se a troca de valores
			node.setItem(r.getItem());

			// A arvore pode ter sido desbalanceada, a cada retorno recursivo da funcao
			// sera analisada o balanco do mesmo
			mH = true;

			// Na chamada anterior da funcao, o pai esquerdo de r precisara conter o filho
			// esquerdo do mesmo, se nao perde-se nos
			return r.getLeft();
		}

		return r;
	}

	// ---------------------------------------------------------------
	// BalanceL()
	//
	// Realiza um balanceamento da sub�rvore enraizada em um dado n�,
	// se necess�rio, depois que a altura da sub�rvore enraizada em
	// seu filho esquerdo cresceu ou a altura da sub�rvore enraizada
	// em seu filho direito diminuiu.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceL(AVLTreeNode node, boolean ins) {
		// Por hip�tese, o valor do atributo indicador de mudan�a de
		// altura deve ser true e "node" n�o pode ser uma refer�ncia
		// nula.

		assert (mH);

		assert (node != null);

		// Cria uma refer�ncia auxiliar e a inicializa com o endere�o
		// de n� referenciado por "node". Ao final deste m�todo, esta
		// refer�ncia conter� o endere�o da raiz da sub�rvore
		// enraizada em "node".
		AVLTreeNode res = node;

		// Determina se a �rvore se tornou desbalanceada.
		if (node.getBal() == -1) {

			// Obtenha uma refer�ncia para o filho esquerdo.
			AVLTreeNode p1 = node.getLeft();

			//
			// Determina se a rota��o ser� simples ou dupla.
			//

			// Na inser��o, o status de balanceamento do n�
			// referenciado por "p1" deve ser -1 ou 1, mas nunca igual
			// a 0. Mas, na remo��o, este status balanceamento pode
			// ser -1, 0 ou 1.
			if (p1.getBal() <= 0) {
				// Obtenha o status de balanceamento de "p1" antes do
				// balanceamento.
				int b1 = p1.getBal();

				// Realiza rota��o simples � direita.
				res = balanceRR(node, p1);

				// Verifique se a sub�rvore enraizada em "res" possui
				// a mesma altura da sub�rvore enraizada em "node"
				// (antes do balanceamento). Se sim, n�o h� mais
				// necessidade de rebalancearmos a �rvore a partir
				// deste ponto, exceto no caso de lidarmos com
				// remo��o.
				if ((ins && (b1 == -1)) || (!ins && (b1 == 0))) {
					mH = false;
				}
			} else {
				// Realiza rota��o dupla � direita.
				res = balanceLR(node, p1);
			}
		} else {
			// Obtenha o status de balanceamento de "node".
			int bal = node.getBal();

			// Atualize o status de balanceamento do n� referenciado
			// por "node".
			node.setBal(node.getBal() - 1);

			// Verifica se o status de balanceamento do n� � 0. Se
			// for, mudamos o valor da vari�vel indicadora de altura
			// para "false". Caso contr�rio, deixamos este valor com
			// "true" (pois o balanceamento n�o foi realizado).
			if ((!ins && (bal == 0)) || (ins && (bal == 1))) {
				mH = false;
			}
		}

		return res;
	}

	// ---------------------------------------------------------------
	// balanceR()
	//
	// Realiza um balanceamento da sub�rvore enraizada em um dado n�,
	// se necess�rio, depois que a altura da sub�rvore enraizada em
	// seu filho direito cresceu ou a altura da sub�rvore enraizada em
	// seu filho esquerdo diminuiu.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceR(AVLTreeNode node, boolean ins) {
		// Por hip�tese, o valor do atributo indicador de mudan�a de
		// altura deve ser true e "node" n�o pode ser uma refer�ncia
		// nula.

		assert (mH);

		assert (node != null);

		// Cria uma refer�ncia auxiliar e a inicializa com o endere�o
		// de n� referenciado por "node". Ao final deste m�todo, esta
		// refer�ncia conter� o endere�o da raiz da sub�rvore
		// enraizada em "node".
		AVLTreeNode res = node;

		// Determina se a �rvore se tornou desbalanceada.
		if (node.getBal() == 1) {//

			// Obtenha uma refer�ncia para o filho direito.
			AVLTreeNode p1 = node.getRight();//

			//
			// Determina se a rota��o ser� simples ou dupla.
			//

			// Na inser��o, o status de balanceamento do n�
			// referenciado por "p1" deve ser -1 ou 1, mas nunca igual
			// a 0. Mas, na remo��o, este status balanceamento pode
			// ser -1, 0 ou 1.
			if (p1.getBal() >= 0) {
				// Obtenha o status de balanceamento de "p1" antes do
				// balanceamento.
				int b1 = p1.getBal();

				// Realiza rota��o simples � esquerda.
				res = balanceLL(node, p1);

				// Verifique se a sub�rvore enraizada em "res" possui
				// a mesma altura da sub�rvore enraizada em "node"
				// (antes do balanceamento). Se sim, n�o h� mais
				// necessidade de rebalancearmos a �rvore a partir
				// deste ponto, exceto no caso de lidarmos com
				// remo��o.
				if ((ins && (b1 == 1)) || (!ins && (b1 == 0))) {
					mH = false;
				}
			} else {
				// Realiza rota��o dupla � esquerda.
				res = balanceRL(node, p1);
			}
		} else {
			// Obtenha o status de balanceamento de "node".
			int bal = node.getBal();

			// Atualize o status de balanceamento do n� referenciado
			// por "node".
			node.setBal(node.getBal() + 1);

			// Verifica se o status de balanceamento do n� � 0. Se
			// for, mudamos o valor da vari�vel indicadora de altura
			// para "false". Caso contr�rio, deixamos este valor com
			// "true" (pois o balanceamento n�o foi realizado).
			if ((!ins && (bal == 0)) || (ins && (bal == -1))) {
				mH = false;
			}
		}

		return res;
	}

	// ---------------------------------------------------------------
	// balanceRR()
	//
	// Realiza uma rota��o simples � direita para balancear a
	// sub�rvore enraizada em um dado n�.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceRR(AVLTreeNode p, AVLTreeNode p1) {
		// Por hip�tese, "p1" aponta para o filho esquerdo de "p" e o
		// status de balanceamento do n� correspondente a "p1" deve
		// ser -1 (na inser��o) e -1 ou 0 (na remo��o).
		assert (p != null);

		assert (p1 != null);

		assert (p.getLeft() == p1);

		assert (p1.getBal() <= 0);

		// A sub�rvore direita do n� referenciado por "p1" se torna a
		// sub�rvore esquerda do n� referenciado por "p".
		p.setLeft(p1.getRight());

		// A sub�rvore direita do n� referenciado por "p" se torna a
		// sub�rvore enraizada no n� referenciado por "p1".
		p1.setRight(p);

		// Atualiza o status de balanceamento do n� enraizado em "p".
		if (p1.getBal() == 0) {
			// Este bloco de c�digo s� pode ser executado na remo��o.
			p.setBal(-1);
			p1.setBal(1);
		} else {
			// Na inser��o, este deve ser sempre o caso.
			p.setBal(0);
			p1.setBal(0);
		}

		// O n� referenciado por "p1" deve se tornar a raiz da
		// sub�rvore que, antes do balanceamento, tinha como raiz o n�
		// refernciado por "p".
		return p1;
	}

	// ---------------------------------------------------------------
	// balanceLR()
	//
	// Realiza uma rota��o dupla � direita para balancear a sub�rvore
	// enraizada em um dado n�.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceLR(AVLTreeNode p, AVLTreeNode p1) {
		// Por hip�tese, "p1" aponta para o filho esquerdo de "p" e o
		// status de balanceamento do n� correspondente a "p1" deve
		// ser 1 (na inser��o) e 0 ou 1 (na remo��o).
		assert (p != null);

		assert (p1 != null);

		assert (p.getLeft() == p1);

		assert (p1.getBal() >= 0);

		// Crie uma refer�ncia para o filho direito do n� referenciado
		// por "p1".
		AVLTreeNode p2 = p1.getRight();

		// A sub�rvore esquerda do n� referenciado por "p2" se torna a
		// sub�rvore direita do n� referenciado por "p1".
		p1.setRight(p2.getLeft());

		// A sub�rvore enraizada n� referenciado por "p1" se torna a
		// sub�rvore esquerda do n� referenciado por "p2".
		p2.setLeft(p1);

		// A sub�rvore direita do n� referenciado por "p2" se torna a
		// sub�rvore esquerda do n� referenciado por "p".
		p.setLeft(p2.getRight());

		// A sub�rvore enraizada n� referenciado por "p" se torna a
		// sub�rvore direita do n� referenciado por "p2".
		p2.setRight(p);

		// O pr�ximo passo � ajustar o status de balanceamento dos n�s
		// apontados por "p" e "p1". Note que, na inser��o, o status
		// do n� referenciado por "p2" deve ser -1 ou 1, mas nunca
		// igual a 0. Na remo��o, o status de balanceamento pode ser
		// -1, 0 ou 1.
		if (p2.getBal() == -1) {
			p.setBal(1);
		} else {
			p.setBal(0);
		}

		if (p2.getBal() == 1) {
			p1.setBal(-1);
		} else {
			p1.setBal(0);
		}

		p2.setBal(0);

		// O n� referenciado por "p2" deve se tornar a raiz da
		// sub�rvore que, antes do balanceamento, tinha como raiz o n�
		// refernciado por "p".
		return p2;
	}

	// ---------------------------------------------------------------
	// balanceLL()
	//
	// Realiza uma rota��o simples � esquerda para balancear a
	// sub�rvore enraizada em um dado n�.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceLL(AVLTreeNode p, AVLTreeNode p1) {
		// Por hip�tese, "p1" aponta para o filho direito de "p" e o
		// status de balanceamento do n� correspondente a "p1" deve
		// ser -1 (na inser��o) e -1 ou 0 (na remo��o).
		assert (p != null);

		assert (p1 != null);

		assert (p.getRight() == p1);

		assert (p1.getBal() >= 0);

		// A sub�rvore esquerda do n� referenciado por "p1" se torna a
		// sub�rvore direita do n� referenciado por "p".
		p.setRight(p1.getLeft());//

		// A sub�rvore esquerda do n� referenciado por "p" se torna a
		// sub�rvore enraizada no n� referenciado por "p1".
		p1.setRight(p);//

		// Atualiza o status de balanceamento do n� enraizado em "p".
		if (p1.getBal() == 0) {
			// Este bloco de c�digo s� pode ser executado na remo��o.
			p.setBal(1);
			p1.setBal(-1);
		} else {
			// Na inser��o, este deve ser sempre o caso.
			p.setBal(0);
			p1.setBal(0);
		}

		// O n� referenciado por "p1" deve se tornar a raiz da
		// sub�rvore que, antes do balanceamento, tinha como raiz o n�
		// refernciado por "p".
		return p1;
	}

	// ---------------------------------------------------------------
	// balanceRL()
	//
	// Realiza uma rota��o dupla � esquerda para balancear a sub�rvore
	// enraizada em um dado n�.
	//
	// ---------------------------------------------------------------
	private AVLTreeNode balanceRL(AVLTreeNode p, AVLTreeNode p1) {
		// Por hip�tese, "p1" aponta para o filho direito de "p" e o
		// status de balanceamento do n� correspondente a "p1" deve
		// ser -1 (na inser��o) e 0 ou -1 (na remo��o).
		assert (p != null);

		assert (p1 != null);

		assert (p.getRight() == p1);//

		assert (p1.getBal() >= 0);//

		// Crie uma refer�ncia para o filho esquerdo do n� referenciado
		// por "p1".
		AVLTreeNode p2 = p1.getLeft();//

		// A sub�rvore direita do n� referenciado por "p2" se torna a
		// sub�rvore esquerda do n� referenciado por "p1".
		p1.setRight(p2.getLeft());//

		// A sub�rvore enraizada n� referenciado por "p1" se torna a
		// sub�rvore direita do n� referenciado por "p2".
		p2.setRight(p1);//

		// A sub�rvore esquerda do n� referenciado por "p2" se torna a
		// sub�rvore direita do n� referenciado por "p".
		p.setRight(p2.getLeft());//

		// A sub�rvore enraizada n� referenciado por "p" se torna a
		// sub�rvore esquerda do n� referenciado por "p2".
		p2.setLeft(p);//

		// O pr�ximo passo � ajustar o status de balanceamento dos n�s
		// apontados por "p" e "p1". Note que, na inser��o, o status
		// do n� referenciado por "p2" deve ser -1 ou 1, mas nunca
		// igual a 0. Na remo��o, o status de balanceamento pode ser
		// -1, 0 ou 1.
		if (p2.getBal() == 1) {
			p.setBal(-1);
		} else {
			p.setBal(0);
		}

		if (p2.getBal() == -1) {
			p1.setBal(1);
		} else {
			p1.setBal(0);
		}

		p2.setBal(0);

		// O n� referenciado por "p2" deve se tornar a raiz da
		// sub�rvore que, antes do balanceamento, tinha como raiz o n�
		// refernciado por "p".
		return p2;

	}

} // Fim da classe AVLTree

//
// Definição da classe AVLTreeNode
//

class AVLTreeNode {
	// ---------------------------------------------------------------
	//
	// Atributos
	//
	// ---------------------------------------------------------------

	// Dado armazenado no nó.
	private int mItem;

	// Referência para o nó raiz da subárvore esquerda.
	private AVLTreeNode mLeft;

	// Referência para o nó raiz da subárvore direita.
	private AVLTreeNode mRight;

	// Valor resultado da subtração da altura da subárvore esquerda do
	// valor da altura da subárvore direita. Os valores possíveis são
	// -1, 0 e 1.
	private int mBal;

	// ---------------------------------------------------------------
	//
	// Métodos
	//
	// ---------------------------------------------------------------

	// ---------------------------------------------------------------
	// AVLTreeNode()
	//
	// Construtor cria um AVLTreeNode que cont�m "item"
	// ---------------------------------------------------------------
	public AVLTreeNode(int item) {
		mItem = item;
		mLeft = null;
		mRight = null;
		mBal = 0;
	}

	// ---------------------------------------------------------------
	// getItem()
	//
	// Retorna refer�ncia ao elemento armazenada no n�.
	// ---------------------------------------------------------------
	public int getItem() {
		return mItem;
	}

	// ---------------------------------------------------------------
	// getLeft()
	//
	// Retorna refer�ncia para o n� raiz da sub�rvore esquerda.
	// ---------------------------------------------------------------
	public AVLTreeNode getLeft() {
		return mLeft;
	}

	// ---------------------------------------------------------------
	// getRight()
	//
	// Retorna refer�ncia para o n� raiz da sub�rvore direita.
	// ---------------------------------------------------------------
	public AVLTreeNode getRight() {
		return mRight;
	}

	// ---------------------------------------------------------------
	// getBal()
	//
	// Retorna o status de balanceamento do n�.
	// ---------------------------------------------------------------
	public int getBal() {
		return mBal;
	}

	// ---------------------------------------------------------------
	// setItem()
	//
	// Atribui um valor inteiro ao atributo "m_item" deste n�.
	// ---------------------------------------------------------------
	public void setItem(int item) {
		mItem = item;
	}

	// ---------------------------------------------------------------
	// setLeft()
	//
	// Atribui refer�ncia ao apontador para o n� raiz da sub�rvore
	// esquerda.
	// ---------------------------------------------------------------
	public void setLeft(AVLTreeNode node) {
		mLeft = node;
	}

	// ---------------------------------------------------------------
	// setRight()
	//
	// Atribui refer�ncia ao apontador para o nó raiz da subárvore
	// direita.
	// ---------------------------------------------------------------
	public void setRight(AVLTreeNode node) {
		mRight = node;
	}

	// ---------------------------------------------------------------
	// setBal()
	//
	// Atualiza o status de balanceamento do nó.
	// ---------------------------------------------------------------
	public void setBal(int bal) {
		if (!((bal > -2) && (bal < 2))) {
			throw new IllegalArgumentException();
		}
		mBal = bal;
	}

	// ---------------------------------------------------------------
	// isChild()
	//
	// Determina se este nó é um dos dois filhos de um dado nó.
	// ---------------------------------------------------------------
	public boolean isChild(AVLTreeNode node) {
		return isLeftChild(node) || isRightChild(node);
	}

	// ---------------------------------------------------------------
	// isLeftChild()
	//
	// Determina se este n� � um o filho esquerdo de um dado n�.
	// ---------------------------------------------------------------
	public boolean isLeftChild(AVLTreeNode node) {
		if (node == null) {
			return false;
		}

		return this == node.getLeft();
	}

	// ---------------------------------------------------------------
	// isRightChild()
	//
	// Determina se este nó é um o filho direito de um dado nó.
	// ---------------------------------------------------------------
	public boolean isRightChild(AVLTreeNode node) {
		if (node == null) {
			return false;
		}

		return this == node.getRight();
	}

} // Fim da classe AVLTreeNode
