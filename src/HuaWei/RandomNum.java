package HuaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RandomNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int N = in.nextInt();
			Set<Integer> set = new HashSet<Integer>();
			for(int i=0;i<N;i++){
				set.add(in.nextInt());//ШЅжи

			}
			List<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list);
			for(int i:list)
				System.out.println(i);
		}
		
		
	}

}
