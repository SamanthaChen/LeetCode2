package JZoffer;

/**
 * 字符串的全排列
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PermutationString {

	public static void main(String[] args) {
		String str = "aab";
		PermutationString m = new PermutationString();
		ArrayList<String> list = m.Permutation(str);
		for (String l : list)
			System.out.println(l);

	}

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		// 字符串可能有重复
		char[] ch = str.toCharArray();
		Arrays.sort(ch);// 排序
		permutation(ch, 0, res);
		// 由于结果要求的是字典序，还需要对结果进行排序
		Collections.sort(res);
		return res;
	}

	// 固定一个，后面的全排列
	private void permutation(char[] ch, int start, ArrayList<String> res) {

		if (start == ch.length - 1)
			res.add(new String(ch));
		for (int i = start; i < ch.length; i++) {
			if (i == start || ch[i] != ch[start]) {// 两个相同的就不用交换了
				swap(start, i, ch);
				permutation(ch, start + 1, res);
				swap(start, i, ch);// 返回上一层时候要保持原来值
			}

		}

	}

	public void swap(int i, int j, char[] ch) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
}
