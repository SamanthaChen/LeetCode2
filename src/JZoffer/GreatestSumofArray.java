package JZoffer;

public class GreatestSumofArray {

	public static void main(String[] args) {
		int[] nums = { 1, -2, 3, 10, -4, 7, 2, -5 };
		GreatestSumofArray m = new GreatestSumofArray();
		System.out.println(m.FindGreatestSumOfSubArray(nums));

	}

	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length < 1)
			return 0;
		int localmax = array[0];// 初始值很重要
		int globalmax = array[0];// 初始值很重要
		for (int i = 1; i < array.length; i++) {
			localmax = localmax < 0 ? array[i] : localmax + array[i];
			globalmax = Math.max(localmax, globalmax);
		}
		return globalmax;
	}
}
