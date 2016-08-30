package JZoffer;

import java.util.ArrayList;

public class KLeastNumber {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 1, 6, 2, 7, 3, 8 };
		KLeastNumber m = new KLeastNumber();
		System.out.println(m.GetLeastNumbers_Solution2(nums, 6));
	}

	/**
	 * 第一种：快排的partition的想法
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> output = new ArrayList<Integer>(k);
		if (input == null || k > input.length || input.length <= 0 || k <= 0)
			return output;

		int start = 0;
		int end = input.length - 1;
		// start到index是比input[index]小的
		// index到end是比input[index]大的
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
		// 将前k个输出
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
	 * 第二种解法，利用最大堆存k个最小的
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {

		ArrayList<Integer> output = new ArrayList<Integer>(k);
		if (input == null || k > input.length || input.length <= 0 || k <= 0)
			return output;
		// 1.构建k个数的最大堆
		for (int i = k / 2 - 1; i >= 0; i--)
			adjustHeap(input, i, k - 1);
		// 2. 遍历后面的数字调整堆
		int temp = 0;
		for (int i = k; i < input.length; i++) {
			if (input[i] < input[0]) {
				// 交换两个数，调整堆
				temp = input[0];
				input[0] = input[i];
				input[i] = temp;
				adjustHeap(input, 0, k - 1);
			}
		}
		// 3. 输出前k个最小的
		for (int i = 0; i < k; i++)
			output.add(input[i]);
		return output;

	}

	public void adjustHeap(int[] a, int parent, int end) {
		int temp = a[parent];
		int child = 2 * parent + 1;

		// 沿着较大孩子向下调整
		while (child <= end) {
			// 找左右孩子最大的
			if (child < end && a[child + 1] > a[child]) {
				child = child + 1;
			}
			// 调整树
			if (temp < a[child]) {// 注意这里是temp < a[child]不是a[p]<a[c]
				a[parent] = a[child];
				// 指针后移
				parent = child;
				child = 2 * child + 1;
			} else {
				break;
			}
		}
		a[parent] = temp;
	}
}
