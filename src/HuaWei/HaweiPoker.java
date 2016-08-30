package HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HaweiPoker {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String order = "345678910JQKA2jokerJOKER"; 
		while(in.hasNext()){
			String res = "";
			String[] str = in.nextLine().split("-");
			String[] p0 = str[0].split(" ");
			String[] p1 = str[1].split(" ");
			//有王炸，王炸最大
			if(str[0].equals("joker JOKER") ||str[1].equals("joker JOKER")){
				res = "joker JOKER";
			}else{
				//有炸弹的话
				if(p0.length==4){
					if(p1.length==4){
						res = order.indexOf(p0[0])>order.indexOf(p1[0])? str[0]:str[1];
					}else{
						res=str[0];
					}
				}else if(p1.length==4){
					if(p0.length==4){
						res = order.indexOf(p0[0])>order.indexOf(p1[0])? str[0]:str[1];
					}else{
						res=str[1];
					}
				}else{//没有炸弹
					if(p0.length!=p1.length){
						res = "ERROR";
					}else
						res = order.indexOf(p0[0])>order.indexOf(p1[0])? str[0]:str[1];
				}
			}
			
		
			
			System.out.println(res);
		}

	}

}
