package lecture_13_dp_2;

public class Minimum_Cost_Path_DP {

    public static int minCostPath(int[][] input) {
        int M=input.length;
        int N=input[0].length;

        int[][] dp=new int[M][N];

        dp[0][0]=input[0][0];

        for(int j=1;j<N;j++)
        {
            dp[0][j]=dp[0][j-1]+input[0][j];
        }

        for(int i=1;i<M;i++)
        {
            dp[i][0]=dp[i-1][0]+input[i][0];
        }

        for(int i=1;i<M;i++)
        {
            for(int j=1;j<N;j++)
            {
                int above=dp[i-1][j];
                int left=dp[i][j-1];
                int diagonal=dp[i-1][j-1];

                dp[i][j]=input[i][j]+Math.min(above,Math.min(left,diagonal));
            }
        }

        return dp[M-1][N-1];
    }
}
