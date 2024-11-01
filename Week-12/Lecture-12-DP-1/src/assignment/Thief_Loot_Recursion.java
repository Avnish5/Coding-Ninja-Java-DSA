package assignment;
/*
Problem statement
A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.
 */

public class Thief_Loot_Recursion {
    public static int maxMoneyLooted(int[] arr) {

        return helper(0,arr);
    }

    public static int helper(int i,int[] arr){
        if(i<0 || i>=arr.length) return 0;

        int a=arr[i]+helper(i+2,arr);
        int b=helper(i+1,arr);

        return Math.max(a,b);
    }

    public static void main(String[] args) {
        int[] arr={10,2,30,20,3,50};
        System.out.println(maxMoneyLooted(arr));
    }
}
