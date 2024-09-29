package lecture_3_recursion_1;
/*
Problem statement
Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.

Do this recursively.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input 1 :
3
9 8 10
8
Sample Output 1 :
true
Sample Input 2 :
3
9 8 10
2
Sample Output 2 :
false
 */
public class Check_Number_In_Array {

    public boolean helper(int input[], int x,int si)
    {
        if(si==input.length) return false;

        if(input[si]==x) return true;

        return helper(input,x,si+1);
    }
    public boolean checkNumber(int input[], int x) {

        return helper(input,x,0);
    }
}
