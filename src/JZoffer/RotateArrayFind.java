package JZoffer;

public class RotateArrayFind {

	public static void main(String[] args) {
		int[] a = { 1, 0, 1, 1, 1 };
		RotateArrayFind m = new RotateArrayFind();
		System.out.println(m.minNumberInRotateArray(a));

	}

	public int minNumberInRotateArray(int[] array) {
		int p1 = 0;
		int p2 = array.length - 1;
		int mid = p1;
		while (array[p1] >= array[p2]) {
			if (p2 - p1 == 1) {
				mid = p2;
				break;
			}
			mid = (p1 + p2) / 2;
			// 如果三个数一样的话只能顺序查找
			if (array[p1] == array[p2] && array[mid] == array[p1]) {
				int min = Integer.MAX_VALUE;
				for (int i : array) {
					if (i < min)
						min = i;
				}
				return min;
			}
			// 正常的二分查找
			if (array[mid] >= array[p1])
				p1 = mid;
			else
				p2 = mid;
		}
		return array[mid];
	}
}
