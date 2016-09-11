package JZoffer;

/**
 * n个骰子点数和的概率
 */
public class RollProbability {

	public static void main(String[] args) {
		RollProbability m = new RollProbability();
		m.printProbability(2);
	}

	/**
	 * 有k-1个骰子时，再增加一个骰子，这个骰子的点数只可能为1、2、3、4、5或6。那k个骰子得到点数和为n的情况有：
	 * (k-1,n-1)：第k个骰子投了点数1 (k-1,n-2)：第k个骰子投了点数2 (k-1,n-3)：第k个骰子投了点数3 ....
	 * (k-1,n-6)：第k个骰子投了点数6 在k-1个骰子的基础上，再增加一个骰子出现点数和为n的结果只有这6种情况！
	 * 所以：f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-
	 * 6) 初始化：有1个骰子，f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1。
	 */
	private static final int MAX = 6;// 骰子的面数

	public void printProbability(int n) {
		// 边界
		if (n < 1)
			return;
		// 总的可能结果
		double total = Math.pow(MAX, n);
		int maxSum = MAX * n;// 最大点数和
		double[][] f = new double[n + 1][maxSum + 1];// 横坐标表示第i个骰子，纵坐标表示当前的点数和
		// 初始变量，只有一个骰子时候，1~MAX次数都是1
		for (int i = 1; i <= MAX; i++)
			f[1][i] = i;
		// 开始动态规划
		for (int k = 2; k <= n; k++) {// 第k个骰子
			for (int sum = n; sum <= maxSum; sum++) { // sum是可能的点数和
				// 第k个骰子有MAX种可能
				for (int i = 1; sum - i >= 1 && i <= MAX; i++) {
					f[k][sum] += f[k - 1][sum - i];
				}
			}
		}
		// 打印结果
		for (int i = 1; i <= maxSum; i++) {
			System.out.printf("sum:%d  probability:%.6f \n", i, f[n][i] / total);

		}
	}

}
