package HuaWei;

import java.util.Scanner;

public class ValidPassWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			if (isValid(s)) {
				System.out.println("OK");
			} else
				System.out.println("NG");
		}
		sc.close();
	}

	private static boolean isValid(String s) {
		s.trim();// �����ո�
		if (s == "" || s.length() <= 0)
			return false;
		// 1.���ȳ�8
		if (s.length() <= 8)
			return false;
		// 2.��д��Сд�����֡�������������3��
		int uppercase = 0;
		int lowercase = 0;
		int digit = 0;
		int otherch = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				digit = 1;
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				uppercase = 1;
			} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				lowercase = 1;
			} else {
				otherch = 1;
			}
			// 4.���ȳ���2�����Ӵ� �ظ����֣�
			if (i - 2 >= 0 && i + 1 < s.length()) {
				String sub = s.substring(i - 2, i + 1);// ��ȡ����Ϊ3���Ӵ�
				if (s.substring(i + 1).indexOf(sub) != -1) // ��ʣ�µ��ַ���������û���Ӵ�
					return false;

			}
		}

		if (uppercase + lowercase + digit + otherch < 3)
			return false;

		return true;

	}

}
