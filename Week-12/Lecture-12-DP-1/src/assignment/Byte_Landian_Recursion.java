package assignment;
/*
Problem statement
Byteland has a very strange monetary system.

Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).

You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

You have one gold coin. What is the maximum amount of American dollars you can get for it?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10 ^ 9

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
13
Explanation of Sample Output 1 :
 You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
Sample Input 2 :
2
Sample Output 1 :
2
Explanation of Sample Output 2 :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more than $1 out of them. It is better just to change the 2 coin directly into $2.
 */
public class Byte_Landian_Recursion {

    public static long bytelandian(long n) {
        if( n==0) return n;
        long a=bytelandian(n/2);
        long b=bytelandian(n/3);
        long c=bytelandian(n/4);
        long total=a+b+c;
        return Math.max(total,n);
    }
}
