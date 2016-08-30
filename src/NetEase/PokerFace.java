package NetEase;

import java.util.Scanner;

public class PokerFace {
    
    //һ��ϴ��
    public static int[] replace(int a[], int n) {
        // int m = a.length;
        int b[] = new int[n];
        int c[] = new int[n];
        // ������a��ǰһ�븳ֵ��c
        for (int i = 0; i < n; i++) {
            c[i] = a[i];
        }
        // ������a�ĺ�һ�븳ֵ��b
        for (int i = 0; i < n; i++) {
            b[i] = a[i + n];
        }
        //����c��0,1,2,3,4...��Ӧ����a��0,2,4,6,8...,����a���±���c��2��
        for (int j = 0; j < n; j++) {
            a[j * 2] = c[j];
        }
        //����b��0,1,2,3,4...��Ӧ����a��1,3,5,7,9...,����a���±���c��2����1
        for (int p = 0; p < n; p++) {
            int m = p * 2 + 1;
            a[p * 2 + 1] = b[p];
        }
        return a;
    }
    
    //��ӡ���
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        
        //��ȡ�������ݵ�����
        int t = cin.nextInt();
        
        while (t > 0 && cin.hasNextInt()) {
            a = cin.nextInt();//��ǰ�������ݵĸ���
            b = cin.nextInt();//ϴ�ƴ���
            //����c��������
            int c[] = new int[a * 2];
            //���������ݴ�������c
            for (int i = 0; i < a * 2 && cin.hasNextInt(); i++) {
                c[i] = cin.nextInt();
            }
            while (b > 0) {
                c = replace(c, a);
                b--;
            }
            print(c);
            t--;
        }
        
    }
}