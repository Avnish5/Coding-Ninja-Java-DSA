package lecture_4_recursion_2;

public class Binary_Search {
    public static int searchHelper(int []nums, int t,int l,int r)
    {
        if(l>r) return -1;
        int mid=(l+r)/2;
        if(nums[mid]==t) return mid;

        if(t>nums[mid])
        {
            return searchHelper(nums,t,mid+1,r);
        }
        else{
            return   searchHelper(nums,t,l,mid-1);
        }
    }
    public static int search(int []nums, int target) {
        return searchHelper(nums, target,0,nums.length-1);
    }
}
