package iQiyi;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目例子： 3287956401 4130279856 输出： yes no
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			int[] array = new int[10];
			for (int i = 0; i < 10; i++) {
				array[i] = Integer.valueOf(s.charAt(i));
			}

			Stack<Integer> stack = new Stack<Integer>();
			int parray = 0;
			int pnum = 0;
			boolean flag = true;
			while (parray < 10) {
				if (stack.isEmpty() || stack.peek() < array[parray]) {
					stack.push(pnum);
					pnum++;
				} else if (stack.peek() == array[parray]) {
					stack.pop();
					parray++;
				} else if (stack.peek() > array[parray]) {
					LinkedList<Integer> list = new LinkedList<Integer>();
					while (!stack.isEmpty() && stack.peek() >= array[parray]) {
						list.add(0, stack.pop());
					}
					if (list.size() + parray >= 10) {
						flag = false;
						break;
					}
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i) != array[parray]) {
							flag = false;
							break;
						}
						parray++;
					}
				}

			}
			if (flag == false) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
		scanner.close();

	}

}
