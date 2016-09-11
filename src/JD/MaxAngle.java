package JD;

import java.util.Scanner;

public class MaxAngle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {

			double[] x = new double[3];
			double[] y = new double[3];
			double[] r = new double[3];
			for (int i = 0; i < 3; i++) {
				String s = scanner.nextLine();
				String[] sa = s.split(" ");
				x[i] = Integer.valueOf(sa[0]);
				y[i] = Integer.valueOf(sa[1]);
				r[i] = Integer.valueOf(sa[2]);
			}
			// 解题过程
			double maxsinx = Double.MIN_VALUE;// 存最大sinx值
			boolean flag = false;
			double bestx = 0;
			double besty = 0;
			for (double bx = 0; bx <= 1000; bx = (double) (bx + 1)) {
				for (double by = 0; by <= 1000; by = (double) (by + 1)) {
					double ratio0 = r[0] / distance(x[0], y[0], bx, by);
					double ratio1 = r[0] / distance(x[1], y[1], bx, by);
					double ratio2 = r[0] / distance(x[2], y[2], bx, by);
					if (ratio0 == ratio1 && ratio2 == ratio0 && ratio0 > maxsinx) {
						maxsinx = ratio0;
						bestx = bx;
						besty = by;
						flag = true;
					}
				}
			}
			// 输出结果
			if (flag == true) {
				System.out.printf("%.6f %.6f", bestx, besty);
				System.out.println("");
			} else {
				System.out.println("No");
			}

		}
		scanner.close();

	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double a = Math.pow((x1 - x2), 2);
		double b = Math.pow((y1 - y2), 2);
		double res = Math.pow(a + b, 0.5);
		return res;
	}

}
