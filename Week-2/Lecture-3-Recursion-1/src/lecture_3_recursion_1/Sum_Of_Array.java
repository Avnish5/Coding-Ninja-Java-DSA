package lecture_3_recursion_1;
/*
Problem statement
Given an array of length N, you need to find and return the sum of all elements of the array.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 9
Sample Output 1 :
26
Sample Input 2 :
3
4 2 1
Sample Output 2 :
7
 */
public class Sum_Of_Array {

    public int helper(int input[],int si)
    {
        if(input.length==si) return 0;

        return input[si]+helper(input,si+1);
    }
    public  int sum(int input[]) {

        return helper(input,0);

    }
}
