package Mi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
	public static int getHeight(Map<Integer, ArrayList<Integer>> map, int root, int height) {
		if (map.containsKey(root)) {
			if (map.get(root).size() == 1) {
				height += 1;
				return getHeight(map, map.get(root).get(0), height);
			} else if (map.get(root).size() == 2) {
				height += 1;
				return Math.max(getHeight(map, map.get(root).get(0), height),
						getHeight(map, map.get(root).get(1), height));
			} else {
				return height;
			}
		} else {
			return height;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			for (int i = 0; i < n - 1; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				set.add(c);
				if (!map.containsKey(p)) {
					map.put(p, new ArrayList<Integer>());
				}
				map.get(p).add(c);

			}
			int root = -1;
			for (int i = 0; i < n; i++) {
				if (!set.contains(i)) {
					root = i;
					break;
				}
			}
			System.out.println(getHeight(map, root, 1));
		}
		sc.close();
	}
}
