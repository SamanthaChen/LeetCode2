package JZoffer;

/**
 * n�����ӵ����͵ĸ���
 */
public class RollProbability {

	public static void main(String[] args) {
		RollProbability m = new RollProbability();
		m.printProbability(2);
	}

	/**
	 * ��k-1������ʱ��������һ�����ӣ�������ӵĵ���ֻ����Ϊ1��2��3��4��5��6����k�����ӵõ�������Ϊn������У�
	 * (k-1,n-1)����k������Ͷ�˵���1 (k-1,n-2)����k������Ͷ�˵���2 (k-1,n-3)����k������Ͷ�˵���3 ....
	 * (k-1,n-6)����k������Ͷ�˵���6 ��k-1�����ӵĻ����ϣ�������һ�����ӳ��ֵ�����Ϊn�Ľ��ֻ����6�������
	 * ���ԣ�f(k,n)=f(k-1,n-1)+f(k-1,n-2)+f(k-1,n-3)+f(k-1,n-4)+f(k-1,n-5)+f(k-1,n-
	 * 6) ��ʼ������1�����ӣ�f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1��
	 */
	private static final int MAX = 6;// ���ӵ�����

	public void printProbability(int n) {
		// �߽�
		if (n < 1)
			return;
		// �ܵĿ��ܽ��
		double total = Math.pow(MAX, n);
		int maxSum = MAX * n;// ��������
		double[][] f = new double[n + 1][maxSum + 1];// �������ʾ��i�����ӣ��������ʾ��ǰ�ĵ�����
		// ��ʼ������ֻ��һ������ʱ��1~MAX��������1
		for (int i = 1; i <= MAX; i++)
			f[1][i] = i;
		// ��ʼ��̬�滮
		for (int k = 2; k <= n; k++) {// ��k������
			for (int sum = n; sum <= maxSum; sum++) { // sum�ǿ��ܵĵ�����
				// ��k��������MAX�ֿ���
				for (int i = 1; sum - i >= 1 && i <= MAX; i++) {
					f[k][sum] += f[k - 1][sum - i];
				}
			}
		}
		// ��ӡ���
		for (int i = 1; i <= maxSum; i++) {
			System.out.printf("sum:%d  probability:%.6f \n", i, f[n][i] / total);

		}
	}

}
