package lecture_13_dp_2;

import java.util.Arrays;

public class Minimum_Cost_Path_Memoization {

    public static int helper(int[][] input,int[][] memo,int i,int j){
        if(i==input.length-1 && j==input[0].length-1) return input[i][j];
        if(i<0 || j<0 ||  i>=input.length || j>=input[0].length) return Integer.MAX_VALUE;

        if(memo[i][j]!=-1) return memo[i][j];

        int a=helper(input,memo,i+1,j);
        int b=helper(input,memo,i,j+1);
        int c=helper(input,memo,i+1,j+1);

        int minValue=Math.min(a, Math.min(b,c));
        memo[i][j]=minValue+input[i][j];

        return memo[i][j];
    }
    public static int minCostPath(int[][] input) {
        int[][] memo=new int[input.length][];

        for(int i=0;i<input.length;i++)
        {
            memo[i]=new int[input[i].length];
            Arrays.fill(memo[i],-1);
        }

        return helper(input,memo,0,0);
    }
}
