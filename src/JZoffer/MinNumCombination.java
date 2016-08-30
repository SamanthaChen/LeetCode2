package JZoffer;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumCombination {

	public static void main(String[] args) {

	}

	// 自定义一个排序规则，然后将排序后的字符串连接起来
	public String PrintMinNumber(int[] nums) {
		String[] str = new String[nums.length];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			str[i] = Integer.toString(nums[i]);
		}
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String com1 = s1 + s2;
				String com2 = s2 + s1;
				return com1.compareTo(com2);// 用字符串自带的比较器
			}
		});
		for (String s : str)
			sb.append(s);
		return sb.toString();
	}

}
