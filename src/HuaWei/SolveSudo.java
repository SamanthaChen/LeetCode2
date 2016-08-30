package HuaWei;

import java.util.Scanner;

public class SolveSudo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 装填数组
			int[][] a = new int[9][9];
			boolean[][] rows = new boolean[9][9];
			boolean[][] cols = new boolean[9][9];
			boolean[][] blocks = new boolean[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					a[i][j] = sc.nextInt();
					if (a[i][j] != 0) {
						int val = a[i][j] - 1;// 表示这个
						rows[i][val] = true;// 表示第i行已经有val+1这个值了
						cols[j][val] = true;
						int k = i / 3 * 3 + j / 3;
						blocks[k][val] = true;
					}

				}
			}
			SolveSudo m = new SolveSudo();
			m.DFS(a, rows, cols, blocks);// 递归填
			// 打印解答
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
		// 遍历数组
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// 填补空白的地方
				if (a[i][j] == 0) {
					// 需要从0~9每个数都看一遍是否在行列格中都是没有出现过的
					int k = i / 3 * 3 + j / 3;
					for (int l = 1; l <= 9; l++) {
						if (!rows[i][l - 1] && !cols[j][l - 1] && !blocks[k][l - 1]) {
							// 都没有出现过,尝试添加为l，再看看能不能解答
							rows[i][l - 1] = cols[j][l - 1] = blocks[k][l - 1] = true;
							a[i][j] = l;
							if (DFS(a, rows, cols, blocks)) {
								// 继续递归，递归成功，说明l的假设成立,返回上一次调用的地方继续填数字
								return true;
							}
							// 递归失败，不能用l
							rows[i][l - 1] = cols[j][l - 1] = blocks[k][l - 1] = false;
							a[i][j] = 0;

						}
					}
					return false;// 9个数都循环完了还没有在中间返回，说明这个位置失败，返回上一层
				} // a[i][j]==0的末尾
			}

		} // 最外层for的结束
			// 所有可能性都试过了
		return true;
	}
}
