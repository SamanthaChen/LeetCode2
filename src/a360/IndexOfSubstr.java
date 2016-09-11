package a360;

import java.util.Scanner;

public class IndexOfSubstr {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String NM = scanner.next();//旗帜的序列
			String s1 = scanner.next();//第一个子串
			String s2 = scanner.next();//第二个子串

			boolean foward = false;
			boolean backward = false;

			// 判断是不是正向
			int id1 = -1, id2 = -1;
			id1 = NM.indexOf(s1);// 第一个串的索引
			if (id1 != -1) {
				id2 = NM.indexOf(s2, id1 + 1);// 第二个串的索引，从id+1开始找
				if(id2 != -1){
					foward = true;
				}
					
			}
//			if (id1 != -1 && id2 != -1) //表明在前面找到s1在后面找到s2
//				foward = true;
			// 判断是不是反向
			String MN = new StringBuilder(NM).reverse().toString();// 反向的字符串
			id1 = -1;
			id2 = -1;
			id1 = MN.indexOf(s1);// 第一个串
			if (id1 != -1) {
				id2 = MN.indexOf(s2, id1 + 1);// 第二个串，从id+1开始找
				if(id2!=-1){
					backward = true;
				}
			}

//			if (id1 != -1 && id2 != -1)
//				backward = true;

			if (foward == true && backward == true) {
				System.out.println("both");
			} else if (foward == true && backward == false) {
				System.out.println("foward");
			} else if (backward == true && foward == true) {
				System.out.println("backward");
			} else {
				System.out.println("invalid");
			}

		}
		scanner.close();

	}

}
