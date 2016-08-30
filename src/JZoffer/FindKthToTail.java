package JZoffer;

class ListNode {// ���ڿɼ�����
	int val;
	ListNode next = null;

	ListNode(int n) {
		this.val = n;
	}
}

public class FindKthToTail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * ��Ҫע�����¼��㣺 1. ������ 2. k=0 3. k����������
	 */
	/**
	 * ��Ҫע�����¼��㣺 1. ������ 2. k=0 3. k����������
	 */
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k == 0)
			return null;
		ListNode slower = head;
		ListNode faster = head;

		for (int i = 0; i < k - 1; i++) {
			if (faster.next != null)
				faster = faster.next;
			else
				return null;
		}

		while (faster.next != null) {
			faster = faster.next;
			slower = slower.next;
		}

		return slower;
	}
}
