package JZoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST2BiList {
	/*
	 * * 先根：1,2,4,5,10,11,3,6,13,7 中跟：4,2,10,5,11,1,6,13,3,7
	 * 后跟：4,10,11,5,2,13,6,7,3,1
	 */

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (int i = 0; i < nums.length; i++)
			list.add(new TreeNode(nums[i]));

		list.get(1).left = list.get(2);
		list.get(1).right = list.get(3);

		list.get(2).left = list.get(4);
		list.get(2).right = list.get(5);

		list.get(3).left = list.get(6);
		list.get(3).right = list.get(7);

		list.get(5).left = list.get(10);
		list.get(5).right = list.get(11);

		list.get(6).right = list.get(13);

		TreeNode root = list.get(1);// 1是根节点
		BST2BiList m = new BST2BiList();
		TreeNode head = m.Convert2(root);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.right;
		}

	}

	/**
	 * 这个解法是剪枝offer的
	 */
	TreeNode lastNode = null;// 得设置成全局变量！

	public TreeNode Convert(TreeNode root) {

		convert(root);
		// 根据最后一个节点找到头结点
		while (lastNode != null && lastNode.left != null)
			lastNode = lastNode.left;

		return lastNode;

	}

	private void convert(TreeNode root) {
		if (root == null)
			return;

		// 先调整左边
		convert(root.left);

		// 将中间节点和左边连接
		root.left = lastNode;

		// 可能左子树是空
		if (lastNode != null)
			lastNode.right = root;

		lastNode = root;
		// 调整右边,这里的lastNode是右边链表的头的意思
		convert(root.right);
	}

	// 中序遍历，修改指针
	public TreeNode Convert2(TreeNode root) {

		if (root == null)
			return null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode cur;
		TreeNode p = root;
		boolean isFirst = true;// 由于链表最左边的节点没有前节点，因此设一个标志
		while (p != null || !stack.isEmpty()) {
			while (p != null) {// 遍历左子树
				stack.push(p);
				p = p.left;
			}
			cur = stack.pop();
			if (isFirst) {
				root = cur;// 保存链表头
				isFirst = false;
			} else {
				cur.left = pre;
				pre.right = cur;
			}
			// 指针后移
			pre = cur;
			p = cur.right;
		}
		return root;
	}

}
