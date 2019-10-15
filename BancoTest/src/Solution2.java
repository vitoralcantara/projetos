import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution2 {

	static class DoubleComparable implements Comparable<DoubleComparable> {

		private double value;

		public DoubleComparable(double value) {
			this.value = value;
		}

		@Override
		public int compareTo(DoubleComparable o) {
			// TODO Auto-generated method stub
			if (this.getValue() <= o.getValue()) {
				return -1;
			} else if (this.getValue() > o.getValue()) {
				return 1;
			} else {
				return 0;
			}
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}
	}

	/*
	 * Complete the runningMedian function below.
	 */
	static class RootNode {
		private double value;
		private TreeSet<DoubleComparable> left = new TreeSet<Solution2.DoubleComparable>();
		private TreeSet<DoubleComparable> right = new TreeSet<Solution2.DoubleComparable>();
		private int balance = 0;

		public TreeSet<DoubleComparable> getRight() {
			return right;
		}

		public void setRight(TreeSet<DoubleComparable> right) {
			this.right = right;
		}

		public TreeSet<DoubleComparable> getLeft() {
			return left;
		}

		public void setLeft(TreeSet<DoubleComparable> left) {
			this.left = left;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

	}

	static void insertLeft(RootNode root, double value) {
		root.getLeft().add(new DoubleComparable(value));
	}

	static void insertRight(RootNode root, double value) {
		root.getRight().add(new DoubleComparable(value));
	}

	static void insert(RootNode node, double value) {
		if (value < node.getValue()) {
			insertLeft(node, value);
			if (node.getBalance() > -1) {
				node.setBalance(node.getBalance() - 1);
			} else {
				shiftToLeft(node);
				node.setBalance(0);
			}
		} else if (value >= node.getValue()) {
			insertRight(node, value);
			if (node.getBalance() < 1) {
				node.setBalance(node.getBalance() + 1);
			} else {
				shiftToRight(node);
				node.setBalance(0);
			}
		}
	}

	private static void shiftToLeft(RootNode node) {
		node.getRight().add(new DoubleComparable(node.getValue()));
		node.setValue(node.getLeft().pollLast().getValue());
	}

	private static void shiftToRight(RootNode node) {
		node.getLeft().add(new DoubleComparable(node.getValue()));
		node.setValue(node.getRight().pollFirst().getValue());
	}

	static double getRightValue(RootNode node) {
		return node.getRight().first().getValue();
	}

	static double getLeftValue(RootNode node) {
		return node.getLeft().last().getValue();
	}

	static double[] runningMedian(int[] a) {

		if (a.length == 0) {
			double[] d = {};
			return d;
		}

		RootNode rootNode = new RootNode();
		rootNode.setValue(a[0]);
		double[] result = new double[a.length];

		result[0] = a[0];

		for (int i = 1; i < a.length; i++) {
			insert(rootNode, a[i]);
			if (rootNode.getBalance() > 0) {
				double v1 = rootNode.getValue();
				double v2 = getRightValue(rootNode);
				result[i] = (v1 + v2) / 2.0;
			} else if (rootNode.getBalance() < 0) {
				double v1 = rootNode.getValue();
				double v2 = getLeftValue(rootNode);
				result[i] = (v1 + v2) / 2.0;
			} else {
				result[i] = rootNode.getValue();
			}
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int aCount = Integer.parseInt(scanner.nextLine().trim());

		int[] a = new int[aCount];

		for (int aItr = 0; aItr < aCount; aItr++) {
			int aItem = Integer.parseInt(scanner.nextLine().trim());
			a[aItr] = aItem;
		}

		double[] result = runningMedian(a);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			System.out.println(result[resultItr]);
		}
	}
}
