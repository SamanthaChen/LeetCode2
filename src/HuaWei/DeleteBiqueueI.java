package HuaWei;

import java.util.Scanner;

public class DeleteBiqueueI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i=0;i<n;i++){
				nums[i]=i;
			}
			//删除数字
			int id = 0;
			for(int i=0;i<n-1;i++){
				//找第一个没删掉的
				while(nums[id%n]==-1) id++;
				id++;
				//找第二个没删掉的
				while(nums[id%n]==-1) id++;
				id++;
				while(nums[id%n]==-1) id++;
				//删除
				nums[id%n]=-1;
			}
			//找最后一个没被删除的
			while(nums[id%n]==-1) id++;
			System.out.println(nums[id%n]);
		}
	}
}
