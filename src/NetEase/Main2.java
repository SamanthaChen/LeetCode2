package NetEase;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			// 解题过程
			int count = 0;
			// int[] record = new int[n + 1]; //超过限制
			// record[1] = 1;// f[1]=1
			int odd = 1;
			int even = 1;
			for (int i = 1; i <= n; i++) {
				if (i % 2 != 0) {
					count += i;// 奇数的话是自己
					odd = i;//
				} else {// 偶数的话从最大奇数开始算
					int k = i / 2;
					if (k % 2 == 0) {// 一半是偶数
						count += even;
					} else {
						count += odd;// 一半是奇数
						even = odd;
					}

				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

}
