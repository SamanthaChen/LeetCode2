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
			//ɾ������
			int id = 0;
			for(int i=0;i<n-1;i++){
				//�ҵ�һ��ûɾ����
				while(nums[id%n]==-1) id++;
				id++;
				//�ҵڶ���ûɾ����
				while(nums[id%n]==-1) id++;
				id++;
				while(nums[id%n]==-1) id++;
				//ɾ��
				nums[id%n]=-1;
			}
			//�����һ��û��ɾ����
			while(nums[id%n]==-1) id++;
			System.out.println(nums[id%n]);
		}
	}
}
