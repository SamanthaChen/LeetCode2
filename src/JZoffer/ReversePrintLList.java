package JZoffer;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePrintLList {

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

	}

	// µ›πÈ
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (listNode != null) {
			if (listNode.next != null) {
				res.addAll(printListFromTailToHead(listNode.next));
			}
			res.add(listNode.val);
		}
		return res;
	}

	// ”√’ª
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}
}
