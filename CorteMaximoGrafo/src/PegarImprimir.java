import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PegarImprimir {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(new File(args[0])));
		//PrintWriter pw = new PrintWriter(new File(args[1] + ".out"));
		String nome;
		while (scanner.hasNextLine()) {
			nome = scanner.nextLine();
			

		}

	}
}
