package assignment;

import java.util.Arrays;

public class Thief_Loot_DP {

//    public static int maxMoneyLooted(int[] arr) {
//        int[] memo=new int[arr.length];
//        Arrays.fill(memo,-1);
//        int k= maxMoneyLooted(0,arr,memo);
//
//        for(int num:memo){
//            System.out.print(num+" ");
//        }
//        System.out.println();
//        return k;
//    }

//    public static int maxMoneyLooted(int i,int[] arr,int[] memo) {
//        if (i < 0 || i >= arr.length) return 0;
//
//        if (memo[i] != -1) return memo[i];
//
//        int a = arr[i] + maxMoneyLooted(i + 2, arr, memo);
//        int b = maxMoneyLooted(i + 1, arr, memo);
//
//        memo[i] = Math.max(a, b);
//        return memo[i];
//    }
    public static int maxMoneyLooted(int[] houses){

        int n=houses.length;
        if(n==0) return 0;
        if(n==1) return houses[0];

        int[] dp=new int[houses.length];
        dp[0]=houses[0];
        dp[1]=Math.max(houses[0], houses[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(houses[i]+dp[i-2], dp[i-1]);
        }

        for(int num:dp)
        {
            System.out.print(num+" ");
        }
        System.out.println();

        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        System.out.println(maxMoneyLooted(arr));
    }
}