package NetEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReCreateQueue {

	
	public static void main(String[] args){
		ReCreateQueue m = new ReCreateQueue();
		Scanner cin = new Scanner(System.in);
		int T = cin.nextInt();
		int n = 0;
		for(int i=0;i<T;i++){
			n = cin.nextInt();
			//第一种解法
//			int[] res = m.solution(n);
//			for(int j=0;j<n-1;j++){
//				System.out.print(res[j]+ " ");
//			}
//			System.out.println(res[n-1]);
			
			//第二种解法
			m.solution2(n);
		}
	}
	/**
	 * 第一遍：原数组的1，3,…，等位置放置的肯定是1，2，…，每隔一个位置放一个数； 
第二遍：去掉第一次放入的1，2，…，之后，每隔一个位置接着放入一个数； 
第N遍：一直重复填满整个数组。
	 * */
	public int[] solution(int n){
		
		int[] res = new int[n];
		if(n==1){
			res[0]=1;
			return res;
		}
		int id = 0;
		for(int i=1;i<=n;i++){
			//找第一个空位置
			while(res[id%n]!=0) id++;
			id++;
			//找第二个空位置
			while(res[id%n]!=0) id++;
			res[id%n]=i;
			
		}
		return res;
	}
	/**
	 * 解析
213 -> 132 -> (1) -> 32 头放到尾巴，抛出头
32 -> 23 -> (2) -> 3
3 -> 3 -> (3)
 
3 -> 3
23 -> 32 头插入，尾放头
132 -> 213
	 * */
	//才过了80%？
	public void solution2(int n){
		List<Integer> list = new ArrayList<Integer>();
		if(n==1){
			System.out.println(n);
		}
		for(int i=n;i>=1;i--){
			list.add(0,i);
			int temp = list.get(list.size()-1);
			list.remove(list.size()-1);
			list.add(0,temp);
		}
		for(int i=0;i<n-1;i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println(list.get(n-1));
	}
}
