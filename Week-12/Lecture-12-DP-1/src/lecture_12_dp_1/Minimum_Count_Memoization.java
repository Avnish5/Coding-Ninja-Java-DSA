package lecture_12_dp_1;

import java.util.Arrays;

public class Minimum_Count_Memoization {

    public static int minCount(int n)
    {
        int[] arr=new int[n+1];
        Arrays.fill(arr,-1);
        return minCount(arr,n);
    }

    public static int minCount(int[] arr,int n){
        if(n==0) return 0;

        if(arr[n]!=-1) return arr[n];
        int count=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++)
        {
            int t=n-(i*i);
            int ansCount=1+minCount(arr,t);
            if(ansCount<count) count=ansCount;
        }

        arr[n]=count;
        return arr[n];
    }

}
