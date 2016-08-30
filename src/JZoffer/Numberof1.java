package JZoffer;

import java.util.Scanner;

public class Numberof1 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			System.out.println(NumberOf1II(cin.nextInt()));
		}
		cin.close();

	}

	// 第一种解法，需要循环32次
	public static int NumberOf1(int n) {
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
	}

	// 第二种解法
	public static int NumberOf1II(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);// 这个等式每次减少一个1
		}
		return count;
	}

	// 求一个数的n次方
	/**
	 * 1.全面考察指数的正负、底数是否为零等情况。 2.写出指数的二进制表达，例如13表达为二进制1101。 3.举例:10^1101 =
	 * 10^0001*10^0100*10^1000。 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
	 */
	public double Power(double base, int n) {
		double res = 1, curr = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("分母不能为0");
			exponent = -n;
		} else {// n==0
			return 1;// 0的0次方
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= curr;
			curr *= curr;// 翻倍
			exponent >>= 1;// 右移一位
		}
		return n >= 0 ? res : (1 / res);
	}

}
