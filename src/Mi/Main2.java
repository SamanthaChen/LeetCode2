package Mi;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			String[] str = s.split(" ");
			for (int i = str.length - 1; i >= 1; i--) {
				System.out.print(str[i] + " ");
			}
			System.out.println(str[0]);
		}
		scanner.close();
	}
}
