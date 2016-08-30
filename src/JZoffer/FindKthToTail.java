package JZoffer;

class ListNode {// 包内可见的类
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
	 * 需要注意以下几点： 1. 空链表； 2. k=0 3. k大于链表长度
	 */
	/**
	 * 需要注意以下几点： 1. 空链表； 2. k=0 3. k大于链表长度
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
