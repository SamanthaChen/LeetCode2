package iQiyi;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string1 = scanner.next();
			String string2 = scanner.next();
			int len1 = string1.length();
			int len2 = string2.length();
			int[][] dp = new int[len1 + 1][len2 + 1];
			// ≥ı ºªØdp
			for (int i = 0; i <= len1; i++) {
				dp[i][0] = i;
			}
			for (int j = 0; j <= len2; j++) {
				dp[0][j] = j;
			}
			int tmp = 0;
			for (int i = 0; i < len1; i++) {
				char w1 = string1.charAt(i);
				for (int j = 0; j < len2; j++) {
					char w2 = string2.charAt(j);
					if (w1 == w2) {
						dp[i + 1][j + 1] = dp[i][j];
					} else {
						tmp = Math.min(dp[i + 1][j], dp[i][j + 1]);
						dp[i + 1][j + 1] = Math.min(dp[i][j], tmp) + 1;
					}
				}
			}

			System.out.println(dp[len1][len2]);
		}
		scanner.close();

	}

}
