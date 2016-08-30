package JZoffer;

import java.util.ArrayList;

public class TreePathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		return findPath(root, target, new ArrayList<Integer>());

	}

	private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target, ArrayList<Integer> path) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null && target == 0)
			return res;
		// ��ǰ�ڵ����·��
		path.add(root.val);
		// ������ڵ��ж��ǲ��ǴﵽĿ��ֵ
		if (root.left == null && root.right == null && root.val == target) {
			res.add(new ArrayList<Integer>(path));
		}
		// û�����ڵ�ͼ��������������ж�
		if (root.left != null)
			res.addAll(findPath(root.left, target - root.val, path));
		if (root.right != null)
			res.addAll(findPath(root.right, target - root.val, path));

		// ���ص����ڵ�ʱ����Ҫɾ������ǰ�ڵ�
		path.remove(path.size() - 1);
		return res;

	}

}
