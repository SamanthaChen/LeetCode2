package HuaWei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ErrorCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		while (sc.hasNext()) {
			String path = sc.next();
			String line = sc.next();
			// ȥ��·��������ֻ���ļ���
			int id = path.lastIndexOf("\\");
			path = id < 0 ? path : path.substring(id + 1);
			// ��ȡ16���ַ���
			if (path.length() > 16)
				path = path.substring(path.length() - 16);
			String key = path + " " + line;
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		sc.close();

		// ���������
		int count = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			count++;
			if (count > map.size() - 8) {
				String key = entry.getKey();
				int value = entry.getValue();
				System.out.println(key + " " + value);
			}
		}
	}

}
