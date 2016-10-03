package Sogou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prime2 {

	public static void main(String[] args) {
		Prime2 m = new Prime2();
		m.slove();
	}

	public void slove() {
		// ��ò�����n������
		int maxn = 10000010;
		boolean[] isPrime = getPrime(maxn);
		// ɨ������
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int num, lastnum;// �ֱ��ǵ�һ�����ͺ�һ��
		List<Integer> list = new ArrayList<Integer>();// ����˳��������ż��֮�����������
		num = scanner.nextInt();// ��һ����

		// ����������ż��֮�����������
		for (int i = 1; i < N; i++) {
			lastnum = scanner.nextInt();
			int count = 0;
			for (int j = num + 1; j < lastnum; j = j + 2) {// ż���϶���������������+2����
				if (isPrime[j]) {
					count++;
				}
			}
			list.add(count);
			num = lastnum;// ����һ��
		}
		/*
		 * �������� ������ʹ�ö���ѭ��������������ǻᳬʱ�ġ� �����������һ������ʣ���������ľ���֮�ͣ�
		 * Ȼ������ĺͼ�ȥ��һ�������ڶ������ľ������ n - 1 ��Ϊ�ڶ������������������ľ��롣 ����˼�뼴��������
		 */
		int sum = 0;
		int tmp = 0;
		for (int i = 0; i < N - 1; i++) {
			tmp += list.get(i);
			sum += tmp;
		}
		tmp = sum;
		for (int i = 1; i < N - 1; i++) {
			tmp -= list.get(i - 1) * (N - i);
			sum += tmp;
		}
		System.out.println(sum);
		scanner.close();
	}

	/**
	 * ��ɸ���󲻴���N����������
	 */
	public boolean[] getPrime(int maxn) {
		boolean[] isPrime = new boolean[maxn];
		Arrays.fill(isPrime, true);// ���еĳ�ʼ��Ϊtrue
		for (int i = 2; i * i < maxn; i++) {
			if (!isPrime[i])
				continue;
			// �����ı���һ���Ǻ���
			for (int j = 2; i * j < maxn; j++) {
				isPrime[i * j] = false;
			}
		}
		return isPrime;

	}
}
