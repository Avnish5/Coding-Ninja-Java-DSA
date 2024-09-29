package lecture_3_recursion_1;

public class Last_Index_Of_x_2 {
    public static int helper(int input[], int x,int si)
    {
        if(si==input.length) return -1;
        int ans=helper(input,x,si+1);

        if(ans==-1)
        {
            if(input[si]==x) return si;
        }

        return ans;
    }
    public static int lastIndex(int input[], int x) {

        return helper(input,x,0);
    }
}
