package HuaWei;

import java.util.Scanner;

public class DeleteMinCountChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			int[] count = new int[26];
			// ͳ��Ƶ��
			for (int i = 0; i < s.length(); i++) {
				count[s.charAt(i) - 'a']++;
			}
			// ����һ���ҳ��ִ�����С��
			int mincount = s.length();
			for (int i = 0; i < s.length(); i++) {
				if (count[s.charAt(i) - 'a'] > 0 && count[s.charAt(i) - 'a'] < mincount) {
					mincount = count[s.charAt(i) - 'a'];
				}
			}
			// �����Ƶ����С��
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				if (count[s.charAt(i) - 'a'] > mincount)
					sb.append(s.charAt(i));
			}
			if (sb == null || sb.length() <= 0) {
				System.out.println("");
			} else {
				System.out.println(sb.toString());
			}
		}
		sc.close();
	}

}
