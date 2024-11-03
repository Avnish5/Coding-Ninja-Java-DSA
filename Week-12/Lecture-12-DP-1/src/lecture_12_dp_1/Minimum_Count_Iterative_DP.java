package lecture_12_dp_1;

public class Minimum_Count_Iterative_DP {

    public static void minCount(int n)
    {
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<=n;i++)
        {
            int count=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++)
            {
                int t=i-(j*j);

                    int ansCount=1+arr[t];
                    if(ansCount<count) count=ansCount;
                }

            arr[i]=count;
        }

        for(int num:arr){
            System.out.print(num+" ");
        }

    }

}
