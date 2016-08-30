package NetEase;

import java.util.Scanner;

public class PokerFace {
    
    //一次洗牌
    public static int[] replace(int a[], int n) {
        // int m = a.length;
        int b[] = new int[n];
        int c[] = new int[n];
        // 将数组a的前一半赋值给c
        for (int i = 0; i < n; i++) {
            c[i] = a[i];
        }
        // 将数组a的后一半赋值给b
        for (int i = 0; i < n; i++) {
            b[i] = a[i + n];
        }
        //数组c的0,1,2,3,4...对应数组a的0,2,4,6,8...,所以a的下标是c的2倍
        for (int j = 0; j < n; j++) {
            a[j * 2] = c[j];
        }
        //数组b的0,1,2,3,4...对应数组a的1,3,5,7,9...,所以a的下标是c的2倍加1
        for (int p = 0; p < n; p++) {
            int m = p * 2 + 1;
            a[p * 2 + 1] = b[p];
        }
        return a;
    }
    
    //打印结果
    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        
        //获取测试数据的组数
        int t = cin.nextInt();
        
        while (t > 0 && cin.hasNextInt()) {
            a = cin.nextInt();//当前测试数据的个数
            b = cin.nextInt();//洗牌次数
            //数组c保存数据
            int c[] = new int[a * 2];
            //讲输入数据存入数组c
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