package Sogou;

/**
 * ��Ŀ������

������������2��ż��֮��ľ��룬Ϊ��������֮�������ĸ�������С��������n������2��ż�����������������֮�������ܺͣ�Ӧ����n*(n-1)/2�����룬����ܺ;ͺ�)��
����
��һ��������ż���ĸ�������СΪ2�������ܵ�����֮��ÿ��Ϊһ��ż������С��4���������Ǽ����򣬲��ظ����������С�
���
�������������������ܺͣ���Ӧ����һ����С��0��������

��������
3
4
6
12
�������
6
���˴��룺������Ч�ʣ�������71%ͨ������ʾ��ʱ����ӭָ��
 * 
 * */
import java.util.Scanner;

public class Prime {
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {// ����Ĭ��2����������i=2ʱ��ѭ����ִ��
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int count(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = a[i]; k <= a[j]; k++) {
					if (isPrime(k)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(count(a));

	}

}