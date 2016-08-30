package JZoffer;

//这题怎么这么久！！
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}

	public String toString() {
		return Integer.toString(this.val);
	}
}

public class IsSubTree {

	public static void main(String[] args) {

	}

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				res = matchStruct(root1, root2);
			}
			if (!res) // 根节点不匹配，往左子树找
				res = HasSubtree(root1.left, root2);
			if (!res) // 左子树也不匹配，往右子树找
				res = HasSubtree(root1.right, root2);

		}
		return res;

	}

	public boolean matchStruct(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 != null)
			return false;
		if (root2 == null)
			return true;
		if (root1.val != root2.val)
			return false;
		// 必须左右子树都具有相同结构
		return matchStruct(root1.left, root2.left) && matchStruct(root1.right, root2.right);
	}

}
