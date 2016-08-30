package JZoffer;

import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */
	Stack<Integer> datastack = new Stack<Integer>();// �����е�ֵ
	Stack<Integer> minstack = new Stack<Integer>();// ����ջ���浱ǰ��Сֵ

	public void push(int node) {
		datastack.push(node);
		if (!minstack.isEmpty()) {
			if (node < minstack.peek()) {
				minstack.push(node);
			} else
				minstack.push(minstack.peek());
		} else {
			minstack.push(node);
		}

	}

	public void pop() {
		datastack.pop();
		minstack.pop();

	}

	public int top() {
		return datastack.peek();
	}

	public int min() {
		return minstack.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.min());

	}

}
