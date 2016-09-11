package HuaWei;

import java.util.Scanner;

public class LocationMove {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			String s = cin.nextLine();
			String[] sa = s.split(";");
			getLoc(sa);
		}
		cin.close();

		// System.out.println(isDigit("AA".substring(1)));

	}

	private static void getLoc(String[] sa) {
		int x = 0;
		int y = 0;
		for (String s : sa) {
			// ·Ç·¨×ø±ê
			if (s.matches("[ADWS][0-9]{1,2}")) {
				char ch = s.charAt(0);
				int d = Integer.valueOf(s.substring(1));
				if (ch == 'A')
					x -= d;
				if (ch == 'D')
					x += d;
				if (ch == 'W')
					y += d;
				if (ch == 'S')
					y -= d;
			}
		}

		System.out.println(x + "," + y);
	}

	public static boolean isDigit(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
}
