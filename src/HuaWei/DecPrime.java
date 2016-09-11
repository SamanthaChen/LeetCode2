package HuaWei;

import java.util.Scanner;

/**
 * 分解质因数
 */
public class DecPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			for (int i = 2; i < n; i++) {
				while (n != i) {
					if (n % i != 0) {
						break;// 不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
						// 都被除完之后。剩下的因数只能是奇数，且是质数。
					}
					System.out.print(i + " ");
					n = n / i;
				}
			}
			System.out.println(n);

		}
		sc.close();

	}

}
