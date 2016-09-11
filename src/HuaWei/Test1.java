package HuaWei;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine();
			String[] list = s.split(" {1,}");
			StringBuffer sb = new StringBuffer();
			for (int i = list.length - 1; i >= 0; i--) {
				list[i] = reverse(list[i]);
				sb.append(list[i] + " ");
			}
			sb.delete(sb.length() - 1, sb.length());
			System.out.println(sb.toString());

		}
		sc.close();

	}

	public static String reverse(String s) {
		char[] ch = s.toCharArray();
		int i = 0;
		int j = ch.length - 1;
		while (i < j) {
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
		}
		return new String(ch);
	}
}