package HuaWei;

import java.util.Scanner;

public class ReorderString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			StringBuffer sb = new StringBuffer();
			// �Ȱ�����ĸ˳�����
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < s.length(); j++) {
					char c = s.charAt(j);
					if (Character.isLetter(c) && (c - 'a' == i || c - 'A' == i)) {
						sb.append(c);

					}
				}
			}
			// ��ֱ�Ӳ������ĸ
			for (int i = 0; i < s.length(); i++) {
				if (!Character.isLetter(s.charAt(i))) {
					sb.insert(i, s.charAt(i));
				}
			}
			System.out.println(sb.toString());
		}
		sc.close();
	}

}
