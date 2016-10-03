package Sogou;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			// 求最大回文子串的长度
			slove(s);
		}
		scanner.close();
	}

	// 直接选择就好了，从最长的开始选，是回文就直接输出就好了
	public static void slove(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;

		for (int i = n - 1; i >= 0; i--) {
			int count = 0;
			// 从首尾开始判断是不是回文
			while (count <= i - count && ch[count] == ch[i - count]) {
				count++;
			}
			if (count > i - count) {
				// 说明走到最中间的字符串了，说明是回文
				System.out.println(count);
				break;
			}
		}
	}

	// 思路1： 从中心向两边扩张，O(n^2)时间和O(1)空间
	// 中心的选取有2n-1种，确认回文串有o(n)的时间 所以是O((2n-1)*n)
	public static void longestHuiwenlen(String s) {

		int maxlen = 1;// 原本最长的是1

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandPalindrome(s, i, i);
			int len2 = expandPalindrome(s, i, i + 1);
			int len = Math.max(len1, len2);
			maxlen = Math.max(len, maxlen);
		}
		// return s.substring(start,end+1);
		System.out.println(maxlen);
	}

	// 这个方法返回从中心开始扩张的最长回文串
	public static int expandPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

}
