package HuaWei;

import java.util.Scanner;

public class ChangeBottle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	
		while(in.hasNext()){
			int n=in.nextInt();
			if(n==0) break;
			//�����ܻ���ƿ����
			int res = 0;
			if(n<2){ 
				res = 0;
			}else if(n==2){
				res = 1;
			}else{
				while(n>=2){
					if(n==2){//�����ܻ�һƿ
						res += 1;
						break;
					}else{ 
						res += n/3;
						n = n%3 + n/3;
					}
				}
			}
			System.out.println(res);
		}

	}

}
