package JZoffer;

import java.util.Arrays;

public class ReOrderArray {

	public static void main(String[] args) {
		ReOrderArray m = new ReOrderArray();
		int[] a = { 2, 4, 6, 1, 3, 5, 7 };
		m.reOrderArray2(a);
		System.out.println(Arrays.toString(a));
	}

	// 两个指针进行交换，但是相对位置会变
	public void reOrderArray(int[] array) {
		int p1 = 0;
		int p2 = array.length - 1;
		while (p1 < p2) {
			// 向前移动p1知道遇到第一个偶数
			while (p1 < p2 && array[p1] % 2 == 1)
				p1++;
			// 向后移动p1知道遇到第一个奇数
			while (p1 < p2 && array[p2] % 2 == 0)
				p2--;

			int temp = array[p2];
			array[p2] = array[p1];
			array[p1] = temp;

			p1++;
			p2--;
		}
	}

	// 插入排序
	public void reOrderArray2(int[] array) {
		// 假设前面i-1是排好序的，
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			if (tmp % 2 == 1) {// 遇到奇数往前面有序的插入
				// 偶数往后挪，奇数插入到偶数前面
				int j = i - 1;
				while (j >= 0 && array[j] % 2 == 0) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = tmp;

			}
		}
	}

}
