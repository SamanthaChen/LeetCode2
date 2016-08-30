package JZoffer;

import java.util.ArrayList;

public class KLeastNumber {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 1, 6, 2, 7, 3, 8 };
		KLeastNumber m = new KLeastNumber();
		System.out.println(m.GetLeastNumbers_Solution2(nums, 6));
	}

	/**
	 * ��һ�֣����ŵ�partition���뷨
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> output = new ArrayList<Integer>(k);
		if (input == null || k > input.length || input.length <= 0 || k <= 0)
			return output;

		int start = 0;
		int end = input.length - 1;
		// start��index�Ǳ�input[index]С��
		// index��end�Ǳ�input[index]���
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, start, end);
			} else {
				start = index + 1;
				index = partition(input, start, end);
			}
		}
		// ��ǰk�����
		for (int i = 0; i < k; i++)
			output.add(input[i]);
		return output;

	}

	private int partition(int[] a, int low, int high) {
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	/**
	 * �ڶ��ֽⷨ���������Ѵ�k����С��
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {

		ArrayList<Integer> output = new ArrayList<Integer>(k);
		if (input == null || k > input.length || input.length <= 0 || k <= 0)
			return output;
		// 1.����k����������
		for (int i = k / 2 - 1; i >= 0; i--)
			adjustHeap(input, i, k - 1);
		// 2. ������������ֵ�����
		int temp = 0;
		for (int i = k; i < input.length; i++) {
			if (input[i] < input[0]) {
				// ������������������
				temp = input[0];
				input[0] = input[i];
				input[i] = temp;
				adjustHeap(input, 0, k - 1);
			}
		}
		// 3. ���ǰk����С��
		for (int i = 0; i < k; i++)
			output.add(input[i]);
		return output;

	}

	public void adjustHeap(int[] a, int parent, int end) {
		int temp = a[parent];
		int child = 2 * parent + 1;

		// ���Žϴ������µ���
		while (child <= end) {
			// �����Һ�������
			if (child < end && a[child + 1] > a[child]) {
				child = child + 1;
			}
			// ������
			if (temp < a[child]) {// ע��������temp < a[child]����a[p]<a[c]
				a[parent] = a[child];
				// ָ�����
				parent = child;
				child = 2 * child + 1;
			} else {
				break;
			}
		}
		a[parent] = temp;
	}
}
