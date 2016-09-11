package HuaWei;

import java.util.Scanner;

public class DeleteMinCountChar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			int[] count = new int[26];
			// 统计频率
			for (int i = 0; i < s.length(); i++) {
				count[s.charAt(i) - 'a']++;
			}
			// 遍历一遍找出现次数最小的
			int mincount = s.length();
			for (int i = 0; i < s.length(); i++) {
				if (count[s.charAt(i) - 'a'] > 0 && count[s.charAt(i) - 'a'] < mincount) {
					mincount = count[s.charAt(i) - 'a'];
				}
			}
			// 不添加频率最小的
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				if (count[s.charAt(i) - 'a'] > mincount)
					sb.append(s.charAt(i));
			}
			if (sb == null || sb.length() <= 0) {
				System.out.println("");
			} else {
				System.out.println(sb.toString());
			}
		}
		sc.close();
	}

}
