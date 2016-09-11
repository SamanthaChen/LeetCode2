package HuaWei;

import java.util.Scanner;

public class HeChangDui {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			// ���⣺�����������������
			int[] inc = new int[n];
			int[] dec = new int[n];

			inc[0] = 1;// ��һ��Ԫ��
			for (int i = 1; i < n; i++) {
				inc[i] = 1;
				for (int j = 0; j < i; j++) {
					if (a[j] < a[i] && inc[j] + 1 > inc[i]) {
						inc[i] = inc[j] + 1;
					}
				}
			}
			dec[n - 1] = 1;
			for (int i = n - 2; i >= 0; i--) {
				dec[i] = 1;// ��ʼֵΪ1
				for (int j = n - 1; j > i; j--) {
					if (a[j] < a[i] && dec[j] + 1 > dec[i]) {
						dec[i] = dec[j] + 1;
					}
				}
			}
			// ����������������
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (max < inc[i] + dec[i] - 1)
					max = inc[i] + dec[i] - 1;
			}
			System.out.println(n - max);

		}
		sc.close();
	}

}
