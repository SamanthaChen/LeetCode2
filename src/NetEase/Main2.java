package NetEase;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			// �������
			int count = 0;
			// int[] record = new int[n + 1]; //��������
			// record[1] = 1;// f[1]=1
			int odd = 1;
			int even = 1;
			for (int i = 1; i <= n; i++) {
				if (i % 2 != 0) {
					count += i;// �����Ļ����Լ�
					odd = i;//
				} else {// ż���Ļ������������ʼ��
					int k = i / 2;
					if (k % 2 == 0) {// һ����ż��
						count += even;
					} else {
						count += odd;// һ��������
						even = odd;
					}

				}
			}
			System.out.println(count);
		}
		scanner.close();
	}

}
