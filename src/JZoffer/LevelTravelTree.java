package JZoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTravelTree {

	public static void main(String[] args) {

	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			res.add(node.val);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return res;

	}

}
