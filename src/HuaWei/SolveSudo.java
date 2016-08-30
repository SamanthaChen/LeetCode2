package HuaWei;

import java.util.Scanner;

public class SolveSudo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// װ������
			int[][] a = new int[9][9];
			boolean[][] rows = new boolean[9][9];
			boolean[][] cols = new boolean[9][9];
			boolean[][] blocks = new boolean[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] != 0) {
						int val = a[i][j] - 1;// ��ʾ���
						rows[i][val] = true;// ��ʾ��i���Ѿ���val+1���ֵ��
						cols[j][val] = true;
						int k = i / 3 * 3 + j / 3;
						blocks[k][val] = true;
					}

				}
			}
			SolveSudo m = new SolveSudo();
			m.DFS(a, rows, cols, blocks);// �ݹ���
			// ��ӡ���
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println(a[i][8]);
			}
		} // end while
		sc.close();
	}// end main

	public boolean DFS(int[][] a, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
		// ��������
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// ��հ׵ĵط�
				if (a[i][j] == 0) {
					// ��Ҫ��0~9ÿ��������һ���Ƿ������и��ж���û�г��ֹ���
					int k = i / 3 * 3 + j / 3;
					for (int l = 1; l <= 9; l++) {
						if (!rows[i][l - 1] && !cols[j][l - 1] && !blocks[k][l - 1]) {
							// ��û�г��ֹ�,�������Ϊl���ٿ����ܲ��ܽ��
							rows[i][l - 1] = cols[j][l - 1] = blocks[k][l - 1] = true;
							a[i][j] = l;
							if (DFS(a, rows, cols, blocks)) {
								// �����ݹ飬�ݹ�ɹ���˵��l�ļ������,������һ�ε��õĵط�����������
								return true;
							}
							// �ݹ�ʧ�ܣ�������l
							rows[i][l - 1] = cols[j][l - 1] = blocks[k][l - 1] = false;
							a[i][j] = 0;

						}
					}
					return false;// 9������ѭ�����˻�û�����м䷵�أ�˵�����λ��ʧ�ܣ�������һ��
				} // a[i][j]==0��ĩβ
			}

		} // �����for�Ľ���
			// ���п����Զ��Թ���
		return true;
	}
}
