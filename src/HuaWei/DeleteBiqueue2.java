package HuaWei;

import java.util.Scanner;

//������ʵ����
public class DeleteBiqueue2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			// ��ʼ������
			ListNode p = new ListNode(0);
			ListNode root = p;
			for (int i = 1; i < n; i++) {
				p.next = new ListNode(i);
				p = p.next;
			}
			p.next = root;// ��β���
			// ɾ������,��ɂ��hһ��
			for (int i = 0; i < n - 1; i++) {
				root = root.next;
				root.next = root.next.next;
				root = root.next;
			}
			System.out.println(root.val);

		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {

	}

	ListNode(int n) {
		this.val = n;
	}

}
