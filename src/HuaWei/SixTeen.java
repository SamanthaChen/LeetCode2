package HuaWei;

import java.util.Scanner;

public class SixTeen {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.next();
			s = s.substring(2);
			char[] c = s.toCharArray();
			int sum=0;
			for(char a : c){
				if("ABCDEF".indexOf(a)!=-1){
					sum = sum*16 + (a-'A'+10);
				}else{
					sum = sum*16 + (a-'0');
				}
			}
			System.out.println(sum);
		}

	}

}
