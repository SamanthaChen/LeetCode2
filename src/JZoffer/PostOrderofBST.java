package JZoffer;

/**
 * ȷ��һ�������ǲ��Ƕ����������ĺ�������
 */
public class PostOrderofBST {

	public static void main(String[] args) {
		// int[] nums = { 5, 7, 6, 9, 11, 10, 8 };
		// int[] nums2 = { 7, 4, 6, 5 };
		int[] nums3 = { 4, 6, 7, 5 };
		// int[] nums4 = { 1, 2, 3, 4, 5 };
		PostOrderofBST m = new PostOrderofBST();
		System.out.println(m.VerifySquenceOfBST(nums3));
	}

	public boolean VerifySquenceOfBST(int[] sequence) {

		return helper(sequence, 0, sequence.length - 1);
	}

	public boolean helper(int[] a, int start, int end) {
		if (a == null || start > end)
			return false;
		if (end - start <= 1)
			return true;// ֻ��һ�����ڵ�,����ֻ�������㶼�ǿ��Եģ�
		// ���������붼С�ڸ�
		int i = start;
		for (; i < end; i++) {
			if (a[i] > a[end])
				break;
		}
		// ��������������ڸ�
		for (int j = i; j < end; j++) {
			if (a[j] < a[end])
				return false;
		}
		// ����������Ҳ��BST
		boolean left = true;
		if (i > start) // ˵������������������Ĭ��Ϊtrue
			left = helper(a, start, i - 1);
		// ������������BST
		boolean right = true;
		if (i < end) // ˵������������������Ĭ��Ϊtrue
			right = helper(a, i, end - 1);

		return (left && right);

	}
}
