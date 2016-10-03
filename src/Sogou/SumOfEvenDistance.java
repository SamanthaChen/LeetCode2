package Sogou;

/**
 *定义偶数之间的距离是它们之间的质因数个数，下面输入很多按升序排列的偶数，
 *输出所有两两偶数之间的距离之和（即一共n(n-1)/2组距离之和）。
 *示例：
 *输入： （第一行是偶数的个数，之后是按升序排列的偶数）
 *	3
 *	4
 *	6
 *	12
 *输出：
 *	6
 * */
import java.util.Scanner;

public class SumOfEvenDistance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int n2;
		int count = 0;
		int n1 = scanner.nextInt();// 第一个数
		for (int i = 1; i < N; i++) {
			// 求两两两个偶数之间的质数个数
			n2 = scanner.nextInt();
			// System.out.println(n1 + " " + n2 + " " + decPrime(n1, n2));
			count += decPrime(n1, n2);

			n1 = n2;
		}
		System.out.println(count * (N - 1));
		scanner.close();
	}

	// 分解质因数
	// 求两个数之间的质因数个数
	public static int decPrime(long start, long end) {

		// List<Long> list = new ArrayList<Long>();
		int len = 0;
		for (long i = start; i < end; i++) {
			while (end != i) {
				if (end % i != 0) {
					break;// 不能整除肯定不是因数，能够整除在这里一定是质数。因为所有的2，3,5,7
					// 都被除完之后。剩下的因数只能是奇数，且是质数。
				}
				len++;
				end = end / i;
			}
		}
		len++;
		return len;
	}

}
