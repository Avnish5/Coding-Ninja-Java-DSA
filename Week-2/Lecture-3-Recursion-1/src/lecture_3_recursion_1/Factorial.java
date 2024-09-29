package lecture_3_recursion_1;

public class Factorial {

    public int factorial(int n)
    {
        if(n==0) return 1;

        int smallAns=factorial(n-1);
        return n*smallAns;
    }
}
