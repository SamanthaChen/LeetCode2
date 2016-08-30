package JZoffer;

import java.util.Stack;

public class StackPopOrder {

	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 3, 2, 1 };
		StackPopOrder m = new StackPopOrder();
		System.out.println(m.IsPopOrder(push, pop));

	}

	public boolean IsPopOrder(int[] pushA, int[] popA) {

		Stack<Integer> stack = new Stack<Integer>();
		int push = 0;
		int pop = 0;
		int len = pushA.length;
		while (pop < len) {
			// �����ǰԪ�ػ�����ջ�ף�����ջ�������һ��
			while (stack.isEmpty() || stack.peek() != popA[pop]) {
				if (push == len)
					break;// ѹ��ջ�������Ѿ���������,����ѭ��
				else {
					stack.push(pushA[push]);
					push++;
				}

			}
			// �����������е���һ����1.push���˾�ͷ
			// 2. ջ������
			if (stack.peek() != popA[pop]) {
				return false;
			} else {
				stack.pop();// ������ֿ���
				pop++;
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
