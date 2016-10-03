package Ctrip;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			String[] str = s.split(",");
			// 将字符串转为数组
			int[] nums = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				nums[i] = Integer.valueOf(str[i]);
			}
			int maxpro = 0;
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] - nums[i] > maxpro) {
						maxpro = nums[j] - nums[i];
					}
				}
			}
			System.out.println(maxpro);

		}
		scanner.close();

	}

}
