package HuaWei;

import java.util.ArrayList;
/**
 * ��Ŀ�������һ���ݻ�Ϊw�����Ӻͼ�����Ʒ�ݻ���Ҫ�������������Ʒ�ܸպ�װ������
 * 			�����������������һ�ֽ⣬�н������Yes+�� �޽������No
 * 		 
 * ���⣺
 * ���� �� 10 4 5 6 7  ����һ�������Ӵ�Сw����������Ʒ��
 * ����� Yes 4 6
 * ���룺 10 1 1 1 5 6 7 
 * ����� Yes 1 1 1 7
 * ���룺10 4 5 7 8 
 * ����� No	
 * 
 * */
import java.util.Scanner;

public class zhuanglanzi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			flag = false;// ÿ�ν�������һ���н�ı�ʶ
			String s = sc.nextLine();
			String[] sa = s.split(" ");
			int w = Integer.valueOf(sa[0]);// ���Ӵ�С
			int[] a = new int[sa.length - 1];// ��Ʒ����
			// ���ַ���ת��Ϊ����
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.valueOf(sa[i + 1]);
			}
			// �������
			solution(w, a, 0, new ArrayList<Integer>());// ����н�����

			if (flag == false) {
				System.out.println("No");// �޽�����
			}

		}
		sc.close();
	}

	private static boolean flag = false;

	private static void solution(int w, int[] a, int loc, ArrayList<Integer> arrayList) {
		// �ݹ��������
		if (w == 0) {
			System.out.print("Yes");
			for (int i : arrayList) {
				System.out.print(" " + i);
			}
			System.out.println("");
			flag = true;

		}
		for (int i = loc; i < a.length; i++) {
			arrayList.add(a[i]);
			solution(w - a[i], a, i + 1, arrayList);
			arrayList.remove(arrayList.size() - 1);
		}

	}

}
