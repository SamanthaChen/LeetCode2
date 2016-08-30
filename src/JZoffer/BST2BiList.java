package JZoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST2BiList {
	/*
	 * * �ȸ���1,2,4,5,10,11,3,6,13,7 �и���4,2,10,5,11,1,6,13,3,7
	 * �����4,10,11,5,2,13,6,7,3,1
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

		TreeNode root = list.get(1);// 1�Ǹ��ڵ�
		BST2BiList m = new BST2BiList();
		TreeNode head = m.Convert2(root);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.right;
		}

	}

	/**
	 * ����ⷨ�Ǽ�֦offer��
	 */
	TreeNode lastNode = null;// �����ó�ȫ�ֱ�����

	public TreeNode Convert(TreeNode root) {

		convert(root);
		// �������һ���ڵ��ҵ�ͷ���
		while (lastNode != null && lastNode.left != null)
			lastNode = lastNode.left;

		return lastNode;

	}

	private void convert(TreeNode root) {
		if (root == null)
			return;

		// �ȵ������
		convert(root.left);

		// ���м�ڵ���������
		root.left = lastNode;

		// �����������ǿ�
		if (lastNode != null)
			lastNode.right = root;

		lastNode = root;
		// �����ұ�,�����lastNode���ұ������ͷ����˼
		convert(root.right);
	}

	// ����������޸�ָ��
	public TreeNode Convert2(TreeNode root) {

		if (root == null)
			return null;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		TreeNode cur;
		TreeNode p = root;
		boolean isFirst = true;// ������������ߵĽڵ�û��ǰ�ڵ㣬�����һ����־
		while (p != null || !stack.isEmpty()) {
			while (p != null) {// ����������
				stack.push(p);
				p = p.left;
			}
			cur = stack.pop();
			if (isFirst) {
				root = cur;// ��������ͷ
				isFirst = false;
			} else {
				cur.left = pre;
				pre.right = cur;
			}
			// ָ�����
			pre = cur;
			p = cur.right;
		}
		return root;
	}

}
