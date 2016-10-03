package JZoffer;

/**
 * �ַ�����ȫ����
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
		// �ַ����������ظ�
		char[] ch = str.toCharArray();
		Arrays.sort(ch);// ����
		permutation(ch, 0, res);
		// ���ڽ��Ҫ������ֵ��򣬻���Ҫ�Խ����������
		Collections.sort(res);
		return res;
	}

	// �̶�һ���������ȫ����
	private void permutation(char[] ch, int start, ArrayList<String> res) {

		if (start == ch.length - 1)
			res.add(new String(ch));
		for (int i = start; i < ch.length; i++) {
			if (i == start || ch[i] != ch[start]) {// ������ͬ�ľͲ��ý�����
				swap(start, i, ch);
				permutation(ch, start + 1, res);
				swap(start, i, ch);// ������һ��ʱ��Ҫ����ԭ��ֵ
			}

		}

	}

	public void swap(int i, int j, char[] ch) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
}
