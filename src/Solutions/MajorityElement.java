package Solutions;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int c = 0;
        int times = 0;
        for(int n : nums){
            if(times==0){
                c = n;
                times = 1;
            }else{
                if(c==n) times++;
                else times--;
            }
        }
        return c;
    }
}
