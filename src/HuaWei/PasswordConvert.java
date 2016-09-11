package HuaWei;

import java.util.Scanner;

public class PasswordConvert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			StringBuffer sb = new StringBuffer();
			// 每个字符检查一次
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				// 小写变数字
				if (ch >= 'a' && ch <= 'z') {
					int n1 = ch - 'a';
					if (n1 < 18) {
						n1 = n1 / 3 + 2;
					} else {
						if (ch == 's')
							n1 = 7;
						if ("tuv".indexOf(ch) != -1)
							n1 = 8;
						if ("wxyz".indexOf(ch) != -1)
							n1 = 9;
					}
					sb.append(n1);
				} else if (ch >= 'A' && ch <= 'Z') {
					// 大写变小写，后移
					int n2 = (ch - 'A' + 1) % 26;
					n2 = n2 + 'a';
					sb.append((char) n2);
				} else {
					sb.append(ch);
				}

			}
			System.out.println(sb.toString());
		}
		sc.close();

	}

}
