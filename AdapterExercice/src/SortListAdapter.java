import java.util.ArrayList;
import java.util.List;

public class SortListAdapter implements Sorter {

	public int[] sort(int[] numbers) {
		// convert the array to a List
		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numberList.add(numbers[i]);
		}
		// call the adapter
		NumberSorter sorter = new NumberSorter();
		numberList = sorter.sort(numberList);
		int[] sortedNumbers = new int[numberList.size()];
		for (int i = 0; i < numberList.size(); i++) {
			sortedNumbers[i] = numberList.get(i);
		}
		return sortedNumbers;
	}
}