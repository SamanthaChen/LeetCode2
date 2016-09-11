package HuaWei;

import java.util.Scanner;

/**
 * �������ı�������
 */
public class ShopingList {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int N = cin.nextInt();// ��Ǯ
			int m = cin.nextInt();// �ܸ���
			int[] p = new int[m + 1];// ��Ҫ��
			int[] q = new int[m + 1];// �������Ǹ���
			int[] v = new int[m + 1];// ÿ����Ʒ�ļ۸�
			for (int i = 1; i <= m; i++) {
				v[i] = cin.nextInt();// �۸�
				p[i] = cin.nextInt() * v[i];// �۸�*��Ҫ��
				q[i] = cin.nextInt();// �����������
			}
			System.out.println(getMax(N, m, v, p, q));
		}
		cin.close();

	}

	/**
	 * ת�Ʒ��̣�
	 */
	private static int getMax(int N, int m, int[] v, int[] p, int[] q) {

		int[][] dp = new int[m + 1][N + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= N; j++) {// ���������ԷŶ��
				// ���������
				if (q[i] == 0) {// �±��0��ʼ���Ǵ�1��ʼ��ע��
					// ����j - v[i]�����Ǹ���
					if (v[i] <= j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + p[i]);
					}
				} else {// ����Ǹ���

					if (v[i] + v[q[i]] <= j) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i] - v[q[i]]] + p[i] + p[q[i]]);// ��������һ����
					}
				}
			}
		}

		return dp[m][N];
	}

}
