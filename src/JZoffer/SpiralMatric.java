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

	// ��ָoffer�ϵİ�Ȧ��ӡ
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		// �߽�����
		if (matrix == null)
			return res;
		int rows = matrix.length;
		int cols = matrix[0].length;
		// �����ĸ���
		int top = 0;
		int bottom = rows - 1;
		int left = 0;
		int right = cols - 1;
		while (res.size() < rows * cols) {

			// ��������
			for (int j = left; j <= right; j++)
				res.add(matrix[top][j]);
			top++;// ����һ����

			// ��������
			for (int i = top; i <= bottom; i++)
				res.add(matrix[i][right]);
			right--;// ����һ��

			if (top > bottom)
				break;// ���ֻ��һ�оͲ���Ҫ��,������Ҫ���в��ܴ��������

			// ��������
			for (int j = right; j >= left; j--)
				res.add(matrix[bottom][j]);
			bottom--;

			if (left > right)
				break;// ֹͣ��������ֹ�����ظ����У�������Ҫ���в��ܴ������ϴ�

			// ��������
			for (int i = bottom; i >= top; i--)
				res.add(matrix[i][left]);
			left++;

		}
		return res;
	}
}
