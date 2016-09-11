package DiDi;

/**
 * 题目大意：餐馆有n批客人，每批客人给出人数和消费金额。然后餐馆有m个桌子，
 * 给出每个桌子可以坐的人数。问说在这一时刻，餐馆可以最大盈利多少，并且接待尽量多的客人。
解题思路：将客人按照消费金额、人数排序，然后桌子按照从小到大排序。
消费高的客人尽量找最小满足的桌子给他们。注意输出的时候客人有序号，桌子同样有序号，不能打乱。
 * 
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CanTing2 {
	public static void solve() {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			String s = reader.nextLine();
			String[] sarry = s.split(" ");
			int n = Integer.parseInt(sarry[0]);
			int m = Integer.parseInt(sarry[1]);

			// get tables
			int[] tables = new int[n];
			s = reader.nextLine();
			sarry = s.split(" ");
			for (int i = 0; i < n; i++) {
				tables[i] = Integer.parseInt(sarry[i]);
			}
			Arrays.sort(tables);
			int maxSize = tables[tables.length - 1];

			// get clients
			List<Client> list = new ArrayList<>();
			// Client[] clients = new Client[m];
			for (int i = 0; i < m; i++) {
				s = reader.nextLine();
				sarry = s.split(" ");
				int count = Integer.parseInt(sarry[0]);
				int total = Integer.parseInt(sarry[1]);
				if (count <= maxSize) {
					list.add(new Client(count, total));
				}
				// clients[i] = new Client(count, total);
			}
			Object[] clients = list.toArray();

			// greedy贪婪算法

			Arrays.sort(clients);
			boolean[] isUsed = new boolean[n];

			int sum = 0;
			for (int i = 0; i < clients.length; i++) {
				Client client = (Client) clients[i];
				/*
				 * for(int j = 0; j < tables.length; j ++) { if(tables[j] >=
				 * client.count && !isUsed[j]) { isUsed[j] = true; sum +=
				 * client.total; break; } }
				 */

				int index = Arrays.binarySearch(tables, client.count);// 二分查找该人数应该插入的桌子数
				index += 1;// 因为index不存在的话是返回(-(insertion point) - 1).
				index = -index;
				if (index < tables.length && !isUsed[index]) {// 桌子没用过就分配
					isUsed[index] = true;
					sum += client.total;
				} else {
					while (index < tables.length && isUsed[index]) {// 桌子用过了就继续向下查找
						index++;
					}

					if (index < tables.length) {
						isUsed[index] = true;
						sum += client.total;
					}
				}
			}
			System.out.println(sum);
		}
		reader.close();
	}

	public static void main(String[] args) {
		CanTing2.solve();
	}
}

class Client implements Comparable<Client> {
	public int count;
	public int total;

	public Client() {
	}

	public Client(int count, int total) {
		this.count = count;
		this.total = total;
	}

	@Override
	public int compareTo(Client o) {// 类内排序，按照金额排
		return o.total - this.total;// reverse
	}
}
