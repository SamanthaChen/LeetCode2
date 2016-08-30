package Solutions;

public class merge2SortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k1=m-1;
        int k2=n-1;
        int i=m+n-1;
        while(k2>=0 && k1>=0){
            if(nums1[k1]>nums2[k2]){
                nums1[i--]=nums1[k1--];
            }else{
                nums1[i--]=nums2[k2--];
            }
        }
        while(k1>=0){
            nums1[i--]=nums1[k1--];
        }
        while(k2>=0){
            nums1[i--]=nums2[k2--];
        }
    }
}
