package lecture_12_dp_1;

public class Min_Steps_To_One_DP_Iterative {

    public static int countMinStepsToOne(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=-1;
        }

        return countMinStepsToOne(n,arr);
    }

    public static int countMinStepsToOne(int n,int[] arr){
        if(n==1) return 0;
        arr[1]=0;

        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-1]+1;

            if(i%2==0)
            {
                arr[i]=Math.min(arr[i],arr[i/2]+1);
            }

            if(i%3==0)
            {
                arr[i]=Math.min(arr[i],arr[i/3]+1);
            }

        }

        return arr[n];
    }
}
