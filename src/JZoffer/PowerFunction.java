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

	// ����һ������power
	/**
	 * ��Ҫ���ǵģ� 1. base ==0�� 2. ָ��<0�� 3. ��θ���Ч
	 * 
	 * @throws Exception
	 */
	public double Power(double base, int exponent) throws Exception {
		// ��base=0ʱ��
		if (equal(base, 0.0) && exponent < 0) {
			throw new Exception("0�ĸ�������û������");
		}
		// �ж�exponet��С
		if (exponent == 0)
			return 1;
		int n = Math.abs(exponent);
		// ����mi
		double res = Power(base, n >> 1);
		res *= res;// ����
		if ((n & 1) == 1)
			res *= base;

		return exponent >= 0 ? res : (1 / res);

	}

	// ����double����ֱ���õȺűȽ���ȣ���Ҫ�Լ�дһ��
	public static boolean equal(double a, double b) {
		if ((a - b > -0.0000001) && (a - b < 0.0000001))
			return true;
		else
			return false;
	}

}
