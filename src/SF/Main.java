package SF;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] used;
	static int len;
	static int[] nums;
	static int sum;
	static int maxnum;
	static int parts;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			nums = new int[n];
			sum = 0;
			used = new boolean[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
			}
			// ������
			// ������
			Arrays.sort(nums);
			int maxnum = nums[n - 1];
			for (; maxnum <= sum; maxnum++) {
				if (sum % maxnum == 0) {// �ܱ��ܳ�������ʱ��ź���
					parts = sum / maxnum;
					// ����ľ�ܣ��Ӵ�С��
					if (DFS(0, n - 1, 0)) {
						System.out.println(maxnum);
						break;
					}

				}
			}

		}
		sc.close();
	}

	// ����ľ��

	private static boolean DFS(int res, int next, int cpl) {
		if (res == maxnum) {
			cpl++;
			res = 0;
			next = len - 2;
		}
		// ������ǰ����ľ���Ѿ��ϳ���ϣ�����
		if (cpl == parts) {
			return true;
		}

		// ��ǰ����ľ��û�кϲ��꣬���һ���ϲ�
		while (next >= 0) {
			// �����ǰľ��û�б�ʹ�ù�
			if (used[next] == false) {
				// �Ѻϲ�+ s[next�� <= max ˵����ǰľ�����Լ��뵽��ǰ���ںϲ���ľ����
				if (res + nums[next] <= maxnum) {
					used[next] = true;
					// �����ɹ�����
					if (DFS(res + nums[next], next - 1, cpl)) {
						return true;
					}
					// �������ɹ�������
					used[next] = false;
					// ��ǰ���ںϲ���ľ������res = 0�� ��ʣ��ľ���в������ٺϳ�ľ��������ʧ��
					if (res == 0) {
						break;
					}
					// ���Ժϳ�һ����ǰ�ģ�����ʣ��Ĳ��ܺϳ�һ��ľ��������ʧ��
					if (res + nums[next] == maxnum) {
						break;
					}
					// ���������Ȼ��������
				}

				int i = next - 1;
				while (i >= 0 && nums[i] == nums[next]) {
					i--;
				}
				next = i;
				int l_s = 0;
				while (i >= 0) {
					if (!used[i]) {
						l_s += nums[i];
					}
					i--;
				}

				if (l_s < maxnum - res) {
					break;
				}
				continue;
			}
			next--;

		}
		return false;
	}

}
