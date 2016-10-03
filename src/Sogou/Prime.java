package Sogou;

/**
 * 题目描述：

定义两个大于2的偶数之间的距离，为这两个数之间质数的个数。从小到大输入n个大于2的偶数，输出所有数两两之间距离的总和（应该有n*(n-1)/2个距离，输出总和就好)。
输入
第一行是输入偶数的个数，最小为2，最大可能到几万。之后每行为一个偶数，最小是4，最大可能是几百万，不重复的升序排列。
输出
输入数据两两间距离的总和，这应该是一个不小于0的整数。

样例输入
3
4
6
12
样例输出
6
本人代码：不考虑效率，赛码网71%通过，提示超时；欢迎指正
 * 
 * */
import java.util.Scanner;

public class Prime {
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {// 程序默认2是素数，当i=2时，循环不执行
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int count(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = a[i]; k <= a[j]; k++) {
					if (isPrime(k)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(count(a));

	}

}