package HuaWei;

import java.util.Scanner;

public class IPCout {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Acount = 0;
		int Bcount = 0;
		int Ccount = 0;
		int Dcount = 0;
		int Ecount = 0;
		int error = 0;
		int privateIP = 0;
		while (sc.hasNext()) {
			String s = sc.nextLine();
			String[] ss = s.split("~");
			String ip = ss[0];
			String maskip = ss[1];
			// �ж��Ƿ��ǺϷ���IP������������
			if (!isValidIP(ip) || !isValidIP(maskip)) {
				error++;
				continue;
			}
			// �ж������Ƿ����
			if (!isMask(maskip)) {
				error++;
				continue;
			}
			// ��ip�ַ���תΪ����,�����19..0.�������
			int[] ipArray = new int[4];
			String[] str = ip.split("\\.");
			for (int i = 0; i < 4; i++) {
				ipArray[i] = Integer.valueOf(str[i]);
			}
			// �ж�A-E���ַ
			if (ipArray[0] >= 1 && ipArray[0] <= 126)
				Acount++;
			if (ipArray[0] >= 128 && ipArray[0] <= 191)
				Bcount++;
			if (ipArray[0] >= 192 && ipArray[0] <= 223)
				Ccount++;
			if (ipArray[0] >= 224 && ipArray[0] <= 239)
				Dcount++;
			if (ipArray[0] >= 240 && ipArray[0] <= 255)
				Ecount++;
			// ˽����ַ
			if (ipArray[0] == 10 || (ipArray[0] == 172 && ipArray[1] >= 16 && ipArray[1] <= 31)
					|| (ipArray[0] == 192 && ipArray[1] == 168))
				privateIP++;

		}
		sc.close();
		System.out.println(
				Acount + " " + Bcount + " " + Ccount + " " + Dcount + " " + Ecount + " " + error + " " + privateIP);

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
			// System.out.println(sb.toString());
			// �ж��Ƿ���һ��0����һ��1
			if (sb.lastIndexOf("1") + 1 == sb.indexOf("0"))
				return true;
			else
				return false;

		}
		return false;
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

}
