package HuaWei;

import java.util.ArrayList;
/**
 * 题目：假设给一个容积为w的篮子和几个物品容积，要求你求出几个物品能刚好装满篮子
 * 			假设给的样例最多存在一种解，有解输出：Yes+解 无解输出：No
 * 		 
 * 例题：
 * 输入 ： 10 4 5 6 7  （第一个是篮子大小w，后面是物品）
 * 输出： Yes 4 6
 * 输入： 10 1 1 1 5 6 7 
 * 输出： Yes 1 1 1 7
 * 输入：10 4 5 7 8 
 * 输出： No	
 * 
 * */
import java.util.Scanner;

public class zhuanglanzi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			flag = false;// 每次进来重置一遍有解的标识
			String s = sc.nextLine();
			String[] sa = s.split(" ");
			int w = Integer.valueOf(sa[0]);// 篮子大小
			int[] a = new int[sa.length - 1];// 物品数组
			// 将字符串转换为数组
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.valueOf(sa[i + 1]);
			}
			// 解题过程
			solution(w, a, 0, new ArrayList<Integer>());// 如果有解就输出

			if (flag == false) {
				System.out.println("No");// 无解的情况
			}

		}
		sc.close();
	}

	private static boolean flag = false;

	private static void solution(int w, int[] a, int loc, ArrayList<Integer> arrayList) {
		// 递归结束条件
		if (w == 0) {
			System.out.print("Yes");
			for (int i : arrayList) {
				System.out.print(" " + i);
			}
			System.out.println("");
			flag = true;

		}
		for (int i = loc; i < a.length; i++) {
			arrayList.add(a[i]);
			solution(w - a[i], a, i + 1, arrayList);
			arrayList.remove(arrayList.size() - 1);
		}

	}

}
