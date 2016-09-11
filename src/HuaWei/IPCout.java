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
			// 判断是否是合法的IP或者子网掩码
			if (!isValidIP(ip) || !isValidIP(maskip)) {
				error++;
				continue;
			}
			// 判断掩码是否错误
			if (!isMask(maskip)) {
				error++;
				continue;
			}
			// 将ip字符串转为数组,会出现19..0.这种情况
			int[] ipArray = new int[4];
			String[] str = ip.split("\\.");
			for (int i = 0; i < 4; i++) {
				ipArray[i] = Integer.valueOf(str[i]);
			}
			// 判断A-E类地址
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
			// 私网地址
			if (ipArray[0] == 10 || (ipArray[0] == 172 && ipArray[1] >= 16 && ipArray[1] <= 31)
					|| (ipArray[0] == 192 && ipArray[1] == 168))
				privateIP++;

		}
		sc.close();
		System.out.println(
				Acount + " " + Bcount + " " + Ccount + " " + Dcount + " " + Ecount + " " + error + " " + privateIP);

	}

	// 是否是合法的IP
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

	// 判断是否是合法的子网掩码：前面全是1，后面全是0
	public static boolean isMask(String ip) {
		if (ip == null || "".equals(ip)) {
			return false;
		}
		if (ip.matches("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$")) {
			// 转换为二进制
			String[] str = ip.split("\\.");
			StringBuffer sb = new StringBuffer();
			for (String i : str) {
				sb.append(toBinaryString(i));
			}
			// System.out.println(sb.toString());
			// 判断是否是一串0跟着一串1
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
