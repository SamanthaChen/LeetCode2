package Sogou;

/**
 * �������Ĵ����ȣ������������ܴ���Ҫʱ�临�ӶȾ�����
 * 
 * */
import java.util.Scanner;

public class PalidromeLength {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			// ���������Ӵ��ĳ���
			char[] str = init(s);
			manacher(str);
		}
		scanner.close();

	}

	/**
	 * �������� #a#c#b#c#a#a#c#b#c#d#��ʽ���ַ�������
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

		// ��¼��Ļ��Ĵ��ĳ���
		int maxLen = 0;
		while (i < s.length) {
			// ɨ��ó�radֵ
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
