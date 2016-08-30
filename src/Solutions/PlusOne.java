package Solutions;

public class PlusOne {
    public int[] plusOne(int[] d) {
        int carry=0;
        int sum = 0;
        for(int i=d.length-1;i>=0;i--){
            if(i==d.length-1) 
                sum = d[i]+1;
            else
                sum = d[i]+carry;
            d[i] = sum%10;
            carry = sum/10;
        }
        if(carry==1){
            int[] res = new int[d.length+1];
            res[0]=1;
            for(int i=1;i<res.length;i++) 
                res[i]=d[i-1];
            return res;
        }else
            return d;
        
    }
}
