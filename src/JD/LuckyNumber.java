package JD;

import java.util.Scanner;

import JZoffer.Solution;

public class LuckyNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			long num = sc.nextLong();
			s.getResult(num);
		}
		sc.close();
	}

	public static String getFortuneNum(long num) {
		// ȷ��λ��
		int bits = 1;
		for (int i = 2; i <= num; i += Math.pow(2, bits))
			bits++;

		// ��������
		char[] ret = new char[bits];

		// ȷ��T(num-cur)
		int cur = 0;
		for (int i = 1; i < bits; i++)
			cur += Math.pow(2, i);

		// λ���
		fill(ret, 0, num - cur);
		return String.valueOf(ret);
	}

	public static void fill(char[] ret, int start, double num) {
		if (start == ret.length)
			return;
		int curBits = ret.length - start;
		if (Math.pow(2, curBits - 1) >= num) {
			ret[start] = '4';
			fill(ret, start + 1, num);
		} else {
			ret[start] = '7';
			fill(ret, start + 1, num - Math.pow(2, curBits - 1));
		}

	}
}
