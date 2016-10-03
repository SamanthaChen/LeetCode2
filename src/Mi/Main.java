package Mi;
import java.util.HashMap;
import java.util.Scanner;

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();// n������
			HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
			int first = 0;
			for (int i = 0; i < n;) {
				// ������
				int parentid = scanner.nextInt(); // ���ڵ�
				if (i == 0)
					first = parentid;// ��һ���Ǹ�
				int childid = scanner.nextInt();// �ӽڵ�
				if (!map.containsKey(parentid)) {
					map.put(parentid, new TreeNode(parentid));
					i++;
				}
				if (!map.containsKey(childid)) {
					map.put(childid, new TreeNode(childid));
					i++;
				}
				TreeNode node = map.get(parentid);
				TreeNode child = map.get(childid);

				if (node.left == null) {
					node.left = child;
				} else {
					node.right = child;
				}
			}
			// �����ĸ߶�
			TreeNode tree = map.get(first);
			int res = getHeight(tree);
			System.out.println(res);

		}

		scanner.close();
	}

	private static int getHeight(TreeNode tree) {
		if (tree == null)
			return 0;
		return Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
	}

}
