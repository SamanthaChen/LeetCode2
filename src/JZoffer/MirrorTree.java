package JZoffer;

import java.util.Stack;

public class MirrorTree {

	public static void main(String[] args) {

	}

	// 递归实现
	public void Mirror(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		// 交换左右子树
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		Mirror(root.left);
		Mirror(root.right);
	}

	// 非递归实现
	public void Mirror2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);// 栈里面放的是没有被访问的数据，类似于前序遍历
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null || node.right != null) {
				TreeNode tmp = node.left;
				node.left = node.right;
				node.right = tmp;
			}
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}

}
