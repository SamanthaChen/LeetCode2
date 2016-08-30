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
			// 如果当前元素还不在栈首，把入栈序列添加一遍
			while (stack.isEmpty() || stack.peek() != popA[pop]) {
				if (push == len)
					break;// 压入栈的序列已经遍历完了,跳出循环
				else {
					stack.push(pushA[push]);
					push++;
				}

			}
			// 两种情况会进行到这一步：1.push到了尽头
			// 2. 栈首满足
			if (stack.peek() != popA[pop]) {
				return false;
			} else {
				stack.pop();// 不会出现空吗？
				pop++;
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
