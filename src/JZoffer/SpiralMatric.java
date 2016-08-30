package JZoffer;

import java.util.ArrayList;

public class SpiralMatric {

	public static void main(String[] args) {
		// int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, {
		// 13, 14, 15, 16 } };
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		SpiralMatric m = new SpiralMatric();
		ArrayList<Integer> list = m.printMatrix(a);
		System.out.println(list);

	}

	// 剑指offer上的按圈打印
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		// 边界条件
		if (matrix == null)
			return res;
		int rows = matrix.length;
		int cols = matrix[0].length;
		// 定好四个角
		int top = 0;
		int bottom = rows - 1;
		int left = 0;
		int right = cols - 1;
		while (res.size() < rows * cols) {

			// 从左往右
			for (int j = left; j <= right; j++)
				res.add(matrix[top][j]);
			top++;// 打完一行了

			// 从上往下
			for (int i = top; i <= bottom; i++)
				res.add(matrix[i][right]);
			right--;// 打完一列

			if (top > bottom)
				break;// 如果只有一行就不需要打,至少需要两行才能从右往左打

			// 从右往左
			for (int j = right; j >= left; j--)
				res.add(matrix[bottom][j]);
			bottom--;

			if (left > right)
				break;// 停止条件，防止出现重复的列，至少需要两列才能从下往上打

			// 从下往上
			for (int i = bottom; i >= top; i--)
				res.add(matrix[i][left]);
			left++;

		}
		return res;
	}
}
