package lecture_3_recursion_1;
/*
Problem statement
Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in the output array (in increasing order).

Do this recursively. Indexing in the array starts from 0.

Hint:
Try making a helper function with the required arguments and call the helper function from the allIndexes function.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^3
Sample Input :
5
9 8 10 8 8
8
Sample Output :
1 3 4
 */
public class All_Indexes_Of_X {

    public  int[] helper(int input[], int x,int si)
    {
        if(input.length==si) return new int[0];

        int output[]=helper(input,x,si+1);

        if(input[si]==x)
        {
            int newOutput[]=new int[output.length+1];
            newOutput[0]=si;

            for(int i=1;i<output.length+1;i++)
            {
                newOutput[i]=output[i-1];
            }

            return newOutput;
        }

        return output;
    }

    public  int[] allIndexes(int input[], int x) {

        return helper(input,x,0);

    }
}
