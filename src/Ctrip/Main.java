package Ctrip;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int findnum = scanner.nextInt();
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			// ¶þ·Ö²éÕÒ
			int res = Arrays.binarySearch(nums, findnum);
			System.out.println(res);
		}
		scanner.close();

	}

}
