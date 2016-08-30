package JZoffer;

public class MergeLinkedList {
	// 递归的
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		ListNode head = null;
		if (list1.val < list2.val) {
			head = list1;
			head.next = Merge(list1.next, list2);
		} else {
			head = list2;
			head.next = Merge(list1, list2.next);
		}
		return head;
	}

	// 迭代的
	public ListNode Merge2(ListNode list1, ListNode list2) {
		ListNode cur = new ListNode(0);
		ListNode head = cur;// 保存最初的指针
		// 两个都不为空
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}
		// 至少其中一个为空
		if (list1 != null)
			cur.next = list1;
		if (list2 != null)
			cur.next = list2;
		return head.next;
	}
}
