package Mi;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] numbers = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				String s = scanner.next();
				slove(new StringBuilder(s), new StringBuilder(), 0, 9);
			}
		}
		scanner.close();

	}

	public static String[] numbers = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };

	private static void slove(StringBuilder s, StringBuilder num, int start, int end) {
		if (s.length() == 0) {
			System.out.println(num);
			return;
		}
		for (int i = start; i <= end; i++) {
			char[] ch = numbers[i].toCharArray();
			String temp = s.toString();
			// 找一个完全在里面的单词
			boolean flag = true;
			for (int j = 0; j < ch.length; j++) {
				if (temp.indexOf(ch[j]) == -1) {
					flag = false;
					break;
				}
			}
			// 找到，移除

		}

	}
}
