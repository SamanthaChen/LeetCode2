package JZoffer;

public class MajorNum {

	public static void main(String[] args) {

	}

	public int MoreThanHalfNum_Solution(int[] array) {
		int candidate = 0;
		int times = 0;
		for (int i : array) {
			if (times == 0) {
				candidate = i;
				times = 1;
			} else if (i == candidate) {
				times++;
			} else {
				times--;
			}
		}
		// 检查是不是超过一半
		times = 0;
		for (int i : array) {
			if (i == candidate)
				times++;
		}
		return times > (array.length / 2) ? candidate : 0;
	}

}
