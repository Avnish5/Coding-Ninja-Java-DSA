package assignment;
/*
Problem statement
Given an integer array (of length n), find and return all the subsets of input array.

NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12
20
20 12
15
15 12
15 20
15 20 12
 */
public class Return_Subset_Array {
    public static int[][] subsets(int input[],int s,int e)
    {
        if(s>e)
        {
            int[][] output={{}};
            return output;
        }

        int[][] smallAns=subsets(input,s+1,e);
        int[][] ans=new int[2*smallAns.length][];

        int k=0;

        for (int[] smallAn : smallAns) {
            ans[k] = smallAn;
            k++;
        }
        for(int i=0;i< smallAns.length;i++)
        {
            int[] subset=new int[smallAns[i].length+1];
            int l=0;
            subset[l]=input[s];
            l++;

            for(int j=0;j<smallAns[i].length;j++)
            {
                subset[l]=smallAns[i][j];
                l++;
            }

            ans[k]=subset;
            k++;
        }


        return ans;

    }
    public static int[][] subsets(int input[]) {
        return subsets(input,0,input.length-1);

    }
}
