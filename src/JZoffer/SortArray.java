package JZoffer;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		int[] nums = { 10, 9, 8, 7, 6, 5, 4, 4, 3, 2, 1 };
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));

	}

	// 快排
	private static void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int pivotloc = getMiddle(nums, low, high);
			quickSort(nums, low, pivotloc - 1);
			quickSort(nums, pivotloc + 1, high);

		}

	}

	private static int getMiddle(int[] nums, int low, int high) {
		int key = low + (int) (Math.random() * (high - low + 1));
		int pivot = nums[key];
		// 交换两个数
		int temp = nums[key];
		nums[key] = nums[low];
		nums[low] = temp;

		while (low < high) {
			while (low < high && nums[high] >= pivot)
				high--;
			nums[low] = nums[high];
			while (low < high && nums[low] <= pivot)
				low++;
			nums[high] = nums[low];
		}
		nums[low] = pivot;
		return low;
	}
	// 堆排序

}
