package JZoffer;

public class NumberOfDigitalOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 1�� �����iλ���������󣬴�1��ʼ��ţ��ϵ�����Ϊ0��
	 * ���iλ���ܳ���1�Ĵ����ɸ���λ��������û�и�λ���Ӹ�λΪ0�������ڸ���λ����X��ǰλ����Ȩ��10i-1�� 2.
	 * 
	 * 2�������iλ�ϵ�����Ϊ1�����iλ�Ͽ��ܳ���1�Ĵ��������ܸ���λӰ�죬���ܵ�λӰ�죨��û�е�λ���ӵ�λΪ0����
	 * ���ڸ���λ����X��ǰλ����Ȩ��10i-1+����λ����+1���� 3.
	 * 
	 * 3�������iλ�ϵ����ִ���1�����iλ�Ͽ��ܳ���1�Ĵ������ɸ���λ��������û�и�λ���Ӹ�λΪ0����
	 * ���ڣ�����λ����+1��X��ǰλ����Ȩ��10i-1��
	 * 
	 */
	public int countDigitOne(int n) {
		return n;

	}

	public long CountOne2(long n) {
		long count = 0;
		long i = 1;// ���ұ߿�ʼ��iλ
		long current = 0, after = 0, before = 0;
		while ((n / i) != 0) {
			current = (n / i) % 10;// ��iλ����ֵ
			before = n / (i * 10);// iλ��߸�λ����ֵ
			after = n - (n / i) * i; // iλ�ұߵ�λ����ֵ

			if (current > 1)
				count = count + (before + 1) * i;
			else if (current == 0)
				count = count + before * i;
			else if (current == 1)
				count = count + before * i + after + 1;

			i = i * 10;
		}
		return count;
	}

	public int NumberOfXBetween1AndN_Solution(int n, int x) {
		if (n < 0 || x < 1 || x > 9)
			return 0;
		int high, low, curr, tmp, i = 1;
		high = n;
		int total = 0;
		while (high != 0) {
			high = n / (int) Math.pow(10, i);// ��ȡ��iλ�ĸ�λ
			tmp = n % (int) Math.pow(10, i);
			curr = tmp / (int) Math.pow(10, i - 1);// ��ȡ��iλ
			low = tmp % (int) Math.pow(10, i - 1);// ��ȡ��iλ�ĵ�λ
			if (curr == x) {
				total += high * (int) Math.pow(10, i - 1) + low + 1;
			} else if (curr < x) {
				total += high * (int) Math.pow(10, i - 1);
			} else {
				total += (high + 1) * (int) Math.pow(10, i - 1);
			}
			i++;
		}
		return total;
	}

}
