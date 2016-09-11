package HuaWei;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.nextLine().trim();
			System.out.println(isMask(s));
		}
		sc.close();
	}

	private static Object toBinaryString(String s) {
		int n = Integer.valueOf(s);
		int flag = 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 8; i++) {
			int digit = (flag & n) == 0 ? 0 : 1;
			sb.append(digit);
			flag = flag << 1;
		}
		return sb.toString();
	}

	// �Ƿ��ǺϷ���IP
	public static boolean isValidIP(String ip) {
		if (ip == null || "".equals(ip)) {
			return false;
		}
		if (ip.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$")) {
			String[] str = ip.split("\\.");
			for (String ss : str) {
				if (Integer.valueOf(ss) < 0 || Integer.valueOf(ss) > 256)
					return false;
			}
			return true;
		}
		return false;
	}

	// �ж��Ƿ��ǺϷ����������룺ǰ��ȫ��1������ȫ��0
	public static boolean isMask(String ip) {
		if (ip == null || "".equals(ip)) {
			return false;
		}
		if (ip.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$")) {
			// ת��Ϊ������
			String[] str = ip.split("\\.");
			StringBuffer sb = new StringBuffer();
			for (String i : str) {
				sb.append(toBinaryString(i));
			}
			System.out.println(sb.toString());
			// �ж��Ƿ���һ��0����һ��1(�ҵ��ַ���ת���Ƿ���)
			if (sb.lastIndexOf("1") + 1 == sb.indexOf("0"))
				return true;
			else
				return false;

		}
		return false;
	}
}