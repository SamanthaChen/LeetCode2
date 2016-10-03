package Sogou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prime2 {

	public static void main(String[] args) {
		Prime2 m = new Prime2();
		m.slove();
	}

	public void slove() {
		// 获得不大于n的素数
		int maxn = 10000010;
		boolean[] isPrime = getPrime(maxn);
		// 扫描输入
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int num, lastnum;// 分别是第一个数和后一个
		List<Integer> list = new ArrayList<Integer>();// 保存顺次两两个偶数之间的质数个数
		num = scanner.nextInt();// 第一个数

		// 求两两两个偶数之间的质数个数
		for (int i = 1; i < N; i++) {
			lastnum = scanner.nextInt();
			int count = 0;
			for (int j = num + 1; j < lastnum; j = j + 2) {// 偶数肯定不是质数，所以+2的找
				if (isPrime[j]) {
					count++;
				}
			}
			list.add(count);
			num = lastnum;// 更新一下
		}
		/*
		 * 求出结果。 本可以使用二重循环求出，但那样是会超时的。 这里先求出第一个数到剩余所有数的距离之和，
		 * 然后将求出的和减去第一个数到第二个数的距离乘以 n - 1 即为第二个数到后面所有数的距离。 按此思想即可算出结果
		 */
		int sum = 0;
		int tmp = 0;
		for (int i = 0; i < N - 1; i++) {
			tmp += list.get(i);
			sum += tmp;
		}
		tmp = sum;
		for (int i = 1; i < N - 1; i++) {
			tmp -= list.get(i - 1) * (N - i);
			sum += tmp;
		}
		System.out.println(sum);
		scanner.close();
	}

	/**
	 * 过筛法求不大于N的所有素数
	 */
	public boolean[] getPrime(int maxn) {
		boolean[] isPrime = new boolean[maxn];
		Arrays.fill(isPrime, true);// 所有的初始化为true
		for (int i = 2; i * i < maxn; i++) {
			if (!isPrime[i])
				continue;
			// 合数的倍数一定是合数
			for (int j = 2; i * j < maxn; j++) {
				isPrime[i * j] = false;
			}
		}
		return isPrime;

	}
}
