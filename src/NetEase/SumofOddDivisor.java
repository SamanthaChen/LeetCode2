package NetEase;

/*
 * �����Լ��֮��
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
	 * ������������ڴ�����
	 */
	public static void slove(int n) {
		// �������
		int count = 0;
		int[] record = new int[n + 1];
		record[1] = 1;// f[1]=1
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				count += i;// �����Ļ����Լ�
				record[i] = i;
			} else {// ż���Ļ������������ʼ��
				record[i] = record[i / 2];
				count += record[i];
			}
		}
		System.out.println(count);
	}

	/**
	 * �ڶ�������������Ҫ�ھ��ڲ��Ĺ��� �� ���N������ �� ���Եõ�sum(N)=1+f(2)+3+f(4)+...+f(N-1)+N =
	 * (N+1)^2/4+f(1)+f(2)+..+f((N-1)/2)=(N+1)^2/4+sum((N-1)/2)
	 * ���N��ż�������Եõ�sum(N)=1+3+..+N-1+f(2)+..+f(N)=N^2/4+sum(N/2)
	 * (��������Ϊint������ԭ�����ͳһΪ��һ��)
	 */
	public static int slove2(int n) {
		if (n == 0)
			return 0;
		return ((n + 1) / 2) * ((n + 1) / 2) + slove2(n / 2);
	}

}
