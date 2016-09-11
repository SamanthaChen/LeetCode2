package JD;

/**
 * ������̣���ɽ
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);

		while (cin.hasNextInt()) {
			int n, m;
			n = cin.nextInt();// ��¼����
			m = cin.nextInt();// û����ʧ�ļ�¼����

			// list����ڼ���
			List<Integer> list = new ArrayList<Integer>();

			// map����ڼ����Ӧ�ĸ߶�
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < m; i++) {
				int a = cin.nextInt();// ����
				int b = cin.nextInt();// �߶�
				map.put(a, b);
				list.add(a);
			}

			Collections.sort(list);// ��������������

			int max = 0;

			// �жϵ�һ����߸߶�
			if (list.get(0) > 1) {
				max = map.get(list.get(0)) + list.get(0) - 1;// ��һ���ֵ��ʧ�ˣ���˵�һ��Ӧ����Ŀǰ��һ��ֵ+��ֵ
			} else {
				max = map.get(list.get(0));// �����һ���ֵû����ʧ
			}

			int size = list.size();

			boolean flag = false;

			// �жϵ�i�� �͵� i+1����ܴﵽ����߸߶�
			for (int i = 0; i < size - 1; i++) {
				int pre = list.get(i);
				int next = list.get(i + 1);
				int prehigh = map.get(pre);
				int nexthigh = map.get(next);

				if (Math.abs(prehigh - nexthigh) > Math.abs(pre - next)) {
					System.out.println("IMPOSSIBLE");
					flag = true;
					break;
				} else {
					if (prehigh > nexthigh) {
						next = next - (prehigh - nexthigh);
						max = Math.max(max, prehigh + (next - pre) / 2);
					} else {
						pre = pre + (nexthigh - prehigh);
						max = Math.max(max, nexthigh + (next - pre) / 2);
					}

				}
			}
			if (flag) {
				continue;
			}

			// �ж����һ���ܴﵽ����߸߶�
			if (list.get(size - 1) < (size - 2)) {
				max = Math.max(max, map.get(list.get(size - 1)) + n - list.get(size - 1));
			} else {
				max = Math.max(max, map.get(list.get(size - 1)));
			}

			System.out.println(max);

		}
		cin.close();
	}

}