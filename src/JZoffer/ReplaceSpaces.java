package JZoffer;

import java.util.Scanner;

/*
����1���滻�ַ���������ԭ�����ַ��������滻�������¿���һ���ַ������滻��
����2���ڵ�ǰ�ַ����滻����ô�滻�Ÿ���Ч�ʣ�������java�����е�replace��������
      ��ǰ�����滻��������ַ�Ҫ���������ƶ���Ҫ����ƶ�������Ч�ʵ���
      �Ӻ���ǰ���ȼ�����Ҫ���ٿռ䣬Ȼ��Ӻ���ǰ�ƶ�����ÿ���ַ�ֻΪ�ƶ�һ�Σ�����Ч�ʸ���һ�㡣
*/
public class ReplaceSpaces {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			StringBuffer s = new StringBuffer(cin.nextLine());
			ReplaceSpaces m = new ReplaceSpaces();
			System.out.println(m.replaceSpace(s));
		}
		cin.close();
	}

	public String replaceSpace(StringBuffer str) {
		// ����ո���
		int spacecount = 0;
		int len = str.length();// ԭ������
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				spacecount++;
		}
		// ��չԭ���ַ�������
		str.setLength(len + spacecount * 2);
		// �Ӻ��濪ʼ�����滻
		int p2 = len + spacecount * 2 - 1;
		int p1 = len - 1;
		while (p1 < p2 && p1 >= 0) {
			if (str.charAt(p1) != ' ') {
				str.setCharAt(p2, str.charAt(p1));
				p2--;
				p1--;
			} else {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
				p1--;

			}
		}
		return str.toString();
	}
}
