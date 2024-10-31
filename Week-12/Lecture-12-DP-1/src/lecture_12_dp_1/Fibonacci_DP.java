package lecture_12_dp_1;

public class Fibonacci_DP {

    public static int fibDp(int n)
    {
        int[] storage=new int[n+1];
        storage[0]=0;
        storage[1]=1;

        for(int i=2;i<=n;i++)
        {
            storage[i]=storage[i-1]+storage[i-2];
        }

        return storage[n];
    }

}
