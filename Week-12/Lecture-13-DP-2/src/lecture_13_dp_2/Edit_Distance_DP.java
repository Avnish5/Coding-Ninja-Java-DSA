package lecture_13_dp_2;

public class Edit_Distance_DP {

    public static int editDistance(String s1, String s2) {
        int M=s1.length();
        int N=s2.length();

        int[][] dp=new int[M+1][N+1];

        for(int i=0;i<=N;i++)
        {
            dp[0][i]=i;
        }

        for(int j=0;j<=M;j++)
        {
            dp[j][0]=j;
        }

        for(int i=1;i<=M;i++)
        {
            for(int j=1;j<=N;j++)
            {
                if(s1.charAt(M-i)==s2.charAt(N-j))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }

        return dp[M][N];
    }
}
