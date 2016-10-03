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
			// 解答过程
			// 先排序
			Arrays.sort(nums);
			int maxnum = nums[n - 1];
			for (; maxnum <= sum; maxnum++) {
				if (sum % maxnum == 0) {// 能被总长整除的时候才合理
					parts = sum / maxnum;
					// 搜索木管，从大到小搜
					if (DFS(0, n - 1, 0)) {
						System.out.println(maxnum);
						break;
					}

				}
			}

		}
		sc.close();
	}

	// 搜索木棍

	private static boolean DFS(int res, int next, int cpl) {
		if (res == maxnum) {
			cpl++;
			res = 0;
			next = len - 2;
		}
		// 表明当前所有木棒已经合成完毕，返回
		if (cpl == parts) {
			return true;
		}

		// 当前还有木棍没有合并完，需进一步合并
		while (next >= 0) {
			// 如果当前木棍没有被使用过
			if (used[next] == false) {
				// 已合并+ s[next】 <= max 说明当前木棍可以加入到当前正在合并的木棒中
				if (res + nums[next] <= maxnum) {
					used[next] = true;
					// 搜索成功返回
					if (DFS(res + nums[next], next - 1, cpl)) {
						return true;
					}
					// 搜索不成功，回溯
					used[next] = false;
					// 当前正在合并的木棒长度res = 0， 且剩余木棍中并不能再合成木棒，搜索失败
					if (res == 0) {
						break;
					}
					// 可以合成一个当前的，但是剩余的不能合成一个木棒，搜索失败
					if (res + nums[next] == maxnum) {
						break;
					}
					// 其他情况仍然可以搜索
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
