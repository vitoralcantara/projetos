public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/***** trecho do programa principal ****/
		int[] numbers = new int[] { 34, 2, 4, 12, 1 };
		Sorter sorter = new SortListAdapter();
		numbers = sorter.sort(numbers);
		for(int i = 0 ; i < numbers.length ; i++){
			System.out.print(numbers[i] + " ");
		}
		/****************************/

	}
}
