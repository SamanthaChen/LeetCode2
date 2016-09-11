package JD;

/**
 * 京东编程：爬山
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
			n = cin.nextInt();// 记录个数
			m = cin.nextInt();// 没有遗失的记录个数

			// list保存第几天
			List<Integer> list = new ArrayList<Integer>();

			// map保存第几天对应的高度
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

			for (int i = 0; i < m; i++) {
				int a = cin.nextInt();// 天数
				int b = cin.nextInt();// 高度
				map.put(a, b);
				list.add(a);
			}

			Collections.sort(list);// 对天数进行排序

			int max = 0;

			// 判断第一天最高高度
			if (list.get(0) > 1) {
				max = map.get(list.get(0)) + list.get(0) - 1;// 第一天的值遗失了，因此第一天应该是目前第一个值+差值
			} else {
				max = map.get(list.get(0));// 如果第一天的值没有遗失
			}

			int size = list.size();

			boolean flag = false;

			// 判断第i天 和第 i+1天间能达到的最高高度
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

			// 判断最后一天能达到的最高高度
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