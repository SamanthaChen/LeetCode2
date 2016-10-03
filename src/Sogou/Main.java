package Sogou;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			// ���������Ӵ��ĳ���
			slove(s);
		}
		scanner.close();
	}

	// ֱ��ѡ��ͺ��ˣ�����Ŀ�ʼѡ���ǻ��ľ�ֱ������ͺ���
	public static void slove(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;

		for (int i = n - 1; i >= 0; i--) {
			int count = 0;
			// ����β��ʼ�ж��ǲ��ǻ���
			while (count <= i - count && ch[count] == ch[i - count]) {
				count++;
			}
			if (count > i - count) {
				// ˵���ߵ����м���ַ����ˣ�˵���ǻ���
				System.out.println(count);
				break;
			}
		}
	}

	// ˼·1�� ���������������ţ�O(n^2)ʱ���O(1)�ռ�
	// ���ĵ�ѡȡ��2n-1�֣�ȷ�ϻ��Ĵ���o(n)��ʱ�� ������O((2n-1)*n)
	public static void longestHuiwenlen(String s) {

		int maxlen = 1;// ԭ�������1

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandPalindrome(s, i, i);
			int len2 = expandPalindrome(s, i, i + 1);
			int len = Math.max(len1, len2);
			maxlen = Math.max(len, maxlen);
		}
		// return s.substring(start,end+1);
		System.out.println(maxlen);
	}

	// ����������ش����Ŀ�ʼ���ŵ�����Ĵ�
	public static int expandPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

}
