package HuaWei;

import java.util.Scanner;

/**
 * �ֽ�������
 */
public class DecPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long n = sc.nextLong();
			for (int i = 2; i < n; i++) {
				while (n != i) {
					if (n % i != 0) {
						break;// ���������϶������������ܹ�����������һ������������Ϊ���е�2��3,5,7
						// ��������֮��ʣ�µ�����ֻ��������������������
					}
					System.out.print(i + " ");
					n = n / i;
				}
			}
			System.out.println(n);

		}
		sc.close();

	}

}
