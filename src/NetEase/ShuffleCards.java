package NetEase;
/**
 * ϴ����������ʮ�ֳ�����������Ҫдһ������ģ��ϴ�ƵĹ��̡� ������Ҫϴ2n���ƣ����ϵ��������ǵ�1�ţ���2�ţ���3��һֱ����2n�š����ȣ����ǰ���2n���Ʒֳ����ѣ��������ŵ�1�ŵ���n�ţ��ϰ�ѣ����������ŵ�n+1�ŵ���2n�ţ��°�ѣ������žͿ�ʼϴ�ƵĹ��̣��ȷ������ֵ����һ���ƣ��ٷ������ֵ����һ���ƣ����ŷ������ֵĵ����ڶ����ƣ��ٷ������ֵĵ����ڶ����ƣ�ֱ�����������ֵĵ�һ���ơ����Ű��ƺϲ������Ϳ����ˡ� ������6���ƣ��ʼ�Ƶ�������1,2,3,4,5,6�����ȷֳ����飬��������1,2,3����������4,5,6����ϴ�ƹ����а�˳�������6,3,5,2,4,1�������������ٴκϳ�һ����֮�����ǰ��մ������µ�˳�������ƣ��ͱ��������1,4,2,5,3,6�� ���ڸ���һ��ԭʼ���飬������⸱��ϴ��k��֮��������µ����С� 
��������:
��һ��һ����T(T �� 100)����ʾ��������������ÿ�����ݣ���һ��������n,k(1 �� n,k �� 100)��������һ����2n����a1,a2,...,a2n(1 �� ai �� 1000000000)����ʾԭʼ������ϵ��µ����С�

�������:
����ÿ�����ݣ����һ�У����յ����С�����֮���ÿո��������Ҫ����ĩ�������Ŀո�

��������:
3
3 1
1 2 3 4 5 6
3 2
1 2 3 4 5 6
2 2
1 1 1 1

�������:
1 4 2 5 3 6
1 5 4 3 2 6
1 1 1 1
 * 
 * */
import java.util.Scanner;


public class ShuffleCards {

	public static void main(String[] args) {
		ShuffleCards m = new ShuffleCards();
		
		Scanner cin = new Scanner(System.in);
		int T =cin.nextInt();
		int n=0;
		int k=0;
//		String[] res = new String[T];
	
		for(int i=0;i<T;i++){
		
			n = cin.nextInt();
			k = cin.nextInt();

			int[] nums = new int[2*n];
			for(int j=0;j<2*n;j++){
				nums[j]=cin.nextInt();
			}
			nums = m.solution(n,k,nums);
			//��ӡ���
			for(int j=0;j<2*n-1;j++){
				System.out.print(nums[j]+ " ");
			}
			System.out.println(nums[2*n-1]);
			
			
		}
//		
//		for(String s: res)
//			System.out.println(s);
//		
		
		cin.close();

	}
	public int[] solution(int n,int k, int[] nums){
		int[] temp = new int[2*n];
		for(int i=0;i<k;i++){
			for(int j1=2*n-1,j2=n-1, p=2*n-1;j1>=n;){
				temp[p--]=nums[j1--];
				temp[p--]=nums[j2--];
			}
			for(int j=0;j<2*n;j++){
				nums[j]=temp[j];
			}
		}
		return nums;
		
	}
}
