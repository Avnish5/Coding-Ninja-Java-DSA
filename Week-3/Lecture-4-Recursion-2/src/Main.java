import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
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

            for(int j=0;j<smallAns[i].length;j++)
            {
                subset[l]=smallAns[i][j];
                l++;
            }
            subset[l]=input[s];
            ans[k]=subset;
            k++;
        }


        return ans;

    }
    public static int[][] subsets(int input[]) {
        return subsets(input,0,input.length-1);

    }
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int[][] allSubsets = subsets(input);

        // Print all subsets
        for (int[] subset : allSubsets) {
            System.out.print("[");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
    }
}