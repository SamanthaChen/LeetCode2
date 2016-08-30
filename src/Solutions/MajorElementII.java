package Solutions;

import java.util.ArrayList;
import java.util.List;

public class MajorElementII {
	
    public static List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(nums==null || nums.length==0) return res;
    	int candidate1=0;
    	int times1=0;
    	int candidate2=0;
    	int times2=0;
    	for(int n:nums){
            //ע�������⼸��������˳�򻹲��ܸ���
    	    if(n==candidate1){
    	        times1++;
    	    }else if(n==candidate2){
    	        times2++;
    	    } else if(times1==0){
    	        candidate1=n;
    	        times1=1;
    	    }else if(times2==0){
    	        candidate2=n;
    	        times2=1;
    	    }else {
    	        times1--;
    	        times2--;
    	    }
    	}
    	//���һ���ǲ�����ĳ���n/3
    	times1=0;
    	times2=0;
    	for(int n:nums){
    	    if(n==candidate1) times1++;
    	    else if(n==candidate2) times2++;
    	}
    	if(times1>(nums.length/3)) res.add(candidate1);
    	if(times2>(nums.length/3)) res.add(candidate2);
    	return res;
    }
}
