package assignment;
/*
Problem statement
Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50

Time Limit: 1 sec
Sample Input 1 :
4 2 3
Sample Output 1 :
Whis
Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus
Explanation to Sample Input 1:
Initially, there are 4 coins,  In the first move, Beerus can remove either 1, 2, or 3 coins in all three cases, Whis can win by removing all the remaining coins.
 */
public class Coin_Tower_DP {

    public static String findWinner(int n, int x, int y) {

        boolean[] dp=new boolean[n+1];
        dp[0]=false;
        dp[1]=true;

        for(int i=2;i<=n;i++)
        {
            if(i-1>=0&& !dp[i - 1]){
                dp[i]=true;
            }
            else if(i-x>=0&& !dp[i - x]){
                dp[i]=true;
            }
            else if(i-y>=0&&!dp[i-y]){
                dp[i]=true;
            }
            else
            {
                dp[i]=false;
            }
        }

        for(boolean a:dp)
        {
            System.out.print(a+" ");
        }
        return dp[n] ? "Beerus" : "Whis";

    }

    public static void main(String[] args) {
        findWinner(4,2,3);
    }
}
