package Sogou;

/**
 *����ż��֮��ľ���������֮�����������������������ܶఴ�������е�ż����
 *�����������ż��֮��ľ���֮�ͣ���һ��n(n-1)/2�����֮�ͣ���
 *ʾ����
 *���룺 ����һ����ż���ĸ�����֮���ǰ��������е�ż����
 *	3
 *	4
 *	6
 *	12
 *�����
 *	6
 * */
import java.util.Scanner;

public class SumOfEvenDistance {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int n2;
		int count = 0;
		int n1 = scanner.nextInt();// ��һ����
		for (int i = 1; i < N; i++) {
			// ����������ż��֮�����������
			n2 = scanner.nextInt();
			// System.out.println(n1 + " " + n2 + " " + decPrime(n1, n2));
			count += decPrime(n1, n2);

			n1 = n2;
		}
		System.out.println(count * (N - 1));
		scanner.close();
	}

	// �ֽ�������
	// ��������֮�������������
	public static int decPrime(long start, long end) {

		// List<Long> list = new ArrayList<Long>();
		int len = 0;
		for (long i = start; i < end; i++) {
			while (end != i) {
				if (end % i != 0) {
					break;// ���������϶������������ܹ�����������һ������������Ϊ���е�2��3,5,7
					// ��������֮��ʣ�µ�����ֻ��������������������
				}
				len++;
				end = end / i;
			}
		}
		len++;
		return len;
	}

}
