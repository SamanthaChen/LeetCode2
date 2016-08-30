package HuaWei;

import java.util.Scanner;

class Node {
	int data;
	Node next;

}

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			Node root = new Node();
			root.data = 0;
			Node rootNode = root;
			for (int i = 1; i < num; i++) {
				Node node = new Node();
				node.data = i;
				root.next = node;
				root = node;
			}
			root.next = rootNode;

			while (rootNode.next != rootNode) {
				root = rootNode.next.next;
				rootNode.next.next = root.next;
				rootNode = root.next;
				root = null;
			}

			System.out.println(rootNode.data);
		}
		sc.close();
	}
}