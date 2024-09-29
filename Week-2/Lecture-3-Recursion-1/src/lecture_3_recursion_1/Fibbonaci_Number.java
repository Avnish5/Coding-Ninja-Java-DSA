package lecture_3_recursion_1;

public class Fibbonaci_Number {

    public int fib(int n)
    {
        if(n==0||n==1) return n;

        return fib(n-1)+fib(n-2);
    }
}
