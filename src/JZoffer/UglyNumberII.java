package JZoffer;

public class UglyNumberII {

	public static void main(String[] args) {
		UglyNumberII m = new UglyNumberII();
		System.out.println(m.nthUglyNumber(11));
	}

	public int min(int a, int b, int c) {
		int min = 0;
		min = Math.min(a, b);
		min = Math.min(min, c);
		return min;
	}

	public int nthUglyNumber(int n) {
		if (n < 0)
			return 0;

		int[] res = new int[n];
		res[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < n; i++) {
			res[i] = Math.min(Math.min(res[p2] * 2, res[p3] * 3), res[p5] * 5);
			// 这三个条件可能会重合，应该是并列的，不是取其一的
			if (res[i] == res[p2] * 2)
				p2++;
			if (res[i] == res[p3] * 3)
				p3++;
			if (res[i] == res[p5] * 5)
				p5++;
		}
		return res[n - 1];
	}
}
