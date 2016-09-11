package DiDi;

/**
 * ��Ŀ���⣺�͹���n�����ˣ�ÿ�����˸������������ѽ�Ȼ��͹���m�����ӣ�
 * ����ÿ�����ӿ���������������˵����һʱ�̣��͹ݿ������ӯ�����٣����ҽӴ�������Ŀ��ˡ�
����˼·�������˰������ѽ���������Ȼ�����Ӱ��մ�С��������
���ѸߵĿ��˾�������С��������Ӹ����ǡ�ע�������ʱ���������ţ�����ͬ������ţ����ܴ��ҡ�
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

			// greedy̰���㷨

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

				int index = Arrays.binarySearch(tables, client.count);// ���ֲ��Ҹ�����Ӧ�ò����������
				index += 1;// ��Ϊindex�����ڵĻ��Ƿ���(-(insertion point) - 1).
				index = -index;
				if (index < tables.length && !isUsed[index]) {// ����û�ù��ͷ���
					isUsed[index] = true;
					sum += client.total;
				} else {
					while (index < tables.length && isUsed[index]) {// �����ù��˾ͼ������²���
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
	public int compareTo(Client o) {// �������򣬰��ս����
		return o.total - this.total;// reverse
	}
}
