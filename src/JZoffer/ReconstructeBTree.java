package JZoffer;

public class ReconstructeBTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		ReconstructeBTree m = new ReconstructeBTree();
		TreeNode root = m.reConstructBinaryTree(pre, in);
		m.preTraver(root);

	}

	// �ݹ�
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length < 0 || in.length < 0)
			return null;
		return helper(pre, in, 0, pre.length - 1, 0, in.length - 1);

	}

	// �ݹ���ӳ���
	public TreeNode helper(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {

		// �ݹ��������
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// ǰ��ĵ�һ���Ǹ��ڵ�
		TreeNode root = new TreeNode(pre[preStart]);

		// ���ҵ����������е�λ��
		int i = inStart;
		for (; i <= inEnd; i++) {
			if (pre[preStart] == in[i])
				break;
		}
		// ����������
		int leftlen = i - inStart;
		// ����������
		root.left = helper(pre, in, preStart + 1, preStart + leftlen, inStart, i - 1);
		// ����������
		root.right = helper(pre, in, preStart + leftlen + 1, preEnd, i + 1, inEnd);

		return root;

	}

	public void preTraver(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preTraver(root.left);
			preTraver(root.right);
		} else
			return;

	}
}
