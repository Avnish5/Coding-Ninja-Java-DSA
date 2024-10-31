package lecture_12_dp_1;

public class Min_Steps_To_One_Memoization_Recursion {

    public static int countMinStepsToOne(int n) {
       int[] arr=new int[n+1];
       for(int i=0;i<=n;i++)
       {
           arr[i]=-1;
       }


     return countMinStepsToOne(n,arr);

    }

    public static int countMinStepsToOne(int n,int[] arr){
        if(n==1)
        {
            return 0;
        }

        if(arr[n]!=-1) return arr[n];
        int a=countMinStepsToOne(n-1,arr);
        int b=(n%2==0)?countMinStepsToOne(n/2,arr):Integer.MAX_VALUE;
        int c=(n%3==0)?countMinStepsToOne(n/3,arr):Integer.MAX_VALUE;

        arr[n]=1+Math.min(a,Math.min(b,c));
        return arr[n];
    }




    public static void main(String[] args) {
        int ans=countMinStepsToOne(4);
        System.out.println(ans);
    }
}
