package Sogou;

/**
 * 求最大回文串长度，但是数据量很大，需要时间复杂度尽量低
 * 
 * */
import java.util.Scanner;

public class PalidromeLength {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			// 求最大回文子串的长度
			char[] str = init(s);
			manacher(str);
		}
		scanner.close();

	}

	/**
	 * 返回例如 #a#c#b#c#a#a#c#b#c#d#形式的字符串数组
	 * 
	 * @param s
	 * @return
	 */
	public static char[] init(String s) {
		char[] str = new char[s.length() * 2 + 1];

		int i = 0;
		for (; i < s.length(); i++) {
			str[2 * i] = '#';
			str[2 * i + 1] = s.charAt(i);
		}
		str[2 * i] = '#';

		return str;
	}

	/**
	 * 
	 * 
	 * @param str
	 */
	public static void manacher(char[] s) {
		int rad[] = new int[s.length];

		int i = 1, j = 0, k;

		// 记录最长的回文串的长度
		int maxLen = 0;
		while (i < s.length) {
			// 扫描得出rad值
			while (i - j - 1 > -1 && i + j + 1 < s.length && s[i - j - 1] == s[i + j + 1])
				j++;
			rad[i] = j;

			maxLen = maxLen > j ? maxLen : j;

			k = 1;
			while (k <= rad[i] && rad[i - k] != rad[i] - k) {
				rad[i + k] = Math.min(rad[i - k], rad[i] - k);
				k++;
			}
			i = i + k;
			j = Math.max(j - k, 0);
		}

		System.out.println(maxLen);
	}

}
