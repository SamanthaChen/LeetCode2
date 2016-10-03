package NetEase;

/*
 * 求在圆上并且是整数的点
 * */
import java.util.Scanner;

public class NumInCycle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int rr = scanner.nextInt();
			int count = 0;
			for (int x = 0; x * x < rr; x++) {
				int y = (int) Math.sqrt(rr - x * x);
				if (x * x + y * y == rr)
					count++;
			}
			count = count * 4;
			System.out.println(count);

		}
		scanner.close();
	}

}
