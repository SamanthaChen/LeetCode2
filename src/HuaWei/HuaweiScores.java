package HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 注意几个点：
 * 1.不止一个N M输入值
 * 2. A和B的大小不确定
 * */

public class HuaweiScores {
	 public static void main(String args[]) {
		 HuaweiScores m = new  HuaweiScores();
		 Scanner sc = new Scanner(System.in);
		 while(sc.hasNext()){
			 int N = sc.nextInt();
			 int M = sc.nextInt();
			 int[] scores = new int[N];
			 for(int i=0;i<N;i++){
				  scores[i]=sc.nextInt();
			 }
			 for(int j=0;j<M;j++){
				 String c = sc.next();
				 int A = sc.nextInt();
				 int B = sc.nextInt();
				 if(c.equals("Q")){
					 System.out.println(m.getMax(scores,A,B));
				 }
				 if(c.equals("U")){
					 scores[A-1]=B;
				 } 
			 }
		 }

		sc.close();
	 }
	 public int getMax(int[] a, int A, int B){
		 int max = Integer.MIN_VALUE;
		 
		 for(int i=Math.min(A, B)-1;i<Math.max(A, B);i++){
			 if(a[i]>max) max=a[i];
		 }
		 return max;
	 }
}
