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

	// 递归
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length < 0 || in.length < 0)
			return null;
		return helper(pre, in, 0, pre.length - 1, 0, in.length - 1);

	}

	// 递归的子程序
	public TreeNode helper(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {

		// 递归结束条件
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// 前序的第一个是根节点
		TreeNode root = new TreeNode(pre[preStart]);

		// 先找到根在中序中的位置
		int i = inStart;
		for (; i <= inEnd; i++) {
			if (pre[preStart] == in[i])
				break;
		}
		// 左子树长度
		int leftlen = i - inStart;
		// 构建左子树
		root.left = helper(pre, in, preStart + 1, preStart + leftlen, inStart, i - 1);
		// 构建右子树
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
