package lecture_12_dp_1;

public class Fibbonaci_Series {

    public static int fib(int n)
    {
        int[] storage=new int[n+1];

        for(int i=0;i<=n;i++)
        {
            storage[i]=-1;
        }
        return fib(n,storage);
    }

    public static int fib(int n,int[] storage)
    {
        if(n==0 || n==1)
        {
            storage[n]=n;
            return storage[n];
        }

        if(storage[n]!=-1)
        {
            return storage[n];
        }

        storage[n]=fib(n-1,storage)+fib(n-2,storage);
        return storage[n];
    }

}
