package JZoffer;

public class MatrixFind {
	public boolean Find(int[][] array, int target) {
		int rows = array.length;
		int cols = array[0].length;
		int i = 0;
		int j = cols - 1;
		while (i < rows && j >= 0) {
			if (array[i][j] == target) {
				return true;
			} else if (target < array[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;

	}
}
