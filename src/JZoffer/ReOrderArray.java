package JZoffer;

import java.util.Arrays;

public class ReOrderArray {

	public static void main(String[] args) {
		ReOrderArray m = new ReOrderArray();
		int[] a = { 2, 4, 6, 1, 3, 5, 7 };
		m.reOrderArray2(a);
		System.out.println(Arrays.toString(a));
	}

	// ����ָ����н������������λ�û��
	public void reOrderArray(int[] array) {
		int p1 = 0;
		int p2 = array.length - 1;
		while (p1 < p2) {
			// ��ǰ�ƶ�p1֪��������һ��ż��
			while (p1 < p2 && array[p1] % 2 == 1)
				p1++;
			// ����ƶ�p1֪��������һ������
			while (p1 < p2 && array[p2] % 2 == 0)
				p2--;

			int temp = array[p2];
			array[p2] = array[p1];
			array[p1] = temp;

			p1++;
			p2--;
		}
	}

	// ��������
	public void reOrderArray2(int[] array) {
		// ����ǰ��i-1���ź���ģ�
		for (int i = 1; i < array.length; i++) {
			int tmp = array[i];
			if (tmp % 2 == 1) {// ����������ǰ������Ĳ���
				// ż������Ų���������뵽ż��ǰ��
				int j = i - 1;
				while (j >= 0 && array[j] % 2 == 0) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = tmp;

			}
		}
	}

}
