package HuaWei;

import java.util.Scanner;

/**
 * 有条件的背包问题
 */
public class ShopingList {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int N = cin.nextInt();// 总钱
			int m = cin.nextInt();// 总个数
			int[] p = new int[m + 1];// 重要度
			int[] q = new int[m + 1];// 主见还是附件
			int[] v = new int[m + 1];// 每件物品的价格
			for (int i = 1; i <= m; i++) {
				v[i] = cin.nextInt();// 价格
				p[i] = cin.nextInt() * v[i];// 价格*重要度
				q[i] = cin.nextInt();// 主件附件编号
			}
			System.out.println(getMax(N, m, v, p, q));
		}
		cin.close();

	}

	/**
	 * 转移方程：
	 */
	private static int getMax(int N, int m, int[] v, int[] p, int[] q) {

		int[][] dp = new int[m + 1][N + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= N; j++) {// 递增，可以放多个
				// 如果是主件
				if (q[i] == 0) {// 下标从0开始还是从1开始得注意
					// 考虑j - v[i]可能是负的
					if (v[i] <= j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + p[i]);
					}
				} else {// 如果是附件

					if (v[i] + v[q[i]] <= j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i] - v[q[i]]] + p[i] + p[q[i]]);// 主件附件一起算
					}
				}
			}
		}

		return dp[m][N];
	}

}
