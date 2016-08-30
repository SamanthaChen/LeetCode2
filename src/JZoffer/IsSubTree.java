package JZoffer;

//������ô��ô�ã���
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
			if (!res) // ���ڵ㲻ƥ�䣬����������
				res = HasSubtree(root1.left, root2);
			if (!res) // ������Ҳ��ƥ�䣬����������
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
		// ��������������������ͬ�ṹ
		return matchStruct(root1.left, root2.left) && matchStruct(root1.right, root2.right);
	}

}
