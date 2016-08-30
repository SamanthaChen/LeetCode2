package JZoffer;

public class ReverseLinkedList {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * */
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur = head;
		ListNode pre = null;
		ListNode nxt = null;
		while (cur != null) {
			nxt = cur.next;
			cur.next = pre;
			// ÷∏’Î∫Û“∆
			pre = cur;
			cur = nxt;
		}
		return pre;
	}

}
