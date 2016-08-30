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
		// 当前节点加入路径
		path.add(root.val);
		// 到达根节点判断是不是达到目标值
		if (root.left == null && root.right == null && root.val == target) {
			res.add(new ArrayList<Integer>(path));
		}
		// 没到根节点就继续往左右子树判断
		if (root.left != null)
			res.addAll(findPath(root.left, target - root.val, path));
		if (root.right != null)
			res.addAll(findPath(root.right, target - root.val, path));

		// 返回到父节点时候需要删除掉当前节点
		path.remove(path.size() - 1);
		return res;

	}

}
