package HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ע��������ܻ����ظ����ֵܵ���
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			// �ֵ�ʵ��
			Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				char[] ch = s.toCharArray();
				Arrays.sort(ch);
				String key = new String(ch);
				if (!map.containsKey(key)) {
					ArrayList<String> list = new ArrayList<String>();
					list.add(s);
					map.put(key, list);
				} else {
					ArrayList<String> list = map.get(key);
					list.add(s);
				}
			}
			// ���ֵ������list�����ֵ����������
			for (ArrayList<String> list : map.values()) {
				Collections.sort(list);
			}
			// ���в�ѯ
			String query = sc.next();
			int k = sc.nextInt();
			char[] qch = query.toCharArray();
			Arrays.sort(qch);
			String key = new String(qch);
			ArrayList<String> value = map.get(key);

			// �ҵ��Լ�������
			int id = 0;
			for (int i = 0; i < value.size(); i++) {
				if (value.get(i) == query) {
					id = i;
					break;
				}
			}
			// ���Լ�ɾ��
			value.remove(id);
			int m = value.size();
			String kword = value.get(k);
			System.out.println(m);
			System.out.println(kword);

		}
		sc.close();
	}
}
