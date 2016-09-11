package DiDi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
 * */
// �Զ���һ����
class Order {
	int people;
	int prices;
	int id;

	Order(int id, int people, int prices) {
		this.people = people;
		this.prices = prices;
		this.id = id;
	}
}

class Table {
	int id;
	int size;

	Table(int id, int size) {
		this.id = id;
		this.size = size;
	}
}

public class CanTing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// ������
			int n = sc.nextInt();
			// ������
			List<Order> list = new ArrayList<Order>();
			for (int i = 0; i < n; i++) {
				Order o = new Order(i + 1, sc.nextInt(), sc.nextInt());
				list.add(o);
			}
			// ������
			int m = sc.nextInt();
			List<Table> tList = new ArrayList<Table>();
			for (int i = 0; i < m; i++) {
				Table t = new Table(i + 1, sc.nextInt());

			}
			// ���ս���������
			Collections.sort(list, new Comparator<Order>() {
				@Override
				public int compare(Order order1, Order order2) {
					if (order1.prices > order2.prices) {
						return -1;
					} else if (order1.prices < order2.prices) {
						return 1;
					} else {
						return Integer.compare(order2.people, order1.people);
					}

				}
			});
			// ��������
			tList.sort(new Comparator<Table>() {
				public int compare(Table o1, Table o2) {
					return Integer.compare(o1.size, o2.size);
				}
			});

			// });
			// for (Order l : list) {
			// System.out.println(l.people + " " + l.prices);
			// }
			// ��ѡ�������

		}
		sc.close();
	}

}
