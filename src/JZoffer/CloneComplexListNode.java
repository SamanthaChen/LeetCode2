package JZoffer;

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}

	public void print() {
		RandomListNode head = this;
		RandomListNode n = head;
		System.out.println("next关系：");
		while (n != null) {
			System.out.print(n.label + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("random关系：");
		n = head;
		while (n != null) {
			String s = "";
			if (n.random != null)
				s = Integer.toString(n.random.label);
			else
				s = "null";
			System.out.print(s + "->");
			n = n.next;
		}
		System.out.println("");

	}
}

public class CloneComplexListNode {

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1.random = n3;
		n2.random = n4;
		n1.print();
		CloneComplexListNode m = new CloneComplexListNode();
		RandomListNode copy = m.Clone(n1);
		copy.print();

	}

	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null)
			return null;
		// 第一步：复制每个节点，复制的节点放在原来节点后面
		RandomListNode cur = pHead;
		RandomListNode curCopy;
		RandomListNode nxt;
		while (cur != null) {
			// 复制
			curCopy = new RandomListNode(cur.label);
			nxt = cur.next;
			// 插入
			curCopy.next = cur.next;
			cur.next = curCopy;
			// 指针后移
			cur = nxt;
		}
		// 第二步：复制随机链接
		cur = pHead;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;

		}
		// 第三步：撕裂为两个链表
		cur = pHead;
		RandomListNode pHeadCopy = cur.next;
		while (cur != null) {
			curCopy = cur.next;// 复制值
			cur.next = curCopy.next;
			// 可能出现空指针
			if (cur.next != null)
				curCopy.next = cur.next.next;
			else
				curCopy.next = null;
			// 指针后移
			cur = cur.next;
		}
		return pHeadCopy;
	}
}
