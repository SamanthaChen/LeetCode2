package a360;

import java.util.Scanner;

/**
 * ���������Ӵ������С�
 * 
 */
public class IndexOfSubstr3 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);

		while (reader.hasNext()) {
			String seq = reader.next();
			String first = reader.next();
			String second = reader.next();

			boolean forward = false;
			boolean backward = false;

			// forward
			int firstIndex = getFirstIndex(seq, first);
			if (-1 != firstIndex) {
				String sub = seq.substring(firstIndex + first.length(), seq.length());
				int secondIndex = getFirstIndex(sub, second);
				if (secondIndex != -1) {
					forward = true;
				}
			}
			// backward
			StringBuilder sb = new StringBuilder(seq);
			sb.reverse();
			seq = sb.toString();
			firstIndex = getFirstIndex(seq, first);
			if (-1 != firstIndex) {
				String sub = seq.substring(firstIndex + first.length(), seq.length());
				int secondIndex = getFirstIndex(sub, second);
				if (secondIndex != -1) {
					backward = true;
				}
			}

			if (forward && backward) {
				System.out.println("both");
			} else if (forward) {
				System.out.println("forward");
			} else if (backward) {
				System.out.println("backward");
			} else {
				System.out.println("invalid");
			}
		}
		reader.close();
	}

	public static int getFirstIndex(String haystack, String needle) {
		int n = needle.length(), m = haystack.length();
		int[] key = new int[n];
		for (int i = 1; i < n; i++) {
			int j = key[i - 1];// j��ʾ��һ��ƥ���ǰ��׺���ȣ�Ҳ��ʾ��һ��ƥ��Ӧ�ÿ�ʼ��λ�ã�����һ�ε�ǰ׺����һ���ַ�
			while (j != 0 && (needle.charAt(i) != needle.charAt(j))) {// j ==
																		// 0����ʾ��һ��ƥ�䳤��Ϊ0��������һ��Ӧ�ôӵ�0���ַ���ʼ
				j = key[j - 1];
			}
			key[i] = j + (needle.charAt(i) == needle.charAt(j) ? 1 : 0);
		}

		int i = 0, j = 0;
		while (i < n && j < m) {
			if (i > 0 && needle.charAt(i) != haystack.charAt(j))
				i = key[i - 1];
			else {
				i += (needle.charAt(i) == haystack.charAt(j) ? 1 : 0);
				j++;
			}
		}
		return (i == n ? j - n : -1);
	}

	// test this class
	public static void main(String[] args) {
		IndexOfSubstr3.solve();
	}
}
