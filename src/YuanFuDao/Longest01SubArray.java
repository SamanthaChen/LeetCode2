package YuanFuDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem
 * 
 * 如果一个串只由1和0组成，并且其中1和0的个数相等，我们称之为偶子串。给出一个只由1和0组成的串，求这个串中的子串中，最长的偶子串。
 * 
 * Input
 * 
 * 第一行是N，测试用例的总数，接下来是N行1和0组成的串
 * 
 * Output
 * 
 * N行结果，最长偶子串可能有多
 * 
 * Sample Input
 * 
 * 5 100111011001 10001111 10010111 100111010011 0111101010101110
 * 
 * Output
 * 
 * Case #1: 10 Case #2: 6 Case #3: 6 Case #4: 10 Case #5: 8
 */
public class Longest01SubArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			solution(s);
		}
		scanner.close();

	}

	// 思路：设dp[i]是0~i的前缀和，求dp[i]==dp[j]并且|i-j|最大的值
	// 用map存这个<dp[i],i>
	static void solution(String s) {
		// key是前缀和，value是最小的索引
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);// 为了统一
		int maxlen = 0;
		int presum = 0;
		for (int i = 0; i < s.length(); i++) {
			presum += s.charAt(i) - '0' == 0 ? -1 : 1;
			if (map.containsKey(presum)) {
				int startid = map.get(presum);
				if (i - startid > maxlen) {
					maxlen = i - startid;
				}
			} else {
				map.put(presum, i);// 第一次出现该前缀和的位置
			}
		}
		System.out.println(maxlen);
	}

}
