package HuaWei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteDuplicateChar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			char[] s = in.next().toCharArray();
			Set<Character> set = new LinkedHashSet<Character>();
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<s.length;i++){
                if(set.add(s[i]))
                    sb.append(s[i]);
            }
			System.out.println(sb.toString());//!!!!!!!一定要记得回车啊靠
		}

	}
}
