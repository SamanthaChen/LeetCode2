package SF;

/**
 * POJ 1011的一道题(木棍组合)  另一题是PAT 1003(Emergency)
【题意】：乔治拿来一组等长的木棒，将它们随机地砍断，使得每一节木棍的长度都不超过50个长度单位。
然后他又想把这些木棍恢复到为裁截前的状态，但忘记了初始时有多少木棒以及木棒的初始长度。
请你设计一个程序，帮助乔治计算木棒的可能最小长度。每一节木棍的长度都用大于零的整数表示。

【题解】：对于剪枝能力要求很高。下面说下几个重要的剪枝：
1.把所有木棍的长度从大到小排列，组合木棒时优先使用长的木棍，这样可以加快组合速度，并且对后面的剪枝有帮助。
2.木棒的长度一定是大于等于最长木棍的长度并且小于等于所有木棍长度的和，这个很容易证明。
3.木棒的长度一定是所有木棍长度的和的约数，这个也很容易证明。
4.在某一个木棒的组合过程中，对于当前的木棍stick[i]，如果stick[i-1]没有被组合并且stick[i] == stick[i-1]，那么不用考虑stick[i]，显然stick[i]最终也不会被组合。
5.如果此次是在尝试第i个木棒的第一段，假设stick[j]为当前可以被使用的最长的木棍，如果此次组合失败，直接退出搜索，即退回到对第i-1个木棒的搜索。试想：失败说明现在使用stick[j]是不可行的，那么以后无论什么时候使用stick[j]都是不可行的，因为以后再处理stick[j]时可使用的木棍一定是当前可使用的木棍的子集，在更多木棍选择的情况下都不能组合成功，那么，在更少木棍选择的情况下一定不能组合成功。

 * 
 * 
 * */
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static boolean[] used;
	static int len;
	static int[] s;
	static int sum;
	static int max;
	static int parts;

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			len = reader.nextInt();
			s = new int[len];

			int index = 0;
			used = new boolean[len];
			sum = 0;
			while (index < len) {
				s[index] = reader.nextInt();
				sum += s[index++];
			}
			// 对木棍长度进行排序
			Arrays.sort(s);
			max = s[len - 1];

			// 木棒长度肯定是大于木棍长度的，必然从最长的开始进行合并
			for (; max <= sum; max++) {
				// 只有当木棒长度能够被sum整除时，该木棒长度才算合理
				if (sum % max == 0) {
					parts = sum / max;
					// 搜索按木棍长度，从大往小进行, 这样可以避免不变要的搜索
					Main2 main = new Main2();
					if (main.search(0, len - 1, 0)) {
						System.out.println(max);
						break;
					}
				}
			}
		}
		reader.close();
	}

	/**
	 * 尝试搜索使木棍能够凑成一个木棒
	 * 
	 * @param res
	 *            当前这在合成的木棒的已合成的长度
	 * @param next
	 *            下一个需要搜索的木棍下标
	 * @param cpl
	 *            已经合成的木棒数
	 * @return
	 */
	private boolean search(int res, int next, int cpl) {
		// res = max 说明当前已经合成一个木棒
		// cpl++ res置0
		// next置为len-2,
		// 因为此时len-1这个木棍肯定已经被用掉了，下次搜索肯定从len-2开始，其实这个并不重要，因为每次开始搜索的时候都会检查当前搜索的木棍used[next]
		if (res == max) {
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
				// 已合并+ s[next] <= max 说明当前木棍可以加入到当前正在合并的木棒中
				if (res + s[next] <= max) {
					used[next] = true;
					// 搜索成功返回
					if (search(res + s[next], next - 1, cpl)) {
						return true;
					}
					// 搜索不成功，回溯
					used[next] = false;
					// 当前正在合并的木棒长度res = 0， 且剩余木棍中并不能再合成木棒，搜索失败
					if (res == 0) {
						break;
					}
					// 可以合成一个当前的，但是剩余的不能合成一个木棒，搜索失败
					if (res + s[next] == max) {
						break;
					}
					// 其他情况仍然可以搜索
				}

				int i = next - 1;
				while (i >= 0 && s[i] == s[next]) {
					i--;
				}
				next = i;
				int l_s = 0;
				while (i >= 0) {
					if (!used[i]) {
						l_s += s[i];
					}
					i--;
				}

				if (l_s < max - res) {
					break;
				}
				continue;
			}
			next--;

		}
		return false;
	}

}
