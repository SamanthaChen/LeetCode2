package JZoffer;

import java.util.Scanner;

/*
问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
      从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
      从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
*/
public class ReplaceSpaces {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			StringBuffer s = new StringBuffer(cin.nextLine());
			ReplaceSpaces m = new ReplaceSpaces();
			System.out.println(m.replaceSpace(s));
		}
		cin.close();
	}

	public String replaceSpace(StringBuffer str) {
		// 计算空格数
		int spacecount = 0;
		int len = str.length();// 原来长度
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				spacecount++;
		}
		// 扩展原来字符串长度
		str.setLength(len + spacecount * 2);
		// 从后面开始复制替换
		int p2 = len + spacecount * 2 - 1;
		int p1 = len - 1;
		while (p1 < p2 && p1 >= 0) {
			if (str.charAt(p1) != ' ') {
				str.setCharAt(p2, str.charAt(p1));
				p2--;
				p1--;
			} else {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
				p1--;

			}
		}
		return str.toString();
	}
}
