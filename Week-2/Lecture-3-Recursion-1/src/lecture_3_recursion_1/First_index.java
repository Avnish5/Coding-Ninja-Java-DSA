package lecture_3_recursion_1;
/*
Problem statement
Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.

First index means, the index of first occurrence of x in the input array.

Do this recursively. Indexing in the array starts from 0.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
1
 */
public class First_index {

    public int helper(int input[], int x,int si)
    {
        if(si==input.length) return -1;
        if(input[si]==x) return si;

        return helper(input,x,si+1);
    }
    public  int firstIndex(int input[], int x) {

        return helper(input,x,0);

    }
}
