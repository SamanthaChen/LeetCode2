package JZoffer;

/**
 * 确定一个数组是不是二叉搜索树的后续序列
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
			return true;// 只有一个根节点,或者只有两个点都是可以的？
		// 左子树必须都小于根
		int i = start;
		for (; i < end; i++) {
			if (a[i] > a[end])
				break;
		}
		// 右子树都必须大于根
		for (int j = i; j < end; j++) {
			if (a[j] < a[end])
				return false;
		}
		// 左子树必须也是BST
		boolean left = true;
		if (i > start) // 说明存在左子树，否则默认为true
			left = helper(a, start, i - 1);
		// 右子树必须是BST
		boolean right = true;
		if (i < end) // 说明存在右子树，否则默认为true
			right = helper(a, i, end - 1);

		return (left && right);

	}
}
