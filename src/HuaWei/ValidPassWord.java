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
		s.trim();// 剪掉空格
		if (s == "" || s.length() <= 0)
			return false;
		// 1.长度超8
		if (s.length() <= 8)
			return false;
		// 2.大写、小写、数字、其他符号至少3种
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
			// 4.长度超过2，的子串 重复出现，
			if (i - 2 >= 0 && i + 1 < s.length()) {
				String sub = s.substring(i - 2, i + 1);// 截取长度为3的子串
				if (s.substring(i + 1).indexOf(sub) != -1) // 看剩下的字符串里面有没有子串
					return false;

			}
		}

		if (uppercase + lowercase + digit + otherch < 3)
			return false;

		return true;

	}

}
