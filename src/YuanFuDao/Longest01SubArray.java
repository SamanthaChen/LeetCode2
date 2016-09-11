package YuanFuDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem
 * 
 * ���һ����ֻ��1��0��ɣ���������1��0�ĸ�����ȣ����ǳ�֮Ϊż�Ӵ�������һ��ֻ��1��0��ɵĴ�����������е��Ӵ��У����ż�Ӵ���
 * 
 * Input
 * 
 * ��һ����N��������������������������N��1��0��ɵĴ�
 * 
 * Output
 * 
 * N�н�����ż�Ӵ������ж�
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

	// ˼·����dp[i]��0~i��ǰ׺�ͣ���dp[i]==dp[j]����|i-j|����ֵ
	// ��map�����<dp[i],i>
	static void solution(String s) {
		// key��ǰ׺�ͣ�value����С������
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);// Ϊ��ͳһ
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
				map.put(presum, i);// ��һ�γ��ָ�ǰ׺�͵�λ��
			}
		}
		System.out.println(maxlen);
	}

}
