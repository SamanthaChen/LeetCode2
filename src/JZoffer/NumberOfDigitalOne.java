package JZoffer;

public class NumberOfDigitalOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 1、 如果第i位（自右至左，从1开始标号）上的数字为0，
	 * 则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），等于更高位数字X当前位数的权重10i-1。 2.
	 * 
	 * 2、如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），
	 * 等于更高位数字X当前位数的权重10i-1+（低位数字+1）。 3.
	 * 
	 * 3、如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），
	 * 等于（更高位数字+1）X当前位数的权重10i-1。
	 * 
	 */
	public int countDigitOne(int n) {
		return n;

	}

	public long CountOne2(long n) {
		long count = 0;
		long i = 1;// 从右边开始第i位
		long current = 0, after = 0, before = 0;
		while ((n / i) != 0) {
			current = (n / i) % 10;// 第i位的数值
			before = n / (i * 10);// i位左边高位的数值
			after = n - (n / i) * i; // i位右边地位的数值

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
			high = n / (int) Math.pow(10, i);// 获取第i位的高位
			tmp = n % (int) Math.pow(10, i);
			curr = tmp / (int) Math.pow(10, i - 1);// 获取第i位
			low = tmp % (int) Math.pow(10, i - 1);// 获取第i位的低位
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
