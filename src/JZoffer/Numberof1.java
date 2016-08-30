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

	// ��һ�ֽⷨ����Ҫѭ��32��
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

	// �ڶ��ֽⷨ
	public static int NumberOf1II(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);// �����ʽÿ�μ���һ��1
		}
		return count;
	}

	// ��һ������n�η�
	/**
	 * 1.ȫ�濼��ָ���������������Ƿ�Ϊ�������� 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101�� 3.����:10^1101 =
	 * 10^0001*10^0100*10^1000�� 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
	 */
	public double Power(double base, int n) {
		double res = 1, curr = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("��ĸ����Ϊ0");
			exponent = -n;
		} else {// n==0
			return 1;// 0��0�η�
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= curr;
			curr *= curr;// ����
			exponent >>= 1;// ����һλ
		}
		return n >= 0 ? res : (1 / res);
	}

}
