package HuaWei;

import java.util.Scanner;

public class BottleChange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n != 0) {
				// 处理的代码
				int count = 0;
				while (n > 1) {
					if (n == 2) {
						count++;
						break;
					} else {
						count += n / 3;
						n = n / 3 + n % 3;
					}
				}
				System.out.println(count);
			} else {
				break;
			}

		}
		sc.close();
	}

}
