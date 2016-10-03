package NetEase;

/*
 * 最大奇约数之和
 * */
import java.util.Scanner;

public class SumofOddDivisor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int res = slove2(n);
			System.out.println(res);
		}
		scanner.close();
	}

	/**
	 * 这个方法超过内存限制
	 */
	public static void slove(int n) {
		// 解题过程
		int count = 0;
		int[] record = new int[n + 1];
		record[1] = 1;// f[1]=1
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				count += i;// 奇数的话是自己
				record[i] = i;
			} else {// 偶数的话从最大奇数开始算
				record[i] = record[i / 2];
				count += record[i];
			}
		}
		System.out.println(count);
	}

	/**
	 * 第二个方法！！需要挖掘内部的规律 。 如果N是奇数 。 可以得到sum(N)=1+f(2)+3+f(4)+...+f(N-1)+N =
	 * (N+1)^2/4+f(1)+f(2)+..+f((N-1)/2)=(N+1)^2/4+sum((N-1)/2)
	 * 如果N是偶数。可以得到sum(N)=1+3+..+N-1+f(2)+..+f(N)=N^2/4+sum(N/2)
	 * (这两个因为int除法的原因可以统一为第一个)
	 */
	public static int slove2(int n) {
		if (n == 0)
			return 0;
		return ((n + 1) / 2) * ((n + 1) / 2) + slove2(n / 2);
	}

}
