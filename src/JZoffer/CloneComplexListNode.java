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
		System.out.println("next��ϵ��");
		while (n != null) {
			System.out.print(n.label + "->");
			n = n.next;
		}
		System.out.println("");
		System.out.println("random��ϵ��");
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
		// ��һ��������ÿ���ڵ㣬���ƵĽڵ����ԭ���ڵ����
		RandomListNode cur = pHead;
		RandomListNode curCopy;
		RandomListNode nxt;
		while (cur != null) {
			// ����
			curCopy = new RandomListNode(cur.label);
			nxt = cur.next;
			// ����
			curCopy.next = cur.next;
			cur.next = curCopy;
			// ָ�����
			cur = nxt;
		}
		// �ڶ����������������
		cur = pHead;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;

		}
		// ��������˺��Ϊ��������
		cur = pHead;
		RandomListNode pHeadCopy = cur.next;
		while (cur != null) {
			curCopy = cur.next;// ����ֵ
			cur.next = curCopy.next;
			// ���ܳ��ֿ�ָ��
			if (cur.next != null)
				curCopy.next = cur.next.next;
			else
				curCopy.next = null;
			// ָ�����
			cur = cur.next;
		}
		return pHeadCopy;
	}
}
