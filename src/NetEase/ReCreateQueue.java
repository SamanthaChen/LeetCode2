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
			//��һ�ֽⷨ
//			int[] res = m.solution(n);
//			for(int j=0;j<n-1;j++){
//				System.out.print(res[j]+ " ");
//			}
//			System.out.println(res[n-1]);
			
			//�ڶ��ֽⷨ
			m.solution2(n);
		}
	}
	/**
	 * ��һ�飺ԭ�����1��3,������λ�÷��õĿ϶���1��2������ÿ��һ��λ�÷�һ������ 
�ڶ��飺ȥ����һ�η����1��2������֮��ÿ��һ��λ�ý��ŷ���һ������ 
��N�飺һֱ�ظ������������顣
	 * */
	public int[] solution(int n){
		
		int[] res = new int[n];
		if(n==1){
			res[0]=1;
			return res;
		}
		int id = 0;
		for(int i=1;i<=n;i++){
			//�ҵ�һ����λ��
			while(res[id%n]!=0) id++;
			id++;
			//�ҵڶ�����λ��
			while(res[id%n]!=0) id++;
			res[id%n]=i;
			
		}
		return res;
	}
	/**
	 * ����
213 -> 132 -> (1) -> 32 ͷ�ŵ�β�ͣ��׳�ͷ
32 -> 23 -> (2) -> 3
3 -> 3 -> (3)
 
3 -> 3
23 -> 32 ͷ���룬β��ͷ
132 -> 213
	 * */
	//�Ź���80%��
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
