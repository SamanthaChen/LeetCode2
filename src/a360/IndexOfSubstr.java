package a360;

import java.util.Scanner;

public class IndexOfSubstr {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String NM = scanner.next();//���ĵ�����
			String s1 = scanner.next();//��һ���Ӵ�
			String s2 = scanner.next();//�ڶ����Ӵ�

			boolean foward = false;
			boolean backward = false;

			// �ж��ǲ�������
			int id1 = -1, id2 = -1;
			id1 = NM.indexOf(s1);// ��һ����������
			if (id1 != -1) {
				id2 = NM.indexOf(s2, id1 + 1);// �ڶ���������������id+1��ʼ��
				if(id2 != -1){
					foward = true;
				}
					
			}
//			if (id1 != -1 && id2 != -1) //������ǰ���ҵ�s1�ں����ҵ�s2
//				foward = true;
			// �ж��ǲ��Ƿ���
			String MN = new StringBuilder(NM).reverse().toString();// ������ַ���
			id1 = -1;
			id2 = -1;
			id1 = MN.indexOf(s1);// ��һ����
			if (id1 != -1) {
				id2 = MN.indexOf(s2, id1 + 1);// �ڶ���������id+1��ʼ��
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
