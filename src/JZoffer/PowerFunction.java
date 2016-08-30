package JZoffer;

import java.util.Scanner;

public class PowerFunction {

	public static void main(String[] args) throws Exception {
		PowerFunction m = new PowerFunction();
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			double base = cin.nextDouble();
			int n = cin.nextInt();
			System.out.println(m.Power(base, n));
		}
		cin.close();

	}

	// 计算一个数的power
	/**
	 * 需要考虑的： 1. base ==0； 2. 指数<0； 3. 如何更高效
	 * 
	 * @throws Exception
	 */
	public double Power(double base, int exponent) throws Exception {
		// 当base=0时候
		if (equal(base, 0.0) && exponent < 0) {
			throw new Exception("0的负数次幂没有意义");
		}
		// 判断exponet大小
		if (exponent == 0)
			return 1;
		int n = Math.abs(exponent);
		// 计算mi
		double res = Power(base, n >> 1);
		res *= res;// 翻倍
		if ((n & 1) == 1)
			res *= base;

		return exponent >= 0 ? res : (1 / res);

	}

	// 由于double不能直接用等号比较相等，需要自己写一个
	public static boolean equal(double a, double b) {
		if ((a - b > -0.0000001) && (a - b < 0.0000001))
			return true;
		else
			return false;
	}

}
