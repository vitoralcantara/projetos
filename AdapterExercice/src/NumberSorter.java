import java.util.Collections;
import java.util.List;

/***** This is our adaptee,. *******/
public class NumberSorter {
	public List<Integer> sort(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}
}
